package modelo;

import java.lang.Thread;

import controlador.*;
import main.*;
import vista.*;

public class MenuCliente {
	
	public static void ejecutarCliente(Producto productos[]) {
		
		Producto	productoSeleccionado = new Producto();
		String 		categorias[] = productoSeleccionado.categorias;
		String		categoriaSeleccionada;
		int			indiceProductoseleccionado = 0;
		double 		precioTotal = 0;
		Producto 	cestaDeCompra[];
			
		if (Operaciones.contarTotalProductosActual(productos) > 0) {
			
			System.out.println("-------------->>>>>>Categorías de productos<<<<<<--------------");
			System.out.printf("\t---> 1.- %s\n\t---> 2.- %s\n\t---> 3.- %s\n\t---> 4.- %s", categorias[0], categorias[1], categorias[2], categorias[3]);
			
			//refactorizable sin texto
			categoriaSeleccionada =  categorias[pedirNumeroRango(1, 4, "Inserte el nº de la categoría: ") - 1];
			
			System.out.printf("\n\t- Categoría seleccionada: \"%s\"\n\n", categoriaSeleccionada);
			MostrarListaDeProductos.mostrarPorCategoria(productos, categoriaSeleccionada);
			
			indiceProductoseleccionado = LeerSeleccionDeProducto.seleccionarProductoDeUnaCategoria(productos, categoriaSeleccionada);
			productoSeleccionado = productos[indiceProductoseleccionado];
			
			if ((precioTotal + productoSeleccionado.precio) < 250.00) {
				precioTotal += productoSeleccionado.precio;
				cestaDeCompra = Operaciones.añadirProductoALaCesta(productos, productoSeleccionado);
			}
			else
				MostrarMensajeDeError.noSePuedenAñadirMasProductosALaCesta();
						
//			Productos.mostrarProductos(cestaDeCompra);

			//quiere comprar otro producto o desea pagar ya?
			
				//opcion1:
				//de categoria %s  u otra?
				//misma categoria: volver al punto de mostrar productos de categoria
				//otra categoria: volver al punto de mostrar las categorias para elegir una
			
				//pagar: pasarela de pago
			
//			Menus.mostrarMenuIntermedio();
//			valorTmp = pedirNumeroRango(1, 3, "Elige una opcion:");
//	
//			//pantalla de pago
//			precioTotal = Calculadora.sumarProductos(listaCompra, 3);
//			Menus.imprimirConsola(String.format("El precio total es: %.2f", precioTotal));
//			Menus.imprimirConsola("Quieres continuar con el pago?");
//			Menus.mostrarMenuAceptarPago();
//			
//				fasePago(precioTotal);
//				
//				//final de compra
//				Menus.imprimirConsola("Esperando 2 segundos antes de ir al menu principal..");
//				esperarSegundos(2);
//			}
//			//cancela la compra
//			else {
//				Menus.imprimirConsola("ok. Se te llevara al menu principal..");
//				listaCompra = new String[0][0];
//			}
		}
		else
			MostrarMensajeDeError.noHayNingunProducto();
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

	public static void esperarSegundos(int numero) {
		try {
			Thread.sleep(numero * 1000);
		} catch (InterruptedException e) {
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
			input = Main.teclado.nextLine().trim();

//			if (Validador.esEntero(input)) {
//				numeroEntero = Integer.parseInt(input);
//				esEnteroValido = true;
//			} else {
//				Menus.imprimirConsola("error Error, no es un numero valido. Intenta otra vez.");
//			}

		} while (!esEnteroValido);

		return numeroEntero;
	}

	public static double pedirNumeroDouble(String frasePeticion) {
		boolean valido = false;
		String entrada = "";
		double numero = 0;

//		do {
//			System.out.printf("\t:: %s ", frasePeticion);
//			entrada = teclado.nextLine();
//
//			if (Validador.esDouble(entrada)) {
//				numero = Double.parseDouble(entrada);
//				valido = true;
//			} else {
//				System.out.printf("error\n");
//			}
//
//		} while (!valido);

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
