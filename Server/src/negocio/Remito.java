package negocio;

import java.util.List;
import java.util.Vector;

import dto.PrendaVentaDTO;
import dto.RemitoDTO;

public class Remito {
	private int idRemito;
	private Factura factura;
	private boolean activo;
	private List <PrendaVenta> prendasventas;
	private String estado;
	
	public Remito(){}

	public Remito(int idRemito, Factura factura, boolean activo,List<PrendaVenta> prendas,String estado) {
		super();
		this.idRemito = idRemito;
		this.factura = factura;
		this.activo = activo;
		this.prendasventas = prendas;
		this.estado = estado;
	}

	public int getIdRemito() {
		return idRemito;
	}

	public void setIdRemito(int idRemito) {
		this.idRemito = idRemito;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public List<PrendaVenta> getPrendasventas() {
		return prendasventas;
	}

	public void setPrendasventas(List<PrendaVenta> prendasventas) {
		this.prendasventas = prendasventas;
	}
	
	public RemitoDTO toDTO(){
		RemitoDTO aux = new RemitoDTO();
		aux.setActivo(this.isActivo());
		aux.setFactura(this.getFactura().toDTO());
		aux.setIdRemito(this.getIdRemito());
		
		List<PrendaVentaDTO> p = new Vector<PrendaVentaDTO>();
		for (PrendaVenta pv : this.getPrendasventas()){
			p.add(pv.toDTO());
		}
		aux.setPrendas(p);
		return aux;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
