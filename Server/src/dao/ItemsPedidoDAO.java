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
import negocio.Empleado;
import negocio.ItemPedido;
import negocio.Sucursal;

public class ItemsPedidoDAO {
	
	
	private static SessionFactory sf;
	public static ItemsPedidoDAO instancia;
	
	public static ItemsPedidoDAO getInstance(){
		if(instancia==null)
			instancia = new ItemsPedidoDAO();
		return instancia;
	}
	
	//Agregar un itemPedido a la base de datos
	public void agregarItemPedido(ItemPedido item){
		ItemsPedidoEntity ipe = toEntity(item);
		Session session = sf.openSession();
		session.beginTransaction().begin();
		session.save(ipe);
		session.beginTransaction().commit();
		session.close();
	}
	
	//CONVIERTO ITEM PEDIDO A ENTITY
	public ItemsPedidoEntity toEntity(ItemPedido item){
		ItemsPedidoEntity itemPedido = new ItemsPedidoEntity();

		PrendaEntity prenda = PrendaDAO.getInstance().toEntity(item.getPrenda());
		itemPedido.setActivo(true);
		itemPedido.setCantidad(item.getCantidad());
		itemPedido.setEstado(item.getEstado());
		//itemPedido.setPrenda(prenda);
		return itemPedido;
		
	}
	
	public ItemPedido toNegocio(ItemsPedidoEntity ip){
		ItemPedido e=new ItemPedido();
		e.setActivo(ip.isActivo());
		e.setCantidad(ip.getCantidad());
		e.setEstado(ip.getEstado());
		e.setId(ip.getId().getPedido().getIdPedido().toString() + ip.getId().getPrenda().getIdPrenda().toString());
		e.setPrenda(PrendaDAO.getInstance().toNegocio(ip.getId().getPrenda()));
		e.setPedido(PedidoDAO.getInstance().toNegocio(ip.getId().getPedido()));
		return e;		
	}
	

}
