package modelo;

import	vista.*;

public class MenuAdmin {

	public static BaseDeDatos ejecutarAdmin(BaseDeDatos baseDeDatosMasActual) {
		
		boolean	sesionIniciada;
		int		opcionElegida = -1;
		String		usuarioIniciado = "";
		String operaciones[] = {"Nuevo producto", "Modificar producto", "Eliminar producto", "Salir"};
		
		sesionIniciada = IniciarSesion.intentoDeInicio(baseDeDatosMasActual.administradores, usuarioIniciado);
		
		while (sesionIniciada) {
			
			opcionElegida = MsgPeticion.menuOpciones("Operaciones disponibles", operaciones, "Seleccione una operación") + 1;
			
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
					MostrarMensajeInformativo.msgEstadoSesionCorrecto(usuarioIniciado, 2);
					sesionIniciada = false;
					break;
			}

		}
		
		return (baseDeDatosMasActual);
	}
	
}
