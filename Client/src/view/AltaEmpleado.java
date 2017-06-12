package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import dto.EmpleadoDTO;
import dto.SucursalDTO;
import businessDelegate.BusinessDelegate;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class AltaEmpleado extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtMail;
	private JTextField txtArea;
	private JTextField txtUser;
	private JTextField txtContraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaEmpleado frame = new AltaEmpleado();
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
	public AltaEmpleado() {
		setTitle("Alta Empleado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 27, 144, 14);
		contentPane.add(lblNombre);
		
		JLabel lblMail = new JLabel("Mail:");
		lblMail.setBounds(10, 68, 144, 14);
		contentPane.add(lblMail);
		
		JLabel lblArea = new JLabel("Area:");
		lblArea.setBounds(10, 109, 144, 14);
		contentPane.add(lblArea);
		
		JLabel lblUser = new JLabel("User:");
		lblUser.setBounds(10, 150, 144, 14);
		contentPane.add(lblUser);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(10, 191, 144, 14);
		contentPane.add(lblContrasea);
		
		JLabel lblSucursal = new JLabel("Sucursal:");
		lblSucursal.setBounds(10, 232, 144, 14);
		contentPane.add(lblSucursal);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(140, 24, 209, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtMail = new JTextField();
		txtMail.setColumns(10);
		txtMail.setBounds(140, 65, 209, 20);
		contentPane.add(txtMail);
		
		txtArea = new JTextField();
		txtArea.setColumns(10);
		txtArea.setBounds(140, 106, 209, 20);
		contentPane.add(txtArea);
		
		txtUser = new JTextField();
		txtUser.setColumns(10);
		txtUser.setBounds(140, 147, 209, 20);
		contentPane.add(txtUser);
		
		txtContraseña = new JTextField();
		txtContraseña.setColumns(10);
		txtContraseña.setBounds(140, 188, 209, 20);
		contentPane.add(txtContraseña);
		
		
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
		
		final JComboBox<ComboItem> comboBox = new JComboBox();
		comboBox.addItem(new ComboItem(0,""));
		try{
			
			List <SucursalDTO> sucursales=BusinessDelegate.getInstancia().listarSucursales();
			for(SucursalDTO sucu:sucursales){
				comboBox.addItem(new ComboItem(sucu.getIdSucursal(), sucu.getNombre()));
			}
			comboBox.setBounds(140, 228, 209, 22);
			contentPane.add(comboBox);			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		JButton btnCargar = new JButton("Alta");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ComboItem ci=(ComboItem) comboBox.getSelectedItem();
				Integer idSucursal=ci.getValue();
				EmpleadoDTO empleado=new EmpleadoDTO(txtNombre.getText(),txtMail.getText(),txtArea.getText(),txtUser.getText(),txtContraseña.getText(),idSucursal);
			}
		});
		btnCargar.setBounds(296, 305, 91, 23);
		contentPane.add(btnCargar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuPrincipal mp=new MenuPrincipal();
				mp.setVisible(true);
				mp.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		btnVolver.setBounds(187, 305, 91, 23);
		contentPane.add(btnVolver);
	}
}
