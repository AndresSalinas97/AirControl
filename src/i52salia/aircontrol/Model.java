package i52salia.aircontrol;

import i52salia.aircontrol.utils.Time;
import i52salia.aircontrol.utils.AirConditioner;
import i52salia.aircontrol.utils.ACProgram;
import java.util.ArrayList;

public final class Model {

    public ArrayList<AirConditioner> devices;
    public AirConditioner selectedDevice;
    public ACProgram selectedProgram;

    public Model() {
        devices = new ArrayList<AirConditioner>();

        ///////////////////////////////////////////////////////////////////////
        /////////////////////////////// TESTING ///////////////////////////////
        // Add test devices
        AirConditioner ac1 = new AirConditioner("Dormitorio", "Daikin Wall Split Model A34GH3",
                "A34GH3", "DYPTP7584JCLK3", true, true);
        ac1.setTurnedOn(true);
        devices.add(ac1);

        AirConditioner ac2 = new AirConditioner("Salón", "Daikin Wall Split Model A34GH5",
                "A34GH5", "DYPTP7584ALKSJ3", false, false);
        ac2.setTurnedOn(true);
        devices.add(ac2);

        AirConditioner ac3 = new AirConditioner("Cocina", "Daikin Wall Split Model A34GH3",
                "A34GH3", "DYPTP7584JCLK3", true, true);
        devices.add(ac3);

        AirConditioner ac4 = new AirConditioner("Despacho", "Daikin Wall Split Model A34GH5",
                "A34GH5", "DYPTP7584ALKSJ3", false, false);
        devices.add(ac4);

        // Add test programs
        ACProgram p1 = new ACProgram();
        p1.setOnSaturdays(true);
        p1.setOnSundays(true);
        p1.setStartTime(new Time(9, 0));
        p1.setEndTime(new Time(14, 30));
        p1.setEnabled(true);
        devices.get(0).getPrograms().add(p1);

        ACProgram p2 = new ACProgram();
        p2.setOnMondays(true);
        p2.setOnTuesdays(true);
        p2.setOnWednesdays(true);
        p2.setOnThursdays(true);
        p2.setOnFridays(true);
        p2.setOnSaturdays(true);
        p2.setOnSundays(true);
        p2.setStartTime(new Time(16, 0));
        p2.setEndTime(new Time(21, 30));
        p2.setEnabled(true);
        devices.get(0).getPrograms().add(p2);

        ACProgram p3 = new ACProgram();
        p3.setOnMondays(true);
        p3.setOnTuesdays(true);
        p3.setOnWednesdays(true);
        p3.setOnThursdays(true);
        p3.setOnFridays(true);
        p3.setStartTime(new Time(9, 0));
        p3.setEndTime(new Time(14, 30));
        p3.setFanSpeed(AirConditioner.FanSpeed.HIGH);
        p3.setMode(AirConditioner.Mode.COOL);
        p3.setSetpointCelsius(24);
        devices.get(1).getPrograms().add(p3);

        ACProgram p4 = new ACProgram();
        p4.setOnMondays(true);
        p4.setOnTuesdays(true);
        p4.setOnWednesdays(true);
        p4.setOnThursdays(true);
        p4.setOnFridays(true);
        p4.setOnSaturdays(true);
        p4.setStartTime(new Time(16, 0));
        p4.setEndTime(new Time(21, 30));
        p4.setEnabled(true);
        devices.get(2).getPrograms().add(p4);
    }
}
