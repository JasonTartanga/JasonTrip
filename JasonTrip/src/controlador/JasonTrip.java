package controlador;

import modelo.DAO;
import modelo.Factoria;
import vista.VMain;

/**
 * Esta clase es el controlador de toda la aplicacion.
 *
 * @author xDoble_Jx
 */
public class JasonTrip {

    /**
     * Empieza la aplicacion.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DAO dao = Factoria.getDAO();
        VMain vMain = new VMain(dao);
        vMain.setVisible(true);
    }

}
