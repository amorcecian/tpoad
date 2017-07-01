package dto;

import java.io.Serializable;
import java.util.List;


public class PrendaDTO  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idPrenda;
	private String descripcion;
	private String color;
	private String talle;
	private float precioVenta;
	private String temporada;
	private float tiempoProd;
	private int cantProducir;
	private int cantMinParaProducir;
	private StockDTO stock;
	private List<EtapaProductivaDTO> etapaProd;
	private List<MaterialporPrendaDTO> materiales;
	private boolean activo;
	
	public PrendaDTO(){};
	
	public PrendaDTO(String descripcion,String color, String talle, float precioVenta,
			String temporada,float tiempoProd,int cantProducir){
		this.descripcion=descripcion;
		this.color=color;
		this.talle=talle;
		this.precioVenta=precioVenta;
		this.temporada=temporada;
		this.tiempoProd=tiempoProd;
		this.cantProducir=cantProducir;
		
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
	public StockDTO getStock() {
		return stock;
	}
	public void setStock(StockDTO stock) {
		this.stock = stock;
	}
	public List<EtapaProductivaDTO> getEtapaProd() {
		return etapaProd;
	}
	public void setEtapaProd(List<EtapaProductivaDTO> etapaProd) {
		this.etapaProd = etapaProd;
	}
	public List<MaterialporPrendaDTO> getMateriales() {
		return materiales;
	}
	public void setMateriales(List<MaterialporPrendaDTO> materiales) {
		this.materiales = materiales;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public int getCantMinParaProducir() {
		return cantMinParaProducir;
	}

	public void setCantMinParaProducir(int cantMinParaProducir) {
		this.cantMinParaProducir = cantMinParaProducir;
	}
	
	
	
}
