package negocio;

public class ItemOCMP {
	private int cantidad;
	private Material material;
	private float precio;
	private boolean activo;
	
	public ItemOCMP(){}
	
	

	public ItemOCMP(int cantidad, Material material, float precio,
			boolean activo) {
		super();
		this.cantidad = cantidad;
		this.material = material;
		this.precio = precio;
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

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}



	public boolean isActivo() {
		return activo;
	}



	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	

}
