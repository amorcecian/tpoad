package test;

import controlador.ControladorProduccion;
import controlador.ControladorVenta;

public class TestFunciones {

	public static void main(String[] args) {		
		ControladorVenta.getInstancia().aprobarPedido(1);
		//ControladorProduccion.getInstancia().ContinuarProduccion(1);
		
		//ControladorProduccion.getInstancia().ContinuarProduccion(1);



	}

}
