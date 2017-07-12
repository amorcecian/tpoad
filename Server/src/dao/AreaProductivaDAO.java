package dao;import java.util.ArrayList;import java.util.List;import hbt.HibernateUtil;import negocio.AreaProductiva;import negocio.LineaProductiva;import negocio.Lote;import org.hibernate.Query;import org.hibernate.SessionFactory;import org.hibernate.classic.Session;import entities.AreaProductivaEntity;import entities.LineaProductivaEntity;import entities.LoteEntity;public class AreaProductivaDAO {	private static AreaProductivaDAO instancia;	private static SessionFactory sf;	public static AreaProductivaDAO getInstancia() {		if (instancia == null) {			instancia = new AreaProductivaDAO();			sf = HibernateUtil.getSessionFactory();		}		return instancia;	}		//AGREGAR UN AREA PRODUCTIVA A LA BASE DE DATOS	public void grabarAreaProductiva(AreaProductiva ap) {		Session s = sf.openSession();		s.beginTransaction();		AreaProductivaEntity ape = toEntity(ap);				s.save(ape);		s.flush();		s.getTransaction().commit();		s.close();	}	// ACTUALIZAR UN AREA PRODUCTIVA	public void actualizarArea(AreaProductiva areaProductiva) {		Session s = sf.openSession();			s.beginTransaction();		AreaProductivaEntity ape = toEntity(areaProductiva);		s.update(ape);		s.flush();		s.getTransaction().commit();		s.close();	}		//BORRAR LOGICAMENTE UN AREA PRODUCTIVA	public void eliminarAreaProductiva (AreaProductiva ap){		AreaProductivaEntity ape = toEntity(ap);		SessionFactory sf = HibernateUtil.getSessionFactory();		Session s = sf.openSession();		Query q = s.createQuery("UPDATE AreaProductivaEntity SET activo=? WHERE idAreaProductiva=?").setParameter(0, false).setInteger(1, ape.getIdAreaProductiva());		s.beginTransaction().begin();		q.executeUpdate();		s.beginTransaction().commit();		s.close();			}		public AreaProductiva recuperarAreaProductiva(Integer id){		Session s = sf.openSession();		Query q = s.createQuery("FROM AreaProductivaEntity WHERE idAreaProductiva=?").setInteger(0, id);		AreaProductivaEntity ape = (AreaProductivaEntity) q.uniqueResult();		AreaProductiva ap = toNegocio(ape);		s.close();		return ap;	}	//LISTAR TODOS LOS ALMACENAMIENTOS	  public List<AreaProductiva> listarAreaProductiva(){	  Session s=sf.openSession();	  List<AreaProductiva> lap=new ArrayList<AreaProductiva>();	  @SuppressWarnings("unchecked")	  List<AreaProductivaEntity> lape=s.createQuery("FROM AreaproductivaEntity WHERE activo=1").list();	  for(AreaProductivaEntity ape:lape){		  AreaProductiva ap=AreaProductivaDAO.getInstancia().toNegocio(ape);		  lap.add(ap);	  }	  	  	return lap;	  }	  	//Convierto clase entity a clase de negocio  	public AreaProductiva toNegocio(AreaProductivaEntity ape) {		AreaProductiva ap = new AreaProductiva();		ap.setActivo(ape.isActivo());		ap.setNombre(ape.getNombre());		ap.setIdAreaProductiva(ape.getIdAreaProductiva());				List<LineaProductivaEntity> llpe = ape.getLineas();		List<LineaProductiva> llp = new ArrayList<LineaProductiva>();		for (LineaProductivaEntity lpe : llpe) {			LineaProductiva lp = LineaProductivaDAO.getInstancia().toNegocio(lpe);			llp.add(lp);		}				return ap;	}	//CONVIERTO UNA CLASE DE NEGOCIO A ENTITY	public AreaProductivaEntity toEntity(AreaProductiva ap) {		AreaProductivaEntity ape = new AreaProductivaEntity();		ape.setIdAreaProductiva(ap.getIdAreaProductiva());		ape.setActivo(ap.isActivo());		ape.setNombre(ap.getNombre());						List<LineaProductivaEntity> llpe = new ArrayList<LineaProductivaEntity>();		for (LineaProductiva lp : ap.getLineas()) {			LineaProductivaEntity lpe = LineaProductivaDAO.getInstancia().toEntity(lp);			llpe.add(lpe);		}		ape.setLineas(llpe);				List<LoteEntity> lotesPendientesEntity = new ArrayList<LoteEntity>();		if (ap.getLotesPendientes()!= null){		for (Lote lote : ap.getLotesPendientes()) {			LoteEntity loteEntity = LoteDAO.getInstancia().toEntity(lote);			lotesPendientesEntity.add(loteEntity);		}		ape.setLotesPendientes(lotesPendientesEntity);		}		return ape;	}	}