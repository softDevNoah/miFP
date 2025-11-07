package vista;

public class MostrarMensajeInformativo {
	
	public static void msgBienvenida() {
        System.out.println("***********************************************************************");
        System.out.println("*                                                                     *");
        System.out.println("*   ###############################################################   *");
        System.out.println("*   #                                                             #   *");
        System.out.println("*   #   ★☆★  ¡BIENVENIDX A LA MEJOR MÁQUINA EXPENDEDORA!  ★☆★    #   *");
        System.out.println("*   #                                                             #   *");
        System.out.println("*   #          Donde los sueños se compran con monedas...         #   *");
        System.out.println("*   #              y el antojo nunca queda sin premio.            #   *");
        System.out.println("*   #                                                             #   *");
        System.out.println("*   ###############################################################   *");
        System.out.println("*                                                                     *");
        System.out.println("*            [☕]  [🍫]  [🥤]  [🍪]  [🍬]  [🍩]  [🧃]  [🥨]             *");
        System.out.println("*                                                                     *");
        System.out.println("*              → Pulsa la tecla Enter para continuar ←                *");
        System.out.println("*                                                                     *");
        System.out.println("***********************************************************************");
	}
	
	
	public static void msgEstadoSesionCorrecto(String usuario, int indiceDeMensaje) {
		
		String estados[] = {"iniciada adecuadamente. ¡Bienvenidx, ", "finalizada adecuadamente. ¡Hasta la próxima"};

		System.out.println("\n\n*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*");
		System.out.printf("											[✔]Sesión %s%s!\n", estados[indiceDeMensaje], usuario);
		System.out.println("*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*\n\n");	
	}
		
	public static void msgOperacionSeleccionada(int opcion) {
			
		String opciones[] = {"Nuevo producto", "Modificar producto", "Eliminar producto", "Salir"};
		
		System.out.println("\n\n················································································································");
		System.out.printf("			---------->>>>> Operación seleccionada: %s. <<<<<--------------\n", opciones[opcion - 1]);
		System.out.println("················································································································\n");	

	}	
	
	public static void msgOperacionRealizadaCorrectamente(int operacion) {
		
		String operaciones[] = {"AÑADIDO", "MODIFICADO", "ELIMINADO"};
		
		System.out.println("\n\n················································································································");
		System.out.printf("			---------->>>>> Se ha %s un producto CORRECTAMENTE ✔ <<<<<--------------\n", operaciones[operacion - 1]);
		System.out.println("················································································································\n");
	}	
	
}
