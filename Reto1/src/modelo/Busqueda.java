package modelo;

public class Busqueda{

	public static int buscarProductoPorIdUnico(Producto productos[], int idUnico) {
		
		int		numActualProductos = Operaciones.contarTotalProductosActual(productos);
		int		indiceActualProducto = -1;
		
		for (int i = 0; i < numActualProductos; i++) {
			if (idUnico == productos[i].idUnico)
				indiceActualProducto = i;
		}
		
		return (indiceActualProducto);
	}
	
	
	public static boolean buscarCoincidenciaPorNombre(Producto productos[], String nombre) {
		
		int		numActualProductos = Operaciones.contarTotalProductosActual(productos);
		boolean	coincidencia = false;
		
		for (int i = 0; i < numActualProductos; i++) {
			if (nombre.equals(productos[i].nombre))
				coincidencia = true;
		}
		
		return (coincidencia);
	}
	
	public static boolean buscarIncompatibilidadPorCoincidencia(Producto productos[], int indice) {
		
		Producto	productoUnico = productos[indice];
		boolean		operacionPermitida = true;
		
		if (indice == buscarProductoPorIdUnico(productos, productoUnico.idUnico))
			operacionPermitida = false;
		
		return(operacionPermitida);
	}
	
	
}
