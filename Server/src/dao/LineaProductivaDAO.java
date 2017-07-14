package dao;

import hbt.HibernateUtil;
import negocio.LineaProductiva;
import java.util.List;
import java.util.Vector;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
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
	
	public void grabarLinea(LineaProductiva l) {
		Session s=sf.openSession();
		s.beginTransaction();
		LineaProductivaEntity lp = toEntity(l);		
		s.save(lp);
		s.flush();
		s.clear();
		s.getTransaction().commit();
		s.close();			
	}
	
	public LineaProductivaEntity toEntity(LineaProductiva lp){
		LineaProductivaEntity lpe=new LineaProductivaEntity();
		lpe.setIdLinea(lp.getIdLinea());
		lpe.setActivo(lp.isActivo());
		lpe.setEstado(lp.getEstado());
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
		if(lpe.getLote()!=null) {
			lp.setLote(LoteDAO.getInstancia().toNegocio(lpe.getLote()));
		}		
		return lp;
	}

	public LineaProductiva obtenerLinea(Integer idLineaProd) {		
		Session s = sf.openSession();
		s.beginTransaction();
		LineaProductivaEntity lpe = (LineaProductivaEntity) s.load(LineaProductivaEntity.class, idLineaProd);
		LineaProductiva l = toNegocio(lpe);
		s.flush();
		s.getTransaction().commit();
		s.close();
		return l;
	}

	public void actualizarLinea(LineaProductiva l) {
		Session s = sf.openSession();
		s.beginTransaction();
		LineaProductivaEntity lp = toEntity(l);
		s.update(lp);
		s.flush();
		s.getTransaction().commit();
		s.close();
		
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
