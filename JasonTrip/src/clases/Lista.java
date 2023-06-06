/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.List;

/**
 * Esta clase guarda las listas de un usuario. Las listas son las cosas que
 * tiene hacer un usuario.
 *
 * @author xDoble_Jx
 */
public class Lista {

    //********** ATRIBUTOS **********/
    /**
     * Identificador unico de cada lista.
     */
    private String id_lista;

    /**
     * Titulo de la lista. Para que el usuario pueda diferenciar facilmente sus
     * listas.
     */
    private String titulo;

    /**
     * Breve descripcion del contenido de cada lista.
     */
    private String descripcion;

    /**
     * Usuario que ha creado la lista.
     */
    private String usuario;

    /**
     * Lista de actividades que tiene cada lista.
     */
    private List<Actividad> actividades;

    //********** METODOS **********/
    /**
     * Este metodo devuelve todos los datos de una lista
     *
     * @return informacion de la lista
     */
    @Override
    public String toString() {
        return "Lista{" + "id_lista=" + id_lista + ", titulo=" + titulo + ", descripcion=" + descripcion + ", usuario=" + usuario + ", actividades=" + actividades + '}';
    }

    //********** GETTERS && SETTERS **********/
    public String getId_lista() {
        return id_lista;
    }

    public void setId_lista(String id_lista) {
        this.id_lista = id_lista;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }

}
