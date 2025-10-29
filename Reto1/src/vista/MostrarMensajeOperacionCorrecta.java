package vista;

public class MostrarMensajeOperacionCorrecta {

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
	
}
