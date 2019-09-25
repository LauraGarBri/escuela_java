/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import ConHerencia.HiloFichero;
import ConHerencia.HiloFicheroStrAuxV1;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Formacion
 */
public class ConvertirHerencia {
    
    
     @Test
     public void leerFichero() {
         HiloFichero hf = new HiloFicheroStrAuxV1();
         hf.leerFicheroEjem("C:\\Users\\Formacion\\Desktop\\ESCUELA_JAVA\\escuela_java.git\\01_EjemploJava\\texto.txt");
     }
}
