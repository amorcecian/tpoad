package negocio;

import java.util.List;

public class OrdenCMP {
	private Integer idODCM;
	private String fechaPedido;
	private String fechaEstDespacho;
	private String fechaRealDespacho;
	private List<ItemOCMP> itemPedidoInsumo;
	private OrdenDeProduccion ordenDeProduccion;
	private String estado;
	private float loteValor;
	private boolean activo;
	
	public OrdenCMP(){}
	
	
	public OrdenCMP(Integer idODCM, String fechaPedido,
			String fechaEstDespacho, String fechaRealDespacho,
			List<ItemOCMP> itemPedidoInsumo,
			OrdenDeProduccion ordenDeProduccion, String estado,
			float loteValor, boolean activo) {
		super();
		this.idODCM = idODCM;
		this.fechaPedido = fechaPedido;
		this.fechaEstDespacho = fechaEstDespacho;
		this.fechaRealDespacho = fechaRealDespacho;
		this.itemPedidoInsumo = itemPedidoInsumo;
		this.ordenDeProduccion = ordenDeProduccion;
		this.estado = estado;
		this.loteValor = loteValor;
		this.activo = activo;
	}




	public Integer getIdODCM() {
		return idODCM;
	}



	public void setIdODCM(Integer idODCM) {
		this.idODCM = idODCM;
	}

	

	public List<ItemOCMP> getItemPedidoInsumo() {
		return itemPedidoInsumo;
	}


	public void setItemPedidoInsumo(List<ItemOCMP> itemPedidoInsumo) {
		this.itemPedidoInsumo = itemPedidoInsumo;
	}


	public String getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(String fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public String getFechaEstDespacho() {
		return fechaEstDespacho;
	}

	public void setFechaEstDespacho(String fechaEstDespacho) {
		this.fechaEstDespacho = fechaEstDespacho;
	}

	public String getFechaRealDespacho() {
		return fechaRealDespacho;
	}

	public void setFechaRealDespacho(String fechaRealDespacho) {
		this.fechaRealDespacho = fechaRealDespacho;
	}


	public OrdenDeProduccion getOrdenDeProduccion() {
		return ordenDeProduccion;
	}

	public void setOrdenDeProduccion(OrdenDeProduccion ordenDeProduccion) {
		this.ordenDeProduccion = ordenDeProduccion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public float getLoteValor() {
		return loteValor;
	}

	public void setLoteValor(float loteValor) {
		this.loteValor = loteValor;
	}


	public boolean isActivo() {
		return activo;
	}


	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	

}
