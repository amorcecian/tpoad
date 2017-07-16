package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import entities.ItemOCMPEntity;
import entities.OrdenCMPEntity;
import entities.PedidoEntity;
import entities.PrendaEntity;
import hbt.HibernateUtil;
import negocio.ItemOCMP;
import negocio.OrdenCMP;
import negocio.Pedido;
import negocio.Prenda;

public class OrdenCMPDAO {
	private static OrdenCMPDAO instancia;
	private static SessionFactory sf;

	public static OrdenCMPDAO getInstancia() {
		if (instancia == null) {
			instancia = new OrdenCMPDAO();
			sf = HibernateUtil.getSessionFactory();
		}
		return instancia;
	}

	public OrdenCMPEntity toEntity(OrdenCMP orden) {
		OrdenCMPEntity o = new OrdenCMPEntity();
		List<ItemOCMPEntity> listaux = new Vector<ItemOCMPEntity>();

		o.setActivo(orden.isActivo());
		o.setEstado(orden.getEstado());
		o.setFechaEstDespacho(orden.getFechaEstDespacho());
		o.setFechaPedido(orden.getFechaPedido());
		o.setFechaRealDespacho(orden.getFechaRealDespacho());
		o.setIdODCM(orden.getIdODCM());
		o.setIdLote(orden.getIdLote());
		o.setOrdenDeProduccion(OrdenDeProdDAO.getInstancia().toEntity(orden.getOrdenDeProduccion()));
		for(ItemOCMP i : orden.getItemPedidoInsumo()){
			listaux.add(ItemOCMPDAO.getInstancia().toEntity(i));
		}
		o.setItemPedidoInsumo(listaux);
		return o;
	}
	
	public OrdenCMP toNegocio(OrdenCMPEntity orden) {
		OrdenCMP o = new OrdenCMP();
		List<ItemOCMP> listaaux = new Vector <ItemOCMP>();
		
		o.setActivo(orden.isActivo());
		o.setEstado(orden.getEstado());
		o.setFechaEstDespacho(orden.getFechaEstDespacho());
		o.setFechaPedido(orden.getFechaPedido());
		o.setFechaRealDespacho(orden.getFechaRealDespacho());
		o.setIdODCM(orden.getIdODCM());
		o.setIdLote(orden.getIdLote());
		o.setOrdenDeProduccion(OrdenDeProdDAO.getInstancia().toNegocio(orden.getOrdenDeProduccion()));
		for(ItemOCMPEntity i : orden.getItemPedidoInsumo()){
			listaaux.add(ItemOCMPDAO.getInstancia().toNegocio(i));
		}
		o.setItemPedidoInsumo(listaaux);
		return o;
	}
	
	public void actualizarOrden(OrdenCMP orden) {
		Session s = sf.openSession();
		OrdenCMPEntity o= toEntity(orden);
		s.beginTransaction().begin();
		s.merge(o);
		//s.flush();
		s.beginTransaction().commit();
		s.close();

	}

	public void guardarOrden(OrdenCMP orden) {
		Session s = sf.openSession();
		OrdenCMPEntity o= toEntity(orden);
		s.beginTransaction();
		s.merge(o);
		/*
		for(ItemOCMP i : orden.getItemPedidoInsumo()){
			ItemOCMPDAO.getInstancia().guardarOrden(i);
		}
		*/
		//s.flush();
		s.getTransaction().commit();
		s.close();
	}
	
	public OrdenCMP obtenerOC(Integer idOrden) {		
		Session s = sf.openSession();		
		OrdenCMPEntity pe =(OrdenCMPEntity) s.load(OrdenCMPEntity.class, idOrden);
		OrdenCMP o=toNegocio(pe);
		s.close();
		return o;
	}

	public List<OrdenCMP> obtenerPedidosPendientes() {
			Session s = sf.openSession();
			s.beginTransaction();
			Query q = s.createQuery("FROM OrdenCMPEntity WHERE descripcion LIKE 'Pendiente'");
			@SuppressWarnings("unchecked")
			List<OrdenCMPEntity> aux = q.list();
			List<OrdenCMP> lista= new ArrayList<OrdenCMP>();
			for(OrdenCMPEntity o:aux) {
				lista.add(toNegocio(o));
			}			
			s.flush();
			s.getTransaction().commit();
			s.close();
			return lista;
		}

	
		
}
