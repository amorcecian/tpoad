package dao;

import java.util.ArrayList;
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
		EmpleadoEntity ee = toEntity(empleado);
		Session session=sf.openSession();
		session.beginTransaction();
		session.persist(ee);
		session.flush();
		session.beginTransaction().commit();
		session.close();			
	}
	
	
	public List<Empleado> listarEmpleados(){
		List<Empleado> lstEmpleados=new ArrayList<Empleado>();
		Session session=sf.openSession();
		List<EmpleadoEntity> list=session.createQuery("FROM EmpleadoEntity WHERE activo=1").list();
		for(EmpleadoEntity ee:list){
			Empleado e=EmpleadoDAO.getInstancia().toNegocio(ee);
			lstEmpleados.add(e);
		}
		session.flush();
		session.close();
		return lstEmpleados;
		
	}
	
	//CONVIERTO UN EMPLEADO A EMPLEADO ENTITY
	public EmpleadoEntity toEntity(Empleado empleado){
		EmpleadoEntity ee = new EmpleadoEntity();
		SucursalEntity sucursal = SucursalDAO.getInstancia().obtenerSucursalEntity(empleado.getSucursal().getIdSucursal());
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
	
	public Empleado toNegocio(EmpleadoEntity emp){
		Empleado e=new Empleado();
		e.setIdEmpleado(emp.getIdEmpleado());
		e.setNombre(emp.getNombre());
		e.setArea(emp.getArea());
		e.setUser(emp.getUser());
		e.setContrasenia(emp.getContrasenia());
		e.setMail(emp.getMail());
		e.setActivo(emp.isActivo());
		Sucursal sucu=new Sucursal();
		sucu.setIdSucursal(emp.getSucursal().getIdSucursal());
		e.setSucursal(sucu);
		return e;		
	}
	
	
	
	
	public void actualizarEmpleado(Empleado e) {
		//SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		EmpleadoEntity ee = toEntity(e);
		s.update(ee);
		s.flush();
		s.beginTransaction().commit();
		s.close();
		
	}
	
	public void eliminarEmpleado(Integer idEmpleado) {
		Session s = sf.openSession();
		Query q = s.createQuery("UPDATE EmpleadoEntity SET activo=0 WHERE idEmpleado=:idEmpleado");
		q.setParameter("idEmpleado",idEmpleado);
		q.executeUpdate();
		s.close();
	}

	public Empleado recuperarEmpleado(Integer idEmpleado) {
		Empleado e=null;
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		Query q = s.createQuery("FROM EmpleadoEntity WHERE idEmpleado=?").setInteger(0, idEmpleado);
		EmpleadoEntity ee = (EmpleadoEntity) q.uniqueResult();
		e=this.toNegocio(ee);
		s.close();
		return e;
	}
	
}
