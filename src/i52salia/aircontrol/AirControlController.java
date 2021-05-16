package i52salia.aircontrol;

import i52salia.aircontrol.components.DeviceListComponent;
import i52salia.aircontrol.utils.AirConditioner;
import i52salia.aircontrol.utils.TemperatureConverter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public final class AirControlController {

    private final AirControlModel model;
    private final AirControlView view;

    /**
     * Constructor for class AirControlController.
     *
     * @param model the AirControl model
     * @param view the AirControl view
     */
    public AirControlController(AirControlModel model, AirControlView view) {
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
    }

    private void initProgrammingPanelController() {

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

        view.programmingPanel.setVisible(true);
        view.homePanel.setVisible(false);
        view.settingsPanel.setVisible(false);
    }

    private void switchToSettingsTab() {
        view.titleLabel.setText("Settings");

        view.programmingPanel.setVisible(false);
        view.homePanel.setVisible(false);
        view.settingsPanel.setVisible(true);
    }

    private void reloadDeviceList() {
        view.homePanel.deviceList.removeAll();

        for (AirConditioner device : model.devices) {
            DeviceListComponent newDeviceComponent = new DeviceListComponent();

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
                newDeviceComponent.modeLabel.setText("Mode: " + device.getMode());
                newDeviceComponent.fanSpeedLabel.setText("Fan Speed: " + device.getFanSpeed());
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

            view.homePanel.deviceList.add(newDeviceComponent);
        }

        view.homePanel.deviceList.revalidate();
        view.homePanel.deviceList.repaint();
    }

    private void openSelectedDevice() {
        AirConditioner selectedDevice = model.selectedDevice;

        view.titleLabel.setText(selectedDevice.getGivenName());

        view.homePanel.deviceListMainPanel.setVisible(false);
        view.homePanel.deviceSettingsMainPanel.setVisible(true);

        view.homePanel.onOffButton.setTurnedOn(selectedDevice.isTurnedOn());

        view.homePanel.currentTempLabel.setText(TemperatureConverter.celsiusToCelsiusString(selectedDevice.getCurrentCelsius()));

        view.homePanel.setpointTempSpinner.setValue(selectedDevice.getSetpointCelsius());
    }
}
