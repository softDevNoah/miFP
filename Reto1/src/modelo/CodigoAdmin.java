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
			opcionElegida = LeerOpcionMenu.lecturaOpcionMenu();
			
			switch (opcionElegida) {
				case 1:
					MostrarMensajeOperacionCorrecta.msgOperacionSeleccionada(1);
					baseDeDatosMasActual.productos = Operaciones.nuevoProducto(baseDeDatosMasActual.productos);
					break;
				case 2:
					MostrarMensajeOperacionCorrecta.msgOperacionSeleccionada(2);
					if (Operaciones.modificarProducto(baseDeDatosMasActual.productos))
						MostrarMensajeOperacionCorrecta.msgProductoModificadoCorrectamente();
					break;
				case 3:
					MostrarMensajeOperacionCorrecta.msgOperacionSeleccionada(3);
					if (Operaciones.eliminarProducto(baseDeDatosMasActual.productos))
						MostrarMensajeOperacionCorrecta.msgProductoEliminadoCorrectamente();
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
	
}
