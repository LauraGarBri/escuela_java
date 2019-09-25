package ConvertirStringAux;

import clasesjava.StringAux;
import java.io.File;
import java.util.Scanner;

/**
 * @author Laura Garcia
 */
public class StringAuxV1 implements IQuitarEspacios {

    private StringAux strAux;

    public StringAuxV1() {
        this.strAux = new StringAux ("");
    }
    
 
    @Override
    public String quitarEspaciosSobrantes(String str) {
        return StringAux.quitarEspSobrantesV1(str);
       
    }
     

}
