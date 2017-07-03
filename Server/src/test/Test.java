package test;

import negocio.Almacenamiento;
import negocio.AreaProductiva;
import negocio.Cliente;
import negocio.CuentaCorriente;
import negocio.Empleado;
import negocio.EtapaProductiva;
import negocio.ItemPedido;
import negocio.LineaProductiva;
import negocio.Lote;
import negocio.Material;
import negocio.MaterialPorPrenda;
import negocio.OrdenDeProduccion;
import negocio.Prenda;
import negocio.PrendaVenta;
import negocio.Stock;
import negocio.Sucursal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import businessDelegate.BusinessDelegate;
import controlador.ControladorCompra;
import controlador.ControladorProduccion;
import controlador.ControladorVenta;
import dao.AlmacenamientoDAO;
import dao.AreaProductivaDAO;
import dao.ClienteDAO;
import dao.EmpleadoDAO;
import dao.EtapaProductivaDAO;
import dao.LoteDAO;
import dao.MaterialDAO;
import dao.MaterialPorPrendaDAO;
import dao.OrdenDeProdDAO;
import dao.PrendaDAO;
import dao.PrendaVentaDAO;
import dao.StockDAO;
import dao.SucursalDAO;
import dto.AreaProductivaDTO;
import dto.ClienteDTO;
import dto.CuentaCorrienteDTO;
import dto.ItemPedidoDTO;
import dto.MaterialDTO;
import dto.PrendaDTO;
import dto.SucursalDTO;
import entities.LoteEntity;
import exceptions.ExceptionCliente;

public class Test {

	public static void main(String[] args) throws ExceptionCliente {
		// TODO Auto-generated method stub

		//System.out.println(SucursalDAO.getInstancia().obtenerSucursal("sucursal 5").getIdSucursal());
		//Integer a = new Integer(692);
		/*
		SucursalDTO sucursal = new SucursalDTO(15,"Caballito", "Av Gaona 450", "12 a 16");
		Integer i=ControladorVenta.getInstancia().agregarSucursal(sucursal);
		System.out.println(i);
		
		ControladorVenta.getInstancia().agregarCliente(cliente);("Aram", "Independencia 639", "Activo", 1, 50000, "Taka-Taka", 10000, 5000);
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
		
		
		System.out.println(ControladorCompra.getInstancia().recuperarMaterial(1).getNombre());
		
		List<Material> listaux = MaterialDAO.getInstancia().listarMateriales();
		for(Material a:listaux){
			System.out.println(a.getNombre());				
		}
		
		
		
		Material nm=new Material();
		nm.setActivo(true);
		nm.setCantDisponible(100);
		nm.setCantReservada(50);
		nm.setCosto(10);
		nm.setNombre("Tela Azul");
		nm.setProveedor("Telas SA");
		MaterialDAO.getInstancia().grabarMaterial(nm);

		
		
		MaterialPorPrenda mpp=new MaterialPorPrenda();
		mpp.setActivo(true);
		mpp.setCantidad(100);
		mpp.setDesperdicio(10);
		Material m=MaterialDAO.getInstancia().recuperarMaterial(1);
		mpp.setMaterial(m);
		Prenda p=new Prenda();
		p.setActivo(true);
		p.setCantProducir(100);
		p.setColor("Azul");
		p.setDescripcion("Buzo");
		List <MaterialPorPrenda> lmpp=new ArrayList<MaterialPorPrenda>();
		lmpp.add(mpp);
		p.setMateriales(lmpp);
		p.setPrecioVenta(1000);
		p.setTalle("M");
		p.setTemporada("2017-2018");
		p.setTiempoProd(60);
		PrendaDAO.getInstance().agregarPrenda(p);
		
		
		List<Prenda> lpdto=PrendaDAO.getInstance().listarPrendas();
		
		AreaProductiva ap=new AreaProductiva();
		ap.setNombre("Marcado");
		ap.setActivo(true);
		List<LineaProductiva> llp=new ArrayList<LineaProductiva>();
		LineaProductiva l11 = new LineaProductiva("Libre",null,true);		
		LineaProductiva l12 = new LineaProductiva("Libre",null,true);		
		LineaProductiva l13 = new LineaProductiva("Libre",null,true);
		llp.add(l11);
		llp.add(l12);
		llp.add(l13);
		ap.setLineas(llp);
		
		AreaProductivaDAO.getInstancia().grabarAreaProductiva(ap);
		
		AreaProductivaDAO.getInstancia().listarAreaProductiva();
		*/
		
		
		
		//Desde aca empiezo test 
		
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
		lineas3.add(l31);
		lineas3.add(l32);
		lineas3.add(l33);
		
		AreaProductiva a1 = new AreaProductiva(0, "Corte", lineas1, null, true);
		AreaProductiva a2 = new AreaProductiva(1, "tejido", lineas2, null, true);
		AreaProductiva a3 = new AreaProductiva(2, "planchado", lineas3, null, true);
		AreaProductivaDAO.getInstancia().grabarAreaProductiva(a1);
		AreaProductivaDAO.getInstancia().grabarAreaProductiva(a2);
		AreaProductivaDAO.getInstancia().grabarAreaProductiva(a3);
		
		
		EtapaProductiva e1 = new EtapaProductiva(a1,2,0,true);
		EtapaProductiva e2 = new EtapaProductiva(a2,3,1,true);
		EtapaProductiva e3 = new EtapaProductiva(a3,1,2,true);
		//EtapaProductivaDAO.getInstance().grabarEtapaProductiva(e1);
		//EtapaProductivaDAO.getInstance().grabarEtapaProductiva(e2);
		//EtapaProductivaDAO.getInstance().grabarEtapaProductiva(e3);
		
		List <EtapaProductiva> etapas1 = new Vector<EtapaProductiva>();
		etapas1.add(e1);
		etapas1.add(e2);
		etapas1.add(e3);
			
		Lote l = new Lote();
		l.setEstado("activo");
		l.setActivo(true);
		l.setCantidadProducida(324);
		LoteDAO.getInstancia().guardarLote(l);
			
		Almacenamiento al1 = new Almacenamiento("1", 1, 1, 1, true, null, true);
		Almacenamiento al2 = new Almacenamiento("2", 2, 2, 2, true, null, true);
		Almacenamiento al3 = new Almacenamiento("3", 3, 3, 3, true, null, true);
		AlmacenamientoDAO.getInstance().grabarAlmacenamiento(al1);
		AlmacenamientoDAO.getInstance().grabarAlmacenamiento(al2);
		AlmacenamientoDAO.getInstance().grabarAlmacenamiento(al3);
		
		Sucursal sucu1 = new Sucursal(1, "1", "1", "1", true);
		Sucursal sucu2 = new Sucursal(2, "2", "2", "2", true);
		Sucursal sucu3 = new Sucursal(3, "3", "3", "3", true);
		SucursalDAO.getInstancia().agregarSucursal(sucu1);
		SucursalDAO.getInstancia().agregarSucursal(sucu2);
		SucursalDAO.getInstancia().agregarSucursal(sucu3);
		
		CuentaCorriente cc1 = new CuentaCorriente(123f, "1", 142, 0);
		CuentaCorriente cc2 = new CuentaCorriente(123f, "2", 142, 0);
		CuentaCorriente cc3 = new CuentaCorriente(123f, "3", 142, 0);
		
		Cliente c1 = new Cliente(1, "1", "1", cc1, null, null, "Activo", sucu1, true);
		c1.setUsuario("user1");
		c1.setContraseña("user1");
		Cliente c2 = new Cliente(2, "2", "2", cc2, null, null, "Activo", sucu2, true);
		c2.setUsuario("user2");
		c2.setContraseña("user2");
		Cliente c3 = new Cliente(3, "3", "3", cc3, null, null, "Activo", sucu3, true);
		c3.setUsuario("user3");
		c3.setContraseña("user3");
		ClienteDAO.getInstance().grabarCliente(c1);
		ClienteDAO.getInstance().grabarCliente(c2);
		ClienteDAO.getInstance().grabarCliente(c3);
		
		Empleado emp1 = new Empleado();
		emp1.setActivo(true);
		emp1.setArea("marketing");
		emp1.setContrasenia("laskdfj");
		emp1.setMail("laskdjf@ldskjf.com");
		emp1.setNombre("Empleado 1");
		emp1.setSucursal(sucu1);
		emp1.setUser("emp1");
		EmpleadoDAO.getInstancia().grabarEmpleado(emp1);
		
		Material m1 = new Material(1, "m1", 1, 0, "prov 1", 1, true);
		Material m2 = new Material(2, "m2", 2, 0, "prov 2", 2, true);
		Material m3 = new Material(3, "m3", 3, 0, "prov 3", 3, true);
		MaterialDAO.getInstancia().grabarMaterial(m1);
		MaterialDAO.getInstancia().grabarMaterial(m2);
		MaterialDAO.getInstancia().grabarMaterial(m3);
		
		MaterialPorPrenda mp1 = new MaterialPorPrenda(1,m1,0,true,null);
		MaterialPorPrenda mp2 = new MaterialPorPrenda(2,m2,0,true,null);
		MaterialPorPrenda mp3 = new MaterialPorPrenda(3,m3,0,true,null);
		
		MaterialPorPrendaDAO.getInstance().guardarMaterialPorPrenda(mp1);
		MaterialPorPrendaDAO.getInstance().guardarMaterialPorPrenda(mp2);
		MaterialPorPrendaDAO.getInstance().guardarMaterialPorPrenda(mp3);
		
		List<MaterialPorPrenda> lmp1 = new Vector<MaterialPorPrenda>();
		lmp1.add(mp1);
		List<MaterialPorPrenda> lmp2 = new Vector<MaterialPorPrenda>();
		lmp2.add(mp2);
		List<MaterialPorPrenda> lmp3 = new Vector<MaterialPorPrenda>();
		lmp3.add(mp3);
		
		Prenda remera1 = new Prenda(0, "remera", "verde", "l", 23f, "2017", 6, 25, null, etapas1, lmp1, true,12);
		Prenda remera2 = new Prenda(0, "remera", "azul", "l", 23f, "2017", 6, 25, null, etapas1, lmp2, true,12);
		Prenda remera3 = new Prenda(0, "remera", "naranja", "l", 23f, "2017", 6, 25, null, etapas1, lmp3, true,12);
		PrendaDAO.getInstance().agregarPrenda(remera1);
		PrendaDAO.getInstance().agregarPrenda(remera2);
		PrendaDAO.getInstance().agregarPrenda(remera3);
		
		
		
		List<Material> lm1 = new Vector<Material>();
		lm1.add(m1);
		List<Material> lm2 = new Vector<Material>();
		lm2.add(m2);
		List<Material> lm3 = new Vector<Material>();
		lm3.add(m3);
		
		Lote l1 = new Lote(1, remera1, null, 0, "activo", 1, al1, 1, 1, true);
		LoteDAO.getInstancia().guardarLote(l1);
		Lote l2 = new Lote(2, remera2, null, 0, "activo", 2, al2, 2, 2, true);
		LoteDAO.getInstancia().guardarLote(l2);
		Lote l3 = new Lote(3, remera3, null, 0, "activo", 3, al3, 3, 3, true);
		LoteDAO.getInstancia().guardarLote(l3);
		
		List<Lote> lotes1 = new Vector<Lote>();
		lotes1.add(l1);
		List<Lote> lotes2 = new Vector<Lote>();
		lotes1.add(l2);
		List<Lote> lotes3 = new Vector<Lote>();
		lotes1.add(l3);
		
		List <PrendaVenta> listapv = new Vector<PrendaVenta>();
		
		PrendaVenta pv1 = new PrendaVenta("disponible", l1, true);
		PrendaVenta pv2 = new PrendaVenta("disponible", l2, true);
		PrendaVenta pv3 = new PrendaVenta("disponible", l3, true);
		PrendaVentaDAO.getInstancia().grabarPrendaVenta(pv1);
		PrendaVentaDAO.getInstancia().grabarPrendaVenta(pv2);
		PrendaVentaDAO.getInstancia().grabarPrendaVenta(pv3);
		listapv.add(pv1);
		listapv.add(pv2);
		listapv.add(pv3);
		
		//Stock s1 = new Stock(1, 1, prendasVenta, activo)
		
		/*
		OrdenDeProduccion op1 = new OrdenDeProduccion(1, Calendar.getInstance().getTime().toString(), "total", null, lm1, null, 123f, lotes1, true);
		OrdenDeProduccion op2 = new OrdenDeProduccion(2, Calendar.getInstance().getTime().toString(), "total", null, lm2, null, 123f, lotes2, true);
		OrdenDeProduccion op3 = new OrdenDeProduccion(3, Calendar.getInstance().getTime().toString(), "total", null, lm3, null, 123f, lotes3, true);
		OrdenDeProdDAO.getInstancia().guardarOP(op1);
		OrdenDeProdDAO.getInstancia().guardarOP(op2);
		OrdenDeProdDAO.getInstancia().guardarOP(op3);
		*/


		
	}
}