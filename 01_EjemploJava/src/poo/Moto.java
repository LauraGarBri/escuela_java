package poo;

/**
 * @author Laura Garcia
 */
public class Moto extends Vehiculo implements Rodable{
    
    private int numRuedas;

    public Moto(String marca, TipoColor color, String matricula, int numRuedas) {
        super(marca, color, matricula);
        this.numRuedas = numRuedas;
    }
    
    

    @Override
    public void abrirPuerta() {
    }

    @Override
    public void acelerar() {
        System.out.println("Aceleramos moto");
    }

    @Override
    public String toString() {
        return "Moto: " + super.getMarca() + "\nMatricula: "+super.getMatricula() +
                "\nColor: "+super.getColor().toString()+ "\nRuedas: "+ numRuedas;
    }

    @Override
    public int getNumRuedas() {
        return numRuedas;
    }

    @Override
    public void moverse() {
        System.out.println("Se mueve la moto");
    }

   

   

    

}
