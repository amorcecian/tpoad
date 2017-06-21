package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import businessDelegate.BusinessDelegate;
import dto.SucursalDTO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AltaSucursal extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtDomicilio;
	private JTextField txtHorario;
	private JButton btnAlta;
	private JButton btnVolver;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaSucursal frame = new AltaSucursal();
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
	public AltaSucursal() {
		setTitle("Alta Sucursal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 170);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 17, 99, 14);
		contentPane.add(lblNombre);
		
		JLabel lblDomicilio = new JLabel("Domicilio:");
		lblDomicilio.setBounds(10, 44, 99, 14);
		contentPane.add(lblDomicilio);
		
		JLabel lblHorario = new JLabel("Horario:");
		lblHorario.setBounds(10, 69, 99, 14);
		contentPane.add(lblHorario);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(156, 11, 208, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtDomicilio = new JTextField();
		txtDomicilio.setColumns(10);
		txtDomicilio.setBounds(156, 38, 208, 20);
		contentPane.add(txtDomicilio);
		
		txtHorario = new JTextField();
		txtHorario.setColumns(10);
		txtHorario.setBounds(156, 63, 208, 20);
		contentPane.add(txtHorario);
		
		btnAlta = new JButton("Siguiente");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { 
				String nombre=txtNombre.getText();				String domicilio=txtDomicilio.getText();				String horario=txtHorario.getText();								SucursalDTO sucu=new SucursalDTO();				sucu.setNombre(nombre);				sucu.setDomicilio(domicilio);				sucu.setHorario(horario);								AsignarEncargado ae=new AsignarEncargado(sucu);				ae.setVisible(true);				ae.setLocationRelativeTo(null);				setVisible(false);
			}
		});
		btnAlta.setBounds(273, 108, 91, 23);
		contentPane.add(btnAlta);
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				MenuPrincipal mp=new MenuPrincipal();				mp.setVisible(true);				mp.setLocationRelativeTo(null);				setVisible(false);
			}
		});
		btnVolver.setBounds(156, 108, 91, 23);
		contentPane.add(btnVolver);

	}
}