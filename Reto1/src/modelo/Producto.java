package modelo;

import modelo.*;
import main.*;
import controlador.*;
import vista.*;
import utiles.*;

public class Producto {

	static String	categoria = "";
	static int		idUnico = 0;
	static String	nombre = "";
	static double	precio = 0.00;
	
	public static Producto crearProductoEnSilencio(String categoria, int idUnico, String nombre, double precio) {
		
		Producto producto = new Producto();
		
		setearCategoria(producto, categoria);
		setearIDUnico(producto, idUnico);
		setearNombre(producto, nombre);
		setearPrecio(producto, precio);
		return (producto);
	}
	
	
	public static void setearCategoria(Producto producto, String categoria) {
		producto.categoria = categoria;
	}
	
	public static void setearIDUnico(Producto producto, int idUnico) {
		producto.idUnico = idUnico;
	}
	
	public static void setearNombre(Producto producto, String nombre) {
		producto.nombre = nombre;
	}
	
	public static void setearPrecio(Producto producto, double precio) {
		producto.precio = precio;
	}
	
	public static Producto crearProducto(String categoria, int idUnico, String nombre, double precio) {
		
		Producto producto = new Producto();
		
		setearCategoria(producto, categoria);
		setearIDUnico(producto, idUnico);
		setearNombre(producto, nombre);
		setearPrecio(producto, precio);
		return (producto);
	}
	
	
	public static void seleccionarCategoria(Producto producto, String categoria) {
		
		;
	}
	
	public static void seleccionarIDUnico(Producto producto, int idUnico) {
		producto.idUnico = idUnico;
	}
	
	public static void seleccionarNombre(Producto producto, String nombre) {
		producto.nombre = nombre;
	}
	
	public static void seleccionarPrecio(Producto producto, double precio) {
		producto.precio = precio;
	}
}
