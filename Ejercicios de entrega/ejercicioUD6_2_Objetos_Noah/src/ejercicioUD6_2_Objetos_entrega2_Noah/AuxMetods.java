package ejercicioUD6_2_Objetos_entrega2_Noah;

public class AuxMetods {

	/**
	 * Esta función analiza un String de la clase Main de este programa para determinar si es un número entero positivo o no. Si es otro tipo
	 * de dato o si resulta ser un número entero negativo, devolverá un booleano con valor false. En caso contrario, con valor true.
	 * @return boolean esCorrecto 
	 */
	public static boolean checkSoloNumeroPositivoEntero(String entrada) {
		
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
	 * Este método revisa y valida si los datos introducidos por un usuario a través
	 * del teclado son un número decimal o no.
	 * Solo permite dígitos y un único punto decimal como separador.
	 * 
	 * @param entrada - String a validar
	 * @return true si es un número decimal válido, false en caso contrario
	 */
	public static boolean checkSoloNumeroDecimal(String entrada) {
		
		boolean esCorrecto = true;
		boolean	hayNums = false;
		int		numPuntos = 0;

		for (int i = 0; i < entrada.length(); i++) {
			
			if (Character.isDigit(entrada.charAt(i)))
				hayNums = true;
			
			else if (entrada.charAt(i) == '.') {
				
				numPuntos++;
				
				if (numPuntos > 1) {
					esCorrecto = false;
					return (esCorrecto);
				}
			}
			else {
				esCorrecto = false;
				return (esCorrecto);
			}		
		}
		
		if (!hayNums) {
			return (hayNums);
		}
		return (esCorrecto);
	}
}
