package dto;

import java.io.Serializable;



public class AlmacenamientoDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idAlmacenamiento;
	private String calle;
	private Integer bloque;
	private Integer estante;
	private Integer posicion;
	private boolean libre;
	private LoteDTO lote;
	private boolean activo;
	
	
	public AlmacenamientoDTO(String calle, int bloque, int estante,
			int posicion, boolean libre, LoteDTO lote, boolean activo) {
		super();
		this.calle = calle;
		this.bloque = bloque;
		this.estante = estante;
		this.posicion = posicion;
		this.libre = libre;
		this.lote = lote;
		this.activo = activo;
	}


	public AlmacenamientoDTO() {
		// TODO Auto-generated constructor stub
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


	public LoteDTO getLote() {
		return lote;
	}


	public void setLote(LoteDTO lote) {
		this.lote = lote;
	}


	public int getIdAlmacenamiento() {
		return idAlmacenamiento;
	}


	public void setIdAlmacenamiento(int idAlmacenamiento) {
		this.idAlmacenamiento = idAlmacenamiento;
	}
	
	
	
	

}
