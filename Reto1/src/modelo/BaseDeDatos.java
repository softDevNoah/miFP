package modelo;

import modelo.*;
import main.*;
import controlador.*;
import vista.*;
import utiles.*;

public class BaseDeDatos {

	
	
	public static Producto[] crearBaseDeDatosInicial(Producto producto[]) {
	
		
		for (int i = 0; i < 4; i++) {
			SetearCategoriaProducto.setearCategoria(producto[i], 1, false);
		}
		for (int i = 4; i < 8; i++) {
			SetearCategoriaProducto.setearCategoria(producto[i], 2, false);
		}
		for (int i = 8; i < 12; i++) {
			SetearCategoriaProducto.setearCategoria(producto[i], 3, false);
		}
		for (int i = 12; i < 16; i++) {
			SetearCategoriaProducto.setearCategoria(producto[i], 4, false);
		}
	}
}
