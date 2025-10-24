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
					//nuevoProducto + volver + validaciones
					break;
				case 2:
					//modificarProducto + volver + validaciones
					break;
				case 3:
					//eliminarProducto + volver + validaciones
					break;
				case 4:
					MostrarMensajeOperacionCorrecta.msgSesionFinalizada();
					sesionIniciada = false;
					break;
			}
		}
		return (baseDeDatosMasActual);
	}
	
}
