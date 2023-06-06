package excepciones;

import recursos.LookVentana.VentanaError;

/**
 * Genera una excepcion para los errores a la inesperados. Asigna el mensaje
 * adecuado en base al error.
 *
 * @author xDoble_Jx
 */
public class ErrExtra extends Exception {

    private String mensaje;

    /**
     * Asigna el mensaje adecuado en base al error.
     *
     * @param razon Es la razon del fallo para generar asi el mensaje.
     */
    public ErrExtra(String razon) {

        switch (razon) {

            case "conexion":
                mensaje = "Ha ocurrido un error a la hora de conectarse con la base de datos";
                break;
            case "usuario":
                mensaje = "El usuario que se esta utilizando para conectarse a la bda es erroneo";
                break;
            case "fichero":
                mensaje = "No se ha encontrado un fichero necesario para el funcionamiento de la aplicacion";
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
