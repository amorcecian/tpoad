package entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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

	@Column(name="activo")
	private boolean activo;
	
	@Column(name="id_lote")
	private Integer idLote;

	public LineaProductivaEntity(){}

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


	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Integer getIdLote() {
		return idLote;
	}

	public void setIdLote(Integer idLote) {
		this.idLote = idLote;
	}

}
