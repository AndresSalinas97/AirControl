/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i52salia.si.trabajofinal.aircontrol;

/**
 *
 * @author andres
 */
public class HomePanel extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel
     */
    public HomePanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        devicesListMainPanel = new javax.swing.JPanel();
        scrollPanePanel = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        programsList = new javax.swing.JPanel();
        devicesListButtonsPanel = new javax.swing.JPanel();
        addDeviceButton = new javax.swing.JButton();
        programMainPanel = new javax.swing.JPanel();

        setLayout(new javax.swing.OverlayLayout(this));

        devicesListMainPanel.setLayout(new java.awt.BorderLayout());

        scrollPanePanel.setLayout(new java.awt.GridLayout(1, 0));

        programsList.setLayout(new javax.swing.BoxLayout(programsList, javax.swing.BoxLayout.LINE_AXIS));
        scrollPane.setViewportView(programsList);

        scrollPanePanel.add(scrollPane);

        devicesListMainPanel.add(scrollPanePanel, java.awt.BorderLayout.CENTER);

        devicesListButtonsPanel.setLayout(new java.awt.GridBagLayout());

        addDeviceButton.setText("Add New Device");
        devicesListButtonsPanel.add(addDeviceButton, new java.awt.GridBagConstraints());

        devicesListMainPanel.add(devicesListButtonsPanel, java.awt.BorderLayout.SOUTH);

        add(devicesListMainPanel);

        programMainPanel.setEnabled(false);
        programMainPanel.setLayout(new javax.swing.BoxLayout(programMainPanel, javax.swing.BoxLayout.Y_AXIS));
        add(programMainPanel);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addDeviceButton;
    private javax.swing.JPanel devicesListButtonsPanel;
    private javax.swing.JPanel devicesListMainPanel;
    private javax.swing.JPanel programMainPanel;
    private javax.swing.JPanel programsList;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JPanel scrollPanePanel;
    // End of variables declaration//GEN-END:variables
}