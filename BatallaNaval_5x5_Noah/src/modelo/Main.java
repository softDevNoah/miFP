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
	public static String tableroJuego[][] = { {" ", " ", " ", " ", " "}, {" ", " ", " ", " ", " "}, {" ", " ", " ", " ", " "}, {" ", " ", " ", " ", " "}, {" ", " ", " ", " ", " "}};;
	
	public static void main(String[] args) {
		
		boolean haTerminado;
		int		tamañoDestructor = 3, tamañoFragata = 2, tamañoSubmarino = 2;
				
		do {
			int	tocadoDestructor = 0, tocadaFragata = 0, tocadoSubmarino = 0;
			int	fragHundidas = 0, submaHundidos = 0;
			
			haTerminado = false;
			tiradas = 0;
			
			for (int filas = 0; filas < tableroJuego.length; filas++) {
				for (int columnas = 0; columnas < tableroJuego[0].length; columnas++) {
					tableroJuego[filas][columnas] = " ";
				}
			}
			System.out.println("---------------------------------------------------------------------------------------------------------");
			System.out.println("\n\t¡Bienvenidx a Batalla Naval! Para comenzar el juego pulse Enter, por favor.");
			teclado.nextLine();
			System.out.println("\tSi ya habías jugado y DESEAS SALIR introduce \"1\"... \n\n\t--->Para jugar, cualquier otra cosa.");
			entrada = teclado.nextLine();
			if (!entrada.trim().equals("1")) {
				while((maxTiradas - tiradas) > 0) {
					
					x = -1;
					y = -1;
					
					System.out.println();
					MostrarTableroDeJuego.tirada(tableroJuego);
					
					System.out.printf("\n\n------->>> Tiradas restantes %d:\n\tInserte coordenada x: ", maxTiradas - tiradas);
					entrada = teclado.nextLine();
					if (ValidarEntrada.limitesOk(entrada) && ValidarEntrada.esNum(entrada)) {
						
						x = Integer.parseInt(entrada);
						
						System.out.print("\n\tInserte coordenada y: ");
						entrada = teclado.nextLine();
						
						if (ValidarEntrada.limitesOk(entrada) && ValidarEntrada.esNum(entrada)) {
							y = Integer.parseInt(entrada);
						}
					}
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					if (x < 1 || x > 5 || y < 1 || y > 5 )
						System.out.println("\n\t---->>> Coordenadas incorrectas, se penalizará una tirada...");
					else {
						x--;
						y--;
						if (tableroInterno[x][y] == "D") {
							if (tableroJuego[x][y] != "X") {
								tableroJuego[x][y] = "X";
								tocadoDestructor++;
								if (tocadoDestructor == tamañoDestructor)
									System.out.println("\n-------------------------- ¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡DESTRUCTOR HUNDIDO!!!!!!!!!!!!!!! --------------------------\n");
								else
									System.out.println("\n---->>> Destructor tocado... \n");
							}
							else
								System.out.println("\n---->>> Tirada repetida... se penalizará una tirada...");
						}
						else if (tableroInterno[x][y] == "F") {
							if (tableroJuego[x][y] != "X") {
								tableroJuego[x][y] = "X";
								tocadaFragata++;
								if (tocadaFragata == tamañoFragata) {
									System.out.println("\n-------------------------- ¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡FRAGATA HUNDIDA!!!!!!!!!!!!!!!--------------------------\n");
									tocadaFragata = 0;
									fragHundidas++;
								}
								else
									System.out.println("\n---->>> Fragata tocada... \n");
								
	
							}
							else
								System.out.println("\n---->>> Tirada repetida... se penalizará una tirada...");
						}
						else if (tableroInterno[x][y] == "S") {
							if (tableroJuego[x][y] != "X") {
								tableroJuego[x][y] = "X";
								tocadoSubmarino++;
								if (tocadoSubmarino == tamañoSubmarino) {
									System.out.println("\n-------------------------- ¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡SUBMARINO HUNDIDO!!!!!!!!!!!!!!! --------------------------\n");
									tocadoSubmarino = 0;
									submaHundidos++;
								}
								else
									System.out.println("\n---->>> Submarino tocado... \n");
	
							}
							else
								System.out.println("\n---->>> Tirada repetida... se penalizará una tirada...");
						}
						else {
							if (tableroJuego[x][y] != "A") {
								tableroJuego[x][y] = "A";
								System.out.println("\n---->>> Agua...");
							}
							else
								System.out.println("\n---->>> Tirada repetida... se penalizará una tirada...");
						}	
					}
					tiradas++;
					
					if (tocadoDestructor == 3 && fragHundidas == 2 && submaHundidos == 2)
					{
						System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
						System.out.println("+                                                                                                         +");
						System.out.println("+                                   ¡¡¡HA GANADO EL JUEGO!!!                                              +");
						System.out.println("+                                                                                                         +");
						System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
						tiradas = 16;
	
					}
					
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				if (tiradas > 15) {
					System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
					System.out.println("+                                                                                                         +");
					System.out.println("+                                     ¡¡¡HAS PERDIDO, CATETOO!!!                                          +");
					System.out.println("+                                                                                                         +");
					System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
					System.out.println("\n\n\n\n\n\n\n");
					
					haTerminado = true;
				
				}
			}
		} while (haTerminado);
		System.out.println("\n\n\n\n\n\n\n");
		System.out.println("Saliendo...");
	}
		

}
