package entities;

import javax.persistence.*;

import dto.MaterialDTO;
import negocio.Material;

@Entity
@Table(name="materiales")
public class MaterialEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_material")
	private Integer idMaterial;
	@Column(name="nombre")
	private String nombre;
	@Column(name="cantidad_disponible")
	private Integer cantDisponible;
	@Column(name="proveedor")
	private String proveedor;
	@Column(name="costo")
	private float costo;
	@Column(name="activo")
	private boolean activo;
	
	@OneToOne
	@JoinColumn(name="id_material")
	private MaterialPorPrendaEntity materialPorPrenda;
	
	public MaterialEntity(){};

	public MaterialEntity(Integer idMaterial, String nombre,
			Integer cantDisponible, Integer cantReservada, String proveedor,
			float costo, boolean activo) {
		super();
		this.idMaterial = idMaterial;
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

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
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
		maux.setActivo(this.activo);
		return maux;
	}

	public Material toNegocio() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	

}
