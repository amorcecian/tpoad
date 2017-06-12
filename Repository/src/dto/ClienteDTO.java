package dto;

import java.io.Serializable;
import java.util.List;

public class ClienteDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idCliente;
	private String nombre;
	private String direccion;
	//private CuentaCorriente cuentaCorriente;
	//private List<Pedido> pedidos;
	//private List<Factura> facturas;
	private String condicion;
	//private SucursalDTO sucursal;
	private boolean activo;
	private float limiteCredito;
	private String condicionPago;
	private float saldo;
	private float valorConsignacion;
	private Integer idSucu;
	
	
	public ClienteDTO(String nombre, String direccion, String condicion, float limiteCredito,
			String condPago, float saldo, float valorConsignacion, Integer idSucursa) {
		this.nombre=nombre;
		this.direccion=direccion;
		this.condicion=condicion;
		this.limiteCredito=limiteCredito;
		this.condicionPago=condPago;
		this.saldo=saldo;
		this.valorConsignacion=valorConsignacion;
		this.idSucu=idSucursa;		
	}
	
	public ClienteDTO(){}

	public Integer getIdSucu() {
		return idSucu;
	}

	public void setIdSucu(Integer idSucu) {
		this.idSucu = idSucu;
	}

	public float getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(float limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	public String getCondicionPago() {
		return condicionPago;
	}

	public void setCondicionPago(String condicionPago) {
		this.condicionPago = condicionPago;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public float getValorConsignacion() {
		return valorConsignacion;
	}

	public void setValorConsignacion(float valorConsignacion) {
		this.valorConsignacion = valorConsignacion;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	
	public Integer getIdCliente() {
		return idCliente;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCondicion() {
		return condicion;
	}
	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}/*
	public SucursalDTO getSucursal() {
		return sucursal;
	}
	public void setSucursal(SucursalDTO sucursal) {
		this.sucursal = sucursal;
	}*/
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	} 
	
	
}
