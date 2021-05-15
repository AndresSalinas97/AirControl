package i52salia.si.trabajofinal.aircontrol;

import java.util.ArrayList;

/**
 *
 * @author Andrés Salinas Lima {@literal <i52salia@uco.es>}
 */
public class AirControlModel {
    public ArrayList<AirConditioner> devices;

    public AirControlModel() {
        devices = new ArrayList<AirConditioner>();

        // TESTING DEVICES
        devices.add(new AirConditioner("Daikin Wall Split Model A34GH3",
                "A34GH3", "DYPTP7584JCLK3", true, true));
        devices.add(new AirConditioner("Daikin Wall Split Model A34GH5",
                "A34GH5", "DYPTP7584ALKSJ3", false, false));
    }
}
