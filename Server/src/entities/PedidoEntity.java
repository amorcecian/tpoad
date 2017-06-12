package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="pedidos")
public class PedidoEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_pedido",nullable=false)
	private Integer idPedido;
	@OneToMany
	@JoinColumn(name="id_pedido")
	private List<ItemsPedidoEntity> items;
	@Column(name="fecha_generacion")
	private String fechaGeneracion;
	@Column(name="fecha_estimada")
	private String fechaEstDespacho;
	@Column(name="fecha_real")
	private String fechaRealDespacho;
	@Column(name="valor")
	private float valor;
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private ClienteEntity cliente;
	@ManyToOne
	@JoinColumn(name="id_sucursal")
	private SucursalEntity sucursal;
	@Column(name="estado")
	private String estado;
	@Column(name="motivos_cancelacion")
	private String motivoCancelar;
	
	public PedidoEntity(){}

	public PedidoEntity(Integer idPedido, List<ItemsPedidoEntity> items,
			String fechaGeneracion, String fechaEstDespacho,
			String fechaRealDespacho, float valor, ClienteEntity cliente,
			SucursalEntity sucursal, String estado, String motivoCancelar) {
		super();
		this.idPedido = idPedido;
		this.items = items;
		this.fechaGeneracion = fechaGeneracion;
		this.fechaEstDespacho = fechaEstDespacho;
		this.fechaRealDespacho = fechaRealDespacho;
		this.valor = valor;
		this.cliente = cliente;
		this.sucursal = sucursal;
		this.estado = estado;
		this.motivoCancelar = motivoCancelar;
	}

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public List<ItemsPedidoEntity> getItems() {
		return items;
	}

	public void setItems(List<ItemsPedidoEntity> items) {
		this.items = items;
	}

	public String getFechaGeneracion() {
		return fechaGeneracion;
	}

	public void setFechaGeneracion(String fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
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

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

	public SucursalEntity getSucursal() {
		return sucursal;
	}

	public void setSucursal(SucursalEntity sucursal) {
		this.sucursal = sucursal;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getMotivoCancelar() {
		return motivoCancelar;
	}

	public void setMotivoCancelar(String motivoCancelar) {
		this.motivoCancelar = motivoCancelar;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	};
	
	

}
