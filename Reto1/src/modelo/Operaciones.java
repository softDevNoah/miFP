package modelo;

import controlador.*;
import main.Main;
import vista.*;

public class Operaciones {

	/**
	 * Crea un nuevo producto y se agrega a array de productos existentes en la máquina.
	 * Se asignan los valores de los atributos del producto añadido.
	 * Al final se ofrece cancelar la operación y solo devuelve los productos con el nuevo si no se cancela.
	 * Si se cancela, devuelve el array originalmente recibido.
	 * 
	 * @param productos - Array completo de productos disponibles en la máquina expendedora
	 * @return Array completo de productos disponibles en la máquina expendedora con el nuevo producto o el array sin modificar
	 */
	public static Producto[] nuevoProducto(Producto productos[]) {
		
		Producto	nuevoProducto;
		Producto	productosActualizados[];
		int			cantidadActual;
		
		cantidadActual = productos.length;
		nuevoProducto = new Producto();
				
		nuevoProducto.nombre = RecogerDatoDeProducto.recogerNombre(productos);
		nuevoProducto.categoria = RecogerDatoDeProducto.recogerCategoria(nuevoProducto.categorias);
		nuevoProducto.precio = RecogerDatoDeProducto.recogerPrecio();
		nuevoProducto.idUnico = RecogerDatoDeProducto.recogerIDUnico(productos);
		
		if (MostrarMensajeDePeticion.menuOpciones("¿Desea cancelar y volver atrás?", null, "Introduzca una opción") == 0)
			return (productos);
		
		productosActualizados = new Producto[cantidadActual + 1];
		
		for (int i = 0; i < cantidadActual; i++) 
			productosActualizados[i] = productos[i];

		productosActualizados[cantidadActual] = nuevoProducto;
		
		MostrarMensajeInformativo.msgOperacionRealizadaCorrectamente(1);
		return (productosActualizados);
	}

	/**
	 * Si existen productos en la máquina, se selecciona producto. Si no existen, se muestra un mensaje de error.
	 * Si la selección es correcta,se modifican los valores de los atributos del producto seleccionado.
	 * Al final se ofrece cancelar la operación y solo devuelve el array de productos con los cambios incluidos si no se cancela.
	 * Si se cancela la operación, devuelve el array de productos con el producto seleccionado sin ningún cambio.
	 * 
	 * @param productos - Array completo de productos disponibles en la máquina expendedora
	 * @return Array de productos modificado o sin modificar
	 */
	public static Producto[] modificarProducto(Producto[] productos) {
		int			indiceProducto;
		int			tipoDato = -1;
		String		nombreOriginal;
		String		categoriaOriginal;
		double		precioOriginal;

		if (productos.length > 0) {
			do {
				MostrarListaDeProductos.mostrarListaCompleta(productos);
				indiceProducto = LeerSeleccion.seleccionarProducto(productos, "modificar");
				
				nombreOriginal = productos[indiceProducto].nombre;
				categoriaOriginal =	productos[indiceProducto].categoria;
				precioOriginal = productos[indiceProducto].precio;
				
				do {
					tipoDato = LeerSeleccion.seleccionTipoDato(productos[indiceProducto]);
					switch (tipoDato) {
						case 1:
							productos[indiceProducto].nombre = RecogerDatoDeProducto.recogerNombre(productos);
							break;
						case 2:
							productos[indiceProducto].categoria = RecogerDatoDeProducto.recogerCategoria(productos[indiceProducto].categorias);
							break;
						case 3:
							productos[indiceProducto].precio = RecogerDatoDeProducto.recogerPrecio();
							break;
					}
					
					
				} while (MostrarMensajeDePeticion.menuOpciones("¿Desea modificar otro dato de este producto?", null, "Introduzca una opción") == 0);
					
				if (MostrarMensajeDePeticion.menuOpciones("¿Desea cancelar la operación?", null, "Introduzca una opción") == 0) {
						productos[indiceProducto].nombre = nombreOriginal;
						productos[indiceProducto].categoria = categoriaOriginal;
						productos[indiceProducto].precio = precioOriginal;
					}
				else 
					MostrarMensajeInformativo.msgOperacionRealizadaCorrectamente(2);
				
			} while (MostrarMensajeDePeticion.menuOpciones("¿Desea volver al menú principal?", null, "Introduzca una opción") == 1);
		}
		else
			MostrarMensajeDeError.mostrarError(9);
		return (productos);
	}
	
	/**
	 * Si existen productos en la máquina, se selecciona producto. Si no existen, se muestra un mensaje de error.
	 * Si la selección es correcta, se pide confirmacón para el borrado. Solo si se confirma la operación, se crea un array
	 * de productos copiando todos los productos del array originzal excepto el producto seleccionado, devolviendo el array
	 * modificado.
	 * Si no, se cancela la operación mostrando un mensaje y devuelve el array sin cambios.
	 * 
	 * @param productos - Array completo de productos disponibles en la máquina expendedora
	 * @return Array de productos modificado o sin modificar
	 */
	public static Producto[] eliminarProducto(Producto productos[]) {
	
		Producto	productosActualizados[];
		int			cantidadActual;
		int			indiceProductoSeleccionado = -1;
		cantidadActual = productos.length;

		if (cantidadActual > 0) {
			MostrarListaDeProductos.mostrarListaCompleta(productos);
			indiceProductoSeleccionado = LeerSeleccion.seleccionarProducto(productos, "eliminar");
			if (MostrarMensajeDePeticion.menuOpciones("¿Está segurx de eliminar este producto?", null, "Introduzca una opción") == 0) {
				productosActualizados = new Producto[cantidadActual - 1];
				int j = 0;
				for (int i = 0; i < cantidadActual; i++) {
						if (i != indiceProductoSeleccionado) {
							productosActualizados[j] = productos[i];
							j++;
						}
					}
				MostrarMensajeInformativo.msgOperacionRealizadaCorrectamente(3);
				return (productosActualizados);
			}
			System.out.println("\n\t\t------->>>> Cancelando... <<<<-------\n");
		}
		else
			MostrarMensajeDeError.mostrarError(9);
		return (productos);
	}
	
	/**
	 * Busca un producto por medio de su ID en el array de productos existentes en la máquina.
	 * 
	 * @param productos - Array completo de productos disponibles en la máquina expendedora
	 * @param idUnico - valor indicado como ID del supuesto producto
	 * @return El indice del producto si es encontrado, -1 en caso contrario.
	 */
	public static int buscarPorID(Producto productos[], int idUnico) {
		
		int		cantidadActual = productos.length;
		int		indiceActualProducto = -1;
		
		if (idUnico == 0) {
			MostrarMensajeDeError.mostrarError(10);
			return (0);
		}
		for (int i = 0; i < cantidadActual; i++) {
			if (idUnico == productos[i].idUnico)
				indiceActualProducto = i;
		}
		return (indiceActualProducto);
	}
	
	/**
	 * Se añade un producto a un array de productos que representa la cesta de la compra.
	 * 
	 * @param cestaDeCompra - Array con los productos añadidos en el proceso de compra.
	 * @param producto - producto que se pretende añadir al array de la cesta de la compra.
	 * @return El array de cesta de la compra con el producto añadido (actualizada).
	 */
	public static Producto[] añadirProductoALaCesta(Producto cestaDeCompra[], Producto producto) {
		
		Producto	productosActualizados[];
		int			cantidadActual;
		
		cantidadActual = cestaDeCompra.length;
			
		productosActualizados = new Producto[cantidadActual + 1];
		
		for (int i = 0; i < cantidadActual; i++) 
			productosActualizados[i] = cestaDeCompra[i];
		
		productosActualizados[cantidadActual] = producto;
		
		System.out.println("\n\n················································································································");
		System.out.printf("			---------->>> Se ha añadido 1 ud de %s CORRECTAMENTE ✔ <<<--------------\n", producto.nombre);
		System.out.println("················································································································\n");
		
		return (productosActualizados);
	}
	
	/**
	 * Pide saldo de manera consecutiva hasta que se alcance el precioTotal,
	 * posteriormente se calcula su cambio y este se desglosa en en los billetes/monedas mínimos.
	 * Va mostrando saldo introducido e importe pendiente.
	 * 
	 * @param precioTotal - valor a pagar por los productos comprados.
	 */
	public static void pasarelaDePago(double precioTotal) {
		
		double	dineroIntroducido = 0.0;
		double	faltante = precioTotal;
		String	entrada;
		boolean esCorrecto;
		double	cambio = 0.0;
		double	saldoAcumulado = 0.0;
		
		while (saldoAcumulado < precioTotal) {
			
			esCorrecto = false;
			
			do {	
				System.out.printf("\t·Saldo introducido: %.2f€\n\n", saldoAcumulado);

				System.out.printf("\t------>>>>>> Importe pendiente: %.2f€.\n\n", faltante);
				System.out.print("\t·····> Introduzca dinero, por favor: ");
				
				entrada = Main.teclado.nextLine().trim();

				if (ValidarTipoDeEntrada.estaDentroDeLimites(entrada) && ValidarTipoDeEntrada.checkSoloNumeroDecimal(entrada)) {
					dineroIntroducido = Double.parseDouble(entrada);
					if (saldoAcumulado + dineroIntroducido <= 250) {
						saldoAcumulado += dineroIntroducido;
						esCorrecto = true;
						}
					else
						MostrarMensajeDeError.mostrarError(12);
					}
				System.out.println();
			} while (!esCorrecto);
			
			if (saldoAcumulado < precioTotal) 
				faltante = precioTotal - saldoAcumulado;
		}
		
		cambio = saldoAcumulado - precioTotal;
		
		if (cambio > 0) {
			System.out.printf("\t·Su cambio es: %.2f€\n\n", cambio);
			desglosarCambio(cambio);
		}

		System.out.println("\n\n\t------>>>>>> Gracias por su compra <<<<<<------");
	}		

	/**
	 * Divide el cambio en billetes y monedas, y muestra la cantidad de cada uno de estos segun corresponda.
	 * 
	 * @param cambio - cantidad que debe desglosarse.
	 */
	private static void desglosarCambio(double cambio) {
		int [] billetes= {200, 100, 50, 20, 10, 5, 2, 1};
		int [] monedas= {50, 20, 10, 5, 2, 1};
		
		int euros=(int) cambio;
		int cent= (int) Math.round((cambio-euros)*100);
		
		System.out.println("\t\t·Desglose del cambio: ");
		
		for (int b : billetes) {
			int cantidad = euros / b;
			if( cantidad > 0) {
				System.out.printf("\t\t\t" + cantidad + " x "+ b + "€\n");
				euros%=b;
			}
		}
		
		for (int m: monedas) {
			int cantidad=cent/m;
			if(cantidad>0) {
				System.out.println("\t\t\t" + cantidad + " x " + m + " céntimos");
				cent%=m;
			}
		}
	
	}
}
