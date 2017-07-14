package controlador;
import java.util.ArrayList;import java.util.List;import java.util.Vector;import dao.AlmacenamientoDAO;import dao.AreaProductivaDAO;import dao.EmpleadoDAO;import dao.LineaProductivaDAO;import dao.LoteDAO;import dao.MaterialDAO;import dao.MaterialPorPrendaDAO;import dao.OrdenDeProdDAO;import dao.PrendaDAO;import dao.PrendaVentaDAO;import dto.AreaProductivaDTO;import dto.EmpleadoDTO;import dto.LineaProductivaDTO;import dto.LoteDTO;import dto.MaterialDTO;import dto.MaterialporPrendaDTO;import dto.OrdenDeProduccionDTO;import dto.PrendaDTO;import entities.AreaProductivaEntity;import entities.LineaProductivaEntity;import negocio.*;
import java.util.ArrayList;import java.util.Calendar;import java.util.List;import java.util.Vector;import dao.AlmacenamientoDAO;import dao.AreaProductivaDAO;import dao.LineaProductivaDAO;import dao.LoteDAO;import dao.MaterialDAO;import dao.MaterialPorPrendaDAO;import dao.OrdenDeProdDAO;import dao.PrendaDAO;import dto.AreaProductivaDTO;import dto.LineaProductivaDTO;import dto.LoteDTO;import dto.MaterialDTO;import dto.MaterialporPrendaDTO;import dto.PrendaDTO;import entities.AreaProductivaEntity;import entities.LineaProductivaEntity;import entities.OrdenDeProduccionEntity;import entities.PrendaCantidad;import negocio.*;
public class ControladorProduccion {
	private List<OrdenDeProduccion> ordenesDeProduccion;	private List<Prenda> prendas;	private List<Lote> lotes;	private List<OrdenModificacion> ordendesDeModificacion;	private List<AreaProductiva> areasProductivas;	private List<EtapaProductiva> etapasProductivas;	private List<Almacenamiento> almacenamiento;		private static ControladorProduccion instancia;
	public static ControladorProduccion getInstancia(){		if(instancia==null){			instancia=new ControladorProduccion();		}		return instancia;	}	//Me notifican que termino una linea de prod	public void liberarArea(int idLineaProd){		//recorro todas las etapas hasta dar con la indicada		LineaProductiva aux = LineaProductivaDAO.getInstancia().obtenerLinea(idLineaProd);		aux.setEstado("Libre");		LineaProductivaDAO.getInstancia().actualizarLinea(aux);	}
	public void asignarDepositoLibre(Lote lote) {		int aux = 0;		boolean asignado = false;		while (asignado == false){			Almacenamiento a = this.almacenamiento.get(aux);			if(a.isLibre() == true){				a.setLibre(false);				asignado = true;				lote.setUbicacion(a);				AlmacenamientoDAO.getInstance().actualizarAlmacenamiento(a);				LoteDAO.getInstancia().actualizarLote(lote);			}			aux++;		}		}
	public boolean tengoStock(Pedido p){		boolean haystock = true;		List<PrendaCantidad> prendasAProducir=new ArrayList<PrendaCantidad>();				//Recorro todos los items pedidos		for(ItemPedido i : p.getItems()){						//Busco la prenda en la base			Prenda prendaPersistida = PrendaDAO.getInstance().obtenerPrenda(i.getPrenda().getIdPrenda());					System.out.println("Cantidad pedida de "+i.getPrenda().getDescripcion()+" "+i.getCantidad() );			//si la cantidad pedida es mayor al stock que tengo			if(i.getCantidad() > prendaPersistida.getStock().getCantidad() ){				System.out.println(prendaPersistida.getDescripcion() + "Stock: "+prendaPersistida.getStock().getCantidad());				haystock = false;				//Agrego la prenda de la que falta stock al vector				PrendaCantidad prendaAproducir=new PrendaCantidad(prendaPersistida, i.getCantidad()-prendaPersistida.getStock().getCantidad());				prendasAProducir.add(prendaAproducir);				}			}		/* Al salir del for, voy a tener un vector con prendas a producir		 * en caso de que me falte stock de alguna prenda.		 * caso contrario, solamente devuelvo el booleano		 */		//si el arreglo NO esta vacio		if (!prendasAProducir.isEmpty()){			this.generarOrdenes(prendasAProducir, p);		}		// devuelvo si hay stock o no		return haystock;	}	private void generarOrdenes(List<PrendaCantidad> aProducir, Pedido p) {		List<Prenda> listaPrendasConMismaDescripcion = new ArrayList<Prenda>();		List<PrendaCantidad> prendasAProducir=new ArrayList<PrendaCantidad>();		int cantPrendasIgualesAProducir = 0;				//Recorro la lista de prendas que me envian		for(PrendaCantidad prenda : aProducir){			System.out.println("Prenda a producir: "+prenda.getPrenda().getDescripcion()+" - Cantidad Solicitada: "+					prenda.getCantidadAProducir());									//levanto todas las prendas de la base que matcheen con la descripcion			listaPrendasConMismaDescripcion = PrendaDAO.getInstance().obtenerPrendasPorDescripcion(prenda.getPrenda().getDescripcion());			/* Para cada prenda que tenga esa descripcion, verifico si el stock que tiene			 * esta por debajo del minimo para mandar a producir			 * A diferencia de la funcion "TengoStock" esta verifica			 * todos los talles y colores de esa prenda			 */							System.out.println("Prendas con la misma descripcion: "+listaPrendasConMismaDescripcion.size());
			//Recorro todas las prendas que matchean con la descripcion			for (Prenda prendaaux : listaPrendasConMismaDescripcion){								//verifico que la cantidad a producir sea mayor al stock				if(prenda.getCantidadAProducir() > prendaaux.getStock().getCantidad()){					System.out.println("Prenda a producir con la misma descripcion: "+prendaaux.getDescripcion());					cantPrendasIgualesAProducir++;					PrendaCantidad pc=new PrendaCantidad(prendaaux, prenda.getCantidadAProducir()-prendaaux.getStock().getCantidad());					prendasAProducir.add(pc);					//System.out.println(cantAProd);				}			}						/*			 * Al terminar de recorrer el for, si la cant a producir es mayor a 3			 * genero una orden de produccion total, caso contrario hago una parcial			 */			}			//Aca termine de recorrer todas las prendas que me envian para producir del pedido					System.out.println("Cantidad de prendas iguales a producir: "+cantPrendasIgualesAProducir);		if(cantPrendasIgualesAProducir <= 3){			this.GenerarOrdenProdParcial(prendasAProducir,p);		} else{			this.GenerarOrdenProdCompleta(prendasAProducir,p);		}			}	private void GenerarOrdenProdCompleta(List<PrendaCantidad> listaprendas, Pedido p) {		List <Prenda> opPrendas=new ArrayList<Prenda>();		for(PrendaCantidad pc:listaprendas) {			opPrendas.add(pc.getPrenda());		};		//Genero orden de produccion y asigno variables basicas		OrdenDeProduccion op = new OrdenDeProduccion();		op.setFecha(Calendar.getInstance().getTime().toString());		op.setPedido(p);		op.setTipo("Completa");		op.setPrenda(opPrendas);		op.setActivo(true);				//Para cada prenda que voy a producir		for(PrendaCantidad prenda : listaprendas){						//Genero un lote nuevo con cada una de las prendas			Lote nuevo = new Lote();			nuevo.setPrenda(prenda.getPrenda());			nuevo.setActivo(true);			nuevo.setOrdenDeProduccion(op);			nuevo.setProceso(0);						//Verifico que haya stock de materiales para producir prenda			if(ControladorCompra.getInstancia().listoParaProducir(prenda.getPrenda())){								//Si hay stock empiezo a producir				nuevo.setEstado("Nuevo");				//nuevo.AsignarAreaProd();				ControladorCompra.getInstancia().reservarMateriales(prenda.getPrenda());							}else {				//si no hay stock, genero orden de compra				ControladorCompra.getInstancia().generarOrdenCompra(prenda.getPrenda(), op);				nuevo.setEstado("Pendiente compra Materiales");			}						int aux = LoteDAO.getInstancia().guardarLote(nuevo);			Lote nuevo2 = LoteDAO.getInstancia().obtenerLote(aux);			nuevo2.setOrdenDeProduccion(op);			LoteDAO.getInstancia().actualizarLote(nuevo2);		}			OrdenDeProdDAO.getInstancia().guardarOP(op);		//Aca termine de recorrer todas las prendas que me envian para producir del pedido		}	private void GenerarOrdenProdParcial(List<PrendaCantidad> listaprendas, Pedido p) {		List <MaterialPorPrenda> lmpp=new ArrayList<MaterialPorPrenda>();		List <Prenda> opPrendas=new ArrayList<Prenda>();		for(PrendaCantidad pc:listaprendas) {			opPrendas.add(pc.getPrenda());		};		//Genero orden de produccion y asigno variables basicas		OrdenDeProduccion op = new OrdenDeProduccion();		op.setFecha(p.getFechaGeneracion());		op.setPedido(p);		op.setTipo("Parcial");		op.setPrenda(opPrendas);		op.setActivo(true);				float costoOrdenProduccion=0;				System.out.println("Tipo de orden de produccion - Generar Orden Produccion Parcial: "+op.getTipo());		Integer idOrdenDeProd=OrdenDeProdDAO.getInstancia().guardarOP(op);		op=OrdenDeProdDAO.getInstancia().obtenerOP(idOrdenDeProd);				System.out.println("Tipo de orden de produccion - Recuperar Orden de Produccion: "+op.getTipo());				List<Lote> lotesAProducir=new ArrayList<Lote>();				//Para cada prenda que voy a producir				for(PrendaCantidad prenda : listaprendas){					float costoPorPrenda=0;					System.out.println(prenda.getPrenda().getDescripcion());					//Genero un lote nuevo con cada una de las prendas					Lote nuevo = new Lote();					nuevo.setPrenda(prenda.getPrenda());					nuevo.setActivo(true);					nuevo.setOrdenDeProduccion(op);					nuevo.setProceso(0);					Integer idLote=LoteDAO.getInstancia().guardarLote(nuevo);					nuevo=LoteDAO.getInstancia().obtenerLote(idLote);					System.out.println(nuevo.getPrenda().getDescripcion());									//Verifico que haya stock de materiales para producir prenda					if(ControladorCompra.getInstancia().listoParaProducir(prenda.getPrenda())){												//Si hay stock empiezo a producir						nuevo.setEstado("Nuevo");						this.AsignarAreaProd(nuevo);						//ControladorCompra.getInstancia().reservarMateriales(prenda);											}else {						//si no hay stock, genero orden de compra						ControladorCompra.getInstancia().generarOrdenCompra(prenda.getPrenda(),op);						nuevo.setEstado("Pendiente compra Materiales");					}					lotesAProducir.add(nuevo);										//SACO EL COSTO DE PRODUCCION										lmpp=prenda.getPrenda().getMateriales();					for(MaterialPorPrenda mpp:lmpp) {						System.out.println("Costo del material: "+mpp.getMaterial().getCosto());						float costoMaterial=mpp.getMaterial().getCosto()*mpp.getCantidad();						costoPorPrenda=costoPorPrenda+costoMaterial;											}					costoOrdenProduccion=costoOrdenProduccion+(costoPorPrenda*prenda.getCantidadAProducir());					nuevo.setCostoProd(costoPorPrenda*prenda.getCantidadAProducir());										LoteDAO.getInstancia().actualizarLote(nuevo);				}					op.setLotes(lotesAProducir);				op.setPrecioProd(costoOrdenProduccion);				OrdenDeProdDAO.getInstancia().actualizarOP(op);				//Aca termine de recorrer todas las prendas que me envian para producir del pedido							}		public void agregarPrenda(PrendaDTO prenda){
		Prenda p=new Prenda();		p.setDescripcion(prenda.getDescripcion());		p.setColor(prenda.getColor());		p.setTalle(prenda.getTalle());		p.setTemporada(prenda.getTemporada());		p.setCantProducir(prenda.getCantProducir());		p.setPrecioVenta(prenda.getPrecioVenta());		p.setActivo(true);		PrendaDAO.getInstance().agregarPrenda(p);				for(MaterialporPrendaDTO mdto:prenda.getMateriales()){			MaterialPorPrenda mpp = new MaterialPorPrenda();			mpp.setActivo(true);			mpp.setCantidad(mdto.getCantidad());			mpp.setDesperdicio(mdto.getDesperdicio());			mpp.setMaterial(MaterialDAO.getInstancia().recuperarMaterial(mpp.getMaterial().getIdMaterial()));						MaterialPorPrendaDAO.getInstance().guardarMaterialPorPrenda(mpp);								}
	}		public void agregarAreaProductiva(AreaProductivaDTO area){		AreaProductiva aaux = new AreaProductiva();		aaux.setActivo(true);		aaux.setIdAreaProductiva(area.getIdAreaProductiva());		aaux.setNombre(area.getNombre());			AreaProductivaDAO.getInstancia().grabarAreaProductiva(aaux);	}		public AreaProductivaDTO listarAreasProductivas(){		return null;	}	public Integer obtenerStock(Integer idPrenda) {		return PrendaDAO.getInstance().obtenerPrenda(idPrenda).getStock().getCantidad();	}	public int backlog() {		int aux = 0; 		for(AreaProductiva a : AreaProductivaDAO.getInstancia().listarAreaProductiva()){			aux = aux + a.getLotesPendientes().size();		}				return aux*7;	}			public List<PrendaDTO> listarPrendas(){		List<PrendaDTO> aux = new ArrayList<PrendaDTO>();		List<Prenda> lstPrendas=PrendaDAO.getInstance().listarPrendas();		for(Prenda p:lstPrendas){			PrendaDTO pdto=p.toDTO();			aux.add(pdto);		}					return aux;	}		public List<OrdenDeProduccionDTO> listarOrdenesDeProduccion(){		List<OrdenDeProduccionDTO> lopdto=new ArrayList<OrdenDeProduccionDTO>();		for(OrdenDeProduccion op:OrdenDeProdDAO.getInstancia().listarOrdenDeProduccion()) {			System.out.println(op.getIdOrdenDeProduccion());			lopdto.add(op.toDTO());		}		return lopdto;	}			public void AsignarAreaProd(Lote l){		//voy a la prenda a buscar el proceso productivo, y trato de asignarle una linea			System.out.println("Ingreso a Asignar Area de Produccion");		System.out.println(l.getPrenda().getDescripcion());		List<EtapaProductiva> lep=l.getPrenda().getEtapaProd();		System.out.println("Pase el get etapa productiva");		for(EtapaProductiva ep:lep) {			if(ep.getOrden()==l.getProceso()) {				AreaProductiva ap=ep.getAreaProductiva();				System.out.println("Prenda: "+l.getPrenda().getDescripcion()+" Area Productiva: "+ap.getNombre());				List<LineaProductiva> llp=ap.getLineas();				System.out.println("Paso el get lineas productivas");				for(LineaProductiva lp:llp) {					System.out.println("Linea Productiva: "+lp.getIdLinea());					if(lp.getEstado().equals("Libre")) {						//lp.setLote(l);						lp.setEstado("Ocupado");						LineaProductivaDAO.getInstancia().actualizarLinea(lp);						System.out.println("Actualizo la linea de Produccion");						l.setEstado("Produccion");						break;					}else {						l.setEstado("Pendiente linea de produccion");						ap.getLotesPendientes().add(l);					}				}							}		}				LoteDAO.getInstancia().actualizarLote(l);	}	/*	public void ContinuarProduccion(Integer idLote){		Lote l = LoteDAO.getInstancia().obtenerLote(idLote);		l.seguirProximaEtapa();	}		public void Finalizado(){		this.setEstado("Finalizado");		LoteDAO.getInstancia().actualizarLote(this);	}		public void LiberarAlmacenamiento(){		this.getUbicacion().setLibre(true);		AlmacenamientoDAO.getInstance().actualizarAlmacenamiento(this.getUbicacion());	}		public void seguirProximaEtapa() {		//Si todavia no termino de confeccionar la prenda		if(this.getPrenda().getEtapaProd().size()>this.proceso){			//sumo 1 al proceso			this.proceso++;			//busco una linea libre dentro del area correspondiente			this.AsignarAreaProd();		//si termine de confeccionarlo		}else{			//Cambio el estado, asigno la cantidad que produci			this.setEstado("Confeccionado");			this.setCantidadProducida(prenda.getCantProducir());			this.setCantidadRestante(this.cantidadProducida);			int aux = 0;			//actualizo stock			this.prenda.getStock().agregarStock(this.cantidadProducida);			//genero los prenda Venta			while(aux < this.cantidadProducida){				PrendaVenta pv = new PrendaVenta("Disponible", this, true);				this.prenda.getStock().getPrendasVenta().add(pv);				PrendaVentaDAO.getInstancia().grabarPrendaVenta(pv);							}			//notifico a la orden de produccion			this.ordenDeProduccion.prendaFinalizada(this.prenda);			//le asigno un lugar en el deposito			ControladorProduccion.getInstancia().asignarDepositoLibre(this);		}				LoteDAO.getInstancia().actualizarLote(this);			}		public boolean asignarLinea(Lote lote) {		boolean asignado = false;		int aux = 0;		List <LineaProductiva> l = LineaProductivaDAO.getInstancia().getLineas();		//mientras no este asignado, recorro el vector de lineas		while(asignado == false && l.size() < aux)		{			//Encuentro una linea libre			if(l.get(aux).getEstado()=="Libre"){				// Asigno el lote a la linea, cambio estado				l.get(aux).setEstado("Ocupado");				asignado = true;				l.get(aux).setLote(lote);				LineaProductivaDAO.getInstancia().actualizarLinea(l.get(aux));			} 			//linea no estaba libre, sigo buscando			else{				aux++;			}		}		//si no habia lineas libres, agrego el lote a los pendientes		if(asignado==false){			this.lotesPendientes.add(lote);			AreaProductivaDAO.getInstancia().actualizarArea(this);		}				return asignado;			}	public void liberarLinea(Integer idLineaProd) {		LineaProductiva l = LineaProductivaDAO.getInstancia().obtenerLinea(idLineaProd);		//Cambio estado		l.setEstado("Libre");		//aviso al lote que siga con la proxima etapa		l.getLote().seguirProximaEtapa();		//si tengo lote pendiente, lo ubico		if(!this.getLotesPendientes().isEmpty()){			Lote aux = this.getLotesPendientes().get(0);			this.getLotesPendientes().remove(aux);			l.setLote(aux);			l.setEstado("Ocupado");			aux.setEstado("Produccion");			LoteDAO.getInstancia().actualizarLote(aux);		}		LineaProductivaDAO.getInstancia().actualizarLinea(l);	}			public void prendaFinalizada(Prenda prenda) {		// una vez que se termina de generar el lote, el lote me avisa por medio de este metodo		// que la prenda ya esta en stock y disponible			}									}*/
}
