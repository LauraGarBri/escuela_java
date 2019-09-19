package poo;

/**
 * @author Laura Garcia
 */
public class CocheRally extends Coche{

    //Propiedad 
    private float rozamiento;

    public CocheRally(float rozamiento, int numRuedas, double nivelDeposito, 
            boolean arrancado, TipoCarburante carburante, String marca, TipoColor color, String matricula) {
        super(numRuedas, nivelDeposito, arrancado, carburante, marca, color, matricula);
        this.rozamiento = rozamiento;
    }

    public CocheRally(float rozamiento, int numRuedas, TipoCarburante carburante, 
            String marca, TipoColor color, String matricula) {
        super(numRuedas, carburante, marca, color, matricula);
        this.rozamiento = rozamiento;
    }

    public CocheRally(String marca, TipoColor color, String matricula) {
        super(marca, color, matricula);
        this.rozamiento = 0.4f;
    }

    
    
    //Getter
    public float getRozamiento() {
        return rozamiento;
    }

    //Setter
    public void setRozamiento(float rozamiento) {
        this.rozamiento = rozamiento;
    }

   
   public void derrapar(){
       System.out.println("Derrapeeee!");
       super.explosionCilindro();//Se puede llamar al metodo gracias al protected
   }
   
   //Sobrecarga de metodos
   public void derrapar(float cuanto){
       System.out.println("Derrapeeee de " + cuanto + "newtons!");
       super.explosionCilindro();//Se puede llamar al metodo gracias al protected
   }
   
   //Sobrescritura de metodos
    @Override
   public void acelerar(){
       System.out.println("Acelerando a lo bestia ");
       if(isArrancado()){
            explosionCilindro();
            setNivDeposito(getNivelDeposito()- 0.1);
            System.out.println(getNivelDeposito());
        }
   }
   
   //Metodo toString

    @Override
    public String toString(){
        return "Coche: " + super.getMarca() + "\nMatricula: "+super.getMatricula() +
                "\nColor: "+super.getColor().toString()+ "\nRuedas: "+ super.getNumRuedas() +
                "\nNivel Deposito: "+ super.getNivelDeposito() +  "\nCarburante: "+ super.getCarburante()  +
                "\nArrancado: "+ super.isArrancado()+
                "\nRozamiento: "+ rozamiento;        
    }
    
   
}
