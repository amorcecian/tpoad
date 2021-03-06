package negocio;

import java.util.List;
import java.util.Vector;

import dao.StockDAO;
import dto.PrendaVentaDTO;
import dto.StockDTO;

public class Stock {
	private int idStock;
	private int cantidad;
	private List<PrendaVenta> prendasVenta;
	private boolean activo;
	
	public Stock(){}

	public Stock(int cantidad, List<PrendaVenta> prendasVenta,boolean activo) {
		super();
		this.cantidad = cantidad;
		this.prendasVenta=prendasVenta;
		this.activo = activo;
	}
	
	public Stock(int cantidad,boolean activo) {
		super();
		this.cantidad = cantidad;
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

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	

	public List<PrendaVenta> getPrendasVenta() {
		return prendasVenta;
	}

	public void setPrendasVenta(List<PrendaVenta> prendasVenta) {
		this.prendasVenta = prendasVenta;
	}

	public StockDTO toDTO() {
		StockDTO aux = new StockDTO();
		aux.setActivo(this.isActivo());
		aux.setCantidad(this.getCantidad());
		aux.setIdStock(this.getIdStock());
		
		List<PrendaVentaDTO> listprendas = new Vector <PrendaVentaDTO>();
		if(this.getPrendasVenta()!=null){
			for (PrendaVenta p : this.getPrendasVenta())
					listprendas.add(p.toDTO());
			}
		aux.setPrendasVenta(listprendas);
		
		return aux;
	}

	public void agregarStock(int cantidadProducida) {
		this.cantidad = this.cantidad + cantidadProducida;
		StockDAO.getInstance().actualizarStock(this);
	}
	
	

}
