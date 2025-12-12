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
	
		static String	nombre, sexo;
		static int		edad;
		static double	peso, altura;
		
		Persona caso1 = null;
		Persona caso2 = null;
		Persona caso3 = null;
		Persona personas[] = {caso1, caso2, caso3};
		
		AuxMetods.pintarLinea("~", 71);
		
		nombre = pedirString("el nombre");
		edad = pedirEntero("la edad");
		sexo = pedirString("el sexo (H/M)");
		peso = pedirDecimal("el peso");
		altura = pedirDecimal("la altura");
		
		/* Se pide crear tres objetos y al objeto 1 se pide un constructor que no existe, porque
		 * de los constructores que se han pedido, ninguno coincide...
		 * Así que elijo el completo para poder usarlo.*/
		caso1 = new Persona(nombre, edad, "dniVacio",  sexo.charAt(0), peso, altura);
		
		caso1.generaDNI();
		
		AuxMetods.pintarLinea("~", 71);
		
		nombre = pedirString("el nombre");
		edad = pedirEntero("la edad");
		sexo = pedirString("el sexo (H/M)");
		
		caso2 = new Persona(nombre, edad, sexo.charAt(0));
		
		caso2.generaDNI();
		caso2.setPeso(pedirDecimal("el peso"));
		caso2.setAltura(pedirDecimal("la altura"));
		
		AuxMetods.pintarLinea("~", 71);
		
		caso3 = new Persona();
		
		nombre = pedirString("el nombre");
		edad = pedirEntero("la edad");
		sexo = pedirString("el sexo (H/M)");
		peso = pedirDecimal("el peso");
		altura = pedirDecimal("la altura");
		
		
		caso3.setNombre(nombre);
		caso3.setEdad(edad);
		caso3.setSexo(sexo.charAt(0));
		caso3.setPeso(peso);
		caso3.setAltura(altura);
		caso3.generaDNI();
		
		AuxMetods.pintarLinea("~", 71);
		
		mostrarDatos(personas);
		
		
		
	}

	private static void pedirDatos(int caso) {
		
		switch (caso) { 
		case 1:
			
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		}
	}
	
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
			//imprimirDatos(personas[i])
			System.out.printf("\n\t- %s tiene %d años, sexo %c, DNI %s, pesa %2.f kg y mide %2.f m.\n", nombre, 
								edad, sexo, dni, peso, altura);
		}
	}
	
	private static String pedirString(String dato) {
		
		boolean esCorrecto = false;
		String	valor = "";
		do {
			esCorrecto = false;
			
			System.out.printf("\n\t- Por favor, ingresa %s de la persona: ", dato);
			entrada = teclado.nextLine().trim();
			if (!entrada.isBlank())
				esCorrecto = true;
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
