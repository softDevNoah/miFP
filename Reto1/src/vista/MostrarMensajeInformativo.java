package vista;

/**
 * Esta clase recoge los métodos que se encargan de mostrar mensajes por pantalla de tipo informativo.
 */
public class MostrarMensajeInformativo {
	
	/**
	 * Muestra la pantalla de bienvenida al inicio del programa.
	 */
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
	
	/**
	 * Muestra el saludo o la despedida según sea el estado de la sesion de administración de la máquina.
	 * @param usuario - Nombre de usuario que se mostrará en el mensaje.
	 * @param indiceDeMensaje - indice que mostrará o un saludo o una despedida.
	 */
	public static void msgEstadoSesionCorrecto(String usuario, int indiceDeMensaje) {
		
		String estados[] = {"iniciada adecuadamente. ¡Bienvenidx, ", "finalizada adecuadamente. ¡Hasta la próxima"};

		System.out.println("\n\n*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*");
		System.out.printf("											[✔]Sesión %s%s!\n", estados[indiceDeMensaje], usuario);
		System.out.println("*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*\n\n");	
	}
	
	/**
	 * Muestra la operación seleccionada en el menú de administración segun la opción recibida, con un formato.
	 * @param opcion - Indice que elige cuál es la operación que se imprime por pantalla en el mensaje.
	 */
	public static void msgOperacionSeleccionada(int opcion) {
			
		String opciones[] = {"Nuevo producto", "Modificar producto", "Eliminar producto", "Salir"};
		
		System.out.println("\n\n················································································································");
		System.out.printf("			---------->>>>> Operación seleccionada: %s. <<<<<--------------\n", opciones[opcion - 1]);
		System.out.println("················································································································\n");	

	}	
	
	/**
	 * Muestra el resultado de la operacion selecionnada, según indique el valor recibido por parámetro, con un formato.
	 * @param operacion - indice que indica que mensaje mostrar.
	 */
	public static void msgOperacionRealizadaCorrectamente(int operacion) {
		
		String operaciones[] = {"AÑADIDO", "MODIFICADO", "ELIMINADO"};
		
		System.out.println("\n\n················································································································");
		System.out.printf("			---------->>>>> Se ha %s un producto CORRECTAMENTE ✔ <<<<<--------------\n", operaciones[operacion - 1]);
		System.out.println("················································································································\n");
	}	
	
}
