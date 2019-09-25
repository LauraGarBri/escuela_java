/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import ConvertirStringAux.HiloFicheroNuevo;
import ConvertirStringAux.StringAuxV1;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Formacion
 */
public class TestConvertirStringAux {
        
     @Test
    public void convertir() {
         /*HiloFicheroNuevo hilo = new HiloFicheroNuevo();
         
         hilo.leerFicheroEjem("C:\\Users\\Formacion\\Desktop\\ESCUELA_JAVA\\escuela_java.git\\01_EjemploJava\\texto.txt");
         */
         
         StringAuxV1 strAuxv1 = new StringAuxV1 ();
         HiloFicheroNuevo hilo = new HiloFicheroNuevo(strAuxv1);
         hilo.leerFicheroEjem("C:\\Users\\Formacion\\Desktop\\ESCUELA_JAVA\\escuela_java.git\\01_EjemploJava\\texto.txt");
         
         
    }
}
