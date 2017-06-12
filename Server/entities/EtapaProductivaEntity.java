package entities;

import javax.persistence.*;

@Entity
@Table(name="etapas_productivas")
public class EtapaProductivaEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_etapa_productiva")
	private Integer idEtapaProductiva;
	//private AreaProductivaEntity areaProductiva;
	@Column(name="tiempo_produccion")
	private Integer tiempoProduccion;
	@Column(name="orden")
	private Integer orden;
	
	public EtapaProductivaEntity(){}
	
	public EtapaProductivaEntity(Integer idEtapaProductiva,
			Integer tiempoProduccion, Integer orden) {
		super();
		this.idEtapaProductiva = idEtapaProductiva;
		this.tiempoProduccion = tiempoProduccion;
		this.orden = orden;
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
	
	

}
