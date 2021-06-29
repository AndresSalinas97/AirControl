package i52salia.aircontrol;

import i52salia.aircontrol.components.DeviceListItemComponent;
import i52salia.aircontrol.components.ProgramListItemComponent;
import i52salia.aircontrol.panels.HomePanel;
import i52salia.aircontrol.panels.ProgrammingPanel;
import i52salia.aircontrol.panels.SettingsPanel;
import i52salia.aircontrol.utils.ACProgram;
import i52salia.aircontrol.utils.AirConditioner;
import i52salia.aircontrol.utils.Temperature;
import i52salia.aircontrol.utils.Time;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;

/**
 * The Controller of the AirControl App.
 *
 * @author Andrés Salinas Lima (i52salia@uco.es)
 */
public final class Controller {

    private final Model model;
    private final View view;
    private AirConditioner selectedDevice;
    private ACProgram selectedProgram;

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

    private void initController() {
        initTabBarController();
        initHomePanelController();
        initProgrammingPanelController();
        initSettingsPanelController();
    }

    private void initView() {
        switchToHomeTab();

        switchLanguage();
        switchTemperatureUnit();
        switchTimeFormat();

        view.setVisible(true);
        view.setFocusable(true);
    }

    private void initTabBarController() {
        view.homeTab.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                switchToHomeTab();
            }
        });

        view.programmingTab.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                switchToProgrammingTab();
            }
        });

        view.settingsTab.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                switchToSettingsTab();
            }
        });
    }

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

        hp.backButton.addActionListener((ActionEvent e) -> {
            switchToHomeTab();
        });
    }

    private void initProgrammingPanelController() {
        ProgrammingPanel pp = view.getProgrammingPanel();

        pp.addProgramButton.addActionListener((ActionEvent e) -> {
            addNewProgramStep1();
        });

        pp.cancelChangesButton.addActionListener((ActionEvent e) -> {
            switchToProgrammingTab();
        });

        pp.saveChangesButton.addActionListener((ActionEvent e) -> {
            ACProgram modifiedProgram = pp.programSettingsComponent.getSelectedProgram();
            selectedProgram.setEnabled(modifiedProgram.isEnabled());
            selectedProgram.setDaysOfWeekSelection(modifiedProgram.getDaysOfWeekSelection());
            selectedProgram.setTimeFrame(modifiedProgram.getTimeFrame());
            selectedProgram.setSetpointTemp(modifiedProgram.getSetpointTemp());
            selectedProgram.setMode(modifiedProgram.getMode());
            selectedProgram.setFanSpeed(modifiedProgram.getFanSpeed());

            switchToProgrammingTab();
        });

        pp.deleteProgramButton.addActionListener((ActionEvent e) -> {
            confirmSelectedProgramDeletion();
        });

        pp.cancelStep1Button.addActionListener((ActionEvent e) -> {
            switchToProgrammingTab();
        });

        pp.nextStepButton.addActionListener((ActionEvent e) -> {
            addNewProgramStep2();
        });

        pp.backToStep1Button.addActionListener((ActionEvent e) -> {
            addNewProgramStep1();
        });

        pp.saveNewProgramButton.addActionListener((ActionEvent e) -> {
            addNewProgramStep3();
        });
    }

    private void initSettingsPanelController() {
        SettingsPanel sp = view.getSettingsPanel();

        sp.tempUnitComboBox.addActionListener((ActionEvent e) -> {
            if (sp.tempUnitComboBox.getSelectedIndex() == 0) {
                model.setTempUnit(Temperature.TempUnit.CELSIUS);
            } else if (sp.tempUnitComboBox.getSelectedIndex() == 1) {
                model.setTempUnit(Temperature.TempUnit.FAHRENHEIT);
            }

            switchTemperatureUnit();
        });

        sp.timeFormatComboBox.addActionListener((ActionEvent e) -> {
            if (sp.timeFormatComboBox.getSelectedIndex() == 0) {
                model.setTimeFormat(Time.TimeFormat.TF24HOUR);
            } else if (sp.timeFormatComboBox.getSelectedIndex() == 1) {
                model.setTimeFormat(Time.TimeFormat.TF12HOUR);
            }

            switchTimeFormat();
        });
    }

    private void switchToHomeTab() {
        // Prepare home tab
        reloadDeviceList();
        view.getHomePanel().deviceListMainPanel.setVisible(true);
        view.getHomePanel().deviceSettingsMainPanel.setVisible(false);

        // Switch to home tab
        view.getProgrammingPanel().setVisible(false);
        view.getHomePanel().setVisible(true);
        view.getSettingsPanel().setVisible(false);

        // Set tab title
        view.titleLabel.setText("Home");
    }

    private void switchToProgrammingTab() {
        // Prepare programming tab
        reloadProgramList();
        view.getProgrammingPanel().programListMainPanel.setVisible(true);
        view.getProgrammingPanel().programSettingsMainPanel.setVisible(false);
        view.getProgrammingPanel().newProgramStep1MainPanel.setVisible(false);
        view.getProgrammingPanel().newProgramStep2MainPanel.setVisible(false);

        // Switch to programming tab
        view.getProgrammingPanel().setVisible(true);
        view.getHomePanel().setVisible(false);
        view.getSettingsPanel().setVisible(false);

        // Set tab title
        view.titleLabel.setText("Programming");
    }

    private void addNewProgramStep1() {
        ProgrammingPanel pp = view.getProgrammingPanel();

        // Fill the devices list
        DefaultListModel devicesListModel = new DefaultListModel();
        model.getDevices().stream().forEach((device) -> {
            devicesListModel.addElement(device.getGivenName());
        });
        pp.devicesList.setModel(devicesListModel);

        // Show the right panel
        view.getHomePanel().setVisible(false);
        view.getSettingsPanel().setVisible(false);
        pp.setVisible(true);
        pp.programListMainPanel.setVisible(false);
        pp.programSettingsMainPanel.setVisible(false);
        pp.newProgramStep1MainPanel.setVisible(true);
        pp.newProgramStep2MainPanel.setVisible(false);

        // Set tab title
        view.titleLabel.setText("New Program");
    }

    private void addNewProgramStep2() {
        ProgrammingPanel pp = view.getProgrammingPanel();

        // Check if a device has been selected
        int selectedDeviceIndex = pp.devicesList.getSelectedIndex();
        if (selectedDeviceIndex < 0 || selectedDeviceIndex >= model.getDevices().size()) {
            // TODO: Show warning window
            return;
        }

        // Get the selected device
        selectedDevice = model.getDevices().get(selectedDeviceIndex);

        // Fill the newProgramComponent
        pp.newProgramComponent.setSelectedDeviceName(selectedDevice.getGivenName());
        pp.newProgramComponent.setSelectedProgram(new ACProgram());

        // Show the right panel
        view.getHomePanel().setVisible(false);
        view.getSettingsPanel().setVisible(false);
        pp.setVisible(true);
        pp.programListMainPanel.setVisible(false);
        pp.programSettingsMainPanel.setVisible(false);
        pp.newProgramStep1MainPanel.setVisible(false);
        pp.newProgramStep2MainPanel.setVisible(true);

        // Set tab title
        view.titleLabel.setText("New Program");
    }

    private void addNewProgramStep3() {
        ProgrammingPanel pp = view.getProgrammingPanel();

        ACProgram newProgram = pp.newProgramComponent.getSelectedProgram();

        selectedDevice.getPrograms().add(newProgram);

        switchToProgrammingTab();
    }

    private void switchToSettingsTab() {
        SettingsPanel sp = view.getSettingsPanel();

        // Fill the devices list
        DefaultListModel devicesListModel = new DefaultListModel();
        model.getDevices().stream().forEach((device) -> {
            devicesListModel.addElement(device.getGivenName());
        });
        sp.devicesList.setModel(devicesListModel);

        // Switch to settings tab
        view.getProgrammingPanel().setVisible(false);
        view.getHomePanel().setVisible(false);
        view.getSettingsPanel().setVisible(true);

        // Set tab title
        view.titleLabel.setText("Settings");
    }

    private void reloadDeviceList() {
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
                    openSelectedDevice();
                }
            });
            newDeviceComponent.onOffButton.addActionListener((ActionEvent e) -> {
                device.setTurnedOn(!device.isTurnedOn());
                reloadDeviceList();
            });
            return newDeviceComponent;
        }).forEach((newDeviceComponent) -> {
            listPanel.add(newDeviceComponent);
        });

        listPanel.revalidate();
        listPanel.repaint();
    }

    private void openSelectedDevice() {
        HomePanel hp = view.getHomePanel();

        hp.deviceListMainPanel.setVisible(false);
        hp.deviceSettingsMainPanel.setVisible(true);

        hp.onOffButton.setTurnedOn(selectedDevice.isTurnedOn());

        hp.currentTempLabel.setText(
                selectedDevice.getCurrentTemp().getString(model.getTempUnit()));

        hp.setpointTemperatureSelector.setSelectedTemperature(selectedDevice.getSetpointTemp());

        hp.modeButtons.setSelectedMode(selectedDevice.getMode());

        hp.fanSpeedSelector.setSelectedFanSpeed(selectedDevice.getFanSpeed());

        view.titleLabel.setText(selectedDevice.getGivenName());
    }

    private void reloadProgramList() {
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
                        openSelectedProgram();
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

    private void openSelectedProgram() {
        ProgrammingPanel pp = view.getProgrammingPanel();

        view.titleLabel.setText("Program");

        pp.programListMainPanel.setVisible(false);
        pp.programSettingsMainPanel.setVisible(true);

        pp.programSettingsComponent.setSelectedDeviceName(selectedDevice.getGivenName());
        pp.programSettingsComponent.setSelectedProgram(selectedProgram);
    }

    private void confirmSelectedProgramDeletion() {
        // TODO: Ask user to confirm
        deleteSelectedProgram();
    }

    private void deleteSelectedProgram() {
        selectedDevice.getPrograms().remove(selectedProgram);

        switchToProgrammingTab();
    }

    // TODO
    private void switchLanguage() {

    }

    private void switchTemperatureUnit() {
        view.getHomePanel().setpointTemperatureSelector.setTemperatureUnit(
                model.getTempUnit());
        view.getProgrammingPanel().programSettingsComponent.setTemperatureUnit(
                model.getTempUnit());
        view.getProgrammingPanel().newProgramComponent.setTemperatureUnit(
                model.getTempUnit());

        reloadDeviceList();
        reloadProgramList();
    }

    private void switchTimeFormat() {
        view.getProgrammingPanel().programSettingsComponent.setTimeFormat(
                model.getTimeFormat());
        view.getProgrammingPanel().newProgramComponent.setTimeFormat(
                model.getTimeFormat());

        reloadDeviceList();
        reloadProgramList();
    }
}
