package negocio;

import dto.PrendaVentaDTO;

public class PrendaVenta {
	private int idPrendaVenta;
	private String estado;
	private Lote lote;
	private boolean activo;
	
	public PrendaVenta(){}

	public PrendaVenta(int idPrendaVenta, String estado, Lote lote,
			boolean activo) {
		super();
		this.idPrendaVenta = idPrendaVenta;
		this.estado = estado;
		this.lote = lote;
		this.activo = activo;
	}



	public PrendaVenta(String estado, Lote lote, boolean activo) {
		this.estado = estado;
		this.lote = lote;
		this.activo = activo;
	}

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
	
	public PrendaVentaDTO toDTO(){
		PrendaVentaDTO aux = new PrendaVentaDTO();
		aux.setActivo(this.isActivo());
		aux.setEstado(this.getEstado());
		aux.setIdPrendaVenta(this.getIdPrendaVenta());
		if(this.getLote()!=null){
			aux.setLote(this.getLote().toDTO());
		}
		return aux;
	}

}
