package ejercicios5y6y7_Arrays_Noah;

/**
 * Esta clase contiene los ejercicios 5, 6 y 7 y sus respectivos métodos. 
 */
public class Ejercicios {

	/**
	 * Este método contiene todo el funcionamiento lógico del ejercicio  de la entrega 3/3 de Arrays.
	 * Tiene dos variables, un array de char y otro de int. Este array de char se carga de caracteres
	 * asignados aleatoriamente, de la a minúscula a la z minúscula en este caso. Se muestra con formato
	 * de 15 columnas, se contabiliza cuántas veces aparece cada letra y se muestra por pantalla.
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
	 * Este método crea un array de char de tamaño numTiradas (int que recibe), y usa el código ASCII para poder
	 * determinar cuáles son los caracteres que abarcará este array, indicados por parametro (ints valorMin
	 *  y valorMax), haciendo casteo de datos para poder almacenarlo correctamente. 
	 * 
	 * @param numTiradas - int que determina el tamaño del array
	 * @param valorMin - nº entero que es el código ASCII del valor mínimo del rango de caracteres
	 * @param valorMax - nº entero que es el código ASCII del valor máximo del rango de caracteres
	 * @return sorteo - array de char con los caracteres aleatorios dentro del rango indicado
	 */
	private static char[] generarSorteo(int numTiradas, int valorMin, int valorMax) {
		
		char sorteo[] = new char[numTiradas];
		
		for (int i = 0; i < numTiradas; i++) {
			sorteo[i] = (char)Math.floor(Math.random() * (valorMax - valorMin + 1) + valorMin); // (max - min + 1) - min
		}
		
		return (sorteo);
	}
	
	/**
	 * Este método muestra por pantalla los caracteres del array tipo char, con un formato de tabla de 15 columnas.
	 * En las columnas a partir de la 10, se imprime conservando las proporciones para que se vea ordenado.
	 * 
	 * @param arraySorteo - array de char con los caracteres
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
	 * Este método contabiliza las apariciones de cada caracter en la tabla (array de char).
	 * 
	 * @param arraySorteo - array de caracteres del sorteo
	 * @param valorMin - nº entero que es el código ASCII del valor mínimo del rango de caracteres
	 * @param valorMax - nº entero que es el código ASCII del valor máximo del rango de caracteres
	 * @return frecuencias - array de int con el nº de apariciones de cada caracter en el mismo orden secuencial ASCII
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
	 * Este método muestra por pantalla la frecuencia de aparición de cada caracter en el sorteo. En este caso,
	 * como son letras, en el mensaje aparece letras en vez de caracteres.
	 * 
	 * @param arrayFrecuencias - array de int con el nº de apariciones de cada caracter en el mismo orden secuencial ASCII
	 * @param valorMin - nº entero que es el código ASCII del valor mínimo del rango de caracteres
	 * @param valorMax - nº entero que es el código ASCII del valor máximo del rango de caracteres
	 */
	private static void mostrarFrecuencias(int arrayFrecuencias[], int valorMin, int valorMax) {
		
		System.out.println("\tCantidad de veces que se ha repetido cada letra en el sorteo:");
		for (int i = 0, j = 0; i <= valorMax - valorMin; i++, j++)
			System.out.printf("\t- Letra %c: %d veces.\n", (char)(i + valorMin), arrayFrecuencias[j]);
		
	}
	
	/**
	 * Este método contiene todo el funcionamiento lógico del ejercicio 6 de la entrega 3/3 de Arrays.
	 * Se genera un array de int de en este caso 20 números, se muestra, después se invierte usando solamente un int auxiliar
	 * y se imprime por pantalla el array ya modificado.
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
	 * Este método recibe los valores necesarios para crear un array de enteros aleatorios dentro del rango indicado.
	 * 
	 * @param n - tamaño del array de enteros que se crea
	 * @param valorMin - nº entero de valor mínimo del rango
	 * @param valorMax - nº entero de valor máximo del rango
	 * @return tabla - array de int con los valores asignados
	 */
	private static int[] cargarTabla(int n, int valorMin, int valorMax) {
		
		int	tabla[] = new int[n];
		
		for (int i = 0; i < n; i++)
			tabla[i] = (int)Math.floor(Math.random() * (valorMax - valorMin + 1) + valorMin);
		
		return (tabla);
	}
	
	/**
	 * Este método usa una variable int temporal para ir intercambiando de sitio cada valor. Solo se recorre la mitad del
	 * array en el bucle. Finalmente devuelve el array ya invertido.
	 * 
	 * @param array - array de int original
	 * @return array - el array recibido, con los valores invertidos de posición
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
	 * Este método imprime un array por pantalla con formato de listado.
	 * 
	 * @param array - array de int 
	 */
	private static void mostrarArray(int array[]) {
		
		System.out.print("\t");
		for (int i = 0; i < array.length - 1; i++)
			System.out.printf("%d, ", array[i]);
		System.out.printf("%d.\n\n", array[array.length -1]);
	}	
	
	/**
	 * Este método contiene todo el funcionamiento lógico del ejercicio 7 de la entrega 3/3 de Arrays.
	 * Crea una tabla, en este caso un array de int, lo carga con valores entre 0 y valorMax, y luego
	 * de mostrarlo por pantalla, mueve los ceros a las últimas posiciones y vuelve a mostrarlo.
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
	 * Este método recibe un array de int, y mediante bucles y una variable int temporal, va sustituyendo la posición
	 * de cada 0 que se encuentra hacia el final. Este proceso lo repite tantas veces como posiciones tiene, asegurando
	 * que no quede ningún 0 a la izquierda de otro número distinto. En esta propuesta, los 0 se mueven, no se escriben.
	 * 
	 * @param array - array de int con los valores ya cargados.
	 * @return array - el array con los 0 movidos a la derecha, en caso de tenerlos.
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
