package clasePrincipal;

import java.util.Scanner;

/**
 * Esta clase recoge todos los métodos necesarios para ejecutar el ejercicio multiNotas. Como es solo un ejercicio,
 * no se muestra menú.
 */
public class Main {

	public static Scanner	teclado = new Scanner(System.in);
	public static String		entrada = "";
	
	public static String		materias[] = {"Redes", "Bases de Datos", "Programación"};
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
		int		estadisticas[][][][];
		
		estudiantes = cargarEstudiantes(5);
		notas = cargarNotas(estudiantes);
		estadisticas = cargarEstadisticas(estudiantes, notas);
		mostrarEstadisticas(estadisticas, estudiantes);
		teclado.close();
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
			System.out.printf("Número de estudiantes pendientes de registrar: %d.\n", numEstudiantes - i);
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
		
		for ( int i = 0; i < estudiantes.length; i++) {
			System.out.printf("\t- Por favor, ingrese las notas de %s (de las siguientes asignaturas):\n", estudiantes[i]);
			for (int j = 0; j < materias.length; j++) {
				System.out.printf("\t\t- %s: ", materias[j]);
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
		
		estadisticas[0] = cargarPorEstudiante(estudiantes, notas);
		estadisticas[1] = cargarPorMateria(estudiantes, notas);
		estadisticas[2] = cargarPorTotal(estudiantes, notas);;
				
		return (estadisticas);
	}
	
	//falta reservar memoria para porEstudiante[i*5][j] donde j == 2 y j == 4, que es variable
	private static int[][][] cargarPorEstudiante(String estudiantes[], int notas[][]){
		
		int porEstudiante[][][] = new int [estudiantes.length][6][];
		int	total, media;
		int	numSuspensos;
		int	notaMasAlta, notaMasBaja;
		
		//reservar memoria para todos menos el listado de materias suspendidas
		for (int i = 0; i < estudiantes.length; i++) {
			for (int j = 0; j < 6; j++) {
				if (j != 1)
					porEstudiante[i][j] = new int[1];
			}
		}
		
		//cargar la media de cada estudiante
		for (int i = 0; i < estudiantes.length; i++) {
			total = 0;
			media = 0;
			for (int j = 0; j < materias.length; j++) {
				total += notas[i][j];
			}
			media = total / materias.length;
			porEstudiante[i][0][0] = media;
		}
		
		//cargar lista de materias suspendidas de cada estudiante //el nº de suspensos se imprimira en base a 'materiasSuspendidas.length' en un syso
		for (int i = 0; i < estudiantes.length; i++) {
			numSuspensos = 0;
			for ( int j = 0; j < materias.length; j++) {
				if (notas[i][j] < 5)
					numSuspensos++;
			}
			if (numSuspensos > 0) {
				porEstudiante[i][1] = new int[numSuspensos];
				for ( int k = 0; k < numSuspensos; k++) {
					if (notas[i][k] < 5)
						porEstudiante[i][1][k] = k;
				}
			}
			else {//si la materia es -1 significa que no suspendio nada
				porEstudiante[i][1] = new int[1];
				porEstudiante[i][1][0] = -1;
			}
				
		}
		
		//cargar nota mas alta y mas baja de cada estudiante y la asignatura (se contempla la ultima consultada que tenga esa nota)
		for (int i = 0; i < estudiantes.length; i++) {
			notaMasAlta = 0;
			notaMasBaja = 10;
			for ( int j = 0; j < materias.length; j++) {
				if (notas[i][j] < notaMasBaja)
					notaMasBaja = notas[i][j];
				else if (notas[i][j] > notaMasAlta)
					notaMasAlta = notas[i][j];
			}
			porEstudiante[i][2][0] = notaMasAlta;
			porEstudiante[i][4][0] = notaMasBaja;
			for ( int j = 0; j < materias.length; j++) {
				if (notas[i][j] == notaMasAlta)
					porEstudiante[i][3][0] = j;
				if (notas[i][j] == notaMasBaja)
					porEstudiante[i][5][0] = j;
					 
			}
		}
		
		return (porEstudiante);
	}
	
	//falta reservar memoria para porMateria[i*3][j] donde j == 1, que es variable
	private static int[][][] cargarPorMateria(String estudiantes[], int notas[][]){
		
		int porMateria[][][] = new int [materias.length][6][];
		int	total, media;
		int	notaMasBaja, notaMasAlta;
		int	numSuspensos;
		
		//reserva de memoria para todo 
		for (int i = 0; i < materias.length; i++) {
			for (int j = 0; j < 6; j++) 
				porMateria[i][j] = new int[1];
		}
		
		//cargar la media de notas de cada materia
		for (int i = 0; i < materias.length; i++) {
			total = 0;
			media = 0;
			for (int j = 0; j < notas.length; j++) {
				total += notas[j][i];
			}
			media = total / notas.length;
			porMateria[i][0][0] = media;
		}
		
		//puntuacion mas alta y mas baja de la materia y quien la obtuvo
		for ( int i = 0; i < materias.length; i++) {
			notaMasBaja = 10;
			notaMasAlta = 0;

			//cuales son las peores/mejores notas de esa materia
			for (int j = 0; j < estudiantes.length; j++) {
				if (notas[j][i] < notaMasBaja)
					notaMasBaja = notas[j][i];
				else if (notas[j][i] > notaMasAlta)
					notaMasAlta = notas[j][i];
			}
			porMateria[i][1][0] = notaMasAlta;
			porMateria[i][3][0] = notaMasBaja;			
			
			//quien obtuvo las mejores/peores notas de esa materia
			for (int j = 0; j < notas[j][i]; j++) {
				if (notas[j][i] == notaMasBaja)
					porMateria[i][4][0] = j;
				else if (notas[j][i] == notaMasAlta)
					porMateria[i][2][0] = j;
			}
	}
		
		//numero de suspensos en esa materia
		for ( int i = 0; i < materias.length; i++) {
			numSuspensos = 0;
			for ( int j = 0; j < notas.length; j++) {
				if (notas[j][i] < 5)
					numSuspensos++;
			}
			porMateria[i][5][0] = numSuspensos;
		}
		
		return (porMateria);
	}
	
	private static int[][][] cargarPorTotal(String estudiantes[], int notas[][]){
		
		int porTotal[][][] = new int [1][5][];
		int	total = 0, media = 0;
		int	notaMasBaja = 10, notaMasAlta = 0;
		int	totalSuspensosAlumno = 0, totalSuspensosMateria = 0;
		int	masSuspensos = 0, masSuspensosPorMateria = 0;
		
		
		//espacio de memoria reservado completo
		for (int i = 0; i < 5; i++) {
			if (i != 1 && i != 2)
				porTotal[0][i] = new int[1];
			else
				porTotal[0][i] = new int[3];
		}
		
		//cargar media de todas las notas
		for (int i = 0; i < notas.length; i++) {
			for (int j = 0; j < materias.length; j++) {
				total += notas[i][j];
			}
		}
		media = total / (estudiantes.length * materias.length);
		porTotal[0][0][0] = media;
		
		//calificacion mas alta y  mas baja
		for (int i = 0; i < notas.length; i++) {
			for (int j = 0; j < materias.length; j++) {
				if (notas[i][j] < notaMasBaja)
					notaMasBaja = notas[i][j];
				else if (notas[i][j] > notaMasAlta)
					notaMasAlta = notas[i][j];
			}
		}
		porTotal[0][1][0] = notaMasAlta;
		porTotal[0][2][0] = notaMasBaja;
		
		//peor y mejor estudiante y que materia en cada caso
		for (int i = 0; i < notas.length; i++) {
			for (int j = 0; j < materias.length; j++) {
				if (notas[i][j] == notaMasBaja) {
					porTotal[0][2][1] = i;
					porTotal[0][2][2] = j;
				}
				else if (notas[i][j] == notaMasAlta) {
					porTotal[0][1][1] = i;
					porTotal[0][1][2] = j;
				}
			}
		}
		
		//alumno con mas suspensos y materia con mas suspensos
		if (notaMasBaja < 5) {
			//alumno con mas suspensos
			for (int i = 0; i < estudiantes.length; i++)	{
				totalSuspensosAlumno = 0;
				for (int j = 0; j < materias.length; j++) {
					if (notas[i][j] < 5) {
						totalSuspensosAlumno++;
					}
					masSuspensos = totalSuspensosAlumno;
				}
				totalSuspensosAlumno = 0;
				for (int j = 0; j < materias.length; j++) {
					if (notas[i][j] < 5) {
						totalSuspensosAlumno++;
					}
					if (totalSuspensosAlumno == masSuspensos)
						porTotal[0][3][0] = i;
				}
			}
			
			//materia con mas suspensos
			for (int i = 0; i < materias.length; i++)	{
				totalSuspensosMateria = 0;
				for (int j = 0; j < notas.length; j++) {
					if (notas[i][j] < 5) {
						totalSuspensosMateria++;
					}
				}
				if (masSuspensosPorMateria <= totalSuspensosMateria) {
					masSuspensosPorMateria = totalSuspensosMateria;
					porTotal[0][3][0] = i;
				}
			}
			
		}
		else {
			porTotal[0][3][0] = 0;
			porTotal[0][4][0] = 0;
		}
		
		return (porTotal);
	}

	
	/**
	 * Este método muestra por pantalla los resultados estadísticos tras analizar y comparar
	 * las notas de diversos estudiantes. Dichos resultados están en un array tridimensional.
	 * 
	 * @param estadisticas - array de String tridimensional con toda la información.
	 */
	private static void mostrarEstadisticas(int estadisticas[][][][], String estudiantes[]) {
		//asignaturas suspendidas por estudiante:
			//if (materiasSuspendidas == - 1) {"no ha suspendido ninguna asignatura} else {ha suspendido tantas asignaturas: x (listado)}
		
		System.out.println("");
		System.out.printf("");
		
		System.out.println("\t\t----- MOSTRANDO ESTADÍSTICAS DE LAS NOTAS -----");
		
		System.out.println("\n\t- Información sobre cada estudiante:\n");
		
		for (int i = 0; i < estudiantes.length; i++) {
			System.out.printf("\t\t %s:\n", estudiantes[i]);
			System.out.printf("\t\t\t- Su media es %d/10.\n", estadisticas[0][i][0][0]);
			if (estadisticas[0][0][1][0] == -1)
				System.out.printf("\t\t\t- No suspendió ninguna asignatura.\n");
			else {
				System.out.printf("\t\t\t- Suspendió %d materia(s): ", estadisticas[0][i][1].length);
				if (estadisticas[0][0][1].length > 1) {
					for (int j = 0; j < estadisticas[0][0][1].length - 1; j++) {
						System.out.printf("%s, ", materias[estadisticas[0][i][1][j]]);
					}
					System.out.printf("%s.\n", materias[estadisticas[0][i][1][estadisticas[0][i][1].length - 1]]);
				}
				else				
					System.out.printf("%s. ", materias[estadisticas[0][i][1][0]]);
				
			}
			System.out.printf("\t\t\t- La nota más alta que obtuvo fue de un %d en la materia de %s.\n", estadisticas[0][i][2][0], materias[estadisticas[0][i][3][0]]);
			System.out.printf("\t\t\t- La nota más baja que obtuvo fue de un %d en la materia de %s.\n", estadisticas[0][i][4][0], materias[estadisticas[0][i][5][0]]);
			System.out.println("\n\n");
		}
		
		
		System.out.println("\t- Información de cada materia:\n");
		
		for (int i = 0; i < materias.length; i++) {
			System.out.printf("\t\t %s:\n", materias[i]);
			System.out.printf("\t\t\t- La media es %d/10.\n", estadisticas[1][i][0][0]);
			
			System.out.printf("\t\t\t- La nota más alta es un %d y la obtuvo %s.\n", estadisticas[1][i][1][0], estudiantes[estadisticas[1][i][2][0]]);
			System.out.printf("\t\t\t- La nota más baja es un %d y la obtuvo %s.\n", estadisticas[1][i][3][0], estudiantes[estadisticas[1][i][4][0]]);
			
			System.out.printf("\t\t\t- El número total de suspensos en la asignatura es de %d.\n", estadisticas[1][i][5][0]);
			System.out.println("\n\n");
		}
		
		System.out.println("\t- Información general de las notas recogidas:\n");
		
		System.out.printf("\t\t\t- La media de notas es de %d/10.\n", estadisticas[2][0][0][0]);
		System.out.printf("\t\t\t- La nota más alta obtenida es de un %d, la obtuvo %s en la materia de %s.\n", estadisticas[2][0][1][0], estudiantes[estadisticas[2][0][1][1]], materias[estadisticas[2][0][1][2]]);
		System.out.printf("\t\t\t- La nota más alta obtenida es de un %d, la obtuvo %s en la materia de %s.\n", estadisticas[2][0][2][0], estudiantes[estadisticas[2][0][2][1]], materias[estadisticas[2][0][2][2]]);
		System.out.printf("\t\t\t- El alumno que más asignaturas suspendió fue %s.\n", estudiantes[estadisticas[2][0][3][0]]);
		System.out.printf("\t\t\t- La materia con mayor número de suspensos es %s.\n", materias[estadisticas[2][0][4][0]]);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
