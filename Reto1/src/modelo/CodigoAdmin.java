package modelo;

import	vista.*;
import	controlador.*;

public class CodigoAdmin {

	public static BaseDeDatos ejecutarAdmin(BaseDeDatos baseDeDatosMasActual) {
		
		boolean	sesionIniciada;
		int		opcionElegida = -1;
		
		sesionIniciada = IniciarSesion.intentoDeInicio(baseDeDatosMasActual.administradores);
		
		while (sesionIniciada) {
			
			MostrarMenuAdmin.msgSeleccionaOperacion();
			opcionElegida = LeerOpcionMenu.checkOpcionMenu();
			
			switch (opcionElegida) {
				case 1:
					MostrarMensajeOperacionCorrecta.msgOperacionSeleccionada(1);
					break;
				case 2:
					MostrarMensajeOperacionCorrecta.msgOperacionSeleccionada(2);
					break;
				case 3:
					MostrarMensajeOperacionCorrecta.msgOperacionSeleccionada(3);
					break;
				case 4:
					MostrarMensajeOperacionCorrecta.msgOperacionSeleccionada(4);
					MostrarMensajeOperacionCorrecta.msgSesionFinalizada();
					sesionIniciada = false;
					break;
			}
		}
		return (baseDeDatosMasActual);
	}
	
}
