package ejercicioUD6_2_Objetos_entrega3_Noah;

import java.util.Scanner;

/**
 * Clase ejecutable para probar a pedir una temperatura, pedir al usuario que seleccione la conversion deseada
 * y mostrar el resultado.
 */
public class MainObjetos3 {

	public static String entrada = "";
	public static Scanner teclado = new Scanner(System.in);
	
	/**
	 * Se recoge una temperatura, se ofrece las dos conversiones posibles, se recoge y se ejecuta, mostrando el resultado.
	 * @param args
	 */
	public static void main(String[] args) {
		
		String	conversiones[] = {"Transformas de grados Celsius a grados Fahrenheit", "Transformas de grados Fahrenheit a grados Celsius"};
		int		opcion;
		double	temperatura, tmp;
		
		temperatura = pedirTemperatura();
		tmp = temperatura;
		
		opcion = AuxMetods.menuOpciones("Conversiones disponibles", conversiones, "Introduzca su elección");
		
		if (opcion == 0) {
			temperatura = Temperatura.celsiusToFahrenheit(temperatura);
			System.out.printf("- Temperatura original: %.2f ºC.\n- Temperatura actualizada: %.2f ºF.", tmp, temperatura);
		}
		else {
			temperatura = Temperatura.fahrenheitToCelsius(temperatura);
			System.out.printf("- Temperatura original: %.2f ºF.\n- Temperatura actualizada: %.2f ºC.", tmp, temperatura);
		}
	}


	/**
	 * Este método sirve para pedir por teclado un número decimal (la temperatura), y los datos introducidos se revisa que no sen
	 * una cadena vacía y que efectivamente es un número decimal correcto.
	 *
	 * @return valor - el decimal obtenido
	 */
	private static double pedirTemperatura() {
		
		boolean esCorrecto = false;
		double	valor = 0;
		
		do {
			esCorrecto = false;
		
			System.out.print("\n\t- Por favor, ingresa la temperatura: ");
			entrada = teclado.nextLine().trim();
			
			if (!entrada.isBlank() && AuxMetods.checkSoloNumeroDecimal(entrada)) {
				esCorrecto = true;
				valor = Double.parseDouble(entrada);
			}
		} while (!esCorrecto);
		
		return (valor);
	}

}
