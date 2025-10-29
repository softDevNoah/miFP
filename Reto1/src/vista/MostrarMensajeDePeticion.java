package vista;

import main.Main;

public class MostrarMensajeDePeticion {

	public static void msgIntroduzcaUsuario() {
		System.out.println("****************************************************************************************************************");
		System.out.print("*\tIntroduzca el nombre de usuario, por favor: ");
	}
	
	public static void msgIntroduzcaContraseña() {
		System.out.print("\n\tIntroduzca la contraseña, por favor: ");
	}
	
	public static void msgAsigneCategoria(String categorias[]) {
		System.out.println("****************************************************************************************************************");
		System.out.print("\tAsigne una categoría al producto, por favor. ");
		System.out.printf("Categorías posibles: %s, %s, %s, %s: ", categorias[0], categorias[1], categorias[2], categorias[3]);
	}
	
	public static void msgAsigneIDUnico() {
		System.out.println("****************************************************************************************************************");
		System.out.print("\tAsigne un ID Único al producto, por favor: ");
	}
	
	public static void msgAsigneNombre() {
		System.out.println("****************************************************************************************************************");
		System.out.print("\tAsigne un nombre al producto, por favor: ");
	}
	
	public static void msgAsignePrecio() {
		System.out.println("****************************************************************************************************************");
		System.out.print("\tAsigne un precio al producto, por favor: ");
	}
	
	
	public static boolean condicionDeseaVolver() {
		String	entrada;
		boolean	afirmativo = false;

		System.out.println("[[[[[[\t¿Desea cancelar la operación y regresar al menú?\t]]]]]]");
		System.out.print("\t\t\tSi desea cancelar escriba \"S\":\t");
		entrada = Main.teclado.nextLine();
		if (entrada.equals("S")) {
			afirmativo = true;
			System.out.println("\n\t\t------->>>>\tCancelando...\t<<<<-------\n");
		}
		return (afirmativo);
	}
	
	public static boolean condicionDeseaContinuar() {
		String	entrada;
		boolean	afirmativo = false;

		System.out.println("[[[[[[\t¿Desea continuar modificando datos de este producto?\t]]]]]]");
		System.out.print("\t\t\tSi desea continuar escriba \"S\":\t");
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

		System.out.println("[[[[[[\t¿Estás segurx de eliminar este producto?\t]]]]]]");
		System.out.print("\t\t\tSi desea continuar escriba \"S\":\t");
		entrada = Main.teclado.nextLine();
		if (entrada.equals("S")) {
			afirmativo = true;
			System.out.println("\n\t\t------->>>>\tEliminando...\t<<<<-------\n");
		}
		return (afirmativo);
	}
}
