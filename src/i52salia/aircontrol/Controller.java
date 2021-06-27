package i52salia.aircontrol;

import i52salia.aircontrol.components.DeviceListItem;
import i52salia.aircontrol.components.ProgramListItem;
import i52salia.aircontrol.panels.HomePanel;
import i52salia.aircontrol.panels.ProgrammingPanel;
import i52salia.aircontrol.panels.SettingsPanel;
import i52salia.aircontrol.utils.ACProgram;
import i52salia.aircontrol.utils.AirConditioner;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

        // TODO: Add listener to setpointTemperatureSelector
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

    // TODO
    private void initProgrammingPanelController() {
        ProgrammingPanel pp = view.getProgrammingPanel();

        pp.cancelButton.addActionListener((ActionEvent e) -> {
            switchToProgrammingTab();
        });
    }

    // TODO
    private void initSettingsPanelController() {
        SettingsPanel sp = view.getSettingsPanel();
    }

    private void switchToHomeTab() {
        reloadDeviceList();

        view.getProgrammingPanel().setVisible(false);
        view.getHomePanel().setVisible(true);
        view.getSettingsPanel().setVisible(false);

        view.getHomePanel().deviceListMainPanel.setVisible(true);
        view.getHomePanel().deviceSettingsMainPanel.setVisible(false);

        view.titleLabel.setText("Home");
    }

    private void switchToProgrammingTab() {
        reloadProgramList();

        view.getProgrammingPanel().setVisible(true);
        view.getHomePanel().setVisible(false);
        view.getSettingsPanel().setVisible(false);

        view.getProgrammingPanel().programListMainPanel.setVisible(true);
        view.getProgrammingPanel().programSettingsMainPanel.setVisible(false);

        view.titleLabel.setText("Programming");
    }

    private void switchToSettingsTab() {
        view.getProgrammingPanel().setVisible(false);
        view.getHomePanel().setVisible(false);
        view.getSettingsPanel().setVisible(true);

        view.titleLabel.setText("Settings");
    }

    private void reloadDeviceList() {
        javax.swing.JPanel listPanel = view.getHomePanel().deviceListPanel;

        listPanel.removeAll();

        model.getDevices().stream().map((device) -> {
            DeviceListItem newDeviceComponent = new DeviceListItem();
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
        AirConditioner device = selectedDevice;
        HomePanel hp = view.getHomePanel();

        hp.deviceListMainPanel.setVisible(false);
        hp.deviceSettingsMainPanel.setVisible(true);

        hp.onOffButton.setTurnedOn(device.isTurnedOn());

        hp.currentTempLabel.setText(
                device.getCurrentTemp().getString(model.getTempUnit()));

        // TODO: Fill setpointTemperatureSelector
        hp.modeButtons.setSelectedMode(device.getMode());

        hp.fanSpeedSelector.setSelectedFanSpeed(device.getFanSpeed());

        view.titleLabel.setText(device.getGivenName());
    }

    private void reloadProgramList() {
        view.getProgrammingPanel().programListPanel.removeAll();

        model.getDevices().stream().forEach((device) -> {
            device.getPrograms().stream().map((program) -> {
                ProgramListItem newDeviceComponent = new ProgramListItem();
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
                view.getProgrammingPanel().programListPanel.add(newDeviceComponent);
            });
        });

        view.getProgrammingPanel().programListPanel.revalidate();
        view.getProgrammingPanel().programListPanel.repaint();
    }

    // TODO
    private void openSelectedProgram() {
        AirConditioner device = selectedDevice;
        ACProgram program = selectedProgram;

        view.titleLabel.setText(device.getGivenName() + " Program");

        view.getProgrammingPanel().programListMainPanel.setVisible(false);
        view.getProgrammingPanel().programSettingsMainPanel.setVisible(true);

        view.getProgrammingPanel().deviceLabel.setText(device.getGivenName());

        view.getProgrammingPanel().toggleButton.setToggledOn(program.isEnabled());
    }

    // TODO
    private void switchLanguage() {

    }

    // TODO
    private void switchTemperatureUnit() {

    }

    // TODO
    private void switchTimeFormat() {

    }
}
