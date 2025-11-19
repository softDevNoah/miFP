package modelo;

import java.util.Scanner;

import controlador.*;
import vista.*;

public class Main {

	public static Scanner teclado = new Scanner(System.in);;
	public static String entrada;
	public static int x;
	public static int y;
	public static int maxTiradas = 15;
	public static int tiradas = 0;
	public static String tableroInterno[][] = { {" ", "D", "D", "D", " "}, {"F", " ", " ", " ", " "}, {"F", " ", "S", "F", "F"}, {" ", " ", "S", " ", " "}, {" ", " ", " ", "S", "S"}};
	public static String tableroJuego[][] = { {" ", " ", " ", " ", " "}, {" ", " ", " ", " ", " "}, {" ", " ", " ", " ", " "}, {" ", " ", " ", " ", " "}, {" ", " ", " ", " ", " "}};
	
	public static void main(String[] args) {
		
		System.out.println("\t¡Bienvenidx! \tSi desea jugar a Batalla Naval pulse Enter, por favor.");
		teclado.nextLine();
		
		while(tiradas < maxTiradas) {
			
			x = -1;
			y = -1;
			
			MostrarTableroDeJuego.tirada(tableroJuego);
			
			System.out.printf("Tirada %d:\n\tInserte coordenada x: ", tiradas);
			entrada = teclado.nextLine();
			if (ValidarEntrada.limitesOk(entrada) && ValidarEntrada.esNum(entrada)) {
				
				x = Integer.parseInt(entrada);
				
				System.out.print("\n\tInserte coordenada y: ");
				entrada = teclado.nextLine();
				
				if (ValidarEntrada.limitesOk(entrada) && ValidarEntrada.esNum(entrada)) {
					y = Integer.parseInt(entrada);
				}
			}
			
			if (x < 0 || x > 5 || y < 0 || y > 5 )
				System.out.println("Coordenadas incorrectas, se penalizará una tirada...");
			else {
				
				if (tableroInterno[x][y] == "D") {
					tableroJuego[x][y] = "X";
					MostrarTableroDeJuego.tirada(tableroJuego);
					System.out.println("Destructor tocado...");
				}
				else if (tableroInterno[x][y] == "F") {
					tableroJuego[x][y] = "X";
					System.out.println("Fragata tocada...");
				}
				else if (tableroInterno[x][y] == "S") {
					tableroJuego[x][y] = "X";
					System.out.println("Submarino tocado...");
				}
				else {
					tableroJuego[x][y] = "A";
					System.out.println("Agua...");
				}
			}
			tiradas++;
		}
		/* Pasos main:
		 * 	Setear tablero inicial interno
		 * 
		 * 	Mostrar mensaje de bienvenida al juego
		 * 	Pedir que inicie con tecla
		 * 	Mostrar tablero de juego inicial (vacio)
		 * 
		 * 	bucle (tiradas maximas > 0):
		 * 		msg tirada n: pedir x e y 
		 * 		validacion celda (ver si hay barco)
		 * 		mostrar resultado
		 * 		mostrar tiradas restantes
		 * 		evitar coordenadas repetidas (penalizar con una tirada menos) + msg incorrecto
		 * 		evitar entradas invalidas (penalizar con una tirada menos) + msg incorrecto
		 * 		tiradas == 0: mensaje de fin de juego mas resultado
		 * 		tirada--;
		 * */

	}

}
