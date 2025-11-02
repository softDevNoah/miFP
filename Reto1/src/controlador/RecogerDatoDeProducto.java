package controlador;

import modelo.*;
import vista.*;
import main.Main;

public class RecogerDatoDeProducto {
	
	public static String recogerCategoria(String categorias[]) {
		
		String	entrada; 
		boolean	esCorrecto = false;
		
		do {
			MsgPeticion.msgAsigneCategoria(categorias);
			entrada = Main.teclado.nextLine();
			if (checkCategoria(entrada, categorias))
				esCorrecto = true;
		} while (!esCorrecto);
		
		return (entrada);
	}
	
	public static String recogerNombre(Producto productos[]) {
		
		String	entrada; 
		
		boolean	esCorrecto = false;
		
		do {
			MsgPeticion.msgAsigneDato(1);
			entrada = Main.teclado.nextLine();
			if (checkNombre(entrada, productos))
				esCorrecto = true;			
		} while (!esCorrecto);
	
		return (entrada);
	}
	
	public static double recogerPrecio() {
		
		String	entrada; 
		
		double	precio = -1.00;
		boolean	esCorrecto = false;
		
		do {
			MsgPeticion.msgAsigneDato(2);
			entrada = Main.teclado.nextLine();
			if (ValidarTipoDeEntrada.estaDentroDeLimites(entrada) && ValidarTipoDeEntrada.checkSoloNumeroDecimal(entrada)) {
				precio = Double.parseDouble(entrada);
				esCorrecto = true;
			}
			
		} while (!esCorrecto);
		
		return (precio);
	}
	
	private static boolean checkCategoria(String entrada, String categorias[]) {
		
		boolean	esCorrecto = false;
		
		if (ValidarTipoDeEntrada.estaDentroDeLimites(entrada) && ValidarTipoDeEntrada.checkSoloLetras(entrada)) {
			for(int i = 0; i < 4; i++) {
				if (entrada.equals(categorias[i]))
					esCorrecto = true;	
			}
			if (!esCorrecto)
			MostrarMensajeDeError.mostrarError(6);
		}
		return (esCorrecto);
	}
		
	private static boolean checkNombre(String entrada, Producto productos[]) {
	
		boolean	esCorrecto = true;
		int		totalProductos = productos.length;
		
		if (ValidarTipoDeEntrada.estaDentroDeLimites(entrada) && (ValidarTipoDeEntrada.checkSoloAlfanumerico(entrada))) {
			for (int i = 0; i < totalProductos; i++) {
				if (entrada.equals(productos[i].nombre)) {
					esCorrecto = false;
					MostrarMensajeDeError.nombreYaEnUso(productos[i].nombre);
				}
			}
		}
		else
			esCorrecto = false;
		return (esCorrecto);
	}
	
	
}
