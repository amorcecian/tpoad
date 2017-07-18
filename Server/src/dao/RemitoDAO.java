package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import entities.PrendaVentaEntity;
import entities.RemitoEntity;
import hbt.HibernateUtil;
import negocio.Factura;
import negocio.PrendaVenta;
import negocio.Remito;

public class RemitoDAO {
	private static RemitoDAO instancia;
	private static SessionFactory sf;
	
	public static RemitoDAO getInstance(){
		if(instancia==null){
			instancia = new RemitoDAO();
			sf=HibernateUtil.getSessionFactory();
		}				
		return instancia;
	}
	
	// AGREGAR UN REMITO A LA BASE DE DATOS
	public int grabarRemito(Remito r) {
		Session s = sf.openSession();
		RemitoEntity re = toEntity(r);
		s.beginTransaction();
		Integer idRemito=(Integer) s.save(re);
		s.getTransaction().commit();
		s.close();	
		return idRemito;
	}
	
	
	public void actualizarRemito(Remito r) {
		RemitoEntity re=this.toEntity(r);
		Session s=sf.openSession();
		s.beginTransaction();
		s.merge(re);
		s.getTransaction().commit();
		s.close();
	}
	
	
	// RECUPERAR UN REMITO DE LA BASE
	public Remito obtenerRemito(Integer idRemito) {
		Session s = sf.openSession();
		Query q = s.createQuery("FROM RemitoEntity WHERE idRemito=?").setInteger(0, idRemito);
		RemitoEntity re = (RemitoEntity) q.uniqueResult();		
		Remito remito = toNegocio(re);
		s.close();
		return remito;
		
	}
	
	//CONVIERTO REMITO A REMITOENTITY
	public RemitoEntity toEntity(Remito r){
		RemitoEntity re=new RemitoEntity();
		re.setIdRemito(r.getIdRemito());
		re.setActivo(r.isActivo());		
		re.setFactura(FacturaDAO.getInstance().toEntity(r.getFactura()));
		re.setEstado(r.getEstado());
		return re;
	}
	
	//CONVIERTO REMITOENTITY A REMITO
	public Remito toNegocio(RemitoEntity re){
		Remito remito = new Remito();
		remito.setIdRemito(re.getIdRemito());
		remito.setEstado(re.getEstado());
		remito.setActivo(true);
		remito.setFactura(FacturaDAO.getInstance().toNegocio(re.getFactura()));
		return remito;
	}
}
