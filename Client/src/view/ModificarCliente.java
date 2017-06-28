package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import dto.ClienteDTO;
import dto.CuentaCorrienteDTO;
import dto.EmpleadoDTO;
import dto.SucursalDTO;
import businessDelegate.BusinessDelegate;

import javax.swing.JButton;
import javax.swing.JTextField;

import view.AltaCliente.ComboItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ModificarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtCondicion;
	private JTextField txtLimiteCredito;
	private JTextField txtCondPago;
	private JTextField txtSaldo;
	private JTextField txtValorConsig;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarCliente frame = new ModificarCliente();
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
	public ModificarCliente() {
		setTitle("Modificar Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		
		
		JLabel lblClientes = new JLabel("Clientes:");
		lblClientes.setBounds(23, 30, 141, 14);
		contentPane.add(lblClientes);
		
		
		final JComboBox comboClientes = new JComboBox();		
		comboClientes.addItem(new ComboItem(0, ""));
		try{
			List <ClienteDTO> lstClientes=BusinessDelegate.getInstancia().listarClientes();
			for(ClienteDTO cliente:lstClientes){
				comboClientes.addItem(new ComboItem(cliente.getIdCliente(), cliente.getNombre()));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		comboClientes.setBounds(192, 22, 205, 22);
		contentPane.add(comboClientes);
		
		
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(23, 66, 141, 14);
		contentPane.add(lblNombre);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(23, 107, 141, 14);
		contentPane.add(lblDireccion);
		
		JLabel lblCondicion = new JLabel("Condicion:");
		lblCondicion.setBounds(23, 148, 141, 14);
		contentPane.add(lblCondicion);
		
		JLabel lblLimiteCredito = new JLabel("Limite Credito:");
		lblLimiteCredito.setBounds(23, 193, 141, 14);
		contentPane.add(lblLimiteCredito);
		
		JLabel lblCondicionDePago = new JLabel("Condici\u00F3n de Pago:");
		lblCondicionDePago.setBounds(23, 234, 141, 14);
		contentPane.add(lblCondicionDePago);
		
		JLabel lblSaldo = new JLabel("Saldo:");
		lblSaldo.setBounds(23, 266, 141, 14);
		contentPane.add(lblSaldo);
		
		JLabel lblValorConsignacin = new JLabel("Valor Consignaci\u00F3n:");
		lblValorConsignacin.setBounds(23, 310, 141, 14);
		contentPane.add(lblValorConsignacin);
		
		
		JButton btnModificar = new JButton("Modificar");

		btnModificar.setBounds(289, 392, 91, 23);
		contentPane.add(btnModificar);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(192, 59, 205, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(192, 100, 205, 20);
		contentPane.add(txtDireccion);
		
		txtCondicion = new JTextField();
		txtCondicion.setColumns(10);
		txtCondicion.setBounds(192, 141, 205, 20);
		contentPane.add(txtCondicion);
		
		txtLimiteCredito = new JTextField();
		txtLimiteCredito.setColumns(10);
		txtLimiteCredito.setBounds(192, 186, 205, 20);
		contentPane.add(txtLimiteCredito);
		
		txtCondPago = new JTextField();
		txtCondPago.setColumns(10);
		txtCondPago.setBounds(192, 227, 205, 20);
		contentPane.add(txtCondPago);
		
		txtSaldo = new JTextField();
		txtSaldo.setColumns(10);
		txtSaldo.setBounds(192, 259, 205, 20);
		contentPane.add(txtSaldo);
		
		txtValorConsig = new JTextField();
		txtValorConsig.setColumns(10);
		txtValorConsig.setBounds(192, 300, 205, 20);
		contentPane.add(txtValorConsig);
		
		
		
		
		JLabel lblSucursal = new JLabel("Sucursal:");
		lblSucursal.setBounds(23, 351, 141, 14);
		contentPane.add(lblSucursal);
		
		
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
		comboSucursales.setBounds(192, 347, 205, 22);
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
		btnVolver.setBounds(168, 392, 91, 23);
		contentPane.add(btnVolver);
		
		
		comboClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ComboItem cCliente=(ComboItem) comboClientes.getSelectedItem();
				Integer idCliente=cCliente.getValue();
				if(comboClientes.getSelectedIndex()!=-1){
					try{
						ClienteDTO cdto=BusinessDelegate.getInstancia().recuperarCliente(idCliente);
						txtNombre.setText(cdto.getNombre());
						txtDireccion.setText(cdto.getDireccion());
						txtCondicion.setText(cdto.getCondicion());
						txtCondPago.setText(cdto.getCuentaCorriente().getCondicionPago());
						txtLimiteCredito.setText(String.valueOf(cdto.getCuentaCorriente().getLimiteCredito()));
						txtSaldo.setText(String.valueOf(cdto.getCuentaCorriente().getSaldo()));
						txtValorConsig.setText(String.valueOf(cdto.getCuentaCorriente().getValorConsignacion()));
						Integer idSucursal=cdto.getSucursal().getIdSucursal();
						SucursalDTO sucu=BusinessDelegate.getInstancia().recuperarSucursal(idSucursal);
						comboSucursales.setSelectedIndex(sucu.getIdSucursal());											
					}catch(Exception e){
						e.printStackTrace();
					}
				}
				
			}
		});
		
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{								
				ComboItem ccliente=(ComboItem) comboClientes.getSelectedItem();
				Integer idCliente=ccliente.getValue();							
				ComboItem ci=(ComboItem) comboSucursales.getSelectedItem();
				Integer idSucursal=ci.getValue();
				
				ClienteDTO cli=new ClienteDTO();
				cli.setActivo(true);
				cli.setIdCliente(idCliente);
				cli.setNombre(txtNombre.getText());
				cli.setDireccion(txtDireccion.getText());
				cli.setCondicion(txtCondicion.getText());
				
				CuentaCorrienteDTO ccdto=new CuentaCorrienteDTO();
				
				ccdto.setLimiteCredito(Float.parseFloat(txtLimiteCredito.getText()));
				ccdto.setCondicionPago(txtCondPago.getText());
				ccdto.setSaldo(Float.parseFloat(txtSaldo.getText()));
				ccdto.setValorConsignacion(Float.parseFloat(txtValorConsig.getText()));
				
				cli.setCuentaCorriente(ccdto);
				
				SucursalDTO sdto=BusinessDelegate.getInstancia().recuperarSucursal(idSucursal);
				
				cli.setSucursal(sdto);
				
				BusinessDelegate.getInstancia().actualizarCliente(cli);;
				JOptionPane.showMessageDialog(null, "Cliente modificado correctamente.");
				MenuPrincipal mp=new MenuPrincipal();
				mp.setVisible(true);
				mp.setLocationRelativeTo(null);
				setVisible(false);
				}catch(Exception e){
					e.printStackTrace();
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
