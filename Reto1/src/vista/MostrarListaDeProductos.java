package vista;

import modelo.*;

public class MostrarListaDeProductos {

	public static void mostrarListaCompleta(Producto productos[]) {
		
		int	numActualProductos = Operaciones.contarTotalProductosActual(productos);
		
		if (numActualProductos > 0) {
			System.out.printf("-------------->>>>>>Lista de productos actual, %d productos<<<<<<--------------\n", numActualProductos);
			System.out.println("\n\tNombre\t\tID\t\tCategoría\tPrecio");
			for (int i = 0; i < numActualProductos; i++)
				System.out.printf("\t\t%s\t\t%.2f€)\n\n", i, productos[i].nombre, productos[i].idUnico, productos[i].categoria, productos[i].precio);
		}
		else
			MostrarMensajeDeError.noHayNingunProducto();
	}
	
	public static void mostrarPorCategoria(Producto productos[], String categoria) {
		
		int	numActualProductos = Operaciones.contarTotalProductosActual(productos);
		int	numProductosConCategoria= 0;
		
		if (numActualProductos > 0) {
			for (int i = 0; i < numActualProductos; i++) {
				if (productos[i].categoria.equals(categoria))
					numProductosConCategoria++;
			}
			
			if (numProductosConCategoria > 0) {
				int j = 0;
				System.out.printf("-------------->>>>>>Lista de productos en la categoría %s: %d productos<<<<<<--------------\n", categoria, numProductosConCategoria);
				for (int i = 0; i < numActualProductos; i++) {
					if (productos[i].categoria.equals(categoria)) {
						j++;
						System.out.printf("\t#%d: %s (id -> %d, precio -> %.2f€)\n", j, productos[i].nombre, productos[i].idUnico, productos[i].precio);
					}
				}
			}
			else
				MostrarMensajeDeError.noHayNingunProductoConEsteCriterioDeBusqueda();
		}
		else
			MostrarMensajeDeError.noHayNingunProducto();
	}
	
}
