package controlador;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import dao.EmpleadoDAO;
import dao.LoteDAO;
import dao.MaterialDAO;
import dao.MaterialPorPrendaDAO;
import dao.OrdenCMPDAO;
import dao.SucursalDAO;
import dto.EmpleadoDTO;
import dto.MaterialDTO;
import dto.ordenCMPDTO;
import entities.EmpleadoEntity;
import entities.MaterialEntity;
import entities.OrdenCMPEntity;
import entities.PrendaCantidad;
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
		material.setCosto(m.getCosto());
		material.setNombre(m.getNombre());
		material.setProveedor(m.getProveedor());
		material.setActivo(m.isActivo());
		MaterialDAO.getInstancia().grabarMaterial(material);
		
	}

	public void actualizarMaterial(MaterialDTO m) {
		
		Material material = new Material();
		material.setCantDisponible(m.getCantDisponible());
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
		for(MaterialPorPrenda mpp : MaterialPorPrendaDAO.getInstance().obtenerMaterialDePrenda(prenda.getIdPrenda())){
			Material m=mpp.getMaterial();
			Integer cantidadActual=m.getCantDisponible()-(mpp.getCantidad()+mpp.getDesperdicio());
			m.setCantDisponible(cantidadActual);
			MaterialDAO.getInstancia().actualizarMaterial(m);
		}
	}

	public void generarOrdenCompra(PrendaCantidad prenda,OrdenDeProduccion orden,Lote lote) {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");	
		Calendar calendar = Calendar.getInstance();
		String fechaOrdenDeCompra;
		calendar.setTime(date); 
		date = calendar.getTime();
		fechaOrdenDeCompra=dateFormat.format(date);
		System.out.println("Id Etapa Productiva / Generar OC: "+prenda.getPrenda().getEtapaProd().get(0).getIdEtapaProductiva());
		
		OrdenCMP oc = new OrdenCMP();
		oc.setActivo(true);
		oc.setEstado("Pendiente");
		oc.setOrdenDeProduccion(orden);
		oc.setFechaPedido(fechaOrdenDeCompra);
		oc.setIdLote(lote.getIdLote());
		List<ItemOCMP> listaitems = new Vector<ItemOCMP>();
		
		//Recorro todos los items de la prenda
		for(MaterialPorPrenda m : MaterialPorPrendaDAO.getInstance().obtenerMaterialDePrenda(prenda.getPrenda().getIdPrenda())){
			if((m.getCantidad()*prenda.getCantidadAProducir()) > m.getMaterial().getCantDisponible()){
				ItemOCMP itemaux = new ItemOCMP();
				itemaux.setActivo(true);
				itemaux.setCantidad((m.getCantidad()*prenda.getCantidadAProducir())*2);
				itemaux.setMaterial(m.getMaterial());
				listaitems.add(itemaux);
			}
		}
		
		oc.setItemPedidoInsumo(listaitems);
		
		OrdenCMPDAO.getInstancia().guardarOrden(oc);
		
	}
	
	public void OrdenCompraCompleta(Integer idOC){		
		//Levanto la OC de la base
		OrdenCMP oc = OrdenCMPDAO.getInstancia().obtenerOC(idOC);
		System.out.println("Id Orden de compra: "+oc.getIdODCM());
		
		//Por cada material, aumento la cantidad disponible
		for(ItemOCMP i : oc.getItemPedidoInsumo()){
			Material m = MaterialDAO.getInstancia().recuperarMaterial(i.getMaterial().getIdMaterial());
			m.setCantDisponible(m.getCantDisponible() + i.getCantidad());
			MaterialDAO.getInstancia().actualizarMaterial(m);
		}
		Lote l=LoteDAO.getInstancia().obtenerLote(oc.getIdLote());		
		ControladorProduccion.getInstancia().reactivarProduccion(l);
		
		OrdenCMPDAO.getInstancia().actualizarEstado(oc.getIdODCM(), "Completado");
	}
	
	public List<ordenCMPDTO> ObtenerOCPendientes(){
		List<ordenCMPDTO> list = new Vector<ordenCMPDTO>();
		for(OrdenCMP o : OrdenCMPDAO.getInstancia().obtenerPedidosPendientes()){
			list.add(o.toDTO());
		}
		return list;
	}

}
