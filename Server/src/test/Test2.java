package test;

import java.util.Calendar;
import java.util.Vector;

import controlador.ControladorCompra;
import controlador.ControladorVenta;
import dao.PrendaDAO;
import dto.ItemPedidoDTO;
import exceptions.ExceptionCliente;
import negocio.ItemPedido;

public class Test2 {

	public static void main(String[] args) throws ExceptionCliente {
		ControladorCompra.getInstancia().generarOrdenCompra(prenda, orden);
		
		
	}

}
