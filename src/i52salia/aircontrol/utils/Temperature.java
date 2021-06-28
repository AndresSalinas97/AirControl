package i52salia.aircontrol.utils;

import java.text.DecimalFormat;

/**
 * Class to handle temperature values in both Celsius and Fahrenheit.
 *
 * @author Andrés Salinas Lima (i52salia@uco.es)
 */
public final class Temperature {

    /**
     * Available temperature units.
     */
    public static enum TempUnit {

        /**
         * Celsius.
         */
        CELSIUS,
        /**
         * Fahrenheit.
         */
        FAHRENHEIT
    }

    private double celsius; // Temperature is internally stored in celsius

    /**
     * @param temp temperature value
     * @param tempUnit temperature unit
     */
    public Temperature(double temp, TempUnit tempUnit) {
        celsius = convert(temp, tempUnit, TempUnit.CELSIUS);
    }

    /**
     * @param tempUnit desired output temperature unit
     * @return temperature value
     */
    public double getTemperature(TempUnit tempUnit) {
        return convert(celsius, TempUnit.CELSIUS, tempUnit);
    }

    /**
     * @param temp temperature value
     * @param tempUnit temperature unit
     */
    public void setTemperature(double temp, TempUnit tempUnit) {
        celsius = convert(temp, tempUnit, TempUnit.CELSIUS);
    }

    /**
     * Converts temperature value to a different temperature unit.
     *
     * @param temp input temperature value
     * @param inUnit input temperature unit
     * @param outUnit output temperature unit
     * @return output temperature value
     */
    public final static double convert(double temp, TempUnit inUnit, TempUnit outUnit) {
        if (inUnit == outUnit) {
            return temp;
        } else if (inUnit == TempUnit.CELSIUS && outUnit == TempUnit.FAHRENHEIT) {
            return temp / 5 * 9 + 32;
        } else if (inUnit == TempUnit.FAHRENHEIT && outUnit == TempUnit.CELSIUS) {
            return (temp - 32) * 5 / 9;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * @param unit desired output temperature unit
     * @return a string with the formatted temperature value and unit
     */
    public String getString(TempUnit unit) {
        switch (unit) {
            case CELSIUS:
                DecimalFormat oneDecimalFormat = new DecimalFormat("#.0");
                double c_value = getTemperature(TempUnit.CELSIUS);

                return (oneDecimalFormat.format(c_value) + " ºC");
            case FAHRENHEIT:
                return ((int)getTemperature(TempUnit.FAHRENHEIT) + " ºF");
            default:
                throw new UnsupportedOperationException();
        }
    }
}
