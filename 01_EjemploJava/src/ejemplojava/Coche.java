package ejemplojava;

/**
 *
 * @author Laura Garcia
 */
public class Coche { //heredan de Object
    
    public static final int CAPACIDAD_DEPOSITO =60;
    //Propiedades
    private final byte numRuedas;
    private final String marca;
    private double nivelDeposito;
    private boolean arrancado;
    private TipoColor color;
    private final TipoCarburante carburante;

    
    //Constructor
    public Coche(String marca, TipoColor color, TipoCarburante carburante){
        this.numRuedas = 4;
        this.marca = marca;
        this.color = color;
        this.carburante= carburante;
    }
    
    //Constructor
    public Coche(String marca, String color, String carburante){
        this.numRuedas = 4;
        this.marca = marca;       
        
        /*switch(color){
            case "AZUL":
                this.color = TipoColor.AZUL;
                break;
            case "BLANCO":
                this.color = TipoColor.BLANCO;
                break;
                
        }*/
        
        this.color = TipoColor.valueOf(color.toUpperCase());
        this.carburante = TipoCarburante.valueOf(carburante.toUpperCase());
        
    }
    
    //Getters
    public byte getNumRuedas() {
        return numRuedas;
    }
    
    public String getMarca() {
        return marca;
    }
    
    public double getNivelDeposito(){
        return nivelDeposito;
    }

    public boolean isArrancado() {
        return arrancado;
    }

    public TipoColor getColor() {
        return color;
    }

    public TipoCarburante getCarburante() {
        return carburante;
    }
    
    

    //Setters
    public void setArrancado(boolean arrancado) {
        this.arrancado = arrancado;
    }

    public void setNivelDeposito(double nivelDeposito) {
        this.nivelDeposito = nivelDeposito;
    }

    public void setColor(Enumerados color) {
        this.color = color;
    }
    
  
    //Metodo para modificar el nivel de carburante
    public void echarCarburante(double cantidad){
        if(cantidad > 0){
           this.nivelDeposito += cantidad; 
        }
        if(nivelDeposito > CAPACIDAD_DEPOSITO){
            this.nivelDeposito = CAPACIDAD_DEPOSITO;
        }   
    }
    
    //Metodo para modificar el nivel de deposito en funcion de si aceleramos o no
    public void acelerar(){
        if(arrancado){
            explosionCilindro();
            nivelDeposito -= 0.1;
        }
    }
    
    //Metodo para vaciar el deposito
    public void vaciarDeposito(){
        this.nivelDeposito = 3;
        
        System.out.println("Deposito vaciado de: " + this.toString());
    }
    
    //Metodo toString
    @Override
    public String toString(){
        return "Coche " + marca + " Nivel: " + nivelDeposito + " Color: " + color
                + " Carburante: " + carburante;
    }
    
    //Metodo donde llamamos al metodo toString
    public void mostrar(){
        System.out.println(this.toString());
    }
    
    
    protected void explosionCilindro(){
        System.out.println("Motor funcionando");
    }
    
    protected void setNivDeposito(double nuevoNiv){
        this.nivelDeposito = nuevoNiv;
    }
}
