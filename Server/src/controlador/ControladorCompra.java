package controlador;

import java.util.List;
import java.util.Vector;

import dao.EmpleadoDAO;
import dao.MaterialDAO;
import dao.SucursalDAO;
import dto.EmpleadoDTO;
import dto.MaterialDTO;
import entities.EmpleadoEntity;
import entities.MaterialEntity;
import negocio.*;

public class ControladorCompra {
	private List<OrdenCMP> ordenesMP;
	private List<Material> materiales;
	
	private static ControladorCompra instancia;
	
	public static ControladorCompra getInstancia(){
		if(instancia==null){
			instancia=new ControladorCompra();
		}
		return instancia;
	}
	
	public void agregarMaterial(MaterialDTO m) {
		Material material = new Material();
		material.setCantDisponible(m.getCantDisponible());
		material.setCantReservada(m.getCantReservada());
		material.setCosto(m.getCosto());
		material.setNombre(m.getNombre());
		material.setProveedores(m.getProveedor());
		MaterialDAO.getInstancia().grabarMaterial(material);
		
	}

	public void actualizarMaterial(MaterialDTO m) {
		
		Material material = new Material();
		material.setCantDisponible(m.getCantDisponible());
		material.setCantReservada(m.getCantReservada());
		material.setCosto(m.getCosto());
		material.setNombre(m.getNombre());
		material.setProveedores(m.getProveedor());
		MaterialDAO.getInstancia().actualizarMaterial(material);
		
	}
	
	public MaterialDTO recuperarMaterial(Integer idMaterial){
		return MaterialDAO.getInstancia().recuperarMaterial(idMaterial).toDTO();
	}

	public List<MaterialDTO> listarMateriales() {
		List<MaterialDTO> aux = new Vector<MaterialDTO>();
		for(MaterialEntity e:MaterialDAO.getInstancia().listarMateriales())
			aux.add(e.toDTO());
		return aux;	
	}

}
