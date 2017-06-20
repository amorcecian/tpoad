package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

import dto.MaterialDTO;
import dto.MaterialporPrendaDTO;
import dto.PrendaDTO;
import businessDelegate.BusinessDelegate;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AltaPrendaMaterial extends JFrame {

	private JPanel contentPane;
	private JTextField txtCantidadM1;
	private JTextField txtDespM1;
	private JTextField txtCantidadM2;
	private JTextField txtDespM2;
	private JTextField txtCantidadM3;
	private JTextField txtDespM3;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaPrendaMaterial frame = new AltaPrendaMaterial(PrendaDTO prenda);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	/**
	 * Create the frame.
	 */
	public AltaPrendaMaterial(final PrendaDTO prenda) {
		setTitle("Alta Prenda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAsignarMaterialesA = new JLabel("Asignar Materiales a una prenda");
		lblAsignarMaterialesA.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAsignarMaterialesA.setHorizontalAlignment(SwingConstants.CENTER);
		lblAsignarMaterialesA.setBounds(80, 23, 281, 34);
		contentPane.add(lblAsignarMaterialesA);
		
		JLabel lblMaterial = new JLabel("Material 1:");
		lblMaterial.setBounds(21, 118, 144, 14);
		contentPane.add(lblMaterial);
		
		final JComboBox comboM1 = new JComboBox();
		comboM1.setBounds(21, 143, 144, 22);
		comboM1.addItem("");
		try{
			List<MaterialDTO> materiales=BusinessDelegate.getInstancia().listarMateriales();
			for(MaterialDTO material:materiales){
				comboM1.addItem(new ComboItem(material.getIdMaterial(), material.getNombre()));				
			}
		}catch(Exception e){
			e.printStackTrace();
		}

		contentPane.add(comboM1);
		
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(196, 118, 144, 14);
		contentPane.add(lblCantidad);
		
		txtCantidadM1 = new JTextField();
		txtCantidadM1.setBounds(196, 144, 86, 20);
		contentPane.add(txtCantidadM1);
		txtCantidadM1.setColumns(10);
		
		JLabel lblDesperdicio = new JLabel("Desperdicio:");
		lblDesperdicio.setBounds(327, 118, 105, 14);
		contentPane.add(lblDesperdicio);
		
		txtDespM1 = new JTextField();
		txtDespM1.setColumns(10);
		txtDespM1.setBounds(327, 144, 86, 20);
		contentPane.add(txtDespM1);
		
		final JComboBox comboM2 = new JComboBox();
		comboM2.setBounds(21, 201, 144, 22);
		comboM2.addItem("");
		try{
			List<MaterialDTO> materiales=BusinessDelegate.getInstancia().listarMateriales();
			for(MaterialDTO material:materiales){
				comboM2.addItem(new ComboItem(material.getIdMaterial(), material.getNombre()));				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		contentPane.add(comboM2);
		
		JLabel lblMaterial_1 = new JLabel("Material 2:");
		lblMaterial_1.setBounds(21, 176, 144, 14);
		contentPane.add(lblMaterial_1);
		
		JLabel label_1 = new JLabel("Cantidad:");
		label_1.setBounds(196, 176, 144, 14);
		contentPane.add(label_1);
		
		txtCantidadM2 = new JTextField();
		txtCantidadM2.setColumns(10);
		txtCantidadM2.setBounds(196, 202, 86, 20);
		contentPane.add(txtCantidadM2);
		
		JLabel label_2 = new JLabel("Desperdicio:");
		label_2.setBounds(327, 176, 105, 14);
		contentPane.add(label_2);
		
		txtDespM2 = new JTextField();
		txtDespM2.setColumns(10);
		txtDespM2.setBounds(327, 202, 86, 20);
		contentPane.add(txtDespM2);
		
		final JComboBox comboM3 = new JComboBox();
		comboM3.setBounds(21, 259, 144, 22);
		comboM3.addItem("");
		try{
			List<MaterialDTO> materiales=BusinessDelegate.getInstancia().listarMateriales();
			for(MaterialDTO material:materiales){
				comboM3.addItem(new ComboItem(material.getIdMaterial(), material.getNombre()));				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		contentPane.add(comboM3);
		
		JLabel lblMaterial_2 = new JLabel("Material 3:");
		lblMaterial_2.setBounds(21, 234, 144, 14);
		contentPane.add(lblMaterial_2);
		
		JLabel label_4 = new JLabel("Cantidad:");
		label_4.setBounds(196, 234, 144, 14);
		contentPane.add(label_4);
		
		txtCantidadM3 = new JTextField();
		txtCantidadM3.setColumns(10);
		txtCantidadM3.setBounds(196, 260, 86, 20);
		contentPane.add(txtCantidadM3);
		
		JLabel label_5 = new JLabel("Desperdicio:");
		label_5.setBounds(327, 234, 105, 14);
		contentPane.add(label_5);
		
		txtDespM3 = new JTextField();
		txtDespM3.setColumns(10);
		txtDespM3.setBounds(327, 260, 86, 20);
		contentPane.add(txtDespM3);
		
		JButton btnNewButton = new JButton("Alta");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<MaterialporPrendaDTO> lmpp=new ArrayList<MaterialporPrendaDTO>();
				
				
				if(comboM1.getSelectedItem()!=null){
					try {
						ComboItem ci=(ComboItem) comboM1.getSelectedItem();		
						MaterialDTO material=BusinessDelegate.getInstancia().recuperarMaterial(ci.getValue());
						int cantidad=Integer.parseInt(txtCantidadM1.getText());
						int desperdicio=Integer.parseInt(txtDespM1.getText());
						MaterialporPrendaDTO mpp=new MaterialporPrendaDTO(material,cantidad,desperdicio);
						lmpp.add(mpp);
					} catch (RemoteException e) {
						e.printStackTrace();
					}
					
				}
				
				if(comboM2.getSelectedItem()!=null){
					try {
						ComboItem ci=(ComboItem) comboM2.getSelectedItem();		
						MaterialDTO material=BusinessDelegate.getInstancia().recuperarMaterial(ci.getValue());
						int cantidad=Integer.parseInt(txtCantidadM2.getText());
						int desperdicio=Integer.parseInt(txtDespM2.getText());
						MaterialporPrendaDTO mpp=new MaterialporPrendaDTO(material,cantidad,desperdicio);
						lmpp.add(mpp);
					} catch (RemoteException e) {
						e.printStackTrace();
					}
					
				}
				
				if(comboM3.getSelectedItem()!=null){
					try {
						ComboItem ci=(ComboItem) comboM3.getSelectedItem();		
						MaterialDTO material=BusinessDelegate.getInstancia().recuperarMaterial(ci.getValue());
						int cantidad=Integer.parseInt(txtCantidadM3.getText());
						int desperdicio=Integer.parseInt(txtDespM3.getText());
						MaterialporPrendaDTO mpp=new MaterialporPrendaDTO(material,cantidad,desperdicio);
						lmpp.add(mpp);
					} catch (RemoteException e) {
						e.printStackTrace();
					}
					
				}
				
				prenda.setMateriales(lmpp);
				
			}
		});
		btnNewButton.setBounds(322, 324, 91, 23);
		contentPane.add(btnNewButton);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(218, 324, 91, 23);
		contentPane.add(btnVolver);
		
		JLabel lblPrenda = new JLabel("Prenda: " + prenda.getDescripcion());
		lblPrenda.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblPrenda.setBounds(21, 70, 105, 22);
		contentPane.add(lblPrenda);
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
