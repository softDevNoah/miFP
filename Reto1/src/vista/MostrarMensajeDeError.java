package vista;

public class MostrarMensajeDeError {

	public static void entradaVacia() {
		System.out.println("\n\n-----------------------------------------------------------------------------------------------------------------");
		System.out.println("------------------ERROR:\tNingún dato introducido, por favor inténtelo de nuevo.---------------------------------");
		System.out.println("-----------------------------------------------------------------------------------------------------------------\n\n");
	}
	
	public static void entradaDemasiadoExtensa() {
		System.out.println("\n\n-----------------------------------------------------------------------------------------------------------------");
		System.out.println("------------------ERROR:\tDemasiados datos introducidos, son más de 8 caracteres), por favor inténtelo de nuevo.-");
		System.out.println("-----------------------------------------------------------------------------------------------------------------\n\n");
	}
	
	public static void noEsSoloTexto() {
		System.out.println("\n\n-----------------------------------------------------------------------------------------------------------------");
		System.out.println("------------------ERROR:\tinserte solamente letras y espacios, por favor.----------------------------------------");
		System.out.println("-----------------------------------------------------------------------------------------------------------------\n\n");
	}
	
	public static void noEsSoloUnNumero() {
		System.out.println("\n\n-----------------------------------------------------------------------------------------------------------------");
		System.out.println("------------------ERROR:\tinserte solamente un número, por favor.------------------------------------------------");
		System.out.println("-----------------------------------------------------------------------------------------------------------------\n\n");
	}
	
	public static void noEsSoloAlfanumerico() {
		System.out.println("\n\n-----------------------------------------------------------------------------------------------------------------");
		System.out.println("------------------ERROR:\tinserte solamente caracteres alfanuméricos, por favor.---------------------------------");
		System.out.println("-----------------------------------------------------------------------------------------------------------------\n\n");
	}
	
	public static void noEsSoloSiONo() {
		System.out.println("\n\n-----------------------------------------------------------------------------------------------------------------");
		System.out.println("------------------ERROR:\tinserte solamente sí o no, por favor.--------------------------------------------------");
		System.out.println("-----------------------------------------------------------------------------------------------------------------\n\n");
	}
	public static void noEsSoloUnNumeroDecimal() {
		System.out.println("\n\n-----------------------------------------------------------------------------------------------------------------");
		System.out.println("------------------ERROR:\tinserte solamente sí o no, por favor.--------------------------------------------------");
		System.out.println("-----------------------------------------------------------------------------------------------------------------\n\n");
	}
}
