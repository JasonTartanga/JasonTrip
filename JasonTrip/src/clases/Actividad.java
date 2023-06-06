/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.io.File;
import java.time.LocalDate;
import java.util.List;

/**
 * Esta clase gurada las actividades de una lista. Las actividades son las
 * tareas que tiene cada lista.
 *
 * @author xDoble_Jx
 */
public class Actividad {

    //********** ATRIBUTOS **********/
    /**
     * Identificador unico de cada actividad.
     */
    private String id_actividad;

    /**
     * Nombre de la actividad.
     */
    private String titulo;

    /**
     * Breve descripcion de la actividad.
     */
    private String descripcion;

    /**
     * Ubicacion donde transcurre la actividad.
     */
    private String ubicacion;

    /**
     * Lista con todas las fotos de la actividad.
     */
    private List<File> fotos;

    /**
     * Fecha en la que transcurre la actividad.
     */
    private LocalDate dia;

    //********** METODOS **********/
    /**
     * Este metodo devuelve toda la informacion de una actividad.
     *
     * @return la informacion de la actividad.
     */
    @Override
    public String toString() {
        return "Actividad{" + "id_actividad=" + id_actividad + ", titulo=" + titulo + ", descripcion=" + descripcion + ", ubicacion=" + ubicacion + ", fotos=" + fotos + ", dia=" + dia + '}';
    }

    //********** GETTERS && SETTERS **********/
    public String getId_actividad() {
        return id_actividad;
    }

    public void setId_actividad(String id_actividad) {
        this.id_actividad = id_actividad;
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

}
