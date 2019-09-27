package mx.its.myfirstapplication.data;

import android.support.annotation.NonNull;

import java.io.Serializable;

public class Encuesta implements Serializable {
    private String nombre;
    private int calificacion;
    private float rating;

    public Encuesta(String nombre, int calificacion, float rating) {
        this.nombre = nombre;
        this.calificacion = calificacion;
        this.rating = rating;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @NonNull
    @Override
    public String toString() {
        return nombre +" "+calificacion+" "+rating;
    }
}
