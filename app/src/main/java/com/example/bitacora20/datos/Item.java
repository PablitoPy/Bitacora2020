package com.example.bitacora20.datos;

import java.util.ArrayList;

public class Item {
    private int id;
    private String concepto;
    private String descripcion;
    private String dudas;
    private boolean aprendido;


    public static ArrayList<Item> items = new ArrayList<>();


    public Item(int id, String concepto, String descripcion, String dudas, boolean aprendido) {
        this.id = id;
        this.concepto = concepto;
        this.descripcion = descripcion;
        this.dudas = dudas;
        this.aprendido = aprendido;
    }

    public Item(String concepto, String descripcion, String dudas, boolean aprendido) {
        this.concepto = concepto;
        this.descripcion = descripcion;
        this.dudas = dudas;
        this.aprendido = aprendido;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDudas() {
        return dudas;
    }

    public void setDudas(String dudas) {
        this.dudas = dudas;
    }

    public boolean isAprendido() {
        return aprendido;
    }

    public void setAprendido(boolean aprendido) {
        this.aprendido = aprendido;
    }

    public static ArrayList<Item> getItems() {
        return items;
    }

    public static void setItems(ArrayList<Item> items) {
        Item.items = items;
    }
}


