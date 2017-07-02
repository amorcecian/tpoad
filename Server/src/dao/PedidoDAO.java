package dao;

import hbt.HibernateUtil;

import java.util.List;
import java.util.Vector;

import org.hibernate.*;

import entities.ClienteEntity;
import entities.ItemsPedidoEntity;
import entities.PedidoEntity;
import entities.PrendaEntity;
import exceptions.ExceptionCliente;
import negocio.Cliente;
import negocio.ItemPedido;
import negocio.Pedido;
import negocio.Prenda;
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
			pe.setCliente(ClienteDAO.getInstance().toEntity(cliente));
			//Averiguo la sucursal, la convierto en Entity y la guardo
			Sucursal sucu = SucursalDAO.getInstancia().recuperarSucursal(pedido.getSucursal().getIdSucursal());
			pe.setSucursal(SucursalDAO.getInstancia().toEntity(sucu));
			pe.setEstado(pedido.getEstado());	
			
		} catch (ExceptionCliente e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pe;
		
	}
	
	public Pedido obtenerPedido(Integer idPedido) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		Query q = s.createQuery("FROM PedidoEntity WHERE idPedido=?").setInteger(0, idPedido);
		PedidoEntity pe = (PedidoEntity) q.uniqueResult();
		s.close();
		return this.toNegocio(pe);
	}

	public Pedido toNegocio(PedidoEntity pe) {
		Pedido p = new Pedido();
		p.setActivo(pe.isActivo());
		p.setCliente(ClienteDAO.getInstance().toNegocio(pe.getCliente()));
		p.setEstado(pe.getEstado());
		p.setFechaEstDespacho(pe.getFechaEstDespacho());
		p.setFechaGeneracion(pe.getFechaGeneracion());
		p.setFechaRealDespacho(pe.getFechaRealDespacho());
		p.setIdPedido(pe.getIdPedido());
		List<ItemPedido> itemspedidoaux = new Vector<ItemPedido>();
		for(ItemsPedidoEntity i : pe.getItems()){
			itemspedidoaux.add(ItemsPedidoDAO.getInstance().toNegocio(i));
		}
		p.setMotivoCancelar(pe.getMotivoCancelar());
		p.setSucursal(SucursalDAO.getInstancia().toNegocio(pe.getSucursal()));
		p.setValor(pe.getValor());
		return p;
	}

	public List<Pedido> obtenerPedidosPendientesAreaComercial() {
		//devuelve todos los pedidos pendientes de paorbacion por area comercial
		return null;
		
	}
	

}
