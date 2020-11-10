package com.example.bitacora20.datos;

import java.util.ArrayList;
import java.util.Date;

public class Investigacion {
    private int id;
    private String tema;
    private String comentario;
    private int comprension;
    private String dudas;
    private int tiempoDedicado;



    public static ArrayList<Investigacion> investigaciones = new ArrayList<>();


    public Investigacion(int id, String tema, String comentario, int comprension, String dudas, int tiempoDedicado) {
    this.id = id;
    this.tema = tema;
    this.comentario = comentario;
    this.comprension = comprension;
    this.dudas = dudas;
    this.tiempoDedicado = tiempoDedicado;
    }

    public Investigacion(String tema, String comentario, int comprension, String dudas, int tiempoDedicado) {
        this.tema = tema;
        this.comentario = comentario;
        this.comprension = comprension;
        this.dudas = dudas;
        this.tiempoDedicado = tiempoDedicado;
    }

    public static ArrayList<Investigacion> getInvestigaciones() {
        return investigaciones;
    }

    public static void setInvestigaciones(ArrayList<Investigacion> investigaciones) {
        Investigacion.investigaciones = investigaciones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getComprension() {
        return comprension;
    }

    public void setComprension(int comprension) {
        this.comprension = comprension;
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
}
