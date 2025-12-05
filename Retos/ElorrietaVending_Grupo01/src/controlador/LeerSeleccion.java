package controlador;

import main.Main;
import modelo.*;
import vista.*;

/**
 * Esta clase gestiona los métodos que seleccionan objetos o datos de los objetos. También contiene métodos para revisar si un id de un
 * producto es único o buscar un producto según su id.
 */
public class LeerSeleccion {
	
	/**Solicita al usuario que seleccione un producto mediante su ID único, valida que el ID sea
	 * un número entero positivo y que este exista en el array, y devuelve el índice.
	 * 
 	 * @param productos - Array completo de productos disponibles en la máquina expendedora.
	 * @param opcion - Texto descriptivo de la acción
	 * @return Índice del producto seleccionado en el array. Retorna -1 si no se encuentra
	 */
	public static int seleccionarProducto(Producto productos[], String opcion) {
		String	entrada;
		int		seleccionProducto = -1;
		boolean	esCorrecto = false;
		int		indiceProducto = -1;
		do {
			System.out.printf("\t------>>>>>> ¿Qué producto desea %s? <<<<<<------\n\n", opcion);
			System.out.print("\t·····> Escriba únicamente el ID del producto:\t");
			
			entrada = Main.teclado.nextLine().trim();
			
			//si es un formato valido:
			if (ValidarTipoDeEntrada.estaDentroDeLimites(entrada) && ValidarTipoDeEntrada.checkSoloNumeroPositivoEntero(entrada)) {
				
				seleccionProducto = Integer.parseInt(entrada);
				
				//busca si existe ese producto
				if (!checkIDUnico(productos, seleccionProducto)) {
					indiceProducto = busquedaPorIdUnico(productos, seleccionProducto);
					esCorrecto = true;
					System.out.println();
				}
				else
					MostrarMensajeDeError.mostrarError(10); //no existe
			}
		} while (!esCorrecto); //no sale del bucle hasta que se encuentre el producto
		
		return (indiceProducto);
	}
	
	/**Permite seleccionar un producto de una categoría específica. Muestra solo los productos de la
	 * categoría indicada y solicita al usuario que elija uno de ellos.
	 * 
	 * @param productos - Array completo de productos disponibles en la máquina expendedora
	 * @param categoria - Categoría seleccionada por la cual se filtrarán los productos de la máquina.
	 * @return Objeto Producto seleccionado por el usuario
	 */
	public static Producto seleccionarProductoDeUnaCategoria(Producto productos[], String categoriaSeleccionada) {
	
		String	entrada;
		int		indiceProducto = 0;
		boolean	esCorrecto = false;
		
		int		numActualProductos = productos.length;
		int		numProductosConCategoria;
		
		int		idProductoSeleccionado = 0;
		
		do {
			MostrarListaDeProductos.mostrarPorCategoria(productos, categoriaSeleccionada);
			
			System.out.printf("\t------>>>>>> ¿Qué producto desea añadir a la cesta? <<<<<<------\n");
			System.out.print("\n\tEscriba el nº del producto: ");
			
			entrada = Main.teclado.nextLine().trim();
			
			if (ValidarTipoDeEntrada.estaDentroDeLimites(entrada) && ValidarTipoDeEntrada.checkSoloNumeroPositivoEntero(entrada)) {
				
				indiceProducto = Integer.parseInt(entrada);
				
				numProductosConCategoria = 0;
				
				//primero se cuenta si hay productos de esa categoria
				for (int i = 0; i < numActualProductos; i++) {
					
					if (productos[i].categoria.equals(categoriaSeleccionada)) {
						numProductosConCategoria++;
						
						//si coincide, la seleccion es correcta y se copia el id
						if (numProductosConCategoria == indiceProducto)
							idProductoSeleccionado = productos[i].idUnico;								
					}
				}
				
				//se busca por el id en la lista completa
				indiceProducto = Operaciones.buscarPorID(productos, idProductoSeleccionado);
				
				//si es 0 es que no es correcto
				if (idProductoSeleccionado > 0) {
					esCorrecto = true;
				}
			}
		} while (!esCorrecto);
		
		return (productos[indiceProducto]);
	}
	
	/** Permite al usuario seleccionar qué dato de un producto desea modificar.
	 *  Muestra los valores actuales del producto y da 3 opciones a elegir: nombre, categoría y precio.
	 * 
	 * @param producto - Producto cuyos datos se desean modificar
	 * @return Número del tipo de dato seleccionado
	 */
	public static int seleccionTipoDato(Producto producto) {
		
		String	entrada;
		int		tipoDato = -1;
		boolean	esCorrecto = false;

		do {
			System.out.println("\t------>>>>>> ¿Qué dato desea modificar? <<<<<<------\n");
			System.out.printf("\t\t1.- Nombre\t(original: \"%s\")\n", producto.nombre);
			System.out.printf("\t\t2.- Categoría\t(original: \"%s\")\n", producto.categoria);
			System.out.printf("\t\t3.- Precio\t(original: \"%.2f\")\n\n", producto.precio);
			System.out.print("\t·····> Seleccione un dato, por favor: ");
	
			entrada = Main.teclado.nextLine().trim();
			
			//no se usa menu de opciones porque en el formato se indica los valores originales del producto
			if ((ValidarTipoDeEntrada.estaDentroDeLimites(entrada)) && (entrada.equals("1") || entrada.equals("2") || entrada.equals("3"))) {
				esCorrecto = true;
				tipoDato = Integer.parseInt(entrada);
			}
			
		} while (!esCorrecto); //hasta que no se elija una opcion correcta va a repetir este proceso
		
		return (tipoDato);
	}

	/** Busca un producto en el array de productos existentes en la máquina, mediante su ID único,
	 * recorre linealmente el array hasta encontrar una coincidencia.
	 * 
	 * @param productos - Array completo de productos disponibles en la máquina expendedora
	 * @param numeroID - ID único del producto a buscar
	 * @return Índice del producto en el array. Retorna -1 si no se encuentra.
	 */
	private static int busquedaPorIdUnico(Producto productos[], int numeroID) {
		
		int	indiceProducto = -1;
		int	cantidadActual = productos.length;
		
		for (int i = 0; i < cantidadActual; i++) {
			if (productos[i].idUnico == numeroID)
				indiceProducto = i;
		}
		// si no se ha encontrado, retornará -, pero si lo encontro devolvera el valor asignado con i en el bucle
		return (indiceProducto);
	}

	/**
	 * Verifica si un posible ID ya existe en el array de productos existentes en la máquina expendedora (por tanto estaría repetido),
	 * y así valida que no se ingresen IDs duplicados en ningún momento.
	 * @param productos - Array completo de productos disponibles en la máquina expendedora
	 * @param id - Número que hace de posible id, que se validará si es único o repetido.
	 * @return booleano que indica si el ID efectivamente es único o ya existe.
	 */
	public static boolean checkIDUnico(Producto productos[], int id) {
		
		boolean	esCorrecto = true;
		int		totalProductos = productos.length;		
		
		for (int i = 0; i < totalProductos; i++) {
			if (id == productos[i].idUnico) {
				esCorrecto = false; //esto significa que ya existe
			}
		}
		
		return (esCorrecto);
	}
}
