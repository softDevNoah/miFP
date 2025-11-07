package modelo;

/**
 * Clase que representa un usuario con sus atributos correspondientes: nombre y contraseña.
 * El constructor asigna valores base para inicializar los usuarios creados.
 */
public class Usuario {


		public String	nombre;
		public String	contraseña;
		
		/**
		 * Crea e inicializa un objeto con sus atributos base.
		 */
		public Usuario () {
			nombre = "VACIO";
			contraseña = "VACIO";
		}
}
