package businessDelegate;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.List;

import dto.*;
import exceptions.*;
import interfaces.IController;

public class BusinessDelegate implements IController {

	private static BusinessDelegate instancia = null;
	private IController objetoRemoto;

	public static BusinessDelegate getInstancia() {
		if (instancia == null) {
			instancia = new BusinessDelegate();
		}
		return instancia;
	}

	public BusinessDelegate() {
		try {
			objetoRemoto = (IController) Naming.lookup("//localhost/objetoRemoto");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// @Override

	public List<SucursalDTO> listarSucursales() throws RemoteException {
		return objetoRemoto.listarSucursales();
	}

	public void agregarCliente(ClienteDTO c) throws RemoteException,ExceptionCliente {
		objetoRemoto.agregarCliente(c);
	}

	public void actualizarCliente(ClienteDTO c) throws RemoteException,ExceptionCliente {
		objetoRemoto.actualizarCliente(c);
	}

	public ClienteDTO recuperarCliente(Integer i) throws RemoteException,ExceptionCliente {
		return objetoRemoto.recuperarCliente(i);
	}

	public List<ClienteDTO> listarClientes() throws RemoteException,ExceptionCliente {
		return objetoRemoto.listarClientes();
	}

	public void agregarEmpleado(EmpleadoDTO e) throws RemoteException,ExceptionCliente {
		objetoRemoto.agregarEmpleado(e);
	}

	public void actualizarEmpleado(EmpleadoDTO e) throws RemoteException,ExceptionCliente {
		objetoRemoto.actualizarEmpleado(e);
	}

	public EmpleadoDTO recuperarEmpleado(Integer i) throws RemoteException {
		return objetoRemoto.recuperarEmpleado(i);
	}

	public List<EmpleadoDTO> listarEmpleados() throws RemoteException,ExceptionCliente {
		return objetoRemoto.listarEmpleados();
	}

	public void agregarSucursal(SucursalDTO sucursal) throws RemoteException {
		objetoRemoto.agregarSucursal(sucursal);
	}

	public void agregarMaterial(MaterialDTO m) throws RemoteException {
		objetoRemoto.agregarMaterial(m);
	}

	@Override
	public void actualizarMaterial(MaterialDTO m) throws RemoteException {
		objetoRemoto.actualizarMaterial(m);
	}

	@Override
	public MaterialDTO recuperarMaterial(Integer i) throws RemoteException {
		return objetoRemoto.recuperarMaterial(i);
	}

	@Override
	public List<MaterialDTO> listarMateriales() throws RemoteException {
		return objetoRemoto.listarMateriales();
	}

	@Override
	public void eliminarEmpleado(Integer idEmpleado) throws RemoteException {
		objetoRemoto.eliminarEmpleado(idEmpleado);
	}

	@Override
	public void agregarPrenda(PrendaDTO prenda) throws RemoteException {
		objetoRemoto.agregarPrenda(prenda);
	}
		
	}



	@Override
	public Integer recuperarStock(Integer idPrenda) throws RemoteException {
		return objetoRemoto.recuperarStock(idPrenda);
	}

}

	@Override
	public void asignarEncargado(Integer idSucursal, Integer idEmpleado)throws RemoteException {
		objetoRemoto.asignarEncargado(idSucursal, idEmpleado);		
	}

	@Override
	public SucursalDTO recuperarSucursal(Integer idSucursal) throws RemoteException {
		return objetoRemoto.recuperarSucursal(idSucursal);		
	}

	@Override
	public void actualizarSucursal(SucursalDTO sucursal) throws RemoteException {
		objetoRemoto.actualizarSucursal(sucursal);	
	}

	@Override
	public void eliminarSucursal(Integer idSucursal) throws RemoteException {
		objetoRemoto.eliminarSucursal(idSucursal);		
	}

}
