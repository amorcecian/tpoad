package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class AltaPrenda extends JFrame {

	private JPanel contentPane;

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
		setBounds(100, 100, 450, 362);
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
	}
}
