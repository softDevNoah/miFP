package utiles;

import vista.*;

public class ValidarDatoDeProducto {

	public static boolean checkCategoria(String entrada) {
		
		boolean	esValida = true;
		
		if (!entrada.isEmpty()) {
			MostrarMensajeError.entradaVacia();
			return (false);
		}
		
		return (esValida);
	}
	
	public static boolean checkIDUnico(String entrada) {
		
		boolean	esValida = false;
		
		if (!entrada.isEmpty()) {
			MostrarMensajeError.entradaVacia();
			return (false);
		}
		
		return (esValida);
	}
	
	public static boolean checkNombre(String entrada) {
	
		boolean	esValida = false;
	
		if (!entrada.isEmpty()) {
			MostrarMensajeError.entradaVacia();
			return (false);
		}
		
		return (esValida);
	}
	
	public static boolean checkPrecio(String entrada) {
	
		boolean	esValida = false;
		double precio = -1.00;
	
		if (!entrada.isEmpty()) {
			MostrarMensajeError.entradaVacia();
			return (false);
		}
		
		return (esValida);
	}
}
