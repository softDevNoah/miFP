package modelo;

import java.io.*;

/**
 * 
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		File fichero = new File("prueva.cfg");
		
		if (fichero.exists()) {
			
			FileReader reader = new FileReader(fichero);
			FileWriter writer = new FileWriter(reader);
			
		}

		
	}

}
