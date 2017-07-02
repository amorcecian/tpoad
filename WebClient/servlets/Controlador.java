package servlets;


import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import businessDelegate.BusinessDelegate;
import negocio.AdminCliente;
import negocio.Cliente;


public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String jspPage = "/index.jsp";
		
        if ((action == null) || (action.length() < 1))
        {
            action = "default";
        }
        
        
        if ("default".equals(action))
        {
            jspPage = "/index.jsp";
        }
        else if ("login".equals(action))
        {
        	
        	String nombre=request.getParameter("nombre");
        	String contraseña=request.getParameter("contraseña");        	
        	if(BusinessDelegate.getInstancia().validarCliente(nombre, contraseña)){
        		jspPage = "/index.jsp";
        	}else{
        		jspPage = "/error.jsp";
        	}

            
        }
        else if ("displaylist".equals(action))
        {
            List<Cliente> clientes = AdminCliente.getInstancia().getClientes();
            request.setAttribute("clientes", clientes);
            jspPage = "/MostrarLista.jsp";
        }
        else if ("displaycustomer".equals(action))
        {
            String id = request.getParameter("id");
            Cliente cliente = AdminCliente.getInstancia().getCliente(id);
            request.setAttribute("cliente", cliente);

            jspPage = "/MostrarCliente.jsp";
        }
        else if ("editcustomer".equals(action))
        {
            String id = request.getParameter("id");
            Cliente cliente = AdminCliente.getInstancia().getCliente(id);
            request.setAttribute("cliente", cliente);

            jspPage = "/EditarCliente.jsp";            
        }
        else if ("modificarCliente".equals(action))
        {
            String id = request.getParameter("id");
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String direccion = request.getParameter("direccion");
            
            if(direccion != null){                                   
            	AdminCliente.getInstancia().modificarCliente(id, nombre, apellido, direccion);
            }
            List<Cliente> clientes = AdminCliente.getInstancia().getClientes();
            request.setAttribute("clientes", clientes);
            jspPage = "/MostrarLista.jsp";            
        }
        
        dispatch(jspPage, request, response);
	}
	
	
    protected void dispatch(String jsp, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        if (jsp != null)
        {
        	/*Envía el control al JSP que pasamos como parámetro, y con los 
        	 * request / response cargados con los parámetros */
            RequestDispatcher rd = request.getRequestDispatcher(jsp);
            rd.forward(request, response);
        }
    }

}
