package entities;

import java.io.Serializable;

import javax.persistence.*;

@Embeddable
public class ItemsPedidoIDEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="id_pedido",nullable=false)
	private PedidoEntity pedido;
	
	@ManyToOne
	@JoinColumn(name="id_prenda",nullable=false)
	private PrendaEntity prenda;

	public ItemsPedidoIDEntity(PedidoEntity pedido, PrendaEntity prenda) {
		super();
		this.pedido = pedido;
		this.prenda = prenda;
	}
	
	public ItemsPedidoIDEntity (){}
	

	public PedidoEntity getPedido() {
		return pedido;
	}

	public void setPedido(PedidoEntity pedido) {
		this.pedido = pedido;
	}

	public PrendaEntity getPrenda() {
		return prenda;
	}

	public void setPrenda(PrendaEntity prenda) {
		this.prenda = prenda;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
