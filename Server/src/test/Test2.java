package test;

import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import controlador.ControladorCompra;
import dao.OrdenDeProdDAO;
import dao.PedidoDAO;
import dao.PrendaDAO;
import exceptions.ExceptionCliente;
import negocio.OrdenDeProduccion;
import negocio.Pedido;
import negocio.Prenda;

public class Test2 {

	public static void main(String[] args) throws ExceptionCliente {
		Prenda aux = PrendaDAO.getInstance().obtenerPrenda(1);
		//Pedido p = PedidoDAO.getInstance().obtenerPedido(1);
		OrdenDeProduccion o = OrdenDeProdDAO.getInstancia().obtenerOP(1);
		/*System.out.println(aux.getColor());
		List<Prenda> l = new Vector<Prenda>();
		
		o.setActivo(true);
		o.setFecha(Calendar.getInstance().getTime().toString());
		o.setPedido(p);
		o.setPrenda(l);
		OrdenDeProdDAO.getInstancia().guardarOP(o);
		*/
		
		System.out.println(o.getIdOrdenDeProduccion());
		ControladorCompra.getInstancia().generarOrdenCompra(aux, o);
		
		
	}

}
