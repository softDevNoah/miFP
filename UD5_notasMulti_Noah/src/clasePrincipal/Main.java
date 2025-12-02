package clasePrincipal;

import java.util.Scanner;

/**
 * Esta clase recoge todos los métodos necesarios para ejecutar el ejercicio multiNotas. Como es solo un ejercicio,
 * no se muestra menú.
 */
public class Main {

	public static Scanner	teclado = new Scanner(System.in);
	public static String		entrada = "";
	
	/**
	 * Este método recoge el funcionamiento básico del programa.
	 * Primeramente, se solicita al usuario que introduzca los nombres de 5 estudiantes. Luego, pide uno por uno que
	 * se introduzca las notas de 3 asignaturas.
	 * Y finalmente, se muestran las estadísticas generadas tras analizar dichas notas y compararlas entre sí.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		String	estudiantes[];
		int		notas[][];
		int		estadisticas[][][];
		
		estudiantes = cargarEstudiantes(5);
		notas = cargarNotas(estudiantes);
		estadisticas = cargarEstadisticas(estudiantes, notas);
		mostrarEstadisticas(estadisticas);
		
	}

	/**
	 * Este método solicita al usuario que ingresa por teclado los nombres y apellidos de diversos estudiantes.
	 * Finalmente devuelve un array de String con los nombres y apellidos de los estudiantes.
	 * 
	 * @param numEstudiantes
	 * @return
	 */
	private static String[] cargarEstudiantes(int numEstudiantes) {
		
		String	estudiantes[] = new String[numEstudiantes];
		String	tmp;
		
		for (int i = 0; i < numEstudiantes; i++) {
			estudiantes[i] = pedirNombreApellido(0);
			tmp = estudiantes[i];
			estudiantes[i] = pedirNombreApellido(1);
			tmp = tmp + " " + estudiantes[i];
			estudiantes[i] = tmp;
		}
		return (estudiantes);
	}
	
	/**
	 * Este método solicita al usuario que ingrese o el nombre o los apellidos de un estudiante, valida verifica
	 * la entrada de datos para asegurarse de que sean caracteres alfabeticos. 
	 * Finalmente lo devuelve para posterior tratamiento.
	 * 
	 * @param indicePeticion
	 * @return nombreApellidos - String con el nombre o los apellidos del estudiante
	 */
	private static String pedirNombreApellido(int indicePeticion) {
		
		String	peticion[] = {"un nombre", "unos apellidos"};
		boolean	esCorrecto;
		
		String nombreApellidos = "";
		
		do {
			esCorrecto = true;
			System.out.printf("\tPor favor, ingrese %s: ", peticion[indicePeticion]);
			entrada = teclado.nextLine().trim();
			if (!entrada.isBlank()) {
				for (int i = 0; i < entrada.length(); i++) {
					if (!Character.isAlphabetic(entrada.charAt(i)) && entrada.charAt(i) != ' ')
						esCorrecto = false;
				}
			}
			else
				esCorrecto = false;
			
		} while (!esCorrecto);
		
		System.out.println();
		nombreApellidos = entrada;
		
		return (nombreApellidos);
	}
	
	/**
	 * Este método pide al usuario que ingrese por teclado las notas de unos estudiantes cuyos nombres
	 * ya han sido introducidos.
	 * 
	 * @param estudiantes - array de String con los nombres de los estudiantes recogidos previamente
	 * @return notas - array de int con las notas introducidas por el usuario
	 */
	private static int [][] cargarNotas(String estudiantes[]){
		
		int		notas[][] = new int[estudiantes.length][3];
		String	asignaturas[] = {"Redes", "Base de Datos", "Programación"};
		
		for ( int i = 0; i < estudiantes.length; i++) {
			System.out.printf("\t- Por favor ingrese las notas de %s de las siguientes asignaturas:\n", estudiantes[i]);
			for (int j = 0; j < asignaturas.length; j++) {
				System.out.printf("\t\t- %s: ", asignaturas[j]);
				notas[i][j] = pedirNota();
			}
		}
		return (notas);
	}
	
	/**
	 * Este método recoge por teclado una nota y verifica que sea válida. Si no lo es, muestra un mensaje de error
	 * e insta a volver a intentarlo hasta que sea correcta. Cuando es correcta, la devuelve como int.
	 * @return
	 */
	private static int pedirNota() {
		
		int		nota = -1;
		boolean	esCorrecto;
		do {
			esCorrecto = true;
			entrada = teclado.nextLine().trim();
			if (!entrada.isBlank() && entrada.length() < 3) {
				for (int i = 0; i < entrada.length(); i++) {
					if (!Character.isDigit(entrada.charAt(i)))
						esCorrecto = false;
				}
				if (esCorrecto) {
					nota = Integer.parseInt(entrada);
					if (nota < 0 || nota > 10)
						esCorrecto = false;
				}				
			}
			else
				esCorrecto = false;
			if (!esCorrecto)
				System.out.println("\t--->>> Error: solo un número del 0 al 10. <<<---\n\t\tInténtelo otra vez: ");
			
		} while (!esCorrecto);
	
		return (nota);
	}
	
	
	/**
	 * Este método analiza y compara las notas de diversos estudiantes y carga los resultados 
	 * en un array de String tridimensional. Para ello llama a diversos métodos. Finalmente lo devuelve.
	 * 
	 * @param estudiantes
	 * @param notas
	 * @return
	 */
	private static int[][][][] cargarEstadisticas(String estudiantes[], int notas[][]) {
		
		int	estadisticas[][][][] = new int[3][][][];
				
		int	datosEstudiantes[][][];
		int	datosMaterias[][][];
		int	datosTotal[][][];
		
		datosEstudiantes = cargarPorEstudiante(estudiantes, notas);
		datosMaterias = cargarPorMateria(estudiantes, notas);
		datosTotal = cargarPorTotal(estudiantes, notas);
		
		estadisticas[0] = datosEstudiantes;
		estadisticas[1] = datosMaterias;
		estadisticas[2] = datosTotal;
		
		return (estadisticas);
	}
	
	
	private static int[][][] cargarPorEstudiante(String estudiantes[], int notas[][]){
		
		int estadisticas[][][] = new int [estudiantes.length][6][];
		
		for (int i = 0; i < estudiantes.length; i++) {
			for (int j = 0; j < 6; j++) {
				if (j != 2 && j != 4)
					estadisticas[i][j] = new int[1];
			}
		}
		
		return (estadisticas);
	}
	
	private static int[][][] cargarPorMateria(String estudiantes[], int notas[][]){
		
		int estadisticas[][][] = new int [estudiantes.length][6][];
		
		for (int i = 0; i < notas[0].length; i++) {
			for (int j = 0; j < 6; j++) {
				if (j != 1)
					estadisticas[i][j] = new int[1];
			}
		}
		
		estadisticas[0] = cargarMedia(notas[0]);
		
		return (estadisticas);
	}
	
	private static int[][][] cargarPorTotal(String estudiantes[], int notas[][]){
		
		int estadisticas[][][] = new int [1][5][];
		
		for (int i = 0; i < 5; i++) {
			if (i != 1 && i != 2)
				estadisticas[0][i] = new int[1];
			else
				estadisticas[0][i] = new int[3];
		
		}
		return (estadisticas);
	}
	
	private static int cargarMedia(int arrayNum[]) {
		
		int total;
		int media;
		
		total = 0;
		media = 0;
		for (int i = 0; i < arrayNum.length; i++) {
			total += arrayNum[i];
		}
		media = total / arrayNum.length;
		
		return (media);
	}
	
	//metodo cargarPorMateria(estadisticas)
	//metodo cargarPorTotal(estadisticas)
	
	
	/**
	 * Este método muestra por pantalla los resultados estadísticos tras analizar y comparar
	 * las notas de diversos estudiantes. Dichos resultados están en un array tridimensional.
	 * 
	 * @param estadisticas - array de String tridimensional con toda la información.
	 */
	private static void mostrarEstadisticas(int estadisticas[][][]) {
		
		
	}
}
