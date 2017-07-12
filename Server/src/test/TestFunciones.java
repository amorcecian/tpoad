package test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import controlador.ControladorProduccion;
import controlador.ControladorVenta;
import dao.ClienteDAO;
import dao.FacturaDAO;
import dao.PedidoDAO;
import dao.PrendaDAO;
import dao.SucursalDAO;
import dto.ItemPedidoDTO;
import dto.PedidoDTO;
import dto.PrendaDTO;
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
