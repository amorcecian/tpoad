package dao;

import negocio.MaterialPorPrenda;
import entities.MaterialEntity;
import entities.MaterialPorPrendaEntity;

public class MaterialPorPrendaDAO {
	
	private static MaterialPorPrendaDAO instancia;
	
	public static MaterialPorPrendaDAO getInstance(){
		if(instancia==null)
			instancia = new MaterialPorPrendaDAO();
		return instancia;
	}
	
	// MATERIAL POR PRENDA A ENTITY
	public MaterialPorPrendaEntity materialPPToEntity(MaterialPorPrenda mpp){
		MaterialPorPrendaEntity mppe = new MaterialPorPrendaEntity();
		MaterialEntity me = MaterialDAO.getInstancia().materialToEntity(mpp.getMaterial());
		mppe.setActivo(true);
		mppe.setCantidad(mpp.getCantidad());
		mppe.setDesperdicio(mppe.getDesperdicio());
		mppe.setMaterial(me);
		return mppe;
	}

}
