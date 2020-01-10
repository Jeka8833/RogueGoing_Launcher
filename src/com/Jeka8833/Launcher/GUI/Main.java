package com.Jeka8833.Launcher.GUI;

import com.Jeka8833.Launcher.Util;
import com.Jeka8833.Launcher.WebConnect;
import com.Jeka8833.Launcher.config.Config;
import mslinks.ShellLink;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Calendar;

public class Main {

    public static final String VERSION = "1.0.3";

    private static final JLabel state = new JLabel("Init folders");
    private static final JFrame frame = new JFrame("Updater");

    public static void init() {
        final JProgressBar pb = new JProgressBar();
        final Container container = frame.getContentPane();

        pb.setIndeterminate(true);
        pb.setBounds(5, 20, 240, 15);
        state.setBounds(5, 5, 240, 15);

        container.setLayout(null);
        container.add(state);
        container.add(pb);
        container.setPreferredSize(new Dimension(250, 40));

        frame.setIconImage(new ImageIcon(Main.class.getResource("/com/Jeka8833/Launcher/Image/icon.png")).getImage());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(Main::init);

        try {
            final Path pathFile = Paths.get(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI());

            Config.readConfig();
            final Path configPath = Paths.get(Config.getGamePath());
            final Path configFile = configPath.resolve("Launcher.jar");

            if (!Files.isDirectory(pathFile) && !pathFile.getParent().equals(configPath)) {
                checkUpdateAndDownload();
                try {
                    Files.copy(pathFile, configFile, StandardCopyOption.REPLACE_EXISTING);
                    if (Util.getOS() == Util.OS.WINDOWS) {
                        state.setText("Create link");
                        final Path desktop = Paths.get(System.getProperty("user.home") + "\\Desktop\\RogueGoing.lnk");
                        try {
                            if (Files.exists(desktop)) {
                                Files.delete(desktop);
                            }
                            ShellLink.createLink(configFile.toString(), desktop.toString());
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                    reloadApp(configFile);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            if (Config.config.update && Calendar.getInstance().getTimeInMillis() > Config.config.lastUpdate + 43200000) {
                checkUpdateAndDownload();
            }
            frame.dispose();
            GUI.main(null);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static void checkUpdateAndDownload() {
        state.setText("Check updates");
        try {
            final String[] arr = WebConnect.getString(WebConnect.version).split(";");
            if (isVersion(arr[0])) {
                state.setText("Download update");
                final Path update = File.createTempFile("Updater", ".jar").toPath();
                WebConnect.downloadFile(arr[1], update);
                reloadApp(update);
            }
            Config.config.lastUpdate = Calendar.getInstance().getTimeInMillis();
            Config.writeConfig();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean checkUpdates() {
        try {
            final boolean acc = isVersion(WebConnect.getString(WebConnect.version).split(";")[0]);
            Config.config.lastUpdate = Calendar.getInstance().getTimeInMillis();
            Config.writeConfig();
            return acc;
        } catch (IOException e) {
            return false;
        }
    }

    private static void reloadApp(final Path path) {
        try {
            Runtime.getRuntime().exec(new String[]{"java", "-jar", path.toString()});
            System.exit(0);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static boolean isVersion(final String version) {
        final String[] ver1 = VERSION.split("\\.");
        final String[] ver2 = version.split("\\.");
        if (ver1.length != ver2.length) {
            return true;
        }
        for (int i = 0; i < ver1.length; i++) {
            if (Integer.parseInt(ver2[i]) > Integer.parseInt(ver1[i])) {
                return true;
            }
        }
        return false;
    }
}
