package clasesjava;

/**
 * @author Laura Garcia
 */
public class StringAux {
    
    private String string;

    public StringAux(String string) {
        this.string = string;
    }
    
    

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
    
    
    public String quitarEspSobrantes(){
        return quitarEspSobrantes(string);
    }
    
    public int contarPalabras(){
        return contarPalabras(string);
    }
    

    //Metodo para quitar espacios de más en el texto
    public static String quitarEspacios(String texto){
        texto = texto.trim();
        //Expresion regular para eliminar mas de un espacio
        texto = texto.replaceAll(" +", " ");
        
        return texto;
    }
    
    
    public static String quitarEspSobrantesV1(String texto){//No funciona mirar
       String result = "";
       texto = texto.trim();
       for(int i = 0;i<texto.length(); i++){
           if(texto.charAt(i) != ' '){
               result += texto.charAt(i);
           }else if(i<texto.length()-1){
               if(texto.charAt( i + 1) != ' '){
                   result += ' ';
               }
           }
       }
       return result;
    }
    
    
    
    public static String quitarEspSobrantesV2(String texto){
        String result = "";
        texto = texto.trim();
        String [] palabras = texto.split(" ");
        
        for(String palabra : palabras){
            if(!palabra.isEmpty()){
                result += palabra + " ";
            }        
        }
        
        return result.trim();
    }
    
    
    
    public static String quitarEspSobrantes(String texto){
        
        texto = texto.trim();
        
        while(texto.contains("  ")){
            texto = texto.replace("  "," ");
        }
        
        return texto;
    }
    
    
    
    
    //Metodo para saber el numero de palabras
    public static int contarPalabrasV2(String texto){
        
        int contador = 0;        
        String[] palabras = quitarEspacios(texto).split(" ");
        
        for (String palabra : palabras){
            contador++;   
            //System.out.println(palabra);
        }
        return contador;
    }
    
    
    //Metodo para saber el numero de palabras
    public static int contarPalabras(String texto){
        texto = texto.trim();
        
        if(texto.isEmpty()){
            return 0;
        }else{
            return quitarEspacios(texto).split(" ").length;
        }
          
    }
    
}
