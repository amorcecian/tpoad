package negocio;

import dto.MaterialDTO;
import entities.MaterialEntity;


public class Material {
	private Integer idMaterial;
	private String nombre;
	private Integer cantDisponible;
	private String proveedor;
	private float costo;
	private boolean activo;
	
	public Material(){}
	
	public Material(MaterialEntity me){}
	
	public Material(String nombre, Integer cantDisponible,
			Integer cantReservada, String proveedor, float costo, boolean activo) {
		super();
		this.nombre = nombre;
		this.cantDisponible = cantDisponible;
		this.proveedor = proveedor;
		this.costo = costo;
		this.activo = activo;
	}




	public Integer getIdMaterial() {
		return idMaterial;
	}

	public void setIdMaterial(Integer idMaterial) {
		this.idMaterial = idMaterial;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCantDisponible() {
		return cantDisponible;
	}

	public void setCantDisponible(Integer cantDisponible) {
		this.cantDisponible = cantDisponible;
	}


	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}
	
	

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public MaterialDTO toDTO() {
		MaterialDTO maux = new MaterialDTO();
		maux.setCantDisponible(this.cantDisponible);
		maux.setCosto(this.getCosto());
		maux.setIdMaterial(this.getIdMaterial());
		maux.setNombre(this.nombre);
		maux.setProveedor(this.getProveedor());
		return maux;
	}
	
	

}
