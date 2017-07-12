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
		
		
		/* 
		 *  GENERO UN PEDIDO
		 */
		
		Cliente cliente = ClienteDAO.getInstance().recuperarCliente(1);
		Sucursal sucursal = SucursalDAO.getInstancia().recuperarSucursal(1);
		
		Prenda prenda1 = PrendaDAO.getInstance().obtenerPrenda(1);
		Prenda prenda2 = PrendaDAO.getInstance().obtenerPrenda(2);
		Prenda prenda3 = PrendaDAO.getInstance().obtenerPrenda(3);
		
		
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
		
		Pedido p=new Pedido(lip,fechaGeneracion,null,null,400,cliente,sucursal,"En Proceso",null,true);
		int nroPedido = PedidoDAO.getInstance().guardarPedido(p);
		Pedido p2 = PedidoDAO.getInstance().obtenerPedido(nroPedido);
		
		System.out.println("NUMERO DE PEDIDO GENERADO: "+p2.getIdPedido());

	}

}
