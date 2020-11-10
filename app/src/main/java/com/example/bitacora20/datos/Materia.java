package com.example.bitacora20.datos;

import java.util.ArrayList;
import java.util.Date;

import static com.example.bitacora20.datos.Investigacion.investigaciones;
import static com.example.bitacora20.datos.Ejercicio.ejercicios;
import static com.example.bitacora20.datos.Item.items;
import static com.example.bitacora20.datos.Tema.temas;

public class Materia {
    private int idMateria;
    private String nombre;
    private String descripcion;
    private String profesor;
    private ArrayList<Usuario> usuariosIntegrantes;

    // Carga de Datos
    public static Materia materia1;
    public static Materia materia2;
    public static Materia materia3;
    public static ArrayList<Materia> materias1 = new ArrayList<>();

    public static Tema tema1;
    public static Tema tema2;
    public static Tema tema3;
    public static ArrayList<Tema> temas1 = new ArrayList<>();
    public static ArrayList<Tema> temas2 = new ArrayList<>();
    public static ArrayList<Tema> temas3 = new ArrayList<>();

    public static Investigacion investigacion1;
    public static Investigacion investigacion2;
    public static Investigacion investigacion3;
    public static ArrayList<Investigacion> investigaciones1 = new ArrayList<>();

    public static Ejercicio ejercicio1;
    public static Ejercicio ejercicio2;
    public static Ejercicio ejercicio3;
    public static ArrayList<Ejercicio> ejercicios1 = new ArrayList<>();

    public static Item item1;
    public static Item item2;
    public static Item item3;
    public static ArrayList<Item> items1 = new ArrayList<>();


   /* Date unDate = new Date();*/


    public static ArrayList<Materia> materias = new ArrayList<>();

    static {

        investigacion1 = new Investigacion("tema1", "sehr gut", 89, "keine", 15);
        investigacion2 = new Investigacion("tema1", "buen trabajo", 45, "muchas", 5);
        investigacion3 = new Investigacion("tema1", "sehr gut", 89, "keine", 15);
        investigaciones.add(investigacion1);
        investigaciones.add(investigacion2);
        investigaciones.add(investigacion3);

        ejercicio1 = new Ejercicio("satisfactoria experiencia", 89, "ninguna duda", 16);
        ejercicio2 = new Ejercicio("insatisfactoria experiencia", 89, "ninguna duda", 16);
        ejercicio3 = new Ejercicio("n/a", 89, "ninguna duda", 16);
        ejercicios.add(ejercicio1);
        ejercicios.add(ejercicio2);
        ejercicios.add(ejercicio3);

        item1 = new Item("Guerra Fría", "Conflicto no violento entre los EEUU y la USSR", "ninguna duda", true);
        item2 = new Item("Triple Alianza", "Conflicto armado entre Paraguay y la Alianza de Brasil, Argentina, Uruguay", "ninguna duda", true);
        item3 = new Item("Carrera Espacial", "una carrera en el espacio :p", "ninguna duda", false);
        items.add(item1);
        items.add(item2);
        items.add(item3);


        tema1 = new Tema(1, "Alemán", "2012/01/11");
        tema2 = new Tema(2, "Proyecto TIC", "zwÖlf Mai");
        tema3 = new Tema(3, "Logistica", "12 Feb");
        temas.add(tema1);
        temas.add(tema2);
        temas.add(tema3);

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
