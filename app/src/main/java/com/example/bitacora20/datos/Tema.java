package com.example.bitacora20.datos;

import java.util.ArrayList;
import java.util.Date;

public class Tema {
    private int id;
private String nombre;
private String fecha;
private static Tema temaLogueado;
private ArrayList<Item> itemscargados;
private ArrayList<Investigacion> investigacionescargados;
private ArrayList<Ejercicio> ejercicioscargados;


    public Tema(int id, String nombre, String fecha, Item creado1, Investigacion creado2, Ejercicio creado3 ){
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        itemscargados = new ArrayList<>();
        itemscargados.add( creado1 );
        investigacionescargados = new ArrayList<>();
        investigacionescargados.add( creado2 );
        ejercicioscargados = new ArrayList<>();
        ejercicioscargados.add( creado3 );
    }


    public Tema(String nombre, String fecha, Item creado1, Investigacion creado2, Ejercicio creado3 ){
        this.nombre = nombre;
        this.fecha = fecha;
        itemscargados = new ArrayList<>();
        itemscargados.add( creado1 );
        investigacionescargados = new ArrayList<>();
        investigacionescargados.add( creado2 );
        ejercicioscargados = new ArrayList<>();
        ejercicioscargados.add( creado3 );
    }

    public Tema(String nombre, String fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
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



    public ArrayList<Item> getItemscargados() {
        return itemscargados;
    }

    public void setItemscargados(ArrayList<Item> itemscargados) {
        this.itemscargados = itemscargados;
    }

    public ArrayList<Investigacion> getInvestigacionescargados() {
        return investigacionescargados;
    }

    public void setInvestigacionescargados(ArrayList<Investigacion> investigacionescargados) {
        this.investigacionescargados = investigacionescargados;
    }

    public ArrayList<Ejercicio> getEjercicioscargados() {
        return ejercicioscargados;
    }

    public void setEjercicioscargados(ArrayList<Ejercicio> ejercicioscargados) {
        this.ejercicioscargados = ejercicioscargados;
    }
}
