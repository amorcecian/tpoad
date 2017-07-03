package entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="areas_productivas")
public class AreaProductivaEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_area_productiva",nullable=false)
	private Integer idAreaProductiva;
	
	@Column(name="nombre")
	private String nombre;
	
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="id_linea")
	private List<LineaProductivaEntity> lineas;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="id_lote")
	private List<LoteEntity> lotesPendientes;
	
	@Column(name="activo")
	private boolean activo;

	
	
	public AreaProductivaEntity(){}
	
	public Integer getIdAreaProductiva() {
		return idAreaProductiva;
	}

	public void setIdAreaProductiva(Integer idAreaProductiva) {
		this.idAreaProductiva = idAreaProductiva;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<LineaProductivaEntity> getLineas() {
		return lineas;
	}

	public void setLineas(List<LineaProductivaEntity> lineas) {
		this.lineas = lineas;
	}

	public List<LoteEntity> getLotesPendientes() {
		return lotesPendientes;
	}

	public void setLotesPendientes(List<LoteEntity> lotesPendientes) {
		this.lotesPendientes = lotesPendientes;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	
	
	
	

}
