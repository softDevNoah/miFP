package ejercicioUD6_2_Objetos_entrega1_Noah;

/**
 * Clase que contiene los atributos de un taxi y los métodos necesarios para instanciar
 * un objeto de esta clase, asignar valores a los atributos de dicho objeto y obtener
 * los valores que tiene dicho objeto.
 * Los atributos son privados por lo que se usan getters y setters.
 */
public class Taxi {

	private String	provincia; //se pide que tenga el atributo pero luego no se pide getter ni setter...
	private String	matricula;
	private String	municipio;
	private String	motor;
	
	/**
	 * Este es el constructor sin parámetros que establece los valores por defecto.
	 */
	public Taxi() {
		provincia = "Bizkaia";
		matricula = "VACIO";
		municipio = "VACIO";
		motor = "VACIO";
	}
	
	/**
	 * Este es el constructor de esta clase que recibe por parámetros los valores que se deben asignar
	 * al objeto creado.
	 * 
	 * @param matricula - String que será la matrícula del objeto de clase Taxi
	 * @param municipio - String que será el municipio del objeto de clase Taxi
	 * @param tipoMotor - int que indica el tipo de motor (es el índice de un array de
	 * 						String con los tipos de motor posibles) del objeto de clase Taxi.
	 */
	public Taxi(String matricula, String municipio, int tipoMotor) {
		provincia = "Bizkaia";
		setMatricula(matricula);
		setMunicipio(municipio);
		setTipoMotor(tipoMotor);
	}
	
	/**
	 * Setter para asignar de forma segura un valor al atributo matricula de un objeto de clase Taxi.
	 * @param matricula - String con el valor al atributo matrícula de un objeto de clase Taxi que se asignará
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	/**
	 * Getter para obtener de forma segura el valor del atributo matricula de un objeto de clase Taxi.
	 * 
	 * @return String matricula - valor del atributo matricula del objeto Taxi
	 */
	public String getMatricula() {
		return (matricula);
	}
	
	/**
	 * Setter para asignar de forma segura un valor al atributo municipio de un objeto de clase Taxi.
	 * 
	 * @param municipio - String con el valor al atributo municipio de un objeto de clase Taxi que se asignará
	 */
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	/**
	 * Getter para obtener de forma segura el valor del atributo municipio de un objeto de clase Taxi.
	 * 
	 * @return String municipio - valor del atributo municipio del objeto Taxi
	 */
	public String getMunicipio() {
		return (municipio);
	}
	
	/**
	 * Setter para asignar de forma segura un valor al atributo motor de un objeto de clase Taxi.
	 * 
	 * @param tipoMotor - int que hace de indice para señalar el tipo de motor del objeto Taxi
	 */
	public void setTipoMotor(int tipoMotor) {
		
		String TiposMotor[] = {"desconocido", "diesel", "gasolina"};
		
		if (tipoMotor >= 0 && tipoMotor < 3)
			this.motor = TiposMotor[tipoMotor];
	}
	
	/**
	 * Getter para obtener de forma segura el valor del atributo motor de un objeto de clase Taxi.
	 * 
	 * @return motor - atributo motor del objeto Taxi
	 */
	public String getTipoMotor() {
		return (motor);
	}
	
	/**
	 * Setter para asignar de forma segura un valor al atributo provincia de un objeto de clase Taxi.
	 * 
	 * @return String provincia - valor del atributo provincia del objeto Taxi
	 */
	public String getProvincia() {
		return (provincia);
	}
}
