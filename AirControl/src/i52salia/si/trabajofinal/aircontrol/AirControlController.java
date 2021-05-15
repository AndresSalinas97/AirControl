package i52salia.si.trabajofinal.aircontrol;

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
        updateTitleLabel();
    }

    private void initController() {
        view.tabbedPane.addChangeListener(e -> updateTitleLabel());
    }
    
    private void updateTitleLabel() {
        switch (view.tabbedPane.getSelectedIndex()) {
            case 0:
                view.titleLabel.setText("Programming");
                break;
            case 1:
                view.titleLabel.setText("Home");
                break;
            case 2:
                view.titleLabel.setText("Settings");
                break;
        }
    }
}
