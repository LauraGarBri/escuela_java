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
        
        HiloFicheroNuevoSecuencial hiloFichero = new HiloFicheroNuevoSecuencial(1, new StringAux(), TestPracticaHilos::hiloTerminado);
        HiloFicheroNuevoSecuencial hiloFichero2 = new HiloFicheroNuevoSecuencial(2, new StringAux2(), TestPracticaHilos::hiloTerminado);
        HiloFicheroNuevoSecuencial hiloFichero3 = new HiloFicheroNuevoSecuencial(3, new StringAux3(), TestPracticaHilos::hiloTerminado);
        
        hiloFichero.leerFicheroEjem(ruta);
        hiloFichero2.leerFicheroEjem(ruta);
        hiloFichero3.leerFicheroEjem(ruta);
        
        
        long endTime = new Date().getTime(); 
        
        //System.out.println("Ha tardado: " + (endTime-startTime) + "ms");
    }
    public static Float[] hiloTerminado(Float[] param) {
        System.out.println("CALLBACK>>>> " + param[0] + " Ha tardado: " + param[1]); 
        
        return new Float[]{};
    }
}
