package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import businessDelegate.BusinessDelegate;

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
	            
	            if(BusinessDelegate.getInstancia().validarCliente(usuario, contraseña)){
	            	
	            	response.sendRedirect("index.jsp");
	            }else {
	            	response.sendRedirect("error.jsp");
	            }
	            
	            break;
        	}
    	}  
		doGet(request, response);
	}

}
