package dao;

import org.hibernate.SessionFactory;

import hbt.HibernateUtil;
import negocio.Remito;

public class RemitoDAO {
	private static RemitoDAO instancia;
	private static SessionFactory sf;
	
	public static RemitoDAO getInstance(){
		if(instancia==null){
			instancia = new RemitoDAO();
			sf=HibernateUtil.getSessionFactory();
		}				
		return instancia;
	}

	public Integer grabarRemito(Remito r) {
		// TODO Auto-generated method stub
		return 0;
	}
}
