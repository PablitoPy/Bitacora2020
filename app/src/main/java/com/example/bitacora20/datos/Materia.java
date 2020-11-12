package com.example.bitacora20.datos;

import java.util.ArrayList;


public class Materia {
    private int idMateria;
    private String nombre;
    private String descripcion;
    private String profesor;

    private ArrayList<Tema> temas;
    private ArrayList<Usuario> usuariosIntegrantes;


    public Materia(Integer idMateria,String nombre, String descripcion, String profesor, Usuario creador, ArrayList temas) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.profesor = profesor;
        usuariosIntegrantes = new ArrayList<>();
        usuariosIntegrantes.add( creador );
        this.temas = temas;
    }

    public Materia(String nombre, String descripcion, String profesor, Usuario creador ) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.profesor = profesor;
        usuariosIntegrantes = new ArrayList<>();
        usuariosIntegrantes.add( creador );
    }


    public ArrayList<Usuario> getUsuariosIntegrantes() {
        return usuariosIntegrantes;
    }

    public void setUsuariosIntegrantes(ArrayList<Usuario> usuariosIntegrantes) {
        this.usuariosIntegrantes = usuariosIntegrantes;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
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

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public int cantidadIntegrantes(){
        int cantidad = 0;

        if(usuariosIntegrantes != null){
            cantidad = usuariosIntegrantes.size();
        }
        return cantidad;
    }

    public ArrayList<Tema> getTemas() {
        return temas;
    }

    public void setTemas(ArrayList<Tema> temascargados) {
        this.temas = temascargados;
    }

}
