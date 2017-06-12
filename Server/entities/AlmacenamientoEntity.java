package entities;

import javax.persistence.*;

import dto.AlmacenamientoDTO;


@Entity
@Table(name="almacenamientos")
public class AlmacenamientoEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_almacenamiento", nullable=false)
	private Integer idAlmacenamiento;
	@Column(name="calle")
	private String calle;
	@Column(name="bloque")
	private Integer bloque;
	@Column(name="estante")
	private Integer estante;
	@Column(name="posicion")
	private Integer posicion;
	@Column(name="libre")
	private boolean libre;
	@ManyToOne
	@JoinColumn(name="id_lote")
	private LoteEntity lote;
	
	public AlmacenamientoEntity(){}

	public AlmacenamientoEntity(Integer idAlmacenamiento, String calle,
			Integer bloque, Integer estante, Integer posicion, boolean libre,
			LoteEntity lote) {
		super();
		this.idAlmacenamiento = idAlmacenamiento;
		this.calle = calle;
		this.bloque = bloque;
		this.estante = estante;
		this.posicion = posicion;
		this.libre = libre;
		this.lote = lote;
	}

	public Integer getIdAlmacenamiento() {
		return idAlmacenamiento;
	}

	public void setIdAlmacenamiento(Integer idAlmacenamiento) {
		this.idAlmacenamiento = idAlmacenamiento;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Integer getBloque() {
		return bloque;
	}

	public void setBloque(Integer bloque) {
		this.bloque = bloque;
	}

	public Integer getEstante() {
		return estante;
	}

	public void setEstante(Integer estante) {
		this.estante = estante;
	}

	public Integer getPosicion() {
		return posicion;
	}

	public void setPosicion(Integer posicion) {
		this.posicion = posicion;
	}

	public boolean isLibre() {
		return libre;
	}

	public void setLibre(boolean libre) {
		this.libre = libre;
	}

	public LoteEntity getLote() {
		return lote;
	}

	public void setLote(LoteEntity lote) {
		this.lote = lote;
	}

	public AlmacenamientoDTO toDTO() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	

}
