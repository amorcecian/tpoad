package dao;

import java.util.List;

import negocio.Cliente;
import negocio.Empleado;
import negocio.Sucursal;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import entities.*;
import exceptions.ExceptionCliente;
import hbt.*;

public class EmpleadoDAO {
	private static SessionFactory sf=null;
	private static EmpleadoDAO instancia=null;
	
	public static EmpleadoDAO getInstancia(){
		if(instancia==null){
			sf=HibernateUtil.getSessionFactory();
			instancia=new EmpleadoDAO();
		}
		return instancia;
	}
	
	//AGREGO UN EMPLEADO A LA BASE DE DATOS
	public void grabarEmpleado(Empleado empleado){
		EmpleadoEntity ee = empleadoToEntity(empleado);
		Session session=sf.openSession();
		session.beginTransaction();
		session.persist(ee);
		session.flush();
		session.beginTransaction().commit();
		session.close();			
	}
	
	
	public List<EmpleadoEntity> listarEmpleados(){
		Session session=sf.openSession();
		@SuppressWarnings("unchecked")
		List<EmpleadoEntity> list=session.createQuery("from EmpleadoEntity").list();
		session.close();
		return list;
		
	}
	
	//CONVIERTO UN EMPLEADO A EMPLEADO ENTITY
	public EmpleadoEntity empleadoToEntity(Empleado empleado){
		EmpleadoEntity ee = new EmpleadoEntity();
		SucursalEntity sucursal = SucursalDAO.getInstancia().obtenerSucursalEntity(empleado.getSucursal().getIdSucursal());
		ee.setIdUsuario(empleado.getIdUsuario());
		ee.setNombre(empleado.getNombre());
		ee.setMail(empleado.getMail());
		ee.setArea(empleado.getArea());
		ee.setUser(empleado.getUser());
		ee.setContrasenia(empleado.getContrasenia());
		ee.setSucursal(sucursal);
		ee.setActivo(empleado.isActivo());
		ee.setIdEmpleado(empleado.getIdEmpleado());		
		return ee;
	}
	public void actualizarEmpleado(Empleado e) {
		//SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		EmpleadoEntity ee = empleadoToEntity(e);
		s.update(ee);
		s.flush();
		s.beginTransaction().commit();
		s.close();
		
	}
	
	public void eliminarEmpleado(Integer idEmpleado) {
		Session s = sf.openSession();
		Query q = s.createQuery("UPDATE EmpleadoEntity SET activo=? WHERE idEmpleado=?").setParameter(0,false);
		q.setInteger(1, idEmpleado);
		s.beginTransaction().begin();
		q.executeUpdate();
		s.beginTransaction().commit();
		s.close();
	}

	public Empleado recuperarEmpleado(Integer idEmpleado) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		Empleado e = new Empleado();
		Query q = s.createQuery("FROM EmpleadoEntity WHERE idEmpleado=?").setInteger(0, idEmpleado);
		EmpleadoEntity ee = (EmpleadoEntity) q.uniqueResult();
		e = new Empleado(ee);
		s.close();
		return e;
	}
	
}
