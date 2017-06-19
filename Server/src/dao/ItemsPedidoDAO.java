package dao;

import entities.ItemsPedidoEntity;
import entities.PrendaEntity;
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
	
	//CONVIERTO ITEMPEDIDO A ENTITY
	public ItemsPedidoEntity itemPedidoToEntity(ItemPedido item){
		ItemsPedidoEntity itemPedido = new ItemsPedidoEntity();
		PrendaEntity prenda = PrendaDAO.getInstance().prendaToEntity(item.getPrenda());
		itemPedido.setActivo(true);
		itemPedido.setCantidad(item.getCantidad());
		itemPedido.setEstado(item.getEstado());
		itemPedido.setPrenda(prenda);
		return itemPedido;
	}

}
