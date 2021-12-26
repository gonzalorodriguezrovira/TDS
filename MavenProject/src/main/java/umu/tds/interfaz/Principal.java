package umu.tds.interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.border.EtchedBorder;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;

public class Principal extends JFrame {

	private JPanel contentPane;
	private PantallaLogin PantallaLogin = new PantallaLogin();
	private JTextField txtUsername;
	private JTextField txtPassword;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal Prueba = new Principal();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Principal() {
		 final JFrame ventana=new JFrame();
		ventana.setResizable(false);
		ventana.setVisible(true);
		ventana.setBackground(new Color(192, 192, 192));
		ventana.setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/imagenes/playPeque.gif")));
		ventana.setTitle("AppVideo");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setBounds(100, 100, 673, 524);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(29, 29, 29));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		ventana.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		final JTabbedPane opcionesNavegacion = new JTabbedPane(JTabbedPane.TOP);
		opcionesNavegacion.setBackground(Color.GRAY);
		opcionesNavegacion.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
//		ventana.getContentPane().add(opcionesNavegacion, BorderLayout.CENTER);
		
		JPanel explorar = new JPanel();
		explorar.setBackground(Color.LIGHT_GRAY);
		opcionesNavegacion.addTab("Explorar", null, explorar, null);
		opcionesNavegacion.setForegroundAt(0, new Color(255,163,26));
		
		JPanel misListas = new JPanel();
		misListas.setBackground(Color.LIGHT_GRAY);
		opcionesNavegacion.addTab("Mis Listas", null, misListas, null);
		opcionesNavegacion.setForegroundAt(1, new Color(255,163,26));
		
		JPanel recientes = new JPanel();
		recientes.setBackground(Color.LIGHT_GRAY);
		opcionesNavegacion.addTab("Recientes", null, recientes, null);
		opcionesNavegacion.setForegroundAt(2, new Color(255,163,26));
		
		JPanel nuevaLista = new JPanel();
		nuevaLista.setBackground(Color.LIGHT_GRAY);
		opcionesNavegacion.addTab("Nueva Lista", null, nuevaLista, null);
		opcionesNavegacion.setForegroundAt(3, new Color(255,163,26));
		
		JPanel barraSuperior = new JPanel();
		barraSuperior.setBackground(new Color(80, 80, 80));
		barraSuperior.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ventana.getContentPane().add(barraSuperior, BorderLayout.NORTH);
		barraSuperior.setLayout(new BoxLayout(barraSuperior, BoxLayout.X_AXIS));
		
		JLabel lApp = new JLabel("App");
		lApp.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/play.gif")));
		lApp.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 14));
		barraSuperior.add(lApp);
		
		JLabel lVideo = new JLabel("Video");
		lVideo.setForeground(new Color(255, 153, 0));
		lVideo.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 18));
		barraSuperior.add(lVideo);
		
		Component rigidArea1_BS = Box.createRigidArea(new Dimension(110, 40));
		barraSuperior.add(rigidArea1_BS);
		
		JButton bRegistro = new JButton("Registro");
		bRegistro.setBackground(Color.LIGHT_GRAY);
		barraSuperior.add(bRegistro);
		
		JButton bLogin = new JButton("Login");
		bLogin.setBackground(Color.LIGHT_GRAY);
		barraSuperior.add(bLogin);
		
		final JPanel inicioSesion = new JPanel();
		inicioSesion.setBackground(Color.LIGHT_GRAY);
		inicioSesion.setVisible(false);
//		contentPane.add(inicioSesion, BorderLayout.SOUTH);
		inicioSesion.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBackground(Color.LIGHT_GRAY);
		verticalBox.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		inicioSesion.add(verticalBox);
		
		Component rigidArea_2_IS = Box.createRigidArea(new Dimension(20, 15));
		verticalBox.add(rigidArea_2_IS);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBackground(Color.WHITE);
		verticalBox.add(horizontalBox);
		
		JLabel lblNewLabel = new JLabel("Login");
		horizontalBox.add(lblNewLabel);
		
		Component rigidArea_3_IS = Box.createRigidArea(new Dimension(47, 20));
		horizontalBox.add(rigidArea_3_IS);
		
		txtUsername = new JTextField();
		horizontalBox.add(txtUsername);
		txtUsername.setColumns(10);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		horizontalBox_1.setBackground(Color.WHITE);
		verticalBox.add(horizontalBox_1);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		horizontalBox_1.add(lblNewLabel_1);
		
		Component rigidArea_4_IS = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_4_IS);
		
		txtPassword = new JTextField();
		txtPassword.setToolTipText("");
		horizontalBox_1.add(txtPassword);
		txtPassword.setColumns(10);
		
		Component rigidArea_5_IS = Box.createRigidArea(new Dimension(20, 80));
		verticalBox.add(rigidArea_5_IS);
		
		Box horizontalBox_2 = Box.createHorizontalBox();
		horizontalBox_2.setBackground(Color.WHITE);
		verticalBox.add(horizontalBox_2);
		
		JButton bAceptarLogin = new JButton("Aceptar");
		horizontalBox_2.add(bAceptarLogin);
		
		Component rigidArea_6_IS = Box.createRigidArea(new Dimension(80, 20));
		horizontalBox_2.add(rigidArea_6_IS);
		
		JButton bCancelarLogin = new JButton("Cancelar");
		horizontalBox_2.add(bCancelarLogin);
		
		Component rigidArea_7_IS = Box.createRigidArea(new Dimension(100, 15));
		verticalBox.add(rigidArea_7_IS);
		
		bLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
/*				opcionesNavegacion.setVisible(false);
				inicioSesion.setVisible(true);
				contentPane.add(inicioSesion, BorderLayout.CENTER);
*/				//TODO lo de los ifs que había puesto Gonzalo, que se hace?? se vuelven a poner o no hacen falta aquí?
			}
		});
		
		bCancelarLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	/*			txtUsername.setText("");
				txtPassword.setText("");
				inicioSesion.setVisible(false);
				opcionesNavegacion.setVisible(true);
				contentPane.add(opcionesNavegacion, BorderLayout.CENTER);
	*/		
				
			}
		});
		
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
		bPremium.setForeground(new Color(255,163,26));
		barraSuperior.add(bPremium);
		
		JPanel layeredPane = new JPanel();
		contentPane.add(layeredPane, BorderLayout.CENTER);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		layeredPane.add(inicioSesion, "name_495881833654300");
		layeredPane.add(opcionesNavegacion, "name_495881833654300");
	}

}
