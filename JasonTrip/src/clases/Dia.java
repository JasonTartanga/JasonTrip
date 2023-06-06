/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Esta clase guarda los dias en los que han sucedido actividades y las
 * estadisticas fisicas que el usuario ha tenido ese dia.
 *
 * @author xDoble_Jx
 */
public class Dia {

    //********** ATRIBUTOS **********/
    /**
     * Fecha del dia en el que estamos.
     */
    private LocalDate fecha;

    /**
     * Identificador del usuario al que "pertenece" el dia
     */
    private String usuario;

    /**
     * Numero de kilometros que se ha desplazado en ese dia.
     */
    private float km;

    /**
     * Numero de horas que ha estado haciendo actividades ese dia.
     */
    private LocalTime horas;

    /**
     * Numero de kilo calorias que ha quemado el usuario ese dia.
     */
    private float kcal;

    /**
     * Numero de pasos que ha dado el usuario ese dia.
     */
    private int pasos;

    //********** METODOS **********/
    /**
     * Este metodo devuelve toda la informacion de un dia
     *
     * @return la informacion del dia
     */
    @Override
    public String toString() {
        return "Dia{" + "fecha=" + fecha + ", usuario=" + usuario + ", km=" + km + ", horas=" + horas + ", kcal=" + kcal + ", pasos=" + pasos + '}';
    }

    //********** GETTERS && SETTERS **********/
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public float getKm() {
        return km;
    }

    public void setKm(float km) {
        this.km = km;
    }

    public LocalTime getHoras() {
        return horas;
    }

    public void setHoras(LocalTime horas) {
        this.horas = horas;
    }

    public float getKcal() {
        return kcal;
    }

    public void setKcal(float kcal) {
        this.kcal = kcal;
    }

    public int getPasos() {
        return pasos;
    }

    public void setPasos(int pasos) {
        this.pasos = pasos;
    }

}
