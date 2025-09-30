package ejercicioUD2_7_Noah;


import	java.util.Scanner;

//estas librerías son para validar mas facilmente las fechas
import	java.time.*;
import 	java.time.format.DateTimeFormatter;
import 	java.time.format.DateTimeParseException;

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
	private static long		tis;	//como son 12 digitos debe ser long
	
	public static void main(String[] args) {
		
		String	cadenaTis;
		String	apellido;
		String	nacim;
		int		selec;
		boolean	volver = true;
		
		
		while (volver) { //usando una variable boolean puedo volver o no al inicio cuando se precise
			
			do {
				System.out.println("Inserta el TIS:");
				entrada = teclado.nextLine();
				cadenaTis = entrada.trim();	
			} while (validacionTis(cadenaTis) < 0);
			
			do {
				System.out.println("Inserta el primer apellido:");
				entrada = teclado.nextLine();
				apellido = entrada.trim();
			} while (!validacionApellido(apellido));
			
			do {
				System.out.println("Inserta la fecha (dd/mm/aaaa o dd-mm-aaaa):");
				entrada = teclado.nextLine();
				nacim = entrada.trim();
			} while (!validacionFecha(nacim));
			
			do { 
				System.out.println("Elige servicio:");
				System.out.println("1.- Anula una cita.");
				System.out.println("2.- Concierta una cita.");
				entrada = teclado.nextLine();
				selec = Integer.parseInt(entrada);
			} while (selec != 1 && selec != 2);
			
			//si llega aqui es que los datos ingresados son correctos
			if (selec == 1)
				volver = anularCita();
			else
				volver = concertarCita(tis, apellido, nacim);
		}
		teclado.close();
	}

	//metodo para anular cita
	private static boolean anularCita() {
		
		String	numCita;
		int		cleanNumCita;
		
		do {
			System.out.println("Inserta el número de la cita:");	//esto solo se verifica si se quiere anular cita
			entrada = teclado.nextLine();							//por eso no lo puse en el main
			numCita = entrada.trim();
		} while (!validacionNumCita(numCita));
		
		cleanNumCita = Integer.parseInt(numCita);
		System.out.println("Cita con el número " + cleanNumCita + " anulada.");
		return (false);
	}
	
	//se revisa ya que para ser valido deben ser solo numeros
	private static boolean validacionNumCita(String numCita) {
		
		for (int i = 0; i < numCita.length(); i++) {
			
			if (!Character.isDigit(numCita.charAt(i))) {	//solo pueden ser numeros, y un solo numero
				System.out.println("Error: solo se admite un número de cita.");
				return (false);
			}
		}
		return (true);
	}
	
	//metodo para concertar cita
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
			return (true);	//esto asigna true a la boolean 'volver'
		
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
		
		return (false);	//retornamos false indicando que no es necesario regresar el menu de inicio y resetear 'volver'
	}
		
	//funcion que revisa si el numero de tis ingresado es valido
	private static long validacionTis(String cadenaTis) {
		
		String cleanTis;
		if (!checkOnlyNums(cadenaTis))
			return (-1);
		
		cleanTis = cleanNumTis(cadenaTis);
		
		if (cleanTis.length() < 12) {
			System.out.println("Error: deben ser 12 dígitos.");
			return(-1);
		}
		/* Es curioso porque el enunciado del ejercicio pide que sean exactamente doce digitos pero en el
		 * documento con ejecuciones de ejemplo (1 y 2), ponen numeros de tis de 5 digitos nada mas.
		 * Me he ceñido al requisito en vez de al ejemplo de ejecucion.  */
		
		
		tis = Long.parseLong(cleanTis);
		
		if (tis < 0 || !algoLuhn(tis)) {
			System.out.println("Error: nº de TIS incorrecto.");			
			return (-1);
		}
	
		return (tis);
	}
	
	//para detectar si contiene algo diferente a un digito del 0 al 9
	private static boolean checkOnlyNums(String cadena) {
		
		
		for (int i = 0; i < cadena.length(); i++) {
			
			/*para esta validacion he dado por bueno si se ponen espacios o tabulaciones en medio,
			 * simplemente los quito mas tarde para unificar el numero de tis
			 */
			
			if (!Character.isDigit(cadena.charAt(i)) && cadena.charAt(i) != ' ' && cadena.charAt(i) != '\t') {
				System.out.println("Error: Solo se permite números para el TIS.");
				return (false);
			}
		}
		return (true);
	}
	
	//para eliminar espacios o tabulaciones dentro del numero de tis
	private static String cleanNumTis(String cadenaConEspacios) {
		
		String	copia = "";
		
		for (int i = 0; i < cadenaConEspacios.length(); i++) {
			if (Character.isDigit(cadenaConEspacios.charAt(i)))
				copia = copia + cadenaConEspacios.charAt(i);
		}
		return (copia);
	}

	//implementacion del algoritmo de Luhn para revisar si el ultimo numero de control es correcto
	private static boolean algoLuhn(long tis) {
		
		long	sum = 0;
		long	numControl = tis % 10;
		long	result;
		long	last;
		
		tis = tis / 10;
		while (tis > 9) {
		
			//posicion impar opera
			last = tis % 10;
			last *= 2;
			if (last > 9)
				last -= 9;
			sum += last;
			tis = tis / 10;

			//posicion par solo se suma
			last = tis % 10;
			sum += last;
			tis = tis / 10;
		}
		//ultimo digito debe operarse tambien
		tis *= 2;
		if (tis > 9)
			tis -= 9;
		sum += tis;
		result = (10 - (sum % 10)) % 10;
		if (result == numControl)
			return (true);
		return (false);
	}
	
	//no admite apellidos compuestos realmente pero revisa que sean letras y solo una palabra
	private static boolean validacionApellido(String apellido) {
		if (apellido.length() <= 0) {
			System.out.println("Error: dato incorrecto, inténtalo de nuevo.");//solo debe ser un apellido (una palabra).
			return (false);
		}
		for (int i = 0; i < apellido.length(); i++) {
			if (!Character.isLetter(apellido.charAt(i))) {
				System.out.println("Error: datos incorrectos, inténtelo de nuevo (un apellido, solo una palabra).");
				return (false);
			}
		}
		return (true);
	}
	
	//se revisa el formato y tambien que sea una fecha valida, no se revisa la edad y si es posible (ej: 11/11/1850 ya estaria muerto)
	private static boolean validacionFecha(String nacim) {
		
		if (nacim.length() != 10)
			return (false);
		
		DateTimeFormatter	formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter	formatter2 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		//he querido dar por valido dos formatos diferentes
		try {
			LocalDate.parse(nacim, formatter1);
			return (true);
		} catch (DateTimeParseException excep1) {
			
			try {
				LocalDate.parse(nacim, formatter2);
				return (true);
			} catch (DateTimeParseException excep2) {
				System.out.println("Error: fecha incorrecta.");
				return (false);
			}
		}
	}
	
}
