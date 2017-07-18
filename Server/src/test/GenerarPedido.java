package test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import negocio.Cliente;
import negocio.ItemPedido;
import negocio.Pedido;
import negocio.Prenda;
import negocio.Sucursal;
import dao.ClienteDAO;
import dao.PedidoDAO;
import dao.PrendaDAO;
import dao.SucursalDAO;

public class GenerarPedido {

	public static void main(String[] args) {
		
		
		 
		//GENERO UN PEDIDO
		
		
		Cliente cliente = ClienteDAO.getInstance().recuperarCliente(1);
		Sucursal sucursal = SucursalDAO.getInstancia().recuperarSucursal(cliente.getSucursal().getIdSucursal());
		
		Prenda prenda1 = PrendaDAO.getInstance().obtenerPrenda(2);
		/*
		Prenda prenda2 = PrendaDAO.getInstance().obtenerPrenda(2);
		Prenda prenda3 = PrendaDAO.getInstance().obtenerPrenda(3);
		Prenda prenda4 = PrendaDAO.getInstance().obtenerPrenda(4);
		Prenda prenda5 = PrendaDAO.getInstance().obtenerPrenda(5);
		Prenda prenda6 = PrendaDAO.getInstance().obtenerPrenda(6);
		Prenda prenda7 = PrendaDAO.getInstance().obtenerPrenda(7);
		Prenda prenda8 = PrendaDAO.getInstance().obtenerPrenda(8);
		*/
		
		
		List<ItemPedido> lip=new ArrayList<ItemPedido>();
		ItemPedido ip1=new ItemPedido(1,prenda1,null,true);	
	/*
		ItemPedido ip2=new ItemPedido(30,prenda2,null,true);
		ItemPedido ip3=new ItemPedido(40,prenda3,null,true);
		ItemPedido ip4=new ItemPedido(10,prenda4,null,true);
		ItemPedido ip5=new ItemPedido(30,prenda5,null,true);
		ItemPedido ip6=new ItemPedido(40,prenda6,null,true);
		ItemPedido ip7=new ItemPedido(10,prenda7,null,true);
		ItemPedido ip8=new ItemPedido(30,prenda8,null,true);
		*/
		
		
		lip.add(ip1);
		/*
		lip.add(ip2);
		lip.add(ip3);
		lip.add(ip4);
		lip.add(ip5);
		lip.add(ip6);
		lip.add(ip7);
		lip.add(ip8);
		*/
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");		
		String fechaGeneracion=dateFormat.format(date);	
		
		Pedido p=new Pedido(lip,fechaGeneracion,null,null,400,cliente,sucursal,"Para Aprobar",null,true);
		PedidoDAO.getInstance().guardarPedido(p);
		p = PedidoDAO.getInstance().obtenerPedido(1);
		
		System.out.println("NUMERO DE PEDIDO GENERADO: "+p.getIdPedido());

	}

}
