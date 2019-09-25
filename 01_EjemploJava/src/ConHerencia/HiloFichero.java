package ConHerencia;

import threads.*;
import clasesjava.StringAux;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Laura Garcia
 */
public abstract class HiloFichero {
    
    protected abstract String quitarEspacios(String s);
    
    public  void crearFicheroEjem(String rutaFich) {
        String[] palabras = new String['Z' - 'A' + 1];
        Random r = new Random(new Date().getTime());

        for (char c = 'A'; c < 'Z' + 1; c++) {
            int repe = 2 + Math.abs(r.nextInt() % 8); //Numero aleatorio entre 2 y 9
            
            palabras[c - 'A'] = "";
            for (int i = 0; i < repe; i++) {
                palabras[c - 'A'] += "" + c;
            }
        }
        System.out.println(Arrays.toString(palabras));

        //Creamos el fichero
        FileWriter fich = null;
        try {
            fich = new FileWriter(rutaFich, false);

            for (int i = 0; i < 200000; i++) {
                //Numero aleatorio entre 0 y 2 (3-1)
                if (r.nextInt(2) == 0) {
                    fich.write(palabras[r.nextInt(palabras.length)]);
                }
                if (r.nextInt(2) == 0) {
                    for (int j = 0; j < 5; j++) {
                        fich.write(" ");
                    }
                }
                if(r.nextInt(12)== 0){
                    fich.write("\n\r");
                }
            }
            
            
        } catch (IOException ex) {
            System.err.println("Error en escritura: " + ex.getMessage());
        } catch (Exception ex) {
            System.err.println("Otro error: " + ex.getMessage());
        }finally{
            try{
                if(fich != null){
                    fich.close();
                }               
            }catch(IOException e){
                System.out.println(e.getMessage());
            }
        }

    }
    
    public  void leerFicheroEjem(String rutaFich){
        File fich = new File(rutaFich);
        Scanner escaner = null;
        try{
            escaner = new Scanner(fich);
            while(escaner.hasNextLine()){
                String linea = escaner.nextLine();
                              
                System.out.println(quitarEspacios(linea));
            }
        
        } catch (Exception ex) {
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
