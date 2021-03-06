package dao;

import hbt.HibernateUtil;

import java.util.List;
import java.util.Vector;

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
		MaterialPorPrendaEntity mppe=new MaterialPorPrendaEntity();
		mppe.setId(mpp.getId());
		mppe.setActivo(mpp.isActivo());
		mppe.setCantidad(mpp.getCantidad());
		mppe.setDesperdicio(mpp.getDesperdicio());
		mppe.setMaterial(MaterialDAO.getInstancia().toEntity(mpp.getMaterial()));		
		return mppe;
	}
	
	public void actualizarMaterialPorPrenda(MaterialPorPrenda mp) {
		Session s = sf.openSession();
		MaterialPorPrendaEntity mpe = toEntity(mp);
		s.update(mpe);
		//s.flush();
		s.beginTransaction().commit();
		s.close();

	}

	public void guardarMaterialPorPrenda(MaterialPorPrenda mp) {
		Session s = sf.openSession();
		s.beginTransaction().begin();
		MaterialPorPrendaEntity mpe = toEntity(mp);				
		s.save(mpe);
		s.flush();
		s.getTransaction().commit();
		s.close();
	}
	
	public MaterialPorPrenda obtenerMaterialPorPrenda(Integer idMaterialPrenda) {		
		Session s = sf.openSession();
		MaterialPorPrenda mp = new MaterialPorPrenda();
		Query q = s.createQuery("FROM MaterialPorPrendaEntity WHERE id=?").setInteger(0, idMaterialPrenda);
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

	@SuppressWarnings("unchecked")
	public List<MaterialPorPrenda> obtenerMaterialDePrenda(int idPrenda) {
		Session s = sf.openSession();
		s.beginTransaction();
		List<MaterialPorPrenda> list = new Vector <MaterialPorPrenda>();
		Query q = s.createQuery("FROM MaterialPorPrendaEntity WHERE id_prenda=?");
		q.setParameter(0, idPrenda);
		List<MaterialPorPrendaEntity> lista= q.list();
		for (MaterialPorPrendaEntity l : lista){
			list.add(this.toNegocio(l));
		}
		s.flush();
		s.getTransaction().commit();
		s.close();
		return list;
	}
	

}
