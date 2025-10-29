package vista;

public class MostrarMensajeDeError {

	public static void entradaVacia() {
		System.out.println("\n\n-----------------------------------------------------------------------------------------------------------------");
		System.out.println("------------------ERROR:\tNingún dato introducido, por favor inténtelo de nuevo.---------------------------------");
		System.out.println("-----------------------------------------------------------------------------------------------------------------\n\n");
	}
	
	public static void entradaDemasiadoExtensa() {
		System.out.println("\n\n-----------------------------------------------------------------------------------------------------------------");
		System.out.println("------------------ERROR:\tDemasiados datos, debe ser máximo 8 caracteres, por favor inténtelo de nuevo.----------");
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
	
	public static void noEsSoloUnNumeroPositivo() {
		System.out.println("\n\n-----------------------------------------------------------------------------------------------------------------");
		System.out.println("------------------ERROR:\tinserte un número positivo, por favor.-------------------------------------------------");
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
		System.out.println("------------------ERROR:\tinserte un nº decimal positivo, por favor.---------------------------------------------");
		System.out.println("-----------------------------------------------------------------------------------------------------------------\n\n");
	}
	
	public static void categoriaIncorrecta() {
		System.out.println("\n\n-----------------------------------------------------------------------------------------------------------------");
		System.out.println("------------------ERROR:\tcategoría incorrecta, por favor inténtelo de nuevo.------------------------------------");
		System.out.println("-----------------------------------------------------------------------------------------------------------------\n\n");
	}
	
	public static void nombreYaEnUso(String nombreProducto) {
		System.out.println("\n\n-----------------------------------------------------------------------------------------------------------------");
		System.out.printf("------------------ERROR:\tel nombre \"%s\" ya está asigando a otro producto, por favor elija otro.----------------\n");
		System.out.println("-----------------------------------------------------------------------------------------------------------------\n\n");
	}
	
	public static void usuarioNoExiste(String nombreDeUsuario) {
		System.out.println("\n\n-----------------------------------------------------------------------------------------------------------------");
		System.out.printf("------------------ERROR:\tel usuario %s no existe, por favor pruebe otro.----------------------------\n", nombreDeUsuario);
		System.out.println("-----------------------------------------------------------------------------------------------------------------\n\n");
	}
	
	public static void contraseñaIncorrecta() {
		System.out.println("\n\n-----------------------------------------------------------------------------------------------------------------");
		System.out.printf("------------------ERROR:\tcontraseña incorrecta, por favor inténtelo de nuevo.------------------------------------\n");
		System.out.println("-----------------------------------------------------------------------------------------------------------------\n\n");
	}
	
	public static void opcionIncorrecta() {
		System.out.println("\n\n-----------------------------------------------------------------------------------------------------------------");
		System.out.println("------------------ERROR:\topción incorrecta, por favor inténtelo de nuevo.---------------------------------------");
		System.out.println("-----------------------------------------------------------------------------------------------------------------\n\n");
	}
	
	public static void noHayNingunProducto() {
		System.out.println("\n\n-----------------------------------------------------------------------------------------------------------------");
		System.out.println("------------------ERROR:\tNo existe ningún producto actualmente, esta máquina está vacía.------------------------");
		System.out.println("-----------------------------------------------------------------------------------------------------------------\n\n");
	}
	
	public static void noHayNingunProductoConEsteCriterioDeBusqueda() {
		System.out.println("\n\n-----------------------------------------------------------------------------------------------------------------");
		System.out.println("------------------ERROR:\tNo se ha encontrado un producto acorde a este criterio de búsqueda.--------------------");
		System.out.println("-----------------------------------------------------------------------------------------------------------------\n\n");
	}
	
}
