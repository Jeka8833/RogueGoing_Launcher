package com.Jeka8833.Launcher.GUI;

import com.Jeka8833.Launcher.Util;
import com.Jeka8833.Launcher.config.Config;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class AboutFrame extends javax.swing.JFrame {

    public AboutFrame() {
        initComponents();
        setLocationRelativeTo(null);
        last_check.setText("Last check update is "
                        + new SimpleDateFormat("HH:mm dd-MM-yyyy").format(new Date(Config.config.lastUpdate)));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Image = new javax.swing.JLabel();
        Name = new javax.swing.JLabel();
        auto_check = new javax.swing.JCheckBox();
        check_btn = new javax.swing.JButton();
        bug = new javax.swing.JLabel();
        last_check = new javax.swing.JLabel();
        exit_btn = new javax.swing.JLabel();
        Version_txt = new javax.swing.JLabel();
        version = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("com/Jeka8833/Launcher/local/Bundle"); // NOI18N
        setTitle(bundle.getString("AboutFrame.title")); // NOI18N
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/com/Jeka8833/Launcher/Image/icon.png")).getImage());
        setMinimumSize(new java.awt.Dimension(352, 119));
        setUndecorated(true);
        setResizable(false);

        Image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Jeka8833/Launcher/Image/avatar.png"))); // NOI18N

        Name.setText(bundle.getString("AboutFrame.Name.text")); // NOI18N

        auto_check.setSelected(true);
        auto_check.setText(bundle.getString("AboutFrame.auto_check.text")); // NOI18N

        check_btn.setText(bundle.getString("AboutFrame.check_btn.text")); // NOI18N
        check_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_btnActionPerformed(evt);
            }
        });

        bug.setText(bundle.getString("AboutFrame.bug.text")); // NOI18N
        bug.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bugMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bugMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bugMousePressed(evt);
            }
        });

        last_check.setText(bundle.getString("AboutFrame.last_check.text")); // NOI18N

        exit_btn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        exit_btn.setText(bundle.getString("AboutFrame.exit_btn.text")); // NOI18N
        exit_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exit_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exit_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exit_btnMousePressed(evt);
            }
        });

        Version_txt.setText(bundle.getString("AboutFrame.Version_txt.text")); // NOI18N

        version.setText(Main.VERSION);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Image, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(auto_check)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(check_btn)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(last_check, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Name)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(bug, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exit_btn)
                        .addGap(8, 8, 8))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Version_txt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(version, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exit_btn)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Name)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bug)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Version_txt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(version, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(last_check)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(auto_check)
                    .addComponent(check_btn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(Image, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bugMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bugMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_bugMouseEntered

    private void bugMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bugMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_bugMouseExited

    private void bugMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bugMousePressed
        final String url = "https://github.com/Jeka8833/RogueGoing_Launcher";
        try {
            switch (Util.getOS()) {
                case WINDOWS:
                    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
                    break;
                case LINUX:
                    final String[] browsers = {"epiphany", "firefox", "mozilla", "konqueror",
                        "netscape", "opera", "links", "lynx"};

                    final StringBuilder cmd = new StringBuilder();
                    for (int i = 0; i < browsers.length; i++) {
                        if (i == 0) {
                            cmd.append(String.format("%s \"%s\"", browsers[i], url));
                        } else {
                            cmd.append(String.format(" || %s \"%s\"", browsers[i], url));
                        }
                    }
                    Runtime.getRuntime().exec(new String[]{"sh", "-c", cmd.toString()});
                    break;
                case MAC:
                    Runtime.getRuntime().exec("open " + url);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_bugMousePressed

    private void exit_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_btnMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_exit_btnMouseExited

    private void exit_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_btnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_exit_btnMouseEntered

    private void exit_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_btnMousePressed
        dispose();
    }//GEN-LAST:event_exit_btnMousePressed

    private void check_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_btnActionPerformed
        last_check.setText("Checking...");
        new Thread(() -> {
            if (Main.checkUpdates()) {
                last_check.setText("Download and install...");
                Main.checkUpdateAndDownload();
            } else {
                last_check.setText("No updates, last check is "
                        + new SimpleDateFormat("HH:mm dd-MM-yyyy").format(new Date(Config.config.lastUpdate)));
            }
        }).start();
    }//GEN-LAST:event_check_btnActionPerformed

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(AboutFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new AboutFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Image;
    private javax.swing.JLabel Name;
    private javax.swing.JLabel Version_txt;
    private javax.swing.JCheckBox auto_check;
    private javax.swing.JLabel bug;
    private javax.swing.JButton check_btn;
    private javax.swing.JLabel exit_btn;
    private javax.swing.JLabel last_check;
    private javax.swing.JLabel version;
    // End of variables declaration//GEN-END:variables
}
