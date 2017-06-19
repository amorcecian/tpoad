package dao;

import hbt.HibernateUtil;

import org.hibernate.*;

import entities.ClienteEntity;
import entities.PedidoEntity;
import exceptions.ExceptionCliente;
import negocio.Cliente;
import negocio.Pedido;
import negocio.Sucursal;

public class PedidoDAO {
	
	public static PedidoDAO instancia;
	
	public static PedidoDAO getInstance(){
		if(instancia==null)
			instancia = new PedidoDAO();
		return instancia;
	}
	
	// Guardar un pedido
	
	public int guardarPedido(Pedido pedido){
		PedidoEntity pe = pedidoToEntity(pedido);
		SessionFactory sf = new HibernateUtil().getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		s.persist(pe);
		s.flush();
		s.beginTransaction().commit();
		Integer lastId = (Integer) s.createSQLQuery("SELECT TOP 1 id_pedido FROM pedidos ORDER BY id_pedido DESC ").uniqueResult();
		s.close();
		return lastId;
		
		
	}
	
	public PedidoEntity pedidoToEntity(Pedido pedido){
		PedidoEntity pe = new PedidoEntity();
		try {
			pe.setFechaGeneracion(pedido.getFechaGeneracion());
			//Averiguo el cliente, lo convierto en Entity y lo guardo
			Cliente cliente = ClienteDAO.getInstance().recuperarCliente(pedido.getCliente().getIdCliente());
			pe.setCliente(ClienteDAO.getInstance().clienteToEntity(cliente));
			//Averiguo la sucursal, la convierto en Entity y la guardo
			Sucursal sucu = SucursalDAO.getInstancia().recuperarSucursal(pedido.getSucursal().getIdSucursal());
			pe.setSucursal(SucursalDAO.getInstancia().sucursalToEntity(sucu));
			pe.setEstado(pedido.getEstado());	
			
		} catch (ExceptionCliente e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pe;
		
	}

}
