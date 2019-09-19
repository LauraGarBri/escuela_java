package ejemplojava;


import poo.CocheRally;
import poo.TipoColor;
import poo.Coche;
import poo.TipoCarburante;
import clasesjava.StringAux;

/**
 *
 * @author Laura Garcia
 */
public class Main {

    public static void main(String[] args) {
        //String texto = StringAux.quitarEspacios("   En un    lugar");
        //System.out.println(texto);
        //StringAux.contarPalabras("   en     un    lugar");
        //StringAux.otraFormaQuitarEspacios("   ee     lugar  ");
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void mainCoches(String[] args) {
        
        System.out.println("Hola mundo");
        
        Coche miCoche = new Coche("kia", TipoColor.AZUL,"443"); //La instanciacion se hace con new
        
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
        System.out.println("\n+++++++++++++++++++++++++");
        
        Coche coche2 = new Coche("kia", TipoColor.AZUL,"wew");
        
        System.out.println(coche2.toString());
        
        //-----------------herencia---------------------
        System.out.println("\n*************HERENCIA************");
        CocheRally cocheRally = new CocheRally("Ford", TipoColor.AZUL,"erer");
        
        System.out.println(cocheRally.toString());
        cocheRally.echarCarburante(50);
        cocheRally.setArrancado(true);
        cocheRally.acelerar();
        cocheRally.derrapar();
        cocheRally.mostrar();
        
        //-----------------POLIMORFISMO------------
        System.out.println("\n*******************POLIMORFISMO****************");
        Coche supraNormal = cocheRally;//Conversion implicita
        supraNormal.explosionCilindro();
        //supraNormal.derrapar();
        supraNormal.acelerar();
        supraNormal.mostrar();
        
        CocheRally cr = (CocheRally) supraNormal; //Casting o conversion explicita
        System.out.println("Rozamiento:" + cr.getRozamiento());
                
        //cr = (CocheRally)miCoche; --> No se puede hacer el casting
        //System.out.println("Rozamiento: " +cr.getRozamiento());
    }
}
