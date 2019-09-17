class Operadores {
	
	public static void main (String [] args){
		
		if(args[0].equals("aa")){
			System.out.println("Quieres dos AA");
		}else{
			System.out.println("Quieres otra cosa");
		}
		
		
		//Ternario condicion ? valor verdadero valor falso
		
		System.out.println(5 != 5 ? "Pues si " : " Pues no");
		
		//Ejemplo anterior con operador ternario
		System.out.println(args[0].equals("aa") ? "Quieres dos AA" : "Quieres otra cosa");
		
		
		byte result = 113 & 199;
		System.out.println("AND binario = " + result);
		
		
	}
}