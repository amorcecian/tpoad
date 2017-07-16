package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import entities.ItemOCMPEntity;
import entities.LoteEntity;
import entities.MaterialEntity;
import entities.OrdenDeProduccionEntity;
import entities.PedidoEntity;
import entities.PrendaEntity;
import hbt.HibernateUtil;
import negocio.Lote;
import negocio.Material;
import negocio.OrdenDeProduccion;
import negocio.Prenda;

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


	public OrdenDeProduccionEntity toEntity(OrdenDeProduccion op) {
		OrdenDeProduccionEntity ope = new OrdenDeProduccionEntity();
		ope.setIdOrdenDeProduccion(op.getIdOrdenDeProduccion());
		ope.setActivo(op.isActivo());
		ope.setFecha(op.getFecha());
		ope.setPrecioProd(op.getPrecioProd());
		ope.setTipo(op.getTipo());
		
		if(op.getLotes()!=null) {
			List<LoteEntity> lle=new ArrayList<LoteEntity>();
			for(Lote l:op.getLotes()) {
				lle.add(LoteDAO.getInstancia().toEntity(l));
			}
			ope.setLotes(lle);			
		}

		
		List <PrendaEntity> lpe=new ArrayList<PrendaEntity>();
		for(Prenda p:op.getPrenda()) {
			lpe.add(PrendaDAO.getInstance().toEntity(p));
		}		
		ope.setPrendas(lpe);
		PedidoEntity pe = PedidoDAO.getInstance().toEntity(op.getPedido());
		ope.setPedido(pe);
		
		return ope;
	}

	public OrdenDeProduccion toNegocio(OrdenDeProduccionEntity ope) {
		OrdenDeProduccion op = new OrdenDeProduccion();
		op.setActivo(ope.isActivo());
		op.setFecha(ope.getFecha());
		op.setIdOrdenDeProduccion(ope.getIdOrdenDeProduccion());
		op.setPedido(PedidoDAO.getInstance().toNegocio(ope.getPedido()));
		op.setPrecioProd(ope.getPrecioProd());
		op.setTipo(ope.getTipo());
		
		if(ope.getLotes()!=null) {
			List<Lote> ll=new ArrayList<Lote>();
			for(LoteEntity le:ope.getLotes()) {
				ll.add(LoteDAO.getInstancia().toNegocio(le));
			}
			op.setLotes(ll);
		}
		
		List<Prenda> prendas = new Vector<Prenda>();
		for(PrendaEntity i:ope.getPrendas())
			prendas.add(PrendaDAO.getInstance().toNegocio(i));
		op.setPrenda(prendas);
		return op;

	}

	public void actualizarOP(OrdenDeProduccion op) {
		Session s = sf.openSession();
		s.beginTransaction();
		OrdenDeProduccionEntity orden = toEntity(op);
		s.merge(orden);
		//s.flush();
		s.getTransaction().commit();
		s.close();
	}

	public OrdenDeProduccion obtenerOP(Integer idOrden) {		
		Session s = sf.openSession();
		OrdenDeProduccionEntity ope =(OrdenDeProduccionEntity) s.load(OrdenDeProduccionEntity.class, idOrden);
		OrdenDeProduccion op=this.toNegocio(ope);
		s.close();
		return op;
	}
	
	public Integer guardarOP(OrdenDeProduccion op) {		
		Session s = sf.openSession();
		OrdenDeProduccionEntity ope = toEntity(op);
		s.beginTransaction();
		ope=(OrdenDeProduccionEntity) s.merge(ope);		
		Integer idOP=ope.getIdOrdenDeProduccion();		
		s.flush();
		s.getTransaction().commit();
		s.close();
		return idOP;
	}
	
	public List<OrdenDeProduccion> listarOrdenDeProduccion(){
		Session s=sf.openSession();
		Query q=s.createQuery("FROM OrdenDeProduccionEntity WHERE activo=1");
		List<OrdenDeProduccionEntity> lope=q.list();
		List<OrdenDeProduccion> lop=new ArrayList<OrdenDeProduccion>();
		for(OrdenDeProduccionEntity ope:lope) {
			lop.add(OrdenDeProdDAO.getInstancia().toNegocio(ope));
		}
		s.close();
		return lop;
	}



}
