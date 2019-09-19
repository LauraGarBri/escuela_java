/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import poo.Coche;
import poo.CocheRally;
import poo.Moto;
import poo.Pelota;
import poo.Rodable;
import poo.TipoCarburante;
import poo.TipoColor;
import poo.Vehiculo;

/**
 *
 * @author Formacion
 */
public class TestAbstractInterface {
    
    
    //@Test
    public void abstractos() {
    
        Vehiculo miVehiculo = new Vehiculo("Kia",TipoColor.AZUL, "1234") {
            @Override
            public void abrirPuerta() {
                System.out.println("Abrimos puerta del vehiculo");
            }

            @Override
            public void acelerar() {
                System.out.println("Aceleramos vehiculo");
            }
        };
        
        miVehiculo.abrirPuerta();
            
        //***************************+
        System.out.println("----------------MOTO-------------");
        Vehiculo miMoto = new Moto("Honda",TipoColor.NEGRO,"333",2);
        System.out.println(miMoto.toString());
        miMoto.acelerar();
        
        //************************
        System.out.println("--------------COCHE------------");
        Coche coche = new Coche (2, 34.4,true,TipoCarburante.DIESEL,"Kia",TipoColor.AZUL, "FGH1234");
        coche.abrirPuerta();
        coche.echarCarburante(45);
        System.out.println(coche.toString());
        
        
        //************************
        System.out.println("--------------COCHE RALLY------------");
        CocheRally cocheRally = new CocheRally (4f,4,33.3,true,TipoCarburante.DIESEL,"Supra",TipoColor.AZUL,"TRE4444");
        cocheRally.abrirPuerta();
        cocheRally.acelerar();
        System.out.println(cocheRally.toString());
        assertEquals(cocheRally.getNivelDeposito(), 33.199999999999996, 0.03);
        
        cocheRally.derrapar();
        
        
        
    }
    
    @Test
    public void interfaces (){
        Coche coche = new Coche (2, 34.4,true,TipoCarburante.DIESEL,"Kia",TipoColor.AZUL, "FGH1234");
        coche.echarCarburante(50);
        coche.moverse();
        System.out.println(coche.toString());
        
        System.out.println("----------------MOTO-------------");
        Moto miMoto = new Moto("Honda",TipoColor.NEGRO,"333",2);
        System.out.println(miMoto.toString());
        miMoto.acelerar();        
        miMoto.moverse();
        
        Pelota mipelota = new Pelota();
        
        System.out.println("----------MI PELOTA----------");
        System.out.println(mipelota.getNumRuedas());
        mipelota.moverse();
        System.out.println("------------COSAS QUE RUEDAN----------");
        ArrayList<Rodable> cosasQueRuedan = new ArrayList<>();
        cosasQueRuedan.add(miMoto);
        cosasQueRuedan.add(coche);
        cosasQueRuedan.add(mipelota);
        
        for(Rodable ro: cosasQueRuedan){
            System.out.println(">>Rodando: "+ ro.toString());
            System.out.println("Ruedas: " + mipelota.getNumRuedas());
            ro.moverse();
        }
        
    }
}
