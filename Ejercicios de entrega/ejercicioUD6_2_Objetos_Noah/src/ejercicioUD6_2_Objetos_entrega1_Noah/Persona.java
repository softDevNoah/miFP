package ejercicioUD6_2_Objetos_entrega1_Noah;

/**
 * Esta clase contiene atributos de una Persona, y los métodos para obtener y setear de forma segura
 * los valores de sus atributos
 */
public class Persona {


	private String		nombre; //se pide que tenga el atributo pero luego no se pide getter ni setter...
	private String		apellido;
	private int			edad;
	private boolean		casado;
	private String		numeroDocumentoIdentidad;
	
	/**
	 * Este es el constructor sin parámetros que establece los valores por defecto.
	 */
	public Persona() {
		nombre = "VACIO";
		apellido = "VACIO";
		edad = 0;
		casado = false;
		numeroDocumentoIdentidad = "VACIO";
	}
	
	/**
	 * Este es el constructor de esta clase que recibe por parámetros los valores que se deben asignar a los atributos
	 * del objeto Persona creado.
	 * 
	 * @param nombre - String que será el nombre del objeto de clase Persona
	 * @param apellido - String que será el apellido  del objeto de clase Persona
	 * @param edad - int que será la edad del objeto de clase Persona
	 * @param casado - boolean que será el estado civil del objeto de clase Persona
	 * @param numeroDocumentoIdentidad -  String que será el nº del documento de identidad del objeto de clase Persona
	 */
	public Persona(String nombre, String apellido, int edad, boolean casado, String numeroDocumentoIdentidad) {
		setNombre(nombre);
		setApellido(apellido);
		setEdad(edad);
		setCasado(casado);
		setNumeroDocumentoIdentidad(numeroDocumentoIdentidad);
	}
	
	/**
	 * Setter para asignar de forma segura un valor al atributo nombre de un objeto de clase Persona.
	 * 
	 * @param nombre - String con el valor al atributo nombre de un objeto de clase Persona que se asignará
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Getter para obtener de forma segura el valor del atributo nombre de un objeto de clase Persona.
	 * 
	 * @return String nombre - valor del atributo nombre del objeto Persona
	 */
	public String getNombre() {
		return (nombre);
	}
	
	/**
	 * Setter para asignar de forma segura un valor al atributo apellido de un objeto de clase Persona.
	 * @param apellido - String con el valor al atributo apellido de un objeto de clase Persona que se asignará
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	/**
	 * Getter para obtener de forma segura el valor del atributo apellido de un objeto de clase Persona.
	 * 
	 * @return String apellido - valor del atributo apellido del objeto Persona
	 */
	public String getApellido() {
		return (apellido);
	}
	
	/**
	 * Setter para asignar de forma segura un valor al atributo edad de un objeto de clase Persona.
	 * @param edad - int con el valor al atributo edad de un objeto de clase Persona que se asignará
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	/**
	 * Getter para obtener de forma segura el valor del atributo edad de un objeto de clase Persona.
	 * 
	 * @return int matricula - valor del atributo edad del objeto Persona
	 */
	public int getEdad() {
		return (edad);
	}
	
	/**
	 * Setter para asignar de forma segura un valor al atributo casado de un objeto de clase Persona.
	 * 
	 * @param municipio - boolean con el valor al atributo casado de un objeto de clase Persona que se asignará
	 */
	public void setCasado(boolean casado) {
		this.casado = casado;
	}

	/**
	 * Getter para obtener de forma segura el valor del atributo casado de un objeto de clase Persona.
	 * 
	 * @return boolean municipio - valor del atributo casado del objeto Persona, false es soltero y true casado
	 */
	public boolean getCasado() {
		return (casado);
	}
	
	/**
	 * Setter para asignar de forma segura un valor al atributo numeroDocumentoIdentidad de un objeto de clase Persona.
	 * 
	 * @param numeroDocumentoIdentidad - String que es el numeroDocumentoIdentidad del objeto Persona que se asignará
	 */
	public void setNumeroDocumentoIdentidad(String numeroDocumentoIdentidad) {
		this.numeroDocumentoIdentidad = numeroDocumentoIdentidad;
	}
	
	/**
	 * Getter para obtener de forma segura un valor del atributo numeroDocumentoIdentidad de un objeto de clase Persona.
	 * 
	 * @return String numeroDocumentoIdentidad - valor del atributo numeroDocumentoIdentidad del objeto Persona
	 */
	public String getNumeroDocumentoIdentidad() {
		return (numeroDocumentoIdentidad);
	}
}
