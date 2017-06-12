package negocio;

public class EtapaProductiva {
	private AreaProductiva areaProductiva;
	private int tiempoProduccion;
	private int orden;
	private boolean activo;
	
	public EtapaProductiva(){}
	
	

	public EtapaProductiva(AreaProductiva areaProductiva, int tiempoProduccion,
			int orden, boolean activo) {
		super();
		this.areaProductiva = areaProductiva;
		this.tiempoProduccion = tiempoProduccion;
		this.orden = orden;
		this.activo = activo;
	}



	public AreaProductiva getAreaProductiva() {
		return areaProductiva;
	}

	public void setAreaProductiva(AreaProductiva areaProductiva) {
		this.areaProductiva = areaProductiva;
	}

	public int getTiempoProduccion() {
		return tiempoProduccion;
	}

	public void setTiempoProduccion(int tiempoProduccion) {
		this.tiempoProduccion = tiempoProduccion;
	}

	public int getOrden() {
		return orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}



	public boolean isActivo() {
		return activo;
	}



	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	

}
