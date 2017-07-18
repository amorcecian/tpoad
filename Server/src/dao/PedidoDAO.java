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
	public void guardarPedido(Pedido pedido){
		Session s = sf.openSession();
		s.beginTransaction();
		PedidoEntity pe = toEntity(pedido);		
		s.save(pe);
		//s.flush();
		s.getTransaction().commit();
		s.close();
					
	}
	
	//ACTUALIZAR PEDIDO	
	public void actualizarPedido(Pedido pedido){
		Session s = sf.openSession();
		s.beginTransaction();
		PedidoEntity pe = toEntity(pedido);
		s.update(pe);
		s.flush();
		s.getTransaction().commit();
		s.close();			
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
	
	//LISTO TODOS LOS PEDIDOS
	public List<Pedido> listarPedidos(){
		Session s=sf.openSession();
		List<Pedido> lstpedidos=new ArrayList<Pedido>();
		List<PedidoEntity> lstpedidosEntity;
		Query q=s.createQuery("FROM PedidoEntity");
		lstpedidosEntity=q.list();
		for(PedidoEntity pe:lstpedidosEntity) {
			Pedido ped=this.toNegocio(pe);
			lstpedidos.add(ped);
		}
		return lstpedidos;
	}
	

	
	public Pedido obtenerPedido(Integer idPedido) {		
		Session s = sf.openSession();		
		PedidoEntity pe =(PedidoEntity) s.load(PedidoEntity.class, idPedido);
		Pedido p=toNegocio(pe);
		s.close();
		return p;
	}
	
	public PedidoEntity toEntity(Pedido pedido){
		PedidoEntity pe = new PedidoEntity();	
		pe.setIdPedido(pedido.getIdPedido());
		pe.setFechaGeneracion(pedido.getFechaGeneracion());
		pe.setFechaEstDespacho(pedido.getFechaEstDespacho());
		pe.setFechaRealDespacho(pedido.getFechaRealDespacho());		
		Cliente cliente = ClienteDAO.getInstance().recuperarCliente(pedido.getCliente().getIdCliente());
		pe.setCliente(ClienteDAO.getInstance().toEntity(cliente));
		Sucursal sucu = SucursalDAO.getInstancia().recuperarSucursal(pedido.getSucursal().getIdSucursal());
		pe.setSucursal(SucursalDAO.getInstancia().toEntity(sucu));
		pe.setEstado(pedido.getEstado());
		pe.setActivo(true);
		
		List<ItemsPedidoEntity> lipe=new ArrayList<ItemsPedidoEntity>();
		List<ItemPedido> lip=pedido.getItems();

		for(ItemPedido ip:lip) {
			lipe.add(ItemsPedidoDAO.getInstance().toEntity(ip));
		}
		pe.setItems(lipe);
		
		pe.setValor(pedido.getValor());

		return pe;
		
	}
	
	public void actualizarEstadoPedido(int idPedido, String estado) {
		Session s=sf.openSession();
		s.beginTransaction();
		Query q=s.createQuery("UPDATE PedidoEntity SET estado=? WHERE idPedido=?");
		q.setParameter(0, estado);
		q.setParameter(1, idPedido);
		q.executeUpdate();
		s.getTransaction().commit();
		s.close();
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
		List<ItemPedido> lip = new ArrayList<ItemPedido>();
		for(ItemsPedidoEntity i : pe.getItems()){
			ItemPedido ip=ItemsPedidoDAO.getInstance().toNegocio(i);
			lip.add(ip);
		}
		p.setItems(lip);
		p.setMotivoCancelar(pe.getMotivoCancelar());
		p.setSucursal(SucursalDAO.getInstancia().toNegocio(pe.getSucursal()));
		p.setValor(pe.getValor());
		return p;
	}

	

}
