package controlador;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import businessDelegate.BusinessDelegate;
import negocio.*;
import dto.*;
import entities.ClienteEntity;
import entities.EmpleadoEntity;
import exceptions.ExceptionCliente;
import exceptions.ExceptionSucursal;
import dao.*;

public class ControladorVenta {
	
	private List<Cliente> clientes;
	private List<Pedido> pedidos;
	private List<Empleado> empleados;
	private List<Factura> facturas;
	private List<Remito> remitos;
	private List<Sucursal> sucursales;
	private List<NotaDeCredito> notasDeCredito;
	
	private static ControladorVenta instancia;
	
	public static ControladorVenta getInstancia(){
		if(instancia==null){
			instancia=new ControladorVenta();
		}
		return instancia;
	}
	
	//*********************************************************************************
	//METODOS CLIENTE
	//*********************************************************************************
	
		//Agrego un cliente 
	public void agregarCliente(ClienteDTO cliente) throws ExceptionCliente {
		Cliente c = new Cliente();			
		CuentaCorriente cc = new CuentaCorriente();
		cc.setLimiteCredito(cliente.getCuentaCorriente().getLimiteCredito());
		cc.setCondicionPago(cliente.getCuentaCorriente().getCondicionPago());		
		cc.setSaldo(cliente.getCuentaCorriente().getSaldo());
		cc.setValorConsignacion(cliente.getCuentaCorriente().getValorConsignacion());		
		c.setCuentaCorriente(cc);		
		Sucursal s = SucursalDAO.getInstancia().recuperarSucursal(cliente.getSucursal().getIdSucursal());
		c.setSucursal(s);
		c.setNombre(cliente.getNombre());		
		c.setCondicion(cliente.getCondicion());
		c.setDireccion(cliente.getDireccion());		
		c.setCuentaCorriente(cc);
		c.setactivo(true);
		c.setUsuario(cliente.getUsuario());
		c.setContraseña(cliente.getContraseña());	
		ClienteDAO.getInstance().grabarCliente(c);		
	}

		//Recuperar Cliente
	public ClienteDTO recuperarCliente(Integer idCliente) throws ExceptionCliente{
		return ClienteDAO.getInstance().recuperarCliente(idCliente).toDTO();
	}
		//Eliminar Cliente
	public void eliminarCliente(Integer idCliente) throws RemoteException{
		ClienteDAO.getInstance().eliminarCliente(idCliente);
	}
	

	
	//Actualizo Cliente
	public void actualizarCliente(ClienteDTO cliente) throws ExceptionCliente{	
		Cliente c = new Cliente();
		
		
		CuentaCorriente cc = new CuentaCorriente();
		cc.setLimiteCredito(cliente.getCuentaCorriente().getLimiteCredito());
		cc.setCondicionPago(cliente.getCuentaCorriente().getCondicionPago());		
		cc.setSaldo(cliente.getCuentaCorriente().getSaldo());
		cc.setValorConsignacion(cliente.getCuentaCorriente().getValorConsignacion());
		
		c.setCuentaCorriente(cc);
		
		Sucursal s = SucursalDAO.getInstancia().recuperarSucursal(cliente.getSucursal().getIdSucursal());

		c.setSucursal(s);
		c.setNombre(cliente.getNombre());		
		c.setCondicion(cliente.getCondicion());
		c.setDireccion(cliente.getDireccion());
		
		c.setCuentaCorriente(cc);
		c.setactivo(true);
		c.setIdCliente(cliente.getIdCliente());
		ClienteDAO.getInstance().actualizarCliente(c);
	}
	
	
	//Listar Todos Clientes	
	public List<ClienteDTO> listarClientes() throws ExceptionCliente{
		return ClienteDAO.getInstance().listarClientes();	
	}
	
	public float chequearCredito(Integer idCliente) throws ExceptionCliente{
		return (ClienteDAO.getInstance().recuperarCliente(idCliente).getCuentaCorriente().getSaldo() + ClienteDAO.getInstance().recuperarCliente(idCliente).getCuentaCorriente().getValorConsignacion());
	}
	
	//VALIDO CLIENTE
	public boolean validarCliente(String usuario,String contraseña){
		return ClienteDAO.getInstance().validarCliente(usuario, contraseña);
	}
	
	
	//*********************************************************************************
	//METODOS SUCURSAL
	//*********************************************************************************	
		//Agregar Sucursal
	public Integer agregarSucursal(SucursalDTO sucursal) {
		Sucursal sucu = new Sucursal();
		sucu.setNombre(sucursal.getNombre());
		sucu.setDomicilio(sucursal.getDomicilio());
		sucu.setHorario(sucursal.getHorario());
		sucu.setActivo(true);
		return SucursalDAO.getInstancia().agregarSucursal(sucu);
	}
	
	
	//Actualizo una sucursal
	public void actualizarSucursal(SucursalDTO sucursal){
		Sucursal sucu = new Sucursal();
		sucu.setIdSucursal(sucursal.getIdSucursal());
		sucu.setNombre(sucursal.getNombre());
		sucu.setDomicilio(sucursal.getDomicilio());
		sucu.setHorario(sucursal.getHorario());
		sucu.setActivo(true);
		
		if(sucursal.getEncargado()!=null){
			Empleado emp=EmpleadoDAO.getInstancia().recuperarEmpleado(sucursal.getEncargado().getIdEmpleado());
			sucu.setEncargado(emp);
		}else{
			sucu.setEncargado(null);
		}
		

		SucursalDAO.getInstancia().actualizarSucursal(sucu);		
	}
	
	//Recuperar Sucursal
	public SucursalDTO recuperarSucursal(Integer idSucursal){
		Sucursal sucu=SucursalDAO.getInstancia().recuperarSucursal(idSucursal);
		return sucu.toDTO();
	}
	
	//ELIMINO UNA SUCURSAL
	public void eliminarSucursal(Integer idSucursal){
		SucursalDAO.getInstancia().eliminarSucursal(idSucursal);
	}
	
	public List<SucursalDTO> listarSucursales(){
		return SucursalDAO.getInstancia().listarSucursales();	
	}
	
	
	public void asignarEncargado(Integer idSucursal,Integer idEmpleado){
		SucursalDAO.getInstancia().asignarEncargado(idSucursal,idEmpleado);
	}

	
	
	//*********************************************************************************
	//METODOS EMPLEADO
	//*********************************************************************************	
		//Agregar Empleado
	public void agregarEmpleado(EmpleadoDTO e) {
		Sucursal sucursal = SucursalDAO.getInstancia().recuperarSucursal(e.getIdSucu());
		Empleado empleado = new Empleado();
		empleado.setNombre(e.getNombre());
		empleado.setMail(e.getMail());
		empleado.setArea(e.getArea());
		empleado.setUser(e.getUser());
		empleado.setContrasenia(e.getContrasenia());
		empleado.setSucursal(sucursal);
		empleado.setActivo(true);
		EmpleadoDAO.getInstancia().grabarEmpleado(empleado);
		
	}
	
	//ACTUALIZO UN EMPLEADO
	public void actualizarEmpleado(EmpleadoDTO e) {		
		Empleado em = new Empleado();
		Sucursal s = SucursalDAO.getInstancia().recuperarSucursal(e.getIdSucu());
		em.setArea(e.getArea());
		em.setContrasenia(e.getContrasenia());
		em.setMail(e.getMail());
		em.setNombre(e.getNombre());
		em.setSucursal(s);
		em.setUser(e.getUser());
		em.setActivo(e.isActivo());
		em.setIdEmpleado(e.getIdEmpleado());
		EmpleadoDAO.getInstancia().actualizarEmpleado(em);
	}
	
	public void eliminarEmpleado(Integer idEmpleado){
		EmpleadoDAO.getInstancia().eliminarEmpleado(idEmpleado);
	}
	
	public EmpleadoDTO recuperarEmpleado(Integer idEmpleado){
		return EmpleadoDAO.getInstancia().recuperarEmpleado(idEmpleado).toDTO();
	}

	public List<EmpleadoDTO> listarEmpleados() {
		List<EmpleadoDTO> aux = new ArrayList<EmpleadoDTO>();
		List<Empleado> lstEmpleados=EmpleadoDAO.getInstancia().listarEmpleados();
		for(Empleado e:lstEmpleados){
			EmpleadoDTO edto=e.toDTO();
			aux.add(edto);
		}			
		return aux;	
	}
	
	//********************************************************************************************
	// METODOS PEDIDO
	//********************************************************************************************

	
	
	public PedidoDTO generarPedido(List<ItemPedidoDTO> itemsPedido, String fechaGeneracion, String fechaEstDespacho, 
			String fechaRealDespacho, float valor,Integer idCliente, Integer idSucursal, String estado,
			String motivoCancelar) throws ExceptionCliente{
			
		Pedido p = new Pedido();
		Cliente cliente = ClienteDAO.getInstance().recuperarCliente(idCliente);
		Sucursal sucursal = SucursalDAO.getInstancia().recuperarSucursal(idSucursal);
		List<ItemPedido> items = new Vector<ItemPedido>();
		ItemPedido aux = new ItemPedido();
		for(ItemPedidoDTO i:itemsPedido){
			
			//p.getItems().add(ItemsPedidoDAO.getInstance().toNegocio(i));
			}
			
			
			//Pedido pedido = new Pedido(itemsPedido, fechaGeneracion, fechaEstDespacho, fechaRealDespacho, valor, cliente, sucursal, estado, motivoCancelar, true)
		return p.toDTO();
	}

	/* Controlador de venta llama a controlador de Prod
	 * para verificar si tiene stock. Le envia el pedido
	 * El controlador de prod tiene una funcion que se llama 
	 * verificar stock, donde recibe un pedido
	 * devuelve un boolean, diciendo si hay stock o no.
	 * En caso de que haya stock, devuelve true y el controlador de venta 
	 * sigue con el proceso de venta. Controlador de Prod, NO reserva las prendas 
	 * En caso de que no haya stock, genera una orden de prod
	 * Y cambia el estado del pedido a "En produccion". 
	 * Cuando termina la produccion, va a llamar al controlador de venta
	 * y le indica que termino. Tendria que haber una funcion dentro del controlador de venta
	 * que se llame "orden prod terminada" o algo asi
	 */

	
}

	
