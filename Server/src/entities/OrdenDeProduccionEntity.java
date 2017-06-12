package entities;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="ordenes_produccion")
public class OrdenDeProduccionEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_orden_produccion",nullable=false)
	private Integer idOrdenDeProduccion;
	
	@Column(name="fecha")
	private String fecha;
	
	@Column(name="tipo")
	private String tipo;
	
	@OneToMany
	@JoinColumn(name="id_prenda")
	private List<PrendaEntity> prenda;
	
	@OneToMany
	@JoinColumn(name="id_items_ocmp")
	private List<ItemOCMPEntity> materiales;
	
	@OneToOne
	@JoinColumn(name="id_pedido")
	private PedidoEntity pedido;
	
	@Column(name="precio_prod")
	private float precioProd;
	/*
	@ManyToOne
	@JoinColumn(name="id_lote")
	private List<LoteEntity> lotes;
	*/
	public OrdenDeProduccionEntity(){}
	
	public OrdenDeProduccionEntity(Integer idOrdenDeProduccion, String fecha,
			String tipo, List<PrendaEntity> prenda,
			List<ItemOCMPEntity> materiales, PedidoEntity pedido,
			float precioProd) {
		super();
		this.idOrdenDeProduccion = idOrdenDeProduccion;
		this.fecha = fecha;
		this.tipo = tipo;
		this.prenda = prenda;
		this.materiales = materiales;
		this.pedido = pedido;
		this.precioProd = precioProd;
		//this.lotes = lotes;
	}

	public Integer getIdOrdenDeProduccion() {
		return idOrdenDeProduccion;
	}

	public void setIdOrdenDeProduccion(Integer idOrdenDeProduccion) {
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

	public List<PrendaEntity> getPrenda() {
		return prenda;
	}

	public void setPrenda(List<PrendaEntity> prenda) {
		this.prenda = prenda;
	}

	public List<ItemOCMPEntity> getMateriales() {
		return materiales;
	}

	public void setMateriales(List<ItemOCMPEntity> materiales) {
		this.materiales = materiales;
	}

	public PedidoEntity getPedido() {
		return pedido;
	}

	public void setPedido(PedidoEntity pedido) {
		this.pedido = pedido;
	}

	public float getPrecioProd() {
		return precioProd;
	}

	public void setPrecioProd(float precioProd) {
		this.precioProd = precioProd;
	}
/*
	public List<LoteEntity> getLotes() {
		return lotes;
	}

	public void setLotes(List<LoteEntity> lotes) {
		this.lotes = lotes;
	}
*/	
	

}
