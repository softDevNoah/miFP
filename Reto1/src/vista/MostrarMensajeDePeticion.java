package vista;

import main.Main;

public class MostrarMensajeDePeticion {

	public static void msgIntroduzcaUsuario() {
		System.out.print("*\n\t·····> Introduzca el nombre de usuario, por favor: ");
	}
	
	public static void msgIntroduzcaContraseña() {
		System.out.print("\n\t·····> Introduzca la contraseña, por favor: ");
	}
	
	public static void msgAsigneCategoria(String categorias[]) {
		System.out.print("\t·····> Asigne una categoría al producto, por favor. ");
		System.out.printf("Categorías posibles: %s, %s, %s, %s: ", categorias[0], categorias[1], categorias[2], categorias[3]);
	}
	
	public static void msgAsigneNombre() {
		System.out.print("\t·····> Asigne un nombre al producto, por favor: ");
	}
	
	public static void msgAsignePrecio() {
		System.out.print("\t·····> Asigne un precio al producto, por favor: ");
	}
	
	public static boolean condicionDeseaCancelar() {
		String	entrada;
		boolean	afirmativo = false;

		System.out.println("\t------>>>>>> ¿Desea cancelar la operación?");
		System.out.print("\t·····> Si desea cancelar escriba \"S\":\t");
		entrada = Main.teclado.nextLine();
		if (entrada.equals("S")) {
			afirmativo = true;
			System.out.println("\n\t\t------->>>>\tCancelando...\t<<<<-------\n");
		}
		return (afirmativo);
	}
	
	public static boolean condicionDeseaVolver() {
		String	entrada;
		boolean	afirmativo = false;

		System.out.println("\t------>>>>>> ¿Desea volver al menú?");
		System.out.print("\t·····> Si desea volver escriba \"S\":\t");
		entrada = Main.teclado.nextLine();
		if (entrada.equals("S")) {
			afirmativo = true;
			System.out.println("\n\t\t------->>>>\tRegresando...\t<<<<-------\n");
		}
		return (afirmativo);
	}
	
	public static boolean condicionDeseaContinuar() {
		String	entrada;
		boolean	afirmativo = false;

		System.out.println("\t------>>>>>> ¿Desea continuar modificando datos de este producto?");
		System.out.print("\t·····> Si desea continuar escriba \"S\":\t");
		entrada = Main.teclado.nextLine();
		if (entrada.equals("S")) {
			afirmativo = true;
			System.out.println("\n\t\t------->>>>\tContinuamos...\t<<<<-------\n");
		}
		return (afirmativo);
	}
	
	public static boolean condicionConfirmaEliminar() {
		String	entrada;
		boolean	afirmativo = false;

		System.out.println("\t------>>>>>> ¿Estás segurx de eliminar este producto?");
		System.out.print("\t·····> Si desea continuar escriba \"S\":\t");
		entrada = Main.teclado.nextLine();
		if (entrada.equals("S")) {
			afirmativo = true;
			System.out.println("\n\t\t------->>>>\tEliminando...\t<<<<-------\n");
		}
		return (afirmativo);
	}
}
