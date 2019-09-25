package pruebas;

import StringRober.HiloCrearFichero;
import StringRober.IQuitarEspacio;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        //String ruta = "C:\\Users\\Formacion\\Desktop\\ESCUELA_JAVA\\escuela_java.git\\01_EjemploJava\\texto.txt";
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
    
    
    
        
        long start = new Date().getTime();
        
       
        
        HiloCrearFichero hilo1 = new HiloCrearFichero(1,new StringAux(),TestPracticaHilos::hiloTerminado, ruta);
        HiloCrearFichero hilo2 = new HiloCrearFichero(2,new StringAux2(),TestPracticaHilos::hiloTerminado, ruta);
        HiloCrearFichero hilo3 = new HiloCrearFichero(3,new StringAux3(),TestPracticaHilos::hiloTerminado, ruta);
        
  //      hilo1.leerFicheroEjem(ruta);
        
        try {
            hilo1.start();
            hilo1.join();
            hilo2.start();
            hilo2.join();
            hilo3.start();
            hilo3.join();
            
            long end = new Date().getTime();
            //System.out.println("Tiempo total " + (end - start));
        } catch (InterruptedException ex) {
            Logger.getLogger(TestPracticaHilos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Float[] hiloTerminado(Float[] param){
        System.out.println("Callback" + param[0] + "Ha tardado: " + param[1] );
        
        return new Float[]{};
    }
}
