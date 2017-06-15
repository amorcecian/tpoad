package dto;

import java.io.Serializable;
import java.util.List;

public class OrdenDeProduccionDTO  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int idOrdenDeProduccion;
	private String fecha;
	private String tipo;
	private List<PrendaDTO> prenda;
	private List<MaterialDTO> materiales;
	private PedidoDTO pedido;
	private float precioProd;
	private List<LoteDTO> lotes;
	private boolean activo;
	
	
	public int getIdOrdenDeProduccion() {
		return idOrdenDeProduccion;
	}
	public void setIdOrdenDeProduccion(int idOrdenDeProduccion) {
		this.idOrdenDeProduccion = idOrdenDeProduccion;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public List<PrendaDTO> getPrenda() {
		return prenda;
	}
	public void setPrenda(List<PrendaDTO> prenda) {
		this.prenda = prenda;
	}
	public List<MaterialDTO> getMateriales() {
		return materiales;
	}
	public void setMateriales(List<MaterialDTO> materiales) {
		this.materiales = materiales;
	}
	public PedidoDTO getPedido() {
		return pedido;
	}
	public void setPedido(PedidoDTO pedido) {
		this.pedido = pedido;
	}
	public float getPrecioProd() {
		return precioProd;
	}
	public void setPrecioProd(float precioProd) {
		this.precioProd = precioProd;
	}
	public List<LoteDTO> getLotes() {
		return lotes;
	}
	public void setLotes(List<LoteDTO> lotes) {
		this.lotes = lotes;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	
	
}
