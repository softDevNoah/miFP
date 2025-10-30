package controlador;

import java.util.Scanner;

import modelo.Calculadora;
import modelo.ExpandirArray;
import utilidades.Validador;
import vista.Menus;
import vista.Productos;
import java.lang.Thread;

public class Main {
	public static String[][] tipo1 = { { "90324", "Snack", "Papas Lays", "1.50" },
			{ "04561", "Snack", "Doritos", "1.60" }, { "06651", "Snack", "Galletas Oreo", "1.20" },
			{ "32325", "Snack", "Barritas Cereal", "1.40" } };

	public static String[][] tipo2 = { { "09439", "Bebida", "Coca-Cola", "1.20" },
			{ "09123", "Bebida", "Agua Mineral", "1.00" }, { "09532", "Bebida", "Jugo de Naranja", "1.50" },
			{ "54923", "Bebida", "Red Bull", "2.00" } };

	public static String[][] tipo3 = { { "54013", "Dulce", "Snickers", "0.90" }, { "59023", "Dulce", "M&M's", "1.10" },
			{ "54621", "Dulce", "KitKat", "1.00" }, { "54900", "Dulce", "Chicles Trident", "0.80" } };

	public static String[][] tipo4 = { { "54013", "Saludable", "Barra de granola", "1.80" },
			{ "54090", "Saludable", "Fruta deshidratada", "2.00" },
			{ "49092", "Saludable", "Mix de frutos secos", "2.20" }, { "09430", "Saludable", "Yogur griego", "1.90" } };

	public static String[][][] tipos = { tipo1, tipo2, tipo3, tipo4 };
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		menuGeneral();
	}

	public static void fasePago(double precioTotal) {
		double dineroIntroducido = 0;
		double faltante;

		System.out.println("El precio total es: " + String.format("%.2f", precioTotal) + "€");

		while (dineroIntroducido < precioTotal) {
			double cantidad = pedirNumeroDouble("Introduzca dinero:");
			dineroIntroducido += cantidad;

			if (dineroIntroducido < precioTotal) {
				faltante = precioTotal - dineroIntroducido;
				System.out.println("Falta por introducir: " + String.format("%.2f", faltante) + "€");
			}
		}
		double cambio = dineroIntroducido - precioTotal;
		if (cambio > 0) {
			System.out.println("Cambio a devolver: " + String.format("%.2f", cambio) + "€");
			Calculadora.desglosarCambio(cambio);
		}
		System.out.println("Gracias por su compra.");
		
	}

	public static void menuGeneral() {
		String[][] listaCompra = new String[0][0];
		String[][] tipoSeleccionado = null;
		String[][] productoSeleccionado = new String[1][4];

		int valorTmp = 0;
		int comando = 1;
		double precioTotal = 0;

		do {
			switch (comando) {

			case 1: // BIENVENIDA
				Menus.mostrarMenuBienvenida();
				comando = 2;
				break;

			case 2: // TIPO
				Menus.imprimirConsola("h2 - Menu tipos");

				Menus.mostrarTipos();
				valorTmp = pedirNumeroRango(1, 4, "Elige un numero") - 1;

				tipoSeleccionado = tipos[valorTmp];
				Menus.mostrarAvisoTipoElegido(valorTmp);
				comando = 3;
				break;

			case 3: // COMPRA
				Productos.mostrarProductos(tipoSeleccionado);
				valorTmp = pedirNumeroRango(1, tipoSeleccionado.length, "Elige un número:");
				productoSeleccionado = ExpandirArray.elegirProductoDelArray(productoSeleccionado, tipoSeleccionado,
						valorTmp - 1);
				listaCompra = ExpandirArray.expandirArrayString(listaCompra, productoSeleccionado);
				Productos.mostrarProductos(listaCompra);
				comando = 4;
				break;

			case 4: // INTERMEDIO
				Menus.mostrarMenuIntermedio();
				valorTmp = pedirNumeroRango(1, 3, "Elige una opcion:");

				if (valorTmp == 1) {
					comando = 3;
				} else if (valorTmp == 3) {
					comando = 5;
				} else {
					comando = 2;
				}
				break;

			case 5: // PAGO
				precioTotal = Calculadora.sumarProductos(listaCompra, 3);
				Menus.imprimirConsola(String.format("El precio total es: %.2f", precioTotal));
				Menus.imprimirConsola("Quieres continuar con el pago?");
				Menus.mostrarMenuAceptarPago();
				valorTmp = pedirNumeroRango(1, 2, "Elige una opcion:");
				
				if (valorTmp == 1) {
					//pagar
					fasePago(precioTotal);
					Menus.imprimirConsola("Esperando 2 segundos antes de ir al menu principal..");
					esperarSegundos(2);
					comando = 1;
				} else {
					Menus.imprimirConsola("ok. Se te llevara al menu principal..");
					listaCompra = new String[0][0];
					comando = 1;
				}
				break;
			}

		} while (true);
	}
	
	public static void esperarSegundos(int numero) {
		try {
			Thread.sleep(numero * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int pedirNumeroRango(int min, int max, String texto) {
		int numero = 0;
		boolean fueraDeRango = true;
		do {
			numero = pedirNumeroEntero(texto);
			fueraDeRango = (numero < min) || (numero > max);

			if (fueraDeRango) {
				Menus.imprimirConsola(String.format("error El numero debe ser entre %d y %d", min, max));
			}

		} while (fueraDeRango);

		return numero;
	}

	public static int pedirNumeroEntero(String frase) {
		boolean esEnteroValido = false;
		String input = "";
		int numeroEntero = 0;

		do {
			System.out.printf("\t:: %s ", frase);
			input = teclado.nextLine().trim();

			if (Validador.esEntero(input)) {
				numeroEntero = Integer.parseInt(input);
				esEnteroValido = true;
			} else {
				Menus.imprimirConsola("error Error, no es un numero valido. Intenta otra vez.");
			}

		} while (!esEnteroValido);

		return numeroEntero;
	}

	public static double pedirNumeroDouble(String frasePeticion) {
		boolean valido = false;
		String entrada = "";
		double numero = 0;

		do {
			System.out.printf("\t:: %s ", frasePeticion);
			entrada = teclado.nextLine();

			if (Validador.esDouble(entrada)) {
				numero = Double.parseDouble(entrada);
				valido = true;
			} else {
				System.out.printf("error\n");
			}

		} while (!valido);

		return numero;
	}

	public static double pedirSaldo(int precioTotal) {
		double saldo = 0;
		double tempo = 0;

		do {
			saldo = tempo - saldo;
			saldo = pedirNumeroDouble("Escribe el saldo disponible:");
			if (saldo < precioTotal) {
				System.out.println("Saldo insuficiente, vuelve a intentarlo");
			}

		} while (saldo < precioTotal);

		return saldo;
	}

}
