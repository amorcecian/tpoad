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

import dto.EmpleadoDTO;
import businessDelegate.BusinessDelegate;

public class AsignarEncargado extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AsignarEncargado frame = new AsignarEncargado();
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
	public AsignarEncargado() {
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
		
		try{
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(100, 35, 211, 22);
		comboBox.addItem("");
		List <EmpleadoDTO> empleados=BusinessDelegate.getInstancia().listarEmpleados();
		for(EmpleadoDTO emp:empleados){
			comboBox.insertItemAt(emp.getNombre(), emp.getIdEmpleado());
		}
		contentPane.add(comboBox);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		JButton btnAsignar = new JButton("Asignar");
		btnAsignar.setBounds(271, 68, 91, 23);
		contentPane.add(btnAsignar);
	}

}
