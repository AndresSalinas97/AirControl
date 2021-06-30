package i52salia.aircontrol.utils;

import java.awt.Component;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;

/**
 * A class to help with the creation of dialog boxes.
 * 
 * @author Andrés Salinas Lima (i52salia@uco.es)
 */
public class DialogBoxes {

    /**
     * Shows an error dialog box with the introduced message.
     * 
     * @param parent the JFrame that owns the dialog box
     * @param m the message to be shown
     */
    public final static void showErrrorMessage(Component parent, String m) {
        ResourceBundle bundle = ResourceBundle.getBundle(
                "i52salia/aircontrol/resources/languagebundles/Bundle");

        JOptionPane.showMessageDialog(
                parent,
                m,
                bundle.getString("DialogBoxes.ErrorTitle"),
                JOptionPane.WARNING_MESSAGE
        );
    }

    /**
     * Shows a yes/no deletion confirmation dialog box.
     * 
     * @param parent the JFrame that owns the dialog box
     * @return true if the user clicked on the 'yes' option
     */
    public final static boolean confirmDeletion(Component parent) {
        ResourceBundle bundle = ResourceBundle.getBundle(
                "i52salia/aircontrol/resources/languagebundles/Bundle");

        int result = JOptionPane.showConfirmDialog(
                parent,
                bundle.getString("DialogBoxes.DeleteQuestion"),
                bundle.getString("DialogBoxes.DeleteTitle"),
                JOptionPane.YES_NO_OPTION
        );

        return result == 0;
    }
}
