package excepciones;

import recursos.LookVentana.VentanaError;

/**
 * Genera una excepcion para los errores a la hora de eliminar datos de la base
 * de datos.
 *
 * @author xDoble_Jx
 */
public class ErrDelete extends Exception {

    private String mensaje;

    /**
     *
     * Asigna el mensaje adecuado en base al error.
     *
     * @param tabla Es la tabla donde esta el fallo para generar asi el mensaje.
     */
    public ErrDelete(String tabla) {

        switch (tabla) {
            case "usuario":
                mensaje = "Lo sentimos, ha ocurrido un error a la hora de eliminar tu cuenta";
                break;
            default:
                mensaje = "Ha ocurrido un error inseperado a la hora de eliminar algo de la base de datos";
        }
    }

    /**
     * Este metodo muestra la ventana del error.
     */
    public void mostrarError() {
        VentanaError vm = new VentanaError(mensaje);
    }
}
