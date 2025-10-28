package modelo;

//import controlador.*;
//import vista.*;
//import utiles.*;

public class Operaciones {

	public static boolean nuevoProducto(Producto productos[]) {
		
		boolean creadoCorrectamente = true;
		
		return (creadoCorrectamente);
	}
	
	public static boolean modificarProducto(Producto productos[]) {
		
		boolean modificadoCorrectamente = true;
		
		return (modificadoCorrectamente);
	}

	public static boolean eliminarProducto(Producto productos[]) {
	
		boolean eliminadoCorrectamente = true;
		
		return (eliminadoCorrectamente);
	}

	public static int contarTotalProductosActual(Producto productos[]) {
		
		int		total = 0;
		boolean	finalDelConteo = false;
		int		i = 0;
		
		while (!finalDelConteo) {
			if (productos[i] != null) {
				while (productos[i + 1] != null) {
					total++;
					i++;
				}
				total++;
			}
			finalDelConteo = true;
		}
		return (total);
	}
	
}
