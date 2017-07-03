package dao;

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
	public Integer grabarRemito(Remito r) {
		Session s = sf.openSession();
		RemitoEntity re = toEntity(r);
		s.beginTransaction().begin();
		s.save(re);
		s.flush();
		s.getTransaction().commit();
		Integer lastId = (Integer) s.createSQLQuery("SELECT idRemito FROM RemitoEntity ORDER BY idRemito DESC ").setMaxResults(1).uniqueResult();
		s.close();
		return lastId;
		
	}
	
	
	// RECUPERAR UN REMITO DE LA BASE
	public Remito obtenerRemito(Integer idRemito) {
		Session s = sf.openSession();
		Query q = s.createQuery("FROM RemitoEntity WHERE idRemito=?").setInteger(0, idRemito);
		RemitoEntity re = (RemitoEntity) q.uniqueResult();
		s.close();
		Remito remito = toNegocio(re);
		return remito;
		
	}
	
	//CONVIERTO REMITO A REMITOENTITY
	public RemitoEntity toEntity(Remito r){
		return new RemitoEntity(r);
	}
	
	//CONVIERTO REMITOENTITY A REMITO
	public Remito toNegocio(RemitoEntity re){
		Remito remito = new Remito();
		remito.setIdRemito(re.getIdRemito());
		remito.setEstado(re.getEstado());
		remito.setActivo(true);
		Factura factura = new Factura(re.getFactura());
		remito.setFactura(factura);
		List<PrendaVenta> prendasventas = new Vector<PrendaVenta>();
		for(PrendaVentaEntity i:re.getPrendas())
			prendasventas.add(PrendaVentaDAO.getInstancia().toNegocio(i));
		remito.setPrendasventas(prendasventas);
		return remito;
	}
}
