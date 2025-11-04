package modelo;

import controlador.*;
import vista.*;

public class Operaciones {

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
		
		if (MsgPeticion.menuOpciones("¿Desea cancelar y volver atrás?", null, "Introduzca una opción") == 0)
			return (productos);
		
		productosActualizados = new Producto[cantidadActual + 1];
		
		for (int i = 0; i < cantidadActual; i++) 
			productosActualizados[i] = productos[i];

		productosActualizados[cantidadActual] = nuevoProducto;
		
		MostrarMensajeInformativo.msgOperacionRealizadaCorrectamente(1);
		return (productosActualizados);
	}

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
					
					
				} while (MsgPeticion.menuOpciones("¿Desea modificar otro dato de este producto?", null, "Introduzca una opción") == 0);
					
				if (MsgPeticion.menuOpciones("¿Desea cancelar la operación?", null, "Introduzca una opción") == 0) {
						productos[indiceProducto].nombre = nombreOriginal;
						productos[indiceProducto].categoria = categoriaOriginal;
						productos[indiceProducto].precio = precioOriginal;
					}
				else 
					MostrarMensajeInformativo.msgOperacionRealizadaCorrectamente(2);
				
			} while (MsgPeticion.menuOpciones("¿Desea volver al menú principal?", null, "Introduzca una opción") == 1);
		}
		else
			MostrarMensajeDeError.mostrarError(9);
		return (productos);
	}
	
	
	public static Producto[] eliminarProducto(Producto productos[]) {
	
		Producto	productosActualizados[];
		int			cantidadActual;
		int			indiceProductoSeleccionado = -1;
		cantidadActual = productos.length;

		if (cantidadActual > 0) {
			MostrarListaDeProductos.mostrarListaCompleta(productos);
			indiceProductoSeleccionado = LeerSeleccion.seleccionarProducto(productos, "eliminar");
			if (MsgPeticion.menuOpciones("¿Está segurx de eliminar este producto?", null, "Introduzca una opción") == 0) {
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
			System.out.println("\n\t\t------->>>>\tCancelando...\t<<<<-------\n");
		}
		else
			MostrarMensajeDeError.mostrarError(9);
		return (productos);
	}
	
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
	
	public static Producto[] añadirProductoALaCesta(Producto cestaDeCompra[], Producto producto) {
		
		Producto	productosActualizados[];
		int			cantidadActual;
		double		precioTotal;
		
		cantidadActual = cestaDeCompra.length;
			
		productosActualizados = new Producto[cantidadActual + 1];
		
		for (int i = 0; i < cantidadActual; i++) 
			productosActualizados[i] = cestaDeCompra[i];
		
		productosActualizados[cantidadActual] = producto;
		
		precioTotal = calcularPrecioTotal(0, productosActualizados);

		MostrarListaDeProductos.mostrarCestaCompra(productosActualizados, precioTotal);
		
		return (productosActualizados);
	}
	
	public static double calcularPrecioTotal(int iva, Producto cestaDeCompra[]) {
		double precioTotal = 0;
		
		for (int i = 0; i < cestaDeCompra.length; i++) 
			precioTotal += cestaDeCompra[i].precio;
		if (iva == 0)
			return (precioTotal);
		return (precioTotal *= 1.21);
	}
}
