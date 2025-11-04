package vista;

public class MostrarMensajeDeError {

	private static final String LINEA1 = "\n\n-----------------------------------------------------------------------------------------------------------------\n--------------[✖]ERROR: ";
	private static final String LINEA2 = "\n-----------------------------------------------------------------------------------------------------------------\n";
	
	private static final String	MSG_ERRORES[] = {
			"Ningún dato introducido, por favor inténtelo de nuevo.----------------------------------",
			"Solo se permiten hasta 8 caracteres, por favor inténtelo de nuevo.----------------------",
			"Inserte solamente letras, por favor.----------------------------------------------------",
			"Inserte un número entero positivo, por favor.-------------------------------------------",
			"Inserte solamente caracteres alfanuméricos, por favor.----------------------------------",
			"Inserte un nº decimal positivo, por favor.----------------------------------------------",
			"Categoría incorrecta, por favor inténtelo de nuevo.-------------------------------------",
			"Contraseña incorrecta, por favor inténtelo de nuevo.------------------------------------",
			"Opción incorrecta, por favor inténtelo de nuevo.----------------------------------------",
			"No existe ningún producto actualmente, esta máquina está vacía.-------------------------",
			"No se ha encontrado un producto acorde a este criterio de búsqueda.---------------------",
			"No se puede añadir más productos a la cesta, total máximo permitido: 250€. Lo sentimos.-",
			"Esta máquina no admite ingresar más de 250€.--------------------------------------------",
			"El nombre que intenta asignar no tiene letras, pruebe con otro, por favor.--------------",
			"El ID que intenta asignar, ya existe en otro producto, intente otro por favor.----------",
			"El ID del producto no puede ser 0, debe ser un número entero positivo.------------------",
			"El precio de un producto debe ser mínimo 35 céntimos y máximo 5 euros.------------------",
	};
	
	public static void mostrarError(int indiceDeError) {
		
		System.out.println(LINEA1 + MSG_ERRORES[indiceDeError] + LINEA2);
	}
		
	
	
	public static void nombreYaEnUso(String nombreProducto) {
		
		System.out.printf(LINEA1 + "El nombre \"%s\" ya está asigando a otro producto, por favor elija otro.----------\n" + LINEA2, nombreProducto);
	}
	
	public static void usuarioNoExiste(String nombreDeUsuario) {
		System.out.printf(LINEA1 + "El usuario \"%s\" no existe, por favor pruebe otro.----------------------------\n" + LINEA2, nombreDeUsuario);
	}
	
}
