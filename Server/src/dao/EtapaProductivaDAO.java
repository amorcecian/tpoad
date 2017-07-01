package dao;

import org.hibernate.SessionFactory;

import entities.EtapaProductivaEntity;
import hbt.HibernateUtil;
import negocio.EtapaProductiva;

public class EtapaProductivaDAO {

	private static EtapaProductivaDAO instancia;
	private static SessionFactory sf;
	
	public static EtapaProductivaDAO getInstance(){
		if(instancia==null){
			instancia = new EtapaProductivaDAO();
			sf=HibernateUtil.getSessionFactory();
		}				
		return instancia;
	}

	public EtapaProductiva toNegocio(EtapaProductivaEntity e) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
