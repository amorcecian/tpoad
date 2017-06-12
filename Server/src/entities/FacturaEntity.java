package entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="facturas")
public class FacturaEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="nro_factura")
	private Integer idFactura;
	@Column(name="tipo")
	private String tipo;
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private ClienteEntity cliente;
	@OneToOne
	@JoinColumn(name="id_pedido")
	private PedidoEntity pedido;
	
	public FacturaEntity(){};
	
	public FacturaEntity(Integer idFactura, String tipo, ClienteEntity cliente,
			PedidoEntity pedido) {
		super();
		this.idFactura = idFactura;
		this.tipo = tipo;
		this.cliente = cliente;
		this.pedido = pedido;
	}

	public Integer getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(Integer idFactura) {
		this.idFactura = idFactura;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

	public PedidoEntity getPedido() {
		return pedido;
	}

	public void setPedido(PedidoEntity pedido) {
		this.pedido = pedido;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

}
