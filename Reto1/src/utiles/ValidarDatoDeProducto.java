package utiles;

import vista.*;

public class ValidarDatoDeProducto {

	public static boolean checkCategoria(String entrada, String categorias[]) {
		
		boolean	esCorrecto = false;
		
		if (ValidarTipoDeEntrada.estaDentroDeLimites(entrada)) {
			
			
			esCorrecto = true;
		}
		return (esCorrecto);
	}
	
	public static boolean checkIDUnico(String entrada) {
		
boolean	esCorrecto = false;
		
		if (ValidarTipoDeEntrada.estaDentroDeLimites(entrada)) {
			
			
			esCorrecto = true;
		}
		return (esCorrecto);
	}
	
	public static boolean checkNombre(String entrada) {
	
boolean	esCorrecto = false;
		
		if (ValidarTipoDeEntrada.estaDentroDeLimites(entrada)) {
			
			
			esCorrecto = true;
		}
		return (esCorrecto);
	}
	
	public static boolean checkPrecio(String entrada) {
	
boolean	esCorrecto = false;
		
		if (ValidarTipoDeEntrada.estaDentroDeLimites(entrada)) {
			
			
			esCorrecto = true;
		}
		return (esCorrecto);
	}
}
