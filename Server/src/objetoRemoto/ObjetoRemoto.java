package objetoRemoto;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;

import dto.AreaProductivaDTO;
import dto.ClienteDTO;
import dto.EmpleadoDTO;
import dto.ItemPedidoDTO;
import dto.MaterialDTO;
import dto.PedidoDTO;
import dto.PrendaDTO;
import dto.SucursalDTO;
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
	public void agregarAreaProductiva(AreaProductivaDTO area) throws RemoteException {
		ControladorProduccion.getInstancia().agregarAreaProductiva(area);		
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
	public PedidoDTO generarPedido(List<ItemPedidoDTO> itemsPedido, String fechaGeneracion, Integer idCliente,
			Integer idSucursal, String estado) throws ExceptionCliente,RemoteException {
		return ControladorVenta.getInstancia().generarPedido(itemsPedido, fechaGeneracion, idCliente, idSucursal, estado);
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
	public Date aprobarPedido(Integer idPedido) throws RemoteException {		
		return ControladorVenta.getInstancia().aprobarPedido(idPedido);
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
	public List<PedidoDTO> obtenerPedidosPendientesAreaComercial() throws RemoteException {
		return ControladorVenta.getInstancia().obtenerPedidosPendientesAreaComercial();
	}

}