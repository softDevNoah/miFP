package modelo;

/**
 * Clase que representa un producto que tiene como atributos: una categoria, un id único, un nombre y un precio.
 * El constructor asigna valores base para inicializar los productos creados.
 */
public class Producto {

	String categorias[] = {"Bebida", "Bocata", "Bollo", "Chuche"};
	public String	categoria;
	public int		idUnico;
	public String	nombre;
	public double	precio;
	
	/**
	 * Crea e inicializa un objeto con sus atributos base.
	 */
	public Producto () {
		
		categoria = "VACIO";
		idUnico = -1;
		nombre = "VACIO";
		precio = -1.00;
	}
}

