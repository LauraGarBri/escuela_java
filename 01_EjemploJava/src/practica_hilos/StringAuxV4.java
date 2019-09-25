package practica_hilos;

import clasesjava.StringAux;

/**
 * @author Laura Garcia
 */
public class StringAuxV4 implements IQuitarEspacios {

    private StringAux strAux;

    public StringAuxV4() {
        this.strAux = new StringAux ("");
    }
    
 
    @Override
    public String quitarEspaciosSobrantes(String str) {
        return StringAux.quitarEspSobrantes(str);
       
    }
     

}
