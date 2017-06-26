package dao;

import hbt.HibernateUtil;
import negocio.Lote;

import org.hibernate.SessionFactory;

import entities.LoteEntity;

public class LoteDAO {
	
	private static LoteDAO instancia;
	private static SessionFactory sf;
	
	public static LoteDAO getInstancia(){
		if(instancia==null){
			instancia=new LoteDAO();
			sf=HibernateUtil.getSessionFactory();
		}
		return instancia;
	}
	
	public LoteEntity toEntity(Lote lote){
		LoteEntity le=new LoteEntity();
		le.setActivo(lote.isActivo());
		le.setCantidadProducida(lote.getCantidadProducida());
		le.setCantidadRestante(lote.getCantidadRestante());
		le.setCostoProd(lote.getCostoProd());
		le.setEstado(lote.getEstado());
		le.setPrenda(PrendaDAO.getInstance().toEntity(lote.getPrenda()));
		//le.setAreaProductiva(AreaProductivaDAO.getInstancia().toEntity(lote.get));
		//le.setOrdenDeProduccion(Orde);
		return le;
		
	}
	

}
