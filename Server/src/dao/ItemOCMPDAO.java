package dao;

import org.hibernate.SessionFactory;

import entities.ItemOCMPEntity;
import hbt.HibernateUtil;
import negocio.ItemOCMP;

public class ItemOCMPDAO {

	private static ItemOCMPDAO instancia;
	private static SessionFactory sf;

	public static ItemOCMPDAO getInstancia() {
		if (instancia == null) {
			instancia = new ItemOCMPDAO();
			sf = HibernateUtil.getSessionFactory();
		}
		return instancia;
	}
	public ItemOCMPEntity toEntity(ItemOCMP i) {
		// TODO Auto-generated method stub
		return null;
	}

}
