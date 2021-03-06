package view;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import view.ModificarEmpleado.ComboItem;
import businessDelegate.BusinessDelegate;
import dto.ClienteDTO;
import dto.CuentaCorrienteDTO;
import dto.SucursalDTO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class AltaCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtLimiteCredito;
	private JTextField txtCondPago;
	private JTextField txtSaldo;
	private JTextField txtValorConsig;
	private JTextField txtUsuario;
	private JTextField txtContrase�a;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaCliente frame = new AltaCliente();
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
	public AltaCliente() {
		setTitle("Alta Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(20, 30, 126, 14);
		contentPane.add(lblNombre);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(20, 74, 126, 14);
		contentPane.add(lblDireccion);
		
		JLabel lblCondicion = new JLabel("Condicion:");
		lblCondicion.setBounds(20, 118, 126, 14);
		contentPane.add(lblCondicion);
		
		JLabel lblLimiteCredito = new JLabel("Limite Credito:");
		lblLimiteCredito.setBounds(20, 162, 126, 14);
		contentPane.add(lblLimiteCredito);
		
		JLabel lblCondicinDePago = new JLabel("Condici\u00F3n de Pago:");
		lblCondicinDePago.setBounds(20, 206, 126, 14);
		contentPane.add(lblCondicinDePago);
		
		JLabel lblSaldo = new JLabel("Saldo:");
		lblSaldo.setBounds(20, 250, 126, 14);
		contentPane.add(lblSaldo);
		
		JLabel lblValorConsignacin = new JLabel("Valor Consignaci\u00F3n:");
		lblValorConsignacin.setBounds(20, 294, 126, 14);
		contentPane.add(lblValorConsignacin);
		
		JLabel lblSucursal = new JLabel("Sucursal:");
		lblSucursal.setBounds(20, 338, 126, 14);
		contentPane.add(lblSucursal);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(181, 27, 203, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(181, 71, 203, 20);
		contentPane.add(txtDireccion);
		
		txtLimiteCredito = new JTextField();
		txtLimiteCredito.setColumns(10);
		txtLimiteCredito.setBounds(181, 159, 203, 20);
		contentPane.add(txtLimiteCredito);
		
		txtCondPago = new JTextField();
		txtCondPago.setColumns(10);
		txtCondPago.setBounds(181, 203, 203, 20);
		contentPane.add(txtCondPago);
		
		txtSaldo = new JTextField();
		txtSaldo.setColumns(10);
		txtSaldo.setBounds(181, 247, 203, 20);
		contentPane.add(txtSaldo);
		
		txtValorConsig = new JTextField();
		txtValorConsig.setColumns(10);
		txtValorConsig.setBounds(181, 291, 203, 20);
		contentPane.add(txtValorConsig);
		
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
		comboSucursales.setBounds(181, 334, 203, 22);
		contentPane.add(comboSucursales);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuPrincipal mp=new MenuPrincipal();
				mp.setVisible(true);
				mp.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		btnVolver.setBounds(225, 422, 91, 23);
		contentPane.add(btnVolver);
		
		JButton btnAlta = new JButton("Alta");

		btnAlta.setBounds(341, 422, 91, 23);
		contentPane.add(btnAlta);
		
		final JComboBox comboCondicion = new JComboBox();
		comboCondicion.addItem("Responsable Inscripto");
		comboCondicion.addItem("Monotributista");
		comboCondicion.setBounds(181, 114, 203, 22);
		contentPane.add(comboCondicion);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(20, 366, 126, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(20, 394, 126, 14);
		contentPane.add(lblContrasea);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(181, 363, 203, 20);
		contentPane.add(txtUsuario);
		
		txtContrase�a = new JTextField();
		txtContrase�a.setColumns(10);
		txtContrase�a.setBounds(181, 391, 203, 20);
		contentPane.add(txtContrase�a);
		
		
		
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				ComboItem ci=(ComboItem) comboSucursales.getSelectedItem();
				Integer idSucursal=ci.getValue();
				ClienteDTO cli=new ClienteDTO();
				cli.setNombre(txtNombre.getText());
				cli.setDireccion(txtDireccion.getText());
				cli.setCondicion((String)comboCondicion.getSelectedItem());
				
				CuentaCorrienteDTO ccdto=new CuentaCorrienteDTO();
				
				ccdto.setLimiteCredito(Float.parseFloat(txtLimiteCredito.getText()));
				ccdto.setCondicionPago(txtCondPago.getText());
				ccdto.setSaldo(Float.parseFloat(txtSaldo.getText()));
				ccdto.setValorConsignacion(Float.parseFloat(txtValorConsig.getText()));
				
				cli.setCuentaCorriente(ccdto);
				
				SucursalDTO sdto=BusinessDelegate.getInstancia().recuperarSucursal(idSucursal);
				
				cli.setSucursal(sdto);
				
				cli.setUsuario(txtUsuario.getText());
				cli.setContrase�a(txtContrase�a.getText());
				
				BusinessDelegate.getInstancia().agregarCliente(cli);
				JOptionPane.showMessageDialog(null, "Cliente agregado correctamente.");
				MenuPrincipal mp=new MenuPrincipal();
				mp.setVisible(true);
				mp.setLocationRelativeTo(null);
				setVisible(false);
				}catch(Exception e){
					//e.printStackTrace();
					JOptionPane.showMessageDialog(null,
						    "Debe completar todos los campos.",
						    "Error",
						    JOptionPane.ERROR_MESSAGE);
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
