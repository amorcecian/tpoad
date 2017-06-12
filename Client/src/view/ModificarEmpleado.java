package view;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;

import dto.EmpleadoDTO;
import businessDelegate.BusinessDelegate;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarEmpleado extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarEmpleado frame = new ModificarEmpleado();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ModificarEmpleado() {
		setTitle("Modificar Empleado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmpleados = new JLabel("Empleados:");
		lblEmpleados.setBounds(31, 23, 118, 14);
		contentPane.add(lblEmpleados);
		
		
		try{
			JComboBox lstEmpleados = new JComboBox();
			lstEmpleados.setBounds(170, 16, 199, 22);
			lstEmpleados.addItem("");
			List<EmpleadoDTO> lstEmpleado=BusinessDelegate.getInstancia().listarEmpleados();
			for(EmpleadoDTO emp:lstEmpleado){
				lstEmpleados.addItem(emp.getNombre());
			}
			contentPane.add(lstEmpleados);			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(31, 60, 118, 14);
		contentPane.add(lblNombre);
		
		JLabel lblMail = new JLabel("Mail:");
		lblMail.setBounds(31, 93, 118, 14);
		contentPane.add(lblMail);
		
		JLabel lblArea = new JLabel("Area:");
		lblArea.setBounds(31, 127, 118, 14);
		contentPane.add(lblArea);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(31, 165, 118, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(31, 202, 118, 14);
		contentPane.add(lblContrasea);
		
		JLabel lblSucursal = new JLabel("Sucursal:");
		lblSucursal.setBounds(31, 232, 118, 14);
		contentPane.add(lblSucursal);
		
		textField = new JTextField();
		textField.setBounds(169, 54, 200, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(170, 87, 200, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(170, 121, 200, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(169, 159, 200, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(170, 196, 200, 20);
		contentPane.add(textField_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(170, 224, 202, 22);
		contentPane.add(comboBox);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(317, 273, 91, 23);
		contentPane.add(btnModificar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuPrincipal mp=new MenuPrincipal();
				mp.setVisible(true);
				mp.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		btnVolver.setBounds(193, 273, 91, 23);
		contentPane.add(btnVolver);
	}
}
