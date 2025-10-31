package vista;

public class MostrarMensajeDeError {

	public static void entradaVacia() {
		System.out.println("\n\n-----------------------------------------------------------------------------------------------------------------");
		System.out.println("------------------ERROR: Ningún dato introducido, por favor inténtelo de nuevo.----------------------------------");
		System.out.println("-----------------------------------------------------------------------------------------------------------------\n");
	}
	
	public static void entradaDemasiadoExtensa() {
		System.out.println("\n\n-----------------------------------------------------------------------------------------------------------------");
		System.out.println("------------------ERROR: Solo se permiten hasta 8 caracteres, por favor inténtelo de nuevo.----------------------");
		System.out.println("-----------------------------------------------------------------------------------------------------------------\n");
	}
	
	public static void noEsSoloTexto() {
		System.out.println("\n\n-----------------------------------------------------------------------------------------------------------------");
		System.out.println("------------------ERROR: Inserte solamente letras, por favor.----------------------------------------------------");
		System.out.println("-----------------------------------------------------------------------------------------------------------------\n");
	}
	
	public static void noEsSoloUnNumero() {
		System.out.println("\n\n-----------------------------------------------------------------------------------------------------------------");
		System.out.println("------------------ERROR: Inserte solamente un número, por favor.-------------------------------------------------");
		System.out.println("-----------------------------------------------------------------------------------------------------------------\n");
	}
	
	public static void noEsSoloUnNumeroPositivo() {
		System.out.println("\n\n-----------------------------------------------------------------------------------------------------------------");
		System.out.println("------------------ERROR: Inserte un número positivo, por favor.--------------------------------------------------");
		System.out.println("-----------------------------------------------------------------------------------------------------------------\n");
	}
	
	public static void noEsSoloAlfanumerico() {
		System.out.println("\n\n-----------------------------------------------------------------------------------------------------------------");
		System.out.println("------------------ERROR: Inserte solamente caracteres alfanuméricos, por favor.----------------------------------");
		System.out.println("-----------------------------------------------------------------------------------------------------------------\n");
	}
	
	public static void noEsSoloUnNumeroDecimal() {
		System.out.println("\n\n-----------------------------------------------------------------------------------------------------------------");
		System.out.println("------------------ERROR: Inserte un nº decimal positivo, por favor.----------------------------------------------");
		System.out.println("-----------------------------------------------------------------------------------------------------------------\n");
	}
	
	public static void categoriaIncorrecta() {
		System.out.println("\n\n-----------------------------------------------------------------------------------------------------------------");
		System.out.println("------------------ERROR: Categoría incorrecta, por favor inténtelo de nuevo.-------------------------------------");
		System.out.println("-----------------------------------------------------------------------------------------------------------------\n");
	}
	
	public static void nombreYaEnUso(String nombreProducto) {
		System.out.println("\n\n-----------------------------------------------------------------------------------------------------------------");
		System.out.printf("------------------ERROR: El nombre \"%s\" ya está asigando a otro producto, por favor elija otro.----------\n", nombreProducto);
		System.out.println("-----------------------------------------------------------------------------------------------------------------\n");
	}
	
	public static void usuarioNoExiste(String nombreDeUsuario) {
		System.out.println("\n\n-----------------------------------------------------------------------------------------------------------------");
		System.out.printf("------------------ERROR: El usuario \"%s\" no existe, por favor pruebe otro.----------------------------\n", nombreDeUsuario);
		System.out.println("-----------------------------------------------------------------------------------------------------------------\n");
	}
	
	public static void contraseñaIncorrecta() {
		System.out.println("\n\n-----------------------------------------------------------------------------------------------------------------");
		System.out.printf("------------------ERROR: Contraseña incorrecta, por favor inténtelo de nuevo.------------------------------------\n");
		System.out.println("-----------------------------------------------------------------------------------------------------------------\n");
	}
	
	public static void opcionIncorrecta() {
		System.out.println("\n\n-----------------------------------------------------------------------------------------------------------------");
		System.out.println("------------------ERROR: Opción incorrecta, por favor inténtelo de nuevo.----------------------------------------");
		System.out.println("-----------------------------------------------------------------------------------------------------------------\n");
	}
	
	public static void noHayNingunProducto() {
		System.out.println("\n\n-----------------------------------------------------------------------------------------------------------------");
		System.out.println("------------------ERROR: No existe ningún producto actualmente, esta máquina está vacía.-------------------------");
		System.out.println("-----------------------------------------------------------------------------------------------------------------\n");
	}
	
	public static void noHayNingunProductoConEsteCriterioDeBusqueda() {
		System.out.println("\n\n-----------------------------------------------------------------------------------------------------------------");
		System.out.println("------------------ERROR: No se ha encontrado un producto acorde a este criterio de búsqueda.---------------------");
		System.out.println("-----------------------------------------------------------------------------------------------------------------\n");
	}
	
	public static void noSePuedenAñadirMasProductosALaCesta() {
		System.out.println("\n\n-----------------------------------------------------------------------------------------------------------------");
		System.out.println("------------------ERROR: No se pueden añadir más productos a la cesta, ha llegado al máximo permitido.-----------");
		System.out.println("------------------	Solo se permiten añadir productos mientras no se alcance un total de 250€, lo sentimos.------");
		System.out.println("-----------------------------------------------------------------------------------------------------------------\n");
	}
	
}
