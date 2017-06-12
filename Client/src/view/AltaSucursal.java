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
	private JTextField txtId;

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
		setBounds(100, 100, 450, 273);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 71, 99, 14);
		contentPane.add(lblNombre);
		
		JLabel lblDomicilio = new JLabel("Domicilio:");
		lblDomicilio.setBounds(10, 98, 99, 14);
		contentPane.add(lblDomicilio);
		
		JLabel lblHorario = new JLabel("Horario:");
		lblHorario.setBounds(10, 123, 99, 14);
		contentPane.add(lblHorario);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(156, 65, 208, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		
		JLabel lblIdSucursal = new JLabel("Id Sucursal:");
		lblIdSucursal.setBounds(10, 44, 99, 14);
		contentPane.add(lblIdSucursal);
		
		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(156, 41, 208, 20);
		contentPane.add(txtId);
		
		txtDomicilio = new JTextField();
		txtDomicilio.setColumns(10);
		txtDomicilio.setBounds(156, 92, 208, 20);
		contentPane.add(txtDomicilio);
		
		txtHorario = new JTextField();
		txtHorario.setColumns(10);
		txtHorario.setBounds(156, 117, 208, 20);
		contentPane.add(txtHorario);
		
		btnAlta = new JButton("Alta");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { 
				try{
				SucursalDTO sucursal=new SucursalDTO(Integer.parseInt(txtId.getText()),txtNombre.getText(),txtDomicilio.getText(),txtHorario.getText());
				BusinessDelegate.getInstancia().agregarSucursal(sucursal);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		btnAlta.setBounds(285, 176, 91, 23);
		contentPane.add(btnAlta);

	}
}