package umu.tds.nuevoInterfaz;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;

public class AppVideo extends JFrame {

	private JPanel contentPane;
	// IDENTIFICADORES DE LAS DISTINTAS VENTANAS
	final static String INICIO_SESION = "Inicio de sesion";
	final static String BRUH = "borrame cuando tengas ventana de inicio";
	final static String REGISTRO = "Registro de usuario";
	final static String EXPLORAR = "Explorar videos";
	final static String MIS_LISTAS = "Buscar en las listas de usuario";
	// VENTANAS
	final static JPanel vDisplay = new JPanel(new CardLayout(0, 0));
	
	private InicioSesion pIS = new InicioSesion();
	private PantallaBase pPB = new PantallaBase();
	private Registro pR = new Registro();
	private Explorar pE = new Explorar();
	private MisListas pML = new MisListas();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppVideo frame = new AppVideo();
					// frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	/**
	 * Create the frame.
	 */
	public AppVideo() {

		JFrame ventana = new JFrame();
		ventana.setResizable(false);
		ventana.setVisible(true);
		ventana.setBackground(new Color(192, 192, 192));
		ventana.setIconImage(
				Toolkit.getDefaultToolkit().getImage(AppVideo.class.getResource("/imagenes/playPeque.gif")));
		ventana.setTitle("AppVideo");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setBounds(100, 100, 707, 639);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(29, 29, 29));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		ventana.setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 603, 0 };
		gbl_contentPane.rowHeights = new int[] { 44, 32, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JPanel barraSuperior = new JPanel();
		barraSuperior.setBackground(new Color(80, 80, 80));
		barraSuperior.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GridBagConstraints gbc_barraSuperior = new GridBagConstraints();
		gbc_barraSuperior.fill = GridBagConstraints.HORIZONTAL;
		gbc_barraSuperior.anchor = GridBagConstraints.NORTH;
		gbc_barraSuperior.insets = new Insets(0, 0, 5, 0);
		gbc_barraSuperior.gridx = 0;
		gbc_barraSuperior.gridy = 0;
		ventana.getContentPane().add(barraSuperior, gbc_barraSuperior);
		barraSuperior.setLayout(new BoxLayout(barraSuperior, BoxLayout.X_AXIS));

		JLabel lApp = new JLabel("App");
		lApp.setIcon(new ImageIcon(AppVideo.class.getResource("/imagenes/play.gif")));
		lApp.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 14));
		barraSuperior.add(lApp);

		JLabel lVideo = new JLabel("Video");
		lVideo.setForeground(new Color(255, 153, 0));
		lVideo.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 18));
		barraSuperior.add(lVideo);

		Component rigidArea1_BS = Box.createRigidArea(new Dimension(125, 40));
		barraSuperior.add(rigidArea1_BS);

		JButton bRegistro = new JButton("Registro");
		bRegistro.setBackground(Color.LIGHT_GRAY);
		barraSuperior.add(bRegistro);

		JButton bLogin = new JButton("Login");
		bLogin.setBackground(Color.LIGHT_GRAY);
		barraSuperior.add(bLogin);

		Component rigidArea_2_BS = Box.createRigidArea(new Dimension(40, 40));
		barraSuperior.add(rigidArea_2_BS);

		JButton bLogout = new JButton("Logout");
		bLogout.setBackground(Color.LIGHT_GRAY);
		barraSuperior.add(bLogout);

		Component rigidArea_3_BS = Box.createRigidArea(new Dimension(40, 40));
		barraSuperior.add(rigidArea_3_BS);

		JButton bPremium = new JButton("Premium");
		bPremium.setFont(new Font("Tahoma", Font.BOLD, 12));
		bPremium.setBackground(Color.BLACK);
		bPremium.setForeground(new Color(255, 163, 26));
		barraSuperior.add(bPremium);

		JPanel barraExploracion = new JPanel();
		barraExploracion.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		barraExploracion.setBackground(new Color(80, 80, 80));
		GridBagConstraints gbc_barraExploracion = new GridBagConstraints();
		gbc_barraExploracion.insets = new Insets(0, 0, 5, 0);
		gbc_barraExploracion.fill = GridBagConstraints.HORIZONTAL;
		gbc_barraExploracion.anchor = GridBagConstraints.NORTH;
		gbc_barraExploracion.gridx = 0;
		gbc_barraExploracion.gridy = 1;
		contentPane.add(barraExploracion, gbc_barraExploracion);
		barraExploracion.setLayout(new BoxLayout(barraExploracion, BoxLayout.X_AXIS));

		Component rigidArea_1 = Box.createRigidArea(new Dimension(4, 20));
		barraExploracion.add(rigidArea_1);

		JButton bExplorar = new JButton("Explorar");
		bExplorar.setBackground(Color.LIGHT_GRAY);
		barraExploracion.add(bExplorar);

		JButton bMisListas = new JButton("Mis Listas");
		bMisListas.setBackground(Color.LIGHT_GRAY);
		barraExploracion.add(bMisListas);

		JButton bRecientes = new JButton("Recientes");
		bRecientes.setBackground(Color.LIGHT_GRAY);
		barraExploracion.add(bRecientes);

		JButton bNuevaLista = new JButton("Nueva Lista");
		bNuevaLista.setBackground(Color.LIGHT_GRAY);
		barraExploracion.add(bNuevaLista);

		Component rigidArea = Box.createRigidArea(new Dimension(4, 28));
		barraExploracion.add(rigidArea);

		
		GridBagConstraints gbc_vDisplay = new GridBagConstraints();
		gbc_vDisplay.fill = GridBagConstraints.BOTH;
		gbc_vDisplay.gridx = 0;
		gbc_vDisplay.gridy = 2;
		contentPane.add(vDisplay, gbc_vDisplay);
		
		vDisplay.add(pPB, BRUH);
		vDisplay.add(pIS, INICIO_SESION);
		vDisplay.add(pE, EXPLORAR);
		vDisplay.add(pR, REGISTRO);
		vDisplay.add(pML, MIS_LISTAS);
		
		CardLayout c = (CardLayout)(vDisplay.getLayout());
		bLogin.addActionListener(ev -> c.show(vDisplay, INICIO_SESION));
		/*
		bLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout)(vDisplay.getLayout());
				c.show(vDisplay, INICIO_SESION);
			}
		});
		*/
		bRegistro.addActionListener(ev -> c.show(vDisplay, REGISTRO));
		/*
		bRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout)(vDisplay.getLayout());
				c.show(vDisplay, REGISTRO);
			}
		});
		*/
		bExplorar.addActionListener(ev -> c.show(vDisplay, EXPLORAR));
		/*
		bExplorar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout)(vDisplay.getLayout());
				c.show(vDisplay, EXPLORAR);
			}
		});
		*/
		bMisListas.addActionListener(ev -> c.show(vDisplay, MIS_LISTAS));
		/*
		bMisListas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout)(vDisplay.getLayout());
				c.show(vDisplay, MIS_LISTAS);
			}
		});
		*/
	}

}
