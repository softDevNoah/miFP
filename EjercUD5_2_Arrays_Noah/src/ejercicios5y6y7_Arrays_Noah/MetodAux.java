package ejercicios5y6y7_Arrays_Noah;

/**
 * Esta clase contiene métodos considerados auxiliares, es decir, pueden ser llamados para validaciones o tareas
 * menores que son repetitivas.
 */
public class MetodAux {
	
	/**
	 * Este método ofrece un menú de opciones, numeradas a partir del 1, con un título previo y una petición posterior.
	 * Retorna un nº entero que sirve de índice para señalar cuál ha sido la opción seleccionada por el usuario
	 * a través del teclado. Además, integra una validación tal que si el usuario introduce una opción que no
	 * es válida, vuelve a mostrar todo de nuevo.
	 * 
	 * @param titulo - String que encabezará el menú
	 * @param opciones - Listado de opciones que se mostrará con formato por pantalla (si es null, será opcion de Si/No)
	 * @param peticion - String que pide al usuario ingresar la selección deseada.
	 * @return int que hace de índice para indicar la opción seleccionada
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
			
			Main567.entrada = Main567.teclado.nextLine().trim();
			
			if (!Main567.entrada.isEmpty() && checkSoloNumeroPositivoEntero()) {
				
				opcionSeleccionada = Integer.parseInt(Main567.entrada);
				
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
	 * Este método analiza un String para verificar si contiene solamente un nº entero positivo o no.
	 * 
	 * @return boolean esCorrecto con valor true si es un entero positivo y false en caso contrario
	 */
	public static boolean checkSoloNumeroPositivoEntero() {
		boolean esCorrecto = true;

		for (int i = 0; i < Main567.entrada.length(); i++) {
			if (i == 0 && Main567.entrada.charAt(i) == '+')
				i++;
			if (!Character.isDigit(Main567.entrada.charAt(i)))
				esCorrecto = false;
		}
		if (!esCorrecto)
			System.out.println("\t----->>>> Error: introduzca únicamente un número entero (mayor de 0), por favor.");
		return (esCorrecto);
	}
	
	/**
	 * Este método recibe un String y un nº entero (num) e imprime por pantalla dicho String num veces.
	 * 
	 * @param c - String que se desea imprimir repetidamente
	 * @param num - número que indica cuántas veces se desea imprimir por pantalla el String
	 */
	public static void pintarLinea(String c, int num) {
		
		System.out.println();
		for(int i = 0; i < num; i++)
			System.out.printf("%s", c);
		System.out.println();
	
	}
}
