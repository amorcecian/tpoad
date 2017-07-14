package test;

import controlador.ControladorVenta;

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
