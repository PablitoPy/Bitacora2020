package com.example.bitacora20.datos;

import java.util.ArrayList;
import java.util.Date;

public class Materia {
    private int id;
    private String nombre;
    private String descripcion;
    private ArrayList<Usuario> usuariosIntegrantes;
    public static Materia materia1;
    public static Materia materia2;
    public static Materia materia3;

    public static ArrayList<Materia> materias = new ArrayList<>();

    static {
        Usuario unUsuario = new Usuario("pepe", "Carlos", "correo@mail.com", "123", "000000");
        materia1 = new Materia(1, "Alemán", "Aleman A2", unUsuario);
        materia2 = new Materia(2, "Proyecto TIC", "Desarrollo de apps", unUsuario);
        materia3 = new Materia(3, "Logistica", "Módulo final", unUsuario);
        materias.add(materia1);
        materias.add(materia2);
        materias.add(materia3);
    }

    public Materia(int id, String nombre, String descripcion, Usuario creador) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        usuariosIntegrantes = new ArrayList<>();
        usuariosIntegrantes.add( creador );
    }

    public static void agregarMateria( Materia unaMateria ) {
        materias.add( unaMateria );
    }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int cantidadIntegrantes(){
        int cantidad = 0;

        if(usuariosIntegrantes != null){
            cantidad = usuariosIntegrantes.size();
        }
        return cantidad;
    }

    public static ArrayList<Materia> getMaterias() {
        return materias;
    }
}
