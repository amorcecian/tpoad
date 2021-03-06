package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;import java.util.Date;import java.util.List;

import dto.*;
import exceptions.ExceptionCliente;



public interface IController extends Remote {
	
	public List<SucursalDTO> listarSucursales() throws RemoteException;
	public void agregarSucursal(SucursalDTO sucursal) throws RemoteException;
	public void actualizarSucursal(SucursalDTO sucursal) throws RemoteException;
	public void eliminarSucursal(Integer idSucursal) throws RemoteException;
	public SucursalDTO recuperarSucursal(Integer idSucursal) throws RemoteException;
	public void asignarEncargado(Integer idSucursal,Integer idEmpleado) throws RemoteException;
	public void agregarCliente(ClienteDTO c) throws RemoteException, ExceptionCliente;
	public void actualizarCliente(ClienteDTO c) throws RemoteException, ExceptionCliente;
	public void eliminarCliente(Integer idCliente) throws RemoteException;
	public ClienteDTO recuperarCliente(Integer i) throws RemoteException, ExceptionCliente;
	public List<ClienteDTO> listarClientes() throws RemoteException, ExceptionCliente;		public Integer validarCliente(String usuario, String contraseņa) throws RemoteException;
	public void agregarEmpleado(EmpleadoDTO e) throws RemoteException, ExceptionCliente;
	public void eliminarEmpleado(Integer idEmpleado) throws RemoteException;
	public void actualizarEmpleado(EmpleadoDTO e) throws RemoteException, ExceptionCliente;		public Integer validarEmpleado(String usuario, String contraseņa) throws RemoteException;
	public EmpleadoDTO recuperarEmpleado(Integer i) throws RemoteException;
	public List<EmpleadoDTO> listarEmpleados() throws RemoteException, ExceptionCliente;
	public void agregarMaterial(MaterialDTO m) throws RemoteException;
	public void actualizarMaterial(MaterialDTO e) throws RemoteException;
	public MaterialDTO recuperarMaterial(Integer i) throws RemoteException;
	public List<MaterialDTO> listarMateriales() throws RemoteException;
	public void agregarPrenda(PrendaDTO prenda) throws RemoteException;		public List<PrendaDTO> listarPrendas() throws RemoteException;
	public Integer recuperarStock(Integer idPrenda) throws RemoteException;		public void generarPedido(PedidoDTO pedido) throws ExceptionCliente,RemoteException;		public List<PedidoDTO> listarPedidoEstado(String estado) throws RemoteException;	public void aprobarPedido(Integer idPedido) throws RemoteException;		public Integer obtenerStock(Integer idPrenda) throws RemoteException;		public PedidoDTO obtenerPedido(Integer idPedido) throws RemoteException;		public float chequearCredito(Integer idCliente) throws ExceptionCliente,RemoteException;		public List<PedidoDTO> listarPedidos() throws RemoteException;		public List<OrdenDeProduccionDTO> listarOrdenesDeProduccion() throws RemoteException;
		public List<ordenCMPDTO> ObtenerOCPendientes() throws RemoteException;		public void ContinuarProduccion(Integer idLote) throws RemoteException;	public OrdenDeProduccionDTO obtenerOP(Integer idOP)  throws RemoteException;		public List<AlmacenamientoDTO> listarAlmacenamientos() throws RemoteException;		public List<LoteDTO> listarLotesTerminadosDeProducir() throws RemoteException;		public AlmacenamientoDTO recuperarAlmacenamiento(Integer idAlmacenamiento) throws RemoteException;		public void OrdenCompraCompleta(Integer idOC) throws RemoteException;		public Integer comenzarDespacho(Integer idPedido) throws RemoteException;		public RemitoDTO recuperarRemito(int idRemito) throws RemoteException;
}
