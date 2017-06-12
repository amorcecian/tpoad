package negocio;

import dto.EmpleadoDTO;
import entities.*;

public class Empleado {
	
	private Integer idEmpleado;
	private Integer idUsuario;
	private String nombre;
	private String mail;
	private String area;
	private String user;
	private String contrasenia;
	private Sucursal sucursal;
	private boolean activo;
	
	public Empleado(EmpleadoEntity empleado){
		this.idEmpleado=empleado.getIdEmpleado();
		this.idUsuario=empleado.getIdUsuario();
		this.nombre=empleado.getNombre();
		this.mail=empleado.getMail();
		this.area=empleado.getArea();
		this.user=empleado.getUser();
		this.contrasenia=empleado.getContrasenia();
		this.sucursal=new Sucursal(empleado.getSucursal());
		this.activo=empleado.isActivo();
	}
/*	
	public Empleado(String nombre,String mail,String area,String user,String contraseña,Sucursal sucursal){
		this.nombre=nombre;
		this.mail=mail;
		this.area=area;
		this.user=user;
		this.contrasenia=user;
		this.sucursal=sucursal;
	}
*/

	public Empleado() {
		// TODO Auto-generated constructor stub
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

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public Integer getIdUsuario() {
		return this.idUsuario;
	}


	public EmpleadoDTO toDTO() {
		EmpleadoDTO e = new EmpleadoDTO();
		e.setArea(this.area);
		e.setContrasenia(this.contrasenia);
		e.setIdSucu(this.sucursal.getIdSucursal());
		e.setIdUsuario(this.idUsuario);
		e.setMail(this.mail);
		e.setNombre(this.nombre);
		e.setUser(this.user);
		e.setContrasenia(this.contrasenia);
		e.setActivo(this.activo);
		e.setUser(this.user);
		e.setIdEmpleado(this.idEmpleado);
		return e;
	}
	
}
