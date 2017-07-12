package entities;

import javax.persistence.*;

@Entity
@Table(name="lotes")
public class LoteEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_lote",nullable=false)
	private Integer idLote;
	
	/*
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_prenda",nullable=false)
	private PrendaEntity prenda;
	*/
	
	
	@ManyToOne
	@JoinColumn(name="id_orden_lote")
	private OrdenDeProduccionEntity ordenDeProduccion;
	
	/*
	@ManyToOne
	@JoinColumn(name="id_lote_pendiente")
	private AreaProductivaEntity areaProductiva;
	*/
	@Column(name="estado")
	private String estado;
	@Column(name="costoProd")
	private float costoProd;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_almacenamiento")
	private AlmacenamientoEntity ubicacion;
	
	@Column(name="cantidadProducida")
	private Integer cantidadProducida;
	@Column(name="cantidadRestante")
	private Integer cantidadRestante;
	@Column(name="activo")
	private boolean activo;
	@Column(name="proceso")
	private int proceso;
	
	public LoteEntity(){}


	public Integer getIdLote() {
		return idLote;
	}

	public void setIdLote(Integer idLote) {
		this.idLote = idLote;
	}

	/*
	public PrendaEntity getPrenda() {
		return prenda;
	}

	public void setPrenda(PrendaEntity prenda) {
		this.prenda = prenda;
	}*/
	
	
	public OrdenDeProduccionEntity getOrdenDeProduccion() {
		return ordenDeProduccion;
	}

	public void setOrdenDeProduccion(OrdenDeProduccionEntity ordenDeProduccion) {
		this.ordenDeProduccion = ordenDeProduccion;
	}
	/*
	public Integer getProceso() {
		return proceso;
	}

	public void setProceso(Integer proceso) {
		this.proceso = proceso;
	}
*/
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public float getCostoProd() {
		return costoProd;
	}

	public void setCostoProd(float costoProd) {
		this.costoProd = costoProd;
	}

	public AlmacenamientoEntity getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(AlmacenamientoEntity ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Integer getCantidadProducida() {
		return cantidadProducida;
	}

	public int getProceso() {
		return proceso;
	}


	public void setProceso(int i) {
		this.proceso = i;
	}


	public void setCantidadProducida(Integer cantidadProducida) {
		this.cantidadProducida = cantidadProducida;
	}

	public Integer getCantidadRestante() {
		return cantidadRestante;
	}

	public void setCantidadRestante(Integer cantidadRestante) {
		this.cantidadRestante = cantidadRestante;
	}



	public boolean isActivo() {
		return activo;
	}



	public void setActivo(boolean activo) {
		this.activo = activo;
	}


	/*
	public AreaProductivaEntity getAreaProductiva() {
		return areaProductiva;
	}
	public void setAreaProductiva(AreaProductivaEntity areaProductiva) {
		this.areaProductiva = areaProductiva;
	}*/
	
	
	
	
	
	
}
