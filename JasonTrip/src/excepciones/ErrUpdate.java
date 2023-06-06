package excepciones;

import recursos.LookVentana.VentanaError;

/**
 * Genera una excepcion para los errores a la hora de modificar datos de la base
 * de datos.
 *
 * @author xDoble_Jx
 */
public class ErrUpdate extends Exception {

    private String mensaje;

    /**
     *
     * Asigna el mensaje adecuado en base al error.
     *
     * @param tabla Es la tabla donde esta el fallo para generar asi el mensaje.
     */
    public ErrUpdate(String tabla) {

        switch (tabla) {
            case "usuario":
                mensaje = "Lo sentimos, ha ocurrido un error a la modificar tu perfil. Intentelo de nuevo en otro momento";
                break;
            default:
                mensaje = "Ha ocurrido un error inseperado a la hora de modificar algo de la base de datos";
        }
    }

    /**
     * Este metodo muestra la ventana del error.
     */
    public void mostrarError() {
        VentanaError vm = new VentanaError(mensaje);
    }
}
