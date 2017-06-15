package dto;

import java.io.Serializable;

public class PrendaVentaDTO  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idPrendaVenta;
	private String estado;
	private LoteDTO lote;
	private boolean activo;
	
	public int getIdPrendaVenta() {
		return idPrendaVenta;
	}
	public void setIdPrendaVenta(int idPrendaVenta) {
		this.idPrendaVenta = idPrendaVenta;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public LoteDTO getLote() {
		return lote;
	}
	public void setLote(LoteDTO lote) {
		this.lote = lote;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	
	
}
