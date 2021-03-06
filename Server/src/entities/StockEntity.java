package entities;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="stocks")
public class StockEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_Stock")
	
	private Integer idStock;
	@Column(name="cantidad")
	private Integer cantidad;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="id_Stock_prendVenta")
	private List<PrendaVentaEntity> prendasVenta;
	

	@Column(name="activo")
	private boolean activo;
		
	public StockEntity() {}


	public Integer getIdStock() {
		return idStock;
	}

	public void setIdStock(Integer idStock) {
		this.idStock = idStock;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public List<PrendaVentaEntity> getPrendasVenta() {
		return prendasVenta;
	}

	public void setPrendasVenta(List<PrendaVentaEntity> prendasVenta) {
		this.prendasVenta = prendasVenta;
	}
	
	
	
}
