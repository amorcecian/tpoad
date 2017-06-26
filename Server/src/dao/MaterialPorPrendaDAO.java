package dao;

import hbt.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import negocio.MaterialPorPrenda;
import entities.MaterialEntity;
import entities.MaterialPorPrendaEntity;
import entities.PrendaEntity;

public class MaterialPorPrendaDAO {
	
	private static MaterialPorPrendaDAO instancia;
	private static SessionFactory sf;
	
	public static MaterialPorPrendaDAO getInstance(){
		if(instancia==null){
			instancia = new MaterialPorPrendaDAO();
			sf=HibernateUtil.getSessionFactory();
		}			
		return instancia;
	}
	
	//AGREGO MATERIAL POR PRENDA
	public void agregarMateriaporPrenda(MaterialPorPrenda mpp){
		Session s=sf.openSession();
		MaterialPorPrendaEntity mppe=toEntity(mpp);
		s.beginTransaction();
		s.save(mppe);
		s.flush();
		s.getTransaction().commit();
		s.close();
	}
	
	// MATERIAL POR PRENDA A ENTITY
	public MaterialPorPrendaEntity toEntity(MaterialPorPrenda mpp){
		MaterialPorPrendaEntity mppe = new MaterialPorPrendaEntity();
		MaterialEntity me = MaterialDAO.getInstancia().toEntity(mpp.getMaterial());
		mppe.setActivo(true);
		mppe.setCantidad(mpp.getCantidad());
		mppe.setDesperdicio(mppe.getDesperdicio());
		mppe.setMaterial(me);		
		return mppe;
	}
	
	
	

}
