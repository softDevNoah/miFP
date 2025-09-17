package ejerciciosTema1_3_Noah;

public class Ejercicio4 {

	//4.-¿Qué mostrará el siguiente código por pantalla?:
	public static void main(String[] args) {
		
		int num=5;
		num += num -1 *4 +1;	//primero se realizará la multiplicación, por la prioridad de operadores
		/*Sería así como operaría:
		num = num + num - (1 * 4) + 1; es decir num = 5 + 5 - 4 + 1 => 5 + 1 + 1;*/
		
		System.out.println (num);
		num=4;	//aqui se sobreescribe el valor de num
		System.out.println (num);
	}

}
