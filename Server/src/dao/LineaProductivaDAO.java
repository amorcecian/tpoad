package dao;

import hbt.HibernateUtil;
import negocio.LineaProductiva;
import negocio.Material;

import java.util.List;
import java.util.Vector;

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
		if(lp.getArea()!=null){
			lpe.setAreaProductiva(AreaProductivaDAO.getInstancia().toEntity(lp.getArea()));
		}
		if(lp.getLote()!=null){
			lpe.setLote(LoteDAO.getInstancia().toEntity(lp.getLote()));
		}
		return lpe;
	}

	public LineaProductiva toNegocio(LineaProductivaEntity lpe) {
		LineaProductiva lp=new LineaProductiva();
		lp.setActivo(lpe.isActivo());
		lp.setEstado(lpe.getEstado());
		lp.setIdLinea(lpe.getIdLinea());
		lp.setArea(AreaProductivaDAO.getInstancia().toNegocio(lpe.getAreaProductiva()));
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
		Session session=sf.openSession();
		session.beginTransaction();
		LineaProductivaEntity lp = toEntity(l);		
		session.save(lp);
		session.flush();
		session.getTransaction().commit();
		session.close();			
	}

	public List<LineaProductiva> getLineas() {
		Session s = sf.openSession();
		Query q = s.createQuery("FROM LineaProductivaEntity");
		List<LineaProductivaEntity> aux = q.list();
		List <LineaProductiva> lineas = new Vector<LineaProductiva>();
		s.close();
		for(LineaProductivaEntity i:aux)
			lineas.add(toNegocio(i));
		return lineas;
	}

}
