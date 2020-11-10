package com.example.bitacora20.datos;

import java.util.ArrayList;
import java.util.Date;

public class Tema {
private int id;
private String nombre;
private String fecha;


public static Tema tema1;
public static Tema tema2;
public static Tema tema3;

public static ArrayList<Tema> temas = new ArrayList<>();



    public Tema(int id, String nombre, String fecha){
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
    }

    public Tema(String nombre, String fecha){
        this.nombre = nombre;
        this.fecha = fecha;
    }

    public static void agregarTema(Tema unTema ) {
        temas.add( unTema );
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public static ArrayList<Tema> getTemas() {
        return temas;
    }

    public static void setTemas(ArrayList<Tema> temas) {
        Tema.temas = temas;
    }
}
