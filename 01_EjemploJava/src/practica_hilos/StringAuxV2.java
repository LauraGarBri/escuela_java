package practica_hilos;

import ConvertirStringAux.*;
import clasesjava.StringAux;
import practica_hilos.IQuitarEspacios;

/**
 * @author Laura Garcia
 */
public class StringAuxV2 implements IQuitarEspacios {

    private StringAux strAux;

    public StringAuxV2() {
        this.strAux = new StringAux ("");
    }
    
 
    @Override
    public String quitarEspaciosSobrantes(String str) {
        return StringAux.quitarEspSobrantesV2(str);
       
    }
     

}
