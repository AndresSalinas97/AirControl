package i52salia.aircontrol.components;

import java.awt.event.ActionListener;

/**
 * A simple Java Swing Component (JPanel) of an On/Off button.
 *
 * (Most of the code was automatically generated by NetBeans).
 *
 * @author Andrés Salinas Lima {@literal <i52salia@uco.es>}
 */
public class OnOffButton extends javax.swing.JPanel {

    private boolean turnedOn;

    /**
     * Constructor for the OnOffButton class.
     */
    public OnOffButton() {
        initComponents();
        turnOff();

        button.addActionListener(e -> turn());
    }

    /**
     * @return boolean indicating if the button is turned On or Off
     */
    public boolean isTurnedOn() {
        return turnedOn;
    }

    /**
     * @param turnedOn boolean indicating if the button is turned On or Off
     */
    public void setTurnedOn(boolean turnedOn) {
        if (turnedOn) {
            turnOn();
        } else {
            turnOff();
        }
    }

    /**
     * Switch the current button state (it will turn On if it was Off and vice
     * versa).
     */
    public void turn() {
        setTurnedOn(!turnedOn);
    }

    /**
     * Allows to add an ActionListener to the button.
     *
     * @param l ActionListener
     */
    public void addActionListener(ActionListener l) {
        button.addActionListener(l);
    }

    /**
     * Allows to enable/disable the button.
     *
     * @param b boolean indicating the button's enability
     */
    public void setEnabled(boolean b) {
        button.setEnabled(b);
    }

    private void turnOn() {
        turnedOn = true;

        button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/i52salia/aircontrol/resources/images/on-icon.png")));

        //button.setForeground(new java.awt.Color(0, 153, 0));
        button.setText("(ON)");
    }

    private void turnOff() {
        turnedOn = false;

        button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/i52salia/aircontrol/resources/images/off-icon.png")));

        //button.setForeground(new java.awt.Color(255, 0, 0));
        button.setText("(OFF)");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button = new javax.swing.JButton();

        setLayout(new java.awt.GridLayout(1, 0));

        button.setFont(new java.awt.Font("Ubuntu", 2, 12)); // NOI18N
        button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/i52salia/aircontrol/resources/images/off-icon.png"))); // NOI18N
        button.setText("(OFF)");
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionPerformed(evt);
            }
        });
        add(button);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button;
    // End of variables declaration//GEN-END:variables
}
