package modelo;

import	vista.*;
import	controlador.*;
import main.Main;

public class CodigoAdmin {

	public static BaseDeDatos ejecutarAdmin(BaseDeDatos baseDeDatosMasActual) {
		
		boolean	sesionIniciada;
		int		opcionElegida = -1;
		
		sesionIniciada = IniciarSesion.intentoDeInicio(baseDeDatosMasActual.administradores);
		
		while (sesionIniciada) {
			
			MostrarMenuAdmin.msgSeleccionaOperacion();
			opcionElegida = lecturaOpcionMenu();
			
			switch (opcionElegida) {
				case 1:
					MostrarMensajeOperacionCorrecta.msgOperacionSeleccionada(1);
					baseDeDatosMasActual.productos = Operaciones.nuevoProducto(baseDeDatosMasActual.productos);
					break;
				case 2:
					MostrarMensajeOperacionCorrecta.msgOperacionSeleccionada(2);
					baseDeDatosMasActual.productos = Operaciones.modificarProducto(baseDeDatosMasActual.productos);
					break;
				case 3:
					MostrarMensajeOperacionCorrecta.msgOperacionSeleccionada(3);
					baseDeDatosMasActual.productos = Operaciones.eliminarProducto(baseDeDatosMasActual.productos);
					break;
				case 4:
					MostrarMensajeOperacionCorrecta.msgOperacionSeleccionada(4);
					MostrarMensajeOperacionCorrecta.msgSesionFinalizada();
					sesionIniciada = false;
					break;
			}
			if (opcionElegida < 1 || opcionElegida > 4)
				MostrarMensajeDeError.opcionIncorrecta();
		}
		
		return (baseDeDatosMasActual);
	}
	
	public static int lecturaOpcionMenu() {
		
		boolean opcionValida = false;
		int		opcionMenu = -1;
		
		String entrada;
		
		do {
			entrada = Main.teclado.nextLine();
			if (ValidarTipoDeEntrada.estaDentroDeLimites(entrada) && ValidarTipoDeEntrada.checkSoloNumeroPositivoEntero(entrada)) {
				opcionMenu = Integer.parseInt(entrada);
				opcionValida = true;
			}
		}while (!opcionValida);
		
		System.out.println("*  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  * *");
		
		return (opcionMenu);
	}
	
}
