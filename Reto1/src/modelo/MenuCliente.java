package modelo;

import controlador.*;
import vista.*;

/**
 * Esta clase gestiona el flujo principal de la parte del programa que gestiona la venta de productos en una máquina expendedora.
 * Muestra un menú de operaciones y ejecuta según se seleccione.
 * Acumula productos seleccionados en una cesta de la compra a la cual se puede acceder para realizar una consulta de la misma.
 * Cuando el usuario lo indica puede terminar la compra, pagando o cancelando la compra.
 */
public class MenuCliente {
	
	/**Muestra opciones de compra de diferentes productos según su categoría, para despues realizar la operación seleccionada.
	 * Crea y gestiona una cesta de la compra que contendrá un array de los productos seleccionados.
	 * Solo ejecuta el proceso de compra, no devuelve nada.
	 * 
	 * @param productos - Array completo de productos disponibles en la máquina expendedora
	 */
	public static void ejecutarCliente(Producto productos[]) {
		
		Producto 	cestaDeCompra[] = new Producto[0];
		Producto	producto = new Producto();
		
		String		categSelect;
		double 		precioTotal = 0;
		boolean		seguirEnMismaCategoria = true;
		boolean		seguirComprando = true;
		
		int			decisionDeCompra = 0;
		String		opcionesDeCompra[] = {"Acceder a resumen de compra", "Comprar otro producto de otra categoría", "Comprar otro producto dentro de esta categoría"};
		
		if (productos.length > 0) {
				
			while (seguirComprando) {
				
				categSelect = producto.categorias[MostrarMensajeDePeticion.menuOpciones("Categorías de productos", producto.categorias, "Elija una categoría")];
				seguirEnMismaCategoria = true;
				
				while (seguirEnMismaCategoria) {
					
					producto =  LeerSeleccion.seleccionarProductoDeUnaCategoria(productos, categSelect);
					
					if ((precioTotal + producto.precio) < 250.00) {
						precioTotal += producto.precio;
						cestaDeCompra = Operaciones.añadirProductoALaCesta(cestaDeCompra, producto);
						decisionDeCompra = MostrarMensajeDePeticion.menuOpciones("Operaciones disponibles", opcionesDeCompra, "Elija una operación");
						if (decisionDeCompra == 0) {
							MostrarListaDeProductos.mostrarCestaCompra(cestaDeCompra, precioTotal);
							if (MostrarMensajeDePeticion.menuOpciones("¿He terminado de añadir productos?", null, "Seleccione una respuesta:") == 0) {
								seguirEnMismaCategoria = false;
								seguirComprando = false;
							}
							else
								seguirEnMismaCategoria = false;
								
						}
						else if (decisionDeCompra == 1)
							seguirEnMismaCategoria = false;				
					}
					else {
						MostrarMensajeDeError.mostrarError(11);
						seguirEnMismaCategoria = false;
						seguirComprando = false;
					}
				}
			}

			if (MostrarMensajeDePeticion.menuOpciones("¿Está de acuerdo con el importe total y desea pagar?", null, "Introduzca una opción") == 0) {
				Operaciones.pasarelaDePago(precioTotal);
			}
			else			
				System.out.println("\n\t------->>>> Cancelando compra... <<<<-------\n");
		}
		else
			MostrarMensajeDeError.mostrarError(9);
	}

		
	
}
