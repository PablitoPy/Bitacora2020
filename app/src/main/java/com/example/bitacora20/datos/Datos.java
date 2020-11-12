package com.example.bitacora20.datos;

import android.util.Log;

import java.util.ArrayList;


import com.example.bitacora20.utils.LogUtils;

public class Datos {

    // Carga de Datos
    public static Materia materia1;
    public static Materia materia2;
    public static Materia materia3;
    public static ArrayList<Materia> materias1 = new ArrayList<>();

    public static Tema tema1;
    public static Tema tema2;
    public static Tema tema3;
    public static Tema tema4;
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
        investigaciones1.add(investigacion1);
        investigaciones1.add(investigacion2);
        investigaciones1.add(investigacion3);

        ejercicio1 = new Ejercicio("satisfactoria experiencia", 89, "ninguna duda", 16);
        ejercicio2 = new Ejercicio("insatisfactoria experiencia", 89, "ninguna duda", 16);
        ejercicio3 = new Ejercicio("n/a", 89, "ninguna duda", 16);
        ejercicios1.add(ejercicio1);
        ejercicios1.add(ejercicio2);
        ejercicios1.add(ejercicio3);

        item1 = new Item("Guerra Fría", "Conflicto no violento entre los EEUU y la USSR", "ninguna duda", true);
        item2 = new Item("Triple Alianza", "Conflicto armado entre Paraguay y la Alianza de Brasil, Argentina, Uruguay", "ninguna duda", true);
        item3 = new Item("Carrera Espacial", "una carrera en el espacio :p", "ninguna duda", false);
        items1.add(item1);
        items1.add(item2);
        items1.add(item3);


        tema1 = new Tema(1, "Logaritmica", "2012/01/11", item1, investigacion1,ejercicio1);
        tema2 = new Tema(2, "Trigonometria", "zwÖlf Mai",item2, investigacion2,ejercicio2);
        tema3 = new Tema(3, "Geometria", "12 Feb", item3, investigacion3,ejercicio3);
        tema4 = new Tema(4, "test", "20 Feb", item3, investigacion3,ejercicio3);
        temas1.add(tema1);
        temas2.add(tema2);
        temas3.add(tema3);


        Usuario unUsuario = new Usuario("pepe", "Carlos", "correo@mail.com", "123", "000000");
        materia1 = new Materia(1, "Matematica", "Matematica I y II", "Hans", unUsuario, temas1);
        materia2 = new Materia(2, "Proyecto TIC", "Desarrollo de apps", "Guido", unUsuario, temas2);
        materia3 = new Materia(3, "Logistica", "Módulo final", "Eladio", unUsuario, temas3);
        materias.add(materia1);
        materias.add(materia2);
        materias.add(materia3);
    }
    public static Materia buscarMateria (int idMateria) {
        Materia unaMateria = null;
        for (int i = 0; i < materias.size(); i++) {
            unaMateria = materias.get(i);
            if (idMateria == unaMateria.getIdMateria()) {
                i = materias.size();
                Log.i(LogUtils.tag, "Bitacora encontrada: "+unaMateria.getNombre());
                return unaMateria;
            }

        }
        Log.i(LogUtils.tag, "Bitacora NULL");

        return null;
    }



    public static void agregarMateria(Materia unaMateria ) {
        materias.add( unaMateria );
    }

    public static void agregarTema(Tema unTema, Materia unaMateria  ) {
        unaMateria.getTemas().add( unTema );
    }



}
