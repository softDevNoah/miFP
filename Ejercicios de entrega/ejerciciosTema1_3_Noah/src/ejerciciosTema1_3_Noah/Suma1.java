package ejerciciosTema1_3_Noah;

public class Suma1 {

	public static void main(String[] args) {
	
		int n1=50;
		int n2=30, suma=0, n3;	//error1: falta inicializar n3
		suma=n1+n2;
		
		System.out.println("LA SUMA ES: "+suma);
		//inicializo n3 antes de usarlo
		n3 = 20;
		suma=suma+n3;
		System.out.println("LA NUEVA SUMA ES: "+suma);//actualizo el msg impreso por pantalla
	}
}
