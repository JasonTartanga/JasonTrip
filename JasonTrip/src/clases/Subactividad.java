/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.io.File;
import java.time.LocalDate;
import java.util.List;

/**
 * Esta clase guarda las subadctividades de una actividad. Las subactividades
 * son las tareas que tienen cada tarea y que aparecen con sangria.
 *
 * @author xDoble_Jx
 */
public class Subactividad {

    //********** ATRIBUTOS **********/
    /**
     * Identificador unico de cada subactividad.
     */
    private String id_subactividad;

    /**
     * Nombre de la subsubactividad.
     */
    private String titulo;

    /**
     * Breve descripcion de la subactividad.
     */
    private String descripcion;

    /**
     * Ubicacion donde transcurre la subactividad.
     */
    private String ubicacion;

    /**
     * Lista con todas las fotos de la subactividad.
     */
    private List<File> fotos;

    /**
     * Fecha en la que transcurre la subactividad.
     */
    private LocalDate dia;

    /**
     * Actividad padre.
     */
    private String id_actividad;

    //********** METODOS **********/
    /**
     * Este metodo devuelve toda la informacion de una subactividad.
     *
     * @return la informacion de una subactividad.
     */
    @Override
    public String toString() {
        return "Subactividad{" + "id_subactividad=" + id_subactividad + ", titulo=" + titulo + ", descripcion=" + descripcion + ", ubicacion=" + ubicacion + ", fotos=" + fotos + ", dia=" + dia + ", actividad=" + id_actividad + '}';
    }

    //********** GETTERS && SETTERS **********/
    public String getId_subactividad() {
        return id_subactividad;
    }

    public void setId_subactividad(String id_subactividad) {
        this.id_subactividad = id_subactividad;
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

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<File> getFotos() {
        return fotos;
    }

    public void setFotos(List<File> fotos) {
        this.fotos = fotos;
    }

    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }

    public String getId_actividad() {
        return id_actividad;
    }

    public void setId_actividad(String id_actividad) {
        this.id_actividad = id_actividad;
    }

}
