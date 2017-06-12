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
	@OneToMany
	@JoinColumn(name="id_items_ocmp")
	private List<ItemOCMPEntity> itemPedidoInsumo;
	@OneToMany
	@JoinColumn(name="id_orden_produccion")
	private List<OrdenDeProduccionEntity> ordenDeProduccion;
	@Column(name="estado")
	private String estado;
	@Column(name="lote_valor")
	private float loteValor;
	
	public OrdenCMPEntity(){}
	
	public OrdenCMPEntity(Integer idODCM, String fechaPedido,
			String fechaEstDespacho, String fechaRealDespacho,
			List<ItemOCMPEntity> itemPedidoInsumo,
			List<OrdenDeProduccionEntity> ordenDeProduccion, String estado,
			float loteValor) {
		super();
		this.idODCM = idODCM;
		this.fechaPedido = fechaPedido;
		this.fechaEstDespacho = fechaEstDespacho;
		this.fechaRealDespacho = fechaRealDespacho;
		this.itemPedidoInsumo = itemPedidoInsumo;
		this.ordenDeProduccion = ordenDeProduccion;
		this.estado = estado;
		this.loteValor = loteValor;
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

	public List<OrdenDeProduccionEntity> getOrdenDeProduccion() {
		return ordenDeProduccion;
	}

	public void setOrdenDeProduccion(List<OrdenDeProduccionEntity> ordenDeProduccion) {
		this.ordenDeProduccion = ordenDeProduccion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public float getLoteValor() {
		return loteValor;
	}

	public void setLoteValor(float loteValor) {
		this.loteValor = loteValor;
	}
	
	
	
	

}
