package negocio;

import dto.AlmacenamientoDTO;
import entities.AlmacenamientoEntity;

public class Almacenamiento {	private Integer id;
	private String calle;
	private Integer bloque;
	private Integer estante;
	private Integer posicion;
	private boolean libre;
	private boolean activo;
	
	public Almacenamiento(){}
	public Almacenamiento(String calle, Integer bloque, Integer estante, Integer posicion,			boolean libre, boolean activo) {
		super();
		this.calle = calle;
		this.bloque = bloque;
		this.estante = estante;
		this.posicion = posicion;
		this.libre = libre;
		this.activo = activo;
	}

	public Almacenamiento(AlmacenamientoEntity ce) {
		this.bloque = ce.getBloque();
		this.calle = ce.getCalle();
		this.estante = ce.getEstante();
		this.libre = ce.isLibre();
		this.posicion = ce.getPosicion();
		this.activo = ce.isActivo();
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
	
	public Integer getId() {		return id;	}	public void setId(Integer id) {		this.id = id;	}	public AlmacenamientoDTO ToDTO() {
		AlmacenamientoDTO aaux = new AlmacenamientoDTO();		aaux.setIdAlmacenamiento(this.id);
		aaux.setBloque(this.getBloque());
		aaux.setCalle(this.getCalle()); 
		aaux.setEstante(this.getEstante());
		aaux.setLibre(this.isLibre());
		aaux.setPosicion(this.getPosicion());
		aaux.setActivo(this.isActivo());
		return aaux;
	}

}
