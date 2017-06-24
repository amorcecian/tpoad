package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

import view.AltaEmpleado.ComboItem;
import businessDelegate.BusinessDelegate;
import dto.EmpleadoDTO;
import dto.SucursalDTO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarSucursal extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtDomicilio;
	private JTextField txtHorario;
	private JComboBox comboEncargado = new JComboBox();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarSucursal frame = new ModificarSucursal();
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
	public ModificarSucursal() {
		setTitle("Modificar Sucursal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 419, 259);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(25, 65, 118, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblDomicilio = new JLabel("Domicilio");
		lblDomicilio.setBounds(25, 90, 118, 14);
		contentPane.add(lblDomicilio);
		
		JLabel lblHorario = new JLabel("Horario:");
		lblHorario.setBounds(25, 115, 118, 14);
		contentPane.add(lblHorario);
		
		JLabel lblEncargado = new JLabel("Encargado:");
		lblEncargado.setBounds(25, 140, 118, 14);
		contentPane.add(lblEncargado);
		
		JLabel lblSucursales = new JLabel("Sucursales:");
		lblSucursales.setBounds(25, 40, 118, 14);
		contentPane.add(lblSucursales);
		
	
		final JComboBox comboSucursales = new JComboBox();
		comboSucursales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ComboItem cisucursal=(ComboItem) comboSucursales.getSelectedItem();
				Integer idSucursal=cisucursal.getValue();
				if(idSucursal!=0){
					try{
						SucursalDTO sdto=BusinessDelegate.getInstancia().recuperarSucursal(idSucursal);
						txtNombre.setText(sdto.getNombre());
						txtDomicilio.setText(sdto.getDomicilio());
						txtHorario.setText(sdto.getHorario());
						EmpleadoDTO emdto=sdto.getEncargado();
						comboEncargado.addItem(new ComboItem(emdto.getIdEmpleado(),emdto.getNombre()));
					}catch(Exception e){
						e.printStackTrace();
					}					
				}							
			}
		});
		comboSucursales.addItem(new ComboItem(0,""));
		try{
			List <SucursalDTO> sucursales=BusinessDelegate.getInstancia().listarSucursales();
			for(SucursalDTO sucu:sucursales){
				comboSucursales.addItem(new ComboItem(sucu.getIdSucursal(), sucu.getNombre()));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		comboSucursales.setBounds(153, 36, 153, 22);
		contentPane.add(comboSucursales);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(153, 62, 153, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtDomicilio = new JTextField();
		txtDomicilio.setColumns(10);
		txtDomicilio.setBounds(153, 87, 153, 20);
		contentPane.add(txtDomicilio);
		
		txtHorario = new JTextField();
		txtHorario.setColumns(10);
		txtHorario.setBounds(153, 112, 153, 20);
		contentPane.add(txtHorario);
		
		
		if(comboEncargado.getSelectedIndex()!=0){
		comboEncargado.addItem(new ComboItem(0,""));
		}
		try{
			List <EmpleadoDTO> empleados=BusinessDelegate.getInstancia().listarEmpleados();
			for(EmpleadoDTO emp:empleados){
				comboEncargado.addItem(new ComboItem(emp.getIdEmpleado(), emp.getNombre()));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		comboEncargado.setBounds(153, 136, 153, 22);
		contentPane.add(comboEncargado);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(308, 185, 91, 23);
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
		btnVolver.setBounds(194, 185, 91, 23);
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
