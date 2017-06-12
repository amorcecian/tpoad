package entities;

import javax.persistence.*;

@Entity
@Table(name="material_prenda")
public class MaterialPorPrendaEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_material_prenda",nullable=false)
	private Integer idMaterialPrenda;
	@Column(name="cantidad")
	private Integer cantidad;
	@ManyToOne
	@JoinColumn(name="id_material")
	private MaterialEntity material;
	@Column(name="desperdicio")
	private Integer desperdicio;
	
	public MaterialPorPrendaEntity(){};
	
	public MaterialPorPrendaEntity(Integer idMaterialPrenda, Integer cantidad,
			MaterialEntity material, Integer desperdicio) {
		super();
		this.idMaterialPrenda = idMaterialPrenda;
		this.cantidad = cantidad;
		this.material = material;
		this.desperdicio = desperdicio;
	}


	public Integer getIdMaterialPrenda() {
		return idMaterialPrenda;
	}


	public void setIdMaterialPrenda(Integer idMaterialPrenda) {
		this.idMaterialPrenda = idMaterialPrenda;
	}


	public Integer getCantidad() {
		return cantidad;
	}


	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}


	public MaterialEntity getMaterial() {
		return material;
	}


	public void setMaterial(MaterialEntity material) {
		this.material = material;
	}


	public Integer getDesperdicio() {
		return desperdicio;
	}


	public void setDesperdicio(Integer desperdicio) {
		this.desperdicio = desperdicio;
	}
	
	
	
	
	
	

}
