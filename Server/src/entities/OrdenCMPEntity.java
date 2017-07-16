package entities;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="ordenes_cmp")
public class OrdenCMPEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_orden_cmp",nullable=false)
	private Integer idODCM;
	@Column(name="fechaPedido")
	private String fechaPedido;
	@Column(name="fecha_est_despacho")
	private String fechaEstDespacho;
	@Column(name="fecha_real_despacho")
	private String fechaRealDespacho;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="id_orden_cmp")
	private List<ItemOCMPEntity> itemPedidoInsumo;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_orden_produccion",nullable=true)
	private OrdenDeProduccionEntity ordenDeProduccion;
	
	@Column(name="estado")
	private String estado;
	@Column(name="lote_valor")
	private Integer idLote;
	@Column(name="activo")
	private boolean activo;
	
	public OrdenCMPEntity(){}
	
	public OrdenCMPEntity(Integer idODCM, String fechaPedido,
			String fechaEstDespacho, String fechaRealDespacho,
			List<ItemOCMPEntity> itemPedidoInsumo,
			OrdenDeProduccionEntity ordenDeProduccion, String estado,
			Integer idLote, boolean activo) {
		super();
		this.idODCM = idODCM;
		this.fechaPedido = fechaPedido;
		this.fechaEstDespacho = fechaEstDespacho;
		this.fechaRealDespacho = fechaRealDespacho;
		this.itemPedidoInsumo = itemPedidoInsumo;
		this.ordenDeProduccion = ordenDeProduccion;
		this.estado = estado;
		this.idLote = idLote;
		this.activo = activo;
	}



	public Integer getIdODCM() {
		return idODCM;
	}

	public void setIdODCM(Integer idODCM) {
		this.idODCM = idODCM;
	}

	public String getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(String fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public String getFechaEstDespacho() {
		return fechaEstDespacho;
	}

	public void setFechaEstDespacho(String fechaEstDespacho) {
		this.fechaEstDespacho = fechaEstDespacho;
	}

	public String getFechaRealDespacho() {
		return fechaRealDespacho;
	}

	public void setFechaRealDespacho(String fechaRealDespacho) {
		this.fechaRealDespacho = fechaRealDespacho;
	}

	public List<ItemOCMPEntity> getItemPedidoInsumo() {
		return itemPedidoInsumo;
	}

	public void setItemPedidoInsumo(List<ItemOCMPEntity> itemPedidoInsumo) {
		this.itemPedidoInsumo = itemPedidoInsumo;
	}

	public OrdenDeProduccionEntity getOrdenDeProduccion() {
		return ordenDeProduccion;
	}

	public void setOrdenDeProduccion(OrdenDeProduccionEntity ordenDeProduccion) {
		this.ordenDeProduccion = ordenDeProduccion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getIdLote() {
		return idLote;
	}

	public void setIdLote(Integer idLote) {
		this.idLote = idLote;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	

}
