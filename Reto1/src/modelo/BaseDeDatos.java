package modelo;

//import controlador.*;
//import vista.*;
//import utiles.*;

public class BaseDeDatos {

	
	
	public static Producto[] setearBaseDeDatosInicial(Producto producto[]) {
	
		
		for (int i = 0; i < 4; i++) {
			SetearCategoriaProducto.setearCategoria(producto[i], 1, false);
			SetearCategoriaProducto.setearID(producto[i], i, false);
			//setear nombre
			//setear precio
		}
		for (int i = 4; i < 8; i++) {
			SetearCategoriaProducto.setearCategoria(producto[i], 2, false);
			SetearCategoriaProducto.setearID(producto[i], i, false);
		}
		for (int i = 8; i < 12; i++) {
			SetearCategoriaProducto.setearCategoria(producto[i], 3, false);
			SetearCategoriaProducto.setearID(producto[i], i, false);
		}
		for (int i = 12; i < 16; i++) {
			SetearCategoriaProducto.setearCategoria(producto[i], 4, false);
			SetearCategoriaProducto.setearID(producto[i], i, false);
		}
	
	return (producto);
	}
}
