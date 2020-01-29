package com.Jeka8833.Launcher.GUI;

import com.Jeka8833.Launcher.Util;
import com.Jeka8833.Launcher.WebConnect;
import com.Jeka8833.Launcher.config.Config;
import mslinks.ShellLink;
import org.jetbrains.annotations.NotNull;

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
import java.util.ResourceBundle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger log = LogManager.getLogger(Main.class);
    
    public static final String VERSION = "1.0.3";

    private static final ResourceBundle bundle = ResourceBundle.getBundle("com/Jeka8833/Launcher/local/Bundle");
    private static final JLabel state = new JLabel(bundle.getString("Main.state"));
    private static final JFrame frame = new JFrame(bundle.getString("Main.title"));

    private static void init() {
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
            log.error("Fail set look and feel", e);
        }
        log.info("Create window");
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
                        state.setText(bundle.getString("Main.create.link"));
                        final Path desktop = Paths.get(System.getProperty("user.home") + "\\Desktop\\RogueGoing.lnk");
                        try {
                            if (Files.exists(desktop)) {
                                Files.delete(desktop);
                            }
                            ShellLink.createLink(configFile.toString(), desktop.toString());
                        } catch (IOException ex) {
                            log.error("Fail create link", ex);
                        }
                    }
                    reloadApp(configFile);
                } catch (IOException ex) {
                    log.error("Fail copy file", ex);
                }
            }
            if (Config.config.update && Calendar.getInstance().getTimeInMillis() > Config.config.lastUpdate + 43200000) {
                checkUpdateAndDownload();
            }
            frame.dispose();
            log.info("Run main window");
            GUI.main(null);
        } catch (URISyntaxException e) {
            log.error("Error path", e);
        }
    }

    public static void checkUpdateAndDownload() {
        log.info("Check updates");
        state.setText(bundle.getString("Main.check.update"));
        try {
            final String[] arr = WebConnect.getString(WebConnect.version).split(";");
            if (isVersion(arr[0])) {
                state.setText(bundle.getString("Main.download.update"));
                final Path update = File.createTempFile("Updater", ".jar").toPath();
                WebConnect.downloadFile(arr[1], update);
                reloadApp(update);
            }
            Config.config.lastUpdate = Calendar.getInstance().getTimeInMillis();
            Config.writeConfig();
        } catch (IOException e) {
            log.error("Fail check updates", e);
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

    private static void reloadApp(@NotNull final Path path) {
        try {
            Runtime.getRuntime().exec(new String[]{"java", "-jar", path.toString()});
            System.exit(0);
        } catch (IOException ex) {
            log.error("Fail run app", ex);
        }
    }

    private static boolean isVersion(@NotNull final String version) {
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
