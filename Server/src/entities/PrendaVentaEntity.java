package entities;

import javax.persistence.*;

import dao.LoteDAO;
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
	@OneToOne
	@JoinColumn(name="id_lote")
	private LoteEntity lote;
	@Column(name="activo")
	private boolean activo;
	
	public PrendaVentaEntity(){}
	
	

	public PrendaVentaEntity(Integer idPrendaVenta, String estado,
			LoteEntity lote, boolean activo) {
		super();
		this.idPrendaVenta = idPrendaVenta;
		this.estado = estado;
		this.lote = lote;
		this.activo = activo;
	}
	
	public PrendaVentaEntity(PrendaVenta pv){
		this.idPrendaVenta = pv.getIdPrendaVenta();
		this.estado = pv.getEstado();
		LoteEntity lote = LoteDAO.getInstancia().toEntity(pv.getLote());
		this.lote = lote;
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

	public LoteEntity getLote() {
		return lote;
	}

	public void setLote(LoteEntity lote) {
		this.lote = lote;
	}



	public boolean isActivo() {
		return activo;
	}



	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	
	
	

}
