package modelo;

import	vista.*;
import	controlador.*;
import main.Main;

public class MenuAdmin {

	public static BaseDeDatos ejecutarAdmin(BaseDeDatos baseDeDatosMasActual) {
		
		boolean	sesionIniciada;
		int		opcionElegida = -1;
		
		sesionIniciada = IniciarSesion.intentoDeInicio(baseDeDatosMasActual.administradores);
		
		while (sesionIniciada) {
			
			opcionElegida = lecturaOpcionMenu();
			
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
					MostrarMensajeInformativo.msgSesionFinalizada();
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
			MostrarMensajeInformativo.msgSeleccionaOperacion();
			entrada = Main.teclado.nextLine();
			if (ValidarTipoDeEntrada.estaDentroDeLimites(entrada) && ValidarTipoDeEntrada.checkSoloNumeroPositivoEntero(entrada)) {
				opcionMenu = Integer.parseInt(entrada);
				opcionValida = true;
			}
		}while (!opcionValida);
		
		System.out.println("*\n*  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  * *");
		
		return (opcionMenu);
	}
	
	
}
