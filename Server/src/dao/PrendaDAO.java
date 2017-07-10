package dao;

import hbt.HibernateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dto.SucursalDTO;
import negocio.Cliente;
import negocio.Empleado;
import negocio.EtapaProductiva;
import negocio.MaterialPorPrenda;
import negocio.Prenda;
import entities.ClienteEntity;
import entities.EmpleadoEntity;
import entities.EtapaProductivaEntity;
import entities.MaterialPorPrendaEntity;
import entities.PrendaEntity;
import entities.SucursalEntity;
import exceptions.ExceptionCliente;

public class PrendaDAO {
	
	private static PrendaDAO instancia;
	private static SessionFactory sf;
	
	public static PrendaDAO getInstance(){
		if(instancia==null){
			instancia = new PrendaDAO();
			sf=HibernateUtil.getSessionFactory();
		}				
		return instancia;
	}
	
	// AGREGAR UNA PRENDA
	public Integer agregarPrenda(Prenda p){		
		Session s=sf.openSession();			
		s.beginTransaction();
		PrendaEntity pe=toEntity(p);
		Integer idPrenda=(Integer)s.save(pe);
		s.flush();			
		s.getTransaction().commit();
		s.close();
		return idPrenda;
	}
		
	
	
	
	//LISTAR TODAS LAS PRENDAS
	public List<Prenda> listarPrendas(){
		Session s=sf.openSession();
		List<Prenda> lstPrendas=new ArrayList<Prenda>();
		List<PrendaEntity> lpe=s.createQuery("FROM PrendaEntity WHERE activo=1").list();
		for(PrendaEntity pe:lpe) {
			Prenda p=PrendaDAO.getInstance().toNegocio(pe);
			lstPrendas.add(p);
		}
		s.flush();
		s.close();
		return lstPrendas;
	}
	
	
	
	// PRENDA TO PRENDAENTITY
	
	public PrendaEntity toEntity(Prenda p){
		PrendaEntity pe = new PrendaEntity();
		pe.setIdPrenda(p.getIdPrenda());
		pe.setActivo(p.isActivo());
		pe.setCantProducir(p.getCantProducir());
		pe.setCantMinParaProducir(p.getCantMinParaProducir());
		pe.setColor(p.getColor());
		pe.setDescripcion(p.getDescripcion());
		pe.setTalle(p.getTalle());
		pe.setTemporada(p.getTemporada());
		pe.setTiempoProd(p.getTiempoProd());
		pe.setPrecioVenta(p.getPrecioVenta());
		pe.setStock(StockDAO.getInstance().toEntity(p.getStock()));		
		List<MaterialPorPrendaEntity> lmppe = new ArrayList<MaterialPorPrendaEntity>();
		if(p.getMateriales()!=null){
		List<MaterialPorPrenda> lmpp=p.getMateriales();		
			for (MaterialPorPrenda mpp:lmpp){
				MaterialPorPrendaEntity mppe=MaterialPorPrendaDAO.getInstance().toEntity(mpp);
				lmppe.add(mppe);
			}
		}
		pe.setMateriales(lmppe);
		List<EtapaProductivaEntity> lepe=new ArrayList<EtapaProductivaEntity>();
		for(EtapaProductiva ep:p.getEtapaProd()) {
			lepe.add(EtapaProductivaDAO.getInstance().toEntity(ep));
		}
		pe.setEtapaProductiva(lepe);
		return pe;
	}
	
	public Prenda toNegocio(PrendaEntity p){
		Prenda prenda = new Prenda();
		/*
		List<EtapaProductiva> etapas = new Vector<EtapaProductiva>();
		List<MaterialPorPrenda> materiales = new Vector<MaterialPorPrenda>();
		
		if(p.getMaterialesPorPrenda()!=null){
			for (MaterialPorPrendaEntity mpp:p.getMaterialesPorPrenda()){
				materiales.add(MaterialPorPrendaDAO.getInstance().toNegocio(mpp));
			}
		}	
		prenda.setMateriales(materiales);
		
		
		for (EtapaProductivaEntity e : p.getEtapaProd()){
			etapas.add(EtapaProductivaDAO.getInstance().toNegocio(e));
		}
		prenda.setEtapaProd(etapas);
		*/
		prenda.setIdPrenda(p.getIdPrenda());
		prenda.setCantProducir(p.getCantProducir());
		prenda.setCantMinParaProducir(p.getCantMinParaProducir());
		prenda.setColor(p.getColor());
		prenda.setDescripcion(p.getDescripcion());
		prenda.setPrecioVenta(p.getPrecioVenta());
		prenda.setTalle(p.getTalle());
		prenda.setTemporada(p.getTemporada());
		prenda.setTiempoProd(p.getTiempoProd());
		prenda.setActivo(true);		
		if(p.getStock()!=null) {
		prenda.setStock(StockDAO.getInstance().toNegocio(p.getStock()));
		};

		
		return prenda;
	}

	public Prenda obtenerPrenda(Integer idPrenda) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		Prenda c = new Prenda();
		Query q = s.createQuery("FROM PrendaEntity WHERE idPrenda=?").setInteger(0, idPrenda);
		PrendaEntity ce = (PrendaEntity) q.uniqueResult();
		c = this.toNegocio(ce);
		s.close();
		return c;
	}

	@SuppressWarnings("unchecked")
	public List<Prenda> obtenerPrendasPorDescripcion(String descripcion) {
		Session s = sf.openSession();
		Query q = s.createQuery("FROM PrendaEntity WHERE descripcion LIKE ?").setString(0, "%"+descripcion+"%");
		List<PrendaEntity> aux = q.list();
		s.close();
		List<Prenda> prendas = new Vector<Prenda>();
		for(PrendaEntity i:aux)
			prendas.add(toNegocio(i));
		return prendas;
	}

}
