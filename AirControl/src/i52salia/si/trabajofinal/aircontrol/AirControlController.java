package i52salia.si.trabajofinal.aircontrol;

/**
 *
 * @author andres
 */
public class AirControlController {

    private final AirControlModel model;
    private final AirControlView view;

    /**
     * Constructor for class AirControlController.
     *
     * @param m the AirControl model
     * @param v the AirControl view
     */
    public AirControlController(AirControlModel m, AirControlView v) {
        model = m;
        view = v;

        initView();
        initController();
    }

    private void initView() {
        view.setVisible(true);
        view.setFocusable(true);
    }

    private void initController() {

    }
}
