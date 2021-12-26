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

public class Prueba extends JFrame {

	private JPanel contentPane;
	private PantallaLogin PantallaLogin = new PantallaLogin();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prueba Prueba = new Prueba();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Prueba() {
		 final JFrame ventana=new JFrame();
		ventana.setResizable(false);
		ventana.setVisible(true);
		ventana.setBackground(new Color(192, 192, 192));
		ventana.setIconImage(Toolkit.getDefaultToolkit().getImage(Prueba.class.getResource("/imagenes/playPeque.gif")));
		ventana.setTitle("AppVideo");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setBounds(100, 100, 673, 524);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(29, 29, 29));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));<>
		ventana.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.ORANGE);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		ventana.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel explorar = new JPanel();
		explorar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255,163,26), new Color(255,163,26)));
		explorar.setBackground(Color.GRAY);
		tabbedPane.addTab("Explorar", null, explorar, null);
		tabbedPane.setForegroundAt(0, new Color(255,163,26));
		
		JPanel misListas = new JPanel();
		misListas.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255,163,26), new Color(255,163,26)));
		misListas.setBackground(Color.GRAY);
		tabbedPane.addTab("Mis Listas", null, misListas, null);
		tabbedPane.setForegroundAt(1, new Color(255,163,26));
		
		JPanel recientes = new JPanel();
		recientes.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255,163,26), new Color(255,163,26)));
		recientes.setBackground(Color.GRAY);
		tabbedPane.addTab("Recientes", null, recientes, null);
		tabbedPane.setForegroundAt(2, new Color(255,163,26));
		
		JPanel nuevaLista = new JPanel();
		nuevaLista.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255,163,26), new Color(255,163,26)));
		nuevaLista.setBackground(Color.GRAY);
		tabbedPane.addTab("Nueva Lista", null, nuevaLista, null);
		tabbedPane.setForegroundAt(3, new Color(255,163,26));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(80, 80, 80));
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ventana.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JLabel lApp = new JLabel("App");
		lApp.setIcon(new ImageIcon(Prueba.class.getResource("/imagenes/play.gif")));
		lApp.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 14));
		panel.add(lApp);
		
		JLabel lVideo = new JLabel("Video");
		lVideo.setForeground(new Color(255, 153, 0));
		lVideo.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 18));
		panel.add(lVideo);
		
		Component rigidArea = Box.createRigidArea(new Dimension(150, 40));
		panel.add(rigidArea);
		
		JButton bRegistro = new JButton("Registro");
		bRegistro.setBackground(Color.BLACK);
		panel.add(bRegistro);
		
		JButton bLogin = new JButton("Login");
		bLogin.setBackground(Color.BLACK);
		panel.add(bLogin);
		bLogin.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if (ventana.getContentPane()==contentPane){
					ventana.setContentPane(PantallaLogin);
					ventana.revalidate();
					
				} else {
					ventana.setContentPane(contentPane);
					ventana.revalidate();
				}

				
			}
		});
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(40, 40));
		panel.add(rigidArea_1);
		
		JButton bLogout = new JButton("Logout");
		bLogout.setBackground(Color.BLACK);
		panel.add(bLogout);
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(40, 40));
		panel.add(rigidArea_2);
		
		JButton bPremium = new JButton("Premium");
		bPremium.setFont(new Font("Tahoma", Font.BOLD, 12));
		bPremium.setBackground(Color.BLACK);
		bPremium.setForeground(new Color(255,163,26));
		panel.add(bPremium);
		
	}

}
