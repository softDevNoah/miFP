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
	
	public static String seleccionarCategoria(String categorias[]) {
		
		String categoriaSeleccionada;
		
		MostrarListaDeProductos.mostrarCategorias(categorias);
		categoriaSeleccionada =  categorias[MenuCliente.pedirNumeroRango(1, 4, "Inserte el nº de la categoría: ") - 1];
		
		System.out.printf("\n\t- Categoría seleccionada: \"%s\"\n\n", categoriaSeleccionada);
		
		return (categoriaSeleccionada);
	}
}
