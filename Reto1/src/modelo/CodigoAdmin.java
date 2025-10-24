package modelo;

public class CodigoAdmin {

	public static BaseDeDatos ejecutarAdmin(BaseDeDatos baseDeDatosMasActual) {
		
		boolean		sesionIniciada;	
		sesionIniciada = IniciarSesion.intentoDeInicio(baseDeDatosMasActual.administradores);
		
		while (sesionIniciada) {
			//MostrarMenuAdmin.
		}
		return (baseDeDatosMasActual);
	}
	
}
