package negocio;

import dto.PrendaVentaDTO;

public class PrendaVenta {
	private int idPrendaVenta;
	private String estado;
	private int idLote;
	private boolean activo;
	private int idRemito;
	
	public PrendaVenta(){}

	public PrendaVenta(String estado, int idLote, boolean activo) {
		this.estado = estado;
		this.idLote = idLote;
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
	
	

	public int getIdRemito() {
		return idRemito;
	}

	public void setIdRemito(int idRemito) {
		this.idRemito = idRemito;
	}

	public PrendaVentaDTO toDTO(){
		PrendaVentaDTO aux = new PrendaVentaDTO();
		aux.setActivo(this.isActivo());
		aux.setEstado(this.getEstado());
		aux.setIdPrendaVenta(this.getIdPrendaVenta());
		aux.setLote(this.idLote);
		return aux;
	}

}
