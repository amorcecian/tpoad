package entities;

import javax.persistence.*;

@Entity
@Table(name="etapas_productivas")
public class EtapaProductivaEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_etapa_productiva")
	private Integer idEtapaProductiva;
	
	@OneToOne(cascade=CascadeType.ALL)
	//@PrimaryKeyJoinColumn
	@JoinColumn(name="id_area_productiva")
	private AreaProductivaEntity areaProductiva;
	
	@Column(name="tiempo_produccion")
	private Integer tiempoProduccion;
	
	@ManyToOne
	@JoinColumn(name="id_prenda")
	private PrendaEntity Prenda;
	
	@Column(name="orden")
	private Integer orden;
	
	@Column(name="activo")
	private boolean activo;
	
	public EtapaProductivaEntity(){}
	
	
	public EtapaProductivaEntity(Integer idEtapaProductiva,
			Integer tiempoProduccion, Integer orden, boolean activo) {
		super();
		this.idEtapaProductiva = idEtapaProductiva;
		this.tiempoProduccion = tiempoProduccion;
		this.orden = orden;
		this.activo = activo;
	}



	public Integer getIdEtapaProductiva() {
		return idEtapaProductiva;
	}

	public void setIdEtapaProductiva(Integer idEtapaProductiva) {
		this.idEtapaProductiva = idEtapaProductiva;
	}

	public Integer getTiempoProduccion() {
		return tiempoProduccion;
	}

	public void setTiempoProduccion(Integer tiempoProduccion) {
		this.tiempoProduccion = tiempoProduccion;
	}

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}


	public boolean isActivo() {
		return activo;
	}


	public void setActivo(boolean activo) {
		this.activo = activo;
	}


	public AreaProductivaEntity getAreaProductiva() {
		return areaProductiva;
	}


	public void setAreaProductiva(AreaProductivaEntity areaProductiva) {
		this.areaProductiva = areaProductiva;
	}
	
	

}
