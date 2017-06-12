package view;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.rmi.RemoteException;
import java.util.List;

import javafx.scene.control.ComboBox;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

import businessDelegate.BusinessDelegate;
import dto.EmpleadoDTO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BajaEmpleado extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BajaEmpleado frame = new BajaEmpleado();
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
	public BajaEmpleado() {
		setTitle("Baja Empleado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 154);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmpleados = new JLabel("Empleados:");
		lblEmpleados.setBounds(30, 31, 99, 14);
		contentPane.add(lblEmpleados);
		
		
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
		
		final JComboBox lstEmpleados = new JComboBox();
		lstEmpleados.setBounds(139, 27, 229, 22);
		lstEmpleados.addItem("");
		try{
			List<EmpleadoDTO> lstEmpleado=BusinessDelegate.getInstancia().listarEmpleados();
			for(EmpleadoDTO emp:lstEmpleado){
				lstEmpleados.addItem(new ComboItem(emp.getIdEmpleado(), emp.getNombre()));
			}
			contentPane.add(lstEmpleados);			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ComboItem ci=(ComboItem) lstEmpleados.getSelectedItem();
				try {
					BusinessDelegate.getInstancia().eliminarEmpleado(ci.getValue());
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnEliminar.setBounds(319, 79, 91, 23);
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
		btnVolver.setBounds(195, 79, 91, 23);
		contentPane.add(btnVolver);
	}

}
