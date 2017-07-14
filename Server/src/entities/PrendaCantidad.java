package entities;

import negocio.Prenda;

public class PrendaCantidad {
	private Prenda prenda;
	private Integer cantidadAProducir;
	
	public PrendaCantidad(Prenda p, Integer c) {
		this.prenda=p;
		this.cantidadAProducir=c;
	}

	public Prenda getPrenda() {
		return prenda;
	}

	public void setPrenda(Prenda prenda) {
		this.prenda = prenda;
	}

	public Integer getCantidadAProducir() {
		return cantidadAProducir;
	}

	public void setCantidadAProducir(Integer cantidadAProducir) {
		this.cantidadAProducir = cantidadAProducir;
	}
	
	

}
