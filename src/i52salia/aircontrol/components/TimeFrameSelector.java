package i52salia.aircontrol.components;

import i52salia.aircontrol.utils.Time;
import i52salia.aircontrol.utils.TimeFrame;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeListener;

/**
 * Java Swing Component (JPanel) to select the time frame of an AC program.
 *
 * (Much of the code was automatically generated by NetBeans).
 *
 * @author Andrés Salinas Lima (i52salia@uco.es)
 */
public final class TimeFrameSelector extends javax.swing.JPanel {

    private Time.TimeFormat timeFormat;

    /**
     * Creates and initializes the JPanel.
     */
    public TimeFrameSelector() {
        initComponents();
       
        // To avoid null pointer exceptions
        timeFormat = Time.TimeFormat.TF24HOUR;
        setTimeFormat(timeFormat);
    }

    /**
     * @return the time frame selected by the user.
     */
    public TimeFrame getTimeFrame() {
        int startHour, startMinute, endHour, endMinute;
        Time.DayPeriod startDayPeriod, endDayPeriod;
        Time startTime, endTime;

        switch (timeFormat) {
            case TF24HOUR:
                startHour = (int) startHour24Spinner.getValue();
                startMinute = (int) startMinute24Spinner.getValue();
                endHour = (int) endHour24Spinner.getValue();
                endMinute = (int) endMinute24Spinner.getValue();

                startTime = new Time(startHour, startMinute);
                endTime = new Time(endHour, endMinute);

                return new TimeFrame(startTime, endTime);
            case TF12HOUR:
                startHour = (int) startHour12Spinner.getValue();
                startMinute = (int) startMinute12Spinner.getValue();
                endHour = (int) endHour12Spinner.getValue();
                endMinute = (int) endMinute12Spinner.getValue();

                if (startDayPeriodBox.getSelectedIndex() == 0) {
                    startDayPeriod = Time.DayPeriod.AM;
                } else {
                    startDayPeriod = Time.DayPeriod.PM;
                }
                if (endDayPeriodBox.getSelectedIndex() == 0) {
                    endDayPeriod = Time.DayPeriod.AM;
                } else {
                    endDayPeriod = Time.DayPeriod.PM;
                }

                startTime = new Time(startHour, startMinute, startDayPeriod);
                endTime = new Time(endHour, endMinute, endDayPeriod);

                return new TimeFrame(startTime, endTime);
            default:
                throw new UnsupportedOperationException();
        }
    }

    /**
     * @param timeFrame the time frame to be shown to the user
     */
    public void setTimeFrame(TimeFrame timeFrame) {
        int startHour, startMinute, endHour, endMinute;
        Time.DayPeriod startDayPeriod, endDayPeriod;

        switch (timeFormat) {
            case TF24HOUR:
                startHour = timeFrame.getStartTime().get24Hour();
                startMinute = timeFrame.getStartTime().getMinute();
                endHour = timeFrame.getEndTime().get24Hour();
                endMinute = timeFrame.getEndTime().getMinute();

                startHour24Spinner.setValue(startHour);
                startMinute24Spinner.setValue(startMinute);
                endHour24Spinner.setValue(endHour);
                endMinute24Spinner.setValue(endMinute);

                break;
            case TF12HOUR:
                startHour = timeFrame.getStartTime().get12Hour();
                startMinute = timeFrame.getStartTime().getMinute();
                endHour = timeFrame.getEndTime().get12Hour();
                endMinute = timeFrame.getEndTime().getMinute();

                startDayPeriod = timeFrame.getStartTime().getDayPeriod();
                endDayPeriod = timeFrame.getEndTime().getDayPeriod();

                startHour12Spinner.setValue(startHour);
                startMinute12Spinner.setValue(startMinute);
                endHour12Spinner.setValue(endHour);
                endMinute12Spinner.setValue(endMinute);

                if (startDayPeriod == Time.DayPeriod.AM) {
                    startDayPeriodBox.setSelectedIndex(0);
                } else {
                    startDayPeriodBox.setSelectedIndex(1);

                }
                if (endDayPeriod == Time.DayPeriod.AM) {
                    endDayPeriodBox.setSelectedIndex(0);
                } else {
                    endDayPeriodBox.setSelectedIndex(1);
                }

                break;
            default:
                throw new UnsupportedOperationException();
        }
    }

    /**
     * @param timeFormat the time format that will be used
     */
    public void setTimeFormat(Time.TimeFormat timeFormat) {
        this.timeFormat = timeFormat;

        switch (timeFormat) {
            case TF24HOUR:
                tf24HourPanel.setVisible(true);
                tf12HourPanel.setVisible(false);
                break;
            case TF12HOUR:
                tf24HourPanel.setVisible(false);
                tf12HourPanel.setVisible(true);
                break;
            default:
                throw new UnsupportedOperationException();
        }
    }

    /**
     * Allows to add a changeListener to the spinners
     *
     * @param l
     */
    public void addChangeListener(ChangeListener l) {
        startHour24Spinner.addChangeListener(l);
        startMinute24Spinner.addChangeListener(l);
        endHour24Spinner.addChangeListener(l);
        endMinute24Spinner.addChangeListener(l);
        startHour12Spinner.addChangeListener(l);
        startMinute12Spinner.addChangeListener(l);
        endHour12Spinner.addChangeListener(l);
        endMinute12Spinner.addChangeListener(l);
    }

    /**
     * Allows to add an actionListener to the comboBoxes
     *
     * @param l
     */
    public void addActionListener(ActionListener l) {
        startDayPeriodBox.addActionListener(l);
        endDayPeriodBox.addActionListener(l);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tf24HourPanel = new javax.swing.JPanel();
        startTimePanel24 = new javax.swing.JPanel();
        startHour24Spinner = new javax.swing.JSpinner();
        dotsLabel1 = new javax.swing.JLabel();
        startMinute24Spinner = new javax.swing.JSpinner();
        endTimePanel24 = new javax.swing.JPanel();
        endHour24Spinner = new javax.swing.JSpinner();
        dotsLabel2 = new javax.swing.JLabel();
        endMinute24Spinner = new javax.swing.JSpinner();
        tf12HourPanel = new javax.swing.JPanel();
        startTimePanel12 = new javax.swing.JPanel();
        startHour12Spinner = new javax.swing.JSpinner();
        dotsLabel3 = new javax.swing.JLabel();
        startMinute12Spinner = new javax.swing.JSpinner();
        invisibleSeparator1 = new javax.swing.JSeparator();
        startDayPeriodBox = new javax.swing.JComboBox();
        endTimePanel12 = new javax.swing.JPanel();
        endHour12Spinner = new javax.swing.JSpinner();
        dotsLabel4 = new javax.swing.JLabel();
        endMinute12Spinner = new javax.swing.JSpinner();
        invisibleSeparator2 = new javax.swing.JSeparator();
        endDayPeriodBox = new javax.swing.JComboBox();

        setLayout(new javax.swing.OverlayLayout(this));

        startTimePanel24.setBorder(javax.swing.BorderFactory.createTitledBorder("Start Time"));

        startHour24Spinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 23, 1));
        startTimePanel24.add(startHour24Spinner);

        dotsLabel1.setText(":");
        startTimePanel24.add(dotsLabel1);

        startMinute24Spinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 5));
        startTimePanel24.add(startMinute24Spinner);

        tf24HourPanel.add(startTimePanel24);

        endTimePanel24.setBorder(javax.swing.BorderFactory.createTitledBorder("End Time"));

        endHour24Spinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 23, 1));
        endTimePanel24.add(endHour24Spinner);

        dotsLabel2.setText(":");
        endTimePanel24.add(dotsLabel2);

        endMinute24Spinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 5));
        endTimePanel24.add(endMinute24Spinner);

        tf24HourPanel.add(endTimePanel24);

        add(tf24HourPanel);

        startTimePanel12.setBorder(javax.swing.BorderFactory.createTitledBorder("Start Time"));

        startHour12Spinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));
        startTimePanel12.add(startHour12Spinner);

        dotsLabel3.setText(":");
        startTimePanel12.add(dotsLabel3);

        startMinute12Spinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 5));
        startTimePanel12.add(startMinute12Spinner);

        invisibleSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        invisibleSeparator1.setBorder(null);
        invisibleSeparator1.setPreferredSize(new java.awt.Dimension(5, 0));
        startTimePanel12.add(invisibleSeparator1);

        startDayPeriodBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AM", "PM" }));
        startTimePanel12.add(startDayPeriodBox);

        tf12HourPanel.add(startTimePanel12);

        endTimePanel12.setBorder(javax.swing.BorderFactory.createTitledBorder("End Time"));

        endHour12Spinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));
        endTimePanel12.add(endHour12Spinner);

        dotsLabel4.setText(":");
        endTimePanel12.add(dotsLabel4);

        endMinute12Spinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 5));
        endTimePanel12.add(endMinute12Spinner);

        invisibleSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        invisibleSeparator2.setBorder(null);
        invisibleSeparator2.setPreferredSize(new java.awt.Dimension(5, 0));
        endTimePanel12.add(invisibleSeparator2);

        endDayPeriodBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AM", "PM" }));
        endTimePanel12.add(endDayPeriodBox);

        tf12HourPanel.add(endTimePanel12);

        add(tf12HourPanel);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dotsLabel1;
    private javax.swing.JLabel dotsLabel2;
    private javax.swing.JLabel dotsLabel3;
    private javax.swing.JLabel dotsLabel4;
    private javax.swing.JComboBox endDayPeriodBox;
    private javax.swing.JSpinner endHour12Spinner;
    private javax.swing.JSpinner endHour24Spinner;
    private javax.swing.JSpinner endMinute12Spinner;
    private javax.swing.JSpinner endMinute24Spinner;
    private javax.swing.JPanel endTimePanel12;
    private javax.swing.JPanel endTimePanel24;
    private javax.swing.JSeparator invisibleSeparator1;
    private javax.swing.JSeparator invisibleSeparator2;
    private javax.swing.JComboBox startDayPeriodBox;
    private javax.swing.JSpinner startHour12Spinner;
    private javax.swing.JSpinner startHour24Spinner;
    private javax.swing.JSpinner startMinute12Spinner;
    private javax.swing.JSpinner startMinute24Spinner;
    private javax.swing.JPanel startTimePanel12;
    private javax.swing.JPanel startTimePanel24;
    private javax.swing.JPanel tf12HourPanel;
    private javax.swing.JPanel tf24HourPanel;
    // End of variables declaration//GEN-END:variables
}
