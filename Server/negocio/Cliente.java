package negocio;

import java.util.List;

import dto.ClienteDTO;
import entities.ClienteEntity;

public class Cliente {
	
	private Integer idCliente;
	private String nombre;
	private String direccion;
	private CuentaCorriente cuentaCorriente;
	private List<Pedido> pedidos;
	private List<Factura> facturas;
	private String condicion;
	private Sucursal sucursal;
	private boolean activo; 

	public Cliente(){}
	
	public Cliente(Integer idCliente, String nombre, String direccion,
			CuentaCorriente cuentaCorriente, List<Pedido> pedidos,
			List<Factura> facturas, String condicion, Sucursal sucursal, boolean activo) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.direccion = direccion;
		this.cuentaCorriente = cuentaCorriente;
		this.pedidos = pedidos;
		this.facturas = facturas;
		this.condicion = condicion;
		this.sucursal = sucursal;
		this.activo = activo;
	}
	
	public Cliente(ClienteEntity ce){
		CuentaCorriente cc = new CuentaCorriente(ce.getCuentaCorriente());
		Sucursal s = new Sucursal(ce.getSucursal());
		this.idCliente=ce.getIdCliente();
		this.nombre=ce.getNombre();
		this.direccion=ce.getDireccion();
		this.cuentaCorriente=cc;
		this.condicion=ce.getCondicion();
		this.sucursal=s;
		this.activo=ce.isactivo();
		
	}

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

	public CuentaCorriente getCuentaCorriente() {
		return cuentaCorriente;
	}

	public void setCuentaCorriente(CuentaCorriente cuentaCorriente) {
		this.cuentaCorriente = cuentaCorriente;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public String getCondicion() {
		return condicion;
	}

	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}
	public boolean isactivo() {
		return activo;
	}

	public void setactivo(boolean activo) {
		this.activo = activo;
	}
	
	public ClienteDTO toDTO(){
		ClienteDTO aux = new ClienteDTO();
		aux.setActivo(this.activo);
		aux.setCondicion(this.condicion);
		aux.setCondicionPago(this.cuentaCorriente.getCondicionPago());
		aux.setDireccion(this.direccion);
		aux.setIdSucu(this.getSucursal().getIdSucursal());
		aux.setLimiteCredito(this.cuentaCorriente.getLimiteCredito());
		aux.setNombre(this.nombre);
		aux.setSaldo(this.cuentaCorriente.getSaldo());
		aux.setValorConsignacion(this.cuentaCorriente.getValorConsignacion());
		aux.setIdCliente(this.getIdCliente());
		return aux;
	}
	
}
