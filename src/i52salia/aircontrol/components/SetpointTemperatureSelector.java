package i52salia.aircontrol.components;

import i52salia.aircontrol.utils.Temperature;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Java Swing Component (JPanel) to select the setpoint temperature of an AC.
 *
 * (Most of the code was automatically generated by NetBeans).
 *
 * @author Andrés Salinas Lima (i52salia@uco.es)
 */
public final class SetpointTemperatureSelector extends javax.swing.JPanel {

    private Temperature temperature;
    private Temperature.TempUnit tempUnit;

    /**
     * Creates and initializes the JPanel.
     */
    public SetpointTemperatureSelector() {
        initComponents();

        // Initialize members randomly to avoid null pointer exceptions
        temperature = new Temperature(21, Temperature.TempUnit.CELSIUS);
        tempUnit = Temperature.TempUnit.CELSIUS;

        addChangeListener((ChangeEvent e) -> {
            updateTemperatureMember();
        });
    }

    /**
     * Sets the temperature shown by the spinner.
     * 
     * @param temperature
     */
    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;

        switch (tempUnit) {
            case CELSIUS:
                celsiusSpinner.setValue(temperature.getTemperature(tempUnit));
                break;
            case FAHRENHEIT:
                fahrenheitSpinner.setValue((int) temperature.getTemperature(tempUnit));
                break;
            default:
                throw new UnsupportedOperationException();
        }
    }

    /**
     * Adapts the spinners to the desired temperature unit.
     * 
     * @param tempUnit
     */
    public void setUnit(Temperature.TempUnit tempUnit) {
        this.tempUnit = tempUnit;

        switch (tempUnit) {
            case CELSIUS:
                celsiusPanel.setVisible(true);
                fahrenheitPanel.setVisible(false);
                break;
            case FAHRENHEIT:
                celsiusPanel.setVisible(false);
                fahrenheitPanel.setVisible(true);
                break;
            default:
                throw new UnsupportedOperationException();
        }
    }

    /**
     * @return the temperature selected on the spinners
     */
    public Temperature getTemperature() {
        return temperature;
    }

    /**
     * Adds a changeListener to all the spinners.
     * 
     * @param l
     */
    public void addChangeListener(ChangeListener l) {
        celsiusSpinner.addChangeListener(l);
        fahrenheitSpinner.addChangeListener(l);
    }

    /**
     * Allows to enable/disable the spinners.
     * 
     * @param b 
     */
    @Override
    public void setEnabled(boolean b) {
        celsiusSpinner.setEnabled(b);
        fahrenheitSpinner.setEnabled(b);
        celsiusLabel.setEnabled(b);
        fahrenheitLabel.setEnabled(b);
    }

    private void updateTemperatureMember() {
        switch (tempUnit) {
            case CELSIUS:
                temperature.setTemperature(
                        (double) celsiusSpinner.getValue(), tempUnit);
                break;
            case FAHRENHEIT:
                temperature.setTemperature(
                        (double) (int) fahrenheitSpinner.getValue(), tempUnit);
                break;
            default:
                throw new UnsupportedOperationException();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        celsiusPanel = new javax.swing.JPanel();
        celsiusSpinner = new javax.swing.JSpinner();
        celsiusLabel = new javax.swing.JLabel();
        fahrenheitPanel = new javax.swing.JPanel();
        fahrenheitSpinner = new javax.swing.JSpinner();
        fahrenheitLabel = new javax.swing.JLabel();

        setLayout(new javax.swing.OverlayLayout(this));

        celsiusSpinner.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        celsiusSpinner.setModel(new javax.swing.SpinnerNumberModel(21.0d, 10.0d, 30.0d, 0.5d));
        celsiusSpinner.setPreferredSize(new java.awt.Dimension(70, 28));
        celsiusPanel.add(celsiusSpinner);

        celsiusLabel.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        celsiusLabel.setText("ºC");
        celsiusPanel.add(celsiusLabel);

        add(celsiusPanel);

        fahrenheitSpinner.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        fahrenheitSpinner.setModel(new javax.swing.SpinnerNumberModel(70, 50, 90, 1));
        fahrenheitSpinner.setPreferredSize(new java.awt.Dimension(70, 28));
        fahrenheitPanel.add(fahrenheitSpinner);

        fahrenheitLabel.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        fahrenheitLabel.setText("ºF");
        fahrenheitPanel.add(fahrenheitLabel);

        add(fahrenheitPanel);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel celsiusLabel;
    private javax.swing.JPanel celsiusPanel;
    private javax.swing.JSpinner celsiusSpinner;
    private javax.swing.JLabel fahrenheitLabel;
    private javax.swing.JPanel fahrenheitPanel;
    private javax.swing.JSpinner fahrenheitSpinner;
    // End of variables declaration//GEN-END:variables
}