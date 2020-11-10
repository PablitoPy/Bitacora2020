package com.example.bitacora20.datos;

import java.util.ArrayList;

public class Ejercicio {
    private int id;
    private String experiencia;
    private int logrado;
    private String dudas;
    private int tiempoDedicado;


    public static ArrayList<Ejercicio> ejercicios = new ArrayList<>();


    public Ejercicio(int id, String experiencia, int logrado, String dudas, int tiempoDedicado) {
        this.id = id;
        this.experiencia = experiencia;
        this.logrado = logrado;
        this.dudas = dudas;
        this.tiempoDedicado = tiempoDedicado;
    }

    public Ejercicio(String experiencia, int logrado, String dudas, int tiempoDedicado) {
        this.experiencia = experiencia;
        this.logrado = logrado;
        this.dudas = dudas;
        this.tiempoDedicado = tiempoDedicado;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public int getLogrado() {
        return logrado;
    }

    public void setLogrado(int logrado) {
        this.logrado = logrado;
    }

    public String getDudas() {
        return dudas;
    }

    public void setDudas(String dudas) {
        this.dudas = dudas;
    }

    public int getTiempoDedicado() {
        return tiempoDedicado;
    }

    public void setTiempoDedicado(int tiempoDedicado) {
        this.tiempoDedicado = tiempoDedicado;
    }

    public static ArrayList<Ejercicio> getEjercicios() {
        return ejercicios;
    }

    public static void setEjercicios(ArrayList<Ejercicio> ejercicios) {
        Ejercicio.ejercicios = ejercicios;
    }
}

