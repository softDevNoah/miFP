package vista;


public class Menus {
	private static String menuAceptarPago = "si;no";

	public static void mostrarMenuAceptarPago() {
		imprimirConsola(String.format("menu %s", menuAceptarPago));
	}

	public static void formatoTitulo(String texto) {
		String borde = "-";
		int cantidad;

		texto = texto.substring(2).trim();
		cantidad = texto.length() * 2;

		System.out.printf("\n\n%s\n\t%s\n%s\n\n", borde.repeat(cantidad), texto.toUpperCase(), borde.repeat(cantidad));
	}

	public static void formatoTituloDos(String texto) {
		texto = texto.substring(2).trim();
		System.out.printf("\n\n\t%s\n\n", texto);
	}


	public static void imprimirConsola(String texto) {
		if (texto.startsWith("h1")) {
			formatoTitulo(texto);
		} else if (texto.startsWith("h2")) {
			formatoTituloDos(texto);
		} else if (texto.startsWith("error")) {
			System.out.printf("\t\t[✖] %s\n\n", texto);
		} else if (texto.startsWith("exito")) {
			System.out.printf("\t\t[✔] %s\n\n", texto);
		} else if (texto.startsWith("resultado")) {
			System.out.printf("\t-> %s\n", texto);
		} else if (texto.startsWith("//")) {
			System.out.printf("\t\\\\ %s\n", texto);
		} else {
			System.out.printf("\t:: %s\n", texto);
		}
	}

}
