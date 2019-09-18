package ejemplojava;

/**
 * @author Laura Garcia
 */
public class CocheRally extends Coche{

    //Propiedad 
    private float rozamiento;

    //Constructor con parametros
    public CocheRally(String marca, TipoColor color, TipoCarburante carburante,
            float rozamiento) {
        super(marca, color, carburante);
        this.rozamiento = rozamiento;  
    }

    //Constructor con parametros. Sobrecarga de constructor
    public CocheRally(String marca, String color, String carburante,
             float rozamiento) {
        super(marca, color, carburante);
        this.rozamiento = rozamiento;
    }

    //Getter
    public float getRozamiento() {
        return rozamiento;
    }

    //Setter
    public void setRozamiento(float rozamiento) {
        this.rozamiento = rozamiento;
    }

    @Override
    public String toString() {
        return super.getMarca()+" "+ super.getCarburante()+ " "+super.getColor() +" "+ super.getNumRuedas();
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
    
   
}
