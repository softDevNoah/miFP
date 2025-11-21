package ejercicios1y2_Arrays_Noah;

/**
 * Esta clase desarrolla el ejercicio 2. Se carga un array bidimensional de números enteros aleatorios entre el 1 y 100,
 * y muestra por pantalla dicho array, el resultado de sumar los números que se hayan en posiciones pares y el producto
 * de los números que están en las posiciones impares del array.
 */
public class EjecutarEjercicio2 {

	/**
	 * Este método contiene el flujo del ejercicio2, declara el array y las variables para las operaciones y llama a las otras funciones.
	 */
	public static void ejercicio2() {
		
		int numeros[] = new int[20];
		int suma;
		long producto;
		
		numeros = cargarTabla(numeros);
		suma = sumaPares(numeros);
		producto = prodImpares(numeros);
		
		imprimirDatos(numeros, suma, producto);
	}
	
	/**
	 * Función que genera de forma aleatoria un número entre el 1 y el 100.
	 * @return
	 */
	private static int generarNumero() {
		int numRandom;
		
		numRandom = (int)(Math.random() * 100) + 1; // (max - min + 1) - min
		
		return (numRandom);
	}
	
	/**
	 * Función que recibe un array de números, y carga números aleatorios llamando a la función generarNúmeros en dicho array. Finalmente lo devuelve.
	 * Si este array tuviera ya valores, esta función los sobrescribe.
	 * @param numeros - array de int de tamaño desconocido
	 * @return array recibido con números cargados en él
	 */
	private static int[] cargarTabla(int numeros[]) {
		
		for(int i = 0; i < numeros.length; i++)
			numeros[i] = generarNumero();
		
		return (numeros);
	}
	
	/**
	 * Esta función recibe un array de números enteros, y suma todos los que están en posiciones pares dentro de ese array. Se consideran las posiciones
	 * según funciona en programación, siendo 0 la primera posición y no 1.
	 * @param numeros - array de números enteros
	 * @return total - número entero que refleja el total de esta operación realizada
	 */
	private static int sumaPares(int numeros[]) {
		
		int total = 0;
		
		for (int i = 0; i < numeros.length; i+=2)
			total+= numeros[i];
	
		return (total);
	}
	
	/**
	 * Esta función recibe un array de números enteros, y multiplica todos los que están en posiciones impares dentro de ese array. Se consideran las posiciones
	 * según funciona en programación, siendo 0 la primera posición y no 1.
	 * @param numeros - array de números enteros
	 * @return producto - número entero que refleja el resultado de esta operación realizada
	 */
	private static long prodImpares(int numeros[]) {
		long producto = 1;
		
		for (int i = 1; i < numeros.length; i+=2)
			producto *= (long)numeros[i];
		
		return (producto);
	}
	
	/**
	 * Este método recibe un array de números enteros, el total de la suma de sus números en posiciones pares y el producto de los números en sus posiciones
	 * impares. Se consideran las posiciones según funciona en programación, siendo 0 la primera posición y no 1.
	 * Imprime el listado de números del array (completo), el listado de números en posiciones pares y su suma total, y por último el listado de números
	 * en posiciones impares y su producto.
	 * @param numeros - array de números enteros
	 * @param suma - número entero que refleja el total de la suma de sus números en posiciones pares
	 * @param producto - número entero que refleja el producto de los números en sus posiciones impares
	 */
	private static void imprimirDatos(int numeros[], int suma, long producto) {
		
		System.out.printf("\tLa lista completa de números es:\n\t\t%d", numeros[0]);
		for (int i = 1; i < numeros.length; i++)
			System.out.printf(", %d", numeros[i]);
		System.out.println(".\n");
		
		System.out.println("\t***Aviso: se está considerando posiciones conforme se usa en programación,\n\tpor tanto la primera posición es la posición 0 y no la 1... ***\n\n");
		
		System.out.println("\tLa suma de los números en posiciones pares es: ");
		
		System.out.printf("\t\t%d", numeros[0]);
		for (int i = 2; i < numeros.length; i += 2)
			System.out.printf(" + %d", numeros[i]);
		System.out.printf(" = %d.\n\n", suma);
		
		System.out.println("\tEl producto de los números en posiciones impares es: ");
		
		System.out.printf("\t\t%d", numeros[1]);
		for (int i = 3; i < numeros.length; i += 2)
			System.out.printf(" * %d", numeros[i]);
		System.out.printf(" = %d.\n\n", producto);
		
	}
}
