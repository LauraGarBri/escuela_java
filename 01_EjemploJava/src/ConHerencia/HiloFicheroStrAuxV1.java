package ConHerencia;

import clasesjava.StringAux;

/**
 * @author Laura Garcia
 */
public class HiloFicheroStrAuxV1  extends HiloFichero{

    @Override
    protected String quitarEspacios(String s) {
        return StringAux.quitarEspSobrantesV1(s);
        
    }

}
