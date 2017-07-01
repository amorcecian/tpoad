package dao;

import negocio.Cliente;
import negocio.CuentaCorriente;
import negocio.Sucursal;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dto.ClienteDTO;
import dto.SucursalDTO;
import entities.ClienteEntity;
import entities.CuentaCorrienteEntity;
import entities.SucursalEntity;
import exceptions.ExceptionCliente;
import hbt.HibernateUtil;


public class ClienteDAO {
	
	private static ClienteDAO instancia;
	private static SessionFactory sf;
	
	public static ClienteDAO getInstance(){
		if(instancia==null){
			instancia = new ClienteDAO();
			sf=HibernateUtil.getSessionFactory();
		}
			
		return instancia;
	}
	
	//AGREGAR UN CLIENTE A LA BASE DE DATOS
	public void grabarCliente(Cliente c) throws ExceptionCliente{		
		Session s = sf.openSession();
		try {			
			ClienteEntity ce = toEntity(c);
			s.save(ce);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			throw new ExceptionCliente();
		} finally{
			s.close();
		}

		
	}
	
	public void actualizarCliente(Cliente c) throws ExceptionCliente{		
		Session s = sf.openSession();
		try {
			
			ClienteEntity ce = toEntity(c);
			s.update(ce);
			s.flush();
			s.beginTransaction().commit();			
			
		} catch (HibernateException e) {
			e.printStackTrace();
			//throw new ExceptionCliente();
		} finally{
			s.close();
		}

		
	}
	
	//BORRAR LOGICAMENTE UN CLIENTE DE LA BASE DE DATOS
	public void eliminarCliente(Integer idCliente) throws RemoteException{	
		Session s=sf.openSession();
		Query q=s.createQuery("UPDATE ClienteEntity SET activo=0 WHERE idCliente=:idCliente");
		q.setParameter("idCliente",idCliente);
		q.executeUpdate();
		s.close();
	}
	
	//RECUPERAR UN CLIENTE DE LA BASE DE DATOS
	public Cliente recuperarCliente(Integer idCliente) throws ExceptionCliente{
		Cliente c=null;		
		Session s = sf.openSession();
		try {
			Query q = s.createQuery("FROM ClienteEntity WHERE idCliente=?").setInteger(0, idCliente);
			ClienteEntity ce = (ClienteEntity) q.uniqueResult();
			c = this.toNegocio(ce);
		} catch (HibernateException e) {
			throw new ExceptionCliente();
		}
		s.close();
		return c;
	}
	/*
	//AGREGAR UNA CUENTA CORRIENTE A UN CLIENTE
	public void agregarCuentaCorrienteCliente(Integer idCliente, CuentaCorriente cc){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		CuentaCorrienteEntity cce = cuentaCorrienteToEntity(cc);
		Query q = s.createQuery("UPDATE ClienteEntity SET CuentaCorrienteEntity=? WHERE idCliente=?").setInteger(1, idCliente).setEntity(0, cce);
		q.executeUpdate();
		s.close();
	}
	*/
	

	

	
	//CONVIERTO UNA CUENTA CORRIENTE A CUENTA CORRIENTE ENTITY
	public CuentaCorrienteEntity cuentaCorrienteToEntity(CuentaCorriente cc){
		CuentaCorrienteEntity cce = new CuentaCorrienteEntity(cc.getLimiteCredito(),
				cc.getCondicionPago(), cc.getSaldo(), cc.getValorConsignacion());
		return cce;
	}
	
	//Listar todos los clientes
	public List<ClienteDTO> listarClientes() throws ExceptionCliente{
		Session s = sf.openSession();
		List<ClienteDTO> lstclientes=new ArrayList<ClienteDTO>();
		List<ClienteEntity> lce=s.createQuery("FROM ClienteEntity WHERE activo=1").list();
		for(ClienteEntity ce:lce){
			ClienteDTO cdto=this.toNegocio(ce).toDTO();
			lstclientes.add(cdto);
		}
		s.flush();
		s.close();
		return lstclientes;			
	}
	
	//CONVIERTO UN CLIENTE EN UN CLIENTE ENTITY
	public ClienteEntity toEntity(Cliente c){
		ClienteEntity ce = new ClienteEntity();
		SucursalEntity sucursal = SucursalDAO.getInstancia().obtenerSucursalEntity(c.getSucursal().getIdSucursal());
		CuentaCorrienteEntity cce = cuentaCorrienteToEntity(c.getCuentaCorriente());
		ce.setIdCliente(c.getIdCliente());
		ce.setNombre(c.getNombre());
		ce.setDireccion(c.getDireccion());
		ce.setCondicion(c.getCondicion());
		ce.setSucursal(sucursal);
		ce.setCuentaCorriente(cce);
		ce.setactivo(c.isactivo());
		ce.setUsuario(c.getUsuario());
		ce.setContraseña(c.getContraseña());
		return ce;
	}
	
	public Cliente toNegocio(ClienteEntity cli){
		Cliente c=new Cliente();
		
		c.setIdCliente(cli.getIdCliente());
		c.setNombre(cli.getNombre());
		c.setDireccion(cli.getDireccion());
		c.setCondicion(cli.getCondicion());
		c.setactivo(cli.isactivo());
		
		CuentaCorriente cc=new CuentaCorriente();
		cc.setCondicionPago(cli.getCuentaCorriente().getCondicionPago());
		cc.setLimiteCredito(cli.getCuentaCorriente().getLimiteCredito());
		cc.setSaldo(cli.getCuentaCorriente().getSaldo());
		cc.setValorConsignacion(cli.getCuentaCorriente().getValorConsignacion());
		
		c.setCuentaCorriente(cc);
		
		Sucursal sucu=SucursalDAO.getInstancia().toNegocio(cli.getSucursal());
		c.setSucursal(sucu);
		c.setUsuario(cli.getUsuario());
		c.setContraseña(cli.getContraseña());
		//Falta Pedidos,Facturas
		return c;
	}


}
