package controlador;

public class ValidarEntrada {

	public static boolean limitesOk(String entrada) {
		
		if (entrada.isEmpty())
			return (false);
		else if( entrada.length() > 1)
			return (false);
		return (true);
	}
	
	public static boolean esNum(String entrada) {
	
		if (!Character.isDigit(entrada.charAt(0)))
			return (false);
		return (true);
	}
	
	public static boolean esTexto(String entrada) {
		
		if (!Character.isAlphabetic(entrada.charAt(0)))
			return (false);
		return (true);
		
	}
}
