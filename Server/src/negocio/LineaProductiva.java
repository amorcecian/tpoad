package negocio;

import dto.LineaProductivaDTO;

public class LineaProductiva {
	private int idLinea;
	private String estado;
	private int idLote;
	private boolean activo;
	
	public LineaProductiva(){}
	

	public LineaProductiva(String estado, Lote lote, boolean activo) {
		super();
		this.estado = estado;
		this.activo = activo;
	}

	public LineaProductiva(int idLinea, String estado, Lote lote, boolean activo) {
		super();
		this.idLinea = idLinea;
		this.estado = estado;
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


	public LineaProductivaDTO toDTO() {
		LineaProductivaDTO aux = new LineaProductivaDTO();
		aux.setActivo(this.isActivo());
		aux.setEstado(this.getEstado());
		aux.setIdLinea(this.getIdLinea());
		if(this.getIdLote()!=0){
			aux.setIdLote(this.getIdLote());;
		}
		return aux;
	}



}
