package dto;

import java.io.Serializable;

public class EmpleadoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer idEmpleado;
	private Integer idUsuario;
	private String nombre;
	private String mail;
	private String area;
	private String user;
	private String contrasenia;
	private Integer idSucu;
	private boolean activo;
	
	public EmpleadoDTO(){}
	
	public EmpleadoDTO(String nombre,String mail,String area,String user,String contraseña, Integer idSucursal){
		this.nombre=nombre;
		this.mail=mail;
		this.area=area;
		this.user=user;
		this.contrasenia=contraseña;
		this.idSucu=idSucursal;
	}
	
	
	public Integer getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
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
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public Integer getIdSucu() {
		return idSucu;
	}
	public void setIdSucu(Integer idSucu) {
		this.idSucu = idSucu;
	}

	
	
}
