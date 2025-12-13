package ejercicioUD6_2_Objetos_entrega2_Noah;

import java.util.Scanner;

/**
 * Esta es la clase ejecutable para probar a crear 3 objetos Persona usando los tres constructores disponibles
 * de esa clase. Se piden los datos por teclado y se muestran por pantalla.
 */
public class MainObjetos2 {

	static Scanner	teclado = new Scanner(System.in);
	static String	entrada = "";
		
	/**
	 * Método main con el proceso lógico del programa. Se piden los datos para cargar los objetos, y se muestra la 
	 * información por pantalla.
	 * @param args
	 */
	public static void main(String[] args) {
	
		Persona personas[];
		
		AuxMetods.pintarLinea("~", 71);
		personas = crear3Personas();		
		AuxMetods.pintarLinea("~", 71);	
		mostrarDatos(personas);
	}

	/**
	 * Este método se usa para crear tres objetos Persona. Pide los datos necesarios para cada caso, y usa el constructor
	 * más adecuado.
	 * @return personas - array de los 3 objetos con los datos ya cargados
	 */
	private static Persona[] crear3Personas() {
		
		String	nombre, sexo;
		int		edad;
		double	peso, altura;
		
		Persona personas[] = new Persona[3];
		
		nombre = pedirString("el nombre");
		edad = pedirEntero("la edad");
		sexo = pedirString("el sexo (H/M)");
		peso = pedirDecimal("el peso");
		altura = pedirDecimal("la altura");
		
	
		/* Se pide crear tres objetos y al objeto 1 se pide un constructor que no existe, porque
		 * de los constructores que se han pedido, ninguno coincide...
		 * Así que elijo el constructor más completo para poder usarlo.*/
		
		//objeto 1, constructor completo:
		personas[0] = new Persona(nombre, edad, "dniVacio",  sexo.charAt(0), peso, altura);
		personas[0].comprobarSexo(sexo.charAt(0));
		personas[0].generaDNI();

		AuxMetods.pintarLinea("~", 71);
		
		//objeto 2, constructor parcial:
		nombre = pedirString("el nombre");
		edad = pedirEntero("la edad");
		sexo = pedirString("el sexo (H/M)");
		
		personas[1] = new Persona(nombre, edad, sexo.charAt(0));
		
		personas[1].comprobarSexo(sexo.charAt(0));
		personas[1].generaDNI();
		personas[1].setPeso(pedirDecimal("el peso"));
		personas[1].setAltura(pedirDecimal("la altura"));

		AuxMetods.pintarLinea("~", 71);
		
		//objeto 3, constructor vacío:
		personas[2] = new Persona();
		
		nombre = pedirString("el nombre");
		edad = pedirEntero("la edad");
		sexo = pedirString("el sexo (H/M)");
		peso = pedirDecimal("el peso");
		altura = pedirDecimal("la altura");

		personas[2].setNombre(nombre);
		personas[2].setEdad(edad);
		personas[2].setSexo(sexo.charAt(0));
		personas[2].setPeso(peso);
		personas[2].setAltura(altura);
		personas[2].generaDNI();

		AuxMetods.pintarLinea("~", 71);
		
		return (personas);
	}
	
	/**
	 * Método que se encarga de imprimir los datos de un array de objetos Persona de tamaño indeterminado.
	 * @param personas
	 */
	private static void mostrarDatos(Persona personas[]) {
		
		String	nombre, sexo, dni;
		int		edad;
		double	peso, altura;

		for (int i = 0; i < personas.length; i++) {
			
			nombre = personas[i].getNombre();
			edad = personas[i].getEdad();
			sexo = Character.toString(personas[i].getSexo());
			peso =  personas[i].getPeso();
			altura =  personas[i].getAltura();
			dni = personas[i].getDNI();
			
			
			if (personas[i].calcularIMC() < 0)
				System.out.printf("- El IMC de %s está por debajo del umbral saludable.\n", personas[i].getNombre());
			if (personas[i].calcularIMC() > 0)
				System.out.printf("- El IMC de %s está por encima del umbral saludable.\n", personas[i].getNombre());
			else
				System.out.printf("- El IMC de %s está dentro del umbral saludable.\n", personas[i].getNombre());
			if (personas[i].esMayorDeEdad())
				System.out.printf("- %s es mayor de edad.\n", personas[i].getNombre());
			else
				System.out.printf("- %s es menor de edad.\n", personas[i].getNombre());

			System.out.printf("- %s tiene %d años, sexo %s, DNI %s, pesa %.2f kg y mide %.2f m.\n\n", nombre, 
								edad, sexo, dni, peso, altura);
		}
	}
	
	/**
	 * Este método sirve para pedir por teclado un String, en este caso se especifica qué tipo de información
	 * se pide gracias al String que se recibe por parámetro, y los datos introducidos se revisa que no sen
	 * una cadena vacía.
	 * @param dato - tipo de dato que se desea que se introduzca
	 * @return valor - el String con el dato obtenido
	 */
	private static String pedirString(String dato) {
		
		boolean esCorrecto = false;
		String	valor = "";
		do {
			esCorrecto = false;
			
			System.out.printf("\n\t- Por favor, ingresa %s de la persona: ", dato);
			entrada = teclado.nextLine().trim();
			if (!entrada.isBlank()) {
				esCorrecto = true;
				valor = entrada;
			}
		} while (!esCorrecto);
		
		return (valor);
	}
	
	/**
	 * Este método sirve para pedir por teclado un número entero, en este caso se especifica qué tipo de información
	 * se pide gracias al String que se recibe por parámetro, y los datos introducidos se revisa que no sen
	 * una cadena vacía y que efectivamente es un número entero.
	 * @param dato - tipo de dato que se desea que se introduzca
	 * @return valor - el int obtenido
	 */
	private static int pedirEntero(String dato) {
		
		boolean esCorrecto = false;
		int valor = 0;
		
		do {
			esCorrecto = false;
		
			System.out.printf("\n\t- Por favor, ingresa %s de la persona: ", dato);
			entrada = teclado.nextLine().trim();
			if (!entrada.isBlank() && AuxMetods.checkSoloNumeroPositivoEntero(entrada)) {
				esCorrecto = true;
				valor = Integer.parseInt(entrada);
			}
		} while (!esCorrecto);
		
		return (valor);
		
	}
	
	/**
	 * Este método sirve para pedir por teclado un número decimal, en este caso se especifica qué tipo de información
	 * se pide gracias al String que se recibe por parámetro, y los datos introducidos se revisa que no sen
	 * una cadena vacía y que efectivamente es un número decimal correcto.
	 * @param dato - tipo de dato que se desea que se introduzca
	 * @return valor - el decimal obtenido
	 */
	private static double pedirDecimal(String dato) {
		
		boolean esCorrecto = false;
		double	valor = 0;
		
		do {
			esCorrecto = false;
		
			System.out.printf("\n\t- Por favor, ingresa %s de la persona: ", dato);
			entrada = teclado.nextLine();
			
			if (!entrada.isBlank() && AuxMetods.checkSoloNumeroDecimal(entrada)) {
				esCorrecto = true;
				valor = Double.parseDouble(entrada);
			}
		} while (!esCorrecto);
		
		return (valor);
	}

}
