package i52salia.aircontrol;

import i52salia.aircontrol.components.DeviceListItem;
import i52salia.aircontrol.components.ProgramListItem;
import i52salia.aircontrol.utils.ACProgram;
import i52salia.aircontrol.utils.AirConditioner;
import i52salia.aircontrol.utils.TemperatureConverter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public final class Controller {

    private final Model model;
    private final View view;

    /**
     * Constructor for class AirControlController.
     *
     * @param model the AirControl model
     * @param view the AirControl view
     */
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        initView();
        initController();
    }

    private void initView() {
        switchToHomeTab();

        view.setVisible(true);
        view.setFocusable(true);
    }

    private void initController() {
        initTabController();
        initHomePanelController();
        initProgrammingPanelController();
        initSettingsPanelController();
    }

    private void initTabController() {
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
        view.homePanel.onOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.selectedDevice.setTurnedOn(!model.selectedDevice.isTurnedOn());
            }
        });

        view.homePanel.setpointTempSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                model.selectedDevice.setSetpointCelsius(
                        (float) view.homePanel.setpointTempSpinner.getValue());
            }
        });

        view.homePanel.modeButtons.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                model.selectedDevice.setMode(view.homePanel.modeButtons.getSelectedMode());
            }
        });

        view.homePanel.fanSpeedSelector.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                model.selectedDevice.setFanSpeed(view.homePanel.fanSpeedSelector.getSelectedFanSpeed());
            }
        });

        view.homePanel.backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchToHomeTab();
            }
        });
    }

    private void initProgrammingPanelController() {
        view.programmingPanel.cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchToProgrammingTab();
            }
        });
    }

    private void initSettingsPanelController() {

    }

    private void switchToHomeTab() {
        view.titleLabel.setText("Home");

        reloadDeviceList();

        view.programmingPanel.setVisible(false);
        view.homePanel.setVisible(true);
        view.settingsPanel.setVisible(false);

        view.homePanel.deviceListMainPanel.setVisible(true);
        view.homePanel.deviceSettingsMainPanel.setVisible(false);
    }

    private void switchToProgrammingTab() {
        view.titleLabel.setText("Programming");

        reloadProgramList();

        view.programmingPanel.setVisible(true);
        view.homePanel.setVisible(false);
        view.settingsPanel.setVisible(false);

        view.programmingPanel.programListMainPanel.setVisible(true);
        view.programmingPanel.programSettingsMainPanel.setVisible(false);
    }

    private void switchToSettingsTab() {
        view.titleLabel.setText("Settings");

        view.programmingPanel.setVisible(false);
        view.homePanel.setVisible(false);
        view.settingsPanel.setVisible(true);
    }

    private void reloadDeviceList() {
        view.homePanel.deviceListPanel.removeAll();

        for (AirConditioner device : model.devices) {
            DeviceListItem newDeviceComponent = new DeviceListItem();

            newDeviceComponent.nameLabel.setText(device.getGivenName());

            if (device.isTurnedOn()) {
                newDeviceComponent.onPanel.setVisible(true);
                newDeviceComponent.offPanel.setVisible(false);

                newDeviceComponent.onOffButton.setTurnedOn(true);

                newDeviceComponent.currentTempOnLabel.setText(
                        TemperatureConverter.celsiusToCelsiusString(
                                device.getCurrentCelsius()));

                newDeviceComponent.setpointTempLabel.setText(
                        TemperatureConverter.celsiusToCelsiusString(
                                device.getSetpointCelsius()));

                switch (device.getMode()) {
                    case COOL:
                        newDeviceComponent.modeLabel.setText("Mode: Cool");
                        break;
                    case FAN:
                        newDeviceComponent.modeLabel.setText("Mode: Fan");
                        break;
                    case DRY:
                        newDeviceComponent.modeLabel.setText("Mode: Dry");
                        break;
                    case HEAT:
                        newDeviceComponent.modeLabel.setText("Mode: Heat");
                        break;
                    case AUTO:
                        newDeviceComponent.modeLabel.setText("Mode: Auto");
                        break;
                }

                switch (device.getFanSpeed()) {
                    case LOW:
                        newDeviceComponent.fanSpeedLabel.setText("Fan Speed: Low");
                        break;
                    case MEDIUM:
                        newDeviceComponent.fanSpeedLabel.setText("Fan Speed: Medium");
                        break;
                    case HIGH:
                        newDeviceComponent.fanSpeedLabel.setText("Fan Speed: High");
                        break;
                    case AUTO:
                        newDeviceComponent.fanSpeedLabel.setText("Fan Speed: Auto");
                        break;
                }

            } else {
                newDeviceComponent.onPanel.setVisible(false);
                newDeviceComponent.offPanel.setVisible(true);

                newDeviceComponent.onOffButton.setTurnedOn(false);

                newDeviceComponent.currentTempOffLabel.setText(
                        TemperatureConverter.celsiusToCelsiusString(
                                device.getCurrentCelsius()));
            }

            newDeviceComponent.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    model.selectedDevice = device;
                    openSelectedDevice();
                }
            });

            newDeviceComponent.onOffButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    device.setTurnedOn(!device.isTurnedOn());
                    reloadDeviceList();
                }
            });

            view.homePanel.deviceListPanel.add(newDeviceComponent);
        }

        view.homePanel.deviceListPanel.revalidate();
        view.homePanel.deviceListPanel.repaint();
    }

    private void openSelectedDevice() {
        AirConditioner device = model.selectedDevice;

        view.titleLabel.setText(device.getGivenName());

        view.homePanel.deviceListMainPanel.setVisible(false);
        view.homePanel.deviceSettingsMainPanel.setVisible(true);

        view.homePanel.onOffButton.setTurnedOn(device.isTurnedOn());

        view.homePanel.currentTempLabel.setText(TemperatureConverter.celsiusToCelsiusString(device.getCurrentCelsius()));

        view.homePanel.setpointTempSpinner.setValue(device.getSetpointCelsius());

        view.homePanel.modeButtons.setSelectedMode(device.getMode());

        view.homePanel.fanSpeedSelector.setSelectedFanSpeed(device.getFanSpeed());
    }

    private void reloadProgramList() {
        view.programmingPanel.programListPanel.removeAll();

        for (AirConditioner device : model.devices) {
            for (ACProgram program : device.getPrograms()) {
                ProgramListItem newDeviceComponent = new ProgramListItem();

                newDeviceComponent.nameLabel.setText(device.getGivenName());

                newDeviceComponent.toggleButton.setToggledOn(program.isEnabled());

                String daysOfWeekText = "";
                if (program.isOnMondays() && program.isOnTuesdays()
                        && program.isOnWednesdays() && program.isOnThursdays()
                        && program.isOnFridays() && program.isOnSaturdays()
                        && program.isOnSundays()) {
                    daysOfWeekText = "Everyday";
                } else if (program.isOnMondays() && program.isOnTuesdays()
                        && program.isOnWednesdays() && program.isOnThursdays()
                        && program.isOnFridays() && !program.isOnSaturdays()
                        && !program.isOnSundays()) {
                    daysOfWeekText = "Weekdays";
                } else if (!program.isOnMondays() && !program.isOnTuesdays()
                        && !program.isOnWednesdays() && !program.isOnThursdays()
                        && !program.isOnFridays() && program.isOnSaturdays()
                        && program.isOnSundays()) {
                    daysOfWeekText = "Weekends";
                } else {
                    boolean first = true;
                    if (program.isOnMondays()) {
                        daysOfWeekText += "Mon";
                        first = false;
                    }
                    if (program.isOnTuesdays()) {
                        if (!first) {
                            daysOfWeekText += ", ";
                        }
                        daysOfWeekText += "Tue";
                        first = false;
                    }
                    if (program.isOnWednesdays()) {
                        if (!first) {
                            daysOfWeekText += ", ";
                        }
                        daysOfWeekText += "Wed";
                        first = false;
                    }
                    if (program.isOnThursdays()) {
                        if (!first) {
                            daysOfWeekText += ", ";
                        }
                        daysOfWeekText += "Thu";
                        first = false;
                    }
                    if (program.isOnFridays()) {
                        if (!first) {
                            daysOfWeekText += ", ";
                        }
                        daysOfWeekText += "Fri";
                        first = false;
                    }
                    if (program.isOnSaturdays()) {
                        if (!first) {
                            daysOfWeekText += ", ";
                        }
                        daysOfWeekText += "Sat";
                        first = false;
                    }
                    if (program.isOnSundays()) {
                        if (!first) {
                            daysOfWeekText += ", ";
                        }
                        daysOfWeekText += "Sun";
                        first = false;
                    }
                }
                newDeviceComponent.daysLabel.setText(daysOfWeekText);

                newDeviceComponent.timeLabel.setText(
                        program.getStartTime().get24HourString() + " - "
                        + program.getEndTime().get24HourString());

                view.programmingPanel.programListPanel.add(newDeviceComponent);

                newDeviceComponent.setpointTempLabel.setText(
                        TemperatureConverter.celsiusToCelsiusString(
                                program.getSetpointCelsius()));

                switch (program.getMode()) {
                    case COOL:
                        newDeviceComponent.modeLabel.setText("Mode: Cool");
                        break;
                    case FAN:
                        newDeviceComponent.modeLabel.setText("Mode: Fan");
                        break;
                    case DRY:
                        newDeviceComponent.modeLabel.setText("Mode: Dry");
                        break;
                    case HEAT:
                        newDeviceComponent.modeLabel.setText("Mode: Heat");
                        break;
                    case AUTO:
                        newDeviceComponent.modeLabel.setText("Mode: Auto");
                        break;
                }

                switch (program.getFanSpeed()) {
                    case LOW:
                        newDeviceComponent.fanSpeedLabel.setText("Fan Speed: Low");
                        break;
                    case MEDIUM:
                        newDeviceComponent.fanSpeedLabel.setText("Fan Speed: Medium");
                        break;
                    case HIGH:
                        newDeviceComponent.fanSpeedLabel.setText("Fan Speed: High");
                        break;
                    case AUTO:
                        newDeviceComponent.fanSpeedLabel.setText("Fan Speed: Auto");
                        break;
                }

                newDeviceComponent.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        model.selectedDevice = device;
                        model.selectedProgram = program;
                        openSelectedProgram();
                    }
                });

                newDeviceComponent.toggleButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        program.setEnabled(!program.isEnabled());
                    }
                });
            }
        }

        view.programmingPanel.programListPanel.revalidate();
        view.programmingPanel.programListPanel.repaint();
    }

    /**
     * TODO
     */
    public void openSelectedProgram() {
        AirConditioner device = model.selectedDevice;
        ACProgram program = model.selectedProgram;

        view.titleLabel.setText(device.getGivenName() + " Program");

        view.programmingPanel.programListMainPanel.setVisible(false);
        view.programmingPanel.programSettingsMainPanel.setVisible(true);

        view.programmingPanel.deviceLabel.setText(device.getGivenName());

        view.programmingPanel.toggleButton.setToggledOn(program.isEnabled());
    }
}
