package controlador;

import main.Main;
import modelo.*;
import utiles.*;

public class LeerSeleccionDeProducto {
	
	public static int seleccionarProducto(Producto productos[], String opcion) {
		String	entrada;
		int		seleccionProducto = -1;
		boolean	esCorrecto = false;
		
		do {
			System.out.printf("[[[[[[\t¿Qué producto desea %s?\t]]]]]]\n", opcion);
			System.out.print("\tEscriba únicamente el ID del producto:\t");
			entrada = Main.teclado.nextLine();
			if (ValidarTipoDeEntrada.estaDentroDeLimites(entrada) && ValidarTipoDeEntrada.checkSoloNumeroPositivoEntero(entrada))
				seleccionProducto = Integer.parseInt(entrada);
				if (ValidarDatoDeProducto.checkIDUnico(seleccionProducto, productos))
					esCorrecto = true;
		} while (!esCorrecto);
		
		return (seleccionProducto);
	}
	
	public static int eleccionTipoDato(Producto producto) {
		
		String	entrada;
		int		tipoDato = -1;
		boolean	esCorrecto = false;

		do {
			System.out.println("[[[[[[\t¿Qué dato desea modificar?\t]]]]]]");
			System.out.printf("\t1.- Nombre (original: \"%s\".\n", producto.nombre);
			System.out.printf("\t2.- Categoría (original: \"%s\".\n", producto.categoria);
			System.out.printf("\t3.- Precio (original: \"%.2f\".\n", producto.precio);
			System.out.print("Escriba solo 1, 2 o 3 para elegir, por favor:\t");
	
			entrada = Main.teclado.nextLine();
			if ((ValidarTipoDeEntrada.estaDentroDeLimites(entrada)) && (entrada.equals("1") || entrada.equals("2") || entrada.equals("3"))) {
				esCorrecto = true;
				tipoDato = Integer.parseInt(entrada);
			}
		} while (!esCorrecto);
		
		return (tipoDato);
	}
}
