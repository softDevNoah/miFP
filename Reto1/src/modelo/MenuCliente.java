package modelo;

import controlador.*;
import main.Main;
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
			
			precioTotal *= 1.21;
			
			System.out.printf("\t---> El precio total con IVA incluido es: %.2f€\n", precioTotal);
			
			if (MsgPeticion.menuOpciones("¿Desea terminar la compra y realizar el pago ahora?", null, "Introduzca una opción") == 0) {
				faseDePago(precioTotal);
			}
			else			
				System.out.println("\n\t\t------->>>>\tCancelando compra...\t<<<<-------\n");
		}
		else
			MostrarMensajeDeError.noHayNingunProducto();
	}

		
	public static void faseDePago(double precioTotal) {
		
		double	dineroIntroducido = 0.0;
		double	faltante = precioTotal;
		String	entrada;
		boolean esCorrecto = false;
		double	cambio = 0.0;
		double	saldoAcumulado = 0.0;
		
		while (dineroIntroducido < precioTotal) {
			do {	
				System.out.printf("\t------>>>>>> Importe pendiente: %.2f€.\n\n", faltante);
				System.out.print("\t------>>>>>> Introduzca dinero, por favor: ");
				
				entrada = Main.teclado.nextLine();

				if (ValidarTipoDeEntrada.estaDentroDeLimites(entrada) && ValidarTipoDeEntrada.checkSoloNumeroDecimal(entrada)) {
					dineroIntroducido = Double.parseDouble(entrada);
					if (dineroIntroducido <= 250) {
						saldoAcumulado += dineroIntroducido;
						esCorrecto = true;
						}
					else
						MostrarMensajeDeError.maximoDineroIngresadoAlcanzado();
					}
				System.out.println();
			} while (!esCorrecto);
			
			if (saldoAcumulado < precioTotal) {
				faltante = precioTotal - saldoAcumulado;
			}
			
		}
		
		cambio = saldoAcumulado - precioTotal;
		
		if (cambio > 0) {
			System.out.printf("\tSu cambio es: %.2f€\n\n", cambio);
			Calculadora.desglosarCambio(cambio);
		}

		System.out.println("\n\n\t------>>>>>> Gracias por su compra <<<<<<------");
	}		

}
