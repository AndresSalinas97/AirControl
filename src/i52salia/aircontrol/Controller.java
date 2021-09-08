package i52salia.aircontrol;

import i52salia.aircontrol.components.DeviceListItemComponent;
import i52salia.aircontrol.components.ProgramListItemComponent;
import i52salia.aircontrol.panels.HomePanel;
import i52salia.aircontrol.panels.ProgrammingPanel;
import i52salia.aircontrol.panels.SettingsPanel;
import i52salia.aircontrol.utils.ACProgram;
import i52salia.aircontrol.utils.AirConditioner;
import i52salia.aircontrol.utils.DialogBoxes;
import i52salia.aircontrol.utils.Temperature;
import i52salia.aircontrol.utils.Time;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;

/**
 * The Controller of the AirControl App.
 *
 * @author Andrés Salinas Lima (i52salia@uco.es)
 */
public final class Controller {

    private final Model model;
    private View view;
    private AirConditioner selectedDevice;
    private ACProgram selectedProgram;
    private ResourceBundle bundle = ResourceBundle.getBundle(
            "i52salia/aircontrol/resources/languagebundles/Bundle");

    /**
     * @param model the AirControl model
     * @param view the AirControl view
     */
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        initController();
        initView();
    }

    /**
     * Initializes the controller of the different panels.
     */
    private void initController() {
        initTabBarController();
        initHomePanelController();
        initProgrammingPanelController();
        initSettingsPanelController();
    }

    /**
     * Initializes the view: selects the right unit format and switches to the
     * home panel.
     */
    private void initView() {
        switchToHomeMainPanel();

        changeTemperatureUnit();
        changeTimeFormat();

        view.setVisible(true);
        view.setFocusable(true);
    }

    /**
     * Initializes the tab bar controller: adds the right event listeners to the
     * right buttons.
     */
    private void initTabBarController() {
        view.homeTab.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                switchToHomeMainPanel();
            }
        });

        view.programmingTab.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                switchToProgrammingMainPanel();
            }
        });

        view.settingsTab.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                switchToSettingsMainPanel();
            }
        });
    }

    /**
     * Initializes the Home panel controller: adds the right event listeners to
     * the right buttons.
     */
    private void initHomePanelController() {
        HomePanel hp = view.getHomePanel();

        hp.onOffButton.addActionListener((ActionEvent e) -> {
            selectedDevice.setTurnedOn(!selectedDevice.isTurnedOn());
        });

        hp.setpointTemperatureSelector.addChangeListener((ChangeEvent e) -> {
            selectedDevice.setSetpointTemp(
                    hp.setpointTemperatureSelector.getSelectedTemperature());
        });

        hp.modeButtons.addChangeListener((ChangeEvent e) -> {
            selectedDevice.setMode(hp.modeButtons.getSelectedMode());
        });

        hp.fanSpeedSelector.addChangeListener((ChangeEvent e) -> {
            selectedDevice.setFanSpeed(hp.fanSpeedSelector.getSelectedFanSpeed());
        });

        hp.moreSettingsButton.addActionListener((ActionEvent e) -> {
            switchToSelectedDeviceSettings();
        });

        hp.addDeviceButton.addActionListener((ActionEvent e) -> {
            switchToAddNewDeviceStep1();
        });
    }

    /**
     * Initializes the Programming panel controller: adds the right event
     * listeners to the right buttons.
     */
    private void initProgrammingPanelController() {
        ProgrammingPanel pp = view.getProgrammingPanel();

        // Main panel
        pp.addProgramButton.addActionListener((ActionEvent e) -> {
            switchToAddNewProgramStep1();
        });

        // Program settings panel
        pp.cancelChangesButton.addActionListener((ActionEvent e) -> {
            switchToProgrammingMainPanel();
        });
        pp.saveChangesButton.addActionListener((ActionEvent e) -> {
            saveProgramSettingsChanges();
        });
        pp.deleteProgramButton.addActionListener((ActionEvent e) -> {
            confirmSelectedProgramDeletion();
        });

        // New program panels
        pp.cancelStep1Button.addActionListener((ActionEvent e) -> {
            switchToProgrammingMainPanel();
        });
        pp.nextStepButton.addActionListener((ActionEvent e) -> {
            switchToAddNewProgramStep2();
        });
        pp.backToStep1Button.addActionListener((ActionEvent e) -> {
            switchToAddNewProgramStep1();
        });
        pp.saveNewProgramButton.addActionListener((ActionEvent e) -> {
            saveNewProgram();
        });
    }

    /**
     * Initializes the Settings panel controller: adds the right event listeners
     * to the right buttons.
     */
    private void initSettingsPanelController() {
        SettingsPanel sp = view.getSettingsPanel();

        // Main Panel
        sp.languageComboBox.addActionListener((ActionEvent e) -> {
            if (sp.languageComboBox.getSelectedIndex() == 0) {
                changeLanguage("en");
            } else if (sp.languageComboBox.getSelectedIndex() == 1) {
                changeLanguage("es");
            }
        });
        sp.tempUnitComboBox.addActionListener((ActionEvent e) -> {
            if (sp.tempUnitComboBox.getSelectedIndex() == 0) {
                model.setTempUnit(Temperature.TempUnit.CELSIUS);
            } else if (sp.tempUnitComboBox.getSelectedIndex() == 1) {
                model.setTempUnit(Temperature.TempUnit.FAHRENHEIT);
            }

            changeTemperatureUnit();
        });
        sp.timeFormatComboBox.addActionListener((ActionEvent e) -> {
            if (sp.timeFormatComboBox.getSelectedIndex() == 0) {
                model.setTimeFormat(Time.TimeFormat.TF24HOUR);
            } else if (sp.timeFormatComboBox.getSelectedIndex() == 1) {
                model.setTimeFormat(Time.TimeFormat.TF12HOUR);
            }

            changeTimeFormat();
        });
        sp.openDeviceSettingsButton.addActionListener((ActionEvent e) -> {
            openSelectedDeviceSettings();
        });
        sp.addDeviceButton.addActionListener((ActionEvent e) -> {
            switchToAddNewDeviceStep1();
        });

        // Device settings panel
        sp.saveChangesButton.addActionListener((ActionEvent e) -> {
            saveDeviceSettingsChanges();
        });
        sp.cancelChangesButton.addActionListener((ActionEvent e) -> {
            switchToSettingsMainPanel();
        });
        sp.deleteDeviceButton.addActionListener((ActionEvent e) -> {
            confirmSelectedDeviceDeletion();
        });

        // Add new device panels
        sp.nextStepButton.addActionListener((ActionEvent e) -> {
            switchToAddNewDeviceStep2();
        });
        sp.cancelStep1Button.addActionListener((ActionEvent e) -> {
            switchToSettingsMainPanel();
        });
        sp.backToStep1Button.addActionListener((ActionEvent e) -> {
            switchToAddNewDeviceStep1();
        });
        sp.saveNewDeviceButton.addActionListener((ActionEvent e) -> {
            saveNewDevice();
        });
    }

    /**
     * Switches to the Home tab.
     */
    private void switchToHomeTab() {
        // Switch to home tab
        view.getHomePanel().setVisible(true);
        view.getProgrammingPanel().setVisible(false);
        view.getSettingsPanel().setVisible(false);

        // Paint tabs
        view.homeTab.setBackground(View.SELECTED_TAB_BG);
        view.programmingTab.setBackground(View.UNSELECTED_TAB_BG);
        view.settingsTab.setBackground(View.UNSELECTED_TAB_BG);
    }

    /**
     * Switches to the Programming tab.
     */
    private void switchToProgrammingTab() {
        // Switch to home tab
        view.getHomePanel().setVisible(false);
        view.getProgrammingPanel().setVisible(true);
        view.getSettingsPanel().setVisible(false);

        // Paint tabs
        view.homeTab.setBackground(View.UNSELECTED_TAB_BG);
        view.programmingTab.setBackground(View.SELECTED_TAB_BG);
        view.settingsTab.setBackground(View.UNSELECTED_TAB_BG);
    }

    /**
     * Switches to the Settings tab.
     */
    private void switchToSettingsTab() {
        // Switch to home tab
        view.getHomePanel().setVisible(false);
        view.getProgrammingPanel().setVisible(false);
        view.getSettingsPanel().setVisible(true);

        // Paint tabs
        view.homeTab.setBackground(View.UNSELECTED_TAB_BG);
        view.programmingTab.setBackground(View.UNSELECTED_TAB_BG);
        view.settingsTab.setBackground(View.SELECTED_TAB_BG);
    }

    /**
     * Prepares the content and switches to the main panel of the Home tab.
     */
    private void switchToHomeMainPanel() {
        HomePanel hp = view.getHomePanel();

        switchToHomeTab();

        // Set tab title
        view.titleLabel.setText(bundle.getString("View.tabs.Home"));

        // Prepare home tab
        reloadHomeTabDeviceList();

        // Show the right subpanel
        hp.deviceListMainPanel.setVisible(true);
        hp.deviceSettingsMainPanel.setVisible(false);
    }

    /**
     * Reloads the list of devices in the main panel of the Home tab.
     */
    private void reloadHomeTabDeviceList() {
        javax.swing.JPanel listPanel = view.getHomePanel().deviceListPanel;

        listPanel.removeAll();

        model.getDevices().stream().map((device) -> {
            DeviceListItemComponent newDeviceComponent = new DeviceListItemComponent();
            newDeviceComponent.nameLabel.setText(device.getGivenName());
            if (device.isTurnedOn()) {
                // Make ON panel visible
                newDeviceComponent.onPanel.setVisible(true);
                newDeviceComponent.offPanel.setVisible(false);

                // Fill panel
                newDeviceComponent.onOffButton.setTurnedOn(true);
                newDeviceComponent.currentTempOnLabel.setText(
                        device.getCurrentTemp().getString(model.getTempUnit()));
                newDeviceComponent.setpointTempLabel.setText(
                        device.getSetpointTemp().getString(model.getTempUnit()));
                newDeviceComponent.modeLabel.setText(device.getModeString());
                newDeviceComponent.fanSpeedLabel.setText(
                        device.getFanSpeedString());
            } else {
                // Make OFF panel visible
                newDeviceComponent.onPanel.setVisible(false);
                newDeviceComponent.offPanel.setVisible(true);

                // Fill panel
                newDeviceComponent.onOffButton.setTurnedOn(false);
                newDeviceComponent.currentTempOffLabel.setText(
                        device.getCurrentTemp().getString(model.getTempUnit()));
            }
            newDeviceComponent.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    selectedDevice = device;
                    switchToSelectedDevice();
                }
            });
            newDeviceComponent.onOffButton.addActionListener((ActionEvent e) -> {
                device.setTurnedOn(!device.isTurnedOn());
                reloadHomeTabDeviceList();
            });
            return newDeviceComponent;
        }).forEach((newDeviceComponent) -> {
            listPanel.add(newDeviceComponent);
        });

        listPanel.revalidate();
        listPanel.repaint();
    }

    /**
     * Prepares the content and switches to the main panel of the Programming
     * tab.
     */
    private void switchToProgrammingMainPanel() {
        ProgrammingPanel pp = view.getProgrammingPanel();

        switchToProgrammingTab();

        // Set tab title
        view.titleLabel.setText(bundle.getString("View.tabs.Programming"));

        // Prepare programming tab
        reloadProgrammingTabProgramList();

        // Show the right subpanel
        pp.programListMainPanel.setVisible(true);
        pp.programSettingsMainPanel.setVisible(false);
        pp.newProgramStep1MainPanel.setVisible(false);
        pp.newProgramStep2MainPanel.setVisible(false);
    }

    /**
     * Reloads the list of programs in the main panel of the Programming tab.
     */
    private void reloadProgrammingTabProgramList() {
        JPanel listPanel = view.getProgrammingPanel().programListPanel;

        listPanel.removeAll();

        model.getDevices().stream().forEach((device) -> {
            device.getPrograms().stream().map((program) -> {
                ProgramListItemComponent newDeviceComponent = new ProgramListItemComponent();

                newDeviceComponent.nameLabel.setText(device.getGivenName());
                newDeviceComponent.toggleButton.setToggledOn(program.isEnabled());
                newDeviceComponent.daysLabel.setText(
                        program.getDaysOfWeekSelection().getString());
                newDeviceComponent.timeLabel.setText(
                        program.getTimeFrame().getString(model.getTimeFormat()));
                newDeviceComponent.setpointTempLabel.setText(
                        program.getSetpointTemp().getString(model.getTempUnit()));
                newDeviceComponent.modeLabel.setText(program.getModeString());
                newDeviceComponent.fanSpeedLabel.setText(program.getFanSpeedString());

                newDeviceComponent.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        selectedDevice = device;
                        selectedProgram = program;
                        switchToSelectedProgram();
                    }
                });
                newDeviceComponent.toggleButton.addActionListener((ActionEvent e) -> {
                    program.setEnabled(!program.isEnabled());
                });

                return newDeviceComponent;
            }).forEach((newDeviceComponent) -> {
                listPanel.add(newDeviceComponent);
            });
        });

        listPanel.revalidate();
        listPanel.repaint();
    }

    /**
     * Prepares the content and switches to the main panel of the Settings tab.
     */
    private void switchToSettingsMainPanel() {
        SettingsPanel sp = view.getSettingsPanel();

        switchToSettingsTab();

        // Set tab title
        view.titleLabel.setText(bundle.getString("View.tabs.Settings"));

        // Prepare settings tab
        reloadSettingsTabComboBoxes();
        reloadSettingsTabDeviceList();

        // Show the right subpanel
        sp.settingsMainPanel.setVisible(true);
        sp.deviceSettingsMainPanel.setVisible(false);
        sp.newDeviceStep1MainPanel.setVisible(false);
        sp.newDeviceStep2MainPanel.setVisible(false);
    }

    /**
     * Reloads the comboBoxes (selecting the active settings) in the main panel
     * of the Settings tab.
     */
    private void reloadSettingsTabComboBoxes() {
        SettingsPanel sp = view.getSettingsPanel();

        // Language
        if (Locale.getDefault().getLanguage().equals("es")) {
            sp.languageComboBox.setSelectedIndex(1);
        } else {
            sp.languageComboBox.setSelectedIndex(0);
        }

        // Temperature unit
        switch (model.getTempUnit()) {
            case CELSIUS:
                sp.tempUnitComboBox.setSelectedIndex(0);
                break;
            case FAHRENHEIT:
                sp.tempUnitComboBox.setSelectedIndex(1);
                break;
            default:
                throw new UnsupportedOperationException();
        }

        // Time format
        switch (model.getTimeFormat()) {
            case TF24HOUR:
                sp.timeFormatComboBox.setSelectedIndex(0);
                break;
            case TF12HOUR:
                sp.timeFormatComboBox.setSelectedIndex(1);
                break;
            default:
                throw new UnsupportedOperationException();
        }
    }

    /**
     * Reloads the list of devices of the main panel of the Settings tab.
     */
    private void reloadSettingsTabDeviceList() {
        // Fill the devices list
        DefaultListModel devicesListModel = new DefaultListModel();

        model.getDevices()
                .stream().forEach((device) -> {
                    devicesListModel.addElement(device.getGivenName());
                });

        view.getSettingsPanel().devicesList.setModel(devicesListModel);
    }

    /**
     * Prepares the content and switches to the panel with the first step to add
     * a new program.
     */
    private void switchToAddNewProgramStep1() {
        ProgrammingPanel pp = view.getProgrammingPanel();

        switchToProgrammingTab();

        // Set tab title
        view.titleLabel.setText(bundle.getString("ProgrammingPanel.NewProgramTitle"));

        // Show the right subpanel
        pp.programListMainPanel.setVisible(false);
        pp.programSettingsMainPanel.setVisible(false);
        pp.newProgramStep1MainPanel.setVisible(true);
        pp.newProgramStep2MainPanel.setVisible(false);

        // Fill the devices list
        DefaultListModel devicesListModel = new DefaultListModel();
        model.getDevices().stream().forEach((device) -> {
            devicesListModel.addElement(device.getGivenName());
        });
        pp.devicesList.setModel(devicesListModel);
    }

    /**
     * Prepares the content and switches to the panel with the second step to
     * add a new program.
     */
    private void switchToAddNewProgramStep2() {
        ProgrammingPanel pp = view.getProgrammingPanel();

        // Check if a device has been selected
        int selectedDeviceIndex = pp.devicesList.getSelectedIndex();
        if (selectedDeviceIndex < 0 || selectedDeviceIndex >= model.getDevices().size()) {
            DialogBoxes.showErrrorMessage(
                    view, bundle.getString("Controller.addNewProgramStep2.Error"));
            return;
        }

        // Get the selected device
        selectedDevice = model.getDevices().get(selectedDeviceIndex);

        // Set tab title
        view.titleLabel.setText(
                bundle.getString("ProgrammingPanel.NewProgramTitle")
                + " - "
                + selectedDevice.getGivenName());

        // Fill the newProgramComponent
        pp.newProgramComponent.setSelectedDeviceName(selectedDevice.getGivenName());
        pp.newProgramComponent.setSelectedProgram(new ACProgram());

        // Show the right panel
        pp.newProgramStep1MainPanel.setVisible(false);
        pp.newProgramStep2MainPanel.setVisible(true);
    }

    /**
     * Saves the new program as configured by the user in the second step.
     */
    private void saveNewProgram() {
        ProgrammingPanel pp = view.getProgrammingPanel();

        ACProgram newProgram = pp.newProgramComponent.getSelectedProgram();

        selectedDevice.getPrograms().add(newProgram);

        switchToProgrammingMainPanel();
    }

    /**
     * Prepares the content and switches to the panel with the first step to add
     * a new device.
     */
    private void switchToAddNewDeviceStep1() {
        SettingsPanel sp = view.getSettingsPanel();

        switchToSettingsTab();

        // Set tab title
        view.titleLabel.setText(bundle.getString("SettingsPanel.NewDeviceTitle"));

        // Show the right subpanel
        sp.settingsMainPanel.setVisible(false);
        sp.deviceSettingsMainPanel.setVisible(false);
        sp.newDeviceStep1MainPanel.setVisible(true);
        sp.newDeviceStep2MainPanel.setVisible(false);

        // Fill the devices list
        DefaultListModel devicesListModel = new DefaultListModel();
        model.getNetworkDevices().stream().forEach((device) -> {
            devicesListModel.addElement(device.getModelName());
        });
        sp.newDevicesList.setModel(devicesListModel);
    }

    /**
     * Prepares the content and switches to the panel with the second step to
     * add a new device.
     */
    private void switchToAddNewDeviceStep2() {
        SettingsPanel sp = view.getSettingsPanel();

        // Check if a device has been selected
        int selectedDeviceIndex = sp.newDevicesList.getSelectedIndex();
        if (selectedDeviceIndex < 0 || selectedDeviceIndex >= model.getNetworkDevices().size()) {
            DialogBoxes.showErrrorMessage(
                    view, bundle.getString("Controller.addNewDeviceStep2.Error"));
            return;
        }

        // Get the selected device
        selectedDevice = model.getNetworkDevices().get(selectedDeviceIndex);

        // Prepare the panel
        sp.newDeviceNameField.setText(selectedDevice.getModelName());

        // Show the right panel
        sp.newDeviceStep1MainPanel.setVisible(false);
        sp.newDeviceStep2MainPanel.setVisible(true);
    }

    /**
     * Saves the new device as configured by the user in the second step.
     */
    private void saveNewDevice() {
        SettingsPanel sp = view.getSettingsPanel();

        selectedDevice.setGivenName(sp.newDeviceNameField.getText());

        model.getDevices().add(selectedDevice);

        switchToSelectedDevice();
    }

    /**
     * Prepares the content and switches to the panel with the selected AC
     * device current status.
     */
    private void switchToSelectedDevice() {
        HomePanel hp = view.getHomePanel();

        switchToHomeTab();

        // Set tab title
        view.titleLabel.setText(selectedDevice.getGivenName());

        // Show the right subpanel
        hp.deviceListMainPanel.setVisible(false);
        hp.deviceSettingsMainPanel.setVisible(true);

        // Fill the panel with the device configuration
        hp.onOffButton.setTurnedOn(selectedDevice.isTurnedOn());

        hp.currentTempLabel.setText(
                selectedDevice.getCurrentTemp().getString(model.getTempUnit()));

        hp.setpointTemperatureSelector.setSelectedTemperature(selectedDevice.getSetpointTemp());

        hp.modeButtons.setSelectedMode(selectedDevice.getMode());

        hp.fanSpeedSelector.setSelectedFanSpeed(selectedDevice.getFanSpeed());
    }

    /**
     * Prepares the content and switches to the panel with the selected program
     * configuration.
     */
    private void switchToSelectedProgram() {
        ProgrammingPanel pp = view.getProgrammingPanel();

        switchToProgrammingTab();

        // Set tab title
        view.titleLabel.setText(
                bundle.getString("ProgrammingPanel.ProgramTitle")
                + " - "
                + selectedDevice.getGivenName());

        // Show the right subpanel
        pp.programListMainPanel.setVisible(false);
        pp.programSettingsMainPanel.setVisible(true);
        pp.newProgramStep1MainPanel.setVisible(false);
        pp.newProgramStep2MainPanel.setVisible(false);

        // Prepare the panel
        pp.programSettingsComponent.setSelectedDeviceName(selectedDevice.getGivenName());
        pp.programSettingsComponent.setSelectedProgram(selectedProgram);
    }

    private void saveProgramSettingsChanges() {
        ProgrammingPanel pp = view.getProgrammingPanel();

        ACProgram modifiedProgram = pp.programSettingsComponent.getSelectedProgram();
        
        selectedProgram.setEnabled(modifiedProgram.isEnabled());
        selectedProgram.setDaysOfWeekSelection(modifiedProgram.getDaysOfWeekSelection());
        selectedProgram.setTimeFrame(modifiedProgram.getTimeFrame());
        selectedProgram.setSetpointTemp(modifiedProgram.getSetpointTemp());
        selectedProgram.setMode(modifiedProgram.getMode());
        selectedProgram.setFanSpeed(modifiedProgram.getFanSpeed());

        switchToProgrammingMainPanel();
    }

    /**
     * Tries to open the settings of the device selected in the list of the
     * settings main panel.
     */
    private void openSelectedDeviceSettings() {
        SettingsPanel sp = view.getSettingsPanel();

        // Check if a device has been selected
        int selectedDeviceIndex = sp.devicesList.getSelectedIndex();
        if (selectedDeviceIndex < 0 || selectedDeviceIndex >= model.getDevices().size()) {
            DialogBoxes.showErrrorMessage(
                    view, bundle.getString("Controller.openDeviceSettingsButton.Error"));
            return;
        }

        selectedDevice = model.getDevices().get(selectedDeviceIndex);

        switchToSelectedDeviceSettings();
    }

    /**
     * Prepares the content and switches to the panel with the selected AC
     * device settings and info.
     */
    private void switchToSelectedDeviceSettings() {
        SettingsPanel sp = view.getSettingsPanel();

        switchToSettingsTab();

        // Set tab title
        view.titleLabel.setText(
                bundle.getString("SettingsPanel.DeviceSettingsTitle")
                + " - "
                + selectedDevice.getGivenName());

        // Show the right subpanel
        sp.setVisible(true);
        sp.settingsMainPanel.setVisible(false);
        sp.deviceSettingsMainPanel.setVisible(true);
        sp.newDeviceStep1MainPanel.setVisible(false);
        sp.newDeviceStep2MainPanel.setVisible(false);

        // Fill the panel
        sp.deviceNameField.setText(selectedDevice.getGivenName());
        if (selectedDevice.hasHorizontalVanes()) {
            sp.horizontalSwingLabel.setEnabled(true);
            sp.horizontalSwingCheckBox.setEnabled(true);
            sp.horizontalSwingCheckBox.setSelected(
                    selectedDevice.isHorizontalVanesSwinging());
        } else {
            sp.horizontalSwingLabel.setEnabled(false);
            sp.horizontalSwingCheckBox.setEnabled(false);
            sp.horizontalSwingCheckBox.setSelected(false);
        }
        if (selectedDevice.hasVerticalVanes()) {
            sp.verticalSwingLabel.setEnabled(true);
            sp.verticalSwingCheckBox.setEnabled(true);
            sp.verticalSwingCheckBox.setSelected(
                    selectedDevice.isVerticalVanesSwinging());
        } else {
            sp.verticalSwingLabel.setEnabled(false);
            sp.verticalSwingCheckBox.setEnabled(false);
            sp.verticalSwingCheckBox.setSelected(false);

        }
        sp.modelNameField.setText(selectedDevice.getModelName());
        sp.modelNumberField.setText(selectedDevice.getModelNumber());
        sp.serialNumberField.setText(selectedDevice.getSerialNumber());
    }

    /**
     * Saves the changes made to the selected device.
     */
    private void saveDeviceSettingsChanges() {
        SettingsPanel sp = view.getSettingsPanel();

        selectedDevice.setGivenName(sp.deviceNameField.getText());
        selectedDevice.setHorizontalVanesSwinging(
                sp.horizontalSwingCheckBox.isSelected());
        selectedDevice.setVerticalVanesSwinging(
                sp.verticalSwingCheckBox.isSelected());

        switchToSettingsMainPanel();
    }

    /**
     * Asks the user to confirm before deleting the program.
     */
    private void confirmSelectedProgramDeletion() {
        if (DialogBoxes.confirmDeletion(view)) {
            deleteSelectedProgram();
        }
    }

    /**
     * Deletes the selected program.
     */
    private void deleteSelectedProgram() {
        selectedDevice.getPrograms().remove(selectedProgram);

        switchToProgrammingMainPanel();
    }

    /**
     * Asks the user to confirm before deleting the device.
     */
    private void confirmSelectedDeviceDeletion() {
        if (DialogBoxes.confirmDeletion(view)) {
            deleteSelectedDevice();
        }
    }

    /**
     * Deletes the selected device.
     */
    private void deleteSelectedDevice() {
        model.getDevices().remove(selectedDevice);

        switchToSettingsMainPanel();
    }

    /**
     * Changes the App language.
     *
     * @param language the desired language (right now only "en" or "es" are
     * possible)
     */
    private void changeLanguage(String language) {
        // Check if it is actually a different language than the current one
        if (Locale.getDefault().getLanguage().equals(language)) {
            return; // Nothing to do
        }

        // Set new Locale and reload interface
        reloadLocale(new Locale(language));

        // Switch back to settings tab
        switchToSettingsMainPanel();
    }

    /**
     * Reloads the App using the new Locale.
     *
     * @param locale
     */
    private void reloadLocale(Locale locale) {
        // Set new Locale
        Locale.setDefault(locale);
        JOptionPane.setDefaultLocale(locale); // For predefined dialog boxes

        // Update the language bundle for this controller
        bundle = ResourceBundle.getBundle(
                "i52salia/aircontrol/resources/languagebundles/Bundle");

        // Destroy current View (JFrame and all its components)
        view.dispose();

        // Create and initialize a new View
        view = new View();
        initController();
        initView();
    }

    /**
     * Changes the temperature unit used in various components of the App.
     */
    private void changeTemperatureUnit() {
        view.getHomePanel().setpointTemperatureSelector.setTemperatureUnit(
                model.getTempUnit());
        view.getProgrammingPanel().programSettingsComponent.setTemperatureUnit(
                model.getTempUnit());
        view.getProgrammingPanel().newProgramComponent.setTemperatureUnit(
                model.getTempUnit());

        reloadHomeTabDeviceList();
        reloadProgrammingTabProgramList();
    }

    /**
     * Changes the time format used in various components of the App.
     */
    private void changeTimeFormat() {
        view.getProgrammingPanel().programSettingsComponent.setTimeFormat(
                model.getTimeFormat());
        view.getProgrammingPanel().newProgramComponent.setTimeFormat(
                model.getTimeFormat());

        reloadHomeTabDeviceList();
        reloadProgrammingTabProgramList();
    }
}
