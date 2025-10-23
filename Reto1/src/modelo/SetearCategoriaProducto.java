package modelo;

import modelo.*;
import main.*;
import controlador.*;
import vista.*;
import utiles.*;

public class SetearCategoriaProducto {

	
	
	public static void setearCategoria(Producto producto, int categoria, boolean bdInicial) {
		
		String categorias[] = {"tipo1", "tipo2", "tipo3", "tipo4"};
		
		
		
		if (!bdInicial) {
			//producto.categoria = categoria;
		}
		else 
			producto.categoria = categorias[categoria -1];
	}
}
