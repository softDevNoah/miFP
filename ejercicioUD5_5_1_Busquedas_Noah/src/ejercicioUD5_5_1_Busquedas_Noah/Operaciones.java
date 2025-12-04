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
		
		if (esPosibleOperar(matrix, 1)) {
			;
		}
		return(matrix);
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
	
}
