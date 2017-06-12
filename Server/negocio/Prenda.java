package negocio;

import java.util.List;

public class Prenda {
	private int idPrenda;
	private String descripcion;
	private String color;
	private String talle;
	private float precioVenta;
	private String temporada;
	private float tiempoProd;
	private int cantProducir;
	private Stock stock;
	private List<EtapaProductiva> etapaProd;
	private List<MaterialPorPrenda> materiales;
	private boolean activo;
	
	public Prenda(){}

	public Prenda(int idPrenda, String descripcion, String color, String talle,
			float precioVenta, String temporada, float tiempoProd,
			int cantProducir, Stock stock, List<EtapaProductiva> etapaProd,
			List<MaterialPorPrenda> materiales, boolean activo) {
		super();
		this.idPrenda = idPrenda;
		this.descripcion = descripcion;
		this.color = color;
		this.talle = talle;
		this.precioVenta = precioVenta;
		this.temporada = temporada;
		this.tiempoProd = tiempoProd;
		this.cantProducir = cantProducir;
		this.stock = stock;
		this.etapaProd = etapaProd;
		this.materiales = materiales;
		this.activo = activo;
	}



	public int getIdPrenda() {
		return idPrenda;
	}

	public void setIdPrenda(int idPrenda) {
		this.idPrenda = idPrenda;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTalle() {
		return talle;
	}

	public void setTalle(String talle) {
		this.talle = talle;
	}

	public float getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
	}

	public String getTemporada() {
		return temporada;
	}

	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}

	public float getTiempoProd() {
		return tiempoProd;
	}

	public void setTiempoProd(float tiempoProd) {
		this.tiempoProd = tiempoProd;
	}

	public int getCantProducir() {
		return cantProducir;
	}

	public void setCantProducir(int cantProducir) {
		this.cantProducir = cantProducir;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public List<EtapaProductiva> getEtapaProd() {
		return etapaProd;
	}

	public void setEtapaProd(List<EtapaProductiva> etapaProd) {
		this.etapaProd = etapaProd;
	}

	public List<MaterialPorPrenda> getMateriales() {
		return materiales;
	}

	public void setMateriales(List<MaterialPorPrenda> materiales) {
		this.materiales = materiales;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	

}
