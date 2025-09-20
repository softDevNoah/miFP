package ejercicioUD2_5_4_Noah;

import java.util.Scanner;

/*Entrega 4 de 4 (5 contando con los ejercicios extra) de los ejercicios del Tema 2.
 * En este paquete se desarrollan los ejercicios 13, 14 y 15*/

public class Main {
	
	private static Scanner	teclado = new Scanner(System.in);
	private static String	entrada;
	private static String	numEjercicio;
	private static int		num;
	
	public static void main(String[] args) {
		
		int opt;
		
		System.out.println("Escribe 13 o 14 (o 0 para salir).");
		
		numEjercicio = teclado.nextLine();
		opt = Integer.parseInt(numEjercicio);
		
		while (opt !=0) {
			switch (opt) {
				case 13:
					ejercicio13();
					break;
				case 14:
					ejercicio14();
					break;
				case 15:
					ejercicio15();
					break;
			}
			if (opt != 0) {
				System.out.println("-------------------------------------------------------------------------------------");
				System.out.println("Escribe 13 o 14 (o 0 para salir).");
				numEjercicio = teclado.nextLine();
				opt = Integer.parseInt(numEjercicio);
			}
		}
	}
	
	private static void ejercicio13() {
		/*13. En un banco se procesan datos de las cuentas corrientes de sus clientes.
		 	De cada cuenta corriente se conoce: número de cuenta y saldo actual.
		  	El ingreso de datos debe finalizar al ingresar un valor negativo en el número de cuenta.
			Se pide confeccionar un programa que lea los datos de las cuentas corrientes e informe:
			a)De cada cuenta: número de cuenta y estado de la cuenta según su saldo,
			sabiendo que Estado de la cuenta puede tener los siguientes valores:
				● 'Acreedor' si el saldo es >0.
				● 'Deudor' si el saldo es <0.
				● 'Nulo' si el saldo es =0.
			b) La suma total de los saldos acreedores.*/
		
		long	 cuenta, saldo, total = 0; //usé tipo long por si el número de cuenta o el saldo es muy largo o alto respectivamente
		
		do { 	/*aunque use while o do-while, debo incluir un if dentro de aqui para poder asegurarme de que la cuenta tiene valor >= 0.
		 		La diferencia en usar do-while aqui, está en que así me evito inicializar las variables cuenta y saldo antes de esta 
		 		estructura. Así, si o si se pedirá al menos una vez que se ingresen los datos de cuenta y saldo*/
			
			System.out.println("Por favor, introduzca el número de cuenta: ");
			
			entrada = teclado.nextLine();
			cuenta = Long.parseLong(entrada);
			
			if (cuenta >= 0) {	//me aseguro de que cuenta es >= 0
				System.out.println("Por favor, introduzca el saldo: ");
			
				entrada = teclado.nextLine();
				saldo = Long.parseLong(entrada);
				
				System.out.print("Cuenta: " + cuenta + "\nEstado: ");
				if (saldo > 0) {
					System.out.println("Acreedor");
					total += saldo;
				}
				else if (saldo == 0)
					System.out.println("Nulo");
				else
					System.out.println("Deudor");
				System.out.println("Saldo total de los acreedores: " + total + "\n");
			
			}
			else
				System.out.println("Salida del programa exitosa.");//indico salida al ingresar un valor negativo
		} while (cuenta >= 0); //condicion para poder seguir funcionando el programa
		
	}
	
	
	private static void ejercicio14() {
		/*14. Escribir un programa que lea 10 notas de alumnos y nos informe cuántos tienen notas
		 * mayores o iguales a 7 y cuántos menores.*/
		
		
	}
	
	private static void ejercicio15() {
		/*15. Realizar un programa que implemente cuatro operaciones básicas de una calculadora: suma, resta, producto y división.
	Mostrar en pantalla el siguiente menú:

		*******************
			Calculadora
		*******************
	1. Suma
	2. Resta
	3. Producto
	4. División
	5. Salir
	
	Introduce la opción deseada:

	En función de la opción introducida por el usuario, se realizará lo siguiente:
		a. Opciones entre 1 y 4: en todos ellos se solicitará introducir dos números por teclado y se realizará la operación matemática indicada por el número de opción de menú. En pantalla se mostrará lo siguiente:
		Operación seleccionada: nombre operación en texto
		Operando1 operación Operando2 = resultado
		Ejemplo:
			Operación seleccionada: Suma
			5+1=6
		b. Hasta que se pulse el número 5, la calculadora estará ejecutándose constantemente. Una vez realizada una operación, el menú volverá a mostrarse para que el usuario pueda seleccionar una nueva opción.
		c. Si selecciona la opción 5, el programa terminará.
		d. Si se pulsa un número fuera del rango del 1 al 5, se mostrará un mensaje por pantalla: Opción X no disponible, vuelva a intentarlo. A continuación, volver a mostrar el menú para que pueda continuar.*/
		
		
	}
}