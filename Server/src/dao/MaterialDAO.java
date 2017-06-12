package dao;

import java.util.List;

import negocio.Cliente;
import negocio.Empleado;
import negocio.Material;
import negocio.Sucursal;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import entities.*;
import exceptions.ExceptionCliente;
import hbt.*;

public class MaterialDAO {
	private static SessionFactory sf=null;
	private static MaterialDAO instancia=null;
	
	public static MaterialDAO getInstancia(){
		if(instancia==null){
			sf=HibernateUtil.getSessionFactory();
			instancia=new MaterialDAO();
		}
		return instancia;
	}
	
	//AGREGO UN Material A LA BASE DE DATOS
	public void grabarMaterial(Material material){
		MaterialEntity me = materialToEntity(material);
		Session session=sf.openSession();
		session.beginTransaction();
		session.persist(me);
		session.flush();
		session.beginTransaction().commit();
		session.close();			
	}
	
	
	public List<MaterialEntity> listarMateriales(){
		Session session=sf.openSession();
		@SuppressWarnings("unchecked")
		List<MaterialEntity> list=session.createQuery("from MaterialEntity").list();
		session.close();
		return list;
		
	}
	
	//CONVIERTO UN EMPLEADO A EMPLEADO ENTITY
	public MaterialEntity materialToEntity(Material material){
		MaterialEntity me = new MaterialEntity();
		me.setCantDisponible(material.getCantDisponible());
		me.setCantReservada(material.getCantReservada());
		me.setCosto(material.getCosto());
		me.setIdMaterial(material.getIdMaterial());
		me.setNombre(material.getNombre());
		me.setProveedor(material.getProveedores());
		return me;
	}
	public void actualizarMaterial(Material m) {
		//SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		MaterialEntity me = materialToEntity(m);
		s.update(me);
		s.flush();
		s.beginTransaction().commit();
		s.close();
		
	}
	
	public void eliminarMaterial(Material material) {

		MaterialEntity me = materialToEntity(material);
		Session s = sf.openSession();
		Query q = s.createQuery("delete FROM MaterialEntity WHERE idMaterial=?").setInteger(0, me.getIdMaterial());
		//q.setInteger(1, me.getIdMaterial());
		s.beginTransaction().begin();
		q.executeUpdate();
		s.beginTransaction().commit();
		s.close();
	}

	public Material recuperarMaterial(Integer idMaterial) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		Material m = new Material();
		Query q = s.createQuery("FROM MaterialEntity WHERE idMaterial=?").setInteger(0, idMaterial);
		MaterialEntity me = (MaterialEntity) q.uniqueResult();
		m = new Material(me);
		s.close();
		return m;
	}
	
}
