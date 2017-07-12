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
		List <PrendaEntity> lpe=new ArrayList<PrendaEntity>();
		for(Prenda p:op.getPrenda()) {
			lpe.add(PrendaDAO.getInstance().toEntity(p));
		}		
		ope.setPrendas(lpe);
		if(op.getPedido() != null){
			PedidoEntity pe = PedidoDAO.getInstance().toEntity(op.getPedido());
			//ope.setPedido(PedidoDAO.getInstance().toEntity(op.getPedido()));
			ope.setPedido(pe);
		}
		return ope;
	}

	public OrdenDeProduccion toNegocio(OrdenDeProduccionEntity ope) {
		OrdenDeProduccion op = new OrdenDeProduccion();
		op.setActivo(ope.isActivo());
		op.setFecha(ope.getFecha());
		op.setIdOrdenDeProduccion(ope.getIdOrdenDeProduccion());
		op.setPedido(PedidoDAO.getInstance().toNegocio(ope.getPedido()));
		op.setPrecioProd(ope.getPrecioProd());
		List<Prenda> prendas = new Vector<Prenda>();
		for(PrendaEntity i:ope.getPrendas())
			prendas.add(PrendaDAO.getInstance().toNegocio(i));
		op.setPrenda(prendas);
		return op;

	}

	public void actualizarOP(OrdenDeProduccion op) {
		Session s = sf.openSession();
		OrdenDeProduccionEntity orden = toEntity(op);
		s.update(orden);
		//s.flush();
		//s.beginTransaction().commit();
		s.close();
	}

	public OrdenDeProduccion obtenerOP(Integer idOrden) {
		
		Session s = sf.openSession();
		OrdenDeProduccion op = new OrdenDeProduccion();
		Query q = s.createQuery("FROM OrdenDeProduccionEntity WHERE idOrdenDeProduccion=?").setInteger(0, idOrden);
		OrdenDeProduccionEntity ope = (OrdenDeProduccionEntity) q.uniqueResult();
		op = toNegocio(ope);
		s.close();
		return op;
	}
	
	public void guardarOP(OrdenDeProduccion op) {		
		Session s = sf.openSession();
		OrdenDeProduccionEntity ope = toEntity(op);
		s.beginTransaction();
		s.save(ope);
		s.flush();
		s.getTransaction().commit();
		s.close();		
	}



}
