package dao;

import java.util.List;
import java.util.Vector;

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
	
	public void agregarStock(Stock stock){
		Session s = sf.openSession();
		StockEntity se = toEntity(stock);
		s.beginTransaction().begin();
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
		s.beginTransaction().commit();
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
		List<PrendaVenta> prendasVenta = new Vector<PrendaVenta>();
		for(PrendaVentaEntity i:se.getPrendasVenta())
			prendasVenta.add(PrendaVentaDAO.getInstancia().toNegocio(i));
		s.setPrendasVenta(prendasVenta);
		return s;
		
	}
	
	public StockEntity toEntity(Stock s){
		StockEntity se = new StockEntity();
		se.setIdStock(s.getIdStock());
		se.setCantidad(s.getCantidad());
		s.setActivo(s.isActivo());
		List<PrendaVentaEntity> prendasVenta = new Vector<PrendaVentaEntity>();
		for(PrendaVenta i:s.getPrendasVenta())
			prendasVenta.add(PrendaVentaDAO.getInstancia().PrendaVentaToEntity(i));
		se.setPrendasVenta(prendasVenta);
		return se;
	}

}
