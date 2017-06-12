package negocio;

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

}
