package poo;

/**
 *
 * @author Laura Garcia
 */
public class Coche extends Vehiculo implements Rodable{ //heredan de Object
    
    public static final int CAPACIDAD_DEPOSITO =60;
    //Propiedades
    private final int numRuedas;
    private double nivelDeposito;
    private boolean arrancado;       
    private TipoCarburante carburante;

    public Coche(String marca, TipoColor color, String matricula) {
        super(marca, color, matricula);
        this.numRuedas = 4;
        
    }

    
    
    public Coche(int numRuedas, double nivelDeposito, boolean arrancado, 
            TipoCarburante carburante, String marca, TipoColor color, String matricula) {
        super(marca, color, matricula);
        this.numRuedas = numRuedas;
        this.nivelDeposito = nivelDeposito;
        this.arrancado = arrancado;
        this.carburante = carburante;
    }

    public Coche(int numRuedas, TipoCarburante carburante, String marca, TipoColor color, String matricula) {
        super(marca, color, matricula);
        this.numRuedas = numRuedas;
        this.carburante = carburante;
    }

    public static int getCAPACIDAD_DEPOSITO() {
        return CAPACIDAD_DEPOSITO;
    }


    public double getNivelDeposito() {
        return nivelDeposito;
    }

    public boolean isArrancado() {
        return arrancado;
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
    @Override
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
        return "Coche: " + super.getMarca() + "\nMatricula: "+super.getMatricula() +
                "\nColor: "+super.getColor().toString()+ "\nRuedas: "+ numRuedas +
                "\nNivel Deposito: "+ nivelDeposito +  "\nCarburante: "+ carburante  +
                "\nArrancado: "+ arrancado;
         
    }
    
    //Metodo donde llamamos al metodo toString
    public void mostrar(){
        System.out.println(this.toString());
    }
    
    
    public void explosionCilindro(){
        System.out.println("Motor funcionando");
    }
    
    protected void setNivDeposito(double nuevoNiv){
        this.nivelDeposito = nuevoNiv;
    }

    @Override
    public void abrirPuerta() {
        System.out.println("Abrimos las puertas del coche");
    }

    @Override
    public void moverse() {
        System.out.println("Avanti tuto! " + toString());
    }

    @Override
    public int getNumRuedas() {
        return numRuedas;
    }

}
