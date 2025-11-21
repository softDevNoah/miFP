package ejercicios1y2_Arrays_Noah;

public class MetodAux {
	
	
	
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
			
			Main12.entrada = Main12.teclado.nextLine().trim();
			
			if (!Main12.entrada.isEmpty() && checkSoloNumeroPositivoEntero()) {
				
				opcionSeleccionada = Integer.parseInt(Main12.entrada);
				
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
	
	public static boolean checkSoloNumeroPositivoEntero() {
		boolean esCorrecto = true;

		for (int i = 0; i < Main12.entrada.length(); i++) {
			if (i == 0 && Main12.entrada.charAt(i) == '+')
				i++;
			if (!Character.isDigit(Main12.entrada.charAt(i)))
				esCorrecto = false;
		}
		if (!esCorrecto)
			System.out.println("\t----->>>> Error: introduzca únicamente un número entero (mayor de 0), por favor.");
		return (esCorrecto);
	}
	
	public static void pintarLinea(String c, int num) {
		
		System.out.println();
		for(int i = 0; i < num; i++)
			System.out.printf("%s", c);
		System.out.println();
	
	}
}
