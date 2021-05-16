package i52salia.aircontrol;

import i52salia.aircontrol.utils.Time;
import i52salia.aircontrol.utils.AirConditioner;
import i52salia.aircontrol.utils.ACProgram;
import java.util.ArrayList;

public final class AirControlModel {
    public ArrayList<AirConditioner> devices;
    public AirConditioner selectedDevice;
    public ACProgram selectedProgram;

    public AirControlModel() {
        devices = new ArrayList<AirConditioner>();

        ///////////////////////////////////////////////////////////////////////
        /////////////////////////////// TESTING ///////////////////////////////

        // Add test devices
        devices.add(new AirConditioner("Dormitorio", "Daikin Wall Split Model A34GH3",
                "A34GH3", "DYPTP7584JCLK3", true, true));
        devices.add(new AirConditioner("Salón", "Daikin Wall Split Model A34GH5",
                "A34GH5", "DYPTP7584ALKSJ3", false, false));
        devices.add(new AirConditioner("Cocina", "Daikin Wall Split Model A34GH3",
                "A34GH3", "DYPTP7584JCLK3", true, true));
        devices.add(new AirConditioner("Despacho", "Daikin Wall Split Model A34GH5",
                "A34GH5", "DYPTP7584ALKSJ3", false, false));
        
        // Add test programs
        ACProgram p1 = new ACProgram();
        p1.setOnSaturdays(true);
        p1.setOnSundays(true);
        p1.setStartTime(new Time(9, 0));
        p1.setEndTime(new Time(14, 30));
        p1.setEnabled(true);
        devices.get(0).getPrograms().add(p1);
        devices.get(1).getPrograms().add(p1);
        devices.get(2).getPrograms().add(p1);
        devices.get(3).getPrograms().add(p1);
        
        ACProgram p2 = new ACProgram();
        p2.setOnTuesdays(true);
        p2.setOnThursdays(true);
        p2.setStartTime(new Time(16, 0));
        p2.setEndTime(new Time(21, 30));
        p2.setEnabled(true);
        devices.get(0).getPrograms().add(p2);
        devices.get(1).getPrograms().add(p2);
        
        ACProgram p3 = new ACProgram();
        p3.setOnMondays(true);
        p3.setOnTuesdays(true);
        p3.setOnThursdays(true);
        p3.setOnWednesdays(true);
        p3.setOnThursdays(true);
        p3.setOnFridays(true);
        p3.setStartTime(new Time(9, 0));
        p3.setEndTime(new Time(14, 30));
        p3.setFanSpeed(AirConditioner.FanSpeed.HIGH);
        p3.setMode(AirConditioner.Mode.COOL);
        p3.setSetpointCelsius(24);
        devices.get(0).getPrograms().add(p2);
        devices.get(1).getPrograms().add(p2);
    }
}
