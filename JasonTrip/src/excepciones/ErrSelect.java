package excepciones;

import recursos.LookVentana.VentanaError;

/**
 * Genera una excepcion para los errores a la hora de recuperar datos de la base
 * de datos.
 *
 * @author xDoble_Jx
 */
public class ErrSelect extends Exception {

    private String mensaje;

    /**
     * Asigna el mensaje adecuado en base al error.
     *
     * @param tabla Es la tabla donde esta el fallo para generar asi el mensaje.
     */
    public ErrSelect(String tabla) {

        switch (tabla) {
            case "usuario":
                mensaje = "Lo sentimos, ha ocurrido un error a la hora de recuperar datos sobre tu usuario";
                break;
            default:
                mensaje = "Ha ocurrido un error inseperado a la hora de buscar algo en la base de datos";
        }
    }

    /**
     * Este metodo muestra la ventana del error.
     */
    public void mostrarError() {
        VentanaError vm = new VentanaError(mensaje);
    }
}
