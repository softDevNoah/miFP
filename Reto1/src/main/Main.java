package main;

import modelo.*;

public class Main {
	
	public static void main(String[] args) {
		
		Producto	productos[] = new Producto[16];
		productos = BaseDeDatos.setearBaseDeDatosInicial(productos);
		
		//BUCLE: pantalla bienvenida (do-while?)
		//pulse cualquier tecla para comenzar
		//quiere comprar un producto o administrar maquina expendedora (if)
		//selecciona opcion 1 o 2
		
		//opcion2:
		CodigoAdmin.ejecutarAdmin(productos);
	}

}
