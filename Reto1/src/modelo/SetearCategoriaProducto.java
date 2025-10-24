package modelo;

import controlador.LeerCategoriaDeDatoDeProducto;

//import controlador.*;
//import vista.*;
//import utiles.*;

public class SetearCategoriaProducto {

	
	
	public static void setearCategoria(Producto producto, int categoria, boolean conOutput) {
		
		String categorias[] = {"tipo1", "tipo2", "tipo3", "tipo4"};
		
		if (conOutput) {
			categoria = LeerCategoriaDeDatoDeProducto.recogerCategoria();
			producto.categoria = categorias[categoria];
		}
		else {
			switch (categoria) {
			
			case 1:
				producto.categoria = categorias[0];
			case 2:
				producto.categoria = categorias[1];
			case 3:
				producto.categoria = categorias[2];
			case 4:
				producto.categoria = categorias[3];
			}
		}
	}
	
	public static void setearID(Producto producto, int id, boolean conOutput) {
		
		if (conOutput)
			producto.idUnico = LeerCategoriaDeDatoDeProducto.recogerCategoria();
		else
			producto.idUnico = id + 1;
	}
}
