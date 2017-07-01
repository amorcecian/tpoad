package dao;

import org.hibernate.SessionFactory;

import entities.StockEntity;
import hbt.HibernateUtil;
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
	
	public void actualizarStock(Stock stock) {
		// TODO Auto-generated method stub
		
	}

	public Stock toNegocio(StockEntity stock) {
		// TODO Auto-generated method stub
		return null;
	}

}
