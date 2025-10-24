package modelo;

import controlador.*;

public class SetearDatoDeProducto {

	public static void setearCategoria(Producto producto, int categoria, boolean conOutput) {
		
		String categorias[] = {"catUno", "catDos", "catTres", "catCuatro"};
		
		if (conOutput) {
			categoria = RecogerDatoDeProducto.recogerCategoria(categorias);
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
			producto.idUnico = RecogerDatoDeProducto.recogerIDUnico();
		else
			producto.idUnico = id + 1;
	}
	
	public static void setearNombre(Producto producto, String nombre, boolean conOutput) {
		
		if (conOutput)
			producto.nombre = RecogerDatoDeProducto.recogerNombre();
		else
			producto.nombre = nombre;
	}
	
	
	public static void setearPrecio(Producto producto, double precio, boolean conOutput) {
		
		if (conOutput)
			producto.precio = RecogerDatoDeProducto.recogerPrecio();
		else
			producto.precio = precio;
	}
}
