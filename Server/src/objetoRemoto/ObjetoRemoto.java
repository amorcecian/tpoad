
package objetoRemoto;

import java.rmi.RemoteException;import java.rmi.server.UnicastRemoteObject;import java.util.List;


import dto.ClienteDTO;import dto.EmpleadoDTO;import dto.MaterialDTO;import dto.SucursalDTO;import exceptions.ExceptionCliente;import interfaces.*;import controlador.*;
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

	public void agregarEmpleado(EmpleadoDTO e) throws RemoteException, ExceptionCliente {

		ControladorVenta.getInstancia().agregarEmpleado(e);

	}

	public void actualizarEmpleado(EmpleadoDTO e) throws RemoteException, ExceptionCliente {

		ControladorVenta.getInstancia().actualizarEmpleado(e);

	}

	public EmpleadoDTO recuperarEmpleado(Integer i) throws RemoteException, ExceptionCliente {

		return ControladorVenta.getInstancia().recuperarEmpleado(i);

	}

	public List<EmpleadoDTO> listarEmpleados() throws RemoteException, ExceptionCliente {
		return ControladorVenta.getInstancia().listarEmpleados();
	}

	public void agregarSucursal(SucursalDTO sucursal) throws RemoteException {

		ControladorVenta.getInstancia().agregarSucursal(sucursal);

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

}