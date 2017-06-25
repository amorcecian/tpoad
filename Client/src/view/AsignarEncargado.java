package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import view.ModificarSucursal.ComboItem;
import dto.EmpleadoDTO;
import dto.SucursalDTO;
import exceptions.ExceptionCliente;
import businessDelegate.BusinessDelegate;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AsignarEncargado extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public AsignarEncargado() {
		setTitle("Asignar Encargado - Sucursal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 488, 228);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblEmpleado = new JLabel("Empleados:");
		lblEmpleado.setBounds(21, 83, 107, 14);
		contentPane.add(lblEmpleado);
		
		

		
		final JComboBox comboEmpleados = new JComboBox();
		comboEmpleados.addItem(new ComboItem(0,""));
		try{
			List <EmpleadoDTO> empleados=BusinessDelegate.getInstancia().listarEmpleados();
			for(EmpleadoDTO emp:empleados){
				comboEmpleados.addItem(new ComboItem(emp.getIdEmpleado(), emp.getNombre()));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		comboEmpleados.setBounds(101, 79, 211, 22);
		contentPane.add(comboEmpleados);
			
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuPrincipal mp=new MenuPrincipal();
				mp.setVisible(true);
				mp.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		btnVolver.setBounds(165, 128, 91, 23);
		contentPane.add(btnVolver);
		
		JLabel lblSucursales = new JLabel("Sucursales:");
		lblSucursales.setBounds(21, 35, 107, 14);
		contentPane.add(lblSucursales);
		
		
		final JComboBox comboSucursales = new JComboBox();
		comboSucursales.addItem(new ComboItem(0,""));
		try{
			List <SucursalDTO> sucursales=BusinessDelegate.getInstancia().listarSucursales();
			for(SucursalDTO sucu:sucursales){
				comboSucursales.addItem(new ComboItem(sucu.getIdSucursal(), sucu.getNombre()));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		comboSucursales.setBounds(101, 31, 211, 22);
		contentPane.add(comboSucursales);
		
		
		JButton btnAsignar = new JButton("Asignar");
		btnAsignar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ComboItem cisucursal=(ComboItem) comboSucursales.getSelectedItem();
				ComboItem ciempleado=(ComboItem) comboEmpleados.getSelectedItem();				
				try {
					Integer idSucursal=cisucursal.getValue();
					Integer idEmpleado=ciempleado.getValue();
					BusinessDelegate.getInstancia().asignarEncargado(idSucursal, idEmpleado);
					JOptionPane.showMessageDialog(null, "Empleado asignado correctamente.");
					MenuPrincipal mp=new MenuPrincipal();
					mp.setVisible(true);
					mp.setLocationRelativeTo(null);
					setVisible(false);
				}catch (Exception e) {
					e.printStackTrace();
				} 
			}
		});
		btnAsignar.setBounds(272, 128, 91, 23);
		contentPane.add(btnAsignar);
	}

	
	class ComboItem {

	    private Integer value;
	    private String label;

	    public ComboItem(Integer value, String label) {
	        this.value = value;
	        this.label = label;
	    }

	    public Integer getValue() {
	        return this.value;
	    }

	    public String getLabel() {
	        return this.label;
	    }

	    @Override
	    public String toString() {
	        return label;
	    }
	}
}
