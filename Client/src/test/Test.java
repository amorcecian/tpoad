package test;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import dto.ClienteDTO;
import dto.EmpleadoDTO;
import dto.MaterialDTO;
import dto.PedidoDTO;
import dto.PrendaDTO;
import dto.SucursalDTO;
import exceptions.ExceptionCliente;
import businessDelegate.*;

public class Test {
	
	

	public static void main(String[] args) throws RemoteException, ExceptionCliente {				
		PedidoDTO pdto = BusinessDelegate.getInstancia().obtenerPedido(1);
	}

}
