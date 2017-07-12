package dao;import java.util.List;import java.util.Vector;import hbt.HibernateUtil;import negocio.LineaProductiva;import negocio.Lote;import org.hibernate.Query;import org.hibernate.SessionFactory;import org.hibernate.classic.Session;import entities.AlmacenamientoEntity;import entities.LineaProductivaEntity;import entities.LoteEntity;public class LoteDAO {	private static LoteDAO instancia;	private static SessionFactory sf;	public static LoteDAO getInstancia() {		if (instancia == null) {			instancia = new LoteDAO();			sf = HibernateUtil.getSessionFactory();		}		return instancia;	}	public void actualizarLote(Lote lote) {		Session s = sf.openSession();		LoteEntity le = toEntity(lote);		s.update(le);		s.flush();		s.beginTransaction().commit();		s.close();	}	public void guardarLote(Lote nuevo) {		Session s = sf.openSession();		s.beginTransaction();		LoteEntity le = toEntity(nuevo);				s.save(le);		s.flush();		s.getTransaction().commit();		s.close();	}		public Lote obtenerLote(Integer idLote) {				Session s = sf.openSession();		s.beginTransaction();		LoteEntity lote = (LoteEntity) s.load(LoteEntity.class, idLote);		Lote l = toNegocio(lote);		s.flush();		s.getTransaction().commit();		s.close();		return l;	}		@SuppressWarnings("unchecked")	public List<Lote> obtenerLotesPorIdOP(Integer idOP){		List<Lote> lotes = new Vector<Lote>();		List<LoteEntity> lotesEntitys = new Vector<LoteEntity>();		Session s = sf.openSession();		s.beginTransaction();		Query q = s.createQuery("FROM LoteEntity WHERE ordenDeProduccion=?").setInteger(0, idOP);		lotesEntitys = q.list();		s.flush();		s.close();		for(LoteEntity i:lotesEntitys)			lotes.add(toNegocio(i));		return lotes;	}		public LoteEntity toEntity(Lote lote) {		LoteEntity le = new LoteEntity();		le.setIdLote(lote.getIdLote());		le.setActivo(lote.isActivo());		le.setCantidadProducida(lote.getCantidadProducida());		le.setCantidadRestante(lote.getCantidadRestante());		le.setCostoProd(lote.getCostoProd());		le.setEstado(lote.getEstado());		//le.setPrenda(PrendaDAO.getInstance().toEntity(lote.getPrenda()));		if(lote.getUbicacion()!=null){		AlmacenamientoEntity ae=AlmacenamientoDAO.getInstance().toEntity(lote.getUbicacion());		le.setUbicacion(ae);		}		// le.setAreaProductiva(AreaProductivaDAO.getInstancia().toEntity(lote.get));		//le.setOrdenDeProduccion(Orde);		return le;	}		public Lote toNegocio(LoteEntity lote) {		Lote l = new Lote();		l.setActivo(lote.isActivo());		l.setCantidadProducida(lote.getCantidadProducida());		l.setCantidadRestante(lote.getCantidadRestante());		l.setCostoProd(lote.getCostoProd());		l.setEstado(lote.getEstado());		l.setIdLote(lote.getIdLote());		//l.setPrenda(PrendaDAO.getInstance().toNegocio(lote.getPrenda()));		l.setUbicacion(AlmacenamientoDAO.getInstance().toNegocio(lote.getUbicacion()));		return l;	}}
