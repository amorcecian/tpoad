package negocio;

import java.util.List;
import java.util.Vector;

import dto.AreaProductivaDTO;
import dto.LineaProductivaDTO;
import dto.LoteDTO;

public class AreaProductiva {
	private int idAreaProductiva;
	private String nombre;
	private List<LineaProductiva> lineas;
	private List<Lote> lotesPendientes;
	private boolean activo;
	
	public AreaProductiva(){}
	
	

	public AreaProductiva(int idAreaProductiva, String nombre,
			List<LineaProductiva> lineas, List<Lote> lotesPendientes,
			boolean activo) {
		super();
		this.idAreaProductiva = idAreaProductiva;
		this.nombre = nombre;
		this.lineas = lineas;
		this.lotesPendientes = lotesPendientes;
		this.activo = activo;
	}



	public int getIdAreaProductiva() {
		return idAreaProductiva;
	}

	public void setIdAreaProductiva(int idAreaProductiva) {
		this.idAreaProductiva = idAreaProductiva;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<LineaProductiva> getLineas() {
		return lineas;
	}

	public void setLineas(List<LineaProductiva> lineas) {
		this.lineas = lineas;
	}

	public List<Lote> getLotesPendientes() {
		return lotesPendientes;
	}

	public void setLotesPendientes(List<Lote> lotesPendientes) {
		this.lotesPendientes = lotesPendientes;
	}



	public boolean isActivo() {
		return activo;
	}



	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public AreaProductivaDTO toDTO() {
		AreaProductivaDTO aux = new AreaProductivaDTO();
		aux.setActivo(this.isActivo());
		aux.setIdAreaProductiva(this.getIdAreaProductiva());
		aux.setNombre(this.getNombre());
		List<LineaProductivaDTO> laux = new Vector<LineaProductivaDTO>();
		for (LineaProductiva l : this.getLineas()){
			laux.add(l.toDTO());
		}
		aux.setLineas(laux);
		List<LoteDTO> loteaux = new Vector<LoteDTO>();
		for (Lote lote : this.getLotesPendientes()){
			loteaux.add(lote.toDTO());
		}
		aux.setLotesPendientes(loteaux);
		return aux;
	}



	public boolean asignarLinea(Lote lote) {
		boolean asignado = false;
		int aux = 0;
		
		//mientras no este asignado, recorro el vector de lineas
		while(asignado == false)
		{
			//Encuentro una linea libre
			if(this.getLineas().get(aux).getEstado()=="Libre"){
				// Asigno el lote a la linea, cambio estado
				this.getLineas().get(aux).setEstado("Ocupado");
				asignado = true;
				this.getLineas().get(aux).setLote(lote);
			} 
			//linea no estaba libre, sigo buscando
			else{
				aux++;
			}

		}
		//si no habia lineas libres, agrego el lote a los pendientes
		if(asignado==false){
			this.lotesPendientes.add(lote);
		}
		
		return asignado;
		
	}



	public void liberarLinea(int idLineaProd) {
		for(LineaProductiva l : lineas){
			if(l.getIdLinea() == idLineaProd){
				//Cambio estado
				l.setEstado("Libre");
				//aviso al lote que siga con la proxima etapa
				l.getLote().seguirProximaEtapa();
				//si tengo lote pendiente, lo ubico
				if(!this.getLotesPendientes().isEmpty()){
					Lote aux = this.getLotesPendientes().get(0);
					this.getLotesPendientes().remove(aux);
					l.setLote(aux);
					l.setEstado("Ocupado");
					aux.setEstado("Produccion");
					
				}
				
			}
		}
		
	}

	


	

}
