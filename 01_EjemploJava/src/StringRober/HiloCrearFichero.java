package StringRober;

import StringRober.StringAux;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import StringRober.IQuitarEspacio;
import java.util.Date;
import java.util.function.Function;

/**
 * @author Laura Garcia
 */
public class HiloCrearFichero extends Thread {

    Function<Float[], Float[]> avisarFin;
    private IQuitarEspacio strAuxv;
    private String rutaFich;
    private int id;

    public HiloCrearFichero(int id, IQuitarEspacio strAuxv, Function<Float[], Float[]> avisarFin, String rutaFich) {
        this.id = id;
        this.strAuxv = strAuxv;
        this.rutaFich = rutaFich;
        this.avisarFin = avisarFin;
    }

    @Override
    public void run() {
        leerFicheroEjem(rutaFich);
    }

    public void leerFicheroEjem(String rutaFich) {
        long start = new Date().getTime();

        File fich = new File(rutaFich);
        Scanner escaner = null;
        try {
            escaner = new Scanner(fich);
            while (escaner.hasNextLine()) {
                String linea = escaner.nextLine();

                strAuxv.quitarEspacios(linea);
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Error: " + ex.getMessage());
        } finally {
            try {
                if (escaner != null) {
                    escaner.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            long end = new Date().getTime();

            avisarFin.apply(new Float[]{(float) id, (float) (end - start)});

        }

    }
}
