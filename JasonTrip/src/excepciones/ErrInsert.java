package excepciones;

import recursos.LookVentana.VentanaError;

/**
 * Genera una excepcion para los errores a la hora de insertar datos en la base
 * de datos.
 *
 * @author xDoble_Jx
 */
public class ErrInsert extends Exception {

    private String mensaje;

    /**
     * Asigna el mensaje adecuado en base al error.
     *
     * @param tabla Es la tabla donde esta el fallo para generar asi el mensaje
     */
    public ErrInsert(String tabla) {
        System.out.println("excepciones.ErrInsert.<init>()");
        switch (tabla) {
            case "usuario":
                mensaje = "Lo sentimos, ha ocurrido un error a la hora de registrarte. Intentelo de nuevo en otro momento";
                break;
            default:
                mensaje = "Ha ocurrido un error inseperado a la hora de guardar algo de la base de datos";
        }
    }

    /**
     * Este metodo muestra la ventana del error
     */
    public void mostrarError() {
        VentanaError vm = new VentanaError(mensaje);
    }
}
