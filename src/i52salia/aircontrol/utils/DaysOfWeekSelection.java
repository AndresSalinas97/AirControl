package i52salia.aircontrol.utils;

import java.util.ResourceBundle;

/**
 * A class to handle a selection of days of the week.
 *
 * @author Andrés Salinas Lima (i52salia@uco.es)
 */
public final class DaysOfWeekSelection {

    private boolean onMondays;
    private boolean onTuesdays;
    private boolean onWednesdays;
    private boolean onThursdays;
    private boolean onFridays;
    private boolean onSaturdays;
    private boolean onSundays;

    /**
     * Constructor with every day set to false.
     */
    public DaysOfWeekSelection() {
        onMondays = false;
        onTuesdays = false;
        onWednesdays = false;
        onThursdays = false;
        onFridays = false;
        onSaturdays = false;
        onSundays = false;
    }

    /**
     * Constructor to initialize with the desired selection.
     *
     * @param onMondays boolean that indicates if the selection includes Mondays
     * @param onTuesdays boolean that indicates if the selection includes
     * Tuesdays
     * @param onWednesdays boolean that indicates if the selection includes
     * Wednesdays
     * @param onThursdays boolean that indicates if the selection includes
     * Thursdays
     * @param onFridays boolean that indicates if the selection includes Fridays
     * @param onSaturdays boolean that indicates if the selection includes
     * Saturdays
     * @param onSundays boolean that indicates if the selection includes Sundays
     */
    public DaysOfWeekSelection(boolean onMondays, boolean onTuesdays,
            boolean onWednesdays, boolean onThursdays, boolean onFridays,
            boolean onSaturdays, boolean onSundays) {
        this.onMondays = onMondays;
        this.onTuesdays = onTuesdays;
        this.onWednesdays = onWednesdays;
        this.onThursdays = onThursdays;
        this.onFridays = onFridays;
        this.onSaturdays = onSaturdays;
        this.onSundays = onSundays;
    }

    /**
     * @return boolean that indicates if the selection includes Mondays
     */
    public boolean isOnMondays() {
        return onMondays;
    }

    /**
     * @param onMondays boolean that indicates if the selection includes Mondays
     */
    public void setOnMondays(boolean onMondays) {
        this.onMondays = onMondays;
    }

    /**
     * @return boolean that indicates if the selection includes Tuesdays
     */
    public boolean isOnTuesdays() {
        return onTuesdays;
    }

    /**
     * @param onTuesdays boolean that indicates if the selection includes
     * Tuesdays
     */
    public void setOnTuesdays(boolean onTuesdays) {
        this.onTuesdays = onTuesdays;
    }

    /**
     * @return boolean that indicates if the selection includes Wednesdays
     */
    public boolean isOnWednesdays() {
        return onWednesdays;
    }

    /**
     * @param onWednesdays boolean that indicates if the selection includes
     * Wednesdays
     */
    public void setOnWednesdays(boolean onWednesdays) {
        this.onWednesdays = onWednesdays;
    }

    /**
     * @return boolean that indicates if the selection includes Thursdays
     */
    public boolean isOnThursdays() {
        return onThursdays;
    }

    /**
     * @param onThursdays boolean that indicates if the selection includes
     * Thursdays
     */
    public void setOnThursdays(boolean onThursdays) {
        this.onThursdays = onThursdays;
    }

    /**
     * @return boolean that indicates if the selection includes Fridays
     */
    public boolean isOnFridays() {
        return onFridays;
    }

    /**
     * @param onFridays boolean that indicates if the selection includes Fridays
     */
    public void setOnFridays(boolean onFridays) {
        this.onFridays = onFridays;
    }

    /**
     * @return boolean that indicates if the selection includes Saturdays
     */
    public boolean isOnSaturdays() {
        return onSaturdays;
    }

    /**
     * @param onSaturdays boolean that indicates if the selection includes
     * Saturdays
     */
    public void setOnSaturdays(boolean onSaturdays) {
        this.onSaturdays = onSaturdays;
    }

    /**
     * @return boolean that indicates if the selection includes Sundays
     */
    public boolean isOnSundays() {
        return onSundays;
    }

    /**
     * @param onSundays boolean that indicates if the selection includes Sundays
     */
    public void setOnSundays(boolean onSundays) {
        this.onSundays = onSundays;
    }

    /**
     * @return A formatted and localized string with the selection
     */
    public String getString() {
        ResourceBundle bundle = ResourceBundle.getBundle(
                "i52salia/aircontrol/resources/languagebundles/Bundle");
                
        String str = "";

        if (onMondays && onTuesdays && onWednesdays && onThursdays
                && onFridays && onSaturdays && onSundays) {
            str = bundle.getString("DaysOfWeekSelection.Everyday");
        } else if (onMondays && onTuesdays && onWednesdays && onThursdays
                && onFridays && !onSaturdays && !onSundays) {
            str = bundle.getString("DaysOfWeekSelection.Weekdays");
        } else if (!onMondays && !onTuesdays && !onWednesdays && !onThursdays
                && !onFridays && onSaturdays && onSundays) {
            str = bundle.getString("DaysOfWeekSelection.Weekends");
        } else {
            boolean first = true;

            if (onMondays) {
                str += bundle.getString("DaysOfWeekSelection.Mon");
                first = false;
            }
            if (onTuesdays) {
                if (!first) {
                    str += ", ";
                }
                str += bundle.getString("DaysOfWeekSelection.Tue");
                first = false;
            }
            if (onWednesdays) {
                if (!first) {
                    str += ", ";
                }
                str += bundle.getString("DaysOfWeekSelection.Wed");
                first = false;
            }
            if (onThursdays) {
                if (!first) {
                    str += ", ";
                }
                str += bundle.getString("DaysOfWeekSelection.Thu");
                first = false;
            }
            if (onFridays) {
                if (!first) {
                    str += ", ";
                }
                str += bundle.getString("DaysOfWeekSelection.Fri");
                first = false;
            }
            if (onSaturdays) {
                if (!first) {
                    str += ", ";
                }
                str += bundle.getString("DaysOfWeekSelection.Sat");
                first = false;
            }
            if (onSundays) {
                if (!first) {
                    str += ", ";
                }
                str += bundle.getString("DaysOfWeekSelection.Sun");
            }
        }

        return str;
    }
}
