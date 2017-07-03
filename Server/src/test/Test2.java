package test;

import java.util.Calendar;
import java.util.Vector;

import controlador.ControladorVenta;
import dao.PrendaDAO;
import dto.ItemPedidoDTO;
import exceptions.ExceptionCliente;
import negocio.ItemPedido;

public class Test2 {

	public static void main(String[] args) throws ExceptionCliente {
		ItemPedido i = new ItemPedido(1, PrendaDAO.getInstance().obtenerPrenda(1), "Activo", true);
		java.util.List<ItemPedidoDTO> items = new Vector<ItemPedidoDTO>();
		items.add(i.toDTO());
		ControladorVenta.getInstancia().generarPedido(items, Calendar.getInstance().getTime().toString(), 1,1, 1, "Activo");

	}

}
