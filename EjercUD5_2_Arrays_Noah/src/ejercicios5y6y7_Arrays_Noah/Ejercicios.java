package ejercicios5y6y7_Arrays_Noah;

public class Ejercicios {

	public static void	ejecutar5() {
		
		char		sorteo[];
		int		frecuencias[];
		
		//Código ASCII:
		//	'a' es 97
		//	'z' es 122
		
		sorteo = generarSorteo(100, 97, 122);
		mostrarSorteo(sorteo);
		System.out.println();
		frecuencias = contarFrecuencias(sorteo, 97, 122);
		mostrarFrecuencias(frecuencias, 97, 122);
		
	}

	
	private static char[] generarSorteo(int numTiradas, int valorMin, int valorMax) {
		
		char sorteo[] = new char[numTiradas];
		
		for (int i = 0; i < numTiradas; i++) {
			sorteo[i] = (char)Math.floor(Math.random() * (valorMax - valorMin + 1) + valorMin); // (max - min + 1) - min
		}
		
		return (sorteo);
	}
	
	//mostrar en 15 columnas
	private static void	mostrarSorteo(char arraySorteo[]) {
		
		int iter = 0;
		
		//cabecera de columnas:
		MetodAux.pintarLinea("____", 20);
		System.out.printf("\t|");
		for (int i = 0; i < 15; i++) {
			System.out.printf(" %d |", i + 1);
		}
		System.out.println();
		MetodAux.pintarLinea("____", 20);
		
		//contenido del array distribuido en 15 columnas:
		do {
			System.out.printf("\t|");
			for (int j = 0; j < 9 && iter < arraySorteo.length; j++) {
				System.out.printf(" %c |", arraySorteo[iter++]);
			}
			for (int j = 9; j < 15 && iter < arraySorteo.length; j++) {
				System.out.printf(" %c  |", arraySorteo[iter++]);
			}
			MetodAux.pintarLinea("____", 20);
		} while (iter < arraySorteo.length);
		
	}
	
	private static int[] contarFrecuencias(char arraySorteo[], int valorMin, int valorMax) {
		
		int	contador = valorMax - valorMin + 1;
		int	vecesRep;
		int	frecuencias[] = new int[contador];
		
		for (int i = 0; i < contador; i++){
			vecesRep = 0;
			for (int j = 0; j < arraySorteo.length; j++) {
				if (arraySorteo[j] == (char)(i + valorMin))
					vecesRep++;
			}
			frecuencias[i] = vecesRep;
		}
		return (frecuencias);
	}

	private static void mostrarFrecuencias(int arrayFrecuencias[], int valorMin, int valorMax) {
		
		System.out.println("\tCantidad de veces que se ha repetido cada letra en el sorteo:");
		for (int i = 0, j = 0; i <= valorMax - valorMin; i++, j++)
			System.out.printf("\t- Letra %c: %d veces.\n", (char)(i + valorMin), arrayFrecuencias[j]);
		
	}
	
/*--------------------------------------------------------------------------------------------------------------------------*/
	
	public static void	ejecutar6() {
			
			
	}
		
//	private static int[] cargarTabla(int n, int valorMin, int valorMax) {
//		
//		
//	}
//	
//	private static int[] invertirTabla(int array[]){
//		
//	}
//
//	private static void mostrarArray(int array[]) {
//		
//		
//	}	
	

/*--------------------------------------------------------------------------------------------------------------------------*/

	
	public static void	ejecutar7() {
		

		
	}
	
//	private static int[] moverCerosFinal(int array[]){
//			
//		}
}
