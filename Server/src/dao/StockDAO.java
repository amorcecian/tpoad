package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import entities.PrendaVentaEntity;
import entities.StockEntity;
import hbt.HibernateUtil;
import negocio.PrendaVenta;
import negocio.Stock;

public class StockDAO {

	private static StockDAO instancia;
	private static SessionFactory sf;
	
	public static StockDAO getInstance(){
		if(instancia==null){
			instancia = new StockDAO();
			sf=HibernateUtil.getSessionFactory();
		}				
		return instancia;
	}
	
	public void grabarStock(Stock stock){
		Session s = sf.openSession();
		s.beginTransaction();
		StockEntity se = toEntity(stock);		
		s.save(se);
		s.flush();
		s.getTransaction().commit();
		s.close();
	}
	
	public void actualizarStock(Stock stock) {
		Session s = sf.openSession();
		StockEntity se = toEntity(stock);
		s.beginTransaction().begin();
		s.update(se);
		s.flush();
		s.getTransaction().commit();
		s.close();
		
	}
	
	public Stock recuperarStock(Integer idStock){
		Session s = sf.openSession();
		Query q = s.createQuery("FROM StockEntity WHERE idStock=?").setInteger(0, idStock);
		StockEntity se = (StockEntity) q.uniqueResult();
		Stock stock = toNegocio(se);
		s.close();
		return stock;
	}

	public Stock toNegocio(StockEntity se) {
		Stock s = new Stock();
		s.setIdStock(se.getIdStock());
		s.setCantidad(se.getCantidad());
		s.setActivo(se.isActivo());
		
		if(se.getPrendasVenta()!=null) {
			List<PrendaVenta> prendasVenta = new ArrayList<PrendaVenta>();
			for(PrendaVentaEntity i:se.getPrendasVenta())
				prendasVenta.add(PrendaVentaDAO.getInstancia().toNegocio(i));
			s.setPrendasVenta(prendasVenta);
		}		
		return s;		
	}
	
	public StockEntity toEntity(Stock s){
		StockEntity se = new StockEntity();
		se.setIdStock(s.getIdStock());
		se.setCantidad(s.getCantidad());
		if(s.getPrendasVenta()!=null) {
		List<PrendaVentaEntity> lpve=new ArrayList<PrendaVentaEntity>();		
		for(PrendaVenta pv:s.getPrendasVenta()) 
			lpve.add(PrendaVentaDAO.getInstancia().toEntity(pv));
		se.setPrendasVenta(lpve);
		}
		se.setActivo(s.isActivo());				
		return se;
	}

}
