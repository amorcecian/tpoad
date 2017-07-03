package servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import businessDelegate.BusinessDelegate;
import dto.ClienteDTO;
import dto.ItemPedidoDTO;
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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
    	String jspPage = "/index.jsp";
    	
    	switch(action){
    		
        	case("login"):{
        		
	            String usuario = request.getParameter("usuario");
	            String contraseña = request.getParameter("contraseña");
	            int idCliente=BusinessDelegate.getInstancia().validarCliente(usuario, contraseña);
	            if(idCliente!=0){
	            	
	            	HttpSession session=request.getSession();  
	                session.setAttribute("usuario",usuario); 
	                session.setAttribute("idCliente",idCliente); 
	            	response.sendRedirect("index.jsp");
	            }else {
	            	response.sendRedirect("error.jsp");
	            }
	            
	            break;
        	}
        	case("CargarPedido"):{
        		List<PrendaDTO> lpdto=BusinessDelegate.getInstancia().listarPrendas();
        		List<ItemPedidoDTO> lipdto=new ArrayList<ItemPedidoDTO>();
        		HttpSession session=request.getSession(false);
        		Integer idCliente=(Integer)session.getAttribute("idCliente");  
        		for(PrendaDTO pdto:lpdto) {
        			if(request.getParameter("cantidadPrenda"+pdto.getIdPrenda())!="") {
            			int cantidad=Integer.parseInt(request.getParameter("cantidadPrenda"+pdto.getIdPrenda()));
            			if(cantidad>0) {
            				ItemPedidoDTO ipdto=new ItemPedidoDTO();
            				ipdto.setCantidad(cantidad);
            				ipdto.setActivo(true);
            				ipdto.setPrenda(pdto);
            				ipdto.setEstado("Pendiente");
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
        			
        			
        			BusinessDelegate.getInstancia().generarPedido(lipdto, fechaGeneracion, idCliente, 
        					cli.getSucursal().getIdSucursal(), "Para Aprobar");
        			
					} catch (Exception e) {
						e.printStackTrace();
					}        					
        			
        		}else {
        			response.sendRedirect("index.jsp");
        		}

	            
	            break;
        	}
    	}  
		doGet(request, response);
	}

}
