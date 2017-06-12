package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import dto.*;
import hbt.*;
import entities.*;
import negocio.*;

public class SucursalDAO {
	
	private static SessionFactory sf=null;
	private static SucursalDAO instancia=null;
	
	public static SucursalDAO getInstancia(){
		if(instancia==null){
			sf=HibernateUtil.getSessionFactory();
			instancia=new SucursalDAO();
		}
		return instancia;
	}
	
	//AGREGAR UNA SUCURSAL A LA BASE DE DATOS
	public void agregarSucursal(Sucursal sucu){
		SucursalEntity se = this.sucursalToEntity(sucu);
		Session s = sf.openSession();
		s.beginTransaction().begin();
		//s.persist(se);
		s.save(se);
		s.beginTransaction().commit();
		s.close();
	}
	
	//RECUPERAR UNA SUCURSAL DE LA BASE DE DATOS
	public Sucursal recuperarSucursal(Integer idSucursal){
		Session s = sf.openSession();
		Query q = s.createQuery("FROM SucursalEntity WHERE idSucursal=?").setInteger(0, idSucursal);
		SucursalEntity se = (SucursalEntity) q.uniqueResult();
		Sucursal sucu = new Sucursal(se);
		s.close();
		return sucu;
	}
	
	
		
	public List<SucursalDTO> listarSucursales(){
		Session session=sf.openSession();
		List<SucursalEntity> list=session.createQuery("from SucursalEntity").list();
		List<SucursalDTO> listaSucursales=new ArrayList<SucursalDTO>();
		for(SucursalEntity sucu:list){
			SucursalDTO SucuDTO=new SucursalDTO(sucu.getIdSucursal(),sucu.getNombre(),sucu.getDomicilio(),sucu.getHorario());
			listaSucursales.add(SucuDTO);
		}
		session.flush();
		session.close();
		return listaSucursales;
	}
	
	public Sucursal obtenerSucursal(String nombre){
		Session session=sf.openSession();
		SucursalEntity sucu=(SucursalEntity) session.createQuery("from SucursalEntity where nombre=:nombreSucu")
				.setParameter("nombreSucu", nombre)
				.uniqueResult();
		return new Sucursal(sucu);
	}
	
	public Sucursal obtenerSucursal(Integer idSucursal){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		Query q = s.createQuery("FROM SucursalEntity WHERE idSucursal=?").setInteger(0, idSucursal);
		s.beginTransaction().begin();
		SucursalEntity sucursal = (SucursalEntity) q.uniqueResult();
		s.beginTransaction().commit();
		Sucursal sucu = new Sucursal(sucursal);
		s.close();
		return sucu;
	}
	
	public SucursalEntity obtenerSucursalEntity(Integer nroSucursal){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		Query q = s.createQuery("FROM SucursalEntity WHERE idSucursal=?").setInteger(0, nroSucursal);
		SucursalEntity sucursal = (SucursalEntity) q.uniqueResult();
		s.close();
		return sucursal;
	}
	
	public SucursalEntity sucursalToEntity(Sucursal sucu){
		//EmpleadoEntity ee = EmpleadoDAO.getInstancia().empleadoToEntity(sucu.getEncargado());
		SucursalEntity sucuEntity = new SucursalEntity();
		sucuEntity.setDomicilio(sucu.getDomicilio());
		sucuEntity.setHorario(sucu.getHorario());
		sucuEntity.setNombre(sucu.getNombre());
		sucuEntity.setIdSucursal(sucu.getIdSucursal());
		//if(ee!=null)
			//sucuEntity.setEncargado(ee);
		return sucuEntity;
	}
	
	public void asignarEncargado(EmpleadoEntity empleado){
		Session session=sf.openSession();
		Query query=session.createQuery("UPDATE SucursalEntity SET EmpleadoEntity=? ");
		
	}

	

}

