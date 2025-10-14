package EjercUD5_2_Arrays_Noah;

public class Ejercicio1 {

	public static void	ejercicio1() {
		
		int	edades[] = new int[20];
		
		System.out.println("¿Desea introducir manualmente las edades de sus 20 estudiantes?");
		
		if (MetodAux.decideSioNo())
			edades = recoge20Edades();
		else
			edades = inventa20Edades();
		
		imprimirEdad(edades);
	}

	private static int[] inventa20Edades() {
		
		int	edades[] = new int[20];
		
		System.out.println("Se procede a generar aleatoriamente las edades de 20 estudiantes ficticios:");
		for (int i = 0; i < edades.length; i++) {
			edades[i] = (int)Math.floor(Math.random() * (100 - 65) + 18);
		}
		return (edades);
	}
	
	private static int	leerEdad() {
		
		int		edad;
		boolean	edadValida;
		
		do {
			System.out.println("Introduzca la edad:");
			edad = MetodAux.checkNumPositivo();
			edadValida = true;
			if (edad < 18 || edad > 35) {
				System.out.println("Error: los estudiantes de este curso solo pueden tener entre 18 y 35 años.");
				System.out.println("Vuelva a intentarlo.");
				edadValida = false;
			}
		} while (!edadValida);
		return (edad);
	}
	
	private static int[] recoge20Edades() {
		int	edades[] = new int[20];
		
		for (int i = 0; i < edades.length; i++) {
			System.out.printf("¿Cuál es la edad del estudiante nº %i?", edades[i]);
			edades[i] = leerEdad();
		}
		
		return (edades);
	}

	private static void imprimirEdad(int edades[]) {
		
		int	media;
		
		for (int i = 0; i < edades.length; i++) {
			System.out.printf("El/la alumno/a nº %i de la lista tiene %d años.\n", i, edades[i]);
		}
		
		media = MetodAux.calcularMedia(edades);
		
		System.out.printf("La media de edad de tus 20 estudiantes es: %i", media);
	}
}
