package modelo;

import java.util.Scanner;
import modelo.*;
import main.*;
import controlador.*;
import vista.*;
import utiles.*;

public class EjecutarCodigoAdmin {

	public static	Scanner teclado = new Scanner(System.in);
	public static	String	entrada;
	public static	int		num = 0;
	
	public static void ejecutarAdmin() {
		
		boolean		sesionIniciada = false;
		Producto	productos[] = new Producto[16];
		
		BaseDeDatos.crearBaseDeDatosInicial(productos);
		
		if (!sesionIniciada) {
			IniciarSesion.iniciarSesion();
			sesionIniciada = true;
		}
		while (sesionIniciada) {
			//MostrarMenuAdmin.
		}
		
	}
	
}
