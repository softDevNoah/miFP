package utiles;

import modelo.*;
import vista.*;

public class ValidarDatoDeProducto {

	public static boolean checkCategoria(String entrada, String categorias[]) {
		
		boolean	esCorrecto = false;
		
		if (ValidarTipoDeEntrada.estaDentroDeLimites(entrada) && ValidarTipoDeEntrada.checkSoloLetras(entrada)) {
			for(int i = 0; i < 4; i++) {
				if (entrada.equals(categorias[i]))
					esCorrecto = true;	
			}
		}
		if (!esCorrecto)
			MostrarMensajeDeError.categoriaIncorrecta();
		return (esCorrecto);
	}
	
	public static boolean checkIDUnico(int id, Producto productos[]) {
		
		boolean	esCorrecto = false;
		int		totalProductos = BaseDeDatos.cantidadProductosActual(productos);		
//		
		for (int i = 0; i < totalProductos; i++) {
			if (id == productos[i].idUnico) {
				esCorrecto = false;
				MostrarMensajeDeError.datoRepetido(productos[i].idUnico);
			}
		}
		
		return (esCorrecto);
	}
	
	public static boolean checkNombre(String entrada, Producto productos[]) {
	
		boolean	esCorrecto = false;
		
		if (ValidarTipoDeEntrada.estaDentroDeLimites(entrada)) {
			
			
			esCorrecto = true;
		}
		return (esCorrecto);
	}
	
	public static boolean checkPrecio(String entrada, Producto productos[]) {
	
		boolean	esCorrecto = false;
		
		if (ValidarTipoDeEntrada.estaDentroDeLimites(entrada)) {
			
			
			esCorrecto = true;
		}
		return (esCorrecto);
	}
}
