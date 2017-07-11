package entities;


import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="prendas")
public class PrendaEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_prenda")
	private Integer idPrenda;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="color")
	private String color;
	
	@Column(name="talle")
	private String talle;
	
	@Column(name="precioVenta")
	private float precioVenta;
	
	@Column(name="temporada")
	private String temporada;
	
	@Column(name="tiempoProd")
	private float tiempoProd;
	
	@Column(name="cantProducir")
	private Integer cantProducir;
	
	@Column(name="cantMinParaProducir")
	private Integer cantMinParaProducir;
	
	@Column(name="activo")
	private boolean activo;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	private StockEntity stock;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="id_prenda")
	private List<MaterialPorPrendaEntity> materiales;
	
	@ManyToOne
	@JoinColumn(name="id_Orden")
	private OrdenDeProduccionEntity ordenDeProduccion;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="id_prenda")
	private List<EtapaProductivaEntity> etapaProductiva;
	
	@OneToOne
	@JoinColumn(name="id_prenda")
	private LoteEntity lote;
	
	

	public PrendaEntity(){}
	
	public Integer getIdPrenda() {
		return idPrenda;
	}
	public void setIdPrenda(Integer idPrenda) {
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
	public Integer getCantProducir() {
		return cantProducir;
	}
	public void setCantProducir(Integer cantProducir) {
		this.cantProducir = cantProducir;
	}
	
	

	public List<MaterialPorPrendaEntity> getMateriales() {
		return materiales;
	}

	public void setMateriales(List<MaterialPorPrendaEntity> materiales) {
		this.materiales = materiales;
	}

	


	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	
	public StockEntity getStock() {
		return stock;
	}

	public void setStock(StockEntity stock) {
		this.stock = stock;
	}

	public Integer getCantMinParaProducir() {
		return cantMinParaProducir;
	}

	public void setCantMinParaProducir(Integer cantMinParaProducir) {
		this.cantMinParaProducir = cantMinParaProducir;
	}

	public OrdenDeProduccionEntity getOrdenDeProduccion() {
		return ordenDeProduccion;
	}

	public void setOrdenDeProduccion(OrdenDeProduccionEntity ordenDeProduccion) {
		this.ordenDeProduccion = ordenDeProduccion;
	}

	public List<EtapaProductivaEntity> getEtapaProductiva() {
		return etapaProductiva;
	}

	public void setEtapaProductiva(List<EtapaProductivaEntity> etapaProductiva) {
		this.etapaProductiva = etapaProductiva;
	}

	public LoteEntity getLote() {
		return lote;
	}

	public void setLote(LoteEntity lote) {
		this.lote = lote;
	}
	
	
	
	

	
}
