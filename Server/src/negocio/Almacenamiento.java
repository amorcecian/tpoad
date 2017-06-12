package negocio;

import entities.AlmacenamientoEntity;

public class Almacenamiento {
	private String calle;
	private int bloque;
	private int estante;
	private int posicion;
	private boolean libre;
	private Lote lote;
	private boolean activo;
	
	public Almacenamiento(){}
	
	

	public Almacenamiento(String calle, int bloque, int estante, int posicion,
			boolean libre, Lote lote, boolean activo) {
		super();
		this.calle = calle;
		this.bloque = bloque;
		this.estante = estante;
		this.posicion = posicion;
		this.libre = libre;
		this.lote = lote;
		this.activo = activo;
	}



	public Almacenamiento(AlmacenamientoEntity ce) {
		
	}

	public Almacenamiento(AlmacenamientoEntity ce) {
		
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getBloque() {
		return bloque;
	}

	public void setBloque(int bloque) {
		this.bloque = bloque;
	}

	public int getEstante() {
		return estante;
	}

	public void setEstante(int estante) {
		this.estante = estante;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public boolean isLibre() {
		return libre;
	}

	public void setLibre(boolean libre) {
		this.libre = libre;
	}

	public Lote getLote() {
		return lote;
	}

	public void setLote(Lote lote) {
		this.lote = lote;
	}



	public boolean isActivo() {
		return activo;
	}



	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	
	
	

}
