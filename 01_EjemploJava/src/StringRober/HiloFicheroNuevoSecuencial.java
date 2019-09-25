package StringRober;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import StringRober.IQuitarEspacio;
import java.util.Date;
import java.util.function.Function;

/**
 * @author Laura Garcia
 */
public class HiloFicheroNuevoSecuencial {
    int id;
    Function<Float[],Float[]> avisarFin;
    //StringAuxV1 strAuxv1 = new StringAuxV1 ();
    private IQuitarEspacio strAuxv;
    
    public HiloFicheroNuevoSecuencial(int id, IQuitarEspacio strAuxv, Function<Float[],Float[]> avisarFin){
        this.id = id;
        this.strAuxv = strAuxv;
        this.avisarFin = avisarFin;
    }


    public void leerFicheroEjem(String rutaFich){
        
        long startTime = new Date().getTime();
        
        File fich = new File(rutaFich);
        Scanner escaner = null;
        try{
            escaner = new Scanner(fich);
            while(escaner.hasNextLine()){
                String linea = escaner.nextLine();
                
                strAuxv.quitarEspacios(linea);
                             
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
            
            
            long endTime = new Date().getTime();
        
            avisarFin.apply(new Float[] {(float)id, (float)(endTime-startTime) });
        }
        
    }
}
