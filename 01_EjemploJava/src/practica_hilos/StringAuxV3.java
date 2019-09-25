package practica_hilos;

import clasesjava.StringAux;

/**
 * @author Laura Garcia
 */
public class StringAuxV3 implements IQuitarEspacios {

    private StringAux strAux;

    public StringAuxV3() {
        this.strAux = new StringAux ("");
    }
    
 
    @Override
    public String quitarEspaciosSobrantes(String str) {
        return StringAux.quitarEspSobrantes(str);
       
    }
     

}
