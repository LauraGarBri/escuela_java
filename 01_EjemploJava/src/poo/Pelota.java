package poo;

/**
 * @author Laura Garcia
 */
public class Pelota implements Rodable {

    @Override
    public int getNumRuedas() {
        return 1;
    }

    @Override
    public void moverse() {
        System.out.println("Bota, bota, mi pelota");
    }

}
