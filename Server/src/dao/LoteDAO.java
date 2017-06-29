package dao;
import hbt.HibernateUtil;import negocio.Lote;import org.hibernate.SessionFactory;import entities.LoteEntity;
public class LoteDAO {
		private static LoteDAO instancia;	@SuppressWarnings("unused")	private static SessionFactory sf;
	public static LoteDAO getInstancia(){
		if(instancia==null){
			instancia=new LoteDAO();
			sf=HibernateUtil.getSessionFactory();
		}
		return instancia;
	}
	
	public LoteEntity toEntity(Lote lote){
		LoteEntity le=new LoteEntity();
		le.setActivo(lote.isActivo());
		le.setCantidadProducida(lote.getCantidadProducida());
		le.setCantidadRestante(lote.getCantidadRestante());
		le.setCostoProd(lote.getCostoProd());
		le.setEstado(lote.getEstado());
		le.setPrenda(PrendaDAO.getInstance().toEntity(lote.getPrenda()));
		//le.setAreaProductiva(AreaProductivaDAO.getInstancia().toEntity(lote.get));
		//le.setOrdenDeProduccion(Orde);
		return le;
		
	}
	

	public LoteEntity toEntity1(Lote lote){
		LoteEntity le=new LoteEntity();
		le.setActivo(lote.isActivo());
		le.setCantidadProducida(lote.getCantidadProducida());
		le.setCantidadRestante(lote.getCantidadRestante());
		le.setCostoProd(lote.getCostoProd());
		le.setEstado(lote.getEstado());
		le.setPrenda(PrendaDAO.getInstance().toEntity(lote.getPrenda()));
		//le.setAreaProductiva(AreaProductivaDAO.getInstancia().toEntity(lote.get));
		//le.setOrdenDeProduccion(Orde);
		return le;
	}
	public Lote toNegocio(LoteEntity lote) {		Lote l=new Lote();		l.setActivo(lote.isActivo());		l.setCantidadProducida(lote.getCantidadProducida());		l.setCantidadRestante(lote.getCantidadRestante());		l.setCostoProd(lote.getCostoProd());		l.setEstado(lote.getEstado());		l.setIdLote(lote.getIdLote());		return l;
	}	public void actualizarLote(Lote lote) {		// TODO Auto-generated method stub			}	public void guardarLote(Lote nuevo) {		// TODO Auto-generated method stub			}
	

}
