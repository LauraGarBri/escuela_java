package poo;

/**
 * @author Laura Garcia
 */
public abstract class Vehiculo {

    //Propiedades
    private String matricula;
    private String marca;
    private TipoColor color;

    //Constructor
    public Vehiculo(String marca, TipoColor color, String matricula) {
        this.marca = marca;
        this.color = color;
        this.matricula = matricula;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setColor(TipoColor color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public TipoColor getColor() {
        return color;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public abstract void abrirPuerta();

    public abstract void acelerar();
   
}
