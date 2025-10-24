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
			administradores[i].nombre = nombres[i];
			administradores[i].contraseña = contraseñas[i];
		}
	}
	
	private Producto[] setearProductosIniciales(Producto productos[]) {
		
		String	nombresIniciales[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "ñ", "o"};
	
		for (int i = 0; i < 16; i++) {
			
			if (i < 4)
				SetearDatoDeProducto.setearCategoria(productos[i], 1, false);
			else if (i < 8)
				SetearDatoDeProducto.setearCategoria(productos[i], 2, false);
			else if (i < 12)
				SetearDatoDeProducto.setearCategoria(productos[i], 3, false);
			else if (i < 16)
				SetearDatoDeProducto.setearCategoria(productos[i], 4, false);
			SetearDatoDeProducto.setearID(productos[i], i, false);
			SetearDatoDeProducto.setearNombre(productos[i], nombresIniciales[i], false);
			SetearDatoDeProducto.setearPrecio(productos[i], (double)i, false);
		}
		return (productos);
	}
	
}