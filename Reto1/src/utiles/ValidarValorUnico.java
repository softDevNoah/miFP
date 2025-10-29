package utiles;

import modelo.*;

public class ValidarValorUnico{

	public static boolean checkIdUnico(Producto productos[], int idUnico) {
		
		int		numActualProductos = Operaciones.contarTotalProductosActual(productos);
		boolean	indiceActualProducto = false;
		
		for (int i = 0; i < numActualProductos; i++) {
			if (idUnico == productos[i].idUnico)
				indiceActualProducto = true;
		}
		
		return (indiceActualProducto);
	}
	
	public static boolean checkNombreUnico(Producto productos[], String nombre) {
		
		int		numActualProductos = Operaciones.contarTotalProductosActual(productos);
		boolean	coincidencia = false;
		
		for (int i = 0; i < numActualProductos; i++) {
			if (nombre.equals(productos[i].nombre))
				coincidencia = true;
		}
		
		return (coincidencia);
	}
	
}
