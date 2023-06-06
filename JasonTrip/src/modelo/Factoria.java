package modelo;

/**
 * Esta clase es una factoria.
 *
 * @author xDoble_Jx
 */
public class Factoria {

    /**
     * Devuelve la interfaz de la implementacion de la logica de negoccio de la
     * base de datos.
     *
     * @return interfaz de la logica de negocio.
     */
    public static DAO getDAO() {
        DAO dao = new DAOImplementacionBD();
        return dao;
    }
}
