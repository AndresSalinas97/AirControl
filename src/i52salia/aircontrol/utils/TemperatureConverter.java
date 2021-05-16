package i52salia.aircontrol.utils;

import java.text.DecimalFormat;

/**
 * A class with methods to convert and print temperature values.
 *
 * @author Andrés Salinas Lima {@literal <i52salia@uco.es>}
 */
public final class TemperatureConverter {

    /**
     * @param celsius temperature in Celsius
     * @return string with the temperature in Celsius with 2 decimal points
     */
    public final static String celsiusToCelsiusString(double celsius) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");

        return (decimalFormat.format(celsius) + " ºC");
    }
}
