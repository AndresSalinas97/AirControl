package i52salia.si.trabajofinal.aircontrol;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author andres
 */
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

            component.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    model.selectedDevice = device;
                    openSelectedDevice();
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
