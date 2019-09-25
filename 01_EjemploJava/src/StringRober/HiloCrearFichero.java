package StringRober;

import StringRober.StringAux;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import StringRober.IQuitarEspacio;

/**
 * @author Laura Garcia
 */
public class HiloCrearFichero {

    //StringAuxV1 strAuxv1 = new StringAuxV1 ();
    private IQuitarEspacio strAuxv;
    
    public HiloCrearFichero(IQuitarEspacio strAuxv){
        this.strAuxv = strAuxv;
    }


    public void leerFicheroEjem(String rutaFich){
        File fich = new File(rutaFich);
        Scanner escaner = null;
        try{
            escaner = new Scanner(fich);
            while(escaner.hasNextLine()){
                String linea = escaner.nextLine();
                
                System.out.println(strAuxv.quitarEspacios(linea));
                             
            }
        
        } catch (FileNotFoundException ex) {
            System.err.println("Error: " + ex.getMessage());
        }finally{
            try{
                if(escaner != null){
                    escaner.close();
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        
    }
}
