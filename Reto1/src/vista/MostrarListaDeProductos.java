package vista;

import modelo.*;

public class MostrarListaDeProductos {

	public static void mostrarListaCompleta(Producto productos[]) {
		
		int	numActualProductos = Operaciones.contarTotalProductosActual(productos);
		
		if (numActualProductos > 0) {
			System.out.printf("-------------->>>>>>Lista de productos actual, %d productos<<<<<<--------------\n", numActualProductos);
			System.out.println("\n\tNombre\t\tID\t\tCategoría\tPrecio");
			System.out.println("\t______\t\t__\t\t_________\t______\n");
			for (int i = 0; i < numActualProductos; i++)
				System.out.printf("\t%s\t\t%d\t\t%s\t\t%.2f€)\n\n", productos[i].nombre, productos[i].idUnico, productos[i].categoria, productos[i].precio);
		}
		else
			MostrarMensajeDeError.noHayNingunProducto();
	}
	
	//puede que haga falta en la parte de cliente
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
						System.out.printf("\t#%d: %s (precio sin I.V.A. -> %.2f€)\n", j, productos[i].nombre, productos[i].precio);
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
