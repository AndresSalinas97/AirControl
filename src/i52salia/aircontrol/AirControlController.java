package i52salia.aircontrol;

import i52salia.aircontrol.components.DeviceListComponent;
import i52salia.aircontrol.utils.AirConditioner;
import i52salia.aircontrol.utils.TemperatureConverter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
            DeviceListComponent component = new DeviceListComponent();

            component.nameLabel.setText(device.getGivenName());

            if (device.isTurnedOn()) {
                component.onPanel.setVisible(true);
                component.offPanel.setVisible(false);

                component.onOffButton.setTurnedOn(true);

                component.currentTempOnLabel.setText(
                        TemperatureConverter.celsiusToCelsiusString(
                                device.getCurrentCelsius()));
                component.setpointTempLabel.setText(
                        TemperatureConverter.celsiusToCelsiusString(
                                device.getSetpointCelsius()));
                component.modeLabel.setText("Mode: " + device.getMode());
                component.fanSpeedLabel.setText("Fan Speed: " + device.getFanSpeed());
            } else {
                component.onPanel.setVisible(false);
                component.offPanel.setVisible(true);

                component.onOffButton.setTurnedOn(false);

                component.currentTempOffLabel.setText(
                        TemperatureConverter.celsiusToCelsiusString(
                                device.getCurrentCelsius()));
            }

            component.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    model.selectedDevice = device;
                    openSelectedDevice();
                }
            });

            component.onOffButton.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    device.setTurnedOn(!device.isTurnedOn());
                    reloadDeviceList();
                }
            });

            view.homePanel.deviceList.add(component);
        }

        view.homePanel.deviceList.revalidate();
        view.homePanel.deviceList.repaint();
    }

    private void openSelectedDevice() {
        view.titleLabel.setText(model.selectedDevice.getGivenName());

        view.homePanel.deviceListMainPanel.setVisible(false);
        view.homePanel.deviceSettingsMainPanel.setVisible(true);
    }
}
