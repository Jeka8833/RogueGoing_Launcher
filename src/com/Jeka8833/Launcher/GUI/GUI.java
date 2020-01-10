package com.Jeka8833.Launcher.GUI;

import com.Jeka8833.Launcher.FileUpdate;
import com.Jeka8833.Launcher.JavaFilter;
import com.Jeka8833.Launcher.config.Config;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public final class GUI extends javax.swing.JFrame {
    
    public GUI() {
        initComponents();

        for(int i = 0; i < 500; i ++){
            language_pane.add(getElem());
        }
        language_pane.add(Box.createVerticalGlue());

        updatePage(0);
    }
    
    public JPanel getElem(){
        JPanel panel = new JPanel();
        panel.setSize(100, 50);
        panel.setMaximumSize(new Dimension(100, 50));
        panel.setBackground(new Color(new Random().nextInt()));
        return panel;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        toolBar = new JPanel();
        RogueGoing_btn = new JPanel();
        RogueGoung_select = new JPanel();
        RogueGoing_Text = new javax.swing.JLabel();
        Setting_btn = new JPanel();
        setting_select = new JPanel();
        setting_Text = new javax.swing.JLabel();
        Language_btn = new JPanel();
        language_select = new JPanel();
        Language_Text = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        line_logo = new JPanel();
        About_btn = new javax.swing.JLabel();
        line_logo2 = new JPanel();
        contentPane = new JPanel();
        LanguagePage = new JPanel();
        Language_text = new javax.swing.JLabel();
        language_scroll = new javax.swing.JScrollPane();
        language_pane = new JPanel();
        line_language = new JPanel();
        SettingPage = new JPanel();
        Setting_text = new javax.swing.JLabel();
        line_setting = new JPanel();
        Body = new JPanel();
        GameDirPane = new JPanel();
        GameDir_text = new javax.swing.JLabel();
        GameDir = new javax.swing.JTextField();
        GameDir_Open_btn = new JPanel();
        GameDir_Open_text = new javax.swing.JLabel();
        JavaDirPane = new JPanel();
        JavaDir_text = new javax.swing.JLabel();
        JavaDir = new javax.swing.JTextField();
        JavaDir_Open_btn = new JPanel();
        JavaDir_Open_text = new javax.swing.JLabel();
        JVMOpPane = new JPanel();
        JVMOp_text = new javax.swing.JLabel();
        JVMOp = new javax.swing.JTextField();
        BottomSettingPane = new JPanel();
        Save_btn = new JPanel();
        save_text = new javax.swing.JLabel();
        Cansel_btn = new JPanel();
        cancel_text = new javax.swing.JLabel();
        reset_btn = new javax.swing.JLabel();
        MainPage = new JPanel();
        BottomPane = new JPanel();
        Play_btn = new JPanel();
        play_text = new javax.swing.JLabel();
        userName_text = new javax.swing.JLabel();
        UserName = new javax.swing.JTextField();
        ProgressBar = new javax.swing.JProgressBar();
        Image = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("com/Jeka8833/Launcher/local/Bundle"); // NOI18N
        setTitle(bundle.getString("GUI.title")); // NOI18N
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/com/Jeka8833/Launcher/Image/icon.png")).getImage());
        setMinimumSize(new Dimension(900, 550));

        toolBar.setBackground(new Color(35, 40, 50));

        RogueGoing_btn.setBackground(new Color(35, 40, 50));
        RogueGoing_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RogueGoing_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RogueGoing_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                RogueGoing_btnMousePressed(evt);
            }
        });

        RogueGoung_select.setBackground(new Color(43, 206, 215));
        RogueGoung_select.setPreferredSize(new Dimension(4, 0));

        javax.swing.GroupLayout RogueGoung_selectLayout = new javax.swing.GroupLayout(RogueGoung_select);
        RogueGoung_select.setLayout(RogueGoung_selectLayout);
        RogueGoung_selectLayout.setHorizontalGroup(
            RogueGoung_selectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );
        RogueGoung_selectLayout.setVerticalGroup(
            RogueGoung_selectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        RogueGoing_Text.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        RogueGoing_Text.setForeground(new Color(239, 239, 239));
        RogueGoing_Text.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Jeka8833/Launcher/Image/game.png"))); // NOI18N
        RogueGoing_Text.setText(bundle.getString("GUI.RogueGoing_Text.text")); // NOI18N

        javax.swing.GroupLayout RogueGoing_btnLayout = new javax.swing.GroupLayout(RogueGoing_btn);
        RogueGoing_btn.setLayout(RogueGoing_btnLayout);
        RogueGoing_btnLayout.setHorizontalGroup(
            RogueGoing_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RogueGoing_btnLayout.createSequentialGroup()
                .addComponent(RogueGoung_select, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(RogueGoing_Text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        RogueGoing_btnLayout.setVerticalGroup(
            RogueGoing_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(RogueGoung_select, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(RogueGoing_Text, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        Setting_btn.setBackground(new Color(35, 40, 50));
        Setting_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Setting_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Setting_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Setting_btnMousePressed(evt);
            }
        });

        setting_select.setBackground(new Color(43, 206, 215));
        setting_select.setPreferredSize(new Dimension(4, 0));

        javax.swing.GroupLayout setting_selectLayout = new javax.swing.GroupLayout(setting_select);
        setting_select.setLayout(setting_selectLayout);
        setting_selectLayout.setHorizontalGroup(
            setting_selectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );
        setting_selectLayout.setVerticalGroup(
            setting_selectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setting_Text.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        setting_Text.setForeground(new Color(239, 239, 239));
        setting_Text.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Jeka8833/Launcher/Image/gear.png"))); // NOI18N
        setting_Text.setText(bundle.getString("GUI.setting_Text.text")); // NOI18N

        javax.swing.GroupLayout Setting_btnLayout = new javax.swing.GroupLayout(Setting_btn);
        Setting_btn.setLayout(Setting_btnLayout);
        Setting_btnLayout.setHorizontalGroup(
            Setting_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Setting_btnLayout.createSequentialGroup()
                .addComponent(setting_select, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(setting_Text, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Setting_btnLayout.setVerticalGroup(
            Setting_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(setting_select, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(setting_Text, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        Language_btn.setBackground(new Color(35, 40, 50));
        Language_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Language_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Language_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Language_btnMousePressed(evt);
            }
        });

        language_select.setBackground(new Color(43, 206, 215));
        language_select.setPreferredSize(new Dimension(4, 0));

        javax.swing.GroupLayout language_selectLayout = new javax.swing.GroupLayout(language_select);
        language_select.setLayout(language_selectLayout);
        language_selectLayout.setHorizontalGroup(
            language_selectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );
        language_selectLayout.setVerticalGroup(
            language_selectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        Language_Text.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Language_Text.setForeground(new Color(239, 239, 239));
        Language_Text.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Jeka8833/Launcher/Image/about.png"))); // NOI18N
        Language_Text.setText(bundle.getString("GUI.Language_Text.text")); // NOI18N

        javax.swing.GroupLayout Language_btnLayout = new javax.swing.GroupLayout(Language_btn);
        Language_btn.setLayout(Language_btnLayout);
        Language_btnLayout.setHorizontalGroup(
            Language_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Language_btnLayout.createSequentialGroup()
                .addComponent(language_select, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(Language_Text, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Language_btnLayout.setVerticalGroup(
            Language_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(language_select, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(Language_Text, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        logo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        logo.setForeground(new Color(239, 239, 239));
        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setText(bundle.getString("GUI.logo.text")); // NOI18N
        logo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        logo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        line_logo.setBackground(new Color(33, 47, 60));
        line_logo.setPreferredSize(new Dimension(165, 2));

        javax.swing.GroupLayout line_logoLayout = new javax.swing.GroupLayout(line_logo);
        line_logo.setLayout(line_logoLayout);
        line_logoLayout.setHorizontalGroup(
            line_logoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        line_logoLayout.setVerticalGroup(
            line_logoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        About_btn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        About_btn.setForeground(new Color(239, 239, 239));
        About_btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        About_btn.setText(bundle.getString("GUI.About_btn.text")); // NOI18N
        About_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                About_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                About_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                About_btnMousePressed(evt);
            }
        });

        line_logo2.setBackground(new Color(33, 47, 60));
        line_logo2.setPreferredSize(new Dimension(140, 2));

        javax.swing.GroupLayout line_logo2Layout = new javax.swing.GroupLayout(line_logo2);
        line_logo2.setLayout(line_logo2Layout);
        line_logo2Layout.setHorizontalGroup(
            line_logo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        line_logo2Layout.setVerticalGroup(
            line_logo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout toolBarLayout = new javax.swing.GroupLayout(toolBar);
        toolBar.setLayout(toolBarLayout);
        toolBarLayout.setHorizontalGroup(
            toolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(RogueGoing_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Setting_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Language_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(line_logo, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, toolBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(toolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(line_logo2, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                    .addComponent(logo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(About_btn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        toolBarLayout.setVerticalGroup(
            toolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(toolBarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(logo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(line_logo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(RogueGoing_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Setting_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Language_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(line_logo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(About_btn)
                .addContainerGap())
        );

        contentPane.setBackground(new Color(102, 102, 102));
        contentPane.setPreferredSize(new Dimension(834, 500));
        contentPane.setLayout(new javax.swing.OverlayLayout(contentPane));

        LanguagePage.setBackground(new Color(10, 24, 37));

        Language_text.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        Language_text.setForeground(new Color(239, 239, 239));
        Language_text.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Language_text.setText(bundle.getString("GUI.Language_text.text")); // NOI18N

        language_scroll.setBorder(null);

        language_pane.setBackground(new Color(10, 24, 37));
        language_pane.setLayout(new javax.swing.BoxLayout(language_pane, javax.swing.BoxLayout.PAGE_AXIS));
        language_scroll.setViewportView(language_pane);

        line_language.setBackground(new Color(33, 47, 60));
        line_language.setPreferredSize(new Dimension(0, 4));

        javax.swing.GroupLayout line_languageLayout = new javax.swing.GroupLayout(line_language);
        line_language.setLayout(line_languageLayout);
        line_languageLayout.setHorizontalGroup(
            line_languageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        line_languageLayout.setVerticalGroup(
            line_languageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout LanguagePageLayout = new javax.swing.GroupLayout(LanguagePage);
        LanguagePage.setLayout(LanguagePageLayout);
        LanguagePageLayout.setHorizontalGroup(
            LanguagePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LanguagePageLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(LanguagePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(line_language, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
                    .addComponent(language_scroll)
                    .addComponent(Language_text, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        LanguagePageLayout.setVerticalGroup(
            LanguagePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LanguagePageLayout.createSequentialGroup()
                .addComponent(Language_text)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(line_language, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(language_scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        contentPane.add(LanguagePage);

        SettingPage.setBackground(new Color(10, 24, 37));

        Setting_text.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        Setting_text.setForeground(new Color(239, 239, 239));
        Setting_text.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Setting_text.setText(bundle.getString("GUI.Setting_text.text")); // NOI18N

        line_setting.setBackground(new Color(33, 47, 60));
        line_setting.setPreferredSize(new Dimension(165, 2));

        javax.swing.GroupLayout line_settingLayout = new javax.swing.GroupLayout(line_setting);
        line_setting.setLayout(line_settingLayout);
        line_settingLayout.setHorizontalGroup(
            line_settingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        line_settingLayout.setVerticalGroup(
            line_settingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );

        Body.setBackground(new Color(10, 24, 37));
        Body.setLayout(new java.awt.GridBagLayout());

        GameDirPane.setBackground(new Color(10, 24, 37));
        GameDirPane.setPreferredSize(new Dimension(350, 25));

        GameDir_text.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        GameDir_text.setForeground(new Color(239, 239, 239));
        GameDir_text.setText(bundle.getString("GUI.GameDir_text.text")); // NOI18N

        GameDir_Open_btn.setBackground(new Color(43, 206, 215));
        GameDir_Open_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                GameDir_Open_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                GameDir_Open_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                GameDir_Open_btnMousePressed(evt);
            }
        });

        GameDir_Open_text.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        GameDir_Open_text.setForeground(new Color(239, 239, 239));
        GameDir_Open_text.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GameDir_Open_text.setText(bundle.getString("GUI.GameDir_Open_text.text")); // NOI18N

        javax.swing.GroupLayout GameDir_Open_btnLayout = new javax.swing.GroupLayout(GameDir_Open_btn);
        GameDir_Open_btn.setLayout(GameDir_Open_btnLayout);
        GameDir_Open_btnLayout.setHorizontalGroup(
            GameDir_Open_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GameDir_Open_btnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(GameDir_Open_text, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        GameDir_Open_btnLayout.setVerticalGroup(
            GameDir_Open_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(GameDir_Open_text, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout GameDirPaneLayout = new javax.swing.GroupLayout(GameDirPane);
        GameDirPane.setLayout(GameDirPaneLayout);
        GameDirPaneLayout.setHorizontalGroup(
            GameDirPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GameDirPaneLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(GameDir_text)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(GameDir, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GameDir_Open_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        GameDirPaneLayout.setVerticalGroup(
            GameDirPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GameDirPaneLayout.createSequentialGroup()
                .addGroup(GameDirPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(GameDir_text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(GameDir_Open_btn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GameDir))
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        Body.add(GameDirPane, gridBagConstraints);

        JavaDirPane.setBackground(new Color(10, 24, 37));
        JavaDirPane.setPreferredSize(new Dimension(350, 25));

        JavaDir_text.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        JavaDir_text.setForeground(new Color(239, 239, 239));
        JavaDir_text.setText(bundle.getString("GUI.JavaDir_text.text")); // NOI18N

        JavaDir_Open_btn.setBackground(new Color(43, 206, 215));
        JavaDir_Open_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JavaDir_Open_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JavaDir_Open_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JavaDir_Open_btnMousePressed(evt);
            }
        });

        JavaDir_Open_text.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JavaDir_Open_text.setForeground(new Color(239, 239, 239));
        JavaDir_Open_text.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JavaDir_Open_text.setText(bundle.getString("GUI.JavaDir_Open_text.text")); // NOI18N

        javax.swing.GroupLayout JavaDir_Open_btnLayout = new javax.swing.GroupLayout(JavaDir_Open_btn);
        JavaDir_Open_btn.setLayout(JavaDir_Open_btnLayout);
        JavaDir_Open_btnLayout.setHorizontalGroup(
            JavaDir_Open_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JavaDir_Open_btnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JavaDir_Open_text, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JavaDir_Open_btnLayout.setVerticalGroup(
            JavaDir_Open_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JavaDir_Open_text, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout JavaDirPaneLayout = new javax.swing.GroupLayout(JavaDirPane);
        JavaDirPane.setLayout(JavaDirPaneLayout);
        JavaDirPaneLayout.setHorizontalGroup(
            JavaDirPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JavaDirPaneLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(JavaDir_text)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(JavaDir, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JavaDir_Open_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        JavaDirPaneLayout.setVerticalGroup(
            JavaDirPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JavaDirPaneLayout.createSequentialGroup()
                .addGroup(JavaDirPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JavaDir_text)
                    .addComponent(JavaDir_Open_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JavaDir, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        Body.add(JavaDirPane, gridBagConstraints);

        JVMOpPane.setBackground(new Color(10, 24, 37));
        JVMOpPane.setPreferredSize(new Dimension(350, 25));

        JVMOp_text.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        JVMOp_text.setForeground(new Color(239, 239, 239));
        JVMOp_text.setText(bundle.getString("GUI.JVMOp_text.text")); // NOI18N

        javax.swing.GroupLayout JVMOpPaneLayout = new javax.swing.GroupLayout(JVMOpPane);
        JVMOpPane.setLayout(JVMOpPaneLayout);
        JVMOpPaneLayout.setHorizontalGroup(
            JVMOpPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JVMOpPaneLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(JVMOp_text)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JVMOp, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );
        JVMOpPaneLayout.setVerticalGroup(
            JVMOpPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JVMOpPaneLayout.createSequentialGroup()
                .addGroup(JVMOpPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JVMOpPaneLayout.createSequentialGroup()
                        .addComponent(JVMOp_text)
                        .addGap(0, 4, Short.MAX_VALUE))
                    .addComponent(JVMOp))
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        Body.add(JVMOpPane, gridBagConstraints);

        BottomSettingPane.setBackground(new Color(57, 63, 70));
        BottomSettingPane.setPreferredSize(new Dimension(0, 35));

        Save_btn.setBackground(new Color(43, 206, 215));
        Save_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Save_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Save_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Save_btnMousePressed(evt);
            }
        });

        save_text.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        save_text.setForeground(new Color(239, 239, 239));
        save_text.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        save_text.setText(bundle.getString("GUI.save_text.text")); // NOI18N

        javax.swing.GroupLayout Save_btnLayout = new javax.swing.GroupLayout(Save_btn);
        Save_btn.setLayout(Save_btnLayout);
        Save_btnLayout.setHorizontalGroup(
            Save_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Save_btnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(save_text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Save_btnLayout.setVerticalGroup(
            Save_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(save_text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Cansel_btn.setBackground(new Color(255, 115, 121));
        Cansel_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Cansel_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Cansel_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Cansel_btnMousePressed(evt);
            }
        });

        cancel_text.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cancel_text.setForeground(new Color(239, 239, 239));
        cancel_text.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cancel_text.setText(bundle.getString("GUI.cancel_text.text")); // NOI18N

        javax.swing.GroupLayout Cansel_btnLayout = new javax.swing.GroupLayout(Cansel_btn);
        Cansel_btn.setLayout(Cansel_btnLayout);
        Cansel_btnLayout.setHorizontalGroup(
            Cansel_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Cansel_btnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cancel_text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Cansel_btnLayout.setVerticalGroup(
            Cansel_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cancel_text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        reset_btn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        reset_btn.setForeground(new Color(239, 239, 239));
        reset_btn.setText(bundle.getString("GUI.reset_btn.text")); // NOI18N
        reset_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reset_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                reset_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                reset_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                reset_btnMousePressed(evt);
            }
        });

        javax.swing.GroupLayout BottomSettingPaneLayout = new javax.swing.GroupLayout(BottomSettingPane);
        BottomSettingPane.setLayout(BottomSettingPaneLayout);
        BottomSettingPaneLayout.setHorizontalGroup(
            BottomSettingPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BottomSettingPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(reset_btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Cansel_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Save_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        BottomSettingPaneLayout.setVerticalGroup(
            BottomSettingPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Save_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Cansel_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(reset_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout SettingPageLayout = new javax.swing.GroupLayout(SettingPage);
        SettingPage.setLayout(SettingPageLayout);
        SettingPageLayout.setHorizontalGroup(
            SettingPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(line_setting, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
            .addGroup(SettingPageLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SettingPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Setting_text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Body, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(BottomSettingPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
        );
        SettingPageLayout.setVerticalGroup(
            SettingPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SettingPageLayout.createSequentialGroup()
                .addComponent(Setting_text)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(line_setting, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Body, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BottomSettingPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        contentPane.add(SettingPage);

        MainPage.setBackground(new Color(10, 24, 37));

        BottomPane.setBackground(new Color(57, 63, 70));

        Play_btn.setBackground(new Color(43, 206, 215));
        Play_btn.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 173, 181), 2));
        Play_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Play_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Play_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Play_btnMousePressed(evt);
            }
        });

        play_text.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        play_text.setForeground(new Color(239, 239, 239));
        play_text.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        play_text.setText(bundle.getString("GUI.play_text.text")); // NOI18N

        javax.swing.GroupLayout Play_btnLayout = new javax.swing.GroupLayout(Play_btn);
        Play_btn.setLayout(Play_btnLayout);
        Play_btnLayout.setHorizontalGroup(
            Play_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Play_btnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(play_text, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                .addContainerGap())
        );
        Play_btnLayout.setVerticalGroup(
            Play_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(play_text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        userName_text.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        userName_text.setForeground(new Color(239, 239, 239));
        userName_text.setText(bundle.getString("GUI.userName_text.text")); // NOI18N

        UserName.setText(bundle.getString("GUI.UserName.text")); // NOI18N

        javax.swing.GroupLayout BottomPaneLayout = new javax.swing.GroupLayout(BottomPane);
        BottomPane.setLayout(BottomPaneLayout);
        BottomPaneLayout.setHorizontalGroup(
            BottomPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BottomPaneLayout.createSequentialGroup()
                .addContainerGap(244, Short.MAX_VALUE)
                .addComponent(Play_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(userName_text)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UserName, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        BottomPaneLayout.setVerticalGroup(
            BottomPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Play_btn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BottomPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BottomPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(BottomPaneLayout.createSequentialGroup()
                        .addComponent(UserName)
                        .addGap(2, 2, 2))
                    .addComponent(userName_text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        ProgressBar.setBackground(new Color(26, 40, 53));
        ProgressBar.setValue(50);
        ProgressBar.setStringPainted(true);

        Image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Jeka8833/Launcher/Image/gory-alpy-noch-nebo-zvezdy-dolina-svet-ogon.jpg"))); // NOI18N

        javax.swing.GroupLayout MainPageLayout = new javax.swing.GroupLayout(MainPage);
        MainPage.setLayout(MainPageLayout);
        MainPageLayout.setHorizontalGroup(
            MainPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BottomPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Image, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        MainPageLayout.setVerticalGroup(
            MainPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPageLayout.createSequentialGroup()
                .addComponent(Image, javax.swing.GroupLayout.PREFERRED_SIZE, 435, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(ProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(BottomPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        contentPane.add(MainPage);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(contentPane, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(contentPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RogueGoing_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RogueGoing_btnMouseEntered
        RogueGoing_btn.setBackground(new Color(22, 137, 146));
    }//GEN-LAST:event_RogueGoing_btnMouseEntered

    private void RogueGoing_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RogueGoing_btnMouseExited
        RogueGoing_btn.setBackground(new Color(35, 40, 50));
    }//GEN-LAST:event_RogueGoing_btnMouseExited

    private void Setting_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Setting_btnMouseEntered
        Setting_btn.setBackground(new Color(22, 137, 146));
    }//GEN-LAST:event_Setting_btnMouseEntered

    private void Setting_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Setting_btnMouseExited
        Setting_btn.setBackground(new Color(35, 40, 50));
    }//GEN-LAST:event_Setting_btnMouseExited

    private void Language_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Language_btnMouseEntered
        Language_btn.setBackground(new Color(22, 137, 146));
    }//GEN-LAST:event_Language_btnMouseEntered

    private void Language_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Language_btnMouseExited
        Language_btn.setBackground(new Color(35, 40, 50));
    }//GEN-LAST:event_Language_btnMouseExited

    private void Language_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Language_btnMousePressed
        updatePage(2);
    }//GEN-LAST:event_Language_btnMousePressed

    private void Setting_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Setting_btnMousePressed
        updatePage(1);
    }//GEN-LAST:event_Setting_btnMousePressed

    private void RogueGoing_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RogueGoing_btnMousePressed
        updatePage(0);
    }//GEN-LAST:event_RogueGoing_btnMousePressed

    private void About_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_About_btnMouseEntered
        About_btn.setForeground(new Color(43, 206, 215));
    }//GEN-LAST:event_About_btnMouseEntered

    private void About_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_About_btnMouseExited
        About_btn.setForeground(new Color(239, 239, 239));
    }//GEN-LAST:event_About_btnMouseExited

    private void About_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_About_btnMousePressed
        AboutFrame.main(null);
    }//GEN-LAST:event_About_btnMousePressed

    private void reset_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reset_btnMousePressed
        System.out.println("reset_btn");
    }//GEN-LAST:event_reset_btnMousePressed

    private void reset_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reset_btnMouseExited
        reset_btn.setForeground(new Color(239, 239, 239));
    }//GEN-LAST:event_reset_btnMouseExited

    private void reset_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reset_btnMouseEntered
        reset_btn.setForeground(new Color(43, 206, 215));
    }//GEN-LAST:event_reset_btnMouseEntered

    private void Cansel_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Cansel_btnMousePressed
        System.out.println("Cansel_btn");
    }//GEN-LAST:event_Cansel_btnMousePressed

    private void Cansel_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Cansel_btnMouseExited
        Cansel_btn.setBackground(new Color(255, 115, 121));
    }//GEN-LAST:event_Cansel_btnMouseExited

    private void Cansel_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Cansel_btnMouseEntered
        Cansel_btn.setBackground(new Color(250, 69, 89));
    }//GEN-LAST:event_Cansel_btnMouseEntered

    private void Save_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Save_btnMousePressed
        System.out.println("Save_btn");
    }//GEN-LAST:event_Save_btnMousePressed

    private void Save_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Save_btnMouseExited
        Save_btn.setBackground(new Color(43, 206, 215));
    }//GEN-LAST:event_Save_btnMouseExited

    private void Save_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Save_btnMouseEntered
        Save_btn.setBackground(new Color(0, 173, 181));
    }//GEN-LAST:event_Save_btnMouseEntered

    private void JavaDir_Open_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JavaDir_Open_btnMousePressed
        final JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.addChoosableFileFilter(new JavaFilter());
        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
        JavaDir.setText(fc.getSelectedFile().toString());
    }//GEN-LAST:event_JavaDir_Open_btnMousePressed

    private void JavaDir_Open_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JavaDir_Open_btnMouseExited
        JavaDir_Open_btn.setBackground(new Color(43, 206, 215));
    }//GEN-LAST:event_JavaDir_Open_btnMouseExited

    private void JavaDir_Open_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JavaDir_Open_btnMouseEntered
        JavaDir_Open_btn.setBackground(new Color(0, 173, 181));
    }//GEN-LAST:event_JavaDir_Open_btnMouseEntered

    private void GameDir_Open_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GameDir_Open_btnMousePressed
        final JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
        GameDir.setText(fc.getSelectedFile().toString());
    }//GEN-LAST:event_GameDir_Open_btnMousePressed

    private void GameDir_Open_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GameDir_Open_btnMouseExited
        GameDir_Open_btn.setBackground(new Color(43, 206, 215));
    }//GEN-LAST:event_GameDir_Open_btnMouseExited

    private void GameDir_Open_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GameDir_Open_btnMouseEntered
        GameDir_Open_btn.setBackground(new Color(0, 173, 181));
    }//GEN-LAST:event_GameDir_Open_btnMouseEntered

    private void Play_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Play_btnMousePressed
        new FileUpdate(this).start();
    }//GEN-LAST:event_Play_btnMousePressed

    private void Play_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Play_btnMouseExited
        Play_btn.setBackground(new Color(43, 206, 215));
    }//GEN-LAST:event_Play_btnMouseExited

    private void Play_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Play_btnMouseEntered
        Play_btn.setBackground(new Color(0, 173, 181));
    }//GEN-LAST:event_Play_btnMouseEntered

    private void writeConfig() {
        Config.config.gamePath = GameDir.getText();
        Config.config.javaPath = JavaDir.getText();
        Config.config.userName = UserName.getText();
        Config.writeConfig();
    }

    public void readConfig() {
        Config.readConfig();
        GameDir.setText(Config.config.gamePath);
        JavaDir.setText(Config.config.javaPath);
        UserName.setText(Config.config.userName);
    }

    private void updatePage(final int page) {
        RogueGoung_select.setVisible(page == 0);
        setting_select.setVisible(page == 1);
        language_select.setVisible(page == 2);
        MainPage.setVisible(page == 0);
        SettingPage.setVisible(page == 1);
        LanguagePage.setVisible(page == 2);
    }

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new GUI().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel About_btn;
    private JPanel Body;
    private JPanel BottomPane;
    private JPanel BottomSettingPane;
    private JPanel Cansel_btn;
    private javax.swing.JTextField GameDir;
    private JPanel GameDirPane;
    private JPanel GameDir_Open_btn;
    private javax.swing.JLabel GameDir_Open_text;
    private javax.swing.JLabel GameDir_text;
    private javax.swing.JLabel Image;
    private javax.swing.JTextField JVMOp;
    private JPanel JVMOpPane;
    private javax.swing.JLabel JVMOp_text;
    private javax.swing.JTextField JavaDir;
    private JPanel JavaDirPane;
    private JPanel JavaDir_Open_btn;
    private javax.swing.JLabel JavaDir_Open_text;
    private javax.swing.JLabel JavaDir_text;
    private JPanel LanguagePage;
    private javax.swing.JLabel Language_Text;
    private JPanel Language_btn;
    private javax.swing.JLabel Language_text;
    private JPanel MainPage;
    private JPanel Play_btn;
    private javax.swing.JProgressBar ProgressBar;
    private javax.swing.JLabel RogueGoing_Text;
    private JPanel RogueGoing_btn;
    private JPanel RogueGoung_select;
    private JPanel Save_btn;
    private JPanel SettingPage;
    private JPanel Setting_btn;
    private javax.swing.JLabel Setting_text;
    private javax.swing.JTextField UserName;
    private javax.swing.JLabel cancel_text;
    private JPanel contentPane;
    private JPanel language_pane;
    private javax.swing.JScrollPane language_scroll;
    private JPanel language_select;
    private JPanel line_language;
    private JPanel line_logo;
    private JPanel line_logo2;
    private JPanel line_setting;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel play_text;
    private javax.swing.JLabel reset_btn;
    private javax.swing.JLabel save_text;
    private javax.swing.JLabel setting_Text;
    private JPanel setting_select;
    private JPanel toolBar;
    private javax.swing.JLabel userName_text;
    // End of variables declaration//GEN-END:variables
}
