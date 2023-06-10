package modelo;

import clases.Lista;
import clases.Usuario;
import excepciones.ErrExtra;
import excepciones.ErrInsert;
import excepciones.ErrSelect;
import excepciones.ErrUpdate;
import java.util.List;

/**
 * Esta interfaz es la logica de negocio de la aplicacion
 *
 * @author xDoble_Jx
 */
public interface DAO {

    //********** INSERT ***********/
    /**
     * Guarda los datos de un usuario en la base de datos.
     *
     * @param usu el usuario que quieres guardar.
     * @throws ErrExtra una excepcion por si hay algun error a la hora de
     * conectarse con la base de datos.
     * @throws ErrInsert una excepcion por si hay algun error a la hora de
     * insertar el usuario.
     */
    public void registrarUsuario(Usuario usu) throws ErrExtra, ErrInsert;

    public void insertarLista(Lista list) throws ErrExtra, ErrInsert;

    //********** UPDATE ***********/
    public void editarTituloLista(String id_lista, String titulo) throws ErrExtra, ErrUpdate;

    //********** DELETE ***********/
    //********** SELECT ***********/
    /**
     * Busca en la base de datos el nombre y la contraseña de un usuario. Si
     * coinciden devuelve un usuario y se inicia sesion, si no no.
     *
     * @param usuario el nombre del usuario.
     * @param contrasenia la contraseña del usuario.
     * @return el usuario que tiene ese nombre y contraseña.
     * @throws ErrExtra una excepcion por si hay algun error a la hora de
     * conectarse con la base de datos.
     * @throws ErrSelect una excepcion por si hay algun error a la hora de
     * buscar datos en la base de datos.
     */
    public Usuario iniciarSesion(String usuario, String contrasenia) throws ErrExtra, ErrSelect;

    /**
     * Busca la id del ultimo usuario y le suma 1
     *
     * @return la id del nuevo usuario
     * @throws ErrExtra una excepcion por si hay un error a la hora de
     * conectarse con la base de datos.
     * @throws ErrSelect una excepcion por si hay algun error a la hora de
     * buscar datos.
     */
    public String generarIdUsuario() throws ErrExtra, ErrSelect;

    public String generarIdLista() throws ErrExtra, ErrSelect;

    public List<Lista> listarListasUsuario(String id_usuario) throws ErrExtra, ErrSelect;

}
