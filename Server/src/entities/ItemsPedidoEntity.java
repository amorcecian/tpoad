package entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="items_pedido")
public class ItemsPedidoEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id",nullable=false)
	private Integer id_itemPedido;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_item_prenda")
	private PrendaEntity prenda;	
	
	
	@Column(name="cantidad")
	private Integer cantidad;

	@Column(name="estado")
	private String estado;
	@Column(name="activo")
	private boolean activo;
	
	public ItemsPedidoEntity(){};
		
	
	
	public ItemsPedidoEntity(Integer id,PrendaEntity prenda, Integer cantidad,
			String estado, boolean activo) {
		super();
		this.id_itemPedido = id;
		this.prenda=prenda;
		this.cantidad = cantidad;
		this.estado = estado;
		this.activo = activo;
	}


	

	public Integer getId_itemPedido() {
		return id_itemPedido;
	}



	public void setId_itemPedido(Integer id_itemPedido) {
		this.id_itemPedido = id_itemPedido;
	}

	

	public PrendaEntity getPrenda() {
		return prenda;
	}

	public void setPrenda(PrendaEntity prenda) {
		this.prenda = prenda;
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
