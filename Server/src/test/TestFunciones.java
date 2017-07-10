package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import controlador.ControladorVenta;
import dao.PedidoDAO;
import dto.PedidoDTO;
import negocio.Pedido;

public class TestFunciones {

	public static void main(String[] args) {
		//PedidoDTO pdto=ControladorVenta.getInstancia().obtenerPedido(1);
		//System.out.println(pdto.getFechaGeneracion());
		ControladorVenta.getInstancia().aprobarPedido(1);


	}

}
