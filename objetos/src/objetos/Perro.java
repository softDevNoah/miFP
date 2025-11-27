package objetos;

public class Perro {

	String	nombre;
	int		edad;
	boolean	vacunado;
	boolean	esterilizado;
	double	peso;
	char	sexo;
	String	tipoPelaje;
	String	raza;
	
	public Perro() {
		nombre = "VACIO";
		edad = -1;
		vacunado = false;
		esterilizado = false;
		peso = -1.0;
		sexo = 'n';
		tipoPelaje = "VACIO";
		raza = "VACIO";
	}
	
	public Perro(String nombre, int edad, boolean vacunado, boolean esterilizado, double peso, char sexo, String tipoPelaje, String raza) {
		
		this.nombre = nombre;
		this.edad = edad;
		this.vacunado = vacunado;
		this.esterilizado = esterilizado;
		this.peso = peso;
		this.sexo = sexo;
		this.tipoPelaje = tipoPelaje;
		this.raza = raza;
	}
	
	public static void ladrar(int veces) {
		
		String	vocalizacion = "Guau!!";
		for (int i = 0; i < veces; i++)
			System.out.print(vocalizacion + " ");
		System.out.println();
	}
}
