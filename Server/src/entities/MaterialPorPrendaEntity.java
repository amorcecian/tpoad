package entities;

import javax.persistence.*;

@Entity
@Table(name="material_prenda")
public class MaterialPorPrendaEntity {
	
/*	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_material_prenda",nullable=false)
	private Integer idMaterialPrenda;
*/	
	
	@EmbeddedId
	private MaterialPorPrendaID id;
	
	@Column(name="cantidad")
	private Integer cantidad;
/*	
	@ManyToOne
	@JoinColumn(name="id_prenda")
	private PrendaEntity prenda;
	
	@ManyToOne
	@JoinColumn(name="id_material")
	private MaterialEntity material;
*/	
	@Column(name="desperdicio")
	private Integer desperdicio;
	
	@Column(name="activo")
	private boolean activo;
	
	//public MaterialPorPrendaEntity(){};
	
	/*
	public MaterialPorPrendaEntity(MaterialPorPrendaID id, Integer cantidad,
			Integer desperdicio, boolean activo) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.desperdicio = desperdicio;
		this.activo = activo;
	}*/
	
	public MaterialPorPrendaEntity(MaterialEntity material, Integer cantidad,
			Integer desperdicio, boolean activo, PrendaEntity prenda) {
		super();
		this.id = new MaterialPorPrendaID(prenda,material);
		this.cantidad = cantidad;
		this.desperdicio = desperdicio;
		this.activo = activo;
	}

	public MaterialPorPrendaID getId() {
		return id;
	}


	public void setId(MaterialPorPrendaID id) {
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
	

}
