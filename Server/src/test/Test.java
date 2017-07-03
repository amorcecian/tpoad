package test;

import negocio.AreaProductiva;
import negocio.Cliente;
import negocio.CuentaCorriente;
import negocio.EtapaProductiva;
import negocio.ItemPedido;
import negocio.LineaProductiva;
import negocio.Lote;
import negocio.Material;
import negocio.MaterialPorPrenda;
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
import dao.AreaProductivaDAO;
import dao.ClienteDAO;
import dao.EtapaProductivaDAO;
import dao.LoteDAO;
import dao.MaterialDAO;
import dao.PrendaDAO;
import dao.PrendaVentaDAO;
import dao.SucursalDAO;
import dto.AreaProductivaDTO;
import dto.ClienteDTO;
import dto.CuentaCorrienteDTO;
import dto.ItemPedidoDTO;
import dto.MaterialDTO;
import dto.SucursalDTO;
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
		EtapaProductivaDAO.getInstance().grabarEtapaProductiva(e1);
		
		List <EtapaProductiva> etapas1 = new Vector<EtapaProductiva>();
		etapas1.add(e1);
		etapas1.add(e2);
		etapas1.add(e3);
		
		Prenda remera = new Prenda(0, "remera", "verde", "l", 23f, "2017", 6, 25, null, etapas1, null, true,12);
		
		
		Lote l = new Lote();
		l.setActivo(true);
		l.setCantidadProducida(324);
		l.setPrenda(remera);
		
		Stock s = new Stock();
		s.setActivo(true);
		s.setCantidad(234);
		
		List <PrendaVenta> listapv = new Vector<PrendaVenta>();
		int aux = 0;
		while(aux < 6){
			PrendaVenta pv = new PrendaVenta("Disponible", l, true);
			listapv.add(pv);
			PrendaVentaDAO.getInstancia().grabarPrendaVenta(pv);
			aux++;
		}
		
		s.setPrendasVenta(listapv);
		remera.setStock(s);
		PrendaDAO.getInstance().agregarPrenda(remera);
		//LoteDAO.getInstancia().guardarLote(l);
		
		Sucursal sucu = new Sucursal();
		sucu.setActivo(true);
		sucu.setDomicilio("lañsdkjf");
		sucu.setHorario("laskjdf");
		sucu.setNombre("ljaskdjf");
		sucu.setIdSucursal(ControladorVenta.getInstancia().agregarSucursal(sucu.toDTO()));
		
		CuentaCorriente cc = new CuentaCorriente();
		cc.setCondicionPago("cash");
		cc.setLimiteCredito(93284029f);
		cc.setSaldo(39f);
		cc.setValorConsignacion(0);
		
		Cliente c = new Cliente();
		c.setactivo(true);
		c.setCondicion("habilitado");
		c.setContraseña("alsdfkj");
		c.setCuentaCorriente(cc);
		c.setDireccion("ñlasdkjf");
		c.setNombre("juan");
		c.setSucursal(sucu);
		c.setUsuario("jñlaskjfd");
		ControladorVenta.getInstancia().agregarCliente(c.toDTO());
		
		ItemPedidoDTO ipa = new ItemPedidoDTO();
		ipa.setActivo(true);
		ipa.setCantidad(3);
		ipa.setPrenda(PrendaDAO.getInstance().obtenerPrenda(1).toDTO());
		List<ItemPedidoDTO> lista = new Vector <ItemPedidoDTO>();
		lista.add(ipa);
		
		
		ControladorVenta.getInstancia().generarPedido(lista, Calendar.getInstance().getTime().toString(), "", "", 324f, c.getIdCliente(), c.getSucursal().getIdSucursal(), "Para Aprobar", "");
		
		
	}

}
