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

import view.AltaCliente.ComboItem;
import businessDelegate.BusinessDelegate;
import dto.AreaProductivaDTO;
import dto.SucursalDTO;

public class AltaEtapaProductiva extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaEtapaProductiva frame = new AltaEtapaProductiva();
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
	public AltaEtapaProductiva() {
		setTitle("Alta Etapa Productiva");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 375, 214);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAreaProductiva = new JLabel("Area productiva:");
		lblAreaProductiva.setBounds(10, 28, 120, 14);
		contentPane.add(lblAreaProductiva);
		
		
		final JComboBox comboAreas = new JComboBox();
		comboAreas.addItem(new ComboItem(0,""));
		try{
			//List<AreaProductivaDTO> ladto=BusinessDelegate.getInstancia().
			
		}catch(Exception e){
			e.printStackTrace();
		}
		comboAreas.setBounds(140, 24, 172, 22);
		contentPane.add(comboAreas);
		/*
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
		*/
		
		JLabel lblTiempoProduccin = new JLabel("Tiempo producci\u00F3n:");
		lblTiempoProduccin.setBounds(10, 72, 120, 14);
		contentPane.add(lblTiempoProduccin);
		
		textField = new JTextField();
		textField.setBounds(140, 69, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblOrden = new JLabel("Orden:");
		lblOrden.setBounds(10, 113, 120, 14);
		contentPane.add(lblOrden);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(140, 110, 86, 20);
		contentPane.add(textField_1);
		
		JButton btnCargar = new JButton("Cargar");
		btnCargar.setBounds(221, 141, 91, 23);
		contentPane.add(btnCargar);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(120, 141, 91, 23);
		contentPane.add(btnCerrar);
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
