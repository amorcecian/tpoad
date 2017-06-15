package dto;

import java.io.Serializable;

public class EtapaProductivaDTO  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private AreaProductivaDTO areaProductivaDTO;
	private int tiempoProduccion;
	private int orden;
	private boolean activo;
	
	public AreaProductivaDTO getAreaProductiva() {
		return areaProductivaDTO;
	}
	public void setAreaProductiva(AreaProductivaDTO areaProductivaDTO) {
		this.areaProductivaDTO = areaProductivaDTO;
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
