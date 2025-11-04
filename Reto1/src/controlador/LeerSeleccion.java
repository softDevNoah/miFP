package controlador;

import main.Main;
import modelo.*;
import vista.*;

/**
 * 
 */
public class LeerSeleccion {
	
	public static int seleccionarProducto(Producto productos[], String opcion) {
		String	entrada;
		int		seleccionProducto = -1;
		boolean	esCorrecto = false;
		int		indiceProducto = -1;
		do {
			System.out.printf("\t------>>>>>> ¿Qué producto desea %s? <<<<<<------\n\n", opcion);
			System.out.print("\t·····> Escriba únicamente el ID del producto:\t");
			
			entrada = Main.teclado.nextLine().trim();
			
			if (ValidarTipoDeEntrada.estaDentroDeLimites(entrada) && ValidarTipoDeEntrada.checkSoloNumeroPositivoEntero(entrada)) {
				
				seleccionProducto = Integer.parseInt(entrada);
				
				if (!checkIDUnico(productos, seleccionProducto)) {
					indiceProducto = busquedaPorIdUnico(productos, seleccionProducto);
					esCorrecto = true;
					System.out.println();
				}
				else
					MostrarMensajeDeError.mostrarError(10);
			}
		} while (!esCorrecto);
		
		return (indiceProducto);
	}
	
	public static Producto seleccionarProductoDeUnaCategoria(Producto productos[], String categoriaSeleccionada) {
	
		String	entrada;
		int		indiceProducto = 0;
		boolean	esCorrecto = false;
		
		int		numActualProductos = productos.length;
		int		numProductosConCategoria;
		
		int		idProductoSeleccionado = 0;
		
		do {
			MostrarListaDeProductos.mostrarPorCategoria(productos, categoriaSeleccionada);
			
			System.out.printf("\t------>>>>>> ¿Qué producto desea añadir a la cesta? <<<<<<------\n");
			System.out.print("\n\tEscriba el nº del producto: ");
			
			entrada = Main.teclado.nextLine().trim();
			
			if (ValidarTipoDeEntrada.estaDentroDeLimites(entrada) && ValidarTipoDeEntrada.checkSoloNumeroPositivoEntero(entrada)) {
				
				indiceProducto = Integer.parseInt(entrada);
				
				numProductosConCategoria = 0;
				
				for (int i = 0; i < numActualProductos; i++) {
					
					if (productos[i].categoria.equals(categoriaSeleccionada)) {
						numProductosConCategoria++;
						
						if (numProductosConCategoria == indiceProducto)
							idProductoSeleccionado = productos[i].idUnico;								
					}
				}
			
				indiceProducto = Operaciones.buscarPorID(productos, idProductoSeleccionado);
				
				if (idProductoSeleccionado > 0) {
					esCorrecto = true;
				}
			}
		} while (!esCorrecto);
		
		return (productos[indiceProducto]);
	}
	
	public static int seleccionTipoDato(Producto producto) {
		
		String	entrada;
		int		tipoDato = -1;
		boolean	esCorrecto = false;

		do {
			System.out.println("\t------>>>>>> ¿Qué dato desea modificar? <<<<<<------\n");
			System.out.printf("\t\t1.- Nombre\t(original: \"%s\")\n", producto.nombre);
			System.out.printf("\t\t2.- Categoría\t(original: \"%s\")\n", producto.categoria);
			System.out.printf("\t\t3.- Precio\t(original: \"%.2f\")\n\n", producto.precio);
			System.out.print("\t·····> Seleccione un dato, por favor: ");
	
			entrada = Main.teclado.nextLine().trim();
			
			if ((ValidarTipoDeEntrada.estaDentroDeLimites(entrada)) && (entrada.equals("1") || entrada.equals("2") || entrada.equals("3"))) {
				esCorrecto = true;
				tipoDato = Integer.parseInt(entrada);
			}
		} while (!esCorrecto);
		
		return (tipoDato);
	}
	
	public static int busquedaPorIdUnico(Producto productos[], int numeroID) {
		
		int	indiceProducto = -1;
		int	cantidadActual = productos.length;
		
		for (int i = 0; i < cantidadActual; i++) {
			if (productos[i].idUnico == numeroID)
				indiceProducto = i;
		}
		
		return (indiceProducto);
	}

	public static boolean checkIDUnico(Producto productos[], int id) {
		
		boolean	esCorrecto = true;
		int		totalProductos = productos.length;		
		
		for (int i = 0; i < totalProductos; i++) {
			if (id == productos[i].idUnico) {
				esCorrecto = false;
			}
		}
		
		return (esCorrecto);
	}
}
