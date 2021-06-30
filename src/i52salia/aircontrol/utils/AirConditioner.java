package i52salia.aircontrol.utils;

import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Class to hold the information, settings and current state of an air
 * conditioning device.
 *
 * @author Andrés Salinas Lima (i52salia@uco.es)
 */
public final class AirConditioner {

    /**
     * Possible modes of the air conditioning device.
     */
    public static enum Mode {

        /**
         * Cooling mode.
         */
        COOL,
        /**
         * Fan mode.
         */
        FAN,
        /**
         * Dehumidifier mode.
         */
        DRY,
        /**
         * Heating mode.
         */
        HEAT,
        /**
         * Automatic mode.
         */
        AUTO
    }

    /**
     * Possible fan speeds of the air conditioning device.
     */
    public static enum FanSpeed {

        /**
         * Low speed.
         */
        LOW,
        /**
         * Medium speed.
         */
        MEDIUM,
        /**
         * High speed.
         */
        HIGH,
        /**
         * Automatic speed.
         */
        AUTO
    }

    private boolean turnedOn;
    private Mode mode;
    private FanSpeed fanSpeed;
    private Temperature setpointTemp;
    private Temperature currentTemp;
    private String givenName;
    private final String modelName;
    private final String modelNumber;
    private final String serialNumber;
    private final boolean hasVerticalVanes;
    private final boolean hasHorizontalVanes;
    private boolean verticalVanesSwinging;
    private boolean horizontalVanesSwinging;
    private final ArrayList<ACProgram> programs;

    /**
     * Constructor of the AirConditioner class.
     *
     * @param givenName given name of the air conditioning device
     * @param modelName model name of the air conditioning device
     * @param modelNumber model number (or code) of the air conditioning device
     * @param serialNumber serial number (or code) of the air conditioning
     * device
     * @param hasVerticalVanes a boolean indicating whether the air conditioning
     * device has swinging vertical vanes or not
     * @param hasHorizontalVanes a boolean indicating whether the air
     * conditioning device has swinging horizontal vanes or not
     */
    public AirConditioner(String givenName, String modelName, String modelNumber,
            String serialNumber, boolean hasVerticalVanes,
            boolean hasHorizontalVanes) {
        this.givenName = givenName;
        this.modelName = modelName;
        this.modelNumber = modelNumber;
        this.serialNumber = serialNumber;
        this.hasVerticalVanes = hasVerticalVanes;
        this.hasHorizontalVanes = hasHorizontalVanes;

        this.turnedOn = false;
        this.mode = Mode.AUTO;
        this.fanSpeed = FanSpeed.AUTO;
        this.setpointTemp = new Temperature(21, Temperature.TempUnit.CELSIUS);
        this.currentTemp = new Temperature(
                getRandomCurrentCelsius(), Temperature.TempUnit.CELSIUS);
        this.horizontalVanesSwinging = false;
        this.verticalVanesSwinging = false;
        this.programs = new ArrayList<>();
    }

    /**
     * @return a random temperature float value between 5 and 35
     */
    private float getRandomCurrentCelsius() {
        float min = 10;
        float max = 30;

        return (float) (min + Math.random() * (max - min));
    }

    /**
     * @return a boolean indicating if the device is turned on
     */
    public boolean isTurnedOn() {
        return turnedOn;
    }

    /**
     * @param turnedOn a boolean indicating if the device is turned on
     */
    public void setTurnedOn(boolean turnedOn) {
        this.turnedOn = turnedOn;
    }

    /**
     * @return currently selected Mode of the device
     */
    public Mode getMode() {
        return mode;
    }

    /**
     * @param mode currently selected Mode of the device
     */
    public void setMode(Mode mode) {
        this.mode = mode;
    }

    /**
     * @return currently selected FanSpeed of the device
     */
    public FanSpeed getFanSpeed() {
        return fanSpeed;
    }

    /**
     * @param fanSpeed currently selected FanSpeed of the device
     */
    public void setFanSpeed(FanSpeed fanSpeed) {
        this.fanSpeed = fanSpeed;
    }

    /**
     * @return currently selected setpoint temperature
     */
    public Temperature getSetpointTemp() {
        return setpointTemp;
    }

    /**
     * @param setpointTemp desired setpoint temperature
     */
    public void setSetpointTemp(Temperature setpointTemp) {
        this.setpointTemp = setpointTemp;
    }

    /**
     * @return current temperature in Celsius measured by the device
     */
    public Temperature getCurrentTemp() {
        return currentTemp;
    }

    /**
     * @param currentTemp current temperature in Celsius measured by the device
     */
    public void setCurrentTemp(Temperature currentTemp) {
        this.currentTemp = currentTemp;
    }

    /**
     * @return device name given by the user
     */
    public String getGivenName() {
        return givenName;
    }

    /**
     * @param givenName device name given by the user
     */
    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    /**
     * @return a boolean indicating if the vertical vanes are currently set to
     * swing
     */
    public boolean isVerticalVanesSwinging() {
        return verticalVanesSwinging;
    }

    /**
     * @param verticalVanesSwing a boolean indicating if the vertical vanes are
     * currently set to swing
     */
    public void setVerticalVanesSwinging(boolean verticalVanesSwing) {
        this.verticalVanesSwinging = verticalVanesSwing;
    }

    /**
     * @return a boolean indicating if the horizontal vanes are currently set to
     * swing
     */
    public boolean isHorizontalVanesSwinging() {
        return horizontalVanesSwinging;
    }

    /**
     * @param HorizontalVanesSwing a boolean indicating if the horizontal vanes
     * are currently set to swing
     */
    public void setHorizontalVanesSwinging(boolean HorizontalVanesSwing) {
        this.horizontalVanesSwinging = HorizontalVanesSwing;
    }

    /**
     * @return the model name of the device
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * @return the model number (or code) of the device
     */
    public String getModelNumber() {
        return modelNumber;
    }

    /**
     *
     * @return the serial number (or code) of the device
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * @return a boolean indicating whether the air conditioning device has
     * swinging vertical vanes or not
     */
    public boolean hasVerticalVanes() {
        return hasVerticalVanes;
    }

    /**
     * @return a boolean indicating whether the air conditioning device has
     * swinging horizontal vanes or not
     */
    public boolean hasHorizontalVanes() {
        return hasHorizontalVanes;
    }

    /**
     * @return the programs ArrayList
     */
    public ArrayList<ACProgram> getPrograms() {
        return programs;
    }

    /**
     * @param mode desired AC mode
     * @return a formatted and localized string with the introduced mode
     */
    public final static String getModeString(Mode mode) {
        ResourceBundle bundle = ResourceBundle.getBundle(
                "i52salia/aircontrol/resources/languagebundles/Bundle");

        String str = bundle.getString("AirConditioner.Mode");
        str += ": ";

        switch (mode) {
            case COOL:
                return str + bundle.getString("AirConditioner.Mode.Cool");
            case FAN:
                return str + bundle.getString("AirConditioner.Mode.Fan");
            case DRY:
                return str + bundle.getString("AirConditioner.Mode.Dry");
            case HEAT:
                return str + bundle.getString("AirConditioner.Mode.Heat");
            case AUTO:
                return str + bundle.getString("AirConditioner.Mode.Auto");
            default:
                throw new UnsupportedOperationException();
        }
    }

    /**
     * @param fanSpeed desired AC fan speed
     * @return a formatted and localized string with the introduced fan speed
     */
    public final static String getFanSpeedString(FanSpeed fanSpeed) {
        ResourceBundle bundle = ResourceBundle.getBundle(
                "i52salia/aircontrol/resources/languagebundles/Bundle");

        String str = bundle.getString("AirConditioner.FanSpeed");
        str += ": ";

        switch (fanSpeed) {
            case LOW:
                return str + bundle.getString("AirConditioner.FanSpeed.Low");
            case MEDIUM:
                return str + bundle.getString("AirConditioner.FanSpeed.Medium");
            case HIGH:
                return str + bundle.getString("AirConditioner.FanSpeed.High");
            case AUTO:
                return str + bundle.getString("AirConditioner.FanSpeed.Auto");
            default:
                throw new UnsupportedOperationException();
        }
    }

    /**
     * @return a formatted and localized string with the currently selected mode
     */
    public String getModeString() {
        return getModeString(mode);
    }

    /**
     * @return a formatted and localized string with the currently selected fan
     * speed
     */
    public String getFanSpeedString() {
        return getFanSpeedString(fanSpeed);
    }
}
