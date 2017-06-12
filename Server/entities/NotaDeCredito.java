package entities;

import javax.persistence.*;

@Entity
@Table(name="notas_de_credito")
public class NotaDeCredito {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="nro_nota_credito",nullable=false)
	private Integer nro_notaCredito;
	@Column(name="cantidad")
	private Integer cantidad;
	@ManyToOne
	@JoinColumn(name="id_prenda")
	private PrendaEntity prenda;
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private ClienteEntity cliente;
	@ManyToOne
	@JoinColumn(name="id_pedido")
	private PedidoEntity pedido;
	
	
	public NotaDeCredito(Integer nro_notaCredito, Integer cantidad,
			PrendaEntity prenda, ClienteEntity cliente, PedidoEntity pedido) {
		super();
		this.nro_notaCredito = nro_notaCredito;
		this.cantidad = cantidad;
		this.prenda = prenda;
		this.cliente = cliente;
		this.pedido = pedido;
	}
	
	public NotaDeCredito(){}

	public Integer getNro_notaCredito() {
		return nro_notaCredito;
	}

	public void setNro_notaCredito(Integer nro_notaCredito) {
		this.nro_notaCredito = nro_notaCredito;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public PrendaEntity getPrenda() {
		return prenda;
	}

	public void setPrenda(PrendaEntity prenda) {
		this.prenda = prenda;
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
	};
	
	
	
	

}
