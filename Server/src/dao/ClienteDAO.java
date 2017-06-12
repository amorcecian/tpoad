package dao;

import negocio.Cliente;
import negocio.CuentaCorriente;

import java.io.Serializable;
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
	
	public static ClienteDAO getInstance(){
		if(instancia==null)
			instancia = new ClienteDAO();
		return instancia;
	}
	
	//AGREGAR UN CLIENTE A LA BASE DE DATOS
	public void grabarCliente(Cliente c) throws ExceptionCliente{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		try {			
			ClienteEntity ce = clienteToEntity(c);
			s.save(ce);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			throw new ExceptionCliente();
		} finally{
			s.close();
		}

		
	}
	
	public void actualizarCliente(Cliente c) throws ExceptionCliente{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		try {
			
			ClienteEntity ce = clienteToEntity(c);
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
	public void eliminarCliente(Cliente cliente) throws ExceptionCliente{
		ClienteEntity ce = clienteToEntity(cliente);
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		try {
			Query q = s.createQuery("UPDATE ClienteEntity SET activo=? WHERE idCliente=?").setParameter(0,false);
			q.setInteger(1, ce.getIdCliente());
			//Query q1 = s.createQuery("delete from ClienteEntity WHERE idCliente=?").setInteger(0, ce.getIdCliente());
			s.beginTransaction().begin();
			q.executeUpdate();
			//q1.executeUpdate();
			s.beginTransaction().commit();
		} catch (HibernateException e) {
			throw new ExceptionCliente();
		}
		s.close();
	}
	
	//RECUPERAR UN CLIENTE DE LA BASE DE DATOS
	public Cliente recuperarCliente(Integer idCliente) throws ExceptionCliente{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		Cliente c = new Cliente();

		try {
			Query q = s.createQuery("FROM ClienteEntity WHERE idCliente=?").setInteger(0, idCliente);
			ClienteEntity ce = (ClienteEntity) q.uniqueResult();
			c = new Cliente(ce);
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
	
	//CONVIERTO UN CLIENTE EN UN CLIENTE ENTITY
	public ClienteEntity clienteToEntity(Cliente c){
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
		return ce;
	}
	
	//CONVIERTO UNA CUENTA CORRIENTE A CUENTA CORRIENTE ENTITY
	public CuentaCorrienteEntity cuentaCorrienteToEntity(CuentaCorriente cc){
		CuentaCorrienteEntity cce = new CuentaCorrienteEntity(cc.getLimiteCredito(),
				cc.getCondicionPago(), cc.getSaldo(), cc.getValorConsignacion());
		return cce;
	}
	
	//Listar todos los clientes
	@SuppressWarnings("finally")
	public List<ClienteDTO> listarClientes() throws ExceptionCliente{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		List<ClienteDTO> listaclientes=new Vector<ClienteDTO>();
		try {
			@SuppressWarnings("unchecked")
			List<ClienteEntity> list=s.createQuery("from ClienteEntity").list();
			
			for(ClienteEntity cliente:list){
				ClienteDTO aux =new ClienteDTO();
				aux = cliente.toDTO();
				listaclientes.add(aux);
			}
			
		} catch (HibernateException e) {
			e.printStackTrace();
			//throw new ExceptionCliente();
		} finally{
			s.close();
			return listaclientes;
		}
	
		
	}

}
