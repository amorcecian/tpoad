package entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="items_pedido")
public class ItemsPedidoEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ItemsPedidoIDEntity id;
	
	@Column(name="cantidad")
	private Integer cantidad;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idPrenda")
	private PrendaEntity prenda;
	
	@Column(name="estado")
	private String estado;
	@Column(name="activo")
	private boolean activo;
	
	public ItemsPedidoEntity(){};
		
	
	
	public ItemsPedidoEntity(ItemsPedidoIDEntity id, Integer cantidad,
			String estado, boolean activo) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.estado = estado;
		this.activo = activo;
	}



	public ItemsPedidoIDEntity getId() {
		return id;
	}
	public void setId(ItemsPedidoIDEntity id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public String getEstado() {
		return estado;
	}
	
	public PrendaEntity getPrenda() {
		return prenda;
	}

	public void setPrenda(PrendaEntity prenda) {
		this.prenda = prenda;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public boolean isActivo() {
		return activo;
	}



	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	

}
