package negocio;

public class Remito {
	private int idRemito;
	private Factura factura;
	private boolean activo;
	
	public Remito(){}

	public Remito(int idRemito, Factura factura, boolean activo) {
		super();
		this.idRemito = idRemito;
		this.factura = factura;
		this.activo = activo;
	}

	public int getIdRemito() {
		return idRemito;
	}

	public void setIdRemito(int idRemito) {
		this.idRemito = idRemito;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	

}
