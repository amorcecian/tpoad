package dto;

import java.io.Serializable;


public class SucursalDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idSucursal;
	private String nombre;
	private String domicilio;
	private String horario;
	private EmpleadoDTO encargado;
	private boolean activo;
	
	public SucursalDTO(){}
	
	
	public SucursalDTO(Integer idSucursal, String nombre, String domicilio,
			String horario, EmpleadoDTO encargado, boolean activo) {
		super();
		this.idSucursal = idSucursal;
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.horario = horario;
		this.encargado = encargado;
		this.activo = activo;
	}







	public int getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(int idSucursal) {
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

	public EmpleadoDTO getEncargado() {
		return encargado;
	}


	public void setEncargado(EmpleadoDTO encargado) {
		this.encargado = encargado;
	}


	public boolean isActivo() {
		return activo;
	}


	public void setActivo(boolean activo) {
		this.activo = activo;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public void setIdSucursal(Integer idSucursal) {
		this.idSucursal = idSucursal;
	}

	
	
	

}
