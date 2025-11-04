package modelo;

public class Producto {

	String categorias[] = {"Bebida", "Bocata", "Bollo", "Chuche"};
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

