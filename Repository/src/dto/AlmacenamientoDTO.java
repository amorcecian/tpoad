package dto;

import java.io.Serializable;



public class AlmacenamientoDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String calle;
	private Integer bloque;
	private Integer estante;
	private Integer posicion;
	private boolean libre;
	//private LoteDto lote;
	private boolean activo;
	
	
	public AlmacenamientoDTO(String calle, int bloque, int estante,
			int posicion, boolean libre, /*LoteDto lote*/ boolean activo) {
		super();
		this.calle = calle;
		this.bloque = bloque;
		this.estante = estante;
		this.posicion = posicion;
		this.libre = libre;
		//this.lote = lote;
		this.activo = activo;
	}


	public String getCalle() {
		return calle;
	}


	public void setCalle(String calle) {
		this.calle = calle;
	}


	public Integer getBloque() {
		return bloque;
	}


	public void setBloque(Integer bloque) {
		this.bloque = bloque;
	}


	public Integer getEstante() {
		return estante;
	}


	public void setEstante(Integer estante) {
		this.estante = estante;
	}


	public Integer getPosicion() {
		return posicion;
	}


	public void setPosicion(Integer posicion) {
		this.posicion = posicion;
	}


	public boolean isLibre() {
		return libre;
	}


	public void setLibre(boolean libre) {
		this.libre = libre;
	}


	public boolean isActivo() {
		return activo;
	}


	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	
	
	

}
