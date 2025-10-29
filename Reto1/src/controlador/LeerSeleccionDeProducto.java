package controlador;

import main.Main;
import modelo.*;
import utiles.*;
import vista.*;

public class LeerSeleccionDeProducto {
	
	public static int seleccionarProducto(Producto productos[], String opcion) {
		String	entrada;
		int		seleccionProducto = -1;
		boolean	esCorrecto = false;
		int		indiceProducto = -1;
		do {
			System.out.printf("\t------>>>>>>\t¿Qué producto desea %s?\t<<<<<<------\n", opcion);
			System.out.print("\tEscriba únicamente el ID del producto:\t");
			entrada = Main.teclado.nextLine();
			if (ValidarTipoDeEntrada.estaDentroDeLimites(entrada) && ValidarTipoDeEntrada.checkSoloNumeroPositivoEntero(entrada))
				seleccionProducto = Integer.parseInt(entrada);
				if (!ValidarDatoDeProducto.checkIDUnico(seleccionProducto, productos)) {
					indiceProducto = busquedaPorIdUnico(productos, seleccionProducto);
					esCorrecto = true;
				}
				else
					MostrarMensajeDeError.noHayNingunProductoConEsteCriterioDeBusqueda();
		} while (!esCorrecto);
		
		return (indiceProducto);
	}
	
	public static int eleccionTipoDato(Producto producto) {
		
		String	entrada;
		int		tipoDato = -1;
		boolean	esCorrecto = false;

		do {
			System.out.println("\t------>>>>>>\t¿Qué dato desea modificar?\t<<<<<<------");
			System.out.printf("\t\t1.- Nombre (original: \"%s\".\n", producto.nombre);
			System.out.printf("\t\t2.- Categoría (original: \"%s\".\n", producto.categoria);
			System.out.printf("\t\t3.- Precio (original: \"%.2f\".\n", producto.precio);
			System.out.print("\tEscriba solo 1, 2 o 3 para elegir, por favor:\t");
	
			entrada = Main.teclado.nextLine();
			if ((ValidarTipoDeEntrada.estaDentroDeLimites(entrada)) && (entrada.equals("1") || entrada.equals("2") || entrada.equals("3"))) {
				esCorrecto = true;
				tipoDato = Integer.parseInt(entrada);
			}
		} while (!esCorrecto);
		
		return (tipoDato);
	}
	
	public static int busquedaPorIdUnico(Producto productos[], int numeroID) {
		
		int	indiceProducto = -1;
		int	cantidadActual = Operaciones.contarTotalProductosActual(productos);
		
		for (int i = 0; i < cantidadActual; i++) {
			if (productos[i].idUnico == numeroID)
				indiceProducto = i;
		}
		
		return (indiceProducto);
	}
}
