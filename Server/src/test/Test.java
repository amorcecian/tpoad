package test;

import negocio.AreaProductiva;
import negocio.Cliente;
import negocio.EtapaProductiva;
import negocio.LineaProductiva;
import negocio.Lote;
import negocio.Material;
import negocio.Prenda;

import java.util.List;
import java.util.Vector;

import businessDelegate.BusinessDelegate;
import controlador.ControladorCompra;
import controlador.ControladorVenta;
import dao.ClienteDAO;
import dao.MaterialDAO;
import dao.SucursalDAO;
import dto.AreaProductivaDTO;
import dto.ClienteDTO;
import dto.MaterialDTO;
import dto.SucursalDTO;
import exceptions.ExceptionCliente;

public class Test {

	public static void main(String[] args) throws ExceptionCliente {
		// TODO Auto-generated method stub

		//System.out.println(SucursalDAO.getInstancia().obtenerSucursal("sucursal 5").getIdSucursal());
		//Integer a = new Integer(692);
		
		//SucursalDTO sucursal = new SucursalDTO(15,"Caballito", "Av Gaona 450", "12 a 16");
		//Integer i=ControladorVenta.getInstancia().agregarSucursal(sucursal);
		//System.out.println(i);
		/*
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
		
		//System.out.println(ControladorCompra.getInstancia().recuperarMaterial(1).getNombre());
		/*
		List<Material> listaux = MaterialDAO.getInstancia().listarMateriales();
		for(Material a:listaux){
			System.out.println(a.getNombre());				
		}*/
		
		LineaProductiva l11 = new LineaProductiva(11,"Libre",null,true);
		LineaProductiva l12 = new LineaProductiva(12,"Libre",null,true);
		LineaProductiva l13 = new LineaProductiva(13,"Libre",null,true);
		LineaProductiva l21 = new LineaProductiva(21,"Libre",null,true);
		LineaProductiva l22 = new LineaProductiva(22,"Libre",null,true);
		LineaProductiva l23 = new LineaProductiva(23,"Libre",null,true);
		LineaProductiva l31 = new LineaProductiva(31,"Libre",null,true);
		LineaProductiva l32 = new LineaProductiva(32,"Libre",null,true);
		LineaProductiva l33 = new LineaProductiva(33,"Libre",null,true);
		
		List <LineaProductiva> lineas1 = new Vector<LineaProductiva>();
		lineas1.add(l11);
		lineas1.add(l12);
		lineas1.add(l13);
		
		List <LineaProductiva> lineas2 = new Vector<LineaProductiva>();
		lineas2.add(l21);
		lineas2.add(l22);
		lineas2.add(l23);
		
		List <LineaProductiva> lineas3 = new Vector<LineaProductiva>();
		lineas2.add(l31);
		lineas2.add(l32);
		lineas2.add(l33);
		
		AreaProductiva a1 = new AreaProductiva(0, "Corte", lineas1, null, true);
		AreaProductiva a2 = new AreaProductiva(1, "tejido", lineas2, null, true);
		AreaProductiva a3 = new AreaProductiva(2, "planchado", lineas3, null, true);
		
		EtapaProductiva e1 = new EtapaProductiva(a1,2,0,true);
		EtapaProductiva e2 = new EtapaProductiva(a2,3,1,true);
		EtapaProductiva e3 = new EtapaProductiva(a3,1,2,true);
		
		List <EtapaProductiva> etapas1 = new Vector<EtapaProductiva>();
		etapas1.add(e1);
		etapas1.add(e2);
		etapas1.add(e3);
		
		Prenda remera = new Prenda(0, "remera", "azul", "l", 23f, "2017", 6, 25, null, etapas1, null, true);
		
		
		
	}

}
