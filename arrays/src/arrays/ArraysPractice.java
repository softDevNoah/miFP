package arrays;

public class ArraysPractice {

	public static void main(String[] args) {
		
		String nombres[] = new String[5];
		
		nombres[0] = "Solagne";
		nombres[1] = "Danilo";
		nombres[2] = "Bea";
		nombres[3] = "Hanae";
		nombres[4] = "Efrain";
		
		/*System.out.println(nombres[0]);
		System.out.println(nombres[1]);
		System.out.println(nombres[2]);
		System.out.println(nombres[3]);
		System.out.println(nombres[4]);*/
		
		/*for (int i = 0; i < 5; i++) {
			System.out.println(nombres[i]);
		}*/
		for (int i = 0; i < nombres.length; i++) {
			System.out.println(nombres[i]);
		}
	}

}
