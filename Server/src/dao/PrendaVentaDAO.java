package dao;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import entities.PrendaVentaEntity;
import entities.RemitoEntity;
import entities.StockEntity;
import hbt.HibernateUtil;
import negocio.Lote;
import negocio.PrendaVenta;
import negocio.Stock;

public class PrendaVentaDAO {

	private static SessionFactory sf=null;
	private static PrendaVentaDAO instancia=null;
	
	public static PrendaVentaDAO getInstancia(){
		if(instancia==null){
			sf=HibernateUtil.getSessionFactory();
			instancia=new PrendaVentaDAO();
		}
		return instancia;
	}
	public void actualizarPrendaVenta(PrendaVenta pv) {
		Session s=sf.openSession();
		s.beginTransaction();
		PrendaVentaEntity pve=this.toEntity(pv);
		s.update(pve);
		System.out.println("Aca grabo id:"+pve.getIdPrendaVenta());
		s.flush();
		s.getTransaction().commit();
		s.close();	
	}

	public Integer grabarPrendaVenta(PrendaVenta pv) {
		Session s = sf.openSession();
		s.beginTransaction();
		PrendaVentaEntity pve = toEntity(pv);
		Integer idPrendaVenta=(Integer) s.save(pve);
		s.flush();
		s.getTransaction().commit();
		s.close();	
		return idPrendaVenta;
	}
	
	public PrendaVenta recuperarPrendaVenta(Integer id) {
		Session s=sf.openSession();
		s.beginTransaction();
		PrendaVentaEntity pve=(PrendaVentaEntity) s.load(PrendaVentaEntity.class, id);
		PrendaVenta pv=this.toNegocio(pve);
		s.flush();
		s.close();
		return pv;				
	}
	
	public PrendaVentaEntity toEntity(PrendaVenta pv) {
		PrendaVentaEntity pve=new PrendaVentaEntity();
		pve.setIdPrendaVenta(pv.getIdPrendaVenta());
		pve.setActivo(pv.isActivo());
		pve.setEstado(pv.getEstado());		
		pve.setIdLote(pv.getIdLote());
		pve.setIdRemito(pv.getIdRemito());	
		return pve;
	}
	
	public PrendaVenta toNegocio(PrendaVentaEntity pve){
		PrendaVenta pv = new PrendaVenta();
		pv.setIdPrendaVenta(pve.getIdPrendaVenta());
		pv.setEstado(pve.getEstado());
		pv.setIdLote(pve.getIdLote());
		pv.setActivo(true);
		pv.setIdRemito(pve.getIdRemito());
		
		return pv;
	}

}
