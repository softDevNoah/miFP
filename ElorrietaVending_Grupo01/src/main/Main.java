package main;

import modelo.*;
import vista.*;

import java.util.Scanner;

public class Main {
	
	public static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		BaseDeDatos baseDeDatos = new BaseDeDatos();
		int			seleccionPrograma = -1;
		String		opcionesMenu[] = {"Comprar productos", "Administrar máquina expendedora", "Apagar máquina expendedora"};
		
		while (seleccionPrograma != 2) {
			MostrarMensajeInformativo.msgBienvenida();
			teclado.nextLine();
			
			seleccionPrograma = MostrarMensajeDePeticion.menuOpciones("Operaciones disponibles", opcionesMenu, "Seleccione una operación");
			
			if (seleccionPrograma == 0) {
				MenuCliente.ejecutarCliente(baseDeDatos.productos);
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			else if (seleccionPrograma == 1) {
				baseDeDatos = MenuAdmin.ejecutarAdmin(baseDeDatos);
			}
			System.out.println("\n".repeat(10));
		}
		
		System.out.println("\n\n················································································································");
		System.out.println("	         ---------->>> Apagando máquina... ¡Hasta la próxima! <<<<<--------------");
		System.out.println("················································································································\n");
		
		teclado.close();
	}	
}
