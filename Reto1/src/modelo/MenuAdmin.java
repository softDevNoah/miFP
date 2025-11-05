package modelo;

import controlador.ValidarUsuarioYContraseña;
import main.Main;
import	vista.*;

public class MenuAdmin {

	public static BaseDeDatos ejecutarAdmin(BaseDeDatos baseDeDatosMasActual) {
		
		boolean	sesionIniciada;
		int		opcionElegida = -1;
		String	usuarioIniciado = "";
		String	operaciones[] = {"Nuevo producto", "Modificar producto", "Eliminar producto", "Salir"};
		
		sesionIniciada = intentoDeInicio(baseDeDatosMasActual.administradores, usuarioIniciado);
		
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
					MostrarMensajeInformativo.msgEstadoSesionCorrecto(usuarioIniciado, 1);
					sesionIniciada = false;
					break;
			}

		}
		
		return (baseDeDatosMasActual);
	}
	
	private static boolean intentoDeInicio(Usuario administradores[], String usuarioIniciado) {
		
		boolean	sesionIniciada = false;
		
		if (recogerUsuarioYContraseña(administradores, usuarioIniciado))
				sesionIniciada = true;
		
		return (sesionIniciada);
	}
	
	private static boolean recogerUsuarioYContraseña(Usuario administradores[], String usuarioIniciado) {
		
		boolean	esCorrecto = false;
		String	entrada;
		int		numUsuario = 0;
		
		do {
			MostrarMensajeDePeticion.msgIntroduzcaDatoSesion(0);
			entrada = Main.teclado.nextLine().trim();
			
			if (ValidarUsuarioYContraseña.checkUsuario(entrada, administradores))
				esCorrecto = true;

		}while (!esCorrecto);
		
		if (esCorrecto) {
			numUsuario = ValidarUsuarioYContraseña.indiceUsuario(entrada, administradores);

		MostrarMensajeDePeticion.msgIntroduzcaDatoSesion(1);
		entrada = Main.teclado.nextLine();
		
		esCorrecto = false;
		
		if (ValidarUsuarioYContraseña.checkContraseña(entrada, administradores, numUsuario))
			esCorrecto = true;

		}
		if (esCorrecto) {
			MostrarMensajeInformativo.msgEstadoSesionCorrecto(administradores[numUsuario].nombre, 1);
			usuarioIniciado = administradores[numUsuario].nombre;
		}
		return (esCorrecto);
	}
}
