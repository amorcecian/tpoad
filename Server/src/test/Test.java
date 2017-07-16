package test;

import java.util.ArrayList;
import java.util.List;

import dao.*;
import negocio.*;

public class Test {

	public static void main(String[] args) {
		
		Stock stock1=StockDAO.getInstance().recuperarStock(1);		
		List <PrendaVenta> lpv=new ArrayList<PrendaVenta>();
		for(int i=0; i<15;i++) {
			PrendaVenta pv=new PrendaVenta("Asignado",1,true);
			lpv.add(pv);			
		}
		stock1.setPrendasVenta(lpv);
		StockDAO.getInstance().actualizarStock(stock1);

	}

}
