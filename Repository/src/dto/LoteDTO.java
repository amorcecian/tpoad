package dto;

import java.io.Serializable;

public class LoteDTO  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int idLote;
	private PrendaDTO prenda;
	private int idOP;
	private int proceso;
	private String estado;
	private float costoProd;
	private AlmacenamientoDTO ubicacion;
	private int cantidadProducida;
	private int cantidadRestante;
	private boolean activo;
	
	
	public int getIdLote() {
		return idLote;
	}
	public void setIdLote(int idLote) {
		this.idLote = idLote;
	}
	public PrendaDTO getPrenda() {
		return prenda;
	}
	public void setPrenda(PrendaDTO prenda) {
		this.prenda = prenda;
	}

	public int getIdOP() {
		return idOP;
	}
	public void setIdOP(int idOP) {
		this.idOP = idOP;
	}
	public int getProceso() {
		return proceso;
	}
	public void setProceso(int proceso) {
		this.proceso = proceso;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public float getCostoProd() {
		return costoProd;
	}
	public void setCostoProd(float costoProd) {
		this.costoProd = costoProd;
	}
	public AlmacenamientoDTO getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(AlmacenamientoDTO ubicacion) {
		this.ubicacion = ubicacion;
	}
	public int getCantidadProducida() {
		return cantidadProducida;
	}
	public void setCantidadProducida(int cantidadProducida) {
		this.cantidadProducida = cantidadProducida;
	}
	public int getCantidadRestante() {
		return cantidadRestante;
	}
	public void setCantidadRestante(int cantidadRestante) {
		this.cantidadRestante = cantidadRestante;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	
	
}
