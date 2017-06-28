package dto;

import java.io.Serializable;

public class MaterialporPrendaDTO  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int cantidad;
	private MaterialDTO material;
	private int desperdicio;
	private boolean activo;
	
	public MaterialporPrendaDTO(){}
	
	public MaterialporPrendaDTO(MaterialDTO material,int cantidad, int desperdicio){
		this.material=material;
		this.cantidad=cantidad;
		this.desperdicio=desperdicio;	
	}
	
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public MaterialDTO getMaterial() {
		return material;
	}
	public void setMaterial(MaterialDTO material) {
		this.material = material;
	}
	public int getDesperdicio() {
		return desperdicio;
	}
	public void setDesperdicio(int desperdicio) {
		this.desperdicio = desperdicio;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	
	
}
