package i52salia.aircontrol.utils;

/**
 * A class to handle time frames (the period between a start time and an end
 * time).
 *
 * @author Andrés Salinas Lima (i52salia@uco.es)
 */
public final class TimeFrame {

    private Time startTime;
    private Time endTime;

    /**
     * @param startTime start time of the time period
     * @param endTime end time of the time period
     */
    public TimeFrame(Time startTime, Time endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * @return startTime start time of the time period
     */
    public Time getStartTime() {
        return startTime;
    }

    /**
     * @param startTime start time of the time period
     */
    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    /**
     * @return end time of the time period
     */
    public Time getEndTime() {
        return endTime;
    }

    /**
     * @param endTime end time of the time period
     */
    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    /**
     * @param timeFormat desired time format
     * @return a formatted string with the start and end times of the time frame
     */
    public String getString(Time.TimeFormat timeFormat) {
        String str = "";

        str += startTime.getString(timeFormat);
        str += " - ";
        str += endTime.getString(timeFormat);

        return str;
    }
}
