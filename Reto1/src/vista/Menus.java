package vista;

import java.util.Scanner;

public class Menus {
	private static String menuBienvenida = "Hola Bievenido";
	private static String menuTipo = "Snack;Bebida;Dulce;Saludable";
	private static String menuIntermedio = "Comprar;Tipo;Pagar";
	private static String menuPrePago = "Comprar;Tipo;Pagar";
	private static String menuAceptarPago = "si;no";
	private static String[] arraytipos = { "Snacks", "Bebida", "Dulce", "Saludable" };

	public static void mostrarMenuBienvenida() {
		imprimirConsola(String.format("h1 %s", menuBienvenida));
		System.out.print("Presiona una tecla y presiona enter para continuar: ");
		Scanner teclado = new Scanner(System.in);
		String tmp = teclado.nextLine();
		tmp = "";
	}
	
	public static void mostrarAvisoTipoElegido(int numero) {
		System.out.printf(String.format("\n\t- Tipo seleccionado: \"%s\"\n", arraytipos[numero]));
	}

	public static void mostrarTipos() {
		imprimirConsola(String.format("menu %s", menuTipo));
	}

	public static void mostrarMenuProductos(String[][] tipo) {
		Productos.mostrarProductos(tipo);
	}

	public static void mostrarMenuIntermedio() {
		imprimirConsola(String.format("menu %s", menuIntermedio));
	}

	public static void mostrarMenuPrePago() {
		imprimirConsola(String.format("menu %s", menuPrePago));
	}
	
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

	public static void formatoMenu(String texto) {
		String[] arrayMenu;
		texto = texto.replaceFirst("menu", "").trim();
		arrayMenu = texto.split(";");
		String resultado = "";

		for (int i = 0; i < arrayMenu.length; i++) {
			resultado += String.format("\t %d. %s\n", i + 1, arrayMenu[i]);
		}
		
		System.out.printf("%s\n", resultado);
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
		} else if (texto.startsWith("menu")) {
			formatoMenu(texto);
		} else {
			System.out.printf("\t:: %s\n", texto);
		}
	}

}
