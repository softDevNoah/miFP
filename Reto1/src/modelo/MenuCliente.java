package modelo;

import java.lang.Thread;

import controlador.*;
import main.*;
import vista.*;

public class MenuCliente {
	
	public static void ejecutarCliente(Producto productos[]) {
		
		Producto 	cestaDeCompra[] = new Producto[0];
		Producto	producto = new Producto();
		
		String		categSelect;
		double 		precioTotal = 0;
		boolean		seguirEnMismaCategoria = true;
		boolean		seguirComprando = true;
		
		int			decisionDeCompra = 0;
		String		opcionesDeCompra[] = {"Terminar la compra y pagar ya", "Comprar otro producto de otra categoría", "Comprar otro producto dentro de esta categoría"};
		if (Operaciones.contarTotalProductosActual(productos) > 0) {
				
			while (seguirComprando) {
				
				//categoriaSeleccionada = LeerSeleccion.seleccionarCategoria(productoSeleccionado.categorias);
				categSelect = producto.categorias[MsgPeticion.menuOpciones("Categorías de productos", producto.categorias, "Elija una categoría")];
				seguirEnMismaCategoria = true;
				
				while (seguirEnMismaCategoria) {
					
					producto =  LeerSeleccion.seleccionarProductoDeUnaCategoria(productos, categSelect);
					
					if ((precioTotal + producto.precio) < 250.00) {
						precioTotal += producto.precio;
						cestaDeCompra = Operaciones.añadirProductoALaCesta(cestaDeCompra, producto);
						decisionDeCompra = MsgPeticion.menuOpciones("Operaciones disponibles", opcionesDeCompra, "Elija una operación");
						if (decisionDeCompra == 0) {
							seguirEnMismaCategoria = false;
							seguirComprando = false;
						}
						else if (decisionDeCompra == 1)
							seguirEnMismaCategoria = false;				
					}
					else {
						MostrarMensajeDeError.noSePuedenAñadirMasProductosALaCesta();
						seguirEnMismaCategoria = false;
						seguirComprando = false;
					}
				}
			}
			System.out.printf("\t---> El precio total es: %.2f€\n\t¿Quiere continuar con el pago?\n\t1.- Si\n\t2.- No, cancelar compra.", precioTotal);
			
			if (MsgPeticion.menuOpciones("¿Desea realizar el pago?", null, "Introduzca una opción") == 1) {
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

	public static int recogerOpcionNumerica(int min, int max) {
		
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
