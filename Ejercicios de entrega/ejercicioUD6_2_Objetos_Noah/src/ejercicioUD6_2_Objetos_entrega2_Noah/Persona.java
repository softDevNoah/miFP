package ejercicioUD6_2_Objetos_entrega2_Noah;

/**
 * Clase bastante completa de una persona. Tiene atributos y métodos bastante útiles.
 */
public class Persona {

	private final char SEXO_POR_DEFECTO = 'M';
	
	private String	nombre = "VACIO";
	private int		edad = -1;
	private String	dni = "VACIO";
	private char	sexo = SEXO_POR_DEFECTO;
	private double	peso = -1.0;
	private double	altura = -1.0;
	
	/**
	 * Constructor vacío que instancia un objeto Persona con los datos por defecto
	 */
	public Persona() {
		
	}
	
	/**
	 * Constructor parcialmente vacío que instancia un objeto Persona con los datos por defecto,
	 * excepto el nombre, la edad y el sexo.
	 * 
	 * @param nombre - nombre que se asignará
	 * @param edad - edad que se asignará
	 * @param sexo - sexo que se asignará
	 */
	public Persona(String nombre, int edad, char sexo) {
		
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
	}
	
	/**
	 * Constructor que recibe por parámetro todos los valores de todos los atributos para un objeto Persona.
	 * De este modo se sobrescriben los valores que tendría por defecto.
	 * 
	 * @param nombre - String que se asignará a la persona como nombre
	 * @param edad - int que se asignará a la persona como edad
	 * @param dni - String que se asignará a la persona como dni
	 * @param sexo - char que se asignará a la persona como sexo
	 * @param peso - double que se asignará a la persona como peso
	 * @param altura - double que se asignará a la persona como altura
	 */
	public Persona(String	nombre, int edad, String dni, char sexo, double peso, double altura) {
		
		this.nombre = nombre;
		this.edad = edad;
		this.dni = dni;
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
	}
	
	/**
	 * Método que analiza la altura y el peso de la persona y devuelve un valor para señalar si la
	 * persona está por debajo, dentro o por encima del umbral saludable según la fórmula del IMC.
	 * La fórmula es peso / (altura * altura).
	 * @return int indicador - Devolverá -1 si está debajo del umbral saludable, 1 si está por encima, y 0 si está dentro del umbral saludable.
	 */
	public int calcularIMC() {
		
		double 	imc = peso / (altura * altura);
		
		if (imc < 20)
			return (-1);
		
		if (imc > 25)
			return (1);
		
		return (0);
	}
	
	/**
	 * Este sencillo método analiza la edad de la persona y devuelve un booleano para indicar si es mayor o menor de edad.
	 * @return false si es menor de 18 años y true si tiene 18 o más años.
	 */
	public boolean esMayorDeEdad() {
	
		if (edad < 18)
			return (false);
		
		return (true);
	}
	
	/**
	 * Este método analiza si el sexo recibido es el char M, que es el valor por defecto. De ser un dato incorrecto o de
	 * no ser M, se asignará H en cualquiera de los casos.
	 * @param sexo - caracter que se contrastará con el valor por defecto de la clase
	 */
	public void comprobarSexo(char sexo) {
		if (sexo != SEXO_POR_DEFECTO)
			this.sexo = 'H';
	}
	
	/**
	 * Este método transforma todos los atributos a Strings y los concatena a uno solo, poniendo como separador entre
	 * cada atributo un punto y coma para un posterior split.
	 * Finalmente lo devuelve.
	 * @return datos - String con todos los atributos dentro, separados por ; (punto y coma)
	 */
	public String toString() {
		
		String edad, sexo, peso, altura, datos;
		edad = Integer.toString(this.edad);
		sexo = Character.toString(this.sexo);
		peso = Double.toString(this.peso);
		altura = Double.toString(this.altura);
		
		datos = this.nombre + ";" + edad + ";" + this.dni + ";" + sexo + ";" + peso + ";" + altura;
		
		return (datos);
	}
	
	/**
	 * Este método genera un dni aleatorio para la persona, según el algortimo que existe para que un dni sea válido.
	 * @return dni - String con el resultado generado compactado en un solo String
	 */
	public void generaDNI() { //la formula no es complicada y esta en internet
		
		int		resto;
		char	letras[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
		/*Las letras del array de char letras[], no son accidentalmente así. Según el algoritmo para el dni debe ser así.*/
		String	dni;
		
		int num = (int)Math.random() * 100000000;
		
		resto = num % 23;
		
		dni = Integer.toString(num) + letras[resto];
		
		this.dni = dni;
	}

	/**
	 * Obtiene el atributo nombre de la persona de forma segura
	 * @return el nombre de la persona
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Asigna el atributo nombre de la persona de forma segura
	 * @param nombre que se va a asignar 
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene el atributo edad de la persona de forma segura
	 * @return edad de la persona
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * Asigna el atributo edad de la persona de forma segura
	 * @param edad que se va a asignar 
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * Obtiene el atributo sexo de la persona de forma segura
	 * @return el sexo de la persona
	 */
	public char getSexo() {
		return sexo;
	}

	/**
	 * Asigna el atributo sexo de la persona de forma segura
	 * @param sexo  que se va a asignar 
	 */
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	/**
	 * Obtiene el atributo peso de la persona de forma segura
	 * @return el peso de la persona 
	 */
	public double getPeso() {
		return peso;
	}

	/**
	 * Asigna el atributo peso de la persona de forma segura
	 * @param peso  que se va a asignar 
	 */
	public void setPeso(double peso) {
		this.peso = peso;
	}

	/**
	 * Obtiene el atributo altura de la persona de forma segura
	 * @return la altura de la persona
	 */
	public double getAltura() {
		return altura;
	}

	/**
	 * Asigna el atributo altura de la persona de forma segura
	 * @param altura que se va a asignar 
	 */
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	
}
