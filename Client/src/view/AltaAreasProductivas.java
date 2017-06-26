package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import dto.AreaProductivaDTO;
import dto.LineaProductivaDTO;
import businessDelegate.BusinessDelegate;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class AltaAreasProductivas extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtLineas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaAreasProductivas frame = new AltaAreasProductivas();
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
	public AltaAreasProductivas() {
		setTitle("Alta Areas Productivas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 225);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreDelArea = new JLabel("Nombre del Area Productiva:");
		lblNombreDelArea.setBounds(10, 33, 195, 14);
		contentPane.add(lblNombreDelArea);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(215, 30, 195, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblCantidadDeLineas = new JLabel("Cantidad de Lineas Productivas:");
		lblCantidadDeLineas.setBounds(10, 85, 195, 14);
		contentPane.add(lblCantidadDeLineas);
		
		txtLineas = new JTextField();
		txtLineas.setColumns(10);
		txtLineas.setBounds(215, 82, 55, 20);
		contentPane.add(txtLineas);
		
		JButton btnAlta = new JButton("Alta");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				String nombreAreaProductiva=txtNombre.getText();
				Integer numeroLineasProducticas=Integer.parseInt(txtLineas.getText());
				AreaProductivaDTO ap=new AreaProductivaDTO();
				ap.setNombre(nombreAreaProductiva);
				ap.setActivo(true);
				List<LineaProductivaDTO> llp=new ArrayList<LineaProductivaDTO>();
				for(int i=0;i<=numeroLineasProducticas;i++){
					LineaProductivaDTO lpdto=new LineaProductivaDTO();
					lpdto.setActivo(true);
					lpdto.setEstado("Libre");
					llp.add(lpdto);
				}
				ap.setLineas(llp);
					//BusinessDelegate.getInstancia().agr
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		btnAlta.setBounds(319, 143, 91, 23);
		contentPane.add(btnAlta);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuPrincipal mp=new MenuPrincipal();
				mp.setVisible(true);
				mp.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		btnVolver.setBounds(218, 143, 91, 23);
		contentPane.add(btnVolver);
	}
}
