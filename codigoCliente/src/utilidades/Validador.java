package utilidades;

public class Validador {
	private static String limiteMinimo = String.valueOf(Integer.MIN_VALUE).substring(1);
	private static String limiteMaximo = String.valueOf(Integer.MAX_VALUE);
	
	public static boolean esEntero(String cadena) {
		boolean resultado = true;
		char primerCaracter = cadena.charAt(0);
		int indice = 0;
		boolean negativo = false;
		boolean todosNumeros = false;
		cadena = cadena.trim();
		String numero = "";
		

		if (cadena == null || cadena.length() == 0) {
			resultado = false;
			
		} else {

			if (primerCaracter == '-') { //numero negativo
				negativo = true;
				indice = 1;
				if (cadena.length() == 1) {
					resultado = false;
				} else {
					todosNumeros = evalularNumeros(cadena, indice);
					// numero sin el signo
					numero = cadena.substring(indice);
					
					if (todosNumeros) {
						resultado = evaluarLimites(numero, negativo);
					} else {
						resultado = false;
					}
					
				}
				
			} else { // numero positivo
				todosNumeros = evalularNumeros(cadena, indice);
				
				if (todosNumeros) {
					resultado = evaluarLimites(cadena, negativo);
				} else {
					resultado = false;
				}
			}

		}

		return resultado;
	}
	
	public static boolean evaluarLimites(String cadena, boolean negativo) {
		boolean resultado = false;
		
		if (cadena.length() > 10) {
			resultado = false;
		} else if (cadena.length() < 10) {
			resultado = true;
		} else if (cadena.length() == 10) {

			if (negativo) {
				if (cadena.compareTo(limiteMinimo) <= 0) {
					resultado = true;
				} else {
					resultado = false;
				}
			} else {
				if (cadena.compareTo(limiteMaximo) <= 0) {
					resultado = true;
				} else {
					resultado = false;
				}
			}
		}
		
		return resultado;
	}

	public static boolean evalularNumeros(String cadena, int indice) {
		boolean resultado = true;
		char caracter;
		for (int i = indice; i < cadena.length(); i++) {
			caracter = cadena.charAt(i);
			if (!Character.isDigit(caracter)) {
				resultado = false;
				break;
			}
		}

		return resultado;
	}

	public static boolean esDouble(String entrada) {
		boolean tienePunto = false;
		char caracter;
		boolean esValido = true;

		for (int i = 0; i < entrada.length(); i++) {
			caracter = entrada.charAt(i);

			if (Character.isDigit(caracter)) {

			} else if (caracter == '.' && !tienePunto) {
				tienePunto = true;
			} else {
				esValido = false;
				break;
			}
		}

		return esValido;
	}

}
