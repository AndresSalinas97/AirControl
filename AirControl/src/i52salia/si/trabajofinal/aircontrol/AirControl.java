package i52salia.si.trabajofinal.aircontrol;

/**
 * Trabajo Final de Prácticas de la Asignatura de Sistemas Interactivos
 *
 * Interface of a mobile app to control air conditioning systems implemented
 * with Java Swing.
 *
 * @author Andrés Salinas Lima {@literal <i52salia@uco.es>}
 */
public final class AirControl {

    /**
     * The main function: starts the application.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Assemble all the pieces of the MVC
        new AirControlController(new AirControlModel(), new AirControlView());
    }
}
