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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import view.ModificarSucursal.ComboItem;
import dto.EmpleadoDTO;
import dto.SucursalDTO;
import exceptions.ExceptionCliente;
import businessDelegate.BusinessDelegate;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarEmpleado extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtMail;
	private JTextField txtArea;
	private JTextField txtUsuario;
	private JTextField txtContraseña;

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

		
		final JComboBox comboEmpleados = new JComboBox();
		comboEmpleados.setBounds(170, 16, 199, 22);
		comboEmpleados.addItem("");
		try{
		List<EmpleadoDTO> lstEmpleado=BusinessDelegate.getInstancia().listarEmpleados();
		for(EmpleadoDTO emp:lstEmpleado){
			comboEmpleados.addItem(new ComboItem(emp.getIdEmpleado(), emp.getNombre()));
		}
		contentPane.add(comboEmpleados);			
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
		
		txtNombre = new JTextField();
		txtNombre.setBounds(169, 54, 200, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtMail = new JTextField();
		txtMail.setColumns(10);
		txtMail.setBounds(170, 87, 200, 20);
		contentPane.add(txtMail);
		
		txtArea = new JTextField();
		txtArea.setColumns(10);
		txtArea.setBounds(170, 121, 200, 20);
		contentPane.add(txtArea);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(169, 159, 200, 20);
		contentPane.add(txtUsuario);
		
		txtContraseña = new JTextField();
		txtContraseña.setColumns(10);
		txtContraseña.setBounds(170, 196, 200, 20);
		contentPane.add(txtContraseña);
		
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
		comboSucursales.setBounds(170, 228, 199, 22);
		contentPane.add(comboSucursales);
		
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ComboItem cempleado=(ComboItem) comboEmpleados.getSelectedItem();				
				Integer idEmpleado=cempleado.getValue();
				String nombre=txtNombre.getText();
				String mail=txtMail.getText();
				String area=txtArea.getText();
				String user=txtUsuario.getText();
				String contraseña=txtContraseña.getText();
				ComboItem csucursal=(ComboItem) comboSucursales.getSelectedItem();
				Integer idSucursal=csucursal.getValue();
				EmpleadoDTO edto=new EmpleadoDTO();
				edto.setIdEmpleado(idEmpleado);
				edto.setNombre(nombre);
				edto.setMail(mail);
				edto.setArea(area);
				edto.setUser(user);
				edto.setContrasenia(contraseña);
				edto.setIdSucu(idSucursal);
				edto.setActivo(true);
				try{
					BusinessDelegate.getInstancia().actualizarEmpleado(edto);
					JOptionPane.showMessageDialog(null, "Empleado actualizado correctamente.");
					MenuPrincipal mp=new MenuPrincipal();
					mp.setVisible(true);
					mp.setLocationRelativeTo(null);
					setVisible(false);					
				}catch(Exception e){
					e.printStackTrace();
				}
				
				
			}
		});
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
		
		
		comboEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ComboItem cEmpleado=(ComboItem) comboEmpleados.getSelectedItem();
				Integer idEmpleado=cEmpleado.getValue();
				if(comboEmpleados.getSelectedIndex()!=-1){
					try{
						EmpleadoDTO edto=BusinessDelegate.getInstancia().recuperarEmpleado(idEmpleado);
						txtNombre.setText(edto.getNombre());
						txtMail.setText(edto.getMail());
						txtArea.setText(edto.getArea());
						txtUsuario.setText(edto.getUser());
						txtContraseña.setText(edto.getContrasenia());
						Integer idSucursal=edto.getIdSucu();
						SucursalDTO sucu=BusinessDelegate.getInstancia().recuperarSucursal(idSucursal);
						comboSucursales.setSelectedIndex(sucu.getIdSucursal());										
					}catch(Exception e){
						e.printStackTrace();
					}									
				}
			}
		});
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
