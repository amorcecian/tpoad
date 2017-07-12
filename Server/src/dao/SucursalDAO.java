package dao;

import java.util.ArrayList;import java.util.List;

import org.hibernate.Query;import org.hibernate.SessionFactory;import org.hibernate.classic.Session;

import dto.*;import hbt.*;import entities.*;import negocio.*;

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
	public Integer agregarSucursal(Sucursal sucu){		SucursalEntity se = this.toEntity(sucu);		
		Session s = sf.openSession();
		s.beginTransaction().begin();
		s.save(se);
		s.flush();		s.getTransaction().commit();		Integer lastId = (Integer) s.createQuery("SELECT idSucursal FROM SucursalEntity ORDER BY idSucursal DESC ").setMaxResults(1).uniqueResult();
		s.close();		return lastId;
	}		//ACTUALIZO UNA SUCURSAL	public void actualizarSucursal(Sucursal sucu){				Session s = sf.openSession();		SucursalEntity se =this.toEntity(sucu);		s.update(se);		//s.flush();		s.beginTransaction().commit();		s.close();			}
	
	//RECUPERAR UNA SUCURSAL DE LA BASE DE DATOS
	public Sucursal recuperarSucursal(Integer idSucursal){
		Sucursal sucu=null;		Session s = sf.openSession();
		Query q = s.createQuery("FROM SucursalEntity WHERE idSucursal=?").setInteger(0, idSucursal);
		SucursalEntity se = (SucursalEntity) q.uniqueResult();
		sucu = this.toNegocio(se);
		s.close();
		return sucu;
	}
	
	
		
	public List<SucursalDTO> listarSucursales(){
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
	}
		
	public Sucursal obtenerSucursal(String nombre){		Sucursal su=null;
		Session session=sf.openSession();
		SucursalEntity sucu=(SucursalEntity) session.createQuery("from SucursalEntity where nombre=:nombreSucu")
				.setParameter("nombreSucu", nombre)
				.uniqueResult();		su=this.toNegocio(sucu);
		return su;
	}
	
	
	public SucursalEntity obtenerSucursalEntity(Integer nroSucursal){
		Session s = sf.openSession();
		s.beginTransaction();		Query q = s.createQuery("FROM SucursalEntity WHERE idSucursal=?").setInteger(0, nroSucursal);
		SucursalEntity sucursal = (SucursalEntity) q.uniqueResult();
		s.flush();		s.getTransaction().commit();		s.close();
		return sucursal;
	}
	
	public SucursalEntity toEntity(Sucursal sucu){		SucursalEntity sucuEntity = new SucursalEntity();				sucuEntity.setIdSucursal(sucu.getIdSucursal());		sucuEntity.setDomicilio(sucu.getDomicilio());
		sucuEntity.setHorario(sucu.getHorario());
		sucuEntity.setNombre(sucu.getNombre());		sucuEntity.setActivo(sucu.isActivo());		if(sucu.getEncargado()!=null){			EmpleadoEntity ee = EmpleadoDAO.getInstancia().toEntity(sucu.getEncargado());			sucuEntity.setEncargado(ee);		}else{			sucuEntity.setEncargado(null);		}
		return sucuEntity;
	}		public Sucursal toNegocio(SucursalEntity sucu){		Sucursal s=new Sucursal();		s.setIdSucursal(sucu.getIdSucursal());		s.setNombre(sucu.getNombre());		s.setDomicilio(sucu.getDomicilio());		s.setHorario(sucu.getHorario());		s.setActivo(sucu.isActivo());		if(sucu.getEncargado()!=null){			Empleado emp=EmpleadoDAO.getInstancia().toNegocio(sucu.getEncargado());			s.setEncargado(emp);		}				return s;	}
	
	public void asignarEncargado(Integer idSucursal,Integer idEmpleado){
		Session s=sf.openSession();
		Query q=s.createQuery("UPDATE SucursalEntity SET id_encargado=:idEncargado WHERE idSucursal=:idSucursal");		q.setParameter("idEncargado",idEmpleado);		q.setParameter("idSucursal",idSucursal);		q.executeUpdate();
		s.close();
	}	public void eliminarSucursal(Integer idSucursal) {		Session s=sf.openSession();		Query q=s.createQuery("UPDATE SucursalEntity SET activo=0 WHERE idSucursal=:idSucursal");		q.setParameter("idSucursal",idSucursal);		q.executeUpdate();		s.close();	}

	

}

