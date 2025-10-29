package controlador;

import modelo.*;
import vista.*;
import utiles.*;
import main.Main;

public class RecogerDatoDeProducto {
	
	public static String recogerCategoria(String categorias[]) {
		
		String	entrada; 
		boolean	esCorrecto = false;
		
		do {
			MostrarMensajeDePeticion.msgAsigneCategoria(categorias);
			entrada = Main.teclado.nextLine();
			if (ValidarDatoDeProducto.checkCategoria(entrada, categorias))
				esCorrecto = true;
		} while (!esCorrecto);
		
		return (entrada);
	}
	
	public static String recogerNombre(Producto productos[]) {
		
		String	entrada; 
		
		boolean	esCorrecto = false;
		
		do {
			MostrarMensajeDePeticion.msgAsigneNombre();
			entrada = Main.teclado.nextLine();
			if (ValidarDatoDeProducto.checkNombre(entrada, productos))
				esCorrecto = true;			
		} while (!esCorrecto);
	
		return (entrada);
	}
	
	public static double recogerPrecio() {
		
		String	entrada; 
		
		double	precio = -1.00;
		boolean	esCorrecto = false;
		
		do {
			MostrarMensajeDePeticion.msgAsignePrecio();
			entrada = Main.teclado.nextLine();
			if (ValidarDatoDeProducto.checkPrecio(entrada)) {
				precio = Double.parseDouble(entrada);
				esCorrecto = true;
			}
			
		} while (!esCorrecto);
		
		return (precio);
	}
}
