package utiles;

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
	
	public static boolean checkIDUnico(String entrada, ) {
		
		boolean	esCorrecto = false;
		
		if (ValidarTipoDeEntrada.estaDentroDeLimites(entrada) && ValidarTipoDeEntrada.checkSoloNumeroPositivoEntero(entrada)) {
			
			
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
