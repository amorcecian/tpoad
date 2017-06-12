package entities;

import java.io.Serializable;

import javax.persistence.*;

@Embeddable
public class CuentaCorrienteEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_cuenta_corriente", nullable=false)
	private Integer id_cuenta_corriente;*/
	
	@Column(name="limite_credito")
	private float limiteCredito;
	
	@Column(name="condicion_pago",length = 100)
	private String condicionPago;
	
	@Column(name="saldo")
	private float saldo;
	
	@Column(name="valor_consignacion")
	private float valorConsignacion;
	
	// ******************************************************
	// Constructor
	// *****************************************************
		
	public CuentaCorrienteEntity(){};
	
	public CuentaCorrienteEntity(float limiteCredito, String condicionPago, float saldo, 
			float valorConsignacion) {
		super();
		//this.id_cuenta_corriente = id_cuenta_corriente;
		this.limiteCredito = limiteCredito;
		this.condicionPago = condicionPago;
		this.saldo = saldo;
		this.valorConsignacion = valorConsignacion;
	}	
	
	
	// ******************************************************
	// Getters y Setters
	// *****************************************************
	
	public float getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(float limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	public String getCondicionPago() {
		return condicionPago;
	}

	public void setCondicionPago(String condicionPago) {
		this.condicionPago = condicionPago;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public float getValorConsignacion() {
		return valorConsignacion;
	}

	public void setValorConsignacion(float valorConsignacion) {
		this.valorConsignacion = valorConsignacion;
	}
		

}
