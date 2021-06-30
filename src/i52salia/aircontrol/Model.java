package i52salia.aircontrol;

import i52salia.aircontrol.utils.Time;
import i52salia.aircontrol.utils.AirConditioner;
import i52salia.aircontrol.utils.ACProgram;
import i52salia.aircontrol.utils.DaysOfWeekSelection;
import i52salia.aircontrol.utils.Temperature;
import i52salia.aircontrol.utils.TimeFrame;
import java.util.ArrayList;

/**
 * The Model of the AirControl App.
 *
 * @author Andrés Salinas Lima (i52salia@uco.es)
 */
public final class Model {

    private final ArrayList<AirConditioner> devices;
    private Temperature.TempUnit tempUnit;
    private Time.TimeFormat timeFormat;

    /**
     * Initializes the model.
     */
    public Model() {
        devices = new ArrayList<>();

        tempUnit = Temperature.TempUnit.CELSIUS;
        timeFormat = Time.TimeFormat.TF24HOUR;

        addExampleDevices();
        addExamplePrograms();
    }

    /**
     * @return temperature unit to be used in the App
     */
    public Temperature.TempUnit getTempUnit() {
        return tempUnit;
    }

    /**
     * @param tempUnit temperature unit to be used in the App
     */
    public void setTempUnit(Temperature.TempUnit tempUnit) {
        this.tempUnit = tempUnit;
    }

    /**
     * @return time format to be used in the App
     */
    public Time.TimeFormat getTimeFormat() {
        return timeFormat;
    }

    /**
     * @param timeFormat time format to be used in the App
     */
    public void setTimeFormat(Time.TimeFormat timeFormat) {
        this.timeFormat = timeFormat;
    }

    private void addExampleDevices() {
        AirConditioner ac1 = new AirConditioner("Living Room",
                "Daikin Wall Split Model A34GH3", "A34GH3", "DYPTP7584JCLK3",
                true, true);
        ac1.setTurnedOn(true);
        devices.add(ac1);

        AirConditioner ac2 = new AirConditioner("Bedroom",
                "Daikin Wall Split Model A34GH5", "A34GH5", "DYPTP7584ALKSJ3",
                false, false);
        ac2.setTurnedOn(true);
        ac2.setFanSpeed(AirConditioner.FanSpeed.LOW);
        ac2.setMode(AirConditioner.Mode.COOL);
        devices.add(ac2);

        AirConditioner ac3 = new AirConditioner("Office",
                "Daikin Wall Split Model A34GH3", "A34GH3", "DYPTP7584JCLK3",
                true, true);
        ac3.setFanSpeed(AirConditioner.FanSpeed.HIGH);
        ac3.setMode(AirConditioner.Mode.FAN);
        devices.add(ac3);
    }

    private void addExamplePrograms() {
        ACProgram p1 = new ACProgram();
        p1.setDaysOfWeekSelection(new DaysOfWeekSelection(
                false, false, false, false, false, true, true));
        p1.setTimeFrame(new TimeFrame(new Time(9, 0), new Time(14, 30)));
        p1.setEnabled(true);
        devices.get(0).getPrograms().add(p1);

        ACProgram p2 = new ACProgram();
        p2.setDaysOfWeekSelection(new DaysOfWeekSelection(
                true, true, true, true, true, true, true));
        p2.setTimeFrame(new TimeFrame(new Time(16, 0), new Time(21, 30)));
        p2.setFanSpeed(AirConditioner.FanSpeed.HIGH);
        p2.setEnabled(true);
        devices.get(0).getPrograms().add(p2);

        ACProgram p3 = new ACProgram();
        p3.setDaysOfWeekSelection(new DaysOfWeekSelection(
                true, true, true, true, true, false, false));
        p3.setTimeFrame(new TimeFrame(new Time(22, 0), new Time(7, 30)));
        p3.setFanSpeed(AirConditioner.FanSpeed.LOW);
        p3.setMode(AirConditioner.Mode.COOL);
        p3.setSetpointTemp(new Temperature(24, Temperature.TempUnit.CELSIUS));
        devices.get(1).getPrograms().add(p3);

        ACProgram p4 = new ACProgram();
        p4.setDaysOfWeekSelection(new DaysOfWeekSelection(
                true, true, true, true, true, true, false));
        p4.setTimeFrame(new TimeFrame(new Time(16, 0), new Time(21, 30)));
        p4.setEnabled(true);
        devices.get(2).getPrograms().add(p4);
    }

    /**
     * @return the list of air conditioning devices
     */
    public ArrayList<AirConditioner> getDevices() {
        return devices;
    }
}
