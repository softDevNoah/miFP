package ejercicios1y2_Arrays_Noah;

public class EjecutarEjercicio2 {

	public static void ejercicio2() {
		
		int numeros[] = new int[20];
		int suma, producto;
		
		numeros = cargarTabla(numeros);
		suma = sumaPares(numeros);
		producto = prodImpares(numeros);
		
		imprimirDatos(numeros, suma, producto);
		
	}
	
	private static int generarNumero() {
		int numRandom;
		
		numRandom = (int)Math.floor(Math.random() * (101 - 99) + 1);
		
		return (numRandom);
	}
	
	private static int[] cargarTabla(int numeros[]) {
		
		for(int i = 0; i < numeros.length; i++)
			numeros[i] = generarNumero();
		
		return (numeros);
	}
	
	private static int sumaPares(int numeros[]) {
		
		int total = 0;
		
		for (int i = 0; i < numeros.length; i++)
			total+= numeros[i];
	
		return (total);
	}
	
	private static int prodImpares(int numeros[]) {
		int producto = 0;
		
		for (int i = 0; i < numeros.length; i++)
			producto += numeros[i];
		
		return (producto);
	}
	
	
	private static void imprimirDatos(int numeros[], int suma, int producto) {
		
		System.out.printf("La lista completa de números es: %d", numeros[0]);
		for (int i = 1; i < numeros.length; i++)
			System.out.printf(", %d", numeros[i]);
		System.out.println(".");
		
		System.out.println("La suma de los números en posiciones pares es: ");
		
		System.out.printf("%d", numeros[0]);
		for (int i = 2; i < numeros.length; i += 2)
			System.out.printf(" + %d", numeros[i]);
		System.out.printf("= %d.\n", suma);
		
		System.out.println("El producto de los números en posiciones impares es: ");
		
		System.out.printf("%d", numeros[0]);
		for (int i = 1; i < numeros.length; i += 2)
			System.out.printf(" * %d", numeros[i]);
		System.out.printf("= %d.\n", suma);
		
	}
}
