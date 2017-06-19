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
import dto.MaterialDTO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AltaMaterial extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtCantDispo;
	private JTextField txtCantRes;
	private JTextField txtProveedor;
	private JTextField txtCosto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaMaterial frame = new AltaMaterial();
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
	public AltaMaterial() {
		setTitle("Alta Material");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(22, 33, 135, 14);
		contentPane.add(lblNombre);
		
		JLabel lblProveedor = new JLabel("Proveedor:");
		lblProveedor.setBounds(22, 174, 135, 14);
		contentPane.add(lblProveedor);
		
		JLabel lblCosto = new JLabel("Costo:");
		lblCosto.setBounds(22, 221, 135, 14);
		contentPane.add(lblCosto);
		
		JLabel lblCambio = new JLabel("Cantidad Disponible:");
		lblCambio.setBounds(22, 80, 135, 14);
		contentPane.add(lblCambio);
		
		JLabel lblCantidadReservada = new JLabel("Cantidad Reservada:");
		lblCantidadReservada.setBounds(22, 127, 135, 14);
		contentPane.add(lblCantidadReservada);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(199, 30, 205, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtCantDispo = new JTextField();
		txtCantDispo.setColumns(10);
		txtCantDispo.setBounds(199, 77, 205, 20);
		contentPane.add(txtCantDispo);
		
		txtCantRes = new JTextField();
		txtCantRes.setColumns(10);
		txtCantRes.setBounds(199, 124, 205, 20);
		contentPane.add(txtCantRes);
		
		txtProveedor = new JTextField();
		txtProveedor.setColumns(10);
		txtProveedor.setBounds(199, 171, 205, 20);
		contentPane.add(txtProveedor);
		
		txtCosto = new JTextField();
		txtCosto.setColumns(10);
		txtCosto.setBounds(199, 218, 205, 20);
		contentPane.add(txtCosto);
		
		JButton btnNewButton = new JButton("Alta");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MaterialDTO materi=new MaterialDTO(txtNombre.getText(),Integer.parseInt(txtCantDispo.getText()),
						Integer.parseInt(txtCantRes.getText()),txtProveedor.getText(),
						Float.parseFloat(txtCosto.getText()),true);
				try{
					BusinessDelegate.getInstancia().agregarMaterial(materi);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(313, 285, 91, 23);
		contentPane.add(btnNewButton);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(197, 285, 91, 23);
		contentPane.add(btnVolver);
	}
}
