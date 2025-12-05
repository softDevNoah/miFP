package modelo;

/**
	 * Clase del objeto BaseDeDatos, que como su nombre indica hará de base de datos, y tiene como atributos
	 *  un array de objetos de clase Producto y un array de objetos de clase Usuario, que son los administradores.
	 */
public class BaseDeDatos {
	
	public Producto	productos[];
	public Usuario 	administradores[];
	
	/**
	 * Constructor del objeto de esta clase, inicializará los valores de sus atributos automáticamente.
	 * Crea 16 productos básicos y 4 usuarios estándar.
	 */
	public BaseDeDatos() {
		
		this.productos = new Producto[16];
		this.administradores = new Usuario[4];
		
		String	nombres[] = {"Maitane", "Rodny", "Esti", "Noah"};
		String	contraseñas[] = {"mait1", "rodn2", "esti3", "noah4"};
		
		productos = setearProductosIniciales(productos);
		
		for(int i = 0; i < 4; i++) {
			administradores[i] = new Usuario();
			administradores[i].nombre = nombres[i];
			administradores[i].contraseña = contraseñas[i];
		}
	}

	/**
	 * Asigna valores a los atributos de los elementos del array de {@code Producto}
	 * @param productos - Array vacío de productos disponibles en la máquina expendedora.
	 * @return Retorna el array inicializado
	 */	private Producto[] setearProductosIniciales(Producto productos[]) {
		
		String	nombresIniciales[] = {"Agua", "Fanta", "Zumo", "Monster", "Vegano", "Chorizo", "Vegetal", "Mixto",
									"Donete", "Zebra", "Palmera", "Cruasán", "KitKat", "Mars", "Kinder", "Twix"};
		double	precios[] = {1.20, 0.6, 0.85, 0.45, 2.2, 2.15, 1.85, 1.20, 0.6, 0.85, 0.45, 2.2, 2.15, 1.85, 1.0, 1.35};
	
		for (int i = 0; i < 16; i++) {
		
			productos[i] = new Producto();
			if (i < 4)
				productos[i].categoria = productos[i].categorias[0];
			else if (i < 8)
				productos[i].categoria = productos[i].categorias[1];
			else if (i < 12)
				productos[i].categoria = productos[i].categorias[2];
			else if (i < 16)
				productos[i].categoria = productos[i].categorias[3];
			
			productos[i].idUnico = i + 1;
			productos[i].nombre = nombresIniciales[i];
			productos[i].precio = precios[i];
		}
		return (productos);
	}
	
	
	
}