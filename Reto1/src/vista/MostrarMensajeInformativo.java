package vista;

public class MostrarMensajeInformativo {

	public static void msgInicioSesionCorrecto(String usuario) {
		System.out.println("\n\n*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*");
		System.out.printf("								Sesión iniciada adecuadamente. Bienvenidx, %s!\n", usuario);
		System.out.println("*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*\n\n");	
	}
	
	public static void msgSesionFinalizada() {
		System.out.println("\n\n*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*");
		System.out.println("*	*	*	*	*	*	*	*	Sesión finalizada adecuadamente. Hasta la próxima!	*	*	*	*	*	*	*	*	*	*	*	*	*	*");
		System.out.println("*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*");	
	}
	
	
	public static void msgOperacionSeleccionada(int opcion) {
			
		String opciones[] = {"Nuevo producto", "Modificar producto", "Eliminar producto", "Salir"};
		
		System.out.println("\n\n*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*");
		System.out.printf("			---------->>>	Operación seleccionada: %s.		<<<<<--------------\n", opciones[opcion - 1]);
		System.out.println("*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*\n");	

	}	
	
	public static void msgProductoCreadoCorrectamente() {
		
		System.out.println("\n\n*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*");
		System.out.println("\t- Se ha creado un producto nuevo correctamente.	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*");
		System.out.println("*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*\n\n");	
	}
	
	public static void msgProductoModificadoCorrectamente() {
		
		System.out.println("\n\n*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*");
		System.out.println("\t- Se ha modificado un producto correctamente.	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*");
		System.out.println("*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*\n\n");	
	}

	public static void msgProductoEliminadoCorrectamente() {
	
		System.out.println("\n\n*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*");
		System.out.println("\t- Se ha eliminado un producto correctamente.	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*");
		System.out.println("*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*\n\n");	
	}
	
	public static void msgSeleccionaOperacion() {
		
		System.out.println("*  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  * *");
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
