package pruebas;

import org.junit.Test;
import static org.junit.Assert.*;
import threads.HiloFichero;

/**
 *
 * @author Formacion
 */
public class TestFicheros {

   

    //@Test
    public void generacionFicheroAleatorio() {
        HiloFichero.crearFicheroEjem("C:\\Users\\Formacion\\Desktop\\ESCUELA_JAVA\\escuela_java.git\\01_EjemploJava\\texto.txt");
    }
    
    @Test
    public void leerFicheroAleatorio(){
        HiloFichero.leerFicheroEjem("C:\\Users\\Formacion\\Desktop\\ESCUELA_JAVA\\escuela_java.git\\01_EjemploJava\\texto.txt");
        
    }
    
    
}
