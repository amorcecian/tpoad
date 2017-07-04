package dao;

import hbt.HibernateUtil;

import java.util.ArrayList;
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
	
	private static PedidoDAO instancia;
	private static SessionFactory sf;
	public static PedidoDAO getInstance(){
		if(instancia==null) {
			instancia = new PedidoDAO();
			sf=HibernateUtil.getSessionFactory();
		}
			
		return instancia;
	}
	
	// Guardar un pedido
	
	public int guardarPedido(Pedido pedido){
		PedidoEntity pe = toEntity(pedido);
		Session s = sf.openSession();
		s.save(pe);
		s.flush();
		Integer lastId = (Integer) s.createSQLQuery("SELECT TOP 1 id_pedido FROM pedidos ORDER BY id_pedido DESC ").uniqueResult();
		s.close();
		return lastId;			
	}
	
	//LISTO TODOS LOS PEDIDOS SEGUN ESTADO
	public List<Pedido> listarPedidosEstado(String estado){
		Session s=sf.openSession();
		List<Pedido> lstpedidos=new ArrayList<Pedido>();
		List<PedidoEntity> lstpedidosEntity;
		Query q=s.createQuery("FROM PedidoEntity WHERE estado=? ");
		q.setParameter(0, estado);
		lstpedidosEntity=q.list();
		for(PedidoEntity pe:lstpedidosEntity) {
			Pedido ped=this.toNegocio(pe);
			lstpedidos.add(ped);
		}
		return lstpedidos;
	}
	

	
	public Pedido obtenerPedido(Integer idPedido) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		Query q = s.createQuery("FROM PedidoEntity WHERE idPedido=?").setInteger(0, idPedido);
		PedidoEntity pe = (PedidoEntity) q.uniqueResult();
		s.close();
		return this.toNegocio(pe);
	}
	
	public PedidoEntity toEntity(Pedido pedido){
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
			pe.setActivo(true);
			List<ItemsPedidoEntity> lipe=new ArrayList<ItemsPedidoEntity>();
			if(pedido.getItems()!=null){
			for(ItemPedido ip:pedido.getItems()) {
				ItemsPedidoEntity ipe=ItemsPedidoDAO.getInstance().toEntity(ip);
				lipe.add(ipe);
			}
			pe.setItems(lipe);
			}
			pe.setValor(pedido.getValor());
		} catch (ExceptionCliente e) {
			e.printStackTrace();
		}
		return pe;
		
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
