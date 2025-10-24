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
				SetearDatoDeProducto.setearCategoria(productos[i], 1, false);
			else if (i < 8)
				SetearDatoDeProducto.setearCategoria(productos[i], 2, false);
			else if (i < 12)
				SetearDatoDeProducto.setearCategoria(productos[i], 3, false);
			else if (i < 16)
				SetearDatoDeProducto.setearCategoria(productos[i], 4, false);
			SetearDatoDeProducto.setearID(productos[i], i, false);
			SetearDatoDeProducto.setearNombre(productos[i], nombresIniciales[i], false);
			SetearDatoDeProducto.setearPrecio(productos[i], precios[i], false);
		}
		return (productos);
	}
	
}