package controlador;

import modelo.*;
import vista.*;
import utiles.*;
import main.Main;

public class RecogerDatoDeProducto {
	
	public static String recogerCategoria(String categorias[]) {
		
		String	entrada = Main.teclado.nextLine(); 
		
		String	categoria = "VACIO";
		boolean	esCorrecto = false;
		
		do {
			MostrarMensajeDePeticion.msgAsigneCategoria(categorias);
			
			if (ValidarDatoDeProducto.checkCategoria(entrada, categorias)) {
				categoria = entrada;
				esCorrecto = true;
			}
			
		} while (!esCorrecto);
		
		return (categoria);
	}
	
	
	/*
	public static int recogerIDUnico(Producto productos[]) {
		
		String entrada; 
		
		int		idUnico = -1;
		boolean	esCorrecto = false;
		
		do {
			MostrarMensajeDePeticion.msgAsigneIDUnico();
			entrada = Main.teclado.nextLine();
			if (ValidarTipoDeEntrada.estaDentroDeLimites(entrada) && ValidarTipoDeEntrada.checkSoloNumeroPositivoEntero(entrada)) {
				idUnico = Integer.parseInt(entrada);
				if (ValidarDatoDeProducto.checkIDUnico(idUnico, productos))
					esCorrecto = true;
			}
			
		} while (!esCorrecto);
		
		return (idUnico);
	}*/
	
	public static String recogerNombre(Producto productos[]) {
		
		String	entrada = Main.teclado.nextLine(); 
		
		String	nombre = "VACIO";
		boolean	esCorrecto = false;
		
		do {
			MostrarMensajeDePeticion.msgAsigneNombre();
			
			if (ValidarDatoDeProducto.checkNombre(entrada, productos)) {
				nombre = entrada;
				esCorrecto = true;
			}
			
		} while (!esCorrecto);
	
		return (nombre);
	}
	
	public static double recogerPrecio() {
		
		String	entrada = Main.teclado.nextLine(); 
		
		double	precio = -1.00;
		boolean	esCorrecto = false;
		
		do {
			MostrarMensajeDePeticion.msgAsignePrecio();
			
			if (ValidarDatoDeProducto.checkPrecio(entrada)) {
				precio = Double.parseDouble(entrada);
				esCorrecto = true;
			}
			
		} while (!esCorrecto);
		
		return (precio);
	}
}
