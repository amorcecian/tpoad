package dao;

import hbt.HibernateUtil;

import java.util.List;
import java.util.Vector;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import negocio.Cliente;
import negocio.MaterialPorPrenda;
import negocio.Prenda;
import entities.ClienteEntity;
import entities.MaterialPorPrendaEntity;
import entities.PrendaEntity;
import exceptions.ExceptionCliente;

public class PrendaDAO {
	
	private static PrendaDAO instancia;
	
	public static PrendaDAO getInstance(){
		if(instancia==null)
			instancia = new PrendaDAO();
		return instancia;
	}
	
	// AGREGAR UNA PRENDA
	public void agregarPrenda(Prenda p){		
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.openSession();			
		try {		
			PrendaEntity pe=prendaToEntity(p);
			s.save(pe);
			List<MaterialPorPrenda> lmpp=p.getMateriales();
			for(MaterialPorPrenda mpp:lmpp){				
				MaterialPorPrendaDAO.getInstance().agregarMateriaporPrenda(mpp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			s.close();
		}
	}
	
	
	// PRENDA TO PRENDAENTITY
	
	public PrendaEntity prendaToEntity(Prenda p){
		PrendaEntity prenda = new PrendaEntity();
		List<MaterialPorPrendaEntity> materiales = new Vector<MaterialPorPrendaEntity>();
		for (MaterialPorPrenda i:p.getMateriales()){
			materiales.add(MaterialPorPrendaDAO.getInstance().materialPPToEntity(i));
		}
		prenda.setCantProducir(p.getCantProducir());
		prenda.setColor(p.getColor());
		prenda.setDescripcion(p.getDescripcion());
		prenda.setMaterialesPorPrenda(materiales);
		prenda.setPrecioVenta(p.getPrecioVenta());
		prenda.setTalle(p.getTalle());
		prenda.setTemporada(p.getTemporada());
		prenda.setTiempoProd(p.getTiempoProd());
		
		return prenda;
	}

	public Prenda obtenerPrenda(Integer idPrenda) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		Prenda c = new Prenda();
		Query q = s.createQuery("FROM PrendaEntity WHERE idPrenda=?").setInteger(0, idPrenda);
		PrendaEntity ce = (PrendaEntity) q.uniqueResult();
		c = new Prenda(ce);
		s.close();
		return c;
	}

	public List<Prenda> obtenerPrendasPorDescripcion(String descripcion) {
		// devolver todas las prendas con una descripcion particular
		return null;
	}

}
