package ejercicioUD6_2_Objetos_entrega2_Noah;

import java.util.Scanner;

/**
 * 
 */
public class MainObjetos2 {

	
	static Scanner	teclado = new Scanner(System.in);
	static String	entrada = "";
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
	
		String	nombre, sexo;
		int		edad, imc;
		double	peso, altura;
		
		Persona personas[] = new Persona[3];
		
		AuxMetods.pintarLinea("~", 71);
		System.out.println();
		
		nombre = pedirString("el nombre");
		edad = pedirEntero("la edad");
		sexo = pedirString("el sexo (H/M)");
		peso = pedirDecimal("el peso");
		altura = pedirDecimal("la altura");
		
		/* Se pide crear tres objetos y al objeto 1 se pide un constructor que no existe, porque
		 * de los constructores que se han pedido, ninguno coincide...
		 * Así que elijo el completo para poder usarlo.*/
		personas[0] = new Persona(nombre, edad, "dniVacio",  sexo.charAt(0), peso, altura);
		personas[0].generaDNI();
		
		System.out.println();
		AuxMetods.pintarLinea("~", 71);
		System.out.println();
		
		nombre = pedirString("el nombre");
		edad = pedirEntero("la edad");
		sexo = pedirString("el sexo (H/M)");
		
		personas[1] = new Persona(nombre, edad, sexo.charAt(0));
		personas[1].generaDNI();
		personas[1].setPeso(pedirDecimal("el peso"));
		personas[1].setAltura(pedirDecimal("la altura"));
		
		System.out.println();
		AuxMetods.pintarLinea("~", 71);
		System.out.println();
		
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
		
		System.out.println();
		AuxMetods.pintarLinea("~", 71);
		System.out.println();
		
		
		for (int i = 0; i < personas.length; i++) {
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
			//imprimirDatos(personas[i])
		}
		
		
	}

	private static String pedirString(String dato) {
		
		boolean esCorrecto = false;
		String	valor = "";
		do {
			esCorrecto = false;
			
			System.out.printf("\n\t- Por favor, ingresa %s de la persona: ", dato);
			entrada = teclado.nextLine().trim();
			if (entrada.isBlank())
				esCorrecto = false;
		} while (!esCorrecto);
		
		return (valor);
	}
	
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
