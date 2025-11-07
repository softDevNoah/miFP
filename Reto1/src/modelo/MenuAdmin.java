package modelo;

import controlador.*;
import main.*;
import	vista.*;

public class MenuAdmin {

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
	
	private static boolean intentoDeInicio(Usuario administradores[]) {
		
		boolean	sesionIniciada = false;
		
		if (recogerUsuarioYContraseña(administradores))
				sesionIniciada = true;
		
		return (sesionIniciada);
	}
	
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
	
	private static int indiceUsuario(String entrada, Usuario administradores[]) {
	
		int	indiceUsuario = 0;
		
		for (int i = 0; i < 4; i++) {
			if (entrada.equals(administradores[i].nombre))
				indiceUsuario = i;
		}
		
		return (indiceUsuario);
	}
	
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
