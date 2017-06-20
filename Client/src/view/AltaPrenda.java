package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JButton;

import dto.MaterialDTO;
import businessDelegate.BusinessDelegate;

public class AltaPrenda extends JFrame {

	private JPanel contentPane;
	private JTextField txtDescripcion;
	private JTextField txtColor;
	private JTextField txtTalle;
	private JTextField txtPrecioVta;
	private JTextField txtTemporada;
	private JTextField txtTiempoProd;
	private JTextField txtCantProd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaPrenda frame = new AltaPrenda();
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
	public AltaPrenda() {
		setTitle("Alta Prenda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setBounds(10, 22, 138, 22);
		contentPane.add(lblDescripcin);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setBounds(10, 66, 138, 22);
		contentPane.add(lblColor);
		
		JLabel lblTalle = new JLabel("Talle:");
		lblTalle.setBounds(10, 110, 138, 22);
		contentPane.add(lblTalle);
		
		JLabel lblPrecioVenta = new JLabel("Precio Venta:");
		lblPrecioVenta.setBounds(10, 154, 138, 22);
		contentPane.add(lblPrecioVenta);
		
		JLabel lblTemporada = new JLabel("Temporada:");
		lblTemporada.setBounds(10, 198, 138, 22);
		contentPane.add(lblTemporada);
		
		JLabel lblTiempoDeProduccion = new JLabel("Tiempo de produccion:");
		lblTiempoDeProduccion.setBounds(10, 242, 138, 22);
		contentPane.add(lblTiempoDeProduccion);
		
		JLabel lblCantidadAProducir = new JLabel("Cantidad a producir:");
		lblCantidadAProducir.setBounds(10, 286, 138, 22);
		contentPane.add(lblCantidadAProducir);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(187, 23, 218, 20);
		contentPane.add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		txtColor = new JTextField();
		txtColor.setColumns(10);
		txtColor.setBounds(187, 67, 218, 20);
		contentPane.add(txtColor);
		
		txtTalle = new JTextField();
		txtTalle.setColumns(10);
		txtTalle.setBounds(187, 111, 218, 20);
		contentPane.add(txtTalle);
		
		txtPrecioVta = new JTextField();
		txtPrecioVta.setColumns(10);
		txtPrecioVta.setBounds(187, 155, 218, 20);
		contentPane.add(txtPrecioVta);
		
		txtTemporada = new JTextField();
		txtTemporada.setColumns(10);
		txtTemporada.setBounds(187, 199, 218, 20);
		contentPane.add(txtTemporada);
		
		txtTiempoProd = new JTextField();
		txtTiempoProd.setColumns(10);
		txtTiempoProd.setBounds(187, 243, 218, 20);
		contentPane.add(txtTiempoProd);
		
		txtCantProd = new JTextField();
		txtCantProd.setColumns(10);
		txtCantProd.setBounds(187, 287, 218, 20);
		contentPane.add(txtCantProd);
		
		JLabel lblMateriales = new JLabel("Materiales:");
		lblMateriales.setBounds(10, 340, 138, 22);
		contentPane.add(lblMateriales);
		
		
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
		
		
		JList listMateriales = new JList();
		listMateriales.setBounds(187, 343, 218, 67);
		try{
		List <MaterialDTO> materiales=BusinessDelegate.getInstancia().listarMateriales();
		
		
		for(MaterialDTO m:materiales){
			listMateriales.add(new ComboItem(m.getIdMaterial(), m.getNombre()));
			//System.out.println(m.getNombre());
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		contentPane.add(listMateriales);
		
		JButton btnNewButton = new JButton("Alta");
		btnNewButton.setBounds(314, 437, 91, 23);
		contentPane.add(btnNewButton);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(204, 437, 91, 23);
		contentPane.add(btnVolver);
	}
}