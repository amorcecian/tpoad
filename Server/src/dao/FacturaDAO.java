package dao;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import entities.FacturaEntity;
import hbt.HibernateUtil;
import negocio.Factura;

public class FacturaDAO {

	private static FacturaDAO instancia;
	private static SessionFactory sf;
	
	public static FacturaDAO getInstance(){
		if(instancia==null){
			instancia = new FacturaDAO();
			sf=HibernateUtil.getSessionFactory();
		}				
		return instancia;
	}

	public Integer grabarFactura(Factura f) {
		Session s=sf.openSession();
		s.beginTransaction();
		FacturaEntity fe=this.toEntity(f);
		Integer idFactura=(Integer) s.save(fe);
		s.flush();
		s.getTransaction().commit();
		s.close();
		return idFactura;
	}
	
	public FacturaEntity toEntity(Factura f){
		FacturaEntity fe=new FacturaEntity();
		fe.setActivo(f.isActivo());
		fe.setIdFactura(f.getIdFactura());
		fe.setCliente(ClienteDAO.getInstance().toEntity(f.getCliente()));
		fe.setPedido(PedidoDAO.getInstance().toEntity(f.getPedido()));
		fe.setTipo(f.getTipo());
		return fe;
	}
	
	
	
}
