package modelo;

import controlador.RecogerDatoDeProducto;
import vista.MostrarMensajeDePeticion;
import vista.MostrarMensajeOperacionCorrecta;

//import controlador.*;
//import vista.*;
//import utiles.*;

public class Operaciones {

	public static Producto[] nuevoProducto(Producto productos[]) {
		
		int			numProductosActual;
		boolean		volverAtras;
		Producto	nuevoProducto;
		Producto	productosActualizados[];
		
		numProductosActual = Operaciones.contarTotalProductosActual(productos);
		volverAtras = false;
		nuevoProducto = new Producto();
				
		nuevoProducto.nombre = RecogerDatoDeProducto.recogerNombre(productos);
		nuevoProducto.categoria = RecogerDatoDeProducto.recogerCategoria(nuevoProducto.categorias);
		nuevoProducto.precio = RecogerDatoDeProducto.recogerPrecio();
		//volverAtras = condicionDeseaVolver
		if (volverAtras) {
			//msgVolverCorrecto
			return (productos);
		}
		
		productosActualizados = new Producto[numProductosActual + 1];
		//copiar los primeros 16
		//asignar valores nuevos al nº 17
		MostrarMensajeOperacionCorrecta.msgProductoCreadoCorrectamente();
		return (productosActualizados);
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
