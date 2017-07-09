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
	@JoinColumn(name="id_orden_produccion")
	private List<PrendaEntity> prenda;
	
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="id_items_ocmp")
	private List<ItemOCMPEntity> materiales;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_pedido")
	private PedidoEntity pedido;
	
	@ManyToOne
	@JoinColumn(name="idorden_produccion")
	private OrdenCMPEntity ordenCompraMateriales;
	
	@Column(name="precio_prod")
	private float precioProd;
	
	/*
	@ManyToOne
	@JoinColumn(name="id_lote")
	private List<LoteEntity> lotes;
	*/
	
	@Column(name="activo")
	private boolean activo;
	
	public OrdenDeProduccionEntity(){}
	
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

	/*
	public List<PrendaEntity> getPrenda() {
		return prenda;
	}

	public void setPrenda(List<PrendaEntity> prenda) {
		this.prenda = prenda;
	}
	*/

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

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}	
	

}
