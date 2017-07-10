package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dto.PedidoDTO;
import entities.EmpleadoEntity;
import entities.ItemsPedidoEntity;
import entities.MaterialPorPrendaEntity;
import entities.PedidoEntity;
import entities.PrendaEntity;
import entities.SucursalEntity;
import hbt.HibernateUtil;
import negocio.Empleado;
import negocio.ItemPedido;
import negocio.Sucursal;

public class ItemsPedidoDAO {
	
	
	private static SessionFactory sf;
	public static ItemsPedidoDAO instancia;
	
	public static ItemsPedidoDAO getInstance(){
		if(instancia==null) {
			instancia = new ItemsPedidoDAO();
			sf=HibernateUtil.getSessionFactory();
		}
			
		return instancia;
	}
	
	//Agregar un itemPedido a la base de datos
	public void agregarItemPedido(ItemPedido item){
		Session s = sf.openSession();
		ItemsPedidoEntity ipe = toEntity(item);		
		s.beginTransaction().begin();
		s.save(ipe);
		s.flush();
		s.beginTransaction().commit();
		s.close();
	}
	
	//CONVIERTO ITEM PEDIDO A ENTITY
	public ItemsPedidoEntity toEntity(ItemPedido ip){
		ItemsPedidoEntity ipe = new ItemsPedidoEntity();
		ipe.setId_itemPedido(ip.getId());
		ipe.setActivo(ip.isActivo());
		ipe.setCantidad(ip.getCantidad());
		ipe.setEstado(ip.getEstado());
		ip.getPrenda().getDescripcion();
		ipe.setPrenda(PrendaDAO.getInstance().toEntity(ip.getPrenda()));
		return ipe;		
	}
	
	public ItemPedido toNegocio(ItemsPedidoEntity ip){
		ItemPedido e=new ItemPedido();
		e.setActivo(ip.isActivo());
		e.setCantidad(ip.getCantidad());
		e.setEstado(ip.getEstado());
		e.setId(ip.getId_itemPedido());
		e.setPrenda(PrendaDAO.getInstance().toNegocio(ip.getPrenda()));
		return e;		
	}
	

}
