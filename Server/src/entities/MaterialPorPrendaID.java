package entities;

import java.io.Serializable;

import javax.persistence.*;

@Embeddable
public class MaterialPorPrendaID implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(fetch=FetchType.EAGER) 
	@JoinColumn(name="id_prenda",nullable=false)
	private PrendaEntity prenda;
	
	@ManyToOne(fetch=FetchType.EAGER) 
	@JoinColumn(name="id_material",nullable=false)
	private MaterialEntity material;
	
	public MaterialPorPrendaID(){}
	
	public MaterialPorPrendaID(PrendaEntity prenda, MaterialEntity material) {
		super();
		this.prenda = prenda;
		this.material = material;
	}

	public PrendaEntity getPrenda() {
		return prenda;
	}

	public void setPrenda(PrendaEntity prenda) {
		this.prenda = prenda;
	}

	public MaterialEntity getMaterial() {
		return material;
	}

	public void setMaterial(MaterialEntity material) {
		this.material = material;
	}
	
	

}
