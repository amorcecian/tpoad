package negocio;

public class OrdenModificacion {
	private Empleado encargado;
	private int cantidad;
	private Empleado autorizado;
	private String comentarios;
	private Prenda prenda;
	private boolean activo;
	
	public OrdenModificacion(){}
	
	

	public OrdenModificacion(Empleado encargado, int cantidad,
			Empleado autorizado, String comentarios, Prenda prenda,
			boolean activo) {
		super();
		this.encargado = encargado;
		this.cantidad = cantidad;
		this.autorizado = autorizado;
		this.comentarios = comentarios;
		this.prenda = prenda;
		this.activo = activo;
	}



	public Empleado getEncargado() {
		return encargado;
	}

	public void setEncargado(Empleado encargado) {
		this.encargado = encargado;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Empleado getAutorizado() {
		return autorizado;
	}

	public void setAutorizado(Empleado autorizado) {
		this.autorizado = autorizado;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public Prenda getPrenda() {
		return prenda;
	}

	public void setPrenda(Prenda prenda) {
		this.prenda = prenda;
	}



	public boolean isActivo() {
		return activo;
	}



	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	
	

}
