package dto;

import java.io.Serializable;
import java.util.List;

public class AreaProductivaDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idAreaProductiva;
	private String nombre;
	private List<LineaProductivaDTO> lineas;
	private List<LoteDTO> lotesPendientes;
	private boolean activo;
	
	public AreaProductivaDTO() {}
	
	public int getIdAreaProductiva() {
		return idAreaProductiva;
	}
	public void setIdAreaProductiva(int idAreaProductiva) {
		this.idAreaProductiva = idAreaProductiva;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<LineaProductivaDTO> getLineas() {
		return lineas;
	}
	public void setLineas(List<LineaProductivaDTO> lineas) {
		this.lineas = lineas;
	}
	public List<LoteDTO> getLotesPendientes() {
		return lotesPendientes;
	}
	public void setLotesPendientes(List<LoteDTO> lotesPendientes) {
		this.lotesPendientes = lotesPendientes;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	
}
