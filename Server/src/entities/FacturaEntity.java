package entities;

import java.io.Serializable;

import javax.persistence.*;

import dao.ClienteDAO;
import dao.PedidoDAO;
import negocio.Factura;

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
	
	@Column(name="activo")
	private boolean activo;
	
	public FacturaEntity(){};
	
	

	public FacturaEntity(Integer idFactura, String tipo, ClienteEntity cliente,
			PedidoEntity pedido, boolean activo) {
		super();
		this.idFactura = idFactura;
		this.tipo = tipo;
		this.cliente = cliente;
		this.pedido = pedido;
		this.activo = activo;
	}
	
	public FacturaEntity(Factura f){
		this.idFactura = f.getIdFactura();
		this.tipo = f.getTipo();
		ClienteEntity cliente = ClienteDAO.getInstance().toEntity(f.getCliente());
		this.cliente = cliente;
		PedidoEntity pedido = PedidoDAO.getInstance().toEntity(f.getPedido());
		this.pedido = pedido;
		this.activo = true;
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



	public boolean isActivo() {
		return activo;
	}



	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	

}
