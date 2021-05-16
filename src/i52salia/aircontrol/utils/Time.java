package i52salia.aircontrol.utils;

/**
 * A simple class to deal with time, both in 24-hour and 12-hour formats.
 *
 * @author Andrés Salinas Lima {@literal <i52salia@uco.es>}
 */
public final class Time {

    /**
     * Indicates the day period (AM or PM) when using 12-hour clock.
     */
    public enum DayPeriod {

        /**
         * From Latin "ante meridiem", translating to "before midday".
         */
        AM,
        /**
         * From Latin "post meridiem", translating to "after midday".
         */
        PM
    }

    private int hour;
    private int minute;

    /**
     * Constructor for the Time class using 24-hour format.
     *
     * @param hour hour (integer from 0 to 23)
     * @param minute minute (integer from 0 to 59)
     */
    public Time(int hour, int minute) {
        setTime(hour, minute);
    }

    /**
     * Constructor for the Time class using 12-hour format.
     *
     * @param hour hour (integer from 1 to 12)
     * @param minute minute (integer from 0 to 59)
     * @param period DayPeriod (AM or PM)
     */
    public Time(int hour, int minute, DayPeriod period) {
        setTime(hour, minute, period);
    }

    /**
     * Sets the time using 24-hour format.
     *
     * @param hour hour (integer from 0 to 23)
     * @param minute minute (integer from 0 to 59)
     *
     * @throws IllegalArgumentException if the hour or minute values aren't
     * correct for the 24-hour format
     */
    public void setTime(int hour, int minute) {
        if (hour < 0 || hour > 23) {
            throw new IllegalArgumentException(
                    "Hour value must be between 0 and 23");
        }
        if (minute < 0 || minute > 59) {
            throw new IllegalArgumentException(
                    "Minute value must be between 0 and 59");
        }

        this.hour = hour;
        this.minute = minute;
    }

    /**
     * Sets the time using 12-hour format.
     *
     * @param hour hour (integer from 1 to 12)
     * @param minute minute (integer from 0 to 59)
     * @param period DayPeriod (AM or PM)
     *
     * @throws IllegalArgumentException if the hour or minute values aren't
     * correct for the 12-hour format
     */
    public void setTime(int hour, int minute, DayPeriod period) {
        if (hour < 1 || hour > 12) {
            throw new IllegalArgumentException(
                    "Hour value must be between 1 and 12");
        }
        if (minute < 0 || minute > 59) {
            throw new IllegalArgumentException(
                    "Minute value must be between 0 and 59");
        }

        this.minute = minute;

        if (hour == 12) {
            if (period == DayPeriod.AM) {
                this.hour = 0;
            } else {
                this.hour = 12;
            }
        } else {
            if (period == DayPeriod.AM) {
                this.hour = hour;
            } else {
                this.hour = hour + 12;
            }
        }
    }

    /**
     * @return the hour using 24-hour format
     */
    public int get24Hour() {
        return hour;
    }

    /**
     * @return the hour using 12-hour format
     */
    public int get12Hour() {
        if (hour == 0 || hour == 12) {
            return 12;
        } else if (hour > 12) {
            return hour - 12;
        } else {
            return hour;
        }
    }

    /**
     * @return the DayPeriod (AM or PM)
     */
    public DayPeriod getDayPeriod() {
        if (hour < 12) {
            return DayPeriod.AM;
        } else {
            return DayPeriod.PM;
        }
    }

    /**
     * @return the minute
     */
    public int getMinute() {
        return minute;
    }

    /**
     * @return a string with the time in 24-hour format
     */
    public String get24HourString() {
        String str = "";

        str += get24Hour();
        str += ":";
        if (getMinute() == 0) {
            str += "00";
        } else {
            str += getMinute();
        }

        return str;
    }

    /**
     * @return a string with the time in 12-hour format
     */
    public String get12HourString() {
        String str = "";

        str += get12Hour();
        str += ":";
        if (getMinute() == 0) {
            str += "00";
        } else {
            str += getMinute();
        }
        str += " ";
        str += getDayPeriod();

        return str;
    }
}
