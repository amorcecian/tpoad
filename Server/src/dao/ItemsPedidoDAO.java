package dao;

import dto.PedidoDTO;
import entities.EmpleadoEntity;
import entities.ItemsPedidoEntity;
import entities.PedidoEntity;
import entities.PrendaEntity;
import entities.SucursalEntity;
import negocio.Empleado;
import negocio.ItemPedido;
import negocio.Sucursal;

public class ItemsPedidoDAO {
	
	public static ItemsPedidoDAO instancia;
	
	public static ItemsPedidoDAO getInstance(){
		if(instancia==null)
			instancia = new ItemsPedidoDAO();
		return instancia;
	}
	
	//Agregar un itemPedido a la base de datos
	public int agregarItemPedido(ItemPedido item){
		return (Integer) null;
	}
	
	//CONVIERTO ITEM PEDIDO A ENTITY
	public ItemsPedidoEntity itemPedidoToEntity(ItemPedido item){
		ItemsPedidoEntity itemPedido = new ItemsPedidoEntity();
		PrendaEntity prenda = PrendaDAO.getInstance().toEntity(item.getPrenda());
		itemPedido.setActivo(true);
		itemPedido.setCantidad(item.getCantidad());
		itemPedido.setEstado(item.getEstado());
		itemPedido.setPrenda(prenda);
		return itemPedido;
		
	}
	
	public ItemPedido toNegocio(ItemsPedidoEntity ip){
		ItemPedido e=new ItemPedido();
		e.setActivo(ip.isActivo());
		e.setCantidad(ip.getCantidad());
		e.setEstado(ip.getEstado());
		e.setId(ip.getId().getPedido().getIdPedido().toString() + ip.getId().getPrenda().getIdPrenda().toString());
		e.setPrenda(PrendaDAO.getInstance().toNegocio(ip.getPrenda()));
		return e;		
	}
	

}
