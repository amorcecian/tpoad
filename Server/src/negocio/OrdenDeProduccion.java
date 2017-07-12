package negocio;

import java.util.List;
import java.util.Vector;

import dto.LoteDTO;
import dto.MaterialDTO;
import dto.OrdenDeProduccionDTO;
import dto.PrendaDTO;

public class OrdenDeProduccion {
	private int idOrdenDeProduccion;
	private String fecha;
	private String tipo;
	private List<Prenda> prenda;
	//private List<Material> materiales;
	private Pedido pedido;
	private float precioProd;
	//private List<Lote> lotes;
	private boolean activo;
	
	public OrdenDeProduccion (){}
	
	

	public OrdenDeProduccion(String fecha,
			String tipo, List<Prenda> prenda, /*List<Material> materiales,*/
			Pedido pedido, float precioProd, /*List<Lote> lotes,*/ boolean activo) {
		super();
		this.fecha = fecha;
		this.tipo = tipo;
		this.prenda = prenda;
		//this.materiales = materiales;
		this.pedido = pedido;
		this.precioProd = precioProd;
		//this.lotes = lotes;
		this.activo = activo;
	}



	public int getIdOrdenDeProduccion() {
		return idOrdenDeProduccion;
	}

	public void setIdOrdenDeProduccion(int idOrdenDeProduccion) {
		this.idOrdenDeProduccion = idOrdenDeProduccion;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Prenda> getPrenda() {
		return prenda;
	}

	public void setPrenda(List<Prenda> prenda) {
		this.prenda = prenda;
	}
/*
	public List<Material> getMateriales() {
		return materiales;
	}

	public void setMateriales(List<Material> materiales) {
		this.materiales = materiales;
	}
*/
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public float getPrecioProd() {
		return precioProd;
	}

	public void setPrecioProd(float precioProd) {
		this.precioProd = precioProd;
	}
/*
	public List<Lote> getLotes() {
		return lotes;
	}

	public void setLotes(List<Lote> lotes) {
		this.lotes = lotes;
	}

*/

	public boolean isActivo() {
		return activo;
	}



	public void setActivo(boolean activo) {
		this.activo = activo;
	}



	public OrdenDeProduccionDTO toDTO() {
		OrdenDeProduccionDTO aux = new OrdenDeProduccionDTO();
		aux.setActivo(this.isActivo());
		aux.setFecha(this.getFecha());
		aux.setIdOrdenDeProduccion(this.getIdOrdenDeProduccion());
		aux.setPedido(this.getPedido().toDTO());
		aux.setPrecioProd(this.getPrecioProd());
		aux.setTipo(this.getTipo());
		/*
		List<LoteDTO> listlotes = new Vector<LoteDTO>();
		for(Lote l : this.getLotes())
			listlotes.add(l.toDTO());
		aux.setLotes(listlotes);
		List<MaterialDTO> listmateriales = new Vector<MaterialDTO>();
		for(Material m:this.getMateriales())
			listmateriales.add(m.toDTO());
		aux.setMateriales(listmateriales);
		*/
		List<PrendaDTO> listprendas = new Vector<PrendaDTO>();
		for(Prenda p:this.getPrenda())
			listprendas.add(p.toDTO());
		aux.setPrenda(listprendas);
		return aux;
		
	}



	public void prendaFinalizada(Prenda prenda) {
		// una vez que se termina de generar el lote, el lote me avisa por medio de este metodo
		// que la prenda ya esta en stock y disponible
		
	}
	
	

}
