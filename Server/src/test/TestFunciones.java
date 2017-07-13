package test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import controlador.ControladorCompra;
import controlador.ControladorProduccion;
import controlador.ControladorVenta;
import dao.AreaProductivaDAO;
import dao.ClienteDAO;
import dao.FacturaDAO;
import dao.LoteDAO;
import dao.PedidoDAO;
import dao.PrendaDAO;
import dao.SucursalDAO;
import dto.ItemPedidoDTO;
import dto.OrdenDeProduccionDTO;
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

		//System.out.println(ControladorVenta.getInstancia().validarEmpleado("diego.milito", "diego"));
		
		//ControladorProduccion.getInstancia().listarOrdenesDeProduccion();
		/*
		 for(OrdenDeProduccionDTO opdto:ControladorProduccion.getInstancia().listarOrdenesDeProduccion()) {
		 
			System.out.println(opdto.getIdOrdenDeProduccion());
		}
	*/
		/*
		Lote l = LoteDAO.getInstancia().obtenerLote(2);
		System.out.println(l.getEstado());
		l.setEstado("prueba");
		LoteDAO.getInstancia().actualizarLote(l);
		l = LoteDAO.getInstancia().obtenerLote(2);
		System.out.println(l.getEstado());*/
		//System.out.println(l.getPrenda().getDescripcion());
		
		//ControladorProduccion.getInstancia().listarOrdenesDeProduccion();

	}

}
