package mx.its.firtsapp;

import java.io.Serializable;

public class Pojo implements Serializable {
    private float currentRating;
    private int color;
    private String nombre;

    public Pojo(float currentRating, int color, String nombre) {
        this.currentRating = currentRating;
        this.color = color;
        this.nombre = nombre;
    }

    public float getCurrentRating() {
        return currentRating;
    }

    public void setCurrentRating(float currentRating) {
        this.currentRating = currentRating;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
