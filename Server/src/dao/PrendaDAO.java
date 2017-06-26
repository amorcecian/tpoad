package dao;

import hbt.HibernateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import negocio.MaterialPorPrenda;
import negocio.Prenda;
import entities.ClienteEntity;
import entities.EmpleadoEntity;
import entities.MaterialPorPrendaEntity;
import entities.PrendaEntity;
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
	public void agregarPrenda(Prenda p){		
		Session s=sf.openSession();			
		try{
			PrendaEntity pe=toEntity(p);
			s.beginTransaction();
			s.save(pe);
			s.flush();			
			s.beginTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{			
			s.close();
		}
		
	}
	
	// AGREGAR UNA PRENDA
	public void agregarPrenda1(Prenda p){		
		Session s=sf.openSession();			
		PrendaEntity pe=new PrendaEntity();
		try{
			pe.setIdPrenda(p.getIdPrenda());
			pe.setDescripcion(p.getDescripcion());
			pe.setColor(p.getColor());
			pe.setTalle(p.getTalle());
			pe.setPrecioVenta(p.getPrecioVenta());
			pe.setTemporada(p.getTemporada());
			pe.setTiempoProd(p.getTiempoProd());
			pe.setCantProducir(p.getCantProducir());
			pe.setActivo(true);	
			
			s.beginTransaction();
			s.save(pe);
			s.flush();
			s.beginTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			s.close();
		}

		
	}
	
	
	// PRENDA TO PRENDAENTITY
	
	public PrendaEntity toEntity(Prenda p){
		PrendaEntity prenda = new PrendaEntity();
		List<MaterialPorPrendaEntity> materiales = new ArrayList<MaterialPorPrendaEntity>();
		List<MaterialPorPrenda> lmpp=p.getMateriales();
		
		for (MaterialPorPrenda i:lmpp){
			materiales.add(MaterialPorPrendaDAO.getInstance().toEntity(i));

		}
		prenda.setIdPrenda(p.getIdPrenda());
		prenda.setCantProducir(p.getCantProducir());
		prenda.setColor(p.getColor());
		prenda.setDescripcion(p.getDescripcion());
		prenda.setMaterialesPorPrenda(materiales);
		prenda.setPrecioVenta(p.getPrecioVenta());
		prenda.setTalle(p.getTalle());
		prenda.setTemporada(p.getTemporada());
		prenda.setTiempoProd(p.getTiempoProd());
		prenda.setActivo(true);		
		
		return prenda;
	}

	public Prenda obtenerPrenda(Integer idPrenda) {
		//levanto una prenda de la base y la devuelvo
		return null;
	}

	public List<Prenda> obtenerPrendasPorDescripcion(String descripcion) {
		// devolver todas las prendas con una descripcion particular
		return null;
	}

}
