package dao;

import java.util.ArrayList;
import java.util.List;

import negocio.Cliente;
import negocio.Empleado;
import negocio.Material;
import negocio.Sucursal;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import dto.MaterialDTO;
import dto.SucursalDTO;
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
		MaterialEntity me = toEntity(material);
		Session session=sf.openSession();
		session.beginTransaction();
		session.save(me);
		session.flush();
		session.beginTransaction().commit();
		session.close();			
	}
	

	
	public List<Material> listarMateriales(){
		Session session=sf.openSession();
		List<MaterialEntity> list=session.createQuery("from MaterialEntity").list();
		List<Material> materiales=new ArrayList<Material>();
		for(MaterialEntity m:list){
			materiales.add(this.toNegocio(m));
		}
		session.flush();
		session.close();
		return materiales;
	}
	
	//CONVIERTO UN MATERIAL A MATERIAL ENTITY
	public MaterialEntity toEntity(Material material){
		MaterialEntity me = new MaterialEntity();
		me.setIdMaterial(material.getIdMaterial());
		me.setCantDisponible(material.getCantDisponible());
		me.setCantReservada(material.getCantReservada());
		me.setCosto(material.getCosto());		
		me.setNombre(material.getNombre());
		me.setProveedor(material.getProveedor());
		me.setActivo(true);
		return me;
	}
	public void actualizarMaterial(Material m) {
		//SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		MaterialEntity me = toEntity(m);
		s.update(me);
		//s.flush();
		s.beginTransaction().commit();
		s.close();
		
	}
	
	public void eliminarMaterial(Material material) {

		MaterialEntity me = toEntity(material);
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
		m = toNegocio(me);
		s.close();
		return m;
	}
	
	public Material toNegocio(MaterialEntity recuperado){
		Material aux=new Material();
		aux.setIdMaterial(recuperado.getIdMaterial());
		aux.setNombre(recuperado.getNombre());
		aux.setCantDisponible(recuperado.getCantDisponible());
		aux.setCantReservada(recuperado.getCantReservada());
		aux.setProveedor(recuperado.getProveedor());
		aux.setCosto(recuperado.getCosto());
		return aux;
	}
	
}
