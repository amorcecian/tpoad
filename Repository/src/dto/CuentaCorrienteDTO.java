package dto;

import java.io.Serializable;

public class CuentaCorrienteDTO implements Serializable {
	

	private float limiteCredito;
	private String condicionPago;
	private float saldo;
	private float valorConsignacion;
	
	public CuentaCorrienteDTO(){}

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
