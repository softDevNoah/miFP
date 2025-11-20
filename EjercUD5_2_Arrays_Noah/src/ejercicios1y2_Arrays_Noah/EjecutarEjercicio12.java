package ejercicios1y2_Arrays_Noah;

public class EjecutarEjercicio12 {

	public static void	ejercicio1() {
		
		int	edades[];
		
		Main12.num = MetodAux.menuOpciones("¿Desea introducir las edades manualmente?", null, "Indique su respuesta");
		
		if (Main12.num == 0)
			edades = recoge20Edades();
		else 
			edades = inventa20Edades();
		
		imprimirEdad(edades);
	}

	private static int[] inventa20Edades() {
		
		int	edades[] = new int[20];
		
		System.out.println("\n\n\t- Se procede a generar aleatoriamente las edades de 20 estudiantes ficticios:\n\n");
		for (int i = 0; i < edades.length; i++) {
			edades[i] = (int)Math.floor(Math.random() * (100 - 65) + 18);
		}
		return (edades);
	}
	
	private static int	leerEdad() {
		
		int		edad = -1;
		boolean	edadValida;
		
		do {
			edadValida = false;
			
			System.out.println("\t- Introduzca la edad:");
			Main12.entrada = Main12.teclado.nextLine().trim();
			
			if (MetodAux.checkSoloNumeroPositivoEntero()) {
				
				edad = Integer.parseInt(Main12.entrada);
			
				if (edad < 18 || edad > 35) {
					System.out.println("Error: los estudiantes de este curso solo pueden tener entre 18 y 35 años.");
					System.out.println("Vuelva a intentarlo.");
				}
				else
					edadValida = true;
			}
			
		} while (!edadValida);
		return (edad);
	}
	
	private static int[] recoge20Edades() {
		int	edades[] = new int[20];
		
		for (int i = 0; i < edades.length; i++) {
			System.out.printf("\t¿Cuál es la edad del estudiante nº %d?\n", i + 1);
			edades[i] = leerEdad();
		}
		
		return (edades);
	}

	private static void imprimirEdad(int edades[]) {
		
		int	media;
		
		for (int i = 0; i < edades.length; i++) {
			System.out.printf("\t- Edad del estudiante nº %d: %d años.\n\n", i, edades[i]);
		}
		
		media = MetodAux.calcularMedia(edades);
		
		System.out.printf("\t- La media de edad de tus 20 estudiantes es: %d años\n\n", media);
		
	}
}
