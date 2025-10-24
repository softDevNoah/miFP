package controlador;

import java.util.Scanner;

import vista.*;
//import modelo.*;
//import controlador.*;
import utiles.*;

public class LeerCategoriaDeDatoDeProducto {
	
	//PSEUDOCODIGO:
		//mensaje Introduzca una categoria de producto
		//leer
		//validar (analizar diversos tipos de error)
		//Es Valido => devolvemos dato desde aqui
		//No es valido => mensaje de error (tipificado)
	
	public static int recogerCategoria() {
		
		Scanner	teclado = new Scanner(System.in);
		String	entrada = teclado.nextLine(); 
		
		int		categoria = -1;
		boolean	esValida = false;
		
		do {
			MostrarMensajeDePeticion.msgAsigneCategoria();
			
			if (ValidarDatoDeProducto.checkCategoria(entrada)) {
				categoria = determinaCategoria(entrada);
				esValida = true;
			}
			
		} while (!esValida);
		
		teclado.close();
		
		return (categoria);
	}
	
	private static int determinaCategoria(String categoria) {
		
		int	numCategoria = -1;
		switch (categoria) {
			case "tipo1":
				numCategoria = 0;
			case "tipo2":
				numCategoria = 1;
			case "tipo3":
				numCategoria = 2;
			case "tipo4":
				numCategoria = 3;
		}
		return (numCategoria);
	}
	
}
