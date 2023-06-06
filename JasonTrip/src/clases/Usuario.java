package clases;

import java.io.File;
import java.time.LocalDate;

/**
 * Esta clase guardar la informacion de los usuarios.
 *
 * @author xDoble_Jx
 */
public class Usuario {

    //********** ATRIBUTOS **********/
    /**
     * Identificador unico de los usuarios.
     */
    private String id_usuario;

    /**
     * Contraseña del usuario para poder iniciar sesion.
     */
    private String contrasenia;

    /**
     * Nombre del usuario.
     */
    private String nombre;

    /**
     * Apellido del usuario.
     */
    private String apellido;

    /**
     * DNI del usuario.
     */
    private String dni;

    /**
     * Correo electronico del usuario
     */
    private String correo;

    /**
     * Fecha de nacimiento del usuario.
     */
    private LocalDate fecha_nac;

    /**
     * Foto de perfil del usuario.
     */
    private File icono;

    //********** METODOS **********/
    /**
     * Este metodo devueleve todos los datos de un usuario.
     *
     * @return la informacion del usuario.
     */
    @Override
    public String toString() {
        return "Usuario{" + "id_usuario=" + id_usuario + "contrasenia=" + contrasenia + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", correo=" + correo + ", fecha_nac=" + fecha_nac + ", icono=" + icono + '}';
    }

    //********** GETTERS && SETTERS **********/
    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public LocalDate getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(LocalDate fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public File getIcono() {
        return icono;
    }

    public void setIcono(File icono) {
        this.icono = icono;
    }

}
