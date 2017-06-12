package negocio;

import entities.CuentaCorrienteEntity;

public class CuentaCorriente {
	private float limiteCredito;
	private String condicionPago;
	private float saldo;
	private float valorConsignacion;
	
	public CuentaCorriente(){}
	
	
	

	
	public CuentaCorriente(float limiteCredito, String condicionPago,
			float saldo, float valorConsignacion) {
		super();
		this.limiteCredito = limiteCredito;
		this.condicionPago = condicionPago;
		this.saldo = saldo;
		this.valorConsignacion = valorConsignacion;
	}

	public CuentaCorriente(CuentaCorrienteEntity cce){
		this.limiteCredito=cce.getLimiteCredito();
		this.condicionPago=cce.getCondicionPago();
		this.saldo=cce.getSaldo();
		this.valorConsignacion=cce.getValorConsignacion();
	}



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
