package modelo;

import controlador.*;
import vista.*;

public class Operaciones {

	public static Producto[] nuevoProducto(Producto productos[]) {
		
		Producto	nuevoProducto;
		Producto	productosActualizados[];
		int			cantidadActual;
		boolean		idUnico = false;
		int			id = 1;
		
		cantidadActual = Operaciones.contarTotalProductosActual(productos);
		nuevoProducto = new Producto();
				
		nuevoProducto.nombre = RecogerDatoDeProducto.recogerNombre(productos);
		nuevoProducto.categoria = RecogerDatoDeProducto.recogerCategoria(nuevoProducto.categorias);
		nuevoProducto.precio = RecogerDatoDeProducto.recogerPrecio();
		
		if (MostrarMensajeDePeticion.condicionDeseaCancelar())
			return (productos);
		
		productosActualizados = new Producto[cantidadActual + 1];
		
		for (int i = 0; i < cantidadActual; i++) 
			productosActualizados[i] = productos[i];
		productosActualizados[cantidadActual] = nuevoProducto;
		
		while (!idUnico) {
			if (ValidarDatoDeProducto.checkIDUnico(productosActualizados, id)) {
				nuevoProducto.idUnico = id;
				idUnico = true;
			}
			else
				id++;
		}
		MostrarMensajeOperacionCorrecta.msgProductoCreadoCorrectamente();
		return (productosActualizados);
	}
	
	public static Producto[] modificarproducto(Producto productos[]) {
		
		Producto	nuevoProducto;
		int			indiceProductoSeleccionado;
		int			tipoDato = -1;

		nuevoProducto = new Producto();

		do {
			MostrarListaDeProductos.mostrarListaCompleta(productos);
			indiceProductoSeleccionado = LeerSeleccionDeProducto.seleccionarProducto(productos, "modificar");
			nuevoProducto = productos[indiceProductoSeleccionado];
			
			do {
				tipoDato = LeerSeleccionDeProducto.eleccionTipoDato(nuevoProducto);
				switch (tipoDato) {
					case 1:
						nuevoProducto.nombre = RecogerDatoDeProducto.recogerNombre(productos);
						break;
					case 2:
						nuevoProducto.categoria = RecogerDatoDeProducto.recogerCategoria(nuevoProducto.categorias);
						break;
					case 3:
						nuevoProducto.precio = RecogerDatoDeProducto.recogerPrecio();
						break;
				}
			} while (MostrarMensajeDePeticion.condicionDeseaContinuar());
				
			if (MostrarMensajeDePeticion.condicionDeseaCancelar())
				nuevoProducto = productos[indiceProductoSeleccionado];
			else {
				productos[indiceProductoSeleccionado] = nuevoProducto;
				MostrarMensajeOperacionCorrecta.msgProductoModificadoCorrectamente();
			}
		} while (!MostrarMensajeDePeticion.condicionDeseaVolver());
		
		return (productos);
	}

	//alternativa mas sencilla
	public static Producto[] modificarProducto(Producto[] productos) {
		int			indiceProducto;
		int			tipoDato = -1;
		String		nombreOriginal;
		String		categoriaOriginal;
		double		precioOriginal;

		if (Operaciones.contarTotalProductosActual(productos) > 0) {
			do {
				MostrarListaDeProductos.mostrarListaCompleta(productos);
				indiceProducto = LeerSeleccionDeProducto.seleccionarProducto(productos, "modificar");
				
				nombreOriginal = productos[indiceProducto].nombre;
				categoriaOriginal =	productos[indiceProducto].categoria;
				precioOriginal = productos[indiceProducto].precio;
				do {
					tipoDato = LeerSeleccionDeProducto.eleccionTipoDato(productos[indiceProducto]);
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
					
					
				} while (MostrarMensajeDePeticion.condicionDeseaContinuar());
					
				if (MostrarMensajeDePeticion.condicionDeseaCancelar()) {
						productos[indiceProducto].nombre = nombreOriginal;
						productos[indiceProducto].categoria = categoriaOriginal;
						productos[indiceProducto].precio = precioOriginal;
					}
				else 
					MostrarMensajeOperacionCorrecta.msgProductoModificadoCorrectamente();
				
			} while (!MostrarMensajeDePeticion.condicionDeseaVolver());
		}
		else
			MostrarMensajeDeError.noHayNingunProducto();
		return (productos);
	}
	public static Producto[] eliminarProducto(Producto productos[]) {
	
		Producto	productosActualizados[];
		int			cantidadActual;
		int			indiceProductoSeleccionado = -1;
		cantidadActual = Operaciones.contarTotalProductosActual(productos);

		if (Operaciones.contarTotalProductosActual(productos) > 0) {
			indiceProductoSeleccionado = LeerSeleccionDeProducto.seleccionarProducto(productos, "eliminar");
			if (MostrarMensajeDePeticion.condicionConfirmaEliminar()) {
				productosActualizados = new Producto[cantidadActual - 1];
				int j = 0;
				for (int i = 0; i < cantidadActual; i++) {
						if (i != indiceProductoSeleccionado) {
							productosActualizados[j] = productos[i];
							j++;
						}
					}
				MostrarMensajeOperacionCorrecta.msgProductoEliminadoCorrectamente();
				return (productosActualizados);
			}
			System.out.println("\n\t\t------->>>>\tCancelando...\t<<<<-------\n");
		}
		else
			MostrarMensajeDeError.noHayNingunProducto();
		return (productos);
	}

	public static int contarTotalProductosActual(Producto productos[]) {
		
		int		total = 0;
		
		for (int i = 0; i < productos.length; i++) {
			if (productos[i] != null) 
					total++;
		}
		return (total);
	}
	
	public static int buscarPorID(Producto productos[], int idUnico) {
		
		int		cantidadActual = Operaciones.contarTotalProductosActual(productos);
		int		indiceActualProducto = -1;
		
		for (int i = 0; i < cantidadActual; i++) {
			if (idUnico == productos[i].idUnico)
				indiceActualProducto = i;
		}
		return (indiceActualProducto);
	}
}
