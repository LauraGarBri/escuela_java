class EstructurasControl{
	
	public static void main(String [] args){
		
		/*for(int i = 0; i < args.length; i++){
			System.out.println("Args: " + i);
			System.out.println("Args: " + args[i]);
		}*/
		
		int i = 0;
		
		while(i < args.length){
			System.out.println("Args: " + i);
			System.out.println("Args: " + args[i]);
			i++;
		}
		//Bucle infinito
		/*
		for(;;){
			System.out.println("Args: " + i);
			i++;
		}*/
		
		do{
			System.out.println("Siempre se ejecuta");
		}while(false);
		
		
		boolean siEjecutar = (5 < 3)&&(20 == 20);
		
		if(siEjecutar){
			System.out.println("Cuando la condicion es true");
		}else if(5==4){
			System.out.println("Cuando la condicion es rara");
		}else{
			System.out.println("Cuando la condicion es false");
		}
		
		int valor =1;
		
		switch(valor){
			case 0:
				System.out.println("Valor cero");
				break;
			case 1:
				System.out.println("Valor uno");
				break;
			case 2:
				System.out.println("Valor dos");
				break;
			default:
				System.out.println("Valor defecto");
				break;
		}
	
	}
}