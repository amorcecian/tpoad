package dao;

import java.util.ArrayList;
import java.util.List;

import hbt.HibernateUtil;
import negocio.AreaProductiva;
import negocio.LineaProductiva;
import negocio.Lote;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import entities.AreaProductivaEntity;
import entities.EmpleadoEntity;
import entities.LineaProductivaEntity;
import entities.LoteEntity;

public class AreaProductivaDAO {
	
	private static AreaProductivaDAO instancia;
	private static SessionFactory sf;
	
	public static AreaProductivaDAO getInstancia(){
		if(instancia==null){
			instancia=new AreaProductivaDAO();
			sf=HibernateUtil.getSessionFactory();
		}
		return instancia;
	}
	
	public void grabarAreaProductiva(AreaProductiva ap){
		AreaProductivaEntity ape=toEntity(ap);
		Session session=sf.openSession();
		session.beginTransaction();
		session.persist(ape);
		session.flush();
		session.beginTransaction().commit();
		session.close();
	}
	
	public AreaProductivaEntity toEntity(AreaProductiva ap){
		AreaProductivaEntity ape=new AreaProductivaEntity();
		ape.setActivo(ap.isActivo());
		ape.setNombre(ap.getNombre());
		
		List<LineaProductivaEntity> llpe=new ArrayList<LineaProductivaEntity>();
		for(LineaProductiva lp:ap.getLineas()){
			LineaProductivaEntity lpe=LineaProductivaDAO.getInstancia().toEntity(lp);
			llpe.add(lpe);
		
		}
		ape.setLineas(llpe);
		/*
		List<LoteEntity> lotesPendientesEntity=new ArrayList<LoteEntity>();
		for(Lote lote:ap.getLotesPendientes()){
			LoteEntity loteEntity=LoteDAO.getInstancia().getInstancia().toEntity(lote);
			lotesPendientesEntity.add(loteEntity);
		}
		ape.setLotesPendientes(lotesPendientesEntity);
		*/
		return ape;
		
	}

}

import java.util.ArrayList;
import java.util.List;

import hbt.HibernateUtil;
import negocio.AreaProductiva;
import negocio.LineaProductiva;
import negocio.Lote;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import dto.SucursalDTO;
import entities.AreaProductivaEntity;
import entities.EmpleadoEntity;
import entities.LineaProductivaEntity;
import entities.LoteEntity;
import entities.SucursalEntity;

public class AreaProductivaDAO {
	
	private static AreaProductivaDAO instancia;
	private static SessionFactory sf;
	
	public static AreaProductivaDAO getInstancia(){
		if(instancia==null){
			instancia=new AreaProductivaDAO();
			sf=HibernateUtil.getSessionFactory();
		}
		return instancia;
	}
	
	public void grabarAreaProductiva(AreaProductiva ap){
		AreaProductivaEntity ape=toEntity(ap);
		Session session=sf.openSession();
		session.beginTransaction();
		session.persist(ape);
		session.flush();
		session.beginTransaction().commit();
		session.close();
	}
	
	public AreaProductiva listarAreaProductiva(){
		Session s=sf.openSession();
		List<AreaProductiva> lap=new ArrayList<AreaProductiva>();
		List<AreaProductivaEntity> lape=s.createQuery("FROM AreaproductivaEntity WHERE activo=1").list();
				
		
		for(AreaProductivaEntity ape:lape){
			AreaProductiva ap=AreaProductivaDAO.getInstancia().toNegocio(ape);
			lap.add(ap);
		}
		
		/*
		Session session=sf.openSession();
		List<SucursalEntity> list=session.createQuery("from SucursalEntity where activo=1").list();
		List<SucursalDTO> listaSucursales=new ArrayList<SucursalDTO>();
		for(SucursalEntity sucu:list){
			SucursalDTO SucuDTO=new SucursalDTO(sucu.getIdSucursal(),sucu.getNombre(),sucu.getDomicilio(),sucu.getHorario());
			listaSucursales.add(SucuDTO);
		}
		session.flush();
		session.close();
		return listaSucursales;
		*/
	}
	
	private AreaProductiva toNegocio(AreaProductivaEntity ape) {
		AreaProductiva ap=new AreaProductiva();
		ap.setActivo(ape.isActivo());
		ap.setNombre(ape.getNombre());
		ap.setIdAreaProductiva(ape.getIdAreaProductiva());
		List<LineaProductivaEntity> llpe=ape.getLineas();
		List<LineaProductiva> llp=new ArrayList<LineaProductiva>();
		for(LineaProductivaEntity lpe:llpe){
			LineaProductiva lp=LineaProductivaDAO.getInstancia().toNegocio(lpe);
			llp.add(lp);
		}
		return null;
	}

	public AreaProductivaEntity toEntity(AreaProductiva ap){
		AreaProductivaEntity ape=new AreaProductivaEntity();
		ape.setActivo(ap.isActivo());
		ape.setNombre(ap.getNombre());
		
		List<LineaProductivaEntity> llpe=new ArrayList<LineaProductivaEntity>();
		for(LineaProductiva lp:ap.getLineas()){
			LineaProductivaEntity lpe=LineaProductivaDAO.getInstancia().toEntity(lp);
			llpe.add(lpe);
		
		}
		ape.setLineas(llpe);
		/*
		List<LoteEntity> lotesPendientesEntity=new ArrayList<LoteEntity>();
		for(Lote lote:ap.getLotesPendientes()){
			LoteEntity loteEntity=LoteDAO.getInstancia().getInstancia().toEntity(lote);
			lotesPendientesEntity.add(loteEntity);
		}
		ape.setLotesPendientes(lotesPendientesEntity);
		*/
		return ape;
		
	}

}
