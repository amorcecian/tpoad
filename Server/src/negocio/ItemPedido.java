package negocio;

import dto.ItemPedidoDTO;

public class ItemPedido {
	
	private String id;
	private int cantidad;
	private Prenda prenda;
	private String estado;
	private boolean activo;
	
	public ItemPedido(){}
	
	

	public ItemPedido(int cantidad, Prenda prenda, String estado, boolean activo) {
		super();
		this.cantidad = cantidad;
		this.prenda = prenda;
		this.estado = estado;
		this.activo = activo;
	}

	

	public String getId() {
		return id;
	}



	public void setId(String string) {
		this.id = string;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}



	public boolean isActivo() {
		return activo;
	}



	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public ItemPedidoDTO toDTO(){
		ItemPedidoDTO aux = new ItemPedidoDTO();
		aux.setActivo(this.isActivo());
		aux.setCantidad(this.getCantidad());
		aux.setEstado(this.getEstado());
		aux.setPrenda(this.getPrenda().toDTO());
		return aux;
	}

}
