package dao;

import hbt.HibernateUtil;
import negocio.LineaProductiva;
import negocio.Material;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import entities.LineaProductivaEntity;
import entities.LoteEntity;
import entities.MaterialEntity;

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
		//lpe.setLote(LoteDAO.getInstancia().toEntity(lp.getLote()));
		return lpe;
	}

	public LineaProductiva toNegocio(LineaProductivaEntity lpe) {
		LineaProductiva lp=new LineaProductiva();
		lp.setActivo(lpe.isActivo());
		lp.setEstado(lpe.getEstado());
		lp.setIdLinea(lpe.getIdLinea());
		lp.setLote(LoteDAO.getInstancia().toNegocio(lpe.getLote()));
		return lp;
	}

	public LineaProductiva obtenerLinea(Integer idLineaProd) {
		
		Session s = sf.openSession();
		LineaProductiva l = new LineaProductiva();
		Query q = s.createQuery("FROM LineaProductivaEntity WHERE idlinea=?").setInteger(0, idLineaProd);
		LineaProductivaEntity lp = (LineaProductivaEntity) q.uniqueResult();
		l = toNegocio(lp);
		s.close();
		return l;
	}

	public void actualizarLinea(LineaProductiva l) {
		Session s = sf.openSession();
		LineaProductivaEntity lp = toEntity(l);
		s.update(lp);
		s.flush();
		s.beginTransaction().commit();
		s.close();
		
	}
	
	public void grabarLinea(LineaProductiva l) {
		LineaProductivaEntity lp = toEntity(l);
		Session session=sf.openSession();
		session.beginTransaction();
		session.persist(lp);
		session.flush();
		session.beginTransaction().commit();
		session.close();	
		
	}

}
