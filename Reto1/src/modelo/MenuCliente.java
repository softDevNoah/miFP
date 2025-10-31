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
		
		int			decisionDeCompra = 0;
		
		if (Operaciones.contarTotalProductosActual(productos) > 0) {
				
			while (seguirComprando) {
				
				categoriaSeleccionada = LeerSeleccion.seleccionarCategoria(productoSeleccionado.categorias);
				seguirComprandoMismaCategoria = true;
				
				while (seguirComprandoMismaCategoria) {
					
					productoSeleccionado =  LeerSeleccion.seleccionarProductoDeUnaCategoria(productos, categoriaSeleccionada);
					
					if ((precioTotal + productoSeleccionado.precio) < 250.00) {
						precioTotal += productoSeleccionado.precio;
						cestaDeCompra = Operaciones.añadirProductoALaCesta(cestaDeCompra, productoSeleccionado);
						MostrarListaDeProductos.mostrarCestaCompra(cestaDeCompra);
						decisionDeCompra = MostrarMensajeDePeticion.condicionSeguirComprando(categoriaSeleccionada);
						if (decisionDeCompra == 1) {
							seguirComprandoMismaCategoria = false;
							seguirComprando = false;
						}
						else if (decisionDeCompra == 2)
							seguirComprandoMismaCategoria = false;				
					}
					else {
						MostrarMensajeDeError.noSePuedenAñadirMasProductosALaCesta();
						seguirComprandoMismaCategoria = false;
						seguirComprando = false;
					}
				}
			}
			System.out.printf("\t---> El precio total es: %.2f€\n\t¿Quiere continuar con el pago?\n\t1.- Si\n\t2.- No, cancelar compra.", precioTotal);
			if (recogerOpcionNumerica(1, 2, "Elige una opcion:") == 1) {
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

	public static int recogerOpcionNumerica(int min, int max, String texto) {
		
		String	entrada;
		boolean	esCorrecto = true;
		int		opcionSeleccionada = 0;

		do {
			entrada = Main.teclado.nextLine();

			if (ValidarTipoDeEntrada.estaDentroDeLimites(entrada) && ValidarTipoDeEntrada.checkSoloNumeroPositivoEntero(entrada)) {
				opcionSeleccionada = Integer.parseInt(entrada);
				if ((opcionSeleccionada < min) || (opcionSeleccionada > max)) {
					MostrarMensajeDeError.opcionIncorrecta();
					esCorrecto = false;
				}
			}
			else 
				esCorrecto = false;
				
		} while (!esCorrecto);

		return (opcionSeleccionada);
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
