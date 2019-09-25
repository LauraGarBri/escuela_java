package ConHerencia;

import clasesjava.StringAux;

/**
 * @author Laura Garcia
 */
public class HiloFicheroStrAuxV2 extends HiloFichero{

    @Override
    protected String quitarEspacios(String s) {
        return StringAux.quitarEspSobrantesV2(s);
        
    }
}
