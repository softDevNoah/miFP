package vista;

import modelo.*;

public class MostrarListaDeProductos {

	public static void mostrarListaCompleta(Producto productos[]) {
		
		int	numActualProductos = productos.length;
		
		if (numActualProductos > 0) {
			System.out.printf("-------------->>>>>>Lista de productos actual, %d productos<<<<<<--------------\n", numActualProductos);
			System.out.println("\n\tNombre\t\tID\t\tCategoría\tPrecio");
			System.out.println("\t______\t\t__\t\t_________\t______\n");
			for (int i = 0; i < numActualProductos; i++)
				System.out.printf("\t%s\t\t%d\t\t%s\t\t%.2f€)\n\n", productos[i].nombre, productos[i].idUnico, productos[i].categoria, productos[i].precio);
		}
		else
			MostrarMensajeDeError.mostrarError(9);
	}
	
	public static void mostrarPorCategoria(Producto productos[], String categoria) {
		
		int	numActualProductos = productos.length;
		int	numProductosConCategoria= 0;
		
		if (numActualProductos > 0) {
			for (int i = 0; i < numActualProductos; i++) {
				if (productos[i].categoria.equals(categoria))
					numProductosConCategoria++;
			}
			
			if (numProductosConCategoria > 0) {
				int j = 0;
				System.out.printf("------>>>>>> Lista de productos en la categoría %s: %d productos<<<<<<------\n", categoria, numProductosConCategoria);
				
				System.out.println("\n\tNúmero\tNombre\tPrecio sin IVA");
				System.out.println("\t______\t______\t______________\n");
				
				for (int i = 0; i < numActualProductos; i++) {
					if (productos[i].categoria.equals(categoria)) {
						j++;
						System.out.printf("\t   #%d:\t%s\t%.2f€)\n", j, productos[i].nombre, productos[i].precio);
					}
				}
				System.out.println();
			}
			else
				MostrarMensajeDeError.mostrarError(10);
		}
		else
			MostrarMensajeDeError.mostrarError(9);
	}
	
	public static void mostrarCestaCompra(Producto productosCesta[], double precioTotal) {
		
		int	cantidadProductos = productosCesta.length;
		
		if (cantidadProductos > 0) {
			System.out.printf("\n------>>>>>> Resumen de compra, cesta con %d productos <<<<<<------\n", cantidadProductos);
			System.out.println("\n\tNombre\t\tCategoría\tPrecio");
			System.out.println("\t______\t\t_________\t______\n");
			for (int i = 0; i < cantidadProductos; i++)
				System.out.printf("\t%s\t\t%s\t\t%.2f€)\n\n", productosCesta[i].nombre, productosCesta[i].categoria, productosCesta[i].precio);
		}
		System.out.printf("\t---> El importe total sería %.2f€ + %.2f€ de IVA = %.2f€.\n", precioTotal, precioTotal * 0.10, precioTotal * 1.10);
	}

}
