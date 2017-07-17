package test;

import java.util.List;

import controlador.ControladorCompra;
import controlador.ControladorProduccion;
import controlador.ControladorVenta;
import dao.AlmacenamientoDAO;
import dao.ClienteDAO;
import dao.LoteDAO;
import dao.OrdenCMPDAO;
import dao.OrdenDeProdDAO;
import dao.PedidoDAO;
import dto.AlmacenamientoDTO;
import dto.ClienteDTO;
import dto.LoteDTO;
import dto.OrdenDeProduccionDTO;
import dto.PedidoDTO;
import dto.ordenCMPDTO;
import negocio.Cliente;
import negocio.Lote;
import negocio.OrdenDeProduccion;

public class TestFunciones {

	public static void main(String[] args) {		
		ControladorVenta.getInstancia().aprobarPedido(1);
		//ControladorProduccion.getInstancia().ContinuarProduccion(5);
		
		//ControladorCompra.getInstancia().OrdenCompraCompleta(3);
		
		/*
		List<OrdenDeProduccionDTO> lopdto=ControladorProduccion.getInstancia().listarOrdenesDeProduccion();
		for(OrdenDeProduccionDTO opdto:lopdto) {
			for(LoteDTO ldto:opdto.getLotes()) {
				System.out.println(ldto.getCantidadProducida());
			}
			
			
		}*/
		/*
		List<PedidoDTO> lp=ControladorVenta.getInstancia().listarPedidos();
		for(PedidoDTO p:lp) {
			ClienteDTO c=p.getCliente();
			System.out.println(c.getNombre());
		}
		*/
		/*
		Cliente c=ClienteDAO.getInstance().recuperarCliente(1);
		c.getCuentaCorriente().setSaldo(200);
		ClienteDAO.getInstance().actualizarCliente(c);
		*/
		
		//System.out.println(ControladorProduccion.getInstancia().termineOP(1));

		/*
		List<ordenCMPDTO> locdto=ControladorCompra.getInstancia().ObtenerOCPendientes();
		for(ordenCMPDTO ocdto:locdto) {
				System.out.println(ocdto.getEstado());			
		}
		*/
		
		//OrdenCMPDAO.getInstancia().actualizarEstado(3,"Pepito");

	}

}
