package ejercicioUD5_5_1_Busquedas_Noah;

/**
 * 
 */
public class Operaciones {

	/**
	 * 
	 * @param matrix
	 * @return
	 */
	public static int[] ingresarValor(int matrix[]) {
		
		int tamaño = 0;
		int	matrixNueva[] = null;
		
		if (esPosibleOperar(matrix, 1)) {
			if (matrix == null) {
				matrixNueva = new int[1];
			}
			else {
				tamaño = matrix.length;
				matrixNueva = new int[tamaño + 1];
				matrixNueva = copiarValores(matrix, matrixNueva);
			}
			matrixNueva[tamaño] = pedirNumero();
		}
		return(matrixNueva);
	}
	
	/**
	 * 
	 * @param matrix
	 * @return
	 */
	public static int[] encontrarValor(int matrix[]) {
		
		if (esPosibleOperar(matrix, 2))	{
			;
		}
		
		return(matrix);
	}

	/**
	 * 
	 * @param matrix
	 * @return
	 */
	public static int[] eliminarValor(int matrix[]) {
	
		if (esPosibleOperar(matrix, 3))	{
			;
		}
		
		return(matrix);
	}
	
	/**
	 * 
	 * @param matrix
	 * @return
	 */
	private static int localizaValor(int matrix[]) {
		
		int	index = -1;
		
		
		return(index);
	}
	
	/**
	 * 
	 * @param matrix
	 * @return
	 */
	private static boolean esPosibleOperar(int matrix[], int operacion) {
		
		boolean	esPosible = true;

		switch (operacion) {
			case 1:
				if ((matrix != null && matrix.length < 10) || matrix == null)
					esPosible = false;
				break;
			case 2:
				if (matrix == null)
					esPosible = false;
				break;
			case 3:
				if (matrix == null)
					esPosible = false;
				break;
		}
		
		return (esPosible);
	}

	/**
	 * 
	 * @param matrix
	 * @return
	 */
	private static int[] copiarValores(int matrixOriginal[], int matrixNueva[]) {
		
		for (int i = 0; i < matrixOriginal.length; i++)
			matrixNueva[i] = matrixOriginal[i];

		return (matrixNueva);
	}
	
	private static boolean checkNumero(String entrada) {
		
		boolean esCorrecto = true;

		if (!entrada.isBlank()) {
		
			if (entrada.length() <= 8) {
				for (int i = 0; i < entrada.length(); i++) {
					if (i == 0 && entrada.charAt(i) == '+' || i == 0 && entrada.charAt(i) == '-')
						i++;	
					if (!Character.isDigit(entrada.charAt(i)))
						esCorrecto = false;
				}
				
				if (!esCorrecto)
					System.out.println("\n\t----->>>> Error: introduzca un número entero, por favor.");
			}
			else {
				System.out.println("\n\t----->>>> Error: solo se permite introducir números del -9999999 hasta el 99999999.");
				esCorrecto = false;
			}
		}
		else
			esCorrecto = false;
		return (esCorrecto);
	}
	
	private static int pedirNumero() {
		
		int 	num = 0;
		boolean	esCorrecto;
		
		do {
			esCorrecto = false;
			System.out.print("\t- Por favor, introduzca un número entero: ");
			MainBusquedas.entrada = MainBusquedas.teclado.nextLine().trim();
			if (checkNumero(MainBusquedas.entrada)) {
				esCorrecto = true;
				num = Integer.parseInt(MainBusquedas.entrada);
			}
		} while (!esCorrecto);
		System.out.println();
		return (num);
	}
}
