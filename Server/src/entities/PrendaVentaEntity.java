package entities;

import javax.persistence.*;
import negocio.PrendaVenta;

@Entity
@Table(name="prendas_venta")
public class PrendaVentaEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_prenda_venta")
	private Integer idPrendaVenta;
	@Column(name="estado")
	private String estado;
	
	private Integer idLote;
	
	@ManyToOne
	@JoinColumn(name="idRemito")
	private RemitoEntity remito;
	
	@Column(name="activo")
	private boolean activo;

	
	public PrendaVentaEntity(){}


	public PrendaVentaEntity(PrendaVenta pv){
		this.idPrendaVenta = pv.getIdPrendaVenta();
		this.estado = pv.getEstado();
		this.idLote=pv.getIdLote();
		this.activo = true;
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
	public Integer getIdLote() {
		return idLote;
	}


	public void setIdLote(Integer idLote) {
		this.idLote = idLote;
	}


	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public RemitoEntity getRemito() {
		return remito;
	}

	public void setRemito(RemitoEntity remito) {
		this.remito = remito;
	}

	

		

}
