package entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="lineas_productivas")
public class LineaProductivaEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_linea")
	private Integer idLinea;
	
	@Column(name="estado")
	private String estado;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_area_productiva",nullable=true)
	private AreaProductivaEntity areaProductiva;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_lote",nullable=true)
	private LoteEntity lote;
	
	@Column(name="activo")
	private boolean activo;

	public LineaProductivaEntity(){}
	
	public AreaProductivaEntity getAreaProductiva() {
		return areaProductiva;
	}

	public void setAreaProductiva(AreaProductivaEntity areaProductiva) {
		this.areaProductiva = areaProductiva;
	}

	public Integer getIdLinea() {
		return idLinea;
	}

	public void setIdLinea(Integer idLinea) {
		this.idLinea = idLinea;
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
