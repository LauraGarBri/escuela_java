/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import poo.Coche;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Formacion
 */
public class TestGenericos {

    @Test
    public void metodoGenerico() {

        ArrayList<Integer> listaInt = new ArrayList<>();
        insertarDobleGenerico(listaInt, 10);
        insertarDobleGenerico(listaInt, 15);
        System.out.println("Enteros: " + listaInt.toString());

        ArrayList<String> listaStr = new ArrayList<>();
        insertarDobleGenerico(listaStr, "Texto 1");
        insertarDobleGenerico(listaStr, "Texto 2");
        System.out.println("Textos: " + listaStr.toString());
        //-----------------------------------------------
        mostrarLista(listaStr.toArray());
        //------------------------------------------------
        Float[] arrF = {1.1f, 2.2f,3.3f};
        ArrayList<Float> listaF = convertirArray(arrF);
        mostrarLista(listaF.toArray());
    }

    //Metodo generico para insertar dos veces un valor en un arraylist
    public static <Tipo> void insertarDobleGenerico(ArrayList<Tipo> lista, Tipo valor) {
        lista.add(valor);
        lista.add(valor);
    }

    //Mostrar array de tipos genericos
    public static <Tipo> void mostrarLista(Tipo[] array) {
        for (Tipo lista1 : array) {
            System.out.println(lista1.toString());
        }
    }

    //Convertir array en arraylist con tipos genericos
    public static <Tipo>ArrayList<Tipo> convertirArray(Tipo[] array) {
        ArrayList<Tipo> list = new ArrayList<>();
        list.addAll(Arrays.asList(array));
        return list;
        
               
    }
}
