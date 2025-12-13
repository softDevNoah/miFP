package ejercicioUD6_2_Objetos_entrega3_Noah;

/**
 * Pequeña clase sin atributos que contiene dos pequeños métodos con las fórmulas
 * correspondientes para recibir un valor de temperatura y convertirlo a otro sistema
 * de medición de temepratura.
 */
public class Temperatura {

	/**
	 * Método que recibe la temperatura de grados celsius y la devuelve transofrmada a agrados fahrenheit.
	 * 
	 * @param celsius - decimal de grados que se desea convertir
	 * @return temperatura convertida a grados fahrenheit
	 */
	static double celsiusToFahrenheit(double celsius) {
		double fahrenheit;
		
		fahrenheit = ((celsius * 9) / 5) +32;
		
		return (fahrenheit);
	}
	
	/**
	 * Método que recibe la temperatura de grados celsius y la devuelve transofrmada a agrados fahrenheit.
	 * 
	 * @param fahrenheit - decimal de grados que se desea convertir
	 * @return temperatura convertida a grados celsius
	 */
	static double fahrenheitToCelsius(double fahrenheit) {
		double celsius;
		
		celsius = ((fahrenheit -32) * 5) / 9;
		
		return (celsius);
	}
	
}
