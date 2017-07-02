package dao;

import org.hibernate.SessionFactory;

import hbt.HibernateUtil;
import negocio.PrendaVenta;

public class PrendaVentaDAO {

	private static SessionFactory sf=null;
	private static PrendaVentaDAO instancia=null;
	
	public static PrendaVentaDAO getInstancia(){
		if(instancia==null){
			sf=HibernateUtil.getSessionFactory();
			instancia=new PrendaVentaDAO();
		}
		return instancia;
	}
	public void actualizarPrendaVenta(PrendaVenta pv) {
		// TODO Auto-generated method stub
		
	}

	public void grabarPrendaVenta(PrendaVenta pv) {
		// TODO Auto-generated method stub
		
	}

}
