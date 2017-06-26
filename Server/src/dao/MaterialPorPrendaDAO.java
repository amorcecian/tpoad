package dao;

import hbt.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import negocio.MaterialPorPrenda;
import entities.MaterialEntity;
import entities.MaterialPorPrendaEntity;

public class MaterialPorPrendaDAO {
	
	private static MaterialPorPrendaDAO instancia;
	
	public static MaterialPorPrendaDAO getInstance(){
		if(instancia==null)
			instancia = new MaterialPorPrendaDAO();
		return instancia;
	}
	
	//AGREGO MATERIAL POR PRENDA
	public void agregarMateriaporPrenda(MaterialPorPrenda mpp){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.openSession();
		MaterialPorPrendaEntity mppe=materialPPToEntity(mpp);
		s.beginTransaction();
		s.save(mppe);
		s.flush();
		s.getTransaction().commit();
		s.close();
	}
	
	// MATERIAL POR PRENDA A ENTITY
	public MaterialPorPrendaEntity materialPPToEntity(MaterialPorPrenda mpp){
		MaterialPorPrendaEntity mppe = new MaterialPorPrendaEntity();
		MaterialEntity me = MaterialDAO.getInstancia().toEntity(mpp.getMaterial());
		mppe.setActivo(true);
		mppe.setCantidad(mpp.getCantidad());
		mppe.setDesperdicio(mppe.getDesperdicio());
		mppe.setMaterial(me);
		return mppe;
	}
	
	
	

}
