/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import poo.Coche;
import poo.CocheRally;
import poo.TipoCarburante;
import poo.TipoColor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;
import poo.Pelota;

/**
 *
 * @author Formacion
 */
public class TestColecciones {

    //@Test
    public void array() {

        //Inicializamos array de coches
        Coche[] coches = new Coche[3];
        coches[0] = new Coche("Fiat", TipoColor.AZUL, "123434");
        coches[1] = new Coche("Audi", TipoColor.ROJO, "343456");
        coches[2] = new Coche("Kia", TipoColor.VERDE, "343434");

        //Otra forma de inicializar coches 
        Coche[] cochesBis = {coches[2], coches[1],
            new Coche("Kia", TipoColor.VERDE, "2323")};

        ArrayList arrayLisObjetos = new ArrayList(); //ArrayList NO generico
        arrayLisObjetos.add(42);
        arrayLisObjetos.add("aaaa");
        arrayLisObjetos.add(coches[0]);

        for (Object obj : arrayLisObjetos) {
            System.out.println("OBJ: " + obj);
        }

        ArrayList<Integer> ventasAnuales = new ArrayList<>();//ArrayList Generico
        Integer objEntero = new Integer(200);
        objEntero.longValue();
        ventasAnuales.add(3000);
        ventasAnuales.add(objEntero);

        ArrayList<Coche> cochesParaVender = new ArrayList<>();
        cochesParaVender.add(new Coche("Sinca", TipoColor.PLATEADO, "4567676"));
        cochesParaVender.add(coches[0]);
        cochesParaVender.add(coches[1]);
        cochesParaVender.add(coches[2]);

        cochesParaVender.add(new CocheRally("Subaru",TipoColor.VERDE,"erere33"));

        if (cochesParaVender.contains(coches[0])) {
            System.out.println("El coche existe");
        } else {
            System.out.println("El coche no existe");
        }

        //funcion lambda
        cochesParaVender.forEach((coche) -> {
            System.out.println(" -> " + coche.toString());

        });
        
        //Otra forma de verlo
        //cochesParaVender.forEach(TestColecciones::mostrarCoche);

    }
    
    //Es exactamente lo mismo que el for each anterior pero con nombre de funcion
    public static void mostrarCoche(Coche coche){
        System.out.println(" ->" + coche.toString());
    }
    
    //@Test
    public void sets(){
        //de la interfaz set, no se pueden repetir elementos
        HashSet<Pelota> pelotas = new HashSet<>();//No se encuentran ordenados
        Pelota pelota1 = new Pelota();
        Pelota pelota2 = new Pelota();
        Pelota pelota3 = new Pelota();
        
        pelotas.add(pelota1);
        pelotas.add(pelota2);
        pelotas.add(pelota3);
        
        //Intentamos añadir otra vez las mismas pelotas pero no se puede
        pelotas.add(pelota3);
        pelotas.add(pelota2);
        
        System.out.println("Set Pelotas: " + pelotas);
        assertEquals(pelotas.size(), 3);
        
        //En hashSet solo podemos recorrer
        for(Pelota has: pelotas){
            System.out.println(has);
        }
    }
    
    @Test
    public void maps(){
        //los hashmap no se pueden repetir, se sobreescriben ("machacan" el valor anterior)
        HashMap<String, Boolean> coloresCalidos = new HashMap<>();
        coloresCalidos.put("Blanco", false);
        coloresCalidos.put("Azul", true);
        coloresCalidos.put("Rojo", false);
        coloresCalidos.put("verde", false);
        coloresCalidos.put("naranja", true);
        
        if(coloresCalidos.get("Rojo")){
            System.out.println("Rojo es calido");
        }
        if(coloresCalidos.get("Azul")){
            System.out.println("Azul es calido");
        }
        
        System.out.println("Verde es " + coloresCalidos.get("verde"));
        
        //Recorrer un hashmap
        for(Map.Entry<String, Boolean> par: coloresCalidos.entrySet()){
            System.out.println("Clave: " + par.getKey());
            System.out.println(" Valor: " + par.getValue());
        }
        
        assertEquals(coloresCalidos.get("Azul"), true);
        assertEquals(coloresCalidos.size(),5);
    }
    
}
