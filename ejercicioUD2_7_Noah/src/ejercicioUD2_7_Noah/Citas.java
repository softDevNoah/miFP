package ejercicioUD2_7_Noah;


import java.util.Scanner;

/*Entrega del ejercicio 2.7 - Citas*/

/*Enunciado:
 * EJECUCIÓN 1
	Inserta el TIS
		78956
	Inserta el primer apellido
		alzola
	Inserta la fecha
		03-05-1990
	Elige servicio:
		1-Anula una cita
		2-Concierta una cita
			2
	Elige servicio:
		1-Cita con enfermero/a
		2-Cita con medico
		3-Volver al inicio
			2
	Indica tipo de contacto
		1-Presencial
		2-Telefono
		3-Volver al inicio
			1
	Ha concertado usted una cita con su medico de manera presencial con los datos:
		TIS: 78956
		Apellido: alzola
		Año de nacimiento 03-05-1990

EJECUCIÓN 2
	Inserta el TIS 78945
	Inserta el primer apellido ETXEBARRIA
	Inserta la fecha 03-08-2023
	Elige servicio
		1-Anula una cita
		2-Concierta una cita
			1
	Inserta el numero de cita
		789
	Cita con numero 789 anulada

Se han de validar todos los menus y el número de TIS (número)*/

public class Citas {

	private static Scanner	teclado = new Scanner(System.in);
	private static String	entrada;
	private static long		tis;
	
	public static void main(String[] args) {
		
		String	cadenaTis;
		String	apellido;
		String	nacim;
		int		selec;
		boolean	volver = true;
		
		
		while (volver == true) { //usando una variable boolean puedo volver o no al inicio cuando se precise
			
			do {
				System.out.println("Inserta el TIS:");
				entrada = teclado.nextLine();
				cadenaTis = entrada.trim();
				System.out.println(cadenaTis);
				
			} while (validacion(cadenaTis) < 0);
			
			do {
				System.out.println("Inserta el primer apellido:");
				apellido = teclado.nextLine();
				
			} while (apellido.length() <= 0);
			
			do {
				System.out.println("Inserta la fecha:");
				nacim = teclado.nextLine();
				
			} while (nacim.length() != 10);
			
			do { 
				System.out.println("Elige servicio:");
				System.out.println("1.- Anula una cita.");
				System.out.println("2.- Concierta una cita.");
				entrada = teclado.nextLine();
				selec = Integer.parseInt(entrada);
				
			} while (selec != 1 && selec != 2);
			
			if (selec == 1)
				volver = anularCita();
			else
				volver = concertarCita(tis, apellido, nacim);
		}
	}

	private static boolean anularCita() {
		
		int	numCita;
		do {
			System.out.println("Inserta el número de la cita:");
			entrada = teclado.nextLine();
			numCita = Integer.parseInt(entrada);
		} while (numCita <= 0);
		
		System.out.println("Cita con el número " + numCita + " anulada.");
		return (false);
	}
	
	private static boolean concertarCita(long tis, String apellido, String nacim) {
		
		int	selec;
		int	servic;
		
		do {
			System.out.println("Elige servicio:");
			System.out.println("1.- Cita con enfermero/a ");
			System.out.println("2.- Cita con médico");
			System.out.println("3.- Volver al inicio");
			entrada = teclado.nextLine();
			selec = Integer.parseInt(entrada);
		} while (selec < 0 || selec > 3);
		
		if (selec == 3)
			return (true);
		
		do {
			System.out.println("Indica tipo de contacto:");
			System.out.println("1.- Presencial");
			System.out.println("2.- Teléfono");
			System.out.println("3.- Volver al inicio");
			entrada = teclado.nextLine();
			servic = Integer.parseInt(entrada);
		} while (selec < 0 || selec > 3);
		
		if (servic == 3)
			return (true);
		
		System.out.print("Ha concertado usted una cita con su ");
		if (selec == 1)
			System.out.print("enfermero/a ");
		else
			System.out.print("médico ");
		System.out.print("de manera ");
		if (servic == 1)
			System.out.println("presencial con los datos:");
		else
			System.out.println("telefónica con los datos:");
		System.out.println("TIS: " + tis + "\nApellido: " + apellido + "\nAño de nacimiento: " + nacim);
		return (false);
	}
	
	private static long validacion(String cadenaTis) {
		
		if (checkOnlyNums(cadenaTis) == false)
			return (-1);
		tis = Long.parseLong(cadenaTis);
		
		if (tis < 0)
			return (-1);
		
		if (algoLuhn(tis) == false)
			return (-1);
		
		return (tis);
	}
	
//para detectar si contiene algo diferente a un digito del 0 al 9
	private static boolean checkOnlyNums(String cadena) {
		
		
		for (int i = 0; i < cadena.length(); i++) {
			
			char c = cadena.charAt(i);

			if (!Character.isDigit(c)) {
				System.out.println("Solo se permite números para el TIS.");
				return (false);
			}
		}
		return (true);
	}

	private static boolean algoLuhn(long tis) {
		
		boolean valido = true;
		
		
		return (valido);
	}
	
}
