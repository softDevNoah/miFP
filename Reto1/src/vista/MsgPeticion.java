package vista;

import main.Main;
import modelo.*;

public class MsgPeticion {

	public static int menuOpciones(String titulo, String opciones[], String peticion) {
		
		String	siNo[] = {"Sí", "No"};
		int		decisionTomada;
		
		if (opciones == null)
			opciones = siNo;
		
		System.out.printf("\n\t------> %s <<<<<<------\n\n", titulo);
		for (int i = 0; i < opciones.length; i++) 
			System.out.printf("\t\t%d.- %s.\n", i + 1, opciones[i]);
		System.out.printf("\n\t%s: ", peticion);
		decisionTomada = MenuCliente.recogerOpcionNumerica(1, opciones.length);
		System.out.println("\n-----------------------------------------------------------------------\n");
		
		return (decisionTomada - 1);
	}
	
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
	
	public static int condicionEsClienteOAdministrador() {
		
		String	entrada;
		int		eleccion = 0;
		
		System.out.println("\t¿Qué operación desea realizar?");
		System.out.println("\t\t1.- Comprar productos");
		System.out.println("\t\t2.- Administrar máquina expendedora");
		System.out.print("\tIntroduzca el nº de la operación: ");
		
		entrada = Main.teclado.nextLine();
		
		if (entrada.equals("1"))
			eleccion = 1;
		else if (entrada.equals("2"))
			eleccion = 2;		

		return (eleccion);
	}
	
	public static int condicionSeguirComprando(String categoria) {
		int	opcionElegida;
		
		System.out.println("\t¿Qué operación desea realizar?");
		System.out.println("\t\t1.- Terminar la compra y pagar ya.");
		System.out.println("\t\t2.- Quiero comprar otro producto de otra categoría.");
		System.out.println("\t\t3.- Quiero otro producto de esta categoría (%s).");	
		System.out.print("\tIntroduzca el nº de la operación: ");
		
		opcionElegida = MenuCliente.recogerOpcionNumerica(1, 3);
		
		return (opcionElegida);
	}
}
