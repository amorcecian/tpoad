package dto;

import java.io.Serializable;
import java.util.List;

public class PedidoDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idPedido;
	private List<ItemPedidoDTO> items;
	private String fechaGeneracion;
	private String fechaEstDespacho;
	private String fechaRealDespacho;
	private float valor;
	private ClienteDTO cliente;
	private SucursalDTO sucursal;
	private String estado;
	private String motivoCancelar;
	private boolean activo;
	
	public PedidoDTO(List<ItemPedidoDTO> itemPedido, String fechaGeneracion, String fechaEstDespacho,
			String fechaRealDespacho,float valor, ClienteDTO cliente,SucursalDTO sucu,
			String estado,String motivoCancelar,boolean activo) {
		this.items=itemPedido;
		this.fechaGeneracion=fechaGeneracion;
		this.fechaEstDespacho=fechaEstDespacho;
		this.fechaRealDespacho=fechaRealDespacho;
		this.valor=valor;
		this.cliente=cliente;
		this.sucursal=sucu;
		this.estado=estado;
		this.motivoCancelar=motivoCancelar;
		this.activo=activo;		
	}
	
	public PedidoDTO() {}
	
	
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public List<ItemPedidoDTO> getItems() {
		return items;
	}
	public void setItems(List<ItemPedidoDTO> items) {
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
	public ClienteDTO getCliente() {
		return cliente;
	}
	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}
	public SucursalDTO getSucursal() {
		return sucursal;
	}
	public void setSucursal(SucursalDTO sucursal) {
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
	
	
	
}
