package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		setTitle("Menu Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		

		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnSucursal = new JMenu("Sucursal");
		menuBar.add(mnSucursal);
		
		JMenuItem mntmAgregar = new JMenuItem("Agregar");
		mntmAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AltaSucursal as=new AltaSucursal();
				as.setVisible(true);
				as.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		mnSucursal.add(mntmAgregar);
		
		JMenuItem mntmModificar = new JMenuItem("Modificar");
		mntmModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModificarSucursal ms=new ModificarSucursal();
				ms.setVisible(true);
				ms.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		mnSucursal.add(mntmModificar);
		
		JMenuItem mntmEliminar = new JMenuItem("Eliminar");
		mntmEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BajaSucursal es=new BajaSucursal();
				es.setVisible(true);
				es.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		mnSucursal.add(mntmEliminar);
		
		JMenuItem mntmAsignarEncargado = new JMenuItem("Asignar Encargado");
		mntmAsignarEncargado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AsignarEncargado ae=new AsignarEncargado();
				ae.setVisible(true);
				ae.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		mnSucursal.add(mntmAsignarEncargado);
		
		JMenu mnEmpleado = new JMenu("Empleado");
		menuBar.add(mnEmpleado);
		
		JMenuItem mntmAgregar_1 = new JMenuItem("Agregar");
		mntmAgregar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AltaEmpleado ae=new AltaEmpleado();
				ae.setVisible(true);
				ae.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		mnEmpleado.add(mntmAgregar_1);
		
		JMenuItem mntmModificar_1 = new JMenuItem("Modificar");
		mntmModificar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModificarEmpleado me=new ModificarEmpleado();
				me.setVisible(true);
				me.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		mnEmpleado.add(mntmModificar_1);
		
		JMenuItem mntmEliminar_1 = new JMenuItem("Eliminar");
		mntmEliminar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BajaEmpleado be=new BajaEmpleado();
				be.setVisible(true);
				be.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		mnEmpleado.add(mntmEliminar_1);
		
		JMenu mnCliente = new JMenu("Cliente");
		menuBar.add(mnCliente);
		
		JMenuItem mntmAgregar_2 = new JMenuItem("Agregar");
		mntmAgregar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AltaCliente ac=new AltaCliente();
				ac.setVisible(true);
				ac.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		mnCliente.add(mntmAgregar_2);
		
		JMenuItem mntmModificar_2 = new JMenuItem("Modificar");
		mntmModificar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModificarCliente mc=new ModificarCliente();
				mc.setVisible(true);
				mc.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		mnCliente.add(mntmModificar_2);
		
		JMenuItem mntmEliminar_2 = new JMenuItem("Eliminar");
		mntmEliminar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BajaCliente bj=new BajaCliente();
				bj.setVisible(true);
				bj.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		mnCliente.add(mntmEliminar_2);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		JMenu mnMateriales = new JMenu("Materiales");
		menuBar.add(mnMateriales);
		
		JMenuItem mntmAltaMaterial = new JMenuItem("Alta Material");
		mntmAltaMaterial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AltaMaterial am=new AltaMaterial();
				am.setVisible(true);
				am.setLocationRelativeTo(null);
				setVisible(false);					
			}
		});
		mnMateriales.add(mntmAltaMaterial);
		
		JMenu mnPrendas = new JMenu("Prendas");
		menuBar.add(mnPrendas);
		
		JMenuItem mntmAltaPrendas = new JMenuItem("Alta Prendas");
		mntmAltaPrendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AltaPrenda ap=new AltaPrenda();
				ap.setVisible(true);
				ap.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		mnPrendas.add(mntmAltaPrendas);
		menuBar.add(mntmSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel imgClothes = new JLabel("");
		imgClothes.setHorizontalAlignment(SwingConstants.CENTER);
		imgClothes.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/images/clothes.png")));
		imgClothes.setBounds(157, 64, 128, 110);
		contentPane.add(imgClothes);
		
		JLabel lblLaSaladita = new JLabel("GutGekleidetWurst");
		lblLaSaladita.setHorizontalAlignment(SwingConstants.CENTER);
		lblLaSaladita.setFont(new Font("Serif", Font.BOLD, 28));
		lblLaSaladita.setBounds(75, 11, 274, 42);
		contentPane.add(lblLaSaladita);
		contentPane.repaint();
	}
	
	
}
