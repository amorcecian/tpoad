package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import businessDelegate.BusinessDelegate;
import dto.AlmacenamientoDTO;
import dto.ClienteDTO;
import dto.EmpleadoDTO;
import dto.ItemPedidoDTO;
import dto.OrdenDeProduccionDTO;
import dto.PedidoDTO;
import dto.PrendaDTO;
import exceptions.ExceptionCliente;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
    	String jspPage = "/index.jsp";
    	
    	switch(action){
    		
        	case("login"):{
        		HttpSession session=request.getSession(); 
	            String usuario = request.getParameter("usuario");
	            String contraseña = request.getParameter("contraseña");
	            int idCliente=BusinessDelegate.getInstancia().validarCliente(usuario, contraseña);
	            if(idCliente!=0){
	            	try {
	            		ClienteDTO cliente=BusinessDelegate.getInstancia().recuperarCliente(idCliente);
	            		session.setAttribute("nombreCLiente", cliente.getNombre());
	            	}catch(Exception e) {
	            		e.printStackTrace();
	            	}           		            	 
	                session.setAttribute("usuario",usuario); 
	                session.setAttribute("idCliente",idCliente); 
	                session.setAttribute("cliente", 1);
	                jspPage = "/index.jsp";  
	            }else {
	            	jspPage = "/error.jsp";
	            }
	            
	            break;
        	}
        	
        	case("loginEmpleados"):{  
        		HttpSession session=request.getSession();
	            String usuario = request.getParameter("usuario");
	            String contraseña = request.getParameter("contraseña");
	            int idEmpleado=BusinessDelegate.getInstancia().validarEmpleado(usuario, contraseña);
	            if(idEmpleado!=0){	            	
	            	EmpleadoDTO empleado=BusinessDelegate.getInstancia().recuperarEmpleado(idEmpleado);
	            	session.setAttribute("nombreUsuario", empleado.getNombre());
	                session.setAttribute("usuario",usuario); 
	                session.setAttribute("idEmpleado",idEmpleado);
	                session.setAttribute("area", empleado.getArea());
	            	jspPage = "/backend.jsp"; 
	            }else {
	            	jspPage = "/error.jsp";
	            }
	            
	            break;
        	}
        	case("CargarPedido"):{
        		List<PrendaDTO> lpdto=BusinessDelegate.getInstancia().listarPrendas();
        		List<ItemPedidoDTO> lipdto=new ArrayList<ItemPedidoDTO>();
        		HttpSession session=request.getSession(false);
        		Integer idCliente=(Integer)session.getAttribute("idCliente");  
        		float valor=0;
        		for(PrendaDTO pdto:lpdto) {
        			if(request.getParameter("cantidadPrenda"+pdto.getIdPrenda())!="") {
            			int cantidad=Integer.parseInt(request.getParameter("cantidadPrenda"+pdto.getIdPrenda()));
            			if(cantidad>0) {
            				ItemPedidoDTO ipdto=new ItemPedidoDTO();
            				ipdto.setCantidad(cantidad);
            				ipdto.setActivo(true);
            				ipdto.setPrenda(pdto);
            				ipdto.setEstado("Pendiente");
            				valor=valor+pdto.getPrecioVenta();
            				lipdto.add(ipdto);
            			}        				
        			}
        		}
        		if(lipdto!=null) {
        			try {
    				ClienteDTO cli;					
					cli = BusinessDelegate.getInstancia().recuperarCliente(idCliente);
        			Date date = new Date();
        			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        			dateFormat.format(date);        			
        			String fechaGeneracion=dateFormat.format(date);       			        			
        			
        			PedidoDTO p=new PedidoDTO(lipdto,fechaGeneracion,null,null,valor,cli,cli.getSucursal(),"Para Aprobar",null,true); 
        			
        			BusinessDelegate.getInstancia().generarPedido(p);     			       			
        			} catch (Exception e) {
						e.printStackTrace();
					}      					       			
        		}
        		jspPage = "/index.jsp";
	            break;
        	}
        	case("AprobarPedido"):{
	            Integer idPedido =Integer.parseInt(request.getParameter("idPedido"));
	            PedidoDTO pdto=BusinessDelegate.getInstancia().obtenerPedido(idPedido);
	            Integer idCliente=pdto.getCliente().getIdCliente();
	            try {
	            	if(pdto.getValor()<=BusinessDelegate.getInstancia().chequearCredito(idCliente)) {
						BusinessDelegate.getInstancia().aprobarPedido(idPedido);	            
						pdto=BusinessDelegate.getInstancia().obtenerPedido(idPedido);
						if(pdto.getFechaEstDespacho()!=null){ 			            	
			            	jspPage = "/backend.jsp";
			            }else {
			            	jspPage = "/error.jsp";
			            }		            						
					}else {
						jspPage = "/backend.jsp";
						System.out.println("El cliente no tiene saldo");
					}
				} catch (ExceptionCliente e) {
					e.printStackTrace();
				}
	            
	            break;
        	}
        	case("verPedido"):{        		
                Integer idPedido = Integer.parseInt(request.getParameter("id"));
                PedidoDTO pdto = BusinessDelegate.getInstancia().obtenerPedido(idPedido);
                request.setAttribute("pedido", pdto);
                jspPage = "/verPedido.jsp";               
	            break;
        	}
        	case("verPedidoCliente"):{        		
                Integer idPedido = Integer.parseInt(request.getParameter("id"));
                PedidoDTO pdto = BusinessDelegate.getInstancia().obtenerPedido(idPedido);
                request.setAttribute("pedido", pdto);
                jspPage = "/verPedidoCliente.jsp";               
	            break;
        	}
        	case("avanzarEtapa"):{        		
                Integer idLote = Integer.parseInt(request.getParameter("idLote"));
                BusinessDelegate.getInstancia().ContinuarProduccion(idLote);
                jspPage = "/avanzarEtapa.jsp";               
	            break;
        	}
        	case("verOP"):{        		
                Integer idOP = Integer.parseInt(request.getParameter("idOP"));
                OrdenDeProduccionDTO opdto = BusinessDelegate.getInstancia().obtenerOP(idOP);
                request.setAttribute("op", opdto);
                jspPage = "/verOP.jsp";               
	            break;
        	} 
        	case("verAlmacenamiento"):{        		
                Integer idAlmacenamiento = Integer.parseInt(request.getParameter("idAlmacenamiento"));
                AlmacenamientoDTO adto = BusinessDelegate.getInstancia().recuperarAlmacenamiento(idAlmacenamiento);
                request.setAttribute("almacenamiento", adto);
                jspPage = "/verAlmacenamiento.jsp";               
	            break;
        	} 
        	case("recibirMercaderia"):{        		
                Integer idOC = Integer.parseInt(request.getParameter("idOC"));
                BusinessDelegate.getInstancia().OrdenCompraCompleta(idOC);               
                jspPage = "/recepcionMercaderia.jsp";               
	            break;
        	} 
        	
        	
        	
        	
        	
        	case("logout"):{  
        		request.getSession().invalidate();
                jspPage = "/login.jsp";               
	            break;
        	}
    	}  
    	dispatch(jspPage, request, response);
	}
	
    protected void dispatch(String jsp, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        if (jsp != null)
        {
        	/*EnvÌa el control al JSP que pasamos como par·metro, y con los 
        	 * request / response cargados con los par·metros */
            RequestDispatcher rd = request.getRequestDispatcher(jsp);
            rd.forward(request, response);
        }
    }

}
