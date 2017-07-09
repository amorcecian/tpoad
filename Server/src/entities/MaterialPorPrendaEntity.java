package entities;

import javax.persistence.*;

@Entity
@Table(name="material_prenda")
public class MaterialPorPrendaEntity {
	
	
	@EmbeddedId
	private MaterialPorPrendaID id;
	
	@Column(name="cantidad")
	private Integer cantidad;
	
	@Column(name="desperdicio")
	private Integer desperdicio;
	
	@Column(name="activo")
	private boolean activo;
	
	public MaterialPorPrendaEntity(){};
	
	
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
