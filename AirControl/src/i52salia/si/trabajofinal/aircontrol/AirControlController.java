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
        view.setVisible(true);
        view.setFocusable(true);
    }

    private void initController() {
        view.homeTab.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                switchToHomeTab();
            }
        });
        
        view.programmingTab.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                switchToProgrammingTab();
            }
        });
        
        view.settingsTab.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                switchToSettingsTab();
            }
        });
    }

    private void switchToHomeTab() {
        view.titleLabel.setText("Home");
        view.programmingPanel.setVisible(false);
        view.homePanel.setVisible(true);
        view.settingsPanel.setVisible(false);
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
}
