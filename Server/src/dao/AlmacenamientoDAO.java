package dao;

import java.util.List;
import java.util.Vector;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dto.AlmacenamientoDTO;
import entities.AlmacenamientoEntity;
import hbt.HibernateUtil;
import negocio.Almacenamiento;

public class AlmacenamientoDAO {
	
	private static AlmacenamientoDAO instancia;
	
	public static AlmacenamientoDAO getInstance(){
		if(instancia==null)
			instancia = new AlmacenamientoDAO();
		return instancia;
	}
	
	//AGREGAR UN ALMACENAMIENTO A LA BASE DE DATOS
	public void grabarAlmacenamiento(Almacenamiento c) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		
			AlmacenamientoEntity ce = AlmacenamientoToEntity(c);
			s.save(ce);
			s.close();
		}

		
	
	// ACTUALIZAR UN ALMACENAMIENTO
	public void actualizarAlmacenamiento(Almacenamiento c) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
				
		AlmacenamientoEntity ce = AlmacenamientoToEntity(c);
			s.update(ce);
			s.flush();
			s.beginTransaction().commit();			
			s.close();
		}
	
	//BORRAR LOGICAMENTE UN ALMACENAMIENTO DE LA BASE DE DATOS
	public void eliminarAlmacenamiento(Almacenamiento alma){
		AlmacenamientoEntity ce = AlmacenamientoToEntity(alma);
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
		Almacenamiento c = new Almacenamiento();
		Query q = s.createQuery("FROM AlmacenamientoEntity WHERE idAlmacenamiento=?").setInteger(0, idAlmacenamiento);
		AlmacenamientoEntity ce = (AlmacenamientoEntity) q.uniqueResult();
		c = new Almacenamiento(ce);
		s.close();
		return c;
	}
	
	
	//CONVIERTO UN ALMACENAMIENTO EN UN ALMACENAMIENTO ENTITY
	public AlmacenamientoEntity AlmacenamientoToEntity(Almacenamiento c){
		AlmacenamientoEntity ce = new AlmacenamientoEntity();
		ce.setBloque(c.getBloque());
		ce.setCalle(c.getCalle());
		ce.setEstante(c.getEstante());
		ce.setLibre(c.isLibre());
		//Lote l = c.getLote();
		//ce.setLote(c.getLote().LoteToEntity());
		ce.setPosicion(c.getPosicion());
		return ce;
	}
	
	
	//LISTAR TODOS LOS ALMACENAMIENTOS
	@SuppressWarnings({ "finally", "unchecked" })
	public List<AlmacenamientoDTO> listarAlmacenamiento() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		List<AlmacenamientoDTO> listaAlmacenamientos=new Vector<AlmacenamientoDTO>();
		List<AlmacenamientoEntity> list=s.createQuery("from AlmacenamientoEntity").list();
		for(AlmacenamientoEntity alma:list){
				AlmacenamientoDTO aux =new AlmacenamientoDTO();
				aux = alma.toDTO();
				listaAlmacenamientos.add(aux);
			}	
			s.close();
			return listaAlmacenamientos;
		}

}
