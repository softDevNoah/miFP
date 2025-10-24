package main;

import modelo.*;

public class Main {
	
	public static void main(String[] args) {
		
		//la BD va en el verdadero main, fuera del bucle de bienvenida etc
		BaseDeDatos baseDeDatos = new BaseDeDatos();
			
		//antes de aqui va:
			//BUCLE: pantalla bienvenida (do-while?)
			//pulse cualquier tecla para comenzar
			//quiere comprar un producto o administrar maquina expendedora (if)
			//selecciona opcion 1 o 2
		
		//opcion2:
		CodigoAdmin.ejecutarAdmin(baseDeDatos);
	}

}
