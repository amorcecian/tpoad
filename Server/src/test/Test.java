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
import negocio.Pedido;
import negocio.Prenda;
import negocio.PrendaVenta;
import negocio.Remito;
import negocio.Stock;
import negocio.Sucursal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.hibernate.cache.ReadWriteCache.Item;

import businessDelegate.BusinessDelegate;
import controlador.ControladorCompra;
import controlador.ControladorProduccion;
import controlador.ControladorVenta;
import dao.AlmacenamientoDAO;
import dao.AreaProductivaDAO;
import dao.ClienteDAO;
import dao.EmpleadoDAO;
import dao.EtapaProductivaDAO;
import dao.LineaProductivaDAO;
import dao.LoteDAO;
import dao.MaterialDAO;
import dao.MaterialPorPrendaDAO;
import dao.OrdenDeProdDAO;
import dao.PedidoDAO;
import dao.PrendaDAO;
import dao.PrendaVentaDAO;
import dao.RemitoDAO;
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
		//Desde aca empiezo test 
		
		AreaProductiva a1 = new AreaProductiva("Corte", null, true);
		AreaProductiva a2 = new AreaProductiva("Tejido", null, true);
		AreaProductiva a3 = new AreaProductiva("Planchado", null, true);
		AreaProductivaDAO.getInstancia().grabarAreaProductiva(a1);
		AreaProductivaDAO.getInstancia().grabarAreaProductiva(a2);
		AreaProductivaDAO.getInstancia().grabarAreaProductiva(a3);
		

		a1 = AreaProductivaDAO.getInstancia().recuperarAreaProductiva(1);
		a2 = AreaProductivaDAO.getInstancia().recuperarAreaProductiva(2);
		a3 = AreaProductivaDAO.getInstancia().recuperarAreaProductiva(3);
		
		LineaProductiva l11 = new LineaProductiva("Libre",null,true,a1);
		LineaProductiva l12 = new LineaProductiva("Libre",null,true,a1);
		LineaProductiva l13 = new LineaProductiva("Libre",null,true,a1);
		LineaProductiva l21 = new LineaProductiva("Libre",null,true,a2);
		LineaProductiva l22 = new LineaProductiva("Libre",null,true,a2);
		LineaProductiva l23 = new LineaProductiva("Libre",null,true,a2);
		LineaProductiva l31 = new LineaProductiva("Libre",null,true,a3);
		LineaProductiva l32 = new LineaProductiva("Libre",null,true,a3);
		LineaProductiva l33 = new LineaProductiva("Libre",null,true,a3);
		
		
		LineaProductivaDAO.getInstancia().grabarLinea(l33);
		LineaProductivaDAO.getInstancia().grabarLinea(l11);
		LineaProductivaDAO.getInstancia().grabarLinea(l31);
		LineaProductivaDAO.getInstancia().grabarLinea(l31);		
		LineaProductivaDAO.getInstancia().grabarLinea(l12);
		LineaProductivaDAO.getInstancia().grabarLinea(l23);
		LineaProductivaDAO.getInstancia().grabarLinea(l22);
		LineaProductivaDAO.getInstancia().grabarLinea(l21);
		LineaProductivaDAO.getInstancia().grabarLinea(l13);
		
		
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
		
		EtapaProductiva e1 = new EtapaProductiva(a1,2,0,true);
		EtapaProductiva e2 = new EtapaProductiva(a2,3,1,true);
		EtapaProductiva e3 = new EtapaProductiva(a3,1,2,true);
		EtapaProductivaDAO.getInstance().grabarEtapaProductiva(e1);
		EtapaProductivaDAO.getInstance().grabarEtapaProductiva(e2);
		EtapaProductivaDAO.getInstance().grabarEtapaProductiva(e3);
		
		List <EtapaProductiva> etapas1 = new Vector<EtapaProductiva>();
		etapas1.add(e1);
		etapas1.add(e2);
		etapas1.add(e3);
			
		Almacenamiento al1 = new Almacenamiento("1", 1, 1, 1, true, true);
		Almacenamiento al2 = new Almacenamiento("2", 2, 2, 2, true, true);
		Almacenamiento al3 = new Almacenamiento("3", 3, 3, 3, true, true);
		AlmacenamientoDAO.getInstance().grabarAlmacenamiento(al1);
		AlmacenamientoDAO.getInstance().grabarAlmacenamiento(al2);
		AlmacenamientoDAO.getInstance().grabarAlmacenamiento(al3);
		
		Sucursal sucu1 = new Sucursal("1", "1", "1", true);
		Sucursal sucu2 = new Sucursal("2", "2", "2", true);
		Sucursal sucu3 = new Sucursal("3", "3", "3", true);
		SucursalDAO.getInstancia().agregarSucursal(sucu1);
		SucursalDAO.getInstancia().agregarSucursal(sucu2);
		SucursalDAO.getInstancia().agregarSucursal(sucu3);
		
		sucu1=SucursalDAO.getInstancia().recuperarSucursal(1);
		sucu2=SucursalDAO.getInstancia().recuperarSucursal(2);
		sucu3=SucursalDAO.getInstancia().recuperarSucursal(3);
		
		CuentaCorriente cc1 = new CuentaCorriente(123f, "1", 142, 0);
		CuentaCorriente cc2 = new CuentaCorriente(123f, "2", 142, 0);
		CuentaCorriente cc3 = new CuentaCorriente(123f, "3", 142, 0);
		
		Cliente c1 = new Cliente("Adidas", "Av Corrientes 834","adidas","adidas", cc1, null, null, "Responsable Inscripto", sucu1, true);
		Cliente c2 = new Cliente("Nike", "Av Cordoba 84","nike","nike", cc2, null, null, "Responsable Inscripto", sucu2, true);
		Cliente c3 = new Cliente("Puma", "Av Independencia 8434","puma","puma", cc3, null, null, "Responsable Inscripto", sucu3, true);
		

		ClienteDAO.getInstance().grabarCliente(c1);
		ClienteDAO.getInstance().grabarCliente(c2);
		ClienteDAO.getInstance().grabarCliente(c3);
		
		c1=ClienteDAO.getInstance().recuperarCliente(1);
		c2=ClienteDAO.getInstance().recuperarCliente(2);
		c3=ClienteDAO.getInstance().recuperarCliente(3);
		
		Empleado emp1 = new Empleado("Marcos Acuña","marcos.acuña@gmail.com","Marketing","marcos.acuña","marcos",sucu1,true);
		Empleado emp2 = new Empleado("Gustavo Bou","gustavo.bou@gmail.com","Ventas","gustavo.bou","gustavo",sucu2,true);
		Empleado emp3 = new Empleado("Diego Milito","diego.milito@gmail.com","Ventas","diego.milito","diego",sucu3,true);
		EmpleadoDAO.getInstancia().grabarEmpleado(emp1);
		EmpleadoDAO.getInstancia().grabarEmpleado(emp2);
		EmpleadoDAO.getInstancia().grabarEmpleado(emp3);
		
		
		Material m1 = new Material("Tela Azul", 20, 50, "Telas SRL", 1, true);
		Material m2 = new Material("Tela Roja", 20, 50, "Telas SRL", 1, true);
		Material m3 = new Material("Botones", 20, 50, "Botones SA", 1, true);
		MaterialDAO.getInstancia().grabarMaterial(m1);
		MaterialDAO.getInstancia().grabarMaterial(m2);
		MaterialDAO.getInstancia().grabarMaterial(m3);
		
		
		m1 = MaterialDAO.getInstancia().recuperarMaterial(1);
		m2 = MaterialDAO.getInstancia().recuperarMaterial(2);
		m3 = MaterialDAO.getInstancia().recuperarMaterial(3);
				

		MaterialPorPrenda mp1 = new MaterialPorPrenda(23,m1,3,true);
		MaterialPorPrenda mp2 = new MaterialPorPrenda(22,m2,2,true);
		MaterialPorPrenda mp3 = new MaterialPorPrenda(33,m3,5,true);
		
		
		List<MaterialPorPrenda> lmpp1=new ArrayList<MaterialPorPrenda>();
		lmpp1.add(mp1);
		lmpp1.add(mp2);
		lmpp1.add(mp3);
		List<MaterialPorPrenda> lmpp2=new ArrayList<MaterialPorPrenda>();
		lmpp2.add(mp1);
		lmpp2.add(mp2);
		List<MaterialPorPrenda> lmpp3=new ArrayList<MaterialPorPrenda>();
		lmpp3.add(mp1);

		
		
		Stock stock1 = new Stock(10, true);
		Stock stock2 = new Stock(20, true);
		Stock stock3 = new Stock(30, true);
		StockDAO.getInstance().grabarStock(stock1);
		StockDAO.getInstance().grabarStock(stock2);
		StockDAO.getInstance().grabarStock(stock3);
		stock1=StockDAO.getInstance().recuperarStock(1);
		stock2=StockDAO.getInstance().recuperarStock(2);
		stock3=StockDAO.getInstance().recuperarStock(3);
		Prenda prenda1 = new Prenda("Remera", "Verde", "M", 23f, "2017", 6, 25, stock1,lmpp1, etapas1, true,12);
		Prenda prenda2 = new Prenda("Buzo", "Azul", "L", 23f, "2017", 6, 25, stock2,lmpp2, etapas1, true,12);
		Prenda prenda3 = new Prenda("Pantalon", "Naranja", "XL", 23f, "2017", 6, 25, stock3,lmpp3, etapas1, true,12);
		PrendaDAO.getInstance().agregarPrenda(prenda1);
		PrendaDAO.getInstance().agregarPrenda(prenda2);
		PrendaDAO.getInstance().agregarPrenda(prenda3);
		prenda1 = PrendaDAO.getInstance().obtenerPrenda(1);
		prenda2 = PrendaDAO.getInstance().obtenerPrenda(2);
		prenda3 = PrendaDAO.getInstance().obtenerPrenda(3);
		

		
		List<Material> lm1 = new Vector<Material>();
		lm1.add(m1);
		List<Material> lm2 = new Vector<Material>();
		lm2.add(m2);
		List<Material> lm3 = new Vector<Material>();
		lm3.add(m3);
		
		

		Lote l1 = new Lote(null,prenda1, 0, "activo", 1, al1, 1, 1, true);
		Lote l2 = new Lote(null,prenda2, 0, "activo", 2, al2, 2, 2, true);
		Lote l3 = new Lote(null,prenda3, 0, "activo", 3, al3, 3, 3, true);
		LoteDAO.getInstancia().guardarLote(l1);		
		LoteDAO.getInstancia().guardarLote(l2);		
		LoteDAO.getInstancia().guardarLote(l3);
		
		List<Lote> lotes1 = new Vector<Lote>();
		lotes1.add(l1);
		List<Lote> lotes2 = new Vector<Lote>();
		lotes1.add(l2);
		List<Lote> lotes3 = new Vector<Lote>();
		lotes1.add(l3);
		
		

		
		
		//GENERO Y GRABO PRENDAVENTA Y LO AGREGO A UNA LISTA DE PRENDAVENTA

		PrendaVenta pv1 = new PrendaVenta("Disponible", LoteDAO.getInstancia().obtenerLote(1), true);
		PrendaVenta pv2 = new PrendaVenta("Disponible", LoteDAO.getInstancia().obtenerLote(2), true);
		PrendaVenta pv3 = new PrendaVenta("Disponible", LoteDAO.getInstancia().obtenerLote(3), true);
		
		PrendaVentaDAO.getInstancia().grabarPrendaVenta(pv1);
		PrendaVentaDAO.getInstancia().grabarPrendaVenta(pv2);
		PrendaVentaDAO.getInstancia().grabarPrendaVenta(pv3);
		
		
		pv1=PrendaVentaDAO.getInstancia().recuperarPrendaVenta(1);
		pv2=PrendaVentaDAO.getInstancia().recuperarPrendaVenta(2);
		pv3=PrendaVentaDAO.getInstancia().recuperarPrendaVenta(3);
		List <PrendaVenta> listapv1 = new ArrayList<PrendaVenta>();
		List <PrendaVenta> listapv2 = new ArrayList<PrendaVenta>();
		List <PrendaVenta> listapv3 = new ArrayList<PrendaVenta>();
		listapv1.add(pv1);
		listapv2.add(pv2);
		listapv3.add(pv3);
		
		stock1=StockDAO.getInstance().recuperarStock(1);
		stock2=StockDAO.getInstance().recuperarStock(2);
		stock3=StockDAO.getInstance().recuperarStock(3);
		stock1.setPrendasVenta(listapv1);
		stock2.setPrendasVenta(listapv2);
		stock3.setPrendasVenta(listapv3);
		
		System.out.println(stock1.getPrendasVenta().get(0).getIdPrendaVenta());
		
		StockDAO.getInstance().actualizarStock(stock1);
		StockDAO.getInstance().actualizarStock(stock2);
		StockDAO.getInstance().actualizarStock(stock3);
		
		
		/*DEBO GENERAR UNA FACTURA PRIMERO
		Remito remito1 = new Remito(0, null, true, listapv1, "activo");
		Remito remito2 = new Remito(1, null, true, listapv2, "activo");
		Remito remito3 = new Remito(2, null, true, listapv3, "activo");
		RemitoDAO.getInstance().grabarRemito(remito1);
		RemitoDAO.getInstance().grabarRemito(remito2);
		RemitoDAO.getInstance().grabarRemito(remito3);
		
		remito1=RemitoDAO.getInstance().obtenerRemito(1);
		remito2=RemitoDAO.getInstance().obtenerRemito(2);
		remito3=RemitoDAO.getInstance().obtenerRemito(3);
		*/
		
		
		List<ItemPedido> lip=new ArrayList<ItemPedido>();
		ItemPedido ip1=new ItemPedido(10,prenda1,null,true);
		ItemPedido ip2=new ItemPedido(30,prenda2,null,true);
		ItemPedido ip3=new ItemPedido(40,prenda3,null,true);
		lip.add(ip1);
		lip.add(ip2);
		lip.add(ip3);
		
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");		
		String fechaGeneracion=dateFormat.format(date);	
		
		Pedido p=new Pedido(lip,fechaGeneracion,null,null,400,c1,sucu1,"En Proceso",null,true);
		int nroPedido2 = PedidoDAO.getInstance().guardarPedido(p);
		Pedido p2 = PedidoDAO.getInstance().obtenerPedido(nroPedido2);
		
		
		List<Prenda> lp=new ArrayList<Prenda>();
		lp.add(prenda1);
		lp.add(prenda2);
		
		String fechaOP=dateFormat.format(date);				
		
		OrdenDeProduccion op1 = new OrdenDeProduccion(fechaOP, "Total", lp, lm1, p2, 123f, lotes1, true);
		OrdenDeProduccion op2 = new OrdenDeProduccion(fechaOP, "Total", lp, lm2, null, 123f, lotes2, true);
		OrdenDeProduccion op3 = new OrdenDeProduccion(fechaOP, "Total", lp, lm3, null, 123f, lotes3, true);
		OrdenDeProdDAO.getInstancia().guardarOP(op1);
		OrdenDeProdDAO.getInstancia().guardarOP(op2);
		OrdenDeProdDAO.getInstancia().guardarOP(op3);
		


		
	}
}