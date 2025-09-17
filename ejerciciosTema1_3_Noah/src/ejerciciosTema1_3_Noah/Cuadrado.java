package ejerciciosTema1_3_Noah;

public class Cuadrado {

	public static void main(String[] args) {
		
		//int numero=2,	//no es un error, pero seria mas conveniente poner todo en una linea o en dos pero siendo dos instrucciones diferentes con sus ;
		int numero = 2;
		//cuad=numero*número;	//ERROR_1: el nombre de la variable tiene una errata
		int cuad = numero * numero;

		//System.out.println("EL CUADRADO DE "+NUMERO+" ES: "+cuad);	//ERROR_2: el nombre de la variable debe ir en minúsculas
		System.out.println("EL CUADRADO DE "+numero+" ES: "+cuad);
	}

}
