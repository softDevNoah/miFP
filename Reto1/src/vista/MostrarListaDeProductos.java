package vista;

import modelo.*;

public class MostrarListaDeProductos {

	public static void mostrarListaCompleta(Producto productos[]) {
		
		int	numActualProductos = Operaciones.contarTotalProductosActual(productos);
		
		if (numActualProductos > 0) {
			System.out.printf("-------------->>>>>>Lista de productos actual, %d productos<<<<<<--------------\n", numActualProductos);
			for (int i = 0; i < numActualProductos; i++)
				System.out.printf("\t#%d: %s (id -> %d, categoría -> %s, precio -> %.2f€)\n", i, productos[i].nombre, productos[i].idUnico, productos[i].categoria, productos[i].precio);
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
	
	public static void mostrarPorPrecioMinimo(Producto productos[], double precio) {
		
		int	numActualProductos = Operaciones.contarTotalProductosActual(productos);
		int	numProductosConPrecioEnRango= 0;
		
		if (numActualProductos > 0) {
			for (int i = 0; i < numActualProductos; i++) {
				if (productos[i].precio >= precio)
					numProductosConPrecioEnRango++;
			}
			if (numProductosConPrecioEnRango > 0) {
				int j = 0;
				System.out.printf("-------------->>>>>>Lista de productos con un precio mayor o igual a de %.2f: %d productos<<<<<<--------------\n", precio, numProductosConPrecioEnRango);
				for (int i = 0; i < numActualProductos; i++) {
					if (productos[i].precio >= precio) {
						j++;
						System.out.printf("\t#%d: %s (id -> %d, categoría -> %s, precio -> %.2f€)\n", j, productos[i].nombre, productos[i].idUnico, productos[i].categoria, productos[i].precio);
					}
				}
			}
			else
				MostrarMensajeDeError.noHayNingunProductoConEsteCriterioDeBusqueda();
		}
		else
			MostrarMensajeDeError.noHayNingunProducto();
	}
	
	public static void mostrarPorPrecioMaximo(Producto productos[], double precio) {
		
		int	numActualProductos = Operaciones.contarTotalProductosActual(productos);
		int	numProductosConPrecioEnRango= 0;
		
		if (numActualProductos > 0) {
			for (int i = 0; i < numActualProductos; i++) {
				if (productos[i].precio <= precio)
					numProductosConPrecioEnRango++;
			}
			if (numProductosConPrecioEnRango > 0) {
				int j = 0;
				System.out.printf("-------------->>>>>>Lista de productos con un precio menor o igual a %.2f: %d productos<<<<<<--------------\n", precio, numProductosConPrecioEnRango);
				for (int i = 0; i < numActualProductos; i++) {
					if (productos[i].precio <= precio) {
						j++;
						System.out.printf("\t#%d: %s (id -> %d, categoría -> %s, precio -> %.2f€)\n", j, productos[i].nombre, productos[i].idUnico, productos[i].categoria, productos[i].precio);
					}
				}
			}
			else
				MostrarMensajeDeError.noHayNingunProductoConEsteCriterioDeBusqueda();
		}
		else
			MostrarMensajeDeError.noHayNingunProducto();
	}
	
	public static void mostrarPorNombre(Producto productos[], String nombre) {
		
		int	numActualProductos = Operaciones.contarTotalProductosActual(productos);
		int	numProductosConNombre = 0;
		
		if (numActualProductos > 0) {
			for (int i = 0; i < numActualProductos; i++) {
				if (productos[i].categoria.equals(nombre))
					numProductosConNombre++;
			}
			
			if (numProductosConNombre > 0) {
				int j = 0;
				System.out.printf("-------------->>>>>>Lista de productos en la categoría %s: %d productos<<<<<<--------------\n", nombre, numProductosConNombre);
				for (int i = 0; i < numActualProductos; i++) {
					if (productos[i].categoria.equals(nombre)) {
						j++;
						System.out.printf("\t#%d: %s (id -> %d, categoría -> %s, precio -> %.2f€)\n", j, productos[i].nombre, productos[i].idUnico, productos[i].categoria, productos[i].precio);
					}
				}
			}
			else
				MostrarMensajeDeError.noHayNingunProductoConEsteCriterioDeBusqueda();
		}
		else
			MostrarMensajeDeError.noHayNingunProducto();
	}
	
	public static void mostrarPorIdUnico(Producto productos[], int idUnico) {
		
		int	numActualProductos = Operaciones.contarTotalProductosActual(productos);
		int indiceProducto = Busqueda.buscarProductoPorIdUnico(productos, idUnico);
		
		if (numActualProductos > 0) {
			if (indiceProducto != -1) {
				System.out.printf("-------------->>>>>>Producto con id %d<<<<<<--------------\n", idUnico);
				System.out.printf("\t- %s, categoría -> %s, precio -> %.2f\n\n", productos[indiceProducto].nombre, productos[indiceProducto].categoria, productos[indiceProducto].precio);
			}
			else
				MostrarMensajeDeError.noHayNingunProductoConEsteCriterioDeBusqueda();
		}
		else
			MostrarMensajeDeError.noHayNingunProducto();
	}
}
