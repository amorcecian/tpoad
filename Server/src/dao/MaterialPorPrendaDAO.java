package dao;

import hbt.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import negocio.Lote;
import negocio.Material;
import negocio.MaterialPorPrenda;
import entities.LoteEntity;
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

		mppe.setMaterial(me);
		mppe.setActivo(true);
		mppe.setCantidad(mpp.getCantidad());
		mppe.setDesperdicio(mpp.getDesperdicio());
		mppe.setPrenda(PrendaDAO.getInstance().toEntity(mpp.getPrenda()));
		return mppe;
	}
	
	public void actualizarMaterialPorPrenda(MaterialPorPrenda mp) {
		Session s = sf.openSession();
		MaterialPorPrendaEntity mpe = toEntity(mp);
		s.update(mpe);
		s.flush();
		s.beginTransaction().commit();
		s.close();

	}

	public void guardarMaterialPorPrenda(MaterialPorPrenda mp) {
		MaterialPorPrendaEntity mpe = toEntity(mp);
		Session session = sf.openSession();
		session.beginTransaction();
		session.persist(mpe);
		session.flush();
		session.beginTransaction().commit();
		session.close();

	}
	
	public MaterialPorPrenda obtenerMaterialPorPrenda(Integer idMaterial) {
		
		Session s = sf.openSession();
		MaterialPorPrenda mp = new MaterialPorPrenda();
		Query q = s.createQuery("FROM MaterialporPrendaEntity WHERE idMaterialPrenda=?").setInteger(0, idMaterial);
		MaterialPorPrendaEntity mpe = (MaterialPorPrendaEntity) q.uniqueResult();
		mp = toNegocio(mpe);
		s.close();
		return mp;
	}

	public MaterialPorPrenda toNegocio(MaterialPorPrendaEntity mpe) {
		MaterialPorPrenda mp = new MaterialPorPrenda();
		mp.setActivo(mpe.isActivo());
		mp.setCantidad(mpe.getCantidad());
		mp.setDesperdicio(mpe.getDesperdicio());
		mp.setMaterial(MaterialDAO.getInstancia().toNegocio(mpe.getMaterial()));
		
		return mp;
	}
	

}
