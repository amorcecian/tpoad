package entities;

import java.io.Serializable;
//import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="sucursales")
public class SucursalEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id_sucursal",nullable=false)
	private Integer idSucursal;
	private String nombre;
	private String domicilio;
	private String horario;
	@OneToOne
	@JoinColumn(name="id_encargado")
	private EmpleadoEntity encargado;
	
	/*
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="id_sucursal")
	private List<EmpleadoEntity> empleados;
	
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="id_sucursal")
	private List<ClientesEntity> clientes;
	*/
	
	
	// ******************************************************
	// Constructor
	// *****************************************************
	
	public SucursalEntity(){};
	
	public SucursalEntity(Integer idSucursal,String nombre,String domicilio, String horario, EmpleadoEntity encargado){
		this.idSucursal=idSucursal;
		this.nombre=nombre;
		this.domicilio=domicilio;
		this.horario=horario;
		this.encargado=encargado;
	}
	
	public SucursalEntity(Integer idSucursal,String nombre,String domicilio, String horario){
		this.idSucursal=idSucursal;
		this.nombre=nombre;
		this.domicilio=domicilio;
		this.horario=horario;
	}
	
	
	// ******************************************************
	// Getters y Setters
	// *****************************************************
	
	public Integer getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(Integer idSucursal) {
		this.idSucursal = idSucursal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public EmpleadoEntity getEncargado() {
		return encargado;
	}

	public void setEncargado(EmpleadoEntity encargado) {
		this.encargado = encargado;
	}
	
	
	

}
