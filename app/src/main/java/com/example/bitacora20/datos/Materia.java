package com.example.bitacora20.datos;

import java.util.ArrayList;
import java.util.Date;

public class Materia {
    private int idMateria;
    private String nombre;
    private String descripcion;
    private String profesor;
    private ArrayList<Usuario> usuariosIntegrantes;
    public static Materia materia1;
    public static Materia materia2;
    public static Materia materia3;

    public static ArrayList<Materia> materias = new ArrayList<>();

    static {
        Usuario unUsuario = new Usuario("pepe", "Carlos", "correo@mail.com", "123", "000000");
        materia1 = new Materia(1, "Alemán", "Aleman A2", "Hans", unUsuario);
        materia2 = new Materia(2, "Proyecto TIC", "Desarrollo de apps", "Guido", unUsuario);
        materia3 = new Materia(3, "Logistica", "Módulo final", "Eladio", unUsuario);
        materias.add(materia1);
        materias.add(materia2);
        materias.add(materia3);
    }

    public Materia(Integer idMateria,String nombre, String descripcion, String profesor, Usuario creador) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.profesor = profesor;
        usuariosIntegrantes = new ArrayList<>();
        usuariosIntegrantes.add( creador );
    }

    public Materia(String nombre, String descripcion, String profesor, Usuario creador) {
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

    public static void agregarMateria(Materia unaMateria ) {
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

    public static ArrayList<Materia> getMaterias() {
        return materias;
    }
}
