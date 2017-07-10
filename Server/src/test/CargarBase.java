package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import dao.AlmacenamientoDAO;
import dao.AreaProductivaDAO;
import dao.ClienteDAO;
import dao.EmpleadoDAO;
import dao.EtapaProductivaDAO;
import dao.LineaProductivaDAO;
import dao.MaterialDAO;
import dao.PrendaDAO;
import dao.StockDAO;
import dao.SucursalDAO;
import negocio.Almacenamiento;
import negocio.AreaProductiva;
import negocio.Cliente;
import negocio.CuentaCorriente;
import negocio.Empleado;
import negocio.EtapaProductiva;
import negocio.LineaProductiva;
import negocio.Material;
import negocio.MaterialPorPrenda;
import negocio.Prenda;
import negocio.Stock;
import negocio.Sucursal;

public class CargarBase {

	public static void main(String[] args) {
		
		//CARGO LAS AREAS PRODUCTIVAS
		AreaProductiva a1 = new AreaProductiva("Corte", null, true);
		AreaProductiva a2 = new AreaProductiva("Tejido", null, true);
		AreaProductiva a3 = new AreaProductiva("Planchado", null, true);
		AreaProductivaDAO.getInstancia().grabarAreaProductiva(a1);
		AreaProductivaDAO.getInstancia().grabarAreaProductiva(a2);
		AreaProductivaDAO.getInstancia().grabarAreaProductiva(a3);
		
		a1 = AreaProductivaDAO.getInstancia().recuperarAreaProductiva(1);
		a2 = AreaProductivaDAO.getInstancia().recuperarAreaProductiva(2);
		a3 = AreaProductivaDAO.getInstancia().recuperarAreaProductiva(3);
		
		
		//CARGO LAS LINEAS PRODUCTIVAS
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
		
		//CARGO LAS ETAPAS PRODUCTIVAS
		EtapaProductiva e1 = new EtapaProductiva(a1,2,0,true);
		EtapaProductiva e2 = new EtapaProductiva(a2,3,1,true);
		EtapaProductiva e3 = new EtapaProductiva(a3,1,2,true);
		EtapaProductivaDAO.getInstance().grabarEtapaProductiva(e1);
		EtapaProductivaDAO.getInstance().grabarEtapaProductiva(e2);
		EtapaProductivaDAO.getInstance().grabarEtapaProductiva(e3);
		
		
		e1=EtapaProductivaDAO.getInstance().recuperarEtapaProductiva(1);
		e2=EtapaProductivaDAO.getInstance().recuperarEtapaProductiva(2);
		e3=EtapaProductivaDAO.getInstance().recuperarEtapaProductiva(3);
		
		List <EtapaProductiva> etapas1 = new ArrayList<EtapaProductiva>();
		etapas1.add(e1);
		etapas1.add(e2);
		etapas1.add(e3);
		
		List <EtapaProductiva> etapas2 = new ArrayList<EtapaProductiva>();
		etapas2.add(e1);
		etapas2.add(e2);

		
		//GENERO LOS ALMACENAMIENTOS
		Almacenamiento al1 = new Almacenamiento("1", 1, 1, 1, true, null, true);
		Almacenamiento al2 = new Almacenamiento("2", 2, 2, 2, true, null, true);
		Almacenamiento al3 = new Almacenamiento("3", 3, 3, 3, true, null, true);
		AlmacenamientoDAO.getInstance().grabarAlmacenamiento(al1);
		AlmacenamientoDAO.getInstance().grabarAlmacenamiento(al2);
		AlmacenamientoDAO.getInstance().grabarAlmacenamiento(al3);
		
		//GENERO LAS SUCURSALES
		Sucursal sucu1 = new Sucursal("Once", "Av. Corrientes 9848", "De 9 hs a 22 hs.", true);
		Sucursal sucu2 = new Sucursal("Palermo", "Av. Santa Fe 345", "De 10 hs a 21 hs.", true);
		Sucursal sucu3 = new Sucursal("Villa Crespo", "Av. Scalabrini Ortiz 456", "De 8 hs a 17 hs.", true);
		SucursalDAO.getInstancia().agregarSucursal(sucu1);
		SucursalDAO.getInstancia().agregarSucursal(sucu2);
		SucursalDAO.getInstancia().agregarSucursal(sucu3);
		
		
		//CARGO CLIENTES
		CuentaCorriente cc1 = new CuentaCorriente(123f, "1", 142, 0);
		CuentaCorriente cc2 = new CuentaCorriente(123f, "2", 142, 0);
		CuentaCorriente cc3 = new CuentaCorriente(123f, "3", 142, 0);
		
		sucu1=SucursalDAO.getInstancia().recuperarSucursal(1);
		sucu2=SucursalDAO.getInstancia().recuperarSucursal(2);
		sucu3=SucursalDAO.getInstancia().recuperarSucursal(3);
		
		Cliente c1 = new Cliente("Adidas", "Av Corrientes 834","adidas","adidas", cc1, null, null, "Responsable Inscripto", sucu1, true);
		Cliente c2 = new Cliente("Nike", "Av Cordoba 84","nike","nike", cc2, null, null, "Responsable Inscripto", sucu2, true);
		Cliente c3 = new Cliente("Puma", "Av Independencia 8434","puma","puma", cc3, null, null, "Responsable Inscripto", sucu3, true);
		

		ClienteDAO.getInstance().grabarCliente(c1);
		ClienteDAO.getInstance().grabarCliente(c2);
		ClienteDAO.getInstance().grabarCliente(c3);

		//CARGO UN EMPLEADO
		Empleado emp1 = new Empleado("Marcos Acuña","marcos.acuña@gmail.com","Marketing","marcos.acuña","marcos",sucu1,true);
		Empleado emp2 = new Empleado("Gustavo Bou","gustavo.bou@gmail.com","Ventas","gustavo.bou","gustavo",sucu2,true);
		Empleado emp3 = new Empleado("Diego Milito","diego.milito@gmail.com","Ventas","diego.milito","diego",sucu3,true);
		EmpleadoDAO.getInstancia().grabarEmpleado(emp1);
		EmpleadoDAO.getInstancia().grabarEmpleado(emp2);
		EmpleadoDAO.getInstancia().grabarEmpleado(emp3);
		
		//CARGO LOS MATERIALES
		Material m1 = new Material("Tela Azul", 100, 50, "Telas SRL", 1, true);
		Material m2 = new Material("Tela Roja", 100, 50, "Telas SRL", 1, true);
		Material m3 = new Material("Botones", 100, 50, "Botones SA", 1, true);
		MaterialDAO.getInstancia().grabarMaterial(m1);
		MaterialDAO.getInstancia().grabarMaterial(m2);
		MaterialDAO.getInstancia().grabarMaterial(m3);
		
		
		m1 = MaterialDAO.getInstancia().recuperarMaterial(1);
		m2 = MaterialDAO.getInstancia().recuperarMaterial(2);
		m3 = MaterialDAO.getInstancia().recuperarMaterial(3);
			
		
		//CARGO LOS MATERIALES POR PRENDA
		MaterialPorPrenda mp1 = new MaterialPorPrenda(23,m1,3,true);
		MaterialPorPrenda mp2 = new MaterialPorPrenda(22,m2,2,true);
		MaterialPorPrenda mp3 = new MaterialPorPrenda(33,m3,5,true);
		
		//CARGO LA PRENDA
		List<MaterialPorPrenda> lmpp1=new ArrayList<MaterialPorPrenda>();
		lmpp1.add(mp1);
		lmpp1.add(mp3);
		List<MaterialPorPrenda> lmpp2=new ArrayList<MaterialPorPrenda>();
		lmpp2.add(mp2);
		lmpp2.add(mp3);
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
		Prenda prenda2 = new Prenda("Buzo", "Azul", "L", 23f, "2017", 6, 25, stock2,lmpp2, etapas2, true,12);
		Prenda prenda3 = new Prenda("Pantalon", "Naranja", "XL", 23f, "2017", 6, 25, stock3,lmpp3, etapas1, true,12);
		PrendaDAO.getInstance().agregarPrenda(prenda1);
		PrendaDAO.getInstance().agregarPrenda(prenda2);
		PrendaDAO.getInstance().agregarPrenda(prenda3);
		prenda1 = PrendaDAO.getInstance().obtenerPrenda(1);
		prenda2 = PrendaDAO.getInstance().obtenerPrenda(2);
		prenda3 = PrendaDAO.getInstance().obtenerPrenda(3);

	}

}
