package dao;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import entities.PrendaVentaEntity;
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
		// TODO Auto-generated method stub
		
	}

	public void grabarPrendaVenta(PrendaVenta pv) {
		Session s = sf.openSession();
		PrendaVentaEntity pve = toEntity(pv);
		s.save(pve);
<<<<<<< Updated upstream
		s.getTransaction().commit();
=======
		s.flush();
>>>>>>> Stashed changes
		s.close();
		
	}
	
	public PrendaVentaEntity PrendaVentaToEntity (PrendaVenta pv){
		return new PrendaVentaEntity(pv);
	}
	
	public PrendaVentaEntity toEntity(PrendaVenta pv) {
		PrendaVentaEntity pve=new PrendaVentaEntity();
		pve.setActivo(pv.isActivo());
		pve.setEstado(pv.getEstado());
		pve.setIdPrendaVenta(pv.getIdPrendaVenta());
		pve.setLote(LoteDAO.getInstancia().toEntity(pv.getLote()));
		return pve;
	}
	
	public PrendaVenta toNegocio(PrendaVentaEntity pve){
		PrendaVenta pv = new PrendaVenta();
		pv.setIdPrendaVenta(pve.getIdPrendaVenta());
		pv.setEstado(pve.getEstado());
		Lote lote = LoteDAO.getInstancia().toNegocio(pve.getLote());
		pv.setLote(lote);
		Stock stock = StockDAO.getInstance().toNegocio(pve.getStock());
		pv.setStock(stock);
		pv.setActivo(true);
		return pv;
	}

}
