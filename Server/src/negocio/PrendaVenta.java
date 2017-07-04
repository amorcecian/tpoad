package negocio;

import dto.PrendaVentaDTO;

public class PrendaVenta {
	private int idPrendaVenta;
	private String estado;
	private Lote lote;
	private boolean activo;
	private Stock stock;
	private Remito remito;
	
	public PrendaVenta(){}

	public PrendaVenta(int idPrendaVenta, String estado, Lote lote,
			boolean activo, Stock stock, Remito remito) {
		super();
		this.idPrendaVenta = idPrendaVenta;
		this.estado = estado;
		this.lote = lote;
		this.activo = activo;
		this.stock = stock;
		this.remito = remito;
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
	
	
	
	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}
	
	public Remito getRemito() {
		return remito;
	}

	public void setRemito(Remito remito) {
		this.remito = remito;
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
