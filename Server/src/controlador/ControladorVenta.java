package controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

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
		//Agregar Cliente
	public void agregarCliente(String nombre, String direccion, String condicion, Integer idScurusal,
			float limiteCredito,String condicionPago,float saldo,float valorConsignacion) throws ExceptionCliente{
		Cliente c = new Cliente();
		CuentaCorriente cc = new CuentaCorriente(limiteCredito, condicionPago, saldo, valorConsignacion);
		Sucursal s = SucursalDAO.getInstancia().recuperarSucursal(idScurusal);
		c.setCondicion(condicion);
		c.setDireccion(direccion);
		c.setNombre(nombre);
		c.setCuentaCorriente(cc);
		c.setSucursal(s);
		c.setactivo(true);
		ClienteDAO.getInstance().grabarCliente(c);
	}
		//Recuperar Cliente
	public ClienteDTO recuperarCliente(Integer idCliente) throws ExceptionCliente{
		return ClienteDAO.getInstance().recuperarCliente(idCliente).toDTO();
	}
		//Eliminar Cliente
	public void eliminarCliente(Integer idCliente) throws ExceptionCliente{
		Cliente cliente = ClienteDAO.getInstance().recuperarCliente(idCliente);
		ClienteDAO.getInstance().eliminarCliente(cliente);
	}
	
	//Agrego un cliente 
	public void agregarCliente(ClienteDTO cliente) throws ExceptionCliente {
		Cliente c = new Cliente();
		CuentaCorriente cc = new CuentaCorriente(cliente.getLimiteCredito(), cliente.getCondicionPago(), cliente.getSaldo(), cliente.getValorConsignacion());
		Sucursal s = SucursalDAO.getInstancia().recuperarSucursal(cliente.getIdSucu());
		c.setCondicion(cliente.getCondicion());
		c.setDireccion(cliente.getDireccion());
		c.setNombre(cliente.getNombre());
		c.setCuentaCorriente(cc);
		c.setSucursal(s);
		c.setactivo(true);
		ClienteDAO.getInstance().grabarCliente(c);
		
	}
	
	//Actualizo Cliente
	public void actualizarCliente(ClienteDTO cliente) throws ExceptionCliente{
		Cliente c = new Cliente();
		CuentaCorriente cc = new CuentaCorriente(cliente.getLimiteCredito(), cliente.getCondicionPago(), cliente.getSaldo(), cliente.getValorConsignacion());
		Sucursal s = SucursalDAO.getInstancia().recuperarSucursal(cliente.getIdSucu());
		c.setCondicion(cliente.getCondicion());
		c.setDireccion(cliente.getDireccion());
		c.setNombre(cliente.getNombre());
		c.setCuentaCorriente(cc);
		c.setSucursal(s);
		c.setactivo(true);
		c.setIdCliente(cliente.getIdCliente());
		ClienteDAO.getInstance().actualizarCliente(c);
	}
	
	
	//Listar Todos Clientes
	
	public List<ClienteDTO> listarClientes() throws ExceptionCliente{
		List<ClienteDTO> listaux = ClienteDAO.getInstance().listarClientes();
		return listaux;
	
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
	
		//Recuperar Sucursal
	public SucursalDTO recuperarSucursal(Integer idSucursal){
		Sucursal sucu=SucursalDAO.getInstancia().recuperarSucursal(idSucursal);
		return sucu.toDTO();
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
	/*public void agregarEmpleado(String nombre,String mail,String area,String user,String contraseña,
			Integer idSucursal){
		Sucursal sucursal = SucursalDAO.getInstancia().obtenerSucursal(idSucursal);
		Empleado empleado = new Empleado(nombre, mail, area, user, contraseña, sucursal);
		EmpleadoDAO.getInstancia().grabarEmpleado(empleado);
	}*/
	
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
		Empleado em=null;
		List<EmpleadoDTO> aux = new Vector<EmpleadoDTO>();
		for(EmpleadoEntity e:EmpleadoDAO.getInstancia().listarEmpleados())
			em=EmpleadoDAO.getInstancia().toNegocio(e);
			aux.add(em.toDTO());
		return aux;	
	}
	
	//********************************************************************************************
	// METODOS PEDIDO
	//********************************************************************************************
	
	public int generarPedido(List<Integer> itemsPedido, String fechaGeneracion, String fechaEstDespacho, 
			String fechaRealDespacho, float valor,Integer idCliente, Integer idSucursal, String estado,
			String motivoCancelar){
		
		try {
			Cliente cliente = ClienteDAO.getInstance().recuperarCliente(idCliente);
			Sucursal sucursal = SucursalDAO.getInstancia().recuperarSucursal(idSucursal);
			List<ItemPedido> items = new Vector<ItemPedido>();
			//ACA TENGO QUE CREAR TODOS LOS ITEMS PEDIDO A PARTIR DE SUS ID'S
			for(Integer i:itemsPedido){
			//	ItemPedido aux = new ItemPe
			}
			
			
			//Pedido pedido = new Pedido(itemsPedido, fechaGeneracion, fechaEstDespacho, fechaRealDespacho, valor, cliente, sucursal, estado, motivoCancelar, true)
		} catch (ExceptionCliente e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
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
