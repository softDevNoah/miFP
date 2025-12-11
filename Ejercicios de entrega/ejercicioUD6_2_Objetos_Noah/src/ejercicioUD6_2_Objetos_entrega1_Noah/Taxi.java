package ejercicioUD6_2_Objetos_entrega1_Noah;

/**
 * 
 */
public class Taxi {

	private String	provincia; //se pide que tenga el atributo pero luego no se pide getter ni setter...
	private String	matricula;
	private String	municipio;
	private String	motor;
	
	/**
	 * 
	 */
	public Taxi() {
		provincia = "Bizkaia";
		matricula = "VACIO";
		municipio = "VACIO";
		motor = "VACIO";
	}
	
	/**
	 * 
	 * @param matricula
	 * @param municipio
	 * @param tipoMotor
	 */
	public Taxi(String matricula, String municipio, int tipoMotor) {
		provincia = "Bizkaia";
		setMatricula(matricula);
		setMunicipio(municipio);
		setTipoMotor(tipoMotor);
	}
	
	/**
	 * 
	 * @param matricula
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getMatricula() {
		return (matricula);
	}
	
	/**
	 * 
	 * @param municipio
	 */
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	/**
	 * 
	 * @return
	 */
	public String getMunicipio() {
		return (municipio);
	}
	
	/**
	 * 
	 * @param tipoMotor
	 */
	public void setTipoMotor(int tipoMotor) {
		
		String TiposMotor[] = {"desconocido", "diesel", "gasolina"};
		
		if (tipoMotor >= 0 && tipoMotor < 3)
			this.motor = TiposMotor[tipoMotor];
	}
	
	/**
	 * 
	 * @return
	 */
	public String getTipoMotor() {
		return (motor);
	}
	
	/**
	 * 
	 * @return
	 */
	public String getProvincia() {
		return (provincia);
	}
}
