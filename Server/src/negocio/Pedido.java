package negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import dto.ItemPedidoDTO;
import dto.PedidoDTO;
import entities.PedidoEntity;

public class Pedido {
	private int idPedido;
	private List<ItemPedido> items;
	private String fechaGeneracion;
	private String fechaEstDespacho;
	private String fechaRealDespacho;
	private float valor;
	private Cliente cliente;
	private Sucursal sucursal;
	private String estado;
	private String motivoCancelar;
	private boolean activo;


	public Pedido(int idPedido, List<ItemPedido> items, String fechaGeneracion,
			String fechaEstDespacho, String fechaRealDespacho, float valor,
			Cliente cliente, Sucursal sucursal, String estado,
			String motivoCancelar, boolean activo) {
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
		this.activo = activo;
	}
	
	public Pedido(List<ItemPedido> items, String fechaGeneracion,
			String fechaEstDespacho, String fechaRealDespacho, float valor,
			Cliente cliente, Sucursal sucursal, String estado,
			String motivoCancelar, boolean activo) {
		super();
		this.items = items;
		this.fechaGeneracion = fechaGeneracion;
		this.fechaEstDespacho = fechaEstDespacho;
		this.fechaRealDespacho = fechaRealDespacho;
		this.valor = valor;
		this.cliente = cliente;
		this.sucursal = sucursal;
		this.estado = estado;
		this.motivoCancelar = motivoCancelar;
		this.activo = activo;
	}

	public Pedido() {}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public List<ItemPedido> getItems() {
		return items;
	}

	public void setItems(List<ItemPedido> items) {
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
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

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public PedidoDTO toDTO() {
		PedidoDTO aux = new PedidoDTO();
		aux.setActivo(this.isActivo());
		aux.setCliente(this.getCliente().toDTO());
		aux.setEstado(this.getEstado());
		aux.setFechaEstDespacho(this.getFechaEstDespacho());
		aux.setFechaGeneracion(this.getFechaGeneracion());
		aux.setFechaRealDespacho(this.getFechaRealDespacho());
		aux.setIdPedido(this.getIdPedido());
		aux.setMotivoCancelar(this.getMotivoCancelar());
		aux.setSucursal(this.getSucursal().toDTO());
		aux.setValor(this.getValor());
		List<ItemPedidoDTO> listitems= new ArrayList<ItemPedidoDTO>();
		for(ItemPedido i : this.getItems())
			listitems.add(i.toDTO());
		aux.setItems(listitems);
		return aux;
		
	}
	
	
	
	

}
