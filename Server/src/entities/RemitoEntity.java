package entities;

import java.util.List;

import javax.persistence.*;

import negocio.PrendaVenta;

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
	@OneToMany
	@JoinColumn(name="id_prenda_venta")
	private List <PrendaVenta> prendas;
	@Column(name="estado")
	private String estado;
	
	public RemitoEntity(){}
	
	public RemitoEntity(Integer idRemito, FacturaEntity factura, boolean activo) {
		super();
		this.idRemito = idRemito;
		this.factura = factura;
		this.activo = activo;
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public List<PrendaVenta> getPrendas() {
		return prendas;
	}

	public void setPrendas(List<PrendaVenta> prendas) {
		this.prendas = prendas;
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
