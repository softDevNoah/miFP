package controlador;

import java.util.Scanner;

import vista.*;
import utiles.*;

public class RecogerDatoDeProducto {
	
	//PSEUDOCODIGO:
		//mensaje Introduzca una categoria de producto
		//leer
		//validar (analizar diversos tipos de error)
		//Es Valido => devolvemos dato desde aqui
		//No es valido => mensaje de error (tipificado)
	
	public static int recogerCategoria(String categorias[]) {
		
		Scanner	teclado = new Scanner(System.in);
		String	entrada = teclado.nextLine(); 
		
		int		categoria = -1;
		boolean	esCorrecto = false;
		
		do {
			MostrarMensajeDePeticion.msgAsigneCategoria();
			
			if (ValidarDatoDeProducto.checkCategoria(entrada, categorias)) {
				categoria = determinaCategoria(entrada);
				esCorrecto = true;
			}
			
		} while (!esCorrecto);
		
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
	
	public static int recogerIDUnico() {
		
		Scanner	teclado = new Scanner(System.in);
		String	entrada = teclado.nextLine(); 
		
		int		idUnico = -1;
		boolean	esCorrecto = false;
		
		do {
			MostrarMensajeDePeticion.msgAsigneIDUnico();
			
			if (ValidarDatoDeProducto.checkIDUnico(entrada)) {
				idUnico = Integer.parseInt(entrada);
				esCorrecto = true;
			}
			
		} while (!esCorrecto);
		
		teclado.close();
		
		return (idUnico);
	}
	
	public static String recogerNombre() {
		
		Scanner	teclado = new Scanner(System.in);
		String	entrada = teclado.nextLine(); 
		
		String	nombre = "VACIO";
		boolean	esCorrecto = false;
		
		do {
			MostrarMensajeDePeticion.msgAsigneNombre();
			
			if (ValidarDatoDeProducto.checkNombre(entrada)) {
				nombre = entrada;
				esCorrecto = true;
			}
			
		} while (!esCorrecto);
		
		teclado.close();
		
		return (nombre);
	}
	
	public static double recogerPrecio() {
		
		Scanner	teclado = new Scanner(System.in);
		String	entrada = teclado.nextLine(); 
		
		double	precio = -1.00;
		boolean	esCorrecto = false;
		
		do {
			MostrarMensajeDePeticion.msgAsignePrecio();
			
			if (ValidarDatoDeProducto.checkPrecio(entrada)) {
				precio = Double.parseDouble(entrada);
				esCorrecto = true;
			}
			
		} while (!esCorrecto);
		
		teclado.close();
		
		return (precio);
	}
}
