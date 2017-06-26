package dao;

import hbt.HibernateUtil;
import negocio.LineaProductiva;

import org.hibernate.SessionFactory;

import entities.LineaProductivaEntity;

public class LineaProductivaDAO {
	
	private static LineaProductivaDAO instancia;
	private static SessionFactory sf;
	
	public static LineaProductivaDAO getInstancia(){
		if(instancia==null){
			instancia=new LineaProductivaDAO();
			sf=HibernateUtil.getSessionFactory();
		}
		return instancia;
	}
	
	public LineaProductivaEntity toEntity(LineaProductiva lp){
		LineaProductivaEntity lpe=new LineaProductivaEntity();
		lpe.setActivo(lp.isActivo());
		lpe.setEstado(lp.getEstado());		
		lpe.setLote(LoteDAO.getInstancia().toEntity(lp.getLote()));
		return null;
	}

}
