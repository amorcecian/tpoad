package dto;

import java.io.Serializable;

public class OrdenModificacionDTO  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EmpleadoDTO encargado;
	private int cantidad;
	private EmpleadoDTO autorizado;
	private String comentarios;
	private PrendaDTO prenda;
	private boolean activo;
	
	public EmpleadoDTO getEncargado() {
		return encargado;
	}
	public void setEncargado(EmpleadoDTO encargado) {
		this.encargado = encargado;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public EmpleadoDTO getAutorizado() {
		return autorizado;
	}
	public void setAutorizado(EmpleadoDTO autorizado) {
		this.autorizado = autorizado;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	public PrendaDTO getPrenda() {
		return prenda;
	}
	public void setPrenda(PrendaDTO prenda) {
		this.prenda = prenda;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	
	
}
