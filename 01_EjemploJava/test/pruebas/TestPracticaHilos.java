package pruebas;

import org.junit.Test;
import static org.junit.Assert.*;
import StringRober.HiloFicheroNuevoSecuencial;
import StringRober.StringAux;
import StringRober.StringAux2;
import StringRober.StringAux3;
import java.util.Date;

public class TestPracticaHilos {
    
    @Test
    public void TestPractica() {
        String ruta = "C:\\Users\\alumno\\Desktop\\ESCUELA JAVA\\LAURA\\01_EjemploJava\\texto.txt";
        
        long startTime = new Date().getTime();
        
        HiloFicheroNuevoSecuencial hiloFichero = new HiloFicheroNuevoSecuencial(new StringAux());
        HiloFicheroNuevoSecuencial hiloFichero2 = new HiloFicheroNuevoSecuencial(new StringAux2());
        HiloFicheroNuevoSecuencial hiloFichero3 = new HiloFicheroNuevoSecuencial(new StringAux3());
        
        hiloFichero.leerFicheroEjem(ruta);
        hiloFichero2.leerFicheroEjem(ruta);
        hiloFichero3.leerFicheroEjem(ruta);
        
        
        long endTime = new Date().getTime();
        
        System.out.println("Ha tardado: " + (endTime-startTime) + "ms");
    }
}
