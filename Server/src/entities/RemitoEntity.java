package entities;

import java.util.List;
import java.util.Vector;

import javax.persistence.*;

import dao.FacturaDAO;
import dao.PrendaVentaDAO;
import negocio.PrendaVenta;
import negocio.Remito;

@Entity
@Table(name="remitos")
public class RemitoEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_remito")
	private Integer idRemito;
	
	@OneToOne
	@JoinColumn(name="id_factura")
	private FacturaEntity factura;
	
	@Column(name="activo")
	private boolean activo;
	
	@OneToMany
	@JoinColumn(name="idRemito")
	private List <PrendaVentaEntity> prendas;
	
	@Column(name="estado")
	private String estado;
	
	public RemitoEntity(){}
	
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public List<PrendaVentaEntity> getPrendas() {
		return prendas;
	}

	public void setPrendas(List<PrendaVentaEntity> prendas) {
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
