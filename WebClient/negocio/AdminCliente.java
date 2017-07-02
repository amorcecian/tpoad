package negocio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class AdminCliente
{
	private List<Cliente> clientes;
	private static AdminCliente instancia;
	
	private AdminCliente()
	{
		clientes = new ArrayList<Cliente>();

        for (int i = 0; i < 10; i++)
        {
            clientes.add(new Cliente("Id_" + i,"Nombre_" + i, "Apellido_" + i, "Direccion_" + i));
        }
	}
	
	public static AdminCliente getInstancia()
	{
		if(instancia==null)
			instancia = new AdminCliente();
		return instancia;
	}
	
    public List<Cliente> getClientes()
    {
        return clientes;
    }

    public Cliente getCliente(String id)
    {
    	Cliente aux;
    	System.out.println(id);
    	for(Iterator<Cliente> i = clientes.iterator(); i.hasNext();)
    	{
    		aux = i.next();
    		if(aux.getId().equals(id))
    			return aux;
    	}
    	return new Cliente(id,null,null,null);
    }
    
    public void modificarCliente(String id, String nombre, String  apellido, String direccion)
    {
    	Cliente aux;
    	for(Iterator<Cliente> i = clientes.iterator(); i.hasNext();)
    	{
    		aux = i.next();
    		if(aux.getId().equals(id))
    		{
    			aux.setNombre(nombre);
    			aux.setApellido(apellido);
    			aux.setDireccion(direccion);
    		}	
    	}
    }
}
