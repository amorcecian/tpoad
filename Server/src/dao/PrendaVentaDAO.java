package dao;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import entities.PrendaVentaEntity;
import entities.StockEntity;
import hbt.HibernateUtil;
import negocio.Lote;
import negocio.PrendaVenta;

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
		// TODO Auto-generated method stub
		
	}

	public void grabarPrendaVenta(PrendaVenta pv) {
		Session s = sf.openSession();
		PrendaVentaEntity pve = PrendaVentaToEntity(pv);
		s.beginTransaction().begin();
		s.save(pve);
		s.flush();
		s.getTransaction().commit();
		s.close();
		
	}
	
	public PrendaVentaEntity PrendaVentaToEntity (PrendaVenta pv){
		return new PrendaVentaEntity(pv);
	}
	
	public PrendaVenta toNegocio(PrendaVentaEntity pve){
		PrendaVenta pv = new PrendaVenta();
		pv.setIdPrendaVenta(pve.getIdPrendaVenta());
		pv.setEstado(pve.getEstado());
		Lote lote = new LoteDAO().toNegocio(pve.getLote());
		pv.setLote(lote);
		pv.setActivo(true);
		return pv;
	}

}
