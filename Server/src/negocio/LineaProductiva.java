package negocio;

import dto.LineaProductivaDTO;

public class LineaProductiva {
	private int idLinea;
	private String estado;
	private Lote lote;
	private boolean activo;
	
	public LineaProductiva(){}
	

	public LineaProductiva(String estado, Lote lote, boolean activo) {
		super();
		this.estado = estado;
		this.lote = lote;
		this.activo = activo;
	}

	public LineaProductiva(int idLinea, String estado, Lote lote, boolean activo) {
		super();
		this.idLinea = idLinea;
		this.estado = estado;
		this.lote = lote;
		this.activo = activo;
	}



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



	public LineaProductivaDTO toDTO() {
		LineaProductivaDTO aux = new LineaProductivaDTO();
		aux.setActivo(this.isActivo());
		aux.setEstado(this.getEstado());
		aux.setIdLinea(this.getIdLinea());
		aux.setLote(this.getLote().toDTO());	
		return aux;
	}

}
