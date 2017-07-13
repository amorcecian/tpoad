package entities;

import javax.persistence.*;

import negocio.Material;

@Entity
@Table(name="material_prenda")
public class MaterialPorPrendaEntity {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_MaterialPrenda")
	private Integer id;
	
	@Column(name="cantidad")
	private Integer cantidad;
	
	@Column(name="desperdicio")
	private Integer desperdicio;
	
	@Column(name="activo")
	private boolean activo;
	
	@OneToOne
	@JoinColumn(name="id_material")
	private MaterialEntity material;
	
	@ManyToOne
	@JoinColumn(name="id_prenda")
	private PrendaEntity prenda;
	
	public MaterialPorPrendaEntity(){};
	
	
	public MaterialPorPrendaEntity(MaterialEntity material, Integer cantidad,
			Integer desperdicio, boolean activo) {
		super();
		this.cantidad = cantidad;
		this.desperdicio = desperdicio;
		this.activo = activo;
	}
	

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getCantidad() {
		return cantidad;
	}


	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getDesperdicio() {
		return desperdicio;
	}


	public void setDesperdicio(Integer desperdicio) {
		this.desperdicio = desperdicio;
	}


	public boolean isActivo() {
		return activo;
	}


	public void setActivo(boolean activo) {
		this.activo = activo;
	}


	public MaterialEntity getMaterial() {
		return material;
	}


	public void setMaterial(MaterialEntity material) {
		this.material = material;
	}
	
	
	

}
