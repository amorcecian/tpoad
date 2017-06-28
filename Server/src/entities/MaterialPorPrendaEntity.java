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
	@JoinColumn(name="id_prenda")
	private PrendaEntity prenda;
	
	@ManyToOne
	@JoinColumn(name="id_material")
	private MaterialEntity material;
	
	@Column(name="desperdicio")
	private Integer desperdicio;
	
	@Column(name="activo")
	private boolean activo;
	
	public MaterialPorPrendaEntity(){};
	
	
	public MaterialPorPrendaEntity(Integer idMaterialPrenda, Integer cantidad,
			MaterialEntity material, Integer desperdicio, boolean activo) {
		super();
		this.idMaterialPrenda = idMaterialPrenda;
		this.cantidad = cantidad;
		this.material = material;
		this.desperdicio = desperdicio;
		this.activo = activo;
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


	public boolean isActivo() {
		return activo;
	}


	public void setActivo(boolean activo) {
		this.activo = activo;
	}


	public PrendaEntity getPrenda() {
		return prenda;
	}


	public void setPrenda(PrendaEntity prenda) {
		this.prenda = prenda;
	}
			
	

}
