package i52salia.aircontrol.utils;

/**
 * Class to hold the configuration of an air conditioning device weekly program.
 *
 * @author Andrés Salinas Lima (i52salia@uco.es)
 */
public final class ACProgram {

    private boolean enabled;
    private boolean onMondays;
    private boolean onTuesdays;
    private boolean onWednesdays;
    private boolean onThursdays;
    private boolean onFridays;
    private boolean onSaturdays;
    private boolean onSundays;
    private Time startTime;
    private Time endTime;
    private float setpointCelsius;
    private AirConditioner.Mode mode;
    private AirConditioner.FanSpeed fanSpeed;

    /**
     * Constructor for the ACProgram class.
     */
    public ACProgram() {
        this.enabled = false;
        this.onMondays = false;
        this.onTuesdays = false;
        this.onWednesdays = false;
        this.onThursdays = false;
        this.onFridays = false;
        this.onSaturdays = false;
        this.onSundays = false;
        this.startTime = new Time(0, 0);
        this.endTime = new Time(0, 0);
        this.setpointCelsius = (float) 21.0;
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
     * @return boolean that indicates if the program will run on Mondays
     */
    public boolean isOnMondays() {
        return onMondays;
    }

    /**
     * @param onMondays boolean that indicates if the program will run on
     * Mondays
     */
    public void setOnMondays(boolean onMondays) {
        this.onMondays = onMondays;
    }

    /**
     * @return boolean that indicates if the program will run on Tuesdays
     */
    public boolean isOnTuesdays() {
        return onTuesdays;
    }

    /**
     * @param onTuesdays boolean that indicates if the program will run on
     * Tuesdays
     */
    public void setOnTuesdays(boolean onTuesdays) {
        this.onTuesdays = onTuesdays;
    }

    /**
     * @return boolean that indicates if the program will run on Wednesdays
     */
    public boolean isOnWednesdays() {
        return onWednesdays;
    }

    /**
     * @param onWednesdays boolean that indicates if the program will run on
     * Wednesdays
     */
    public void setOnWednesdays(boolean onWednesdays) {
        this.onWednesdays = onWednesdays;
    }

    /**
     * @return boolean that indicates if the program will run on Thursdays
     */
    public boolean isOnThursdays() {
        return onThursdays;
    }

    /**
     * @param onThursdays boolean that indicates if the program will run on
     * Thursdays
     */
    public void setOnThursdays(boolean onThursdays) {
        this.onThursdays = onThursdays;
    }

    /**
     * @return boolean that indicates if the program will run on Fridays
     */
    public boolean isOnFridays() {
        return onFridays;
    }

    /**
     * @param onFridays boolean that indicates if the program will run on
     * Fridays
     */
    public void setOnFridays(boolean onFridays) {
        this.onFridays = onFridays;
    }

    /**
     * @return boolean that indicates if the program will run on Saturdays
     */
    public boolean isOnSaturdays() {
        return onSaturdays;
    }

    /**
     * @param onSaturdays boolean that indicates if the program will run on
     * Saturdays
     */
    public void setOnSaturdays(boolean onSaturdays) {
        this.onSaturdays = onSaturdays;
    }

    /**
     * @return boolean that indicates if the program will run on Sundays
     */
    public boolean isOnSundays() {
        return onSundays;
    }

    /**
     * @param onSundays boolean that indicates if the program will run on
     * Sundays
     */
    public void setOnSundays(boolean onSundays) {
        this.onSundays = onSundays;
    }

    /**
     * @return Time in which the program will start running
     */
    public Time getStartTime() {
        return startTime;
    }

    /**
     *
     * @param startTime Time in which the program will start running
     */
    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    /**
     * @return Time in which the program will stop running
     */
    public Time getEndTime() {
        return endTime;
    }

    /**
     * @param endTime Time in which the program will stop running
     */
    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    /**
     * @return desired setpoint temperature in Celsius for the program
     */
    public float getSetpointCelsius() {
        return setpointCelsius;
    }

    /**
     * @param setpointCelsius desired setpoint temperature in Celsius for the
     * program
     */
    public void setSetpointCelsius(float setpointCelsius) {
        this.setpointCelsius = setpointCelsius;
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
}
