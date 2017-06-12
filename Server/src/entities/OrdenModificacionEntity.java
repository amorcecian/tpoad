package entities;

import javax.persistence.*;

@Entity
@Table(name="ordenes_modificacion")
public class OrdenModificacionEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_orden_modificacion")
	private Integer idOrdenModificacion;
	@OneToMany
	@JoinColumn(name="id_empleado_encargado")
	private EmpleadoEntity encargado;
	@Column(name="cantidad")
	private Integer cantidad;
	@OneToMany
	@JoinColumn(name="id_empleado_autorizado")
	private EmpleadoEntity autorizado;
	@Column(name="comentarios")
	private String comentarios;
	@ManyToOne
	@JoinColumn(name="id_prenda")
	private PrendaEntity prenda;
	
	public OrdenModificacionEntity(){}
	
	public OrdenModificacionEntity(Integer idOrdenModificacion,
			EmpleadoEntity encargado, Integer cantidad,
			EmpleadoEntity autorizado, String comentarios, PrendaEntity prenda) {
		super();
		this.idOrdenModificacion = idOrdenModificacion;
		this.encargado = encargado;
		this.cantidad = cantidad;
		this.autorizado = autorizado;
		this.comentarios = comentarios;
		this.prenda = prenda;
	}
	public Integer getIdOrdenModificacion() {
		return idOrdenModificacion;
	}
	public void setIdOrdenModificacion(Integer idOrdenModificacion) {
		this.idOrdenModificacion = idOrdenModificacion;
	}
	public EmpleadoEntity getEncargado() {
		return encargado;
	}
	public void setEncargado(EmpleadoEntity encargado) {
		this.encargado = encargado;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public EmpleadoEntity getAutorizado() {
		return autorizado;
	}
	public void setAutorizado(EmpleadoEntity autorizado) {
		this.autorizado = autorizado;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	public PrendaEntity getPrenda() {
		return prenda;
	}
	public void setPrenda(PrendaEntity prenda) {
		this.prenda = prenda;
	}
	
}
