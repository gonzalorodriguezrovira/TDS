package vista;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import com.itextpdf.text.DocumentException;

import controlador.App;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class AppVideo extends JFrame {
	
	private static final long serialVersionUID = 1L;
	//VENTANA APLICACIÓN
	private JFrame ventana;
	//PANEL PRINCIPAL
	private JPanel contentPane;
	//PANEL PARA LA BARRA SUPERIOR
	private JPanel barraSuperior;
	//PANEL PARA LA BARRA DE EXPLORACIÓN
	private JPanel barraExploracion;
	
	
	// IDENTIFICADORES DE LAS DISTINTAS VENTANAS
	final static String INICIO_SESION = "Inicio de sesion";
	final static String REGISTRO = "Registro de usuario";
	final static String EXPLORAR = "Explorar videos";
	final static String MIS_LISTAS = "Buscar en las listas de usuario";
	final static String NUEVA_LISTA = "Crear nuevas listas";
	final static String RECIENTES = "Lista de videos recientes";

	// VENTANAS
	final static JPanel vDisplay = new JPanel(new CardLayout(0, 0));
	private InicioSesion pIS = new InicioSesion(this);
	private Registro pR = new Registro(this);
	private Explorar pE = new Explorar(this);
	private MisListas pML = new MisListas(this);
	private NuevaLista pNL = new NuevaLista(this);
	private Recientes pRE = new Recientes(this);
	
	// BOTONES
	private JButton bLogin;
	private JButton bRegistro;
	private JButton bLogout;
	private JButton bExplorar;  
	private JButton bMisListas;
	private JButton bRecientes;
	private JButton bNuevaLista;
	private JButton bPremium;
	private JButton bGenerarPDF;
	
	// INFORMACIÓN SOBRE EL USUARIO ACTUAL
	private JLabel lbUsuario;
	private boolean premium;
	private Component rigidArea_3;

	public AppVideo() {
		//ASIGNACIÓN DE LOS VALORES DE LA VENTANA DE LA APP
		inicializarVentana();
		
		//ASIGNACIÓN DE LOS VALORES DEL PANEL CONTENEDOR
		inicializarContent();
		
		//ASIGNACIÓN DE LOS VALORES DE LA BARRA SUPERIOR
		inicializarBarraSuperior();

		//ASIGNACIÓN DE LOS VALORES DE LA BARRA DE EXPLORACIÓN
		inicializarBarraExploracion();

		//ASIGNACIÓN DE LOS VALORES DE LA VENTANA CAMBIANTE
		inicializarVentanaCambiante();

		//*************************************************ACCIONES BOTONES**************************************************
		CardLayout c = (CardLayout) (vDisplay.getLayout());
		bLogin.addActionListener(ev -> c.show(vDisplay, INICIO_SESION));
		
		bRegistro.addActionListener(ev -> c.show(vDisplay, REGISTRO));
		
		bExplorar.addActionListener(ev -> c.show(vDisplay, EXPLORAR));
		
		bMisListas.addActionListener(ev -> c.show(vDisplay, MIS_LISTAS));
		
		bLogout.addActionListener(ev -> cierreSesion());

		bPremium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				premium = App.getUnicaInstancia().usuarioSetPremium();
				cambiarPremium();
			}
		});
		
		bNuevaLista.addActionListener(ev -> c.show(vDisplay, NUEVA_LISTA));
		
		bRecientes.addActionListener(ev -> c.show(vDisplay, RECIENTES));
		
		bGenerarPDF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					generarPDF();
				} catch (DocumentException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//*******************************************************************************************************************
	}
	
	//******************************************************MÉTODOS******************************************************
	public String getUsuario() {
		return lbUsuario.getText();
	}
	
	void setUsuario(String usuario) {
		lbUsuario.setText(usuario);
	}

	public void cambiarPremium() {
		premium = App.getUnicaInstancia().getUsuarioActual().isPremium();
		if(premium) {
			bGenerarPDF.setEnabled(true);
			bPremium.setText("NoPremium");
		}
		else {
			bGenerarPDF.setEnabled(false);
			bPremium.setText("Premium");
		}
		pE.habilitarFiltros(premium);
		pRE.habilitar();
	}
	
	public void registrarUsuario(String nombre, String apellidos, String email, String usuario, String password,
			Date nacimiento) {
		if (App.getUnicaInstancia().registrarUsuario(nombre, apellidos, email, usuario, password, nacimiento)) {
			CardLayout c = (CardLayout) (vDisplay.getLayout());
			c.show(vDisplay, INICIO_SESION);
		}
	}

	public void inicioValido(String nombre) {
		setUsuario(nombre);
		pML.inicializarLista();
		pRE.inicializarLista();
		CardLayout c = (CardLayout) (vDisplay.getLayout());
		c.show(vDisplay, EXPLORAR);
		bRegistro.setEnabled(false);
		bLogin.setEnabled(false);
		lbUsuario.setVisible(true);
		bMisListas.setEnabled(true);
		bRecientes.setEnabled(true);
		bNuevaLista.setEnabled(true);
		bExplorar.setEnabled(true);
		bPremium.setEnabled(true);
		bLogout.setEnabled(true);
		cambiarPremium();
		//pRE.inicializarRecientes();
	}

	public void cierreSesion() {
		if (!getUsuario().equals("")) {
			pNL.vaciar();
			CardLayout c = (CardLayout) (vDisplay.getLayout());
			c.show(vDisplay, INICIO_SESION);
			setUsuario("");
			App.getUnicaInstancia().setUsuarioActual(null);
			bGenerarPDF.setEnabled(false);
			bRegistro.setEnabled(true);
			bLogin.setEnabled(true);
			bMisListas.setEnabled(false);
			bRecientes.setEnabled(false);
			bNuevaLista.setEnabled(false);
			lbUsuario.setVisible(false);
			bExplorar.setEnabled(false);
			bPremium.setEnabled(false);
			bLogout.setEnabled(false);
			bPremium.setText("Premium");
		}
	}
	
	public void actualizarEtiquetasExplorar(){
		pE.cargarEtiquetas();
		pE.actualizarEtiquetas();
	}
	
	public void generarPDF() throws DocumentException, MalformedURLException, IOException {
		App.getUnicaInstancia().generarPDF();
	}
	//*******************************************************************************************************************
	
	//**************************************************INICIALIZADORES**************************************************
	private void inicializarVentana() {
		ventana = new JFrame();
		ventana.setResizable(false);
		ventana.setVisible(true);
		ventana.setBackground(new Color(192, 192, 192));
		ventana.setIconImage(
				Toolkit.getDefaultToolkit().getImage(AppVideo.class.getResource("/imagenes/playPeque.gif")));
		ventana.setTitle("AppVideo");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setBounds(100, 100, 707, 639);
	}
	
	private void inicializarContent() {
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
	}
	
	private void inicializarBarraSuperior() {
		barraSuperior = new JPanel();
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
		
		//COMPONENTES DE LA BARRA SUPERIOR
		JLabel lApp = new JLabel("App");
		lApp.setIcon(new ImageIcon(AppVideo.class.getResource("/imagenes/play.gif")));
		lApp.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 14));
		barraSuperior.add(lApp);
		
		JLabel lVideo = new JLabel("Video");
		lVideo.setForeground(new Color(255, 153, 0));
		lVideo.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 18));
		barraSuperior.add(lVideo);
		
		rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
		barraSuperior.add(rigidArea_3);
		
		bGenerarPDF = new JButton("Generar PDF");
		bGenerarPDF.setEnabled(false);
		bGenerarPDF.setBackground(Color.LIGHT_GRAY);
		barraSuperior.add(bGenerarPDF);

		Component rigidArea1_BS = Box.createRigidArea(new Dimension(35, 40));
		barraSuperior.add(rigidArea1_BS);

		bRegistro = new JButton("Registro");
		bRegistro.setBackground(Color.LIGHT_GRAY);
		barraSuperior.add(bRegistro);

		bLogin = new JButton("Login");
		bLogin.setBackground(Color.LIGHT_GRAY);
		barraSuperior.add(bLogin);

		Component rigidArea_2_BS = Box.createRigidArea(new Dimension(35, 40));
		barraSuperior.add(rigidArea_2_BS);

		bLogout = new JButton("Logout");
		bLogout.setEnabled(false);

		bLogout.setBackground(Color.LIGHT_GRAY);
		barraSuperior.add(bLogout);

		Component rigidArea_3_BS = Box.createRigidArea(new Dimension(35, 40));
		barraSuperior.add(rigidArea_3_BS);

		bPremium = new JButton("Premium");
		bPremium.setEnabled(false);
		bPremium.setFont(new Font("Tahoma", Font.BOLD, 12));
		bPremium.setBackground(Color.BLACK);
		bPremium.setForeground(new Color(255, 163, 26));
		barraSuperior.add(bPremium);
	}
	
	private void inicializarBarraExploracion() {
		barraExploracion = new JPanel();
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

		//COMPONENTES DE LA BARRA DE EXPLORACIÓN
		Component rigidArea_1 = Box.createRigidArea(new Dimension(4, 20));
		barraExploracion.add(rigidArea_1);

		bExplorar = new JButton("Explorar");
		bExplorar.setEnabled(false);
		bExplorar.setBackground(Color.LIGHT_GRAY);
		barraExploracion.add(bExplorar);

		bMisListas = new JButton("Mis Listas");
		bMisListas.setBackground(Color.LIGHT_GRAY);
		barraExploracion.add(bMisListas);
		bMisListas.setEnabled(false);

		bRecientes = new JButton("Recientes");
		bRecientes.setBackground(Color.LIGHT_GRAY);
		barraExploracion.add(bRecientes);
		bRecientes.setEnabled(false);

		bNuevaLista = new JButton("Nueva Lista");
		bNuevaLista.setBackground(Color.LIGHT_GRAY);
		barraExploracion.add(bNuevaLista);
		bNuevaLista.setEnabled(false);

		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		barraExploracion.add(rigidArea_2);

		Component rigidArea = Box.createRigidArea(new Dimension(4, 28));
		barraExploracion.add(rigidArea);

		lbUsuario = new JLabel("");
		lbUsuario.setForeground(Color.ORANGE);
		barraExploracion.add(lbUsuario);
		lbUsuario.setVisible(false);
	}
	
	private void inicializarVentanaCambiante() {
		GridBagConstraints gbc_vDisplay = new GridBagConstraints();
		gbc_vDisplay.fill = GridBagConstraints.BOTH;
		gbc_vDisplay.gridx = 0;
		gbc_vDisplay.gridy = 2;
		contentPane.add(vDisplay, gbc_vDisplay);
		
		vDisplay.add(pIS, INICIO_SESION);
		vDisplay.add(pE, EXPLORAR);
		vDisplay.add(pR, REGISTRO);
		vDisplay.add(pML, MIS_LISTAS);
		vDisplay.add(pNL, NUEVA_LISTA);
		vDisplay.add(pRE, RECIENTES);
	}
	
	public void actualizarListavideos() {
		pML.inicializarLista();
	}
	//*******************************************************************************************************************
}
