package controlador;

import java.util.List;

import negocio.*;

public class ControladorProduccion {
	private List<OrdenDeProduccion> ordenesDeProduccion;
	private List<Prenda> prendas;
	private List<Lote> lotes;
	private List<OrdenModificacion> ordendesDeModificacion;
	private List<AreaProductiva> areasProductivas;
	private List<EtapaProductiva> etapasProductivas;
	private List<Almacenamiento> almacenamiento;
	
	private static ControladorProduccion instancia;
	
	public static ControladorProduccion getInstancia(){
		if(instancia==null){
			instancia=new ControladorProduccion();
		}
		return instancia;
	}
	
	//Me notifican que termino una linea de prod
	public void liberarArea(int idLineaProd,int idAreaProductiva){
		//recorro todas las etapas hasta dar con la indicada
		for(AreaProductiva a : areasProductivas){
			a.liberarLinea(idLineaProd);
		}
		
	}

	public void obtenerDepositoLibre(Lote lote) {
		int aux = 0;
		boolean asignado = false;
		while (asignado == false){
			Almacenamiento a = this.almacenamiento.get(aux);
			if(a.isLibre() == true){
				a.setLibre(false);
				a.setLote(lote);
				asignado = true;
			}
			aux++;
		}
		
	}
}
