package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import view.AsignarEncargado.ComboItem;
import businessDelegate.BusinessDelegate;
import dto.SucursalDTO;

import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BajaSucursal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BajaSucursal frame = new BajaSucursal();
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
	public BajaSucursal() {
		setTitle("Eliminar Sucursal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 187);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
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
		comboSucursales.setBounds(189, 37, 211, 22);
		contentPane.add(comboSucursales);
		
		JLabel lblSucursales = new JLabel("Sucursales:");
		lblSucursales.setBounds(36, 45, 125, 14);
		contentPane.add(lblSucursales);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ComboItem ci=(ComboItem) comboSucursales.getSelectedItem();
				Integer idSucursal=ci.getValue();
				try{
					BusinessDelegate.getInstancia().eliminarSucursal(idSucursal);
					JOptionPane.showMessageDialog(null, "Sucursal eliminada correctamente.");
					MenuPrincipal mp=new MenuPrincipal();
					mp.setVisible(true);
					mp.setLocationRelativeTo(null);
					setVisible(false);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		btnEliminar.setBounds(309, 108, 91, 23);
		contentPane.add(btnEliminar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuPrincipal mp=new MenuPrincipal();
				mp.setVisible(true);
				mp.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		btnVolver.setBounds(201, 108, 91, 23);
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
