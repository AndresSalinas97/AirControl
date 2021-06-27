package i52salia.aircontrol.utils;

/**
 * Class to hold the configuration of an air conditioning device weekly program.
 *
 * @author Andrés Salinas Lima (i52salia@uco.es)
 */
public final class ACProgram {

    private boolean enabled;
    private DaysOfWeekSelection daysOfWeekSelection;
    private TimeFrame timeFrame;
    private Temperature setpointTemp;
    private AirConditioner.Mode mode;
    private AirConditioner.FanSpeed fanSpeed;

    /**
     * Constructor with all values set to their defaults.
     */
    public ACProgram() {
        this.enabled = false;
        daysOfWeekSelection = new DaysOfWeekSelection();
        this.timeFrame = new TimeFrame(new Time(0, 0), new Time(0, 0));
        this.setpointTemp = new Temperature(21, Temperature.TempUnit.CELSIUS);
        this.mode = AirConditioner.Mode.AUTO;
        this.fanSpeed = AirConditioner.FanSpeed.AUTO;
    }

    /**
     * @return boolean that indicates if the program is enabled
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * @param enabled boolean that indicates if the program is enabled
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * @return selection of days of the week in which the program will be active
     */
    public DaysOfWeekSelection getDaysOfWeekSelection() {
        return daysOfWeekSelection;
    }

    /**
     * @param daysOfWeekSelection selection of days of the week in which the
     * program will be active
     */
    public void setDaysOfWeekSelection(DaysOfWeekSelection daysOfWeekSelection) {
        this.daysOfWeekSelection = daysOfWeekSelection;
    }

    /**
     * @return time frame (start time + end time) in which the program will be
     * active
     */
    public TimeFrame getTimeFrame() {
        return timeFrame;
    }

    /**
     * @param timeFrame time frame (start time + end time) in which the program
     * will be active
     */
    public void setTimeFrame(TimeFrame timeFrame) {
        this.timeFrame = timeFrame;
    }

    /**
     * @return desired setpoint temperature for the program
     */
    public Temperature getSetpointTemp() {
        return setpointTemp;
    }

    /**
     * @param setpointTemp desired setpoint temperature for the program
     */
    public void setSetpointTemp(Temperature setpointTemp) {
        this.setpointTemp = setpointTemp;
    }

    /**
     * @return desired air conditioner mode for the program
     */
    public AirConditioner.Mode getMode() {
        return mode;
    }

    /**
     * @param mode desired air conditioner mode for the program
     */
    public void setMode(AirConditioner.Mode mode) {
        this.mode = mode;
    }

    /**
     * @return desired air conditioner fan speed for the program
     */
    public AirConditioner.FanSpeed getFanSpeed() {
        return fanSpeed;
    }

    /**
     * @param fanSpeed desired air conditioner fan speed for the program
     */
    public void setFanSpeed(AirConditioner.FanSpeed fanSpeed) {
        this.fanSpeed = fanSpeed;
    }

    /**
     * @return a formatted and localized string with the currently selected mode
     */
    public String getModeString() {
        return AirConditioner.getModeString(mode);
    }

    /**
     * @return a formatted and localized string with the currently selected fan
     * speed
     */
    public String getFanSpeedString() {
        return AirConditioner.getFanSpeedString(fanSpeed);
    }
}
