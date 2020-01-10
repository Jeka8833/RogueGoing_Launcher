package com.Jeka8833.Launcher.GUI;

import com.Jeka8833.Launcher.Util;
import com.Jeka8833.Launcher.Util.OS;
import com.Jeka8833.Launcher.WebConnect;
import com.Jeka8833.Launcher.config.Config;
import mslinks.ShellLink;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends javax.swing.JFrame {

    public static final String VERSION = "1.0.2";

    public Main() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Updater");
        setResizable(false);

        jProgressBar1.setIndeterminate(true);

        jLabel1.setText("Check position");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        AtomicReference<Main> m = new AtomicReference<>();
        java.awt.EventQueue.invokeLater(() -> {
            m.set(new Main());
            m.get().setVisible(true);
        });
        while (m.get() == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        m.get().start();
    }

    private void start() {
        Config.readConfig();

        final Path pathFile = getRunFile();
        final Path configPath = Paths.get(Config.getGamePath());
        final Path configFile = configPath.resolve("Launcher.jar");

        assert pathFile != null;
        if (!Files.isDirectory(pathFile) && !pathFile.getParent().equals(configPath)) {
            try {
                jLabel1.setText("Set path");
                Files.copy(pathFile, configFile, StandardCopyOption.REPLACE_EXISTING);
                if (Util.getOS() == OS.WINDOWS) {
                    jLabel1.setText("Create link");
                    final Path desktop = Paths.get(System.getProperty("user.home") + "\\Desktop\\RogueGoing.lnk");
                    if (Files.exists(desktop))
                        Files.delete(desktop);
                    ShellLink.createLink(configFile.toString(), desktop.toString());
                }
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            reloadApp(configFile);
            System.exit(0);
        }
        if (Config.config.update) {
            try {
                jLabel1.setText("Check updates");
                final String[] arr = readURL().split(";");
                if (isVersion(arr[0])) {
                    jLabel1.setText("Download update");
                    startUpdate(arr[1]);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        dispose();
        GUI.main(null);
    }

    public static boolean checkUpdates() {
        try {
            return isVersion(readURL().split(";")[0]);
        } catch (IOException e) {
            return false;
        }
    }

    public static void startUpdate(final String url) {
        try {
            final Path update = File.createTempFile("Updater", ".jar").toPath();
            WebConnect.downloadFile(update, url);
            reloadApp(update);
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Path getRunFile() {
        try {
            return Paths.get(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI());
        } catch (URISyntaxException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private static void reloadApp(final Path path) {
        try {
            Runtime.getRuntime().exec(new String[]{"java", "-jar", path.toString()});
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean isVersion(final String version) {
        final String[] ver1 = VERSION.split("\\.");
        final String[] ver2 = version.split("\\.");
        if (ver1.length != ver2.length)
            return true;
        for (int i = 0; i < ver1.length; i++) {
            if (Integer.parseInt(ver2[i]) > Integer.parseInt(ver1[i]))
                return true;
        }
        return false;
    }

    private static String readURL() throws IOException {
        final URL url = new URL(WebConnect.version);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {
            String line;
            final StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
            }
            return sb.toString();
        }
    }

    // Variables declaration - do not modify
    private javax.swing.JLabel jLabel1;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration
}
