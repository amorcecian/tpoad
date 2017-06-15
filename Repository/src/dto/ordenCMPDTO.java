package dto;

import java.io.Serializable;
import java.util.List;

public class ordenCMPDTO  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idODCM;
	private String fechaPedido;
	private String fechaEstDespacho;
	private String fechaRealDespacho;
	private List<ItemOCMPDTO> itemPedidoInsumo;
	private OrdenDeProduccionDTO ordenDeProduccion;
	private String estado;
	private float loteValor;
	private boolean activo;
	
	public Integer getIdODCM() {
		return idODCM;
	}
	public void setIdODCM(Integer idODCM) {
		this.idODCM = idODCM;
	}
	public String getFechaPedido() {
		return fechaPedido;
	}
	public void setFechaPedido(String fechaPedido) {
		this.fechaPedido = fechaPedido;
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
	public List<ItemOCMPDTO> getItemPedidoInsumo() {
		return itemPedidoInsumo;
	}
	public void setItemPedidoInsumo(List<ItemOCMPDTO> itemPedidoInsumo) {
		this.itemPedidoInsumo = itemPedidoInsumo;
	}
	public OrdenDeProduccionDTO getOrdenDeProduccion() {
		return ordenDeProduccion;
	}
	public void setOrdenDeProduccion(OrdenDeProduccionDTO ordenDeProduccion) {
		this.ordenDeProduccion = ordenDeProduccion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public float getLoteValor() {
		return loteValor;
	}
	public void setLoteValor(float loteValor) {
		this.loteValor = loteValor;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	
	
}
