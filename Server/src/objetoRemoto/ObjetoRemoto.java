package objetoRemoto;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;

import dto.AlmacenamientoDTO;
import dto.AreaProductivaDTO;
import dto.ClienteDTO;
import dto.EmpleadoDTO;
import dto.ItemPedidoDTO;
import dto.LoteDTO;
import dto.MaterialDTO;
import dto.OrdenDeProduccionDTO;
import dto.PedidoDTO;
import dto.PrendaDTO;
import dto.RemitoDTO;
import dto.SucursalDTO;
import dto.ordenCMPDTO;
import exceptions.ExceptionCliente;
import interfaces.*;
import controlador.*;

public class ObjetoRemoto extends UnicastRemoteObject implements IController {

	private static final long serialVersionUID = 2833723427294478879L;

	public ObjetoRemoto() throws RemoteException {
		super();
	}

	public List<SucursalDTO> listarSucursales() throws RemoteException {
		return ControladorVenta.getInstancia().listarSucursales();
	}

	public void agregarCliente(ClienteDTO cliente) throws ExceptionCliente {
		ControladorVenta.getInstancia().agregarCliente(cliente);
	}

	public void actualizarCliente(ClienteDTO cliente) throws ExceptionCliente {
		ControladorVenta.getInstancia().actualizarCliente(cliente);
	}

	public ClienteDTO recuperarCliente(Integer id) throws ExceptionCliente {
		return ControladorVenta.getInstancia().recuperarCliente(id);
	}

	public List<ClienteDTO> listarClientes() throws ExceptionCliente {
		return ControladorVenta.getInstancia().listarClientes();
	}

	public void agregarEmpleado(EmpleadoDTO e) throws RemoteException,ExceptionCliente {
		ControladorVenta.getInstancia().agregarEmpleado(e);
	}

	public void actualizarEmpleado(EmpleadoDTO e) throws RemoteException,ExceptionCliente {
		ControladorVenta.getInstancia().actualizarEmpleado(e);
	}

	public EmpleadoDTO recuperarEmpleado(Integer i) throws RemoteException {
		return ControladorVenta.getInstancia().recuperarEmpleado(i);
	}

	public List<EmpleadoDTO> listarEmpleados() throws RemoteException,ExceptionCliente {
		return ControladorVenta.getInstancia().listarEmpleados();
	}

	public void agregarSucursal(SucursalDTO sucursal) throws RemoteException {
		ControladorVenta.getInstancia().agregarSucursal(sucursal);
	}
	
	public void asignarEncargado(Integer idSucursal,Integer idEmpleado) throws RemoteException{
		ControladorVenta.getInstancia().asignarEncargado(idSucursal, idEmpleado);
	}

	public void agregarMaterial(MaterialDTO m) throws RemoteException {
		ControladorCompra.getInstancia().agregarMaterial(m);
	}

	public void actualizarMaterial(MaterialDTO e) throws RemoteException {
		ControladorCompra.getInstancia().actualizarMaterial(e);
	}

	public MaterialDTO recuperarMaterial(Integer i) throws RemoteException {
		return ControladorCompra.getInstancia().recuperarMaterial(i);
	}

	public List<MaterialDTO> listarMateriales() throws RemoteException {
		return ControladorCompra.getInstancia().listarMateriales();
	}

	public void eliminarEmpleado(Integer idEmpleado) throws RemoteException {
		ControladorVenta.getInstancia().eliminarEmpleado(idEmpleado);
	}

	public void agregarPrenda(PrendaDTO prenda) throws RemoteException {
		ControladorProduccion.getInstancia().agregarPrenda(prenda);
	}
	
	public Integer recuperarStock(Integer idPrenda) throws RemoteException{
		return ControladorProduccion.getInstancia().obtenerStock(idPrenda);
	}

	@Override
	public SucursalDTO recuperarSucursal(Integer idSucursal) throws RemoteException {
		return ControladorVenta.getInstancia().recuperarSucursal(idSucursal);
	}

	@Override
	public void actualizarSucursal(SucursalDTO sucursal) throws RemoteException {
		ControladorVenta.getInstancia().actualizarSucursal(sucursal);		
	}

	@Override
	public void eliminarSucursal(Integer idSucursal) throws RemoteException {
		ControladorVenta.getInstancia().eliminarSucursal(idSucursal);		
	}

	@Override
	public void eliminarCliente(Integer idCliente) throws RemoteException {
		ControladorVenta.getInstancia().eliminarCliente(idCliente);		
	}


	@Override
	public Integer validarCliente(String usuario, String contraseña)
			throws RemoteException {
		
		return ControladorVenta.getInstancia().validarCliente(usuario, contraseña);
	}

	@Override
	public List<PrendaDTO> listarPrendas() throws RemoteException {
		
		return ControladorProduccion.getInstancia().listarPrendas();
	}

	@Override
	public void generarPedido(PedidoDTO pdto) throws ExceptionCliente,RemoteException {
		ControladorVenta.getInstancia().generarPedido(pdto);
	}

	@Override
	public List<PedidoDTO> listarPedidoEstado(String estado) throws RemoteException {		
		return ControladorVenta.getInstancia().listarPedidosEstado(estado);
	}

	@Override
	public Integer validarEmpleado(String usuario, String contraseña) throws RemoteException {
		return ControladorVenta.getInstancia().validarEmpleado(usuario, contraseña);
	}

	@Override
	public void aprobarPedido(Integer idPedido) throws RemoteException {		
		ControladorVenta.getInstancia().aprobarPedido(idPedido);
	}

	@Override
	public Integer obtenerStock(Integer idPrenda) throws RemoteException {
		return ControladorProduccion.getInstancia().obtenerStock(idPrenda);
	}

	@Override
	public PedidoDTO obtenerPedido(Integer idPedido) throws RemoteException {
		return ControladorVenta.getInstancia().obtenerPedido(idPedido);
	}

	@Override
	public float chequearCredito(Integer idCliente) throws ExceptionCliente,RemoteException {
		return ControladorVenta.getInstancia().chequearCredito(idCliente);
	}

	@Override
	public List<PedidoDTO> listarPedidos() throws RemoteException {		
		return ControladorVenta.getInstancia().listarPedidos();
	}

	@Override
	public List<OrdenDeProduccionDTO> listarOrdenesDeProduccion()
			throws RemoteException {		
		return ControladorProduccion.getInstancia().listarOrdenesDeProduccion();
	}

	@Override
	public List<ordenCMPDTO> ObtenerOCPendientes() throws RemoteException {
		return ControladorCompra.getInstancia().ObtenerOCPendientes();
	}

	@Override
	public void ContinuarProduccion(Integer idLote) throws RemoteException {
		ControladorProduccion.getInstancia().ContinuarProduccion(idLote);		
	}

	@Override
	public OrdenDeProduccionDTO obtenerOP(Integer idOP) throws RemoteException {
		return ControladorProduccion.getInstancia().obtenerOP(idOP);
	}

	@Override
	public List<AlmacenamientoDTO> listarAlmacenamientos()
			throws RemoteException {
		return ControladorProduccion.getInstancia().listarAlmacenamientos();
	}

	@Override
	public List<LoteDTO> listarLotesTerminadosDeProducir()
			throws RemoteException {
		return ControladorProduccion.getInstancia().listarLotesTerminadosDeProducir();
	}

	@Override
	public AlmacenamientoDTO recuperarAlmacenamiento(Integer idAlmacenamiento)
			throws RemoteException {
		return ControladorProduccion.getInstancia().recuperarAlmacenamiento(idAlmacenamiento);
	}

	@Override
	public void OrdenCompraCompleta(Integer idOC) throws RemoteException {
		ControladorCompra.getInstancia().OrdenCompraCompleta(idOC);		
	}

	@Override
	public Integer comenzarDespacho(Integer idPedido) throws RemoteException {
		return ControladorVenta.getInstancia().comenzarDespacho(idPedido);
	}

	@Override
	public RemitoDTO recuperarRemito(int idRemito) throws RemoteException {
		return ControladorVenta.getInstancia().recuperarRemito(idRemito);
	}

}