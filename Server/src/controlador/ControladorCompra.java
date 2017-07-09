package controlador;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import dao.EmpleadoDAO;
import dao.MaterialDAO;
import dao.MaterialPorPrendaDAO;
import dao.OrdenCMPDAO;
import dao.SucursalDAO;
import dto.EmpleadoDTO;
import dto.MaterialDTO;
import entities.EmpleadoEntity;
import entities.MaterialEntity;
import entities.OrdenCMPEntity;
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
		material.setProveedor(m.getProveedor());
		material.setActivo(m.isActivo());
		MaterialDAO.getInstancia().grabarMaterial(material);
		
	}

	public void actualizarMaterial(MaterialDTO m) {
		
		Material material = new Material();
		material.setCantDisponible(m.getCantDisponible());
		material.setCantReservada(m.getCantReservada());
		material.setCosto(m.getCosto());
		material.setNombre(m.getNombre());
		material.setProveedor(m.getProveedor());
		MaterialDAO.getInstancia().actualizarMaterial(material);
		
	}
	
	public MaterialDTO recuperarMaterial(Integer idMaterial){
		return MaterialDAO.getInstancia().recuperarMaterial(idMaterial).toDTO();
	}

	public List<MaterialDTO> listarMateriales() {
		List<MaterialDTO> aux = new ArrayList<MaterialDTO>();
		for(Material e:MaterialDAO.getInstancia().listarMateriales())
			aux.add(e.toDTO());
		return aux;	
	}

	public boolean listoParaProducir(Prenda prenda) {
		boolean b = true;
		for(MaterialPorPrenda m : MaterialPorPrendaDAO.getInstance().obtenerMaterialDePrenda(prenda.getIdPrenda())){
			if(m.getCantidad() > m.getMaterial().getCantDisponible()){
				b = false;
			}
		}
		return b;
	}

	public void reservarMateriales(Prenda prenda) {
		for(MaterialPorPrenda m : MaterialPorPrendaDAO.getInstance().obtenerMaterialDePrenda(prenda.getIdPrenda())){
			int aux = m.getCantidad();
			m.getMaterial().setCantDisponible(m.getMaterial().getCantDisponible() - aux);
			m.getMaterial().setCantReservada(m.getMaterial().getCantReservada() + aux);
		}
	}

	public void generarOrdenCompra(Prenda prenda,OrdenDeProduccion orden) {
		OrdenCMP oc = new OrdenCMP();
		oc.setActivo(true);
		oc.setEstado("Pendiente");
		oc.setOrdenDeProduccion(orden);
		oc.setFechaPedido(Calendar.getInstance().getTime().toString());
		List<ItemOCMP> listaitems = new Vector<ItemOCMP>();
		
		//Recorro todos los items de la prenda
		for(MaterialPorPrenda m : MaterialPorPrendaDAO.getInstance().obtenerMaterialDePrenda(prenda.getIdPrenda())){
			if(m.getCantidad() > m.getMaterial().getCantDisponible()){
				ItemOCMP itemaux = new ItemOCMP();
				itemaux.setActivo(true);
				itemaux.setCantidad(m.getCantidad()*2);
				itemaux.setMaterial(m.getMaterial());
				listaitems.add(itemaux);
			}
		}
		
		oc.setItemPedidoInsumo(listaitems);
		
		OrdenCMPDAO.getInstancia().guardarOrden(oc);
		
	}

}
