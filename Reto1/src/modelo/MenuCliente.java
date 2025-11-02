package modelo;

import controlador.*;
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
				Pagar.pasarelaDePago(precioTotal);
			}
			else			
				System.out.println("\n\t------->>>> Cancelando compra... <<<<-------\n");
		}
		else
			MostrarMensajeDeError.noHayNingunProducto();
	}

		
	
}
