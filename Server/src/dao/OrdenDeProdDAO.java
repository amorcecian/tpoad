package dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import entities.LoteEntity;
import entities.OrdenDeProduccionEntity;
import hbt.HibernateUtil;
import negocio.Lote;
import negocio.OrdenDeProduccion;

public class OrdenDeProdDAO {


	private static OrdenDeProdDAO instancia;
	private static SessionFactory sf;
	public static OrdenDeProdDAO getInstancia() {
		if (instancia == null) {
			instancia = new OrdenDeProdDAO();
			sf = HibernateUtil.getSessionFactory();
		}
		return instancia;
	}


	public static OrdenDeProduccionEntity toEntity(OrdenDeProduccion op) {
		OrdenDeProduccionEntity ope = new OrdenDeProduccionEntity();
		ope.setIdOrdenDeProduccion(op.getIdOrdenDeProduccion());
		ope.setActivo(op.isActivo());
		ope.setFecha(op.getFecha());
		ope.setPrecioProd(op.getPrecioProd());
		ope.setTipo(op.getTipo());
		ope.setPedido(PedidoDAO.getInstance().toEntity(op.getPedido()));
		
		
		return ope;
	}

	public OrdenDeProduccion toNegocio(OrdenDeProduccionEntity ope) {
		OrdenDeProduccion op = new OrdenDeProduccion();
		//TODO 
		return op;

	}

	public void actualizarOP(OrdenDeProduccion op) {
		Session s = sf.openSession();
		OrdenDeProduccionEntity orden = toEntity(op);
		s.update(orden);
		s.flush();
		s.beginTransaction().commit();
		s.close();
	}

	public OrdenDeProduccion obtenerOP(Integer idOrden) {
		
		Session s = sf.openSession();
		OrdenDeProduccion op = new OrdenDeProduccion();
		Query q = s.createQuery("FROM OrdenDeProduccionEntity WHERE idOrdendeProduccion=?").setInteger(0, idOrden);
		OrdenDeProduccionEntity ope = (OrdenDeProduccionEntity) q.uniqueResult();
		op = toNegocio(ope);
		s.close();
		return op;
	}
	
	public void guardarOP(OrdenDeProduccion op) {		
		Session s = sf.openSession();
		s.beginTransaction();
		OrdenDeProduccionEntity ope = toEntity(op);
		s.save(ope);
		s.flush();
		s.getTransaction().commit();
		s.close();		
	}



}
