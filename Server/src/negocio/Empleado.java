package negocio;

import dto.EmpleadoDTO;
import entities.*;

public class Empleado {
	
	private Integer idEmpleado;
	private String nombre;
	private String mail;
	private String area;
	private String user;
	private String contrasenia;
	private Sucursal sucursal;
	private boolean activo;
	

	public Empleado() {}

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

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	
	public Integer getIdEmpleado() {
		return this.idEmpleado;
	}



	public EmpleadoDTO toDTO() {
		EmpleadoDTO e = new EmpleadoDTO();
		e.setIdEmpleado(idEmpleado);
		e.setNombre(nombre);
		e.setArea(area);
		e.setContrasenia(contrasenia);
		e.setIdSucu(sucursal.getIdSucursal());
		e.setMail(mail);		
		e.setUser(user);
		e.setContrasenia(contrasenia);
		e.setActivo(activo);
		e.setUser(user);		
		return e;
	}
	
	
	
}
