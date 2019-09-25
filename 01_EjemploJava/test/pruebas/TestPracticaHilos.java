package pruebas;

import StringRober.HiloCrearFichero;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import StringRober.HiloFicheroNuevoSecuencial;
import StringRober.StringAux;
import StringRober.StringAux2;
import StringRober.StringAux3;
import java.util.Date;

public class TestPracticaHilos {
       String ruta = "C:\\Users\\alumno\\Desktop\\ESCUELA JAVA\\LAURA\\01_EjemploJava\\texto.txt";

    @Test
    public void TestPracticaSecuencial() {
        
        long startTime = new Date().getTime();
        HiloFicheroNuevoSecuencial hiloFichero = new HiloFicheroNuevoSecuencial(1, new StringAux(), TestPracticaHilos::hiloTerminado);
        HiloFicheroNuevoSecuencial hiloFichero2 = new HiloFicheroNuevoSecuencial(2, new StringAux2(), TestPracticaHilos::hiloTerminado);
        HiloFicheroNuevoSecuencial hiloFichero3 = new HiloFicheroNuevoSecuencial(3, new StringAux3(), TestPracticaHilos::hiloTerminado);

        System.out.println(">>EMPIEZA SECUENCIAL");
        hiloFichero.leerFicheroEjem(ruta);
        hiloFichero2.leerFicheroEjem(ruta);
        hiloFichero3.leerFicheroEjem(ruta);

        System.out.println(">>TERMINA SECUENCIAL");

        long endTime = new Date().getTime();
         System.out.println("TODO " + startTime + "Ha tardado: " + (endTime-startTime));

    }
    @Test
    public void TestPracticaCONCURRENTE() {
        long startTime = new Date().getTime();
        //String ruta = "C:\\Users\\Formacion\\Desktop\\ESCUELA_JAVA\\escuela_java.git\\01_EjemploJava\\texto.txt";
 
        HiloCrearFichero hilo1 = new HiloCrearFichero(1, new StringAux(), TestPracticaHilos::hiloTerminado, ruta);
        HiloCrearFichero hilo2 = new HiloCrearFichero(2, new StringAux2(), TestPracticaHilos::hiloTerminado, ruta);
        HiloCrearFichero hilo3 = new HiloCrearFichero(3, new StringAux3(), TestPracticaHilos::hiloTerminado, ruta);

        try {
            System.out.println(">>EMPIEZA CONCURRENTE");
            hilo3.start();
            hilo2.start();
            hilo1.start();
            
            System.out.println(">>EMPIEZA UNION ESPERA");
            hilo3.join();
            hilo1.join();
            hilo2.join();
            System.out.println(">>TERMINA CONCURRENTE");

        } catch (InterruptedException ex) {
            Logger.getLogger(TestPracticaHilos.class.getName()).log(Level.SEVERE, null, ex);
        }
        long endTime = new Date().getTime();
         System.out.println("TODO " + startTime + "Ha tardado: " + (endTime-startTime));
    }

    public static Float[] hiloTerminado(Float[] param) {
        System.out.println("Callback" + param[0] + "Ha tardado: " + param[1]);

        return new Float[]{};
    }
}
