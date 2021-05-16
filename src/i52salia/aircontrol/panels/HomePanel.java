package i52salia.aircontrol.panels;

public final class HomePanel extends javax.swing.JPanel {

    public HomePanel() {
        initComponents();
        customizeComponents();
    }
    
    public void customizeComponents() {
        deviceListMainPanel.setVisible(true);
        deviceSettingsMainPanel.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        deviceListMainPanel = new javax.swing.JPanel();
        deviceListScrollPane = new javax.swing.JScrollPane();
        deviceList = new javax.swing.JPanel();
        deviceListButtonsPanel = new javax.swing.JPanel();
        addDeviceButton = new javax.swing.JButton();
        deviceSettingsMainPanel = new javax.swing.JPanel();
        deviceSettingsScrollPane = new javax.swing.JScrollPane();
        deviceSettingsList = new javax.swing.JPanel();
        powerPanel = new javax.swing.JPanel();
        onOffButton = new i52salia.aircontrol.components.onoffbutton.OnOffButton();
        currentTempPanel = new javax.swing.JPanel();
        currentTempLabel = new javax.swing.JLabel();
        setPointTempPanel = new javax.swing.JPanel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        modePanel = new javax.swing.JPanel();
        modeButtons = new i52salia.aircontrol.components.modebuttons.ModeButtons();
        fanSpeedPanel = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox();
        deviceSettingsButtonsPanel = new javax.swing.JPanel();
        moreSettingsButton = new javax.swing.JButton();

        setLayout(new javax.swing.OverlayLayout(this));

        deviceListMainPanel.setLayout(new java.awt.BorderLayout());

        deviceListScrollPane.setBorder(null);

        deviceList.setLayout(new javax.swing.BoxLayout(deviceList, javax.swing.BoxLayout.Y_AXIS));
        deviceListScrollPane.setViewportView(deviceList);

        deviceListMainPanel.add(deviceListScrollPane, java.awt.BorderLayout.CENTER);

        deviceListButtonsPanel.setLayout(new java.awt.GridBagLayout());

        addDeviceButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/i52salia/aircontrol/resources/images/add-icon.png"))); // NOI18N
        addDeviceButton.setText("Add New Device");
        deviceListButtonsPanel.add(addDeviceButton, new java.awt.GridBagConstraints());

        deviceListMainPanel.add(deviceListButtonsPanel, java.awt.BorderLayout.SOUTH);

        add(deviceListMainPanel);

        deviceSettingsMainPanel.setEnabled(false);
        deviceSettingsMainPanel.setLayout(new java.awt.BorderLayout());

        deviceSettingsScrollPane.setBorder(null);

        deviceSettingsList.setLayout(new javax.swing.BoxLayout(deviceSettingsList, javax.swing.BoxLayout.Y_AXIS));

        powerPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Power"));
        powerPanel.setMaximumSize(new java.awt.Dimension(500, 100));
        powerPanel.setLayout(new java.awt.GridBagLayout());
        powerPanel.add(onOffButton, new java.awt.GridBagConstraints());

        deviceSettingsList.add(powerPanel);

        currentTempPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Current Temperature"));
        currentTempPanel.setMaximumSize(new java.awt.Dimension(500, 100));
        currentTempPanel.setLayout(new java.awt.GridBagLayout());

        currentTempLabel.setText("jLabel2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(32, 172, 20, 172);
        currentTempPanel.add(currentTempLabel, gridBagConstraints);

        deviceSettingsList.add(currentTempPanel);

        setPointTempPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Setpoint Temperature"));
        setPointTempPanel.setMaximumSize(new java.awt.Dimension(500, 100));
        setPointTempPanel.add(jSpinner1);

        jLabel1.setText("jLabel1");
        setPointTempPanel.add(jLabel1);

        deviceSettingsList.add(setPointTempPanel);

        modePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Mode"));
        modePanel.setMaximumSize(new java.awt.Dimension(500, 100));
        modePanel.setLayout(new java.awt.GridLayout(1, 0));
        modePanel.add(modeButtons);

        deviceSettingsList.add(modePanel);

        fanSpeedPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Fan Speed"));
        fanSpeedPanel.setMaximumSize(new java.awt.Dimension(500, 100));
        fanSpeedPanel.setLayout(new java.awt.GridBagLayout());

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 174, 9, 174);
        fanSpeedPanel.add(jComboBox1, gridBagConstraints);

        deviceSettingsList.add(fanSpeedPanel);

        deviceSettingsScrollPane.setViewportView(deviceSettingsList);

        deviceSettingsMainPanel.add(deviceSettingsScrollPane, java.awt.BorderLayout.CENTER);

        deviceSettingsButtonsPanel.setLayout(new java.awt.GridBagLayout());

        moreSettingsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/i52salia/aircontrol/resources/images/settings-small-icon.png"))); // NOI18N
        moreSettingsButton.setText("More Settings");
        deviceSettingsButtonsPanel.add(moreSettingsButton, new java.awt.GridBagConstraints());

        deviceSettingsMainPanel.add(deviceSettingsButtonsPanel, java.awt.BorderLayout.SOUTH);

        add(deviceSettingsMainPanel);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addDeviceButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    public javax.swing.JLabel currentTempLabel;
    private javax.swing.JPanel currentTempPanel;
    public javax.swing.JPanel deviceList;
    private javax.swing.JPanel deviceListButtonsPanel;
    public javax.swing.JPanel deviceListMainPanel;
    private javax.swing.JScrollPane deviceListScrollPane;
    private javax.swing.JPanel deviceSettingsButtonsPanel;
    public javax.swing.JPanel deviceSettingsList;
    public javax.swing.JPanel deviceSettingsMainPanel;
    private javax.swing.JScrollPane deviceSettingsScrollPane;
    private javax.swing.JPanel fanSpeedPanel;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSpinner jSpinner1;
    private i52salia.aircontrol.components.modebuttons.ModeButtons modeButtons;
    private javax.swing.JPanel modePanel;
    private javax.swing.JButton moreSettingsButton;
    private i52salia.aircontrol.components.onoffbutton.OnOffButton onOffButton;
    private javax.swing.JPanel powerPanel;
    private javax.swing.JPanel setPointTempPanel;
    // End of variables declaration//GEN-END:variables
}
