package controlador;

import java.util.Scanner;

import modelo.*;
import vista.*;
import utiles.*;
import main.Main;

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
	
	public static int recogerIDUnico(Producto productos[]) {
		
		String entrada; 
		
		int		idUnico = -1;
		boolean	esCorrecto = false;
		
		do {
			MostrarMensajeDePeticion.msgAsigneIDUnico();
			entrada = Main.teclado.nextLine();
			if (ValidarTipoDeEntrada.estaDentroDeLimites(entrada) && ValidarTipoDeEntrada.checkSoloNumeroPositivoEntero(entrada)) {
				idUnico = Integer.parseInt(entrada);
				if (ValidarDatoDeProducto.checkIDUnico(idUnico, productos))
					esCorrecto = true;
			}
			
		} while (!esCorrecto);
		
		return (idUnico);
	}
	
	public static String recogerNombre(Producto productos[]) {
		
		String	entrada = Main.teclado.nextLine(); 
		
		String	nombre = "VACIO";
		boolean	esCorrecto = false;
		
		do {
			MostrarMensajeDePeticion.msgAsigneNombre();
			
			if (ValidarDatoDeProducto.checkNombre(entrada, productos)) {
				nombre = entrada;
				esCorrecto = true;
			}
			
		} while (!esCorrecto);
	
		return (nombre);
	}
	
	public static double recogerPrecio(Producto productos[]) {
		
		String	entrada = Main.teclado.nextLine(); 
		
		double	precio = -1.00;
		boolean	esCorrecto = false;
		
		do {
			MostrarMensajeDePeticion.msgAsignePrecio();
			
			if (ValidarDatoDeProducto.checkPrecio(entrada, productos)) {
				precio = Double.parseDouble(entrada);
				esCorrecto = true;
			}
			
		} while (!esCorrecto);
		
		return (precio);
	}
}
