package threads;

import classjava.StringAux;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HiloCrearFichero {
    
    IQuitarEspacio stringAux;

    public HiloCrearFichero(IQuitarEspacio stringAux) {
        this.stringAux = stringAux;
    }
    
    
    
    public void crearFicheroEjem(String rutaFich) {
        String[] palabras = new String['Z' - 'A' + 1];
        
        Random r = new Random(new Date().getTime());
        for (char c = 'A'; c <= 'Z'; c++) {
            //r.nextInt((max - min) + 1) + min;
            int repe = r.nextInt((9 - 2) + 1) + 2;//2 + r.nextInt() % 8; //Entre 2 y 9
            
            palabras[c - 'A'] = "";
            
            for (int i = 0; i < repe; i++) {
                palabras[c - 'A'] += "" + c;
            }
        }
        System.out.println(Arrays.toString(palabras));
        
        FileWriter fich = null;
        try {
            fich = new FileWriter(rutaFich, false);
            for (int i = 0; i < 100000; i++) {
                if (r.nextInt(2) == 0) {
                    fich.write(palabras[r.nextInt(palabras.length)]);
                }
                if (r.nextInt(2) == 0) {
                    for (int j = 0; j < 10; j++) {
                        fich.write(" ");
                    }
                }
                if (r.nextInt(12) == 0) {
                    fich.write("\r\n");
                }
            }
            
        } catch (Exception e) {
            System.err.println("Error en escritura: " + e.getMessage());
        } finally {
            try {
                fich.close();
            } catch (IOException ex) {
                Logger.getLogger(HiloCrearFichero.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void leerFicheroEjem(String rutaFich) {
        File fich = new File(rutaFich);
        
        Scanner scan = null;
        try {
            scan = new Scanner(fich);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                System.out.println(stringAux.quitarEspacios(line));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (scan != null) {
                scan.close();
            }
        }
    }
}
