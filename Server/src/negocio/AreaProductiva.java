package negocio;

import java.util.List;

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
	
	
	

}
