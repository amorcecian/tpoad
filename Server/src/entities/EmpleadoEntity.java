package entities;

import java.io.Serializable;

import javax.persistence.*;

import dto.EmpleadoDTO;


@Entity
@Table(name="empleados")
public class EmpleadoEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_empleado",nullable=false)
	private Integer idEmpleado;
	@Column(name="nombre")
	private String nombre;
	@Column(name="mail")
	private String mail;
	@Column(name="area")
	private String area;
	@Column(name="usuario")
	private String user;
	@Column(name="contrasenia")
	private String contrasenia;
	@OneToOne
	@JoinColumn(name="id_sucursal")
	private SucursalEntity sucursal;
	@Column(name="activo")
	private boolean activo;
	
	
	// ******************************************************
	// Constructor
	// *****************************************************


	public EmpleadoEntity(){}
	
	
	public EmpleadoEntity(Integer idEmpleado, String nombre, String mail, String area, String user, String contrasenia,
			SucursalEntity sucursal, boolean activo) {
		super();
		this.idEmpleado=idEmpleado;
		this.nombre = nombre;
		this.mail = mail;
		this.area = area;
		this.user = user;
		this.contrasenia = contrasenia;
		this.sucursal = sucursal;
		this.activo = activo;
	}


	// ******************************************************
	// Getters y Setters
	// *****************************************************
	



	public Integer getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public SucursalEntity getSucursal() {
		return sucursal;
	}

	public void setSucursal(SucursalEntity sucursal) {
		this.sucursal = sucursal;
	}


}
