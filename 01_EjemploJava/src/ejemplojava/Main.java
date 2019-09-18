package ejemplojava;

/**
 *
 * @author Laura Garcia
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("Hola mundo");
        
        Coche miCoche = new Coche("kia", TipoColor.AZUL,TipoCarburante.DIESEL); //La instanciacion se hace con new
        
        miCoche.echarCarburante(30); //Empezamos con medio deposito
        
        System.out.println("Coche creado: " + miCoche.getMarca() + "\nNivel Depósito: "+
                miCoche.getNivelDeposito() + " litros\n");
        
        
        Coche otroCoche = miCoche; //new Coche();
        
        
        System.out.println("Coche creado: " + otroCoche.getMarca() + "\nCapacidad Depósito: "+
                otroCoche.getNivelDeposito() + " litros\n");
        
        miCoche.vaciarDeposito();
        
        miCoche.setArrancado(true);
        miCoche.echarCarburante(-2);
        for(int i=0; i<3;i++){
            miCoche.acelerar();
            miCoche.mostrar();
        }
        
        
        //----------------------
        System.out.println("+++++++++++++++++++++++++");
        
        Coche coche2 = new Coche("kia", "AZUL","DIESEL");
        
        System.out.println(coche2.toString());
        
        
    }
}
