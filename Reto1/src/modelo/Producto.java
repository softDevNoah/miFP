package modelo;

public class Producto {

	String categorias[] = {"catUno", "catDos", "catTres", "catCuatro"};
	public String	categoria;
	public int		idUnico;
	public String	nombre;
	public double	precio;
	
	public Producto () {
		
		categoria = "VACIO";
		idUnico = -1;
		nombre = "VACIO";
		precio = -1.00;

	}
	
}

