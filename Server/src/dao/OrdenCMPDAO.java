package dao;

import java.util.List;
import java.util.Vector;

import org.hibernate.SessionFactory;

import entities.ItemOCMPEntity;
import entities.LoteEntity;
import entities.OrdenCMPEntity;
import hbt.HibernateUtil;
import negocio.ItemOCMP;
import negocio.Lote;
import negocio.OrdenCMP;

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
		o.setLoteValor(orden.getLoteValor());
		o.setOrdenDeProduccion(OrdenDeProdDAO.getInstancia().toEntity(orden.getOrdenDeProduccion()));
		for(ItemOCMP i : orden.getItemPedidoInsumo()){
			listaux.add(ItemOCMPDAO.getInstancia().toEntity(i));
		}
		
		o.setItemPedidoInsumo(listaux);
		return o;
	}
	
	

	public Lote toNegocio(LoteEntity lote) {
		Lote l = new Lote();
		l.setActivo(lote.isActivo());
		l.setCantidadProducida(lote.getCantidadProducida());
		l.setCantidadRestante(lote.getCantidadRestante());
		l.setCostoProd(lote.getCostoProd());
		l.setEstado(lote.getEstado());
		l.setIdLote(lote.getIdLote());
		return l;

	}
}
