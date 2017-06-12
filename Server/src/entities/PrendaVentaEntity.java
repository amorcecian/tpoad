package entities;

import javax.persistence.*;

@Entity
@Table(name="prendas_venta")
public class PrendaVentaEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_prenda_venta")
	private Integer idPrendaVenta;
	@Column(name="estado")
	private String estado;
	@OneToOne
	@JoinColumn(name="id_lote")
	private LoteEntity lote;
	
	public PrendaVentaEntity(){}
	
	public PrendaVentaEntity(Integer idPrendaVenta, String estado, LoteEntity lote) {
		super();
		this.idPrendaVenta = idPrendaVenta;
		this.estado = estado;
		this.lote = lote;
	}

	public Integer getIdPrendaVenta() {
		return idPrendaVenta;
	}

	public void setIdPrendaVenta(Integer idPrendaVenta) {
		this.idPrendaVenta = idPrendaVenta;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public LoteEntity getLote() {
		return lote;
	}

	public void setLote(LoteEntity lote) {
		this.lote = lote;
	}
	
	
	
	

}
