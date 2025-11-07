package controlador;

import modelo.*;
import vista.*;
import main.Main;

/**
 * Esta clase gestiona la recogida de datos en general, atributos de productos.
 */
public class RecogerDatoDeProducto {
	
	/**
	 * Solicita al usuario que seleccione una categoría de producto, muestra las categorías disponibles
	 * y valida que coincida.
	 * @param categorias - Array con las categorías válidas disponibles.
	 * @return Categoría seleccionada por el usuario (String válido)
	 */
	public static String recogerCategoria(String categorias[]) {
		
		String	entrada; 
		boolean	esCorrecto = false;
		
		do {
			MostrarMensajeDePeticion.msgAsigneCategoria(categorias);
			entrada = Main.teclado.nextLine().trim();

			if (checkCategoria(entrada, categorias))
				esCorrecto = true;
		} while (!esCorrecto);
		
		return (entrada);
	}
	
	/**
	 * Solicita al usuario que ingrese el nombre para un producto.
	 * Valida que el nombre sea alfanumérico, contenga al menos una letra y que no exista ya
	 * otro producto con ese mismo nombre.
	 * 
	 * @param productos - Array completo de productos disponibles en la máquina expendedora
	 * @return Nombre del producto ingresado por el usuario (String válido y único)
	 */
	public static String recogerNombre(Producto productos[]) {
		
		String	entrada; 
		
		boolean	esCorrecto = false;
		
		do {
			MostrarMensajeDePeticion.msgAsigneDato(1);
			entrada = Main.teclado.nextLine().trim();
			
			if (checkNombre(entrada, productos))
				esCorrecto = true;			
		} while (!esCorrecto);
	
		return (entrada);
	}
	
	/**
	 * Solicita al usuario que ingrese el precio para un producto.
	 * @return Precio del producto como double (entre 0.35 y 5.00)
	 */
	public static double recogerPrecio() {
		
		String	entrada; 
		
		double	precio = -1.00;
		boolean	esCorrecto = false;
		
		do {
			MostrarMensajeDePeticion.msgAsigneDato(2);
			entrada = Main.teclado.nextLine().trim();
			
			if (ValidarTipoDeEntrada.estaDentroDeLimites(entrada) && ValidarTipoDeEntrada.checkSoloNumeroDecimal(entrada)) {
				precio = Double.parseDouble(entrada);
				if (precio < 0.35 || precio > 5) // se ha determinado poner unos limites al precio de los productos
					MostrarMensajeDeError.mostrarError(16);
				else
					esCorrecto = true;
			}
			
		} while (!esCorrecto);
		
		return (precio);
	}
	
	/**
	 * Solicita al usuario que ingrese un ID único para un producto, valida que sea entero
	 * positivo diferente de 0 y que tampoco este repetido en la base de datos.
	 * 
	 * @param productos - Array completo de productos disponibles en la máquina expendedora
	 * @return ID único válido para el producto
	 */
	public static int recogerIDUnico(Producto productos[]) {
		
		String	entrada; 
		
		int		idUnico = 0;
		boolean	esCorrecto;
		
		do {
			esCorrecto = true;
			
			MostrarMensajeDePeticion.msgAsigneDato(3);
			entrada = Main.teclado.nextLine().trim();
			
			if (ValidarTipoDeEntrada.estaDentroDeLimites(entrada) && ValidarTipoDeEntrada.checkSoloNumeroPositivoEntero(entrada)) {
				idUnico = Integer.parseInt(entrada);
				
				if (idUnico == 0) { //unico numero entero que no serviria
					MostrarMensajeDeError.mostrarError(15);
					esCorrecto = false;
				}
				else if (!LeerSeleccion.checkIDUnico(productos, idUnico)){ //revisa que sea unico
					MostrarMensajeDeError.mostrarError(14);
					esCorrecto = false;
				}
			}
			else
				esCorrecto = false;
			
		} while (!esCorrecto);
		
		return (idUnico);
	}
	
	/**
	 * Valida que la categoría ingresada sea correcta, verifica que contenga solo letras y que coincida con una de las existentes.
	 * @param entrada - Categoría ingresada por el usuario
	 * @param categorias - Array con las categorías válidas
	 * @return true si la categoría es válida, false en caso contrario
	 */
	private static boolean checkCategoria(String entrada, String categorias[]) {
		
		boolean	esCorrecto = false;
		
		if (ValidarTipoDeEntrada.estaDentroDeLimites(entrada) && ValidarTipoDeEntrada.checkSoloLetras(entrada)) {
			for(int i = 0; i < 4; i++) {
				if (entrada.equals(categorias[i])) //si no coincide con alguna de las 4, no sirve
					esCorrecto = true;	
			}
			if (!esCorrecto)
			MostrarMensajeDeError.mostrarError(6);
		}
		return (esCorrecto);
	}
	
	/**
	 * Valida que el nombre del producto sea correcto y único
	 * @param entrada - Nombre ingresado por el usuario
	 * @param productos - Array completo de productos disponibles en la máquina expendedora
	 * @return true si el nombre es válido y único, false en caso contrario
	 */
	private static boolean checkNombre(String entrada, Producto productos[]) {
	
		boolean	esCorrecto = true;
		int		totalProductos = productos.length;
		boolean	hayLetras = false;
		
		if (ValidarTipoDeEntrada.estaDentroDeLimites(entrada.trim()) && (ValidarTipoDeEntrada.checkSoloAlfanumerico(entrada.trim()))) {
			
			for (int i = 0; i < entrada.trim().length(); i++) {
				if (Character.isLetter(entrada.trim().charAt(i)))
					hayLetras = true; //nos aseguramos de no sea solo numeros, pero puede ser solo letra o lestras con numeros
			}
			
			if (!hayLetras) {
				MostrarMensajeDeError.mostrarError(13);
				return (!esCorrecto);
			}
			
			for (int i = 0; i < totalProductos; i++) {
				if (entrada.equals(productos[i].nombre)) {
					esCorrecto = false; //si el nombre ya se usa en otro producto, tampoco se puede
					MostrarMensajeDeError.nombreYaEnUso(productos[i].nombre);
				}
			}
		}
		
		else
			esCorrecto = false;
		
		return (esCorrecto);
	}
}
