package i52salia.aircontrol.panels;

import javax.swing.DefaultComboBoxModel;

/**
 * JPanel for the Settings tab.
 *
 * (Some of the code was automatically generated by NetBeans and should not be
 * modified to avoid conflicts with the IDE).
 *
 * @author Andrés Salinas Lima (i52salia@uco.es)
 */
public final class SettingsPanel extends javax.swing.JPanel {

    /**
     * Creates and initializes the JPanel.
     */
    public SettingsPanel() {
        initComponents();
        
        // Hide subpanels
        settingsMainPanel.setVisible(true);
        deviceSettingsMainPanel.setVisible(false);
        newDeviceStep1MainPanel.setVisible(false);
        newDeviceStep2MainPanel.setVisible(false);

        // Fill timeFormatComboBox with localized strings
        timeFormatComboBox.setModel(new DefaultComboBoxModel(new String[]{
            java.util.ResourceBundle.getBundle(
            "i52salia/aircontrol/resources/languagebundles/Bundle").getString(
            "SettingsPanel.TimeFormatBox.24"),
            java.util.ResourceBundle.getBundle(
            "i52salia/aircontrol/resources/languagebundles/Bundle").getString(
            "SettingsPanel.TimeFormatBox.12")
        }));
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

        settingsMainPanel = new javax.swing.JScrollPane();
        containerPanel1 = new javax.swing.JPanel();
        settingsPanel = new javax.swing.JPanel();
        appSettingsLabel = new javax.swing.JLabel();
        LanguageLabel = new javax.swing.JLabel();
        languageComboBox = new javax.swing.JComboBox();
        tempUnitLabel = new javax.swing.JLabel();
        tempUnitComboBox = new javax.swing.JComboBox();
        timeFormatLabel = new javax.swing.JLabel();
        timeFormatComboBox = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        devicesLabel = new javax.swing.JLabel();
        devicesScrollPane = new javax.swing.JScrollPane();
        devicesList = new javax.swing.JList();
        openDeviceSettingsButton = new javax.swing.JButton();
        addDeviceButton = new javax.swing.JButton();
        deviceSettingsMainPanel = new javax.swing.JScrollPane();
        containerPanel2 = new javax.swing.JPanel();
        deviceSettingsPanel = new javax.swing.JPanel();
        deviceSettingsLabel = new javax.swing.JLabel();
        deviceNameLabel = new javax.swing.JLabel();
        deviceNameField = new javax.swing.JTextField();
        horizontalSwingLabel = new javax.swing.JLabel();
        horizontalSwingCheckBox = new javax.swing.JCheckBox();
        verticalSwingLabel = new javax.swing.JLabel();
        verticalSwingCheckBox = new javax.swing.JCheckBox();
        saveButton = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        deviceInfoLabel = new javax.swing.JLabel();
        modelNameLabel = new javax.swing.JLabel();
        modelNameField = new javax.swing.JTextField();
        modelNumberLabel = new javax.swing.JLabel();
        modelNumberField = new javax.swing.JTextField();
        serialNumberLabel = new javax.swing.JLabel();
        serialNumberField = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        dangerZoneLabel = new javax.swing.JLabel();
        deleteDeviceButton = new javax.swing.JButton();
        newDeviceStep1MainPanel = new javax.swing.JScrollPane();
        containerPanel4 = new javax.swing.JPanel();
        newDeviceStep1NetworkPanel = new javax.swing.JPanel();
        scanningNetowrkLabel = new javax.swing.JLabel();
        devicesFoundLabel = new javax.swing.JLabel();
        newDeviceStep1ListPanel = new javax.swing.JPanel();
        selectDeviceLabel = new javax.swing.JLabel();
        newProgramStep1ScrollPane = new javax.swing.JScrollPane();
        newDevicesList = new javax.swing.JList();
        newDeviceStep1ButtonsPanel = new javax.swing.JPanel();
        cancelStep1Button = new javax.swing.JButton();
        invisibleSeparator2 = new javax.swing.JSeparator();
        nextStepButton = new javax.swing.JButton();
        newDeviceStep2MainPanel = new javax.swing.JScrollPane();
        containerPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        newDeviceNameLabel = new javax.swing.JLabel();
        newDeviceNameField = new javax.swing.JTextField();
        newDeviceStep2ButtonsPanel = new javax.swing.JPanel();
        backToStep1Button = new javax.swing.JButton();
        invisibleSeparator1 = new javax.swing.JSeparator();
        saveNewDeviceButton = new javax.swing.JButton();

        setLayout(new javax.swing.OverlayLayout(this));

        settingsMainPanel.setBorder(null);

        java.awt.GridBagLayout jPanel1Layout = new java.awt.GridBagLayout();
        jPanel1Layout.columnWidths = new int[] {200, 200};
        settingsPanel.setLayout(jPanel1Layout);

        appSettingsLabel.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("i52salia/aircontrol/resources/languagebundles/Bundle"); // NOI18N
        appSettingsLabel.setText(bundle.getString("SettingsPanel.AppSettings")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        settingsPanel.add(appSettingsLabel, gridBagConstraints);

        LanguageLabel.setText(bundle.getString("SettingsPanel.Language")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        settingsPanel.add(LanguageLabel, gridBagConstraints);

        languageComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "English", "Español" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        settingsPanel.add(languageComboBox, gridBagConstraints);

        tempUnitLabel.setText(bundle.getString("SettingsPanel.TempUnit")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        settingsPanel.add(tempUnitLabel, gridBagConstraints);

        tempUnitComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Celsius (ºC)", "Fahrenheit (ºF)" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        settingsPanel.add(tempUnitComboBox, gridBagConstraints);

        timeFormatLabel.setText(bundle.getString("SettingsPanel.TimeFormat")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        settingsPanel.add(timeFormatLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        settingsPanel.add(timeFormatComboBox, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        settingsPanel.add(jSeparator1, gridBagConstraints);

        devicesLabel.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        devicesLabel.setText(bundle.getString("SettingsPanel.Devices")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        settingsPanel.add(devicesLabel, gridBagConstraints);

        devicesScrollPane.setViewportView(devicesList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 0);
        settingsPanel.add(devicesScrollPane, gridBagConstraints);

        openDeviceSettingsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/i52salia/aircontrol/resources/images/next-icon.png"))); // NOI18N
        openDeviceSettingsButton.setText(bundle.getString("SettingsPanel.OpenDeviceSettings")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        settingsPanel.add(openDeviceSettingsButton, gridBagConstraints);

        addDeviceButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/i52salia/aircontrol/resources/images/add-icon.png"))); // NOI18N
        addDeviceButton.setText(bundle.getString("SettingsPanel.AddDevice")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        settingsPanel.add(addDeviceButton, gridBagConstraints);

        containerPanel1.add(settingsPanel);

        settingsMainPanel.setViewportView(containerPanel1);

        add(settingsMainPanel);

        deviceSettingsMainPanel.setBorder(null);

        java.awt.GridBagLayout deviceSettingsPanelLayout = new java.awt.GridBagLayout();
        deviceSettingsPanelLayout.columnWidths = new int[] {200, 200};
        deviceSettingsPanel.setLayout(deviceSettingsPanelLayout);

        deviceSettingsLabel.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        deviceSettingsLabel.setText(bundle.getString("SettingsPanel.DeviceSettings")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        deviceSettingsPanel.add(deviceSettingsLabel, gridBagConstraints);

        deviceNameLabel.setText(bundle.getString("SettingsPanel.DeviceName")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        deviceSettingsPanel.add(deviceNameLabel, gridBagConstraints);

        deviceNameField.setText("deviceNameField");
        deviceNameField.setMaximumSize(new java.awt.Dimension(175, 35));
        deviceNameField.setMinimumSize(new java.awt.Dimension(175, 35));
        deviceNameField.setPreferredSize(new java.awt.Dimension(175, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        deviceSettingsPanel.add(deviceNameField, gridBagConstraints);

        horizontalSwingLabel.setText(bundle.getString("SettingsPanel.HorizontalSwing")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        deviceSettingsPanel.add(horizontalSwingLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        deviceSettingsPanel.add(horizontalSwingCheckBox, gridBagConstraints);

        verticalSwingLabel.setText(bundle.getString("SettingsPanel.VerticalSwing")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        deviceSettingsPanel.add(verticalSwingLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        deviceSettingsPanel.add(verticalSwingCheckBox, gridBagConstraints);

        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/i52salia/aircontrol/resources/images/save-icon.png"))); // NOI18N
        saveButton.setText(bundle.getString("SettingsPanel.Save")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        deviceSettingsPanel.add(saveButton, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        deviceSettingsPanel.add(jSeparator2, gridBagConstraints);

        deviceInfoLabel.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        deviceInfoLabel.setText(bundle.getString("SettingsPanel.DeviceInfo")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        deviceSettingsPanel.add(deviceInfoLabel, gridBagConstraints);

        modelNameLabel.setText(bundle.getString("SettingsPanel.ModelName")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        deviceSettingsPanel.add(modelNameLabel, gridBagConstraints);

        modelNameField.setEditable(false);
        modelNameField.setText("modelNameField");
        modelNameField.setBorder(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        deviceSettingsPanel.add(modelNameField, gridBagConstraints);

        modelNumberLabel.setText(bundle.getString("SettingsPanel.ModelNumber")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        deviceSettingsPanel.add(modelNumberLabel, gridBagConstraints);

        modelNumberField.setEditable(false);
        modelNumberField.setText("modelNumberField");
        modelNumberField.setBorder(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        deviceSettingsPanel.add(modelNumberField, gridBagConstraints);

        serialNumberLabel.setText(bundle.getString("SettingsPanel.SerialNumber")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        deviceSettingsPanel.add(serialNumberLabel, gridBagConstraints);

        serialNumberField.setEditable(false);
        serialNumberField.setText("serialNumberField");
        serialNumberField.setBorder(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        deviceSettingsPanel.add(serialNumberField, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        deviceSettingsPanel.add(jSeparator3, gridBagConstraints);

        dangerZoneLabel.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        dangerZoneLabel.setText(bundle.getString("SettingsPanel.DangerZone")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        deviceSettingsPanel.add(dangerZoneLabel, gridBagConstraints);

        deleteDeviceButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/i52salia/aircontrol/resources/images/delete-icon.png"))); // NOI18N
        deleteDeviceButton.setText(bundle.getString("SettingsPanel.DeleteDevice")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        deviceSettingsPanel.add(deleteDeviceButton, gridBagConstraints);

        containerPanel2.add(deviceSettingsPanel);

        deviceSettingsMainPanel.setViewportView(containerPanel2);

        add(deviceSettingsMainPanel);

        newDeviceStep1MainPanel.setBorder(null);

        containerPanel4.setLayout(new java.awt.BorderLayout());

        newDeviceStep1NetworkPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 1, 20, 1));

        scanningNetowrkLabel.setForeground(new java.awt.Color(133, 126, 126));
        scanningNetowrkLabel.setText(bundle.getString("SettingsPanel.ScanningTheNetowrk")); // NOI18N
        newDeviceStep1NetworkPanel.add(scanningNetowrkLabel);

        devicesFoundLabel.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        devicesFoundLabel.setForeground(new java.awt.Color(133, 126, 126));
        devicesFoundLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        devicesFoundLabel.setText(bundle.getString("SettingsPanel.2DevicesFound")); // NOI18N
        newDeviceStep1NetworkPanel.add(devicesFoundLabel);

        containerPanel4.add(newDeviceStep1NetworkPanel, java.awt.BorderLayout.NORTH);

        newDeviceStep1ListPanel.setLayout(new java.awt.BorderLayout(0, 5));

        selectDeviceLabel.setText(bundle.getString("SettingsPanel.SelectDevice")); // NOI18N
        newDeviceStep1ListPanel.add(selectDeviceLabel, java.awt.BorderLayout.NORTH);

        newDevicesList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        newProgramStep1ScrollPane.setViewportView(newDevicesList);

        newDeviceStep1ListPanel.add(newProgramStep1ScrollPane, java.awt.BorderLayout.CENTER);

        containerPanel4.add(newDeviceStep1ListPanel, java.awt.BorderLayout.CENTER);

        newDeviceStep1ButtonsPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        cancelStep1Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/i52salia/aircontrol/resources/images/back-icon.png"))); // NOI18N
        cancelStep1Button.setText(bundle.getString("SettingsPanel.Cancel")); // NOI18N
        newDeviceStep1ButtonsPanel.add(cancelStep1Button);

        invisibleSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        invisibleSeparator2.setBorder(null);
        invisibleSeparator2.setPreferredSize(new java.awt.Dimension(25, 0));
        newDeviceStep1ButtonsPanel.add(invisibleSeparator2);

        nextStepButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/i52salia/aircontrol/resources/images/next-icon.png"))); // NOI18N
        nextStepButton.setText(bundle.getString("SettingsPanel.Next")); // NOI18N
        newDeviceStep1ButtonsPanel.add(nextStepButton);

        containerPanel4.add(newDeviceStep1ButtonsPanel, java.awt.BorderLayout.SOUTH);

        newDeviceStep1MainPanel.setViewportView(containerPanel4);

        add(newDeviceStep1MainPanel);

        newDeviceStep2MainPanel.setBorder(null);

        containerPanel3.setEnabled(false);
        containerPanel3.setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.GridBagLayout());

        newDeviceNameLabel.setText(bundle.getString("SettingsPanel.NewDeviceName")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        jPanel1.add(newDeviceNameLabel, gridBagConstraints);

        newDeviceNameField.setText("newDeviceNameField");
        newDeviceNameField.setMaximumSize(new java.awt.Dimension(250, 35));
        newDeviceNameField.setMinimumSize(new java.awt.Dimension(250, 35));
        newDeviceNameField.setPreferredSize(new java.awt.Dimension(250, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        jPanel1.add(newDeviceNameField, gridBagConstraints);

        containerPanel3.add(jPanel1, java.awt.BorderLayout.CENTER);

        newDeviceStep2ButtonsPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        backToStep1Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/i52salia/aircontrol/resources/images/back-icon.png"))); // NOI18N
        backToStep1Button.setText(bundle.getString("SettingsPanel.GoBack")); // NOI18N
        newDeviceStep2ButtonsPanel.add(backToStep1Button);

        invisibleSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        invisibleSeparator1.setBorder(null);
        invisibleSeparator1.setPreferredSize(new java.awt.Dimension(25, 0));
        newDeviceStep2ButtonsPanel.add(invisibleSeparator1);

        saveNewDeviceButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/i52salia/aircontrol/resources/images/save-icon.png"))); // NOI18N
        saveNewDeviceButton.setText(bundle.getString("SettingsPanel.Save")); // NOI18N
        newDeviceStep2ButtonsPanel.add(saveNewDeviceButton);

        containerPanel3.add(newDeviceStep2ButtonsPanel, java.awt.BorderLayout.SOUTH);

        newDeviceStep2MainPanel.setViewportView(containerPanel3);

        add(newDeviceStep2MainPanel);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LanguageLabel;
    public javax.swing.JButton addDeviceButton;
    private javax.swing.JLabel appSettingsLabel;
    public javax.swing.JButton backToStep1Button;
    public javax.swing.JButton cancelStep1Button;
    private javax.swing.JPanel containerPanel1;
    private javax.swing.JPanel containerPanel2;
    private javax.swing.JPanel containerPanel3;
    private javax.swing.JPanel containerPanel4;
    private javax.swing.JLabel dangerZoneLabel;
    public javax.swing.JButton deleteDeviceButton;
    private javax.swing.JLabel deviceInfoLabel;
    public javax.swing.JTextField deviceNameField;
    private javax.swing.JLabel deviceNameLabel;
    private javax.swing.JLabel deviceSettingsLabel;
    public javax.swing.JScrollPane deviceSettingsMainPanel;
    private javax.swing.JPanel deviceSettingsPanel;
    private javax.swing.JLabel devicesFoundLabel;
    private javax.swing.JLabel devicesLabel;
    public javax.swing.JList devicesList;
    private javax.swing.JScrollPane devicesScrollPane;
    public javax.swing.JCheckBox horizontalSwingCheckBox;
    public javax.swing.JLabel horizontalSwingLabel;
    private javax.swing.JSeparator invisibleSeparator1;
    private javax.swing.JSeparator invisibleSeparator2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    public javax.swing.JComboBox languageComboBox;
    public javax.swing.JTextField modelNameField;
    private javax.swing.JLabel modelNameLabel;
    public javax.swing.JTextField modelNumberField;
    private javax.swing.JLabel modelNumberLabel;
    public javax.swing.JTextField newDeviceNameField;
    private javax.swing.JLabel newDeviceNameLabel;
    private javax.swing.JPanel newDeviceStep1ButtonsPanel;
    private javax.swing.JPanel newDeviceStep1ListPanel;
    public javax.swing.JScrollPane newDeviceStep1MainPanel;
    private javax.swing.JPanel newDeviceStep1NetworkPanel;
    private javax.swing.JPanel newDeviceStep2ButtonsPanel;
    public javax.swing.JScrollPane newDeviceStep2MainPanel;
    public javax.swing.JList newDevicesList;
    private javax.swing.JScrollPane newProgramStep1ScrollPane;
    public javax.swing.JButton nextStepButton;
    public javax.swing.JButton openDeviceSettingsButton;
    public javax.swing.JButton saveButton;
    public javax.swing.JButton saveNewDeviceButton;
    private javax.swing.JLabel scanningNetowrkLabel;
    private javax.swing.JLabel selectDeviceLabel;
    public javax.swing.JTextField serialNumberField;
    private javax.swing.JLabel serialNumberLabel;
    public javax.swing.JScrollPane settingsMainPanel;
    private javax.swing.JPanel settingsPanel;
    public javax.swing.JComboBox tempUnitComboBox;
    private javax.swing.JLabel tempUnitLabel;
    public javax.swing.JComboBox timeFormatComboBox;
    private javax.swing.JLabel timeFormatLabel;
    public javax.swing.JCheckBox verticalSwingCheckBox;
    public javax.swing.JLabel verticalSwingLabel;
    // End of variables declaration//GEN-END:variables
}
