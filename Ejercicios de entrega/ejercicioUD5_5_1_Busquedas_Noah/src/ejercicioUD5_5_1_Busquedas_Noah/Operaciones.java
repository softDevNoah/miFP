package ejercicioUD5_5_1_Busquedas_Noah;

/**
 * Esta clase reune los métodos necesarios para manipular la matrix. Todas las operaciones son validadas para
 * evitar errores o desbordamientos
 */
public class Operaciones {

	/**
	 * Este método recibe un array de enteros (la matrix), revisa si contiene números y cuántos números,
	 * pide al usuario que se ingrese un valor por teclado y verifica, siempre que haya espacio disponible,
	 * si ese valor no se encuentra ya en la matrix. Si no está repetido, crea una nueva matrix, copia
	 * los valores de la original, en la última posición disponible coloca el valor nuevo y devuelve esta
	 * nueva matrix. Si no hubiera sido posible, muestra un mensaje de error y devuelve la matrix original.  
	 * 
	 * @param matrix - array de int que puede ser null o contener hasta 10 números
	 * @return matrix nueva si ha sido posible añadir el valor, o matrix original en caso contrario
	 */
	public static int[] ingresarValor(int matrix[]) {
		
		int tamaño = 0;
		int	matrixNueva[] = null;
		int	num;
		
		if (esPosibleOperar(matrix, 1)) {
			if (matrix == null) {
				matrixNueva = new int[1];
			}
			else {
				tamaño = matrix.length;
				matrixNueva = new int[tamaño + 1];
				matrixNueva = copiarValores(matrix, matrixNueva);
			}
			num = pedirNumero();
			if (localizaValor(num, matrix) == -1) {
				matrixNueva[tamaño] = num;
				return(matrixNueva);
			}
			else
				System.out.println("\t----->>>> Error: el número que quieres añadir ya está dentro de la matrix.");
		}
		else
			System.out.println("\t----->>>> Error: no queda espacio para nuevos valores.");
		
		return (matrix);
	}
	
	/**
	 * Este método recibe un array de enteros (la matrix), revisa si contiene números y cuántos números,
	 * pide al usuario que se ingrese un valor por teclado y verifica si dicho valor se encuentra ya en
	 * la matrix. Después, indica en un mensaje impreso en pantalla si el valor se encuentra y en qué
	 * posición o si no ha sido encontrado en la matrix.
	 * 
	 * @param matrix - array de int que puede ser null o contener hasta 10 números
	 */
	public static void encontrarValor(int matrix[]) {
		
		int index = -1, num;
		
		if (esPosibleOperar(matrix, 2))	{
			num = pedirNumero();
			index = localizaValor(num, matrix);
		}
		if (index != -1) {
			System.out.printf("\t - El valor que busca está en la posición nº %d de la matrix (las posiciones empiezan desde 0).\n\n", index);
		}
		else
			System.out.println("\t - El valor que busca no está en la matrix.\n");
	}

	/**
	 * Este método recibe un array de enteros (la matrix), revisa si contiene números y cuántos números,
	 * pide al usuario que se ingrese un valor por teclado y verifica que contenga algún número y que
	 * ese valor se encuentre ya en la matrix. Si no está, muestra un mensaje de error por pantalla, 
	 * y devuelve la matrix original. Si está el valor dentro de la matrix, crea una nueva matrix y copia
	 * todos los valores excepto el indicado por el usuario, y devuelve la nueva matrix. 
	 * 
	 * @param matrix - array de int que puede ser null o contener hasta 10 números
	 * @return matrix nueva si ha sido posible eliminar el valor, o matrix original en caso contrario
	 */
	public static int[] eliminarValor(int matrix[]) {
	
		int num, index = -1;
		int	matrixNueva[] = null;
		
		if (esPosibleOperar(matrix, 3))	{
			num = pedirNumero();
			index = localizaValor(num, matrix);
			if (index != -1) {
				if (matrix.length == 1)
					return (null);
				matrixNueva = new int[matrix.length - 1];
				for (int i = 0, j = 0; i < matrixNueva.length; i++, j++) {
					if (num == matrix[i])
						j++;
					matrixNueva[i] = matrix[j];
					
				}
				return (matrixNueva);
			}
			else
				System.out.println("\t----->>>> Error: el nº que desea eliminar no está en la matrix.");
		}
		else
			System.out.println("\t----->>>> Error: la matrix está ya vacía.");
		return(matrix);
	}
	
	/**
	 * Este método recibe un array de enteros (la matrix), revisa si contiene números y cuántos números,
	 * y verifica que contenga algún número y que el valor de num se encuentre ya en la matrix.
	 * Si no está, devuelve -1. Si está el valor dentro de la matrix, devuelve el índice donde se encuentra
	 * dentro de la matrix. 
	 * 
	 * @param num - número entero introducido previamente por el usuario que se desea localizar
	 * @param matrix - array de int que puede ser null o contener hasta 10 números
	 * @return index - número entero que representa la posición dentro del array o un valor que representa que no está
	 */
	private static int localizaValor(int num, int matrix[]) {
		
		int	index = -1;
		
		if (matrix != null) {
			for (int i = 0; i < matrix.length; i++) {
				if (matrix[i] == num)
					index = i;
			}
		}
		return(index);
	}
	
	/**
	 * Este método recibe un array de enteros (la matrix), revisa si contiene números y cuántos números,
	 * y verifica que cumple los requisitos para realizar una operacion, indicada con un entero por 
	 * parámetros. Si es posible realizar la operación, devuelve true, en caso contrario false. 
	 * 
	 * @param matrix - array de int que puede ser null o contener hasta 10 números
	 * @return boolean esPosible, con valor true si se puede realizar la operacion indicada o false en caso contrario
	 */
	private static boolean esPosibleOperar(int matrix[], int operacion) {
		
		boolean	esPosible = true;

		switch (operacion) {
			case 1:
				if (matrix != null && matrix.length == 10)
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
	 * Este método recibe un array de enteros (la matrix), un array de enteros (matrixNueva), y
	 * copia los valores de la original a la nueva.
	 *  
	 * @param matrix - array de int que puede ser null o contener hasta 10 números
	 * @return matrixNueva - array de int con los valores ya copiados
	 */
	private static int[] copiarValores(int matrixOriginal[], int matrixNueva[]) {
		
		for (int i = 0; i < matrixOriginal.length; i++)
			matrixNueva[i] = matrixOriginal[i];

		return (matrixNueva);
	}
	
	/**
	 * Este método revisa un String que recibe por parámetro para verificar si su contenido es
	 * exclusivamente un número entero. Devuelve un boolean con el resultado de dicha verificación.
	 * 
	 * @param entrada - String cuyo contenido será verificado
	 * @return boolean esCorrecto con valor true si efectivamente es un número entero o false en caso contrario.
	 */
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
	
	/**
	 * Este método solicita por teclado al usuario wque introduzca un número entero, luego verifica que lo que
	 * se ha introducido es efectivamente un número entero y cuando lo es, lo devuelve. Si no lo es, vuelve a pedirlo
	 * nuevamente.
	 * 
	 * @return int num - número introducido por el usuario que ha sido validado
	 */
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
	
	/**
	 * Este método imprime con formato una matrix (array de int) que recibe por parámetro, con un formato
	 * determinado.
	 * 
	 * @param matrix - array de int que puede ser null o contener hasta 10 números
	 */
	public static void mostrarMatrix(int matrix[]) {
		
		MainBusquedas.pintarLinea("* ", 50);
		System.out.print("\t\t\t----- MATRIX -----\n");
	
		if (matrix != null) {
			System.out.print("\n\t\t|  ");
			for ( int i = 0; i < matrix.length; i++) {
				System.out.printf("%d  |  ", matrix[i]);
			}
		}
		else {
			MainBusquedas.pintarLinea("... estoy vacía ... :( ...", 3);
		}
		
		System.out.println();
		MainBusquedas.pintarLinea("* ", 50);
		
		
	}
}
