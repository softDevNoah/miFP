package modelo;

import java.lang.Thread;

import controlador.*;
import main.*;
import vista.*;

public class MenuCliente {
	
	public static void ejecutarCliente(Producto productos[]) {
		
		Producto 	cestaDeCompra[] = new Producto[0];
		Producto	productoSeleccionado = new Producto();
		
		String		categoriaSeleccionada;
		double 		precioTotal = 0;
		boolean		seguirComprandoMismaCategoria = true;
		boolean		seguirComprando = true;
		
		int			decisionPago = 0;
		
		if (Operaciones.contarTotalProductosActual(productos) > 0) {
				
			while (seguirComprando) {
				
				categoriaSeleccionada = RecogerDatoDeProducto.seleccionarCategoria(productoSeleccionado.categorias);
				seguirComprandoMismaCategoria = true;
				
				while (seguirComprandoMismaCategoria) {
					
					productoSeleccionado =  LeerSeleccionDeProducto.seleccionarProductoDeUnaCategoria(productos, categoriaSeleccionada);
					
					if ((precioTotal + productoSeleccionado.precio) < 250.00) {
						precioTotal += productoSeleccionado.precio;
						cestaDeCompra = Operaciones.añadirProductoALaCesta(cestaDeCompra, productoSeleccionado);
						MostrarListaDeProductos.mostrarCestaCompra(cestaDeCompra);
						//condicionQuiereSeguirComprando
							//misma categoria: no se hace nada
							//otra categoria: se pone seguirComprandoMismaCategoria = false
							//no:  se pone seguirComprandoMismaCategoria = false y tambien  se pone seguirComprando = false						
					}
					else {
						MostrarMensajeDeError.noSePuedenAñadirMasProductosALaCesta();
						// se pone seguirComprandoMismaCategoria = false y tambien  se pone seguirComprando = false
					}
				}
			}
			Menus.imprimirConsola(String.format("El precio total es: %.2f", precioTotal));
			Menus.imprimirConsola("Quieres continuar con el pago?");
			Menus.mostrarMenuAceptarPago();
			decisionPago = pedirNumeroRango(1, 2, "Elige una opcion:");
			if (decisionPago == 1) {
				fasePago(precioTotal);
				Menus.imprimirConsola("Esperando 10 segundos antes de ir al menu principal..");
				esperarSegundos(10);
			}
			else			
				Menus.imprimirConsola("ok. Se te llevara al menu principal..");
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
			entrada = Main.teclado.nextLine();

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
