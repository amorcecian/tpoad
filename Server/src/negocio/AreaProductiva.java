package negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import dao.AreaProductivaDAO;
import dao.LineaProductivaDAO;
import dao.LoteDAO;
import dto.AreaProductivaDTO;
import dto.LineaProductivaDTO;
import dto.LoteDTO;
import entities.AreaProductivaEntity;
import entities.LineaProductivaEntity;
import entities.LoteEntity;

public class AreaProductiva {
	private Integer idAreaProductiva;
	private String nombre;
	private List<LineaProductiva> lineas;
	private List<Lote> lotesPendientes;
	private boolean activo;
	
	public AreaProductiva(){}
	
	public AreaProductiva (AreaProductivaEntity ape){
		AreaProductiva ap = new AreaProductiva();
		ap.setIdAreaProductiva(ape.getIdAreaProductiva());
		ap.setNombre(ape.getNombre());
		
		List<LineaProductiva> lp = new ArrayList<LineaProductiva>();
		for(LineaProductivaEntity i:ape.getLineas())
			lp.add(LineaProductivaDAO.getInstancia().toNegocio(i));
		ap.setLineas(lp);
		
		List<Lote> lotes = new ArrayList<Lote>();
		for(LoteEntity j:ape.getLotesPendientes())		 
			lotes.add(LoteDAO.getInstancia().toNegocio(j));
		ap.setLotesPendientes(lotes);
		ap.setActivo(ape.isActivo());
	}
	
	

	public AreaProductiva(String nombre,List<LineaProductiva> lineas,
			 List<Lote> lotesPendientes,
			boolean activo) {
		super();
		this.nombre = nombre;
		this.lineas = lineas;
		this.lotesPendientes = lotesPendientes;
		this.activo = activo;
	}

	


	public Integer getIdAreaProductiva() {
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
		List<LoteDTO> loteaux = new Vector<LoteDTO>();
		for (Lote lote : this.getLotesPendientes()){
			loteaux.add(lote.toDTO());
		}
		aux.setLotesPendientes(loteaux);
		return aux;
	}




	


	

}
