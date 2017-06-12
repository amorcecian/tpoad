package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import dto.ClienteDTO;


@Entity
@Table(name="clientes")
public class ClienteEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_cliente",nullable=false)
	private Integer idCliente;
	@Column(name="nombre")
	private String nombre;
	@Column(name="domicilio")
	private String direccion;
	@Column(name="condicion")
	private String condicion;
	@Column(name="activo")
	private boolean activo;
	
	@Embedded
	private CuentaCorrienteEntity cuentaCorriente;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_sucursal")
	private SucursalEntity sucursal;
	
	/*
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="id_cliente")
	private List<PedidoEntity> pedidos;
	*/
	
	// ******************************************************
	// Constructor
	// *****************************************************
		
	public ClienteEntity(){}
	
		
	public ClienteEntity(Integer idCliente, String nombre, String direccion,
			String condicion, CuentaCorrienteEntity cuentaCorriente,
			SucursalEntity sucursal, List<PedidoEntity> pedidos, boolean activo) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.direccion = direccion;
		this.condicion = condicion;
		this.cuentaCorriente = cuentaCorriente;
		this.sucursal = sucursal;
		this.activo = activo;
		//this.pedidos = pedidos;
	}


	// ******************************************************
	// Getters y Setters
	// *****************************************************
	
	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public CuentaCorrienteEntity getCuentaCorriente() {
		return cuentaCorriente;
	}

	public void setCuentaCorriente(CuentaCorrienteEntity cuentaCorriente) {
		this.cuentaCorriente = cuentaCorriente;
	}
/*
	public List<PedidoEntity> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<PedidoEntity> pedidos) {
		this.pedidos = pedidos;
	}
*/
	public String getCondicion() {
		return condicion;
	}

	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}

	public SucursalEntity getSucursal() {
		return sucursal;
	}

	public void setSucursal(SucursalEntity sucursal) {
		this.sucursal = sucursal;
	}


	public boolean isactivo() {
		return activo;
	}


	public void setactivo(boolean activo) {
		this.activo = activo;
	}
	
	
	public ClienteDTO toDTO(){
		ClienteDTO aux = new ClienteDTO();
		aux.setActivo(this.activo);
		aux.setCondicion(this.condicion);
		aux.setCondicionPago(this.cuentaCorriente.getCondicionPago());
		aux.setDireccion(this.direccion);
		aux.setIdSucu(this.getSucursal().getIdSucursal());
		aux.setLimiteCredito(this.cuentaCorriente.getLimiteCredito());
		aux.setNombre(this.nombre);
		aux.setSaldo(this.cuentaCorriente.getSaldo());
		aux.setValorConsignacion(this.cuentaCorriente.getValorConsignacion());
		aux.setIdCliente(this.getIdCliente());
		return aux;
	}
	
}
