package main;

import modelo.*;
import vista.*;

import java.util.Scanner;

public class Main {
	
	public static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		BaseDeDatos baseDeDatos = new BaseDeDatos();
		
		while (true) {
			MostrarMensajeInformativo.msgBienvenida();
			teclado.nextLine();
			if (MostrarMensajeDePeticion.condicionEsClienteOAdministrador() == 1)
				MenuCliente.ejecutarCliente(baseDeDatos.productos);
			else if (MostrarMensajeDePeticion.condicionEsClienteOAdministrador() == 2)
				baseDeDatos = MenuAdmin.ejecutarAdmin(baseDeDatos);
			else
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		}
	}

}
