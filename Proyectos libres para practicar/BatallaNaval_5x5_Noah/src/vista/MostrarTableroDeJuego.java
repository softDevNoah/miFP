package vista;

public class MostrarTableroDeJuego {

	public static void tirada(String tableroJuego[][]) {
		
		System.out.println("\n------------------------------------- Tablero Actual -------------------------------------\n");
		
		System.out.println("\t\t\t\t    1   2   3   4   5   ");
		System.out.println("\t\t\t\t   ---------------------");
		
		for (int filas = 0; filas < tableroJuego.length; filas++) {
			
			System.out.printf("\t\t\t\t %d |", filas + 1);
			for (int columnas = 0; columnas < tableroJuego[0].length; columnas++) {
				System.out.printf(" %s |", tableroJuego[filas][columnas]);
			}
			System.out.println("\n\t\t\t\t   ---------------------");
		}
	}
}
