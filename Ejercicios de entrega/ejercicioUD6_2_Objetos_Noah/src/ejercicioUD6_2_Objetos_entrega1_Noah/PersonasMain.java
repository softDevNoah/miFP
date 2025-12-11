package ejercicioUD6_2_Objetos_entrega1_Noah;

import java.util.Scanner;

/**
 * Esta sencilla clase contiene un programa sin validaciones (se asume que los datos 
 * introducidos son correctos, del tipo adecuado) que crea dos objetos de clase Persona con
 * los datos necesarios introducidos por teclado por el usuario.
 * Luego calculará cuál de esas dos personas es mayor, lo muestra por pantalla y se termina.
 */
public class PersonasMain {

	/**
	 * Método main con el funcionamiento del pequeño programa. Crea dos objetos, le asigna
	 * valores pedidos por teclado al usuario, opera con ellos, los muestra y se termina.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner	teclado = new Scanner(System.in);
		String	entrada;
		Persona	personas[] = new Persona[2];
		
		String	nombre,	apellido, numeroDocumentoIdentidad;
		int		edad, idxMayor = -1;
		boolean	casado;
		
		for ( int i = 0; i < 2; i++) {
				
			AuxMetods.pintarLinea("~", 71);
			
			System.out.print("\tPor favor inserta el nombre de la perspona: ");
			nombre = teclado.nextLine();
			System.out.print("\tPor favor inserta el apellido de la persona: ");
			apellido = teclado.nextLine();
			
			System.out.print("\tPor favor inserta la edad de la persona: ");
			entrada = teclado.nextLine();
			edad= Integer.parseInt(entrada);
			System.out.print("\tPor favor inserta el estado civil de la perspona (C/S): ");
			entrada = teclado.nextLine();
			
			if (entrada.equals("C"))
				casado = true;
			else
				casado = false;
			
			System.out.print("\tPor favor inserta el nº del DNI de la persona: ");
			numeroDocumentoIdentidad = teclado.nextLine();

			personas[i] = new Persona(nombre, apellido, edad, casado, numeroDocumentoIdentidad);
		}
		AuxMetods.pintarLinea("~", 71);
		
		if (personas[0].getEdad() > personas[1].getEdad())
			idxMayor = 0;
		else if (personas[0].getEdad() < personas[1].getEdad())
			idxMayor = 1;
		if (idxMayor == -1) {
			System.out.println("Tienen la misma edad, se procede a elegir a la primera persona para mostrar los datos:");
			idxMayor = 0;
		}
		System.out.println("Los datos de la persona mayor de las dos son:");
		System.out.printf("- Nombre = %s.\n", personas[idxMayor].getNombre());
		System.out.printf("- Apellido = %s.\n", personas[idxMayor].getApellido());
		System.out.printf("- Edad = %d.\n", personas[idxMayor].getEdad());
		if (personas[idxMayor].getCasado())
			System.out.print("- Estado civil = Casado/a.\n");
		else
			System.out.print("- Estado civil = Soltero/a.\n");
		System.out.printf("- Nº del documento de identidad = %s.\n", personas[idxMayor].getNumeroDocumentoIdentidad());
		
		AuxMetods.pintarLinea("~", 71);
		teclado.close();

	}

}
