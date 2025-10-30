package vista;

public class Productos {

	public static void imprimirDouble(double[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				System.out.println(String.format("valor fila %d: %f", i, array[i][j]));
			}
		}
	}

	public static void mostrarProductos(String[][] array) {
		String id = "";
		String tipo = "";
		String producto = "";
		String precio = "";
		String resultado = "";

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				id = array[i][0];
				tipo = array[i][1];
				producto = array[i][2];
				precio = array[i][3];
			}
			resultado += String.format("\t%d. %s %s\n", i+1, producto, precio);
			
		}
		
		System.out.printf("\n%s\n", resultado);
	}

}
