package negocio;

import java.util.List;

public class OrdenDeProduccion {
	private int idOrdenDeProduccion;
	private String fecha;
	private String tipo;
	private List<Prenda> prenda;
	private List<ItemOCMP> materiales;
	private Pedido pedido;
	private float precioProd;
	private List<Lote> lotes;
	private boolean activo;
	
	public OrdenDeProduccion (){}
	
	

	public OrdenDeProduccion(int idOrdenDeProduccion, String fecha,
			String tipo, List<Prenda> prenda, List<ItemOCMP> materiales,
			Pedido pedido, float precioProd, List<Lote> lotes, boolean activo) {
		super();
		this.idOrdenDeProduccion = idOrdenDeProduccion;
		this.fecha = fecha;
		this.tipo = tipo;
		this.prenda = prenda;
		this.materiales = materiales;
		this.pedido = pedido;
		this.precioProd = precioProd;
		this.lotes = lotes;
		this.activo = activo;
	}



	public int getIdOrdenDeProduccion() {
		return idOrdenDeProduccion;
	}

	public void setIdOrdenDeProduccion(int idOrdenDeProduccion) {
		this.idOrdenDeProduccion = idOrdenDeProduccion;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Prenda> getPrenda() {
		return prenda;
	}

	public void setPrenda(List<Prenda> prenda) {
		this.prenda = prenda;
	}

	public List<ItemOCMP> getMateriales() {
		return materiales;
	}

	public void setMateriales(List<ItemOCMP> materiales) {
		this.materiales = materiales;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public float getPrecioProd() {
		return precioProd;
	}

	public void setPrecioProd(float precioProd) {
		this.precioProd = precioProd;
	}

	public List<Lote> getLotes() {
		return lotes;
	}

	public void setLotes(List<Lote> lotes) {
		this.lotes = lotes;
	}



	public boolean isActivo() {
		return activo;
	}



	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	

}
