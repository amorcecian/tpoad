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
	@Column(name="usuario")
	private String usuario;
	@Column(name="contraseña")
	private String contraseña;
	
	@Embedded
	private CuentaCorrienteEntity cuentaCorriente;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_sucursal")
	private SucursalEntity sucursal;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="id_cliente")
	private List<PedidoEntity> pedidos;
	
	
	// ******************************************************
	// Constructor
	// *****************************************************
		
	public ClienteEntity(){}

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

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	
	

	
}
