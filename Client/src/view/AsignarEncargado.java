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
	public AsignarEncargado(final SucursalDTO sucu) {
		setTitle("Asignar Encargado - Sucursal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 149);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblEmpleado = new JLabel("Empleados:");
		lblEmpleado.setBounds(20, 39, 107, 14);
		contentPane.add(lblEmpleado);
		
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(100, 35, 211, 22);
		try{
		List <EmpleadoDTO> empleados=BusinessDelegate.getInstancia().listarEmpleados();
		for(EmpleadoDTO emp:empleados){
			comboBox.addItem(new ComboItem(emp.getIdEmpleado(), emp.getNombre()));
		}
		contentPane.add(comboBox);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		JButton btnAsignar = new JButton("Asignar");
		btnAsignar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ComboItem ci=(ComboItem) comboBox.getSelectedItem();
				try {
					EmpleadoDTO emp=BusinessDelegate.getInstancia().recuperarEmpleado(ci.getValue());
					sucu.setEncargado(emp);
					BusinessDelegate.getInstancia().agregarSucursal(sucu);
					System.out.println(emp.getIdEmpleado());
					/*
					JOptionPane.showMessageDialog(null,
						    "Sucursal generada correctamente");
					MenuPrincipal mp=new MenuPrincipal();
					mp.setVisible(true);
					mp.setLocationRelativeTo(null);
					setVisible(false);*/
				}catch (Exception e) {
					e.printStackTrace();
				} 
			}
		});
		btnAsignar.setBounds(271, 68, 91, 23);
		contentPane.add(btnAsignar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuPrincipal mp=new MenuPrincipal();
				mp.setVisible(true);
				mp.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		btnVolver.setBounds(164, 68, 91, 23);
		contentPane.add(btnVolver);
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
