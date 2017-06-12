package entities;

import javax.persistence.*;

@Entity
@Table(name="remitos")
public class RemitoEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_remito")
	private Integer idRemito;
	@OneToOne
	@JoinColumn(name="id_facutra")
	private FacturaEntity factura;
	
	public RemitoEntity(){}
	
	public RemitoEntity(Integer idRemito, FacturaEntity factura) {
		super();
		this.idRemito = idRemito;
		this.factura = factura;
	}

	public Integer getIdRemito() {
		return idRemito;
	}

	public void setIdRemito(Integer idRemito) {
		this.idRemito = idRemito;
	}

	public FacturaEntity getFactura() {
		return factura;
	}

	public void setFactura(FacturaEntity factura) {
		this.factura = factura;
	}
	
	

}
