/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import clasesjava.StringAux;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Formacion
 */
public class TestStringAux {
    
    public TestStringAux() {
    }
    
   
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void probarQuitarEspacios() {
         
        String texto3 ="    en    un   LUGAR";
        String resultadoOK= "en un LUGAR";
        
        StringAux texto3aux = new StringAux(texto3);
        String resultadoAUX = texto3aux.quitarEspSobrantes();
        
        
        assertEquals(resultadoOK, resultadoAUX);
     }
     
     
      @Test
     public void probarContarPalabras() {
          assertEquals(3,StringAux.contarPalabras("    en    un   LUGAR"));
          assertEquals(0,StringAux.contarPalabras("     "));
          assertEquals(1,StringAux.contarPalabras("aaaaaa"));
     }
     
}
