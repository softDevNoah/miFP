package ejercicioUD6_2_Objetos_entrega1_Noah;

/**
 * Clase para crear un coche y determinar la velocidad a la que va.
 */
public class Coche {
	
	private int velocidad;
	
	/**
	 * Constructor que setea a cero la velocidad del coche.
	 */
	public Coche() {
	
		velocidad = 0;
		
	}
	
	/**
	 * Método que obtiene de forma segura la velocidad actual del coche.
	 * 
	 * @return velocidad - int de los km/h a los que va el coche.
	 */
	public int getVelocidad() {
		return (velocidad);
	}
	
	/**
	 * Método que hace que el coche acelere lo que indica el int recibido por parámetro.
	 * 
	 * @param mas - (int) km/h que acelerará el coche
	 */
	void acelera(int mas) {
		velocidad += mas; 
	}
	
	/**
	 * Método que hace que el coche frene lo que indica el int recibido por parámetro.
	 * 
	 * @param menos - (int) km/h que desacelerará el coche
	 */
	void frena(int menos) {
		velocidad -= menos;
		if (velocidad < 0)
			velocidad = 0;
	}
}
