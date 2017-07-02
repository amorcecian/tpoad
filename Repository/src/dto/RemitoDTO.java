package dto;

import java.io.Serializable;
import java.util.List;

public class RemitoDTO  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idRemito;
	private FacturaDTO factura;
	private boolean activo;
	private List <PrendaVentaDTO> prendas;
	
	public List<PrendaVentaDTO> getPrendas() {
		return prendas;
	}
	public void setPrendas(List<PrendaVentaDTO> prendas) {
		this.prendas = prendas;
	}
	public int getIdRemito() {
		return idRemito;
	}
	public void setIdRemito(int idRemito) {
		this.idRemito = idRemito;
	}
	public FacturaDTO getFactura() {
		return factura;
	}
	public void setFactura(FacturaDTO factura) {
		this.factura = factura;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	
	
}
