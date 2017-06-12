package negocio;

public class Factura {
	
	private Integer idFactura;
	private String tipo;
	private Cliente cliente;
	private Pedido pedido;
	private boolean activo;
	
	public Factura(){}
	
	

	public Factura(Integer idFactura, String tipo, Cliente cliente,
			Pedido pedido, boolean activo) {
		super();
		this.idFactura = idFactura;
		this.tipo = tipo;
		this.cliente = cliente;
		this.pedido = pedido;
		this.activo = activo;
	}



	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}



	public boolean isActivo() {
		return activo;
	}



	public void setActivo(boolean activo) {
		this.activo = activo;
	}



	public void setIdFactura(Integer idFactura) {
		this.idFactura = idFactura;
	}
	
	

}
