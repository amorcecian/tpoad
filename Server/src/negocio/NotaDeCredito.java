package negocio;

import dto.NotaDeCreditoDTO;

public class NotaDeCredito {
	private int cantidad;
	private Prenda prenda;
	private Cliente cliente;
	private Pedido pedido;
	private boolean activo;
	
	public NotaDeCredito(){}
	
	

	public NotaDeCredito(int cantidad, Prenda prenda, Cliente cliente,
			Pedido pedido, boolean activo) {
		super();
		this.cantidad = cantidad;
		this.prenda = prenda;
		this.cliente = cliente;
		this.pedido = pedido;
		this.activo = activo;
	}



	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Prenda getPrenda() {
		return prenda;
	}

	public void setPrenda(Prenda prenda) {
		this.prenda = prenda;
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

	public NotaDeCreditoDTO toDTO(){
		NotaDeCreditoDTO aux = new NotaDeCreditoDTO();
		aux.setActivo(this.isActivo());
		aux.setCantidad(this.getCantidad());
		aux.setCliente(this.getCliente().toDTO());
		aux.setPedido(this.getPedido().toDTO());
		aux.setPrenda(this.getPrenda().toDTO());
		return aux;
	}
	
}
