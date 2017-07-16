package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.AlmacenamientoEntity;
import hbt.HibernateUtil;
import negocio.Almacenamiento;
import negocio.Lote;

public class AlmacenamientoDAO {
	
	private static AlmacenamientoDAO instancia;
	private static SessionFactory sf=null;
	
	public static AlmacenamientoDAO getInstance(){
		if(instancia==null) {
			instancia = new AlmacenamientoDAO();
			sf=HibernateUtil.getSessionFactory();
		}
			
		return instancia;
	}
	
	//AGREGAR UN ALMACENAMIENTO A LA BASE DE DATOS
	public void grabarAlmacenamiento(Almacenamiento c) {
		Session s = sf.openSession();
		s.beginTransaction();		
		AlmacenamientoEntity ce = toEntity(c);
		s.save(ce);
		s.flush();
		s.getTransaction().commit();
		s.close();
		}

		
	
	// ACTUALIZAR UN ALMACENAMIENTO
	public void actualizarAlmacenamiento(Almacenamiento c) {
		Session s = sf.openSession();				
		AlmacenamientoEntity ce = toEntity(c);
		s.beginTransaction();
		s.update(ce);
		//s.flush();
		s.getTransaction().commit();			
		s.close();
		}
	
	//BORRAR LOGICAMENTE UN ALMACENAMIENTO DE LA BASE DE DATOS
	public void eliminarAlmacenamiento(Almacenamiento alma){
		AlmacenamientoEntity ce = toEntity(alma);
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
			Query q = s.createQuery("UPDATE AlmacenamientoEntity SET activo=? WHERE idAlmacenamiento=?").setParameter(0,false);
			q.setInteger(1, ce.getIdAlmacenamiento());
			//Query q1 = s.createQuery("delete from ClienteEntity WHERE idCliente=?").setInteger(0, ce.getIdCliente());
			s.beginTransaction().begin();
			q.executeUpdate();
			//q1.executeUpdate();
			s.beginTransaction().commit();
		
		s.close();
	}
	
	//RECUPERAR UN ALMACENAMIENTO DE LA BASE DE DATOS
	public Almacenamiento recuperarAlmacenamiento(Integer idAlmacenamiento) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		Query q = s.createQuery("FROM AlmacenamientoEntity WHERE idAlmacenamiento=?").setInteger(0, idAlmacenamiento);
		AlmacenamientoEntity ce = (AlmacenamientoEntity) q.uniqueResult();
		Almacenamiento c = this.toNegocio(ce);
		s.close();
		return c;
	}
	
	
	//CONVIERTO UN ALMACENAMIENTO EN UN ALMACENAMIENTO ENTITY
	public AlmacenamientoEntity toEntity(Almacenamiento c){
		AlmacenamientoEntity ce = new AlmacenamientoEntity();
		ce.setIdAlmacenamiento(c.getId());
		ce.setBloque(c.getBloque());
		ce.setCalle(c.getCalle());
		ce.setEstante(c.getEstante());
		ce.setLibre(c.isLibre());
		ce.setActivo(c.isActivo());
		ce.setPosicion(c.getPosicion());
		return ce;
	}
	
	public Almacenamiento toNegocio(AlmacenamientoEntity ae) {
		Almacenamiento a=new Almacenamiento();
		a.setId(ae.getIdAlmacenamiento());
		a.setActivo(ae.isActivo());
		a.setBloque(ae.getBloque());
		a.setCalle(ae.getCalle());
		a.setEstante(ae.getEstante());
		a.setLibre(ae.isLibre());
		a.setPosicion(ae.getPosicion());
		return a;
	}
	
	
	//LISTAR TODOS LOS ALMACENAMIENTOS
	public List<Almacenamiento> listarAlmacenamiento() {
		Session s = sf.openSession();
		List<Almacenamiento> la=new ArrayList<Almacenamiento>();
		List<AlmacenamientoEntity> lae=s.createQuery("FROM AlmacenamientoEntity").list();
		for(AlmacenamientoEntity ae:lae){
				la.add(this.toNegocio(ae));
			}	
			s.close();
			return la;
		}
	

}
