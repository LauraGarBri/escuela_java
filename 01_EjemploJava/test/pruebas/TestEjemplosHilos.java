/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Formacion
 */
public class TestEjemplosHilos {

    public class ProcesoA extends Thread {

        public void mostrarListaA() {
            for (int i = 0; i < 200; i++) {
                System.out.println("Proceso A: " + i);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(TestEjemplosHilos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        @Override
        public void run() {
            mostrarListaA();
        }

    }

    @Test
    public void probandoClasesConNombre() throws InterruptedException {

        ProcesoA procA = new ProcesoA();
        Thread procB = new Thread() {
            public void run() {
                for (int j = 0; j < 200; j++) {
                    try {
                        System.out.println("Proceso B: " + j);
                        Thread.sleep(3);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(TestEjemplosHilos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };

        procA.start();
        procB.start();
        
        procA.suspend();
        Thread.sleep(20);
        procA.resume();

        try {
            procA.join();
            procB.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(TestEjemplosHilos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
