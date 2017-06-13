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
	@Column(name="activo")
	private boolean activo;
	
	public RemitoEntity(){}
	
	public RemitoEntity(Integer idRemito, FacturaEntity factura, boolean activo) {
		super();
		this.idRemito = idRemito;
		this.factura = factura;
		this.activo = activo;
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

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
