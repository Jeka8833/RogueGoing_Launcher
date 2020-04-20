package com.Jeka8833.Launcher.GUI;

import com.Jeka8833.Launcher.Util;
import com.Jeka8833.Launcher.config.Config;
import java.awt.Font;
import java.awt.font.TextAttribute;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class AboutFrame extends javax.swing.JFrame {

    private static final ResourceBundle bundle = ResourceBundle.getBundle("com/Jeka8833/Launcher/local/Bundle");

    public AboutFrame() {
        initComponents();
        setLocationRelativeTo(null);
        last_check.setText(bundle.getString("About.lastCheck") + " "
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
        Version_txt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("About");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/com/Jeka8833/Launcher/Image/icon.png")).getImage());
        setResizable(false);

        Image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Jeka8833/Launcher/Image/avatar.png"))); // NOI18N

        Name.setText(bundle.getString("About.creator") + " Jeka8833");

        auto_check.setSelected(Config.config.update);
        auto_check.setText(bundle.getString("About.auto"));
        auto_check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                auto_checkActionPerformed(evt);
            }
        });

        check_btn.setText(bundle.getString("About.check"));
        check_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_btnActionPerformed(evt);
            }
        });

        bug.setText(bundle.getString("About.bug"));
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

        Version_txt.setText(bundle.getString("About.version") + " " + Main.VERSION);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Image, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bug, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(auto_check)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(check_btn)
                        .addContainerGap())
                    .addComponent(last_check, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Version_txt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(Name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bug)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Version_txt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(last_check, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(auto_check)
                    .addComponent(check_btn))
                .addGap(10, 10, 10))
            .addComponent(Image, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bugMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bugMouseEntered
        Font font = bug.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        bug.setFont(font.deriveFont(attributes));
    }//GEN-LAST:event_bugMouseEntered

    private void bugMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bugMouseExited
        Font font = bug.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, -1);
        bug.setFont(font.deriveFont(attributes));
    }//GEN-LAST:event_bugMouseExited

    private void bugMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bugMousePressed
        final String url = "https://github.com/Jeka8833/RogueGoing_Launcher";
        try {
            switch (Util.os) {
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

    private void check_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_btnActionPerformed
        last_check.setText(bundle.getString("About.checking"));
        new Thread(() -> {
            if (Main.checkUpdates()) {
                last_check.setText(bundle.getString("About.download"));
                Main.checkUpdateAndDownload();
            } else {
                last_check.setText(bundle.getString("About.noUpdates") + " "
                        + new SimpleDateFormat("HH:mm dd-MM-yyyy").format(new Date(Config.config.lastUpdate)));
            }
        }).start();
    }//GEN-LAST:event_check_btnActionPerformed

    private void auto_checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_auto_checkActionPerformed
        Config.config.update = auto_check.isSelected();
        Config.writeConfig();
    }//GEN-LAST:event_auto_checkActionPerformed

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
    private javax.swing.JLabel last_check;
    // End of variables declaration//GEN-END:variables
}
