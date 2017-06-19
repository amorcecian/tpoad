package dao;

import dto.PedidoDTO;
import entities.ItemsPedidoEntity;
import entities.PedidoEntity;
import entities.PrendaEntity;
import entities.SucursalEntity;
import negocio.ItemPedido;

public class ItemsPedidoDAO {
	
	public static ItemsPedidoDAO instancia;
	
	public static ItemsPedidoDAO getInstance(){
		if(instancia==null)
			instancia = new ItemsPedidoDAO();
		return instancia;
	}
	
	//Agregar un itemPedido a la base de datos
	public int agregarItemPedido(ItemPedido item){
		
	}
	
	//CONVIERTO ITEM PEDIDO A ENTITY
	public ItemsPedidoEntity itemPedidoToEntity(ItemPedido item){
		ItemsPedidoEntity itemPedido = new ItemsPedidoEntity();
		PrendaEntity prenda = PrendaDAO.getInstance().prendaToEntity(item.getPrenda());
		PedidoEntity pedido = 
		itemPedido.setActivo(true);
		itemPedido.setCantidad(item.getCantidad());
		itemPedido.setEstado(item.getEstado());
		itemPedido.setPrenda;
		return itemPedido;
	}

}
