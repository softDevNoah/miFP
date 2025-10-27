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
	
	public static void setearID(Producto productos[], Producto producto, int id, boolean conOutput) {
		
		if (conOutput)
			producto.idUnico = RecogerDatoDeProducto.recogerIDUnico(productos);
		else
			producto.idUnico = id + 1;
	}
	
	public static void setearNombre(Producto productos[], Producto producto, String nombre, boolean conOutput) {
		
		if (conOutput)
			producto.nombre = RecogerDatoDeProducto.recogerNombre(productos);
		else
			producto.nombre = nombre;
	}
	
	
	public static void setearPrecio(Producto productos[], Producto producto, double precio, boolean conOutput) {
		
		if (conOutput)
			producto.precio = RecogerDatoDeProducto.recogerPrecio(productos);
		else
			producto.precio = precio;
	}
}
