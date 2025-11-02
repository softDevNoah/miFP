package main;

import modelo.*;
import vista.*;

import java.util.Scanner;

public class Main {
	
	public static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		BaseDeDatos baseDeDatos = new BaseDeDatos();
		int			seleccionPrograma;
		String		opcionesMenu[] = {"Comprar productos", "Administrar máquina expendedora"};
		
		while (true) {
			MostrarMensajeInformativo.msgBienvenida();
			teclado.nextLine();
			
			seleccionPrograma = MsgPeticion.menuOpciones("Operaciones disponibles", opcionesMenu, "Seleccione una operación");
			
			if (seleccionPrograma == 0) {
				MenuCliente.ejecutarCliente(baseDeDatos.productos);
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			else if (seleccionPrograma == 1)
				baseDeDatos = MenuAdmin.ejecutarAdmin(baseDeDatos);
			
			System.out.println("\n".repeat(50));	
		}
	}

}
