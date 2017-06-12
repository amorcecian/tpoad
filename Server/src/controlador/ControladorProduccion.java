package controlador;

import java.util.List;

import negocio.*;

public class ControladorProduccion {
	private List<OrdenDeProduccion> ordenesDeProduccion;
	private List<Prenda> prendas;
	private List<Lote> lotes;
	private List<OrdenModificacion> ordendesDeModificacion;
	private List<AreaProductiva> areasProductivas;
	private List<EtapaProductiva> etapasProducctivas;
	
	private static ControladorProduccion instancia;
	
	private static ControladorProduccion getInstancia(){
		if(instancia==null){
			instancia=new ControladorProduccion();
		}
		return instancia;
	}
	

}
