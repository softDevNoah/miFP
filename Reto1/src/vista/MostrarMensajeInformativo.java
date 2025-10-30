package vista;

public class MostrarMensajeInformativo {

	public static void msgInicioSesionCorrecto(String usuario) {
		System.out.println("\n\n*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*");
		System.out.printf("											Sesión iniciada adecuadamente. Bienvenidx, %s!\n", usuario);
		System.out.println("*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*\n\n");	
	}
	
	public static void msgSesionFinalizada() {
		System.out.println("\n\n*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*");
		System.out.println("											Sesión finalizada adecuadamente. Hasta la próxima!");
		System.out.println("*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*");	
	}
	
	
	public static void msgOperacionSeleccionada(int opcion) {
			
		String opciones[] = {"Nuevo producto", "Modificar producto", "Eliminar producto", "Salir"};
		
		System.out.println("\n\n················································································································");
		System.out.printf("			---------->>> Operación seleccionada: %s. <<<<<--------------\n", opciones[opcion - 1]);
		System.out.println("················································································································\n");	

	}	
	
	public static void msgOperacionRealizadaCorrectamente(int operacion) {
		
		String operaciones[] = {"CREADO", "MODIFICADO", "ELIMINADO"};
		
		System.out.println("\n\n················································································································");
		System.out.printf("			---------->>> Se ha %s un producto CORRECTAMENTE <<<<<--------------\n", operaciones[operacion - 1]);
		System.out.println("················································································································\n");
	}
	
	public static void msgSeleccionaOperacion() {
		
		System.out.println("*  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  * *\n*");
		System.out.println("*\tOperaciones disponibles:											*");
		System.out.println("*\t\t1.- Nuevo producto.          									*");
		System.out.println("*\t\t2.- Modificar producto.             								*");
		System.out.println("*\t\t3.- Eliminar producto.             								*");
		System.out.println("*\t\t4.- Salir.        										*");
		System.out.println("*                              											*");
		System.out.println("*\t\tIntroduce el número de la operación que desea realizar (1, 2, 3, 4)				*");
		System.out.println("*                              											*");
		System.out.print("*\tOperación número: ");
	}
	
}
