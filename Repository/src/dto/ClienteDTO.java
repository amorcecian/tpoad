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
	private CuentaCorrienteDTO cuentaCorriente;
	private List<PedidoDTO> pedidos;
	private List<FacturaDTO> facturas;
	private String condicion;
	private SucursalDTO sucursal;
	private boolean activo;
	private String usuario;
	private String contraseña;
	
	public ClienteDTO(){}


	public Integer getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
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


	public CuentaCorrienteDTO getCuentaCorriente() {
		return cuentaCorriente;
	}


	public void setCuentaCorriente(CuentaCorrienteDTO cuentaCorriente) {
		this.cuentaCorriente = cuentaCorriente;
	}


	public List<PedidoDTO> getPedidos() {
		return pedidos;
	}


	public void setPedidos(List<PedidoDTO> pedidos) {
		this.pedidos = pedidos;
	}


	public List<FacturaDTO> getFacturas() {
		return facturas;
	}


	public void setFacturas(List<FacturaDTO> facturas) {
		this.facturas = facturas;
	}


	public String getCondicion() {
		return condicion;
	}


	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}


	public SucursalDTO getSucursal() {
		return sucursal;
	}


	public void setSucursal(SucursalDTO sucursal) {
		this.sucursal = sucursal;
	}


	public boolean isActivo() {
		return activo;
	}


	public void setActivo(boolean activo) {
		this.activo = activo;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getContraseña() {
		return contraseña;
	}


	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
		
	
}
