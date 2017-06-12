package service;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import objetoRemoto.*;
import interfaces.*;

public class Server {

	public static void main(String[] args) {		
		new Server();
	}	
	
	public Server(){
		iniciar();
	}
	
	public void iniciar(){
		try{
			LocateRegistry.createRegistry(1099);
			IControllerVentas objetoRemoto=new ObjetoRemoto();
			Naming.rebind("//localhost/objetoRemoto", objetoRemoto);
			System.out.println("Servidor iniciado correctamente");
						
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
