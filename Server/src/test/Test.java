package test;

import negocio.Cliente;

import java.util.List;

import businessDelegate.BusinessDelegate;
import controlador.ControladorCompra;
import controlador.ControladorVenta;
import dao.ClienteDAO;
import dao.SucursalDAO;
import dto.ClienteDTO;
import dto.MaterialDTO;
import dto.SucursalDTO;
import exceptions.ExceptionCliente;

public class Test {

	public static void main(String[] args) throws ExceptionCliente {
		// TODO Auto-generated method stub

		//System.out.println(SucursalDAO.getInstancia().obtenerSucursal("sucursal 5").getIdSucursal());
		//Integer a = new Integer(692);

		/*ControladorVenta.getInstancia().agregarSucursal(1,"San Telmo", "Av Independencia 450", "12 a 16");
=======
		//ControladorVenta.getInstancia().agregarSucursal(1,"San Telmo", "Av Independencia 450", "12 a 16");
>>>>>>> Stashed changes
		ControladorVenta.getInstancia().agregarCliente("Aram", "Independencia 639", "Activo", 1, 50000, "Taka-Taka", 10000, 5000);
		ClienteDTO aux = ControladorVenta.getInstancia().recuperarCliente(1);
		System.out.println("Nombre: "+aux.getNombre()+", Direccion: "+aux.getDireccion()+", Sucursal: "+aux.getIdSucu()+ ", activo: "+aux.isActivo());
		ControladorVenta.getInstancia().eliminarCliente(aux.getIdCliente());
		aux = ControladorVenta.getInstancia().recuperarCliente(1);
		System.out.println("Nombre: "+aux.getNombre()+", Direccion: "+aux.getDireccion()+", Sucursal: "+aux.getIdSucu()+ ", activo: "+aux.isActivo());
		//ControladorVenta.getInstancia().agregarEmpleado("Alexis Canclini", "alexis@canclini.com", "Administracion", "acanclini", "acanclini", 1);
		aux.setDireccion("Juan B Justo 984");
		System.out.println("Nombre: "+aux.getNombre()+", Direccion: "+aux.getDireccion()+", Sucursal: "+aux.getIdSucu()+ ", activo: "+aux.isActivo());
	
		List<ClienteDTO> listaux = ClienteDAO.getInstance().listarClientes();
		for(ClienteDTO a:listaux){
			System.out.println(a.getNombre());
				
		}
		*/
		
		System.out.println(ControladorCompra.getInstancia().recuperarMaterial(1).getNombre());
		
		
	}

}
