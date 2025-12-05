package modelo;

import controlador.*;
import main.*;
import	vista.*;

/**
 * Esta clase gestiona el flujo principal de la parte del programa que gestiona un administrador en una máquina expendedora.
 * Inicia sesión, y si el inicio es correcto, muestra un menú de operaciones y ejecuta según se seleccione.
 * Si el inicio no es correcto, se termina este proceso.
 */
public class MenuAdmin {

	/**
	 * Inicia sesion, si es correcto luego muestra un menú de operaciones a elegir por el lado del administrador.
	 * Siempre que la selección sea correcta, muestra un mensaje informativo de la operación seleccionada y ejecuta el método correspondiente.
	 * Si no es correcta, mostrará el mensaje de error correspondiente.
	 * 
	 * @param baseDeDatosMasActual - Base de datos más reciente con la que trabajará el administrador que inicie sesión
	 * @return devuelve el objeto de la base de datos con los cambios que se hubieran realizado
	 */
	public static BaseDeDatos ejecutarAdmin(BaseDeDatos baseDeDatosMasActual) {
		
		boolean	sesionIniciada;
		int		opcionElegida = -1;
		String	operaciones[] = {"Nuevo producto", "Modificar producto", "Eliminar producto", "Salir"};
		
		sesionIniciada = intentoDeInicio(baseDeDatosMasActual.administradores);
		
		while (sesionIniciada) {
			
			opcionElegida = MostrarMensajeDePeticion.menuOpciones("Operaciones disponibles", operaciones, "Seleccione una operación") + 1;
			
			switch (opcionElegida) {
				case 1:
					MostrarMensajeInformativo.msgOperacionSeleccionada(1);
					baseDeDatosMasActual.productos = Operaciones.nuevoProducto(baseDeDatosMasActual.productos);
					break;
				case 2:
					MostrarMensajeInformativo.msgOperacionSeleccionada(2);
					baseDeDatosMasActual.productos = Operaciones.modificarProducto(baseDeDatosMasActual.productos);
					break;
				case 3:
					MostrarMensajeInformativo.msgOperacionSeleccionada(3);
					baseDeDatosMasActual.productos = Operaciones.eliminarProducto(baseDeDatosMasActual.productos);
					break;
				case 4:
					MostrarMensajeInformativo.msgOperacionSeleccionada(4);
					MostrarMensajeInformativo.msgEstadoSesionCorrecto("", 1);
					sesionIniciada = false;
					break;
			}

		}
		
		return (baseDeDatosMasActual);
	}
	
	/**
	 * DEtermina si se inicia la sesion con éxito.
	 * 
	 * @param administradores - el array de clase Usuario que contiene la lista de administradores existente
	 * @return un booleano que indica si se inicia la sesion o no
	 */
	private static boolean intentoDeInicio(Usuario administradores[]) {
		
		boolean	sesionIniciada = false;
		
		if (recogerUsuarioYContraseña(administradores))
				sesionIniciada = true;
		
		return (sesionIniciada);
	}
	
	/**
	 * Recoger usuario y contraseña para posteriormente ser verificados e indicar si son correctos para realizar el inicio de sesión.
	 * 
	 * @param administradores - el array de clase Usuario que contiene la lista de administradores existente
	 * @return un booleano sobre si el usuario y  la contraseña introducidos son correctos o no
	 */
	private static boolean recogerUsuarioYContraseña(Usuario administradores[]) {
		
		boolean	esCorrecto = false;
		String	entrada;
		int		numUsuario = 0;
		
		do {
			MostrarMensajeDePeticion.msgIntroduzcaDatoSesion(0);
			entrada = Main.teclado.nextLine().trim();
			
			if (checkUsuario(entrada, administradores))
				esCorrecto = true;

		}while (!esCorrecto);
		
		if (esCorrecto) {
			numUsuario = indiceUsuario(entrada, administradores);

		MostrarMensajeDePeticion.msgIntroduzcaDatoSesion(1);
		entrada = Main.teclado.nextLine();
		
		esCorrecto = false;
		
		if (checkContraseña(entrada, administradores, numUsuario))
			esCorrecto = true;

		}
		if (esCorrecto)
			MostrarMensajeInformativo.msgEstadoSesionCorrecto(administradores[numUsuario].nombre, 0);
		return (esCorrecto);
	}
	
	/**
	 * Verifica si el string ingresado está presente en el array, para determinar si el usuario introducido existe en la base de datos.
	 * 
	 * @param entrada - Nombre se usuario que se va a buscar en la base de datos
	 * @param administradores - el array de clase Usuario que contiene la lista de administradores existente
	 * @return booleano que idica si el valor ingresado está presente en el array (por tanto es váido) o no
	 */
	private static boolean checkUsuario(String entrada, Usuario administradores[]) {
		
		boolean existe = false;
		
		if (ValidarTipoDeEntrada.estaDentroDeLimites(entrada) && ValidarTipoDeEntrada.checkSoloAlfanumerico(entrada)) {
			for (int i = 0; i < 4; i++) {
				if (entrada.equals(administradores[i].nombre))
					existe = true;
			}
			if (!existe)
				MostrarMensajeDeError.usuarioNoExiste(entrada);
		}
		return (existe);
	}
	
	/**
	 * Busca el indice del string en el array.
	 * Esto solo es posible cuando ya se ha verificado previamente que efectivamente existe en dicho array.
	 * 
	 * @param entrada - Nombre se usuario que se va a buscar en la base de datos
	 * @param administradores - el array de clase Usuario que contiene la lista de administradores existente
	 * @return índice (número entero) de donde se encuentra el usuario dentro del array de usuarios recibido 
	 */
	private static int indiceUsuario(String entrada, Usuario administradores[]) {
	
		int	indiceUsuario = 0;
		
		for (int i = 0; i < 4; i++) {
			if (entrada.equals(administradores[i].nombre))
				indiceUsuario = i;
		}
		
		return (indiceUsuario);
	}
	
	/**
	 * Verifica si la contraseña es correcta, es decir, si es la que corresponde al usuario previamente introducido.
	 * Se verifica acorde a los valores de la base de datos.
	 * 
	 * @param entrada - Contraseña introducida que ha de ser verificada.
	 * @param administradores - el array de clase Usuario que contiene la lista de administradores existente
	 * @param indiceUsuario - índice del usuario dentro del array de administradores
	 * @return booleano que indica si la contraseña es correcta (pertenece a ese usuario) o no
	 */
	private static boolean checkContraseña(String entrada, Usuario administradores[], int indiceUsuario) {
		
		boolean existe = true;
		if (ValidarTipoDeEntrada.estaDentroDeLimites(entrada) && ValidarTipoDeEntrada.checkSoloAlfanumerico(entrada)) {
			if (!entrada.equals(administradores[indiceUsuario].contraseña)) {
				existe = false;
				MostrarMensajeDeError.mostrarError(7);
			}
		}
		else
			existe = false;
		return (existe);
	}
}
