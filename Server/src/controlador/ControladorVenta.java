package controlador;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import negocio.*;
import dto.*;
import entities.PedidoEntity;
import exceptions.ExceptionCliente;
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
		return (ClienteDAO.getInstance().recuperarCliente(idCliente).getCuentaCorriente().getLimiteCredito() - ClienteDAO.getInstance().recuperarCliente(idCliente).getCuentaCorriente().getSaldo() + ClienteDAO.getInstance().recuperarCliente(idCliente).getCuentaCorriente().getValorConsignacion());
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
		
		p.setActivo(true);
		p.setEstado("Para Aprobar");
		p.setFechaGeneracion(fechaGeneracion);
		p.setFechaEstDespacho(fechaEstDespacho);
		p.setValor(valor);
		p.setCliente(ClienteDAO.getInstance().recuperarCliente(idCliente));
		p.setSucursal(SucursalDAO.getInstancia().recuperarSucursal(idSucursal));
		List<ItemPedido> items = new Vector<ItemPedido>();
		ItemPedido itempedidoaux = new ItemPedido();
		for(ItemPedidoDTO i:itemsPedido){
			itempedidoaux.setActivo(true);
			itempedidoaux.setCantidad(i.getCantidad());
			itempedidoaux.setEstado(i.getEstado());
			itempedidoaux.setPrenda(PrendaDAO.getInstance().obtenerPrenda(i.getPrenda().getIdPrenda()));
			items.add(itempedidoaux);
			}
		
		p.setIdPedido(PedidoDAO.getInstance().guardarPedido(p));	
		return p.toDTO();
	}
	
	public java.util.Date aprobarPedido(Integer idPedido){
		Calendar fecha = Calendar.getInstance();
		Pedido p = PedidoDAO.getInstance().obtenerPedido(idPedido);
		
		if (ControladorProduccion.getInstancia().tengoStock(p) == true){
			p.setEstado("Despachando");
			fecha.set(Calendar.DATE, 7);
			this.comenzarDespacho(idPedido);
		} else{
			p.setEstado("Produciendo");
			int c = ControladorProduccion.getInstancia().backlog();
			fecha.set(Calendar.DATE,c);
		}
		PedidoDAO.getInstance().guardarPedido(p);
		return fecha.getTime();
		
	}
	
	public PedidoDTO obtenerPedido(Integer idPedido){
		return PedidoDAO.getInstance().obtenerPedido(idPedido).toDTO();
	}
	
	public List<PedidoDTO> obtenerPedidosPendientesAreaComercial(){
		List<PedidoDTO> l = new Vector<PedidoDTO>();
		for (Pedido p : PedidoDAO.getInstance().obtenerPedidosPendientesAreaComercial()){
			l.add(p.toDTO());
		}
		
		return l;
	}

	public Integer comenzarDespacho(Integer idPedido){
		
		//Primero reservo todas las prendas, genero el remito y factura
		Pedido p = PedidoDAO.getInstance().obtenerPedido(idPedido);
		Factura f = new Factura();
		Remito r = new Remito();
		f.setActivo(true);
		f.setCliente(p.getCliente());
		f.setPedido(p);
		r.setActivo(true);
		r.setFactura(f);
		f.setIdFactura(FacturaDAO.getInstance().grabarFactura(f));
		r.setIdRemito((RemitoDAO.getInstance().grabarRemito(r)));
		//Para cada item pedido del pedido
		for (ItemPedido i : p.getItems()){
			//Obtengo la cantidad de items para reservar
			int cant = i.getCantidad();
			//obtengo el stock de la prenda
			Stock s = PrendaDAO.getInstance().obtenerPrenda(i.getPrenda().getIdPrenda()).getStock();
			
			//Mientras no reserve todas las prendas que necesito
			while (cant != 0){
				//recorro el arreglo de prendas
				for(PrendaVenta pv : s.getPrendasVenta()){
					//si la prenda esta disponible
					if(pv.getEstado().equals("Disponible")){
						
						//reservo la prenda
						pv.setEstado("Reservado para pedido: "+ p.getIdPedido());
						PrendaVentaDAO.getInstancia().actualizarPrendaVenta(pv);
						r.getPrendasventas().add(pv);
						cant--;
					}
				}
			}
		}
		p.setEstado("Para Despacho");
		r.setEstado("Para Despacho");
		PedidoDAO.getInstance().guardarPedido(p);
		RemitoDAO.getInstance().grabarRemito(r);
		return r.getIdRemito();
	}
	
	public void comenzarTransporte(Integer idRemito){
		Remito r = RemitoDAO.getInstance().obtenerRemito(idRemito);
		for(PrendaVenta pv : r.getPrendasventas()){
			pv.setEstado("Entregado en pedido: "+ r.getFactura().getIdFactura());
			PrendaVentaDAO.getInstancia().actualizarPrendaVenta(pv);
			}
		r.getFactura().getPedido().setFechaRealDespacho(Calendar.getInstance().getTime().toString());
		r.setEstado("Para Transporte");
		RemitoDAO.getInstance().grabarRemito(r);
		FacturaDAO.getInstance().grabarFactura(r.getFactura());
	}
	
	
}

	
