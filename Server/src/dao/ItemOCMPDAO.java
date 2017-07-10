package dao;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

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
		ItemOCMPEntity item = new ItemOCMPEntity();
		item.setActivo(i.isActivo());
		item.setCantidad(i.getCantidad());
		item.setMaterial(MaterialDAO.getInstancia().toEntity(i.getMaterial()));
		item.setPrecio(i.getPrecio());
		return item;
		
	}
	public ItemOCMP toNegocio(ItemOCMPEntity i) {
		ItemOCMP item = new ItemOCMP();
		item.setActivo(i.isActivo());
		item.setCantidad(i.getCantidad());
		item.setMaterial(MaterialDAO.getInstancia().toNegocio(i.getMaterial()));
		item.setPrecio(i.getPrecio());
		return item;
	}
	
	public void actualizarItem(ItemOCMP item) {
		Session s = sf.openSession();
		ItemOCMPEntity i = toEntity(item);
		s.beginTransaction().begin();
		s.update(i);
		s.flush();
		s.beginTransaction().commit();
		s.close();

	}

	public void guardarOrden(ItemOCMP item) {
		Session s = sf.openSession();
		s.beginTransaction();
		ItemOCMPEntity i = toEntity(item);
		s.save(i);
		s.flush();
		s.getTransaction().commit();
		s.close();
	}

}
