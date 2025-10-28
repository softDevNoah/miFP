package modelo;

public class BaseDeDatos {
	
	Producto	productos[];
	Usuario 	administradores[];
	
	public BaseDeDatos() {
		
		this.productos = new Producto[16];
		this.administradores = new Usuario[4];
		
		String	nombres[] = {"user1", "user2", "user3", "user4"};
		String	contraseñas[] = {"1234", "qwer", "qwer1234", "1234qwer"};
		
		productos = setearProductosIniciales(productos);
		
		for(int i = 0; i < 4; i++) {
			administradores[i] = new Usuario();
			administradores[i].nombre = nombres[i];
			administradores[i].contraseña = contraseñas[i];
		}
	}
	
	private Producto[] setearProductosIniciales(Producto productos[]) {
		
		String	nombresIniciales[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "ñ", "o"};
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