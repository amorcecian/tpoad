package dto;

import java.io.Serializable;
import java.util.List;

public class StockDTO  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idStock;
	private int cantidad;
	private List<PrendaVentaDTO> prendasVenta;
	private boolean activo;
	
	public int getIdStock() {
		return idStock;
	}
	public void setIdStock(int idStock) {
		this.idStock = idStock;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public List<PrendaVentaDTO> getPrendasVenta() {
		return prendasVenta;
	}
	public void setPrendasVenta(List<PrendaVentaDTO> prendasVenta) {
		this.prendasVenta = prendasVenta;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	
}
