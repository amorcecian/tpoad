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

import dto.ClienteDTO;
import businessDelegate.BusinessDelegate;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class BajaCliente extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BajaCliente frame = new BajaCliente();
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
	public BajaCliente() {
		setTitle("Baja Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 146);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		try{					
			JLabel lblClientes = new JLabel("Clientes:");
			lblClientes.setBounds(27, 36, 98, 14);
			contentPane.add(lblClientes);
			
			JComboBox comboBox = new JComboBox();
			comboBox.setBounds(121, 32, 222, 22);
			comboBox.addItem("");
			List<ClienteDTO> lstClientes=BusinessDelegate.getInstancia().listarClientes();
			for(ClienteDTO cliente:lstClientes){
				comboBox.addItem(cliente.getNombre());
			}
			contentPane.add(comboBox);
			
		}catch(Exception e){
			e.printStackTrace();
		}

		
		JButton btnBaja = new JButton("Eliminar");
		btnBaja.setBounds(297, 85, 91, 23);
		contentPane.add(btnBaja);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuPrincipal mp=new MenuPrincipal();
				mp.setVisible(true);
				mp.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		btnVolver.setBounds(181, 85, 91, 23);
		contentPane.add(btnVolver);
	}

}
