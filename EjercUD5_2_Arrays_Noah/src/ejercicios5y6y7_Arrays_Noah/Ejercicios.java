package ejercicios5y6y7_Arrays_Noah;

/**
 * Esta clase contiene los ejercicios 5, 6 y 7 y sus respectivos métodos. 
 */
public class Ejercicios {

	/**
	 * 
	 */
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

	/**
	 * 
	 * @param numTiradas
	 * @param valorMin
	 * @param valorMax
	 * @return
	 */
	private static char[] generarSorteo(int numTiradas, int valorMin, int valorMax) {
		
		char sorteo[] = new char[numTiradas];
		
		for (int i = 0; i < numTiradas; i++) {
			sorteo[i] = (char)Math.floor(Math.random() * (valorMax - valorMin + 1) + valorMin); // (max - min + 1) - min
		}
		
		return (sorteo);
	}
	
	/**
	 * 
	 * @param arraySorteo
	 */
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
		
		//contenido del array distribuido en 15 columnas, segun enunciado:
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
	
	/**
	 * 
	 * @param arraySorteo
	 * @param valorMin
	 * @param valorMax
	 * @return
	 */
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

	/**
	 * 
	 * @param arrayFrecuencias
	 * @param valorMin
	 * @param valorMax
	 */
	private static void mostrarFrecuencias(int arrayFrecuencias[], int valorMin, int valorMax) {
		
		System.out.println("\tCantidad de veces que se ha repetido cada letra en el sorteo:");
		for (int i = 0, j = 0; i <= valorMax - valorMin; i++, j++)
			System.out.printf("\t- Letra %c: %d veces.\n", (char)(i + valorMin), arrayFrecuencias[j]);
		
	}
	
	/**
	 * 
	 */
	public static void	ejecutar6() {
			
		int	valorMin, valorMax, tamaño;
		int	tabla[];
		
		valorMin = 1;
		valorMax = 100;
		tamaño = 20;
		
		tabla = cargarTabla(tamaño, valorMin, valorMax);
		System.out.println("Tabla original:");
		mostrarArray(tabla);
		tabla = invertirTabla(tabla);
		System.out.println("Tabla invertida:");
		mostrarArray(tabla);
	}
		
	/**
	 * 
	 * @param n
	 * @param valorMin
	 * @param valorMax
	 * @return
	 */
	private static int[] cargarTabla(int n, int valorMin, int valorMax) {
		
		int	tabla[] = new int[n];
		
		for (int i = 0; i < n; i++)
			tabla[i] = (int)Math.floor(Math.random() * (valorMax - valorMin + 1) + valorMin);
		
		return (tabla);
	}
	
	/**
	 * 
	 * @param array
	 * @return
	 */
	private static int[] invertirTabla(int array[]){
		
		int tmp = 0;
		for (int i = 0, j = array.length - 1; i < j; i++, j--) {
			tmp = array[i];
			array[i] = array[j];
			array[j] = tmp;
		}
		return (array);
	}

	/**
	 * 
	 */
	private static void mostrarArray(int array[]) {
		
		System.out.print("\t");
		for (int i = 0; i < array.length - 1; i++)
			System.out.printf("%d, ", array[i]);
		System.out.printf("%d.\n\n", array[array.length -1]);
	}	
	
	/**
	 * 
	 */
	public static void	ejecutar7() {
		
		int	valorMin, valorMax, tamaño;
		int	tabla[];
		
		valorMin = 0;
		valorMax = 5;//elijo un valor bajo para aumentar la cantidad de 0 por probabilidad
		tamaño = 20;
		
		tabla = cargarTabla(tamaño, valorMin, valorMax);
		System.out.println("Situación original:");
		mostrarArray(tabla);
		tabla = moverCerosFinal(tabla);
		System.out.println("Situación final:");
		mostrarArray(tabla);
		
	}
	
	/**
	 * 
	 * @param array
	 * @return
	 */
	private static int[] moverCerosFinal(int array[]){
		
		int tmp1 = 0;
		
		//el bucle exterior asegura que no quede NINGUN cero mal por error, haciendo varias veces el proceso
		//si no, a veces algun cero queda por la izquierda
		for (int i = 0; i < array.length; i++) {
			
			for (int j = 0; j < array.length; j++) {
				if (array[j] == 0) {
					for (int k = j; k < array.length - 1; k++) {
						tmp1 = array[k];
						array[k] = array[k + 1];
						array[k + 1] = tmp1;
					}
				}
			}
		}
		return (array);
		
	}
}
