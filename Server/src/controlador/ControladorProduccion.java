package controlador;
import java.util.ArrayList;import java.util.List;import java.util.Vector;import dao.AlmacenamientoDAO;import dao.LineaDAO;import dao.LoteDAO;import dao.MaterialDAO;import dao.MaterialPorPrendaDAO;import dao.OrdenDeProdDAO;import dao.PrendaDAO;import dto.LoteDTO;import dto.MaterialDTO;import dto.MaterialporPrendaDTO;import dto.PrendaDTO;import negocio.*;

public class ControladorProduccion {
	private List<OrdenDeProduccion> ordenesDeProduccion;
	private List<Prenda> prendas;
	private List<Lote> lotes;
	private List<OrdenModificacion> ordendesDeModificacion;
	private List<AreaProductiva> areasProductivas;
	private List<EtapaProductiva> etapasProductivas;
	private List<Almacenamiento> almacenamiento;	
	private static ControladorProduccion instancia;
	
	public static ControladorProduccion getInstancia(){
		if(instancia==null){
			instancia=new ControladorProduccion();
		}
		return instancia;
	}
	
	//Me notifican que termino una linea de prod
	public void liberarArea(int idLineaProd,int idAreaProductiva){
		//recorro todas las etapas hasta dar con la indicada
		for(AreaProductiva a : areasProductivas){
			a.liberarLinea(idLineaProd);
		}		
	}

	public void asignarDepositoLibre(Lote lote) {
		int aux = 0;
		boolean asignado = false;
		while (asignado == false){
			Almacenamiento a = this.almacenamiento.get(aux);
			if(a.isLibre() == true){
				a.setLibre(false);
				a.setLote(lote);
				asignado = true;
				lote.setUbicacion(a);				AlmacenamientoDAO.getInstance().actualizarAlmacenamiento(a);				LoteDAO.actualizarLote(lote);				
			}
			aux++;
		}	
	}
	
	public boolean tengoStock(Pedido p){
		boolean haystock = true;
		List <Prenda> aProducir = new Vector<Prenda>();
		//Recorro todos los items pedidos
		for(ItemPedido i : p.getItems()){
			//Busco la prenda en la base
			Prenda prendaPersistida = PrendaDAO.getInstance().obtenerPrenda(i.getPrenda().getIdPrenda());		
			//si la cantidad pedida es mayor al stock que tengo
			if(i.getCantidad() > prendaPersistida.getStock().getCantidad() ){
				haystock = false;
				//Agrego la prenda de la que falta stock al vector
				aProducir.add(prendaPersistida);
				}
			}
		
		/* Al salir del for, voy a tener un vector con prendas a producir
		 * en caso de que me falte stock de alguna prenda.
		 * caso contrario, solamente devuelvo el booleano
		 */
		
		//si el arreglo NO esta vacio
		if (!aProducir.isEmpty()){
			this.generarOrdenes(aProducir, p);
		}
		// devuelvo si hay stock o no
		return haystock;
	}
	
	private void generarOrdenes(List<Prenda> aProducir, Pedido p) {
		List<Prenda> listaprendas = new Vector <Prenda>();
		List<Prenda> arregloAux = new Vector <Prenda>();
		//Recorro la lista de prendas que me envian
		for(Prenda prenda : aProducir){
			int cantAProd = 0;
			//levanto todas las prendas de la base que matcheen con la descripcion
			listaprendas = PrendaDAO.getInstance().obtenerPrendasPorDescripcion(prenda.getDescripcion());
			/* Para cada prenda que tenga esa descripcion, verifico si el stock que tiene
			 * esta por debajo del minimo para mandar a producir
			 * A diferencia de la funcion "TengoStock" esta verifica
			 * todos los talles y colores de esa prenda
			 */				
			//Recorro todas las prendas que matchean con la descripcion
			for (Prenda prendaaux : listaprendas){
				//verifico que la cantidad a producir sea mayor al stock
				if(prendaaux.getCantProducir() > prendaaux.getStock().getCantidad()){
					cantAProd++;
					arregloAux.add(prendaaux);
				}
			}			
			/*
			 * Al terminar de recorrer el for, si la cant a producir es mayor a 3			 * genero una orden de produccion total, caso contrario hago una parcial
			 */
			if(cantAProd < 3){
				this.GenerarOrdenProdParcial(arregloAux,p);
			} else{
				this.GenerarOrdenProdCompleta(listaprendas,p);
			}	
		}	
		//Aca termine de recorrer todas las prendas que me envian para producir del pedido	
	}

	private void GenerarOrdenProdCompleta(List<Prenda> listaprendas, Pedido p) {
		//Genero orden de produccion y asigno variables basicas
		OrdenDeProduccion op = new OrdenDeProduccion();
		op.setFecha(p.getFechaGeneracion());
		op.setPedido(p);
		op.setTipo("Completa");
		op.setPrenda(listaprendas);
		List<Material> materiales = new Vector<Material>();	
		//Para cada prenda que voy a producir
		for(Prenda prenda : listaprendas){
			//para cada material por prenda
			for(MaterialPorPrenda m : prenda.getMateriales()){
				//Agrego el material a la lista
				materiales.add(m.getMaterial());
				//Agrego el precio. El precio se compone de:
				//costo que ya tenia + costo de material * cantida de material * cantidad de prendas  
				op.setPrecioProd(op.getPrecioProd()+(m.getMaterial().getCosto()*m.getCantidad()*prenda.getCantProducir()));				
			}
			//Genero un lote nuevo con cada una de las prendas
			Lote nuevo = new Lote();
			nuevo.setPrenda(prenda);
			nuevo.setActivo(true);
			nuevo.setOrdenDeProduccion(op);
			nuevo.setProceso(0);
			nuevo.setEstado("Nuevo");
			nuevo.AsignarAreaProd();						LoteDAO.guardarLote(nuevo);
		}	
	}

	private void GenerarOrdenProdParcial(List<Prenda> listaprendas, Pedido p) {
		//Genero orden de produccion y asigno variables basicas
		OrdenDeProduccion op = new OrdenDeProduccion();
		op.setFecha(p.getFechaGeneracion());
		op.setPedido(p);
		op.setTipo("Parcial");
		op.setPrenda(listaprendas);
		List<Material> materiales = new Vector<Material>();	
		//Para cada prenda que voy a producir
		for(Prenda prenda : listaprendas){
			//para cada material por prenda
			for(MaterialPorPrenda m : prenda.getMateriales()){
				//Agrego el material a la lista
				materiales.add(m.getMaterial());
				//Agrego el precio. El precio se compone de:
				//costo que ya tenia + costo de material * cantida de material * cantidad de prendas  
				op.setPrecioProd(op.getPrecioProd()+(m.getMaterial().getCosto()*m.getCantidad()*prenda.getCantProducir()));
			}
			//Genero un lote nuevo con cada una de las prendas
			Lote nuevo = new Lote();
			nuevo.setPrenda(prenda);
			nuevo.setActivo(true);
			nuevo.setOrdenDeProduccion(op);
			nuevo.setProceso(0);
			nuevo.setEstado("Nuevo");
						//Esta funciona arranca la produccion del lote			nuevo.AsignarAreaProd();						LoteDAO.guardarLote(nuevo);						
		}				OrdenDeProdDAO.guardarOP(op);		
	}
		public void agregarPrenda(PrendaDTO prenda){
		Prenda p=new Prenda();
		p.setDescripcion(prenda.getDescripcion());
		p.setColor(prenda.getColor());
		p.setTalle(prenda.getTalle());
		p.setTemporada(prenda.getTemporada());
		p.setCantProducir(prenda.getCantProducir());
		p.setPrecioVenta(prenda.getPrecioVenta());
		p.setActivo(true);
		List<MaterialporPrendaDTO> lmdto=prenda.getMateriales();
		List<MaterialPorPrenda> lmpp=new ArrayList<MaterialPorPrenda>();
		for(MaterialporPrendaDTO mdto:lmdto){
			MaterialPorPrenda mpp=new MaterialPorPrenda();						
			Material m=new Material();
			m.setIdMaterial(mdto.getMaterial().getIdMaterial());
			m.setNombre(mdto.getMaterial().getNombre());
			m.setCosto(mdto.getMaterial().getCosto());
			m.setCantDisponible(mdto.getMaterial().getCantDisponible());
			m.setCantReservada(mdto.getMaterial().getCantReservada());
			m.setProveedor(mdto.getMaterial().getProveedor());				
			mpp.setMaterial(m);
			mpp.setCantidad(mdto.getCantidad());
			mpp.setDesperdicio(mdto.getDesperdicio());
			lmpp.add(mpp);			
		}
		p.setMateriales(lmpp);	
		PrendaDAO.getInstance().agregarPrenda(p);
	}	public Integer obtenerStock(Integer idPrenda) {		return PrendaDAO.getInstance().obtenerPrenda(idPrenda).getStock().getCantidad();			}
}
