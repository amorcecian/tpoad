package entities;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="stocks")
public class StockEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_stock")
	private Integer idStock;
	@Column(name="cantidad")
	private Integer cantidad;
	@OneToMany
	@JoinColumn(name="id_prenda_venta")
	private List<PrendaVentaEntity> prendasVenta;
	@Column(name="activo")
	private boolean activo;
		
	public StockEntity() {}

	public StockEntity(Integer idStock, Integer cantidad,
			List<PrendaVentaEntity> prendasVenta, boolean activo) {
		super();
		this.idStock = idStock;
		this.cantidad = cantidad;
		this.prendasVenta = prendasVenta;
		this.activo = activo;
	}



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

	public List<PrendaVentaEntity> getPrendasVenta() {
		return prendasVenta;
	}

	public void setPrendasVenta(List<PrendaVentaEntity> prendasVenta) {
		this.prendasVenta = prendasVenta;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	
}
