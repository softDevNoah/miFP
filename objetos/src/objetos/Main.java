package objetos;

public class Main {

	public static void main(String[] args) {
		
		Perro p1 = new Perro();
		Perro p2 = new Perro();	
			
		if (p1.equals(p2))
			System.out.println("Son iguales");
		else
			System.out.printf("No son iguales: " + p1.toString()  + " y " + p2.toString());
	}
}
