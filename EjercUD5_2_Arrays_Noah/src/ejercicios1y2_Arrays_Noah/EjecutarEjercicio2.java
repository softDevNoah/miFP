package ejercicios1y2_Arrays_Noah;

public class EjecutarEjercicio2 {

	public static void ejercicio2() {
		
		int numeros[] = new int[20];
		int suma;
		long producto;
		
		numeros = cargarTabla(numeros);
		suma = sumaPares(numeros);
		producto = prodImpares(numeros);
		
		imprimirDatos(numeros, suma, producto);
		
	}
	
	private static int generarNumero() {
		int numRandom;
		
		numRandom = (int)(Math.random() * 100) + 1; // (max - min + 1) - min
		
		return (numRandom);
	}
	
	private static int[] cargarTabla(int numeros[]) {
		
		for(int i = 0; i < numeros.length; i++)
			numeros[i] = generarNumero();
		
		return (numeros);
	}
	
	private static int sumaPares(int numeros[]) {
		
		int total = 0;
		
		for (int i = 0; i < numeros.length; i+=2)
			total+= numeros[i];
	
		return (total);
	}
	
	private static long prodImpares(int numeros[]) {
		long producto = 1;
		
		for (int i = 1; i < numeros.length; i+=2)
			producto *= (long)numeros[i];
		
		return (producto);
	}
	
	
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
