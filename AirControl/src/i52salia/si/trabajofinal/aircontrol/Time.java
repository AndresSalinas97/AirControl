package i52salia.si.trabajofinal.aircontrol;

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
     */
    public void setTime(int hour, int minute) {
        assert (hour >= 0 && hour <= 23);
        assert (minute >= 0 && minute <= 59);

        this.hour = hour;
        this.minute = minute;
    }

    /**
     * Sets the time using 12-hour format.
     * 
     * @param hour hour (integer from 1 to 12)
     * @param minute minute (integer from 0 to 59)
     * @param period DayPeriod (AM or PM)
     */
    public void setTime(int hour, int minute, DayPeriod period) {
        assert (hour >= 1 && hour <= 12);
        assert (minute >= 0 && minute <= 59);
        
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
}