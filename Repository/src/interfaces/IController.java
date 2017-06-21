package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import dto.*;
import exceptions.ExceptionCliente;



public interface IController extends Remote {
	
	public List<SucursalDTO> listarSucursales() throws RemoteException;
	public void agregarSucursal(SucursalDTO sucursal) throws RemoteException;
	public void agregarCliente(ClienteDTO c) throws RemoteException, ExceptionCliente;
	public void actualizarCliente(ClienteDTO c) throws RemoteException, ExceptionCliente;
	public ClienteDTO recuperarCliente(Integer i) throws RemoteException, ExceptionCliente;
	public List<ClienteDTO> listarClientes() throws RemoteException, ExceptionCliente;
	public void agregarEmpleado(EmpleadoDTO e) throws RemoteException, ExceptionCliente;
	public void eliminarEmpleado(Integer idEmpleado) throws RemoteException;
	public void actualizarEmpleado(EmpleadoDTO e) throws RemoteException, ExceptionCliente;
	public EmpleadoDTO recuperarEmpleado(Integer i) throws RemoteException;
	public List<EmpleadoDTO> listarEmpleados() throws RemoteException, ExceptionCliente;
	public void agregarMaterial(MaterialDTO m) throws RemoteException;
	public void actualizarMaterial(MaterialDTO e) throws RemoteException;
	public MaterialDTO recuperarMaterial(Integer i) throws RemoteException;
	public List<MaterialDTO> listarMateriales() throws RemoteException;
	public void agregarPrenda(PrendaDTO prenda) throws RemoteException;
	
}
