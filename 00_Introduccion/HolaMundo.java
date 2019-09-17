class HolaMundo{
	public static void main(String[] args){
		System.out.println("Hola Mundo!");
		String nombre ="Laura";
		System.out.println("Hola " + nombre +"!");
		
		//Tipos de datos 
		byte unByte = 127; // desde -128 ocupa 1 byte
		System.out.println("Byte: " + unByte);
		
		int numero = 1234567890; // ocupa 4 byte
		System.out.println("Entero: " + numero);
		
		float decimalFloat = 12345678901F; //ocupa 4 byte
		System.out.println("Decimal Float: " + decimalFloat);
		
		double decimalDoble = 1.2345678901234567; // ocupa 8 byte
		System.out.println("Decimal double: " + decimalDoble);
		
		long entLargo =1234567890123456789L; 
		System.out.println("Entero largo: " + entLargo);
		
		char caracter = 'a'; //Si ponemos numeros serian la correspondencia en ASCII
		System.out.println("caracter: "  + caracter);
		
		char[] texto= {'a','b','c','d'};
		System.out.println("Array : "  + texto[1]);
		
		for(int i=0; i < texto.length;i++){
			System.out.println("Array de caracteres: "  + texto[i]);
		}
		
			
		

	}
}