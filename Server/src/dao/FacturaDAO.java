package dao;

import org.hibernate.SessionFactory;

import entities.FacturaEntity;
import hbt.HibernateUtil;
import negocio.Factura;

public class FacturaDAO {

	private static FacturaDAO instancia;
	private static SessionFactory sf;
	
	public static FacturaDAO getInstance(){
		if(instancia==null){
			instancia = new FacturaDAO();
			sf=HibernateUtil.getSessionFactory();
		}				
		return instancia;
	}

	public Integer grabarFactura(Factura f) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public FacturaEntity FacturaToEntity(Factura f){
		return new FacturaEntity(f);
	}
	
	
	
}
