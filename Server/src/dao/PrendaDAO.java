package dao;

import java.util.List;
import java.util.Vector;

import negocio.MaterialPorPrenda;
import negocio.Prenda;
import entities.MaterialPorPrendaEntity;
import entities.PrendaEntity;

public class PrendaDAO {
	
	private static PrendaDAO instancia;
	
	public static PrendaDAO getInstance(){
		if(instancia==null)
			instancia = new PrendaDAO();
		return instancia;
	}
	
	// AGREGAR UNA PRENDA
	
	// PRENDA TO PRENDAENTITY
	
	public PrendaEntity prendaToEntity(Prenda p){
		PrendaEntity prenda = new PrendaEntity();
		List<MaterialPorPrendaEntity> materiales = new Vector<MaterialPorPrendaEntity>();
		for (MaterialPorPrenda i:p.getMateriales()){
			materiales.add(MaterialPorPrendaDAO.getInstance().materialPPToEntity(i));
		}
		prenda.setCantProducir(p.getCantProducir());
		prenda.setColor(p.getColor());
		prenda.setDescripcion(p.getDescripcion());
		prenda.setMaterialesPorPrenda(materiales);
		prenda.setPrecioVenta(p.getPrecioVenta());
		prenda.setTalle(p.getTalle());
		prenda.setTemporada(p.getTemporada());
		prenda.setTiempoProd(p.getTiempoProd());
		
		return prenda;
	}

	public Prenda obtenerPrenda(Integer idPrenda) {
		//levanto una prenda de la base y la devuelvo
		return null;
	}

	public List<Prenda> obtenerPrendasPorDescripcion(String descripcion) {
		// devolver todas las prendas con una descripcion particular
		return null;
	}

}
