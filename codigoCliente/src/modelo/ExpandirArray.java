package modelo;

public interface ExpandirArray {

	public static double[][] expandirArrayDouble(double[][] arrayAntiguo, double[][] arrDatosNuevos) {
		int numFilasAntiguo = arrayAntiguo.length;
		int numColAntiguo = (numFilasAntiguo > 0) ? arrayAntiguo[0].length : 0;
		int numFilasDatosNuevos = arrDatosNuevos.length;
		int numColDatosNuevos = arrDatosNuevos[0].length;
		double[][] arrayExpandido;

		if (numFilasAntiguo == 0) {
			arrayExpandido = new double[numFilasDatosNuevos][numColDatosNuevos];

			for (int i = 0; i < numFilasDatosNuevos; i++) {
				for (int j = 0; j < numColDatosNuevos; j++) {
					arrayExpandido[i][j] = arrDatosNuevos[i][j];
				}
			}
		} else {
			arrayExpandido = new double[numFilasAntiguo + numFilasDatosNuevos][numColAntiguo];

			for (int i = 0; i < numFilasAntiguo; i++) {
				for (int j = 0; j < numColAntiguo; j++) {
					arrayExpandido[i][j] = arrayAntiguo[i][j];
				}
			}

			for (int i = 0; i < numFilasDatosNuevos; i++) {
				for (int j = 0; j < numColDatosNuevos; j++) {
					arrayExpandido[numFilasAntiguo + i][j] = arrDatosNuevos[i][j];
				}
			}

		}

		return arrayExpandido;
	}
	
	public static String[][] expandirArrayString(String[][] arrayAntiguo, String[][] arrDatosNuevos) {
		int numFilasAntiguo = arrayAntiguo.length;
		int numColAntiguo = (numFilasAntiguo > 0) ? arrayAntiguo[0].length : 0;
		int numFilasDatosNuevos = arrDatosNuevos.length;
		int numColDatosNuevos = arrDatosNuevos[0].length;
		String[][] arrayExpandido;

		if (numFilasAntiguo == 0) {
			arrayExpandido = new String[numFilasDatosNuevos][numColDatosNuevos];

			for (int i = 0; i < numFilasDatosNuevos; i++) {
				for (int j = 0; j < numColDatosNuevos; j++) {
					arrayExpandido[i][j] = arrDatosNuevos[i][j];
				}
			}
		} else {
			arrayExpandido = new String[numFilasAntiguo + numFilasDatosNuevos][numColAntiguo];

			for (int i = 0; i < numFilasAntiguo; i++) {
				for (int j = 0; j < numColAntiguo; j++) {
					arrayExpandido[i][j] = arrayAntiguo[i][j];
				}
			}

			for (int i = 0; i < numFilasDatosNuevos; i++) {
				for (int j = 0; j < numColDatosNuevos; j++) {
					arrayExpandido[numFilasAntiguo + i][j] = arrDatosNuevos[i][j];
				}
			}

		}

		return arrayExpandido;
	}
	
	public static String[][] elegirProductoDelArray(String[][] arrayAntiguo, String[][] arrayTipo, int fila) {
		int numColDatosNuevos = arrayTipo[0].length;
		String[][] arrayExpandido;

		arrayExpandido = new String[1][numColDatosNuevos];

		for (int i = fila; i == fila; i++) {
			for (int j = 0; j < numColDatosNuevos; j++) {
				arrayExpandido[0][j] = arrayTipo[i][j];
			}
		}

		return arrayExpandido;
	}

}
