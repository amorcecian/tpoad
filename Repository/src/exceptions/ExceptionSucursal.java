package exceptions;

import javax.swing.JOptionPane;

public class ExceptionSucursal extends Exception{
	
	 
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 52450350744096812L;

	public void SucursalDuplicada(){
		JOptionPane.showMessageDialog(null, "La sucursal ya existe");
	}

}
