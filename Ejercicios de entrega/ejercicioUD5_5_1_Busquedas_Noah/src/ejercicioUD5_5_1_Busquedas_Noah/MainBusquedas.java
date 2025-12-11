package ejercicioUD5_5_1_Busquedas_Noah;

import java.util.Scanner;

/**
 * Esta clase contiene el método main y otros métodos relacionados con el formateo de mensajes
 * impresos por pantallas o la gestión del menú de operaciones del ejercicio.Tiene dos
 * atributos estáticos que se usarán durante la ejecución del programa para recibir datos
 * por teclado.
 * 																		
 */
public class MainBusquedas {

	public static Scanner	teclado = new Scanner(System.in);
	public static String	entrada = "";
	
	/**
	 * Este método main muestra al usuario por pantalla un menú de operaciones disponibles y el estado 
	 * actualizado de la matrix. Cuando se selecciona una operación, se muestra un mensaje informativo por
	 * pantalla y se ejecuta dicha operación. 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		int		opcion = -1;
		String	opciones[] = {"Introducir un valor", "Encontrar un valor", "Eliminar un valor", "Salir del programa"};	
		int		matrix[] = null;
		
		pintarLinea("~ ", 35);
		System.out.println("\t\t---- ¡Bienvenidx al juego de la matrix! ----\n\n");
				
		do {
			Operaciones.mostrarMatrix(matrix);
			opcion = menuOpciones("Operaciones disponibles", opciones, "Seleccione una opción, por favor");
			
			switch (opcion) {
				case 0:
					msgEjecutandoOpcion(0);
					matrix = Operaciones.ingresarValor(matrix);
					pintarLinea("~", 70);
					break;
				case 1:
					msgEjecutandoOpcion(1);
					Operaciones.encontrarValor(matrix);
					pintarLinea("~", 70);
					break;
				case 2:
					msgEjecutandoOpcion(2);
					matrix = Operaciones.eliminarValor(matrix);
					pintarLinea("~", 70);
					break;
			}
		} while (opcion != 3);
		
		pintarLinea("~", 70);
		System.out.println("\n\t\t---- ¡Hasta la próxima! ----\n");
		pintarLinea("~ ", 35);
	}

	
	/**
	 * Esta función recibe un String que hará de título de un menú, un array de Strings (o null) que se usará como listado de opciones
	 * de dicho menú, y un String que servirá como petición de entrada de datos por teclado.
	 * Posteriormente, recoge dicha entrada, valida que sea de un tipo válido, revisa que está entre las opciones que se muestran, y lo
	 * devuelve (un número entero que indica el índice o posición de la opción del menú que se ha elegido).
	 * 
	 * @param titulo	- String título del menú de opciones.
	 * @param opciones	- Array de Strings opciones del menú, o null, que indica que será de respuesta sí o no.
	 * @param peticion	- String de petición de entrada de datos.
	 * @return posicion - int de posición de la respuesta elegida dentro del array "opciones".
	 */
	public static int menuOpciones(String titulo, String opciones[], String peticion) {
		
		String	siNo[] = {"Sí", "No"};
		int		opcionSeleccionada = 0;
		boolean	esCorrecto;
		
		if (opciones == null)
			opciones = siNo;
		do {
			esCorrecto = true;
			System.out.printf("\n\n\t------> %s <<<<<<------\n\n", titulo);
			
			for (int i = 0; i < opciones.length; i++) 
				System.out.printf("\t\t%d.- %s.\n", i + 1, opciones[i]);
			
			System.out.printf("\n\t·····> %s: ", peticion);
			
			entrada = teclado.nextLine().trim();
			
			if (!entrada.isEmpty() && checkSoloNumeroPositivoEntero()) {
				
				opcionSeleccionada = Integer.parseInt(entrada);
				
				if ((opcionSeleccionada < 1) || (opcionSeleccionada > opciones.length)) {
					System.out.println("\t-------> Error: opción incorrecta...");
					esCorrecto = false;
				}
			}
			else 
				esCorrecto = false;
		} while (!esCorrecto);
	
		return (opcionSeleccionada - 1);
	}
	
	/**
	 * Esta función analiza un String de la clase Main de este programa para determinar si es un número entero positivo o no. Si es otro tipo
	 * de dato o si resulta ser un número entero negativo, devolverá un booleano con valor false. En caso contrario, con valor true.
	 * @return boolean esCorrecto 
	 */
	public static boolean checkSoloNumeroPositivoEntero() {
		
		boolean esCorrecto = true;

		for (int i = 0; i < entrada.length(); i++) {
			if (i == 0 && entrada.charAt(i) == '+')
				i++;
			if (!Character.isDigit(entrada.charAt(i)))
				esCorrecto = false;
		}
		
		if (!esCorrecto)
			System.out.println("\n\t----->>>> Error: introduzca únicamente un número entero (mayor de 0), por favor.");
		
		return (esCorrecto);
	}
	
	/**
	 * Este pequeño método recibe un String que podría ser o no un solo caracter, y un int que servirá para indicar el número de veces
	 * que se imprimirá el String por pantalla.
	 * @param c - Es un String que contendrá bien un caracter o más caracteres. 
	 * @param num - Número de veces que se repetirá el bucle.
	 */
	public static void pintarLinea(String c, int num) {
		
		System.out.println();
		
		for(int i = 0; i < num; i++)
			System.out.printf("%s", c);
		
		System.out.println();
	}
	
	/**
	 * Este método se encarga de mostrar por pantalla con formato qué operación se está realizando. Recibe el índice de la
	 * opcion elegida por el usuario previamente para identificar qué mensaje mostrar.
	 * 
	 * 
	 * @param opcion - int que es índice de la opcion seleccionada previamente
	 */
	private static void msgEjecutandoOpcion(int opcion) {
		
		String accion[] = {"Ingresando nuevo valor", "Encontrando un valor", "Eliminando un valor"};
		
		pintarLinea("~", 70);
		System.out.printf("\n\t\t---- %s... ----\n\n", accion[opcion]);
	}
}
