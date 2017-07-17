package controlador;

import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
		c.setContrase�a(cliente.getContrase�a());	
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
		c.setUsuario(cliente.getUsuario());
		c.setContrase�a(cliente.getContrase�a());
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
	public Integer validarCliente(String usuario,String contrase�a){
		return ClienteDAO.getInstance().validarCliente(usuario, contrase�a);
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
	
	//VALIDO EMPLEADO
	public Integer validarEmpleado(String usuario,String contrase�a){
		return EmpleadoDAO.getInstancia().validarEmpledao(usuario, contrase�a);
	}
	//********************************************************************************************
	// METODOS PEDIDO
	//********************************************************************************************

	
	
	public void generarPedido(PedidoDTO pedido) throws ExceptionCliente{
			
		Pedido p = new Pedido();
		
		p.setActivo(pedido.isActivo());
		p.setEstado(pedido.getEstado());
		p.setFechaGeneracion(pedido.getFechaGeneracion());
		p.setCliente(ClienteDAO.getInstance().recuperarCliente(pedido.getCliente().getIdCliente()));
		p.setSucursal(SucursalDAO.getInstancia().recuperarSucursal(pedido.getCliente().getSucursal().getIdSucursal()));		
		p.setValor(pedido.getValor());		
		List<ItemPedido> lip=new ArrayList<ItemPedido>();				
		for(ItemPedidoDTO i:pedido.getItems()){
			ItemPedido itempedidoaux = new ItemPedido();			
			itempedidoaux.setActivo(true);
			itempedidoaux.setCantidad(i.getCantidad());
			itempedidoaux.setEstado(i.getEstado());
			itempedidoaux.setPrenda(PrendaDAO.getInstance().obtenerPrenda(i.getPrenda().getIdPrenda()));
			lip.add(itempedidoaux);
			}
		p.setItems(lip);
		PedidoDAO.getInstance().guardarPedido(p);			
	}
	
	public void aprobarPedidoComercial(Integer idPedido){
		Pedido p = PedidoDAO.getInstance().obtenerPedido(idPedido);
		
		p.setEstado("Pendiente aprobacion Cliente");
		PedidoDAO.getInstance().actualizarPedido(p);
	}
	
	public void aprobarPedido(Integer idPedido){
		Pedido p = PedidoDAO.getInstance().obtenerPedido(idPedido);
		
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");	
		Calendar calendar = Calendar.getInstance();
		String fechaDespacho;
	

		//La funcion "tengo Stock inicia la produccion en caso de que no haya
		if (ControladorProduccion.getInstancia().tengoStock(p) == true){
			System.out.println("Despachando");
			p.setEstado("Despachando");
			
			calendar.setTime(date); 
			calendar.add(Calendar.DATE, 7);
			date = calendar.getTime();
			fechaDespacho=dateFormat.format(date);
			p.setFechaEstDespacho(fechaDespacho);
			this.comenzarDespacho(idPedido);
		} else{
			p.setEstado("Produciendo");
		}
		PedidoDAO.getInstance().actualizarPedido(p);		
	}
	
	public PedidoDTO obtenerPedido(Integer idPedido){
		return PedidoDAO.getInstance().obtenerPedido(idPedido).toDTO();
	}
	
	public List<PedidoDTO> listarPerdidos(){
		List<PedidoDTO> lpdto=new ArrayList<PedidoDTO>();
		for(Pedido p:PedidoDAO.getInstance().listarPedidos()) {
			PedidoDTO pdto=p.toDTO();
			lpdto.add(pdto);
		}
		return lpdto;
	}
	
	public List<PedidoDTO> listarPedidosEstado(String estado){
		List<PedidoDTO> lpdto=new ArrayList<PedidoDTO>();
		for(Pedido p:PedidoDAO.getInstance().listarPedidosEstado(estado)) {
			lpdto.add(p.toDTO());
		}
		return lpdto;
	}

	public Integer comenzarDespacho(Integer idPedido){
		
		//Primero reservo todas las prendas, genero el remito y factura
		Pedido p = PedidoDAO.getInstance().obtenerPedido(idPedido);
		Factura f = new Factura();
		f.setActivo(true);
		f.setCliente(p.getCliente());
		f.setPedido(p);
		if(p.getCliente().getCondicion().equals("Responsable Inscripto")) {
			f.setTipo("Factura A");
		}else {
			f.setTipo("Consumidor Final");
		}
		
		Integer id_factura = FacturaDAO.getInstance().grabarFactura(f);
		//f.setIdFactura(FacturaDAO.getInstance().grabarFactura(f));
		f=FacturaDAO.getInstance().recuperarFactura(id_factura);
		
		Remito r = new Remito();
		r.setActivo(true);
		r.setFactura(f);
		
		for(ItemPedido ip:p.getItems()) {
			List<PrendaVenta> lpv=ip.getPrenda().getStock().getPrendasVenta();
			r.setPrendasventas(lpv);
		}

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
		return RemitoDAO.getInstance().grabarRemito(r);
		//return r.getIdRemito();
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
	
	
	public void cancelarPedido(Integer idPedido,String motivo) {
		Pedido p=PedidoDAO.getInstance().obtenerPedido(idPedido);
		p.setMotivoCancelar(motivo);
		PedidoDAO.getInstance().actualizarPedido(p);				
	}
	
	
	
	
}

	
