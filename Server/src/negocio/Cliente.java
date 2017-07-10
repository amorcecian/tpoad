package negocio;

import java.util.List;

import dao.SucursalDAO;
import dto.ClienteDTO;
import dto.CuentaCorrienteDTO;
import dto.SucursalDTO;
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
	private String usuario;
	private String contrase�a;
	public Cliente(){}
	
	public Cliente(String nombre, String direccion,String usuario, String contrase�a,
			CuentaCorriente cuentaCorriente, List<Pedido> pedidos,
			List<Factura> facturas, String condicion, Sucursal sucursal, boolean activo) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.usuario=usuario;
		this.contrase�a=contrase�a;
		this.cuentaCorriente = cuentaCorriente;
		this.pedidos = pedidos;
		this.facturas = facturas;
		this.condicion = condicion;
		this.sucursal = sucursal;
		this.activo = activo;
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
		CuentaCorrienteDTO ccdto=new CuentaCorrienteDTO();
		SucursalDTO sdto=new SucursalDTO();
		
		aux.setIdCliente(idCliente);
		aux.setNombre(this.nombre);
		aux.setDireccion(this.direccion);
		aux.setCondicion(condicion);
		aux.setActivo(activo);
		
		ccdto.setLimiteCredito(cuentaCorriente.getLimiteCredito());
		ccdto.setCondicionPago(cuentaCorriente.getCondicionPago());
		ccdto.setSaldo(cuentaCorriente.getSaldo());
		ccdto.setValorConsignacion(cuentaCorriente.getValorConsignacion());
		
		aux.setCuentaCorriente(ccdto);
		
		sdto=SucursalDAO.getInstancia().recuperarSucursal(sucursal.getIdSucursal()).toDTO();
		
		aux.setSucursal(sdto);

		aux.setUsuario(usuario);
		aux.setContrase�a(contrase�a);
		
		return aux;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	
	
	
}
