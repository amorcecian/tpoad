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

import view.ModificarCliente.ComboItem;
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
		setBounds(100, 100, 361, 146);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
							
		JLabel lblClientes = new JLabel("Clientes:");
		lblClientes.setBounds(10, 26, 98, 14);
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
		comboClientes.setBounds(118, 22, 205, 22);
		contentPane.add(comboClientes);

		
		JButton btnBaja = new JButton("Eliminar");
		btnBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ComboItem cCliente=(ComboItem) comboClientes.getSelectedItem();
				Integer idCliente=cCliente.getValue();
				if(comboClientes.getSelectedIndex()!=-1){
					try{
						BusinessDelegate.getInstancia().eliminarCliente(idCliente);
						JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente.");
						MenuPrincipal mp=new MenuPrincipal();
						mp.setVisible(true);
						mp.setLocationRelativeTo(null);
						setVisible(false);
					}catch(Exception e){
						e.printStackTrace();
					}
					
				}
				
			}
		});
		btnBaja.setBounds(234, 85, 91, 23);
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
		btnVolver.setBounds(118, 85, 91, 23);
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
