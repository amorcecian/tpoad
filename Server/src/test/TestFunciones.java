package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import controlador.ControladorProduccion;
import controlador.ControladorVenta;
import dao.FacturaDAO;
import dao.PedidoDAO;
import dto.PedidoDTO;
import negocio.*;

public class TestFunciones {

	public static void main(String[] args) {
		//PedidoDTO pdto=ControladorVenta.getInstancia().obtenerPedido(1);
		//System.out.println(pdto.getFechaGeneracion());
		//ControladorVenta.getInstancia().aprobarPedido(1);
		
		//Factura f1=FacturaDAO.getInstance().recuperarFactura(1);
		//System.out.println(f1.getIdFactura());
		
		ControladorVenta.getInstancia().aprobarPedido(1);


	}

}
