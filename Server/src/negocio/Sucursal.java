package negocio;

import dto.SucursalDTO;
import entities.*;

public class Sucursal {
	
	private Integer idSucursal;
	private String nombre;
	private String domicilio;
	private String horario;
	private Empleado encargado;
	//private List<Empleado> empleados;
	//List <Cliente> clientes;
	private boolean activo;
	
	public Sucursal(SucursalEntity sucursal){
		this.idSucursal=sucursal.getIdSucursal();
		this.nombre=sucursal.getNombre();
		this.domicilio=sucursal.getDomicilio();
		this.horario=sucursal.getHorario();
		//this.empleados=sucursal.getEmpleados();
	}
	
	
	
	
	public Sucursal(Integer idSucursal, String nombre, String domicilio,
			String horario, boolean activo) {
		super();
		this.idSucursal = idSucursal;
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.horario = horario;
		this.activo = activo;
	}
	
	
	public Sucursal(Integer idSucursal, String nombre, String domicilio,
			String horario, Empleado encargado, boolean activo) {
		super();
		this.idSucursal = idSucursal;
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.horario = horario;
		this.encargado = encargado;
		this.activo = activo;
	}




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

	/*
	public List<Cliente> getClientes() {
		return clientes;
	}
	
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	};
	*/
	
	public Empleado getEncargado() {
		return encargado;
	}

	public void setEncargado(Empleado encargado) {
		this.encargado = encargado;
	}
	
	public boolean isActivo() {
		return activo;
	}




	public void setActivo(boolean activo) {
		this.activo = activo;
	}




	public SucursalDTO toDTO(){
		return new SucursalDTO(idSucursal,nombre,domicilio,horario);
	}
	

}
