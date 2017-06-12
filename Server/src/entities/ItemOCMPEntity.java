package entities;

import javax.persistence.*;

@Entity
@Table(name="items_ocmp")
public class ItemOCMPEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_items_ocmp",nullable=false)
	private Integer idItemsOCMP;
	@ManyToOne
	@JoinColumn(name="id_material")
	private MaterialEntity material;
	@Column(name="cantidad")
	private Integer cantidad;
	@Column(name="precio")
	private float precio;
	
	public ItemOCMPEntity(){};
	
	public ItemOCMPEntity(Integer idItemsOCMP, MaterialEntity material,
			Integer cantidad, float precio) {
		super();
		this.idItemsOCMP = idItemsOCMP;
		this.material = material;
		this.cantidad = cantidad;
		this.precio = precio;
	}



	public Integer getIdItemsOCMP() {
		return idItemsOCMP;
	}



	public void setIdItemsOCMP(Integer idItemsOCMP) {
		this.idItemsOCMP = idItemsOCMP;
	}



	public MaterialEntity getMaterial() {
		return material;
	}



	public void setMaterial(MaterialEntity material) {
		this.material = material;
	}



	public Integer getCantidad() {
		return cantidad;
	}



	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}



	public float getPrecio() {
		return precio;
	}



	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
	
	
	
}
