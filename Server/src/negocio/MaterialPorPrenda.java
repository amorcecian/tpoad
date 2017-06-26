package negocio;

import dto.MaterialporPrendaDTO;

public class MaterialPorPrenda {
	private int cantidad;
	private Material material;
	private int desperdicio;
	private boolean activo;
	
	public MaterialPorPrenda(){}
	
	public MaterialPorPrenda(int cantidad, Material material, int desperdicio,
			boolean activo) {
		super();
		this.cantidad = cantidad;
		this.material = material;
		this.desperdicio = desperdicio;
		this.activo = activo;
	}



	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
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
	
	
	public MaterialporPrendaDTO toDTO(){
		MaterialporPrendaDTO aux = new MaterialporPrendaDTO();
		aux.setActivo(this.isActivo());
		aux.setCantidad(this.getCantidad());
		aux.setDesperdicio(this.getDesperdicio());
		aux.setMaterial(this.getMaterial().toDTO());
		return aux;
	}

}
