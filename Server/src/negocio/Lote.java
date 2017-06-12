package negocio;

import entities.LoteEntity;

public class Lote {
	private int idLote;
	private Prenda prenda;
	private OrdenDeProduccion ordenDeProduccion;
	private int proceso;
	private String estado;
	private float costoProd;
	private Almacenamiento ubicacion;
	private int cantidadProducida;
	private int cantidadRestante;
	private boolean activo;
	
	public Lote(){}

	public Lote(int idLote, Prenda prenda, OrdenDeProduccion ordenDeProduccion,
			int proceso, String estado, float costoProd,
			Almacenamiento ubicacion, int cantidadProducida,
			int cantidadRestante, boolean activo) {
		super();
		this.idLote = idLote;
		this.prenda = prenda;
		this.ordenDeProduccion = ordenDeProduccion;
		this.proceso = proceso;
		this.estado = estado;
		this.costoProd = costoProd;
		this.ubicacion = ubicacion;
		this.cantidadProducida = cantidadProducida;
		this.cantidadRestante = cantidadRestante;
		this.activo = activo;
	}



	public int getIdLote() {
		return idLote;
	}

	public void setIdLote(int idLote) {
		this.idLote = idLote;
	}

	public Prenda getPrenda() {
		return prenda;
	}

	public void setPrenda(Prenda prenda) {
		this.prenda = prenda;
	}

	public OrdenDeProduccion getOrdenDeProduccion() {
		return ordenDeProduccion;
	}

	public void setOrdenDeProduccion(OrdenDeProduccion ordenDeProduccion) {
		this.ordenDeProduccion = ordenDeProduccion;
	}

	public int getProceso() {
		return proceso;
	}

	public void setProceso(int proceso) {
		this.proceso = proceso;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public float getCostoProd() {
		return costoProd;
	}

	public void setCostoProd(float costoProd) {
		this.costoProd = costoProd;
	}

	public Almacenamiento getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Almacenamiento ubicacion) {
		this.ubicacion = ubicacion;
	}

	public int getCantidadProducida() {
		return cantidadProducida;
	}

	public void setCantidadProducida(int cantidadProducida) {
		this.cantidadProducida = cantidadProducida;
	}

	public int getCantidadRestante() {
		return cantidadRestante;
	}

	public void setCantidadRestante(int cantidadRestante) {
		this.cantidadRestante = cantidadRestante;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public LoteEntity LoteToEntity() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
