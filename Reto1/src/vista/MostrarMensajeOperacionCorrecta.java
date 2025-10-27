package vista;

public class MostrarMensajeOperacionCorrecta {

	public static void msgSesionFinalizada() {
		System.out.println("\n\n*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*");
		System.out.println("*	*	*	*	*	*	*	*	Sesión finalizada adecuadamente. Hasta la próxima!	*	*	*	*	*	*	*	*	*	*	*");
		System.out.println("*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*");	
	}
	
	
	
	
	public static void msgOperacionSeleccionada(int opcion) {
			
		String opciones[] = {"Nuevo producto", "Modificar producto", "Eliminar producto", "Salir"};
		
		System.out.println("\n\n*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*");
			System.out.printf("			---------->>>	Operación seleccionada: %s.		<<<<<--------------\n", opciones[opcion - 1]);
			System.out.println("*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*\n");	

	}	
}
