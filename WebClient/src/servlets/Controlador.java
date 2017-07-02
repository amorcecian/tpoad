package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	            String contrase�a = request.getParameter("contrase�a");
	            System.out.println(usuario);
	            System.out.println(contrase�a);
	            System.out.println(BusinessDelegate.getInstancia().validarCliente(usuario, contrase�a));
	            /*
	            if(dni != null){
	            	NoRegularDTO nr = new NoRegularDTO(nombre, apellido, dni, direcciondelnoregular);
	            	BusinessDelegate.getInstance().agregarClienteNoRegular(nr);
	            	response.sendRedirect("./index.jsp");
	            }
	            */
	            
	           
	            
	            break;
        	}
    		
    	}	
    	
	}
	
    protected void dispatch(String jsp, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        if (jsp != null)
        {
        	/*Env�a el control al JSP que pasamos como par�metro, y con los 
        	 * request / response cargados con los par�metros */
            RequestDispatcher rd = request.getRequestDispatcher(jsp);
            rd.forward(request, response);
        }
    }

}
