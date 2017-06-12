package negocio;

import java.util.List;

public class Stock {
	private int idStock;
	private int cantidad;
	private List<PrendaVenta> prendasVenta;
	private boolean activo;
	
	public Stock(){}

	public Stock(int idStock, int cantidad, List<PrendaVenta> prendasVenta,
			boolean activo) {
		super();
		this.idStock = idStock;
		this.cantidad = cantidad;
		this.prendasVenta = prendasVenta;
		this.activo = activo;
	}



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

	public List<PrendaVenta> getPrendasVenta() {
		return prendasVenta;
	}

	public void setPrendasVenta(List<PrendaVenta> prendasVenta) {
		this.prendasVenta = prendasVenta;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	

}
