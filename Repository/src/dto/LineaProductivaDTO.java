package dto;

import java.io.Serializable;

public class LineaProductivaDTO  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idLinea;
	private String estado;
	private int idLote;
	private boolean activo;
	
	public int getIdLinea() {
		return idLinea;
	}
	public void setIdLinea(int idLinea) {
		this.idLinea = idLinea;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public int getIdLote() {
		return idLote;
	}
	public void setIdLote(int idLote) {
		this.idLote = idLote;
	}
	
	
	
}
