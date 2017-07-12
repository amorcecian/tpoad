package dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import entities.AreaProductivaEntity;
import entities.EtapaProductivaEntity;
import hbt.HibernateUtil;
import negocio.AreaProductiva;
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

	public void grabarEtapaProductiva(EtapaProductiva ep) {
		Session s = sf.openSession();
		s.beginTransaction();
		EtapaProductivaEntity epe = toEntity(ep);
		s.save(epe);
		s.flush();
		s.getTransaction().commit();
		s.close();
	}
	
	public void actualizarEtapaProductiva(EtapaProductiva ep){
		Session s = sf.openSession();
		EtapaProductivaEntity epe = toEntity(ep);
		s.beginTransaction().begin();
		s.update(epe);
		s.flush();
		s.getTransaction().commit();
		s.close();
	}
	
	public EtapaProductiva recuperarEtapaProductiva(Integer id){
		Session s = sf.openSession();
		Query q = s.createQuery("FROM EtapaProductivaEntity WHERE id_etapa_productiva=?").setInteger(0, id);
		EtapaProductivaEntity epe = (EtapaProductivaEntity) q.uniqueResult();
		EtapaProductiva ep = toNegocio(epe);
		s.close();
		return ep;
	}
	
	public EtapaProductivaEntity toEntity(EtapaProductiva ep){
		EtapaProductivaEntity epe = new EtapaProductivaEntity();
		epe.setIdEtapaProductiva(ep.getIdEtapaProductiva());
		epe.setActivo(ep.isActivo());
		epe.setTiempoProduccion(ep.getTiempoProduccion());
		epe.setOrden(ep.getOrden());
		AreaProductivaEntity ape = AreaProductivaDAO.getInstancia().toEntity(ep.getAreaProductiva());
		epe.setAreaProductiva(ape);
		return epe;
	}
	
	public EtapaProductiva toNegocio(EtapaProductivaEntity epe){
		EtapaProductiva ep = new EtapaProductiva();
		ep.setActivo(epe.isActivo());
		AreaProductiva ape = AreaProductivaDAO.getInstancia().toNegocio(epe.getAreaProductiva());
		ep.setAreaProductiva(ape);
		ep.setIdEtapaProductiva(epe.getIdEtapaProductiva());
		ep.setOrden(epe.getOrden());
		ep.setTiempoProduccion(epe.getTiempoProduccion());
		return ep;
	}
	

}
