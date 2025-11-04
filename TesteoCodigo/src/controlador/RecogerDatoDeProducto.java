package controlador;

import modelo.*;
import vista.*;
import main.Main;

public class RecogerDatoDeProducto {
	
	public static String recogerCategoria(String categorias[]) {
		
		String	entrada; 
		boolean	esCorrecto = false;
		
		do {
			MostrarMensajeDePeticion.msgAsigneCategoria(categorias);
			entrada = Main.teclado.nextLine().trim();

			if (checkCategoria(entrada, categorias))
				esCorrecto = true;
		} while (!esCorrecto);
		
		return (entrada);
	}
	
	public static String recogerNombre(Producto productos[]) {
		
		String	entrada; 
		
		boolean	esCorrecto = false;
		
		do {
			MostrarMensajeDePeticion.msgAsigneDato(1);
			entrada = Main.teclado.nextLine().trim();
			
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
			MostrarMensajeDePeticion.msgAsigneDato(2);
			entrada = Main.teclado.nextLine().trim();
			
			if (ValidarTipoDeEntrada.estaDentroDeLimites(entrada) && ValidarTipoDeEntrada.checkSoloNumeroDecimal(entrada)) {
				precio = Double.parseDouble(entrada);
				if (precio < 0.35 || precio > 5)
					MostrarMensajeDeError.mostrarError(16);
				else
					esCorrecto = true;
			}
			
		} while (!esCorrecto);
		
		return (precio);
	}
	
	
	public static int recogerIDUnico(Producto productos[]) {
		
		String	entrada; 
		
		int		idUnico = 0;
		boolean	esCorrecto;
		
		do {
			esCorrecto = true;
			
			MostrarMensajeDePeticion.msgAsigneDato(3);
			entrada = Main.teclado.nextLine().trim();
			
			if (ValidarTipoDeEntrada.estaDentroDeLimites(entrada) && ValidarTipoDeEntrada.checkSoloNumeroPositivoEntero(entrada)) {
				idUnico = Integer.parseInt(entrada);
				
				if (idUnico == 0) {
					MostrarMensajeDeError.mostrarError(15);
					esCorrecto = false;
				}
				else if (!LeerSeleccion.checkIDUnico(productos, idUnico)){
					MostrarMensajeDeError.mostrarError(14);
					esCorrecto = false;
				}
			}
			else
				esCorrecto = false;
			
		} while (!esCorrecto);
		
		return (idUnico);
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
		boolean	hayLetras = false;
		
		if (ValidarTipoDeEntrada.estaDentroDeLimites(entrada.trim()) && (ValidarTipoDeEntrada.checkSoloAlfanumerico(entrada.trim()))) {
			
			for (int i = 0; i < entrada.trim().length(); i++) {
				if (Character.isLetter(entrada.trim().charAt(i)))
					hayLetras = true;
			}
			if (!hayLetras) {
				MostrarMensajeDeError.mostrarError(13);
				return (!esCorrecto);
			}
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
