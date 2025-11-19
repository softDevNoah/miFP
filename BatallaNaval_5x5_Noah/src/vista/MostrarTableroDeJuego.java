package vista;

public class MostrarTableroDeJuego {

	public static void tirada(String tableroJuego[][]) {
		
		System.out.println("    0   1   2   3   4   ");
		System.out.println("   ---------------------");
		
		for (int filas = 0; filas < tableroJuego.length; filas++) {
			
			System.out.printf(" %d |", filas);
			for (int columnas = 0; columnas < tableroJuego[0].length; columnas++) {
				System.out.printf(" %s |", tableroJuego[filas][columnas]);
			}
			System.out.println("\n   ---------------------");
		}
	}
}
