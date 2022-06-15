package vista;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import controlador.App;
import modelo.Etiqueta;
import modelo.Video;

import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.plaf.DimensionUIResource;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.border.BevelBorder;
import java.awt.CardLayout;
import javax.swing.ListSelectionModel;
import java.awt.BorderLayout;

public class Explorar extends JPanel {

	private static final long serialVersionUID = 1L;

	// JSCOLL
	private JScrollPane scrollListaVideos;

	// CONTROL PANELES
	private boolean control;

	//
	private final static String PANTALLA_VIDEOS = "";
	private final static String REPRODUCTOR = "";

	// PANELES
	private JPanel panelBusqueda;
	private JPanel panelEtiquetas;
	private static JPanel panel;
	private static JPanel panelReproductor;
	private static JPanel panelVideosBuscados;
	// LISTAS
	private JList<String> listaSeleccionados;
	private JList<String> listaEtiquetas;
	private JList<Miniatura> listaVideos;

	// MODELOS
	private DefaultListModel<String> modeloEtiquetas;
	private DefaultListModel<String> modeloEtiqSeleccionadas;
	private DefaultListModel<Miniatura> modeloVideos;

	// VIDEOS
	private List<Video> Videos;

	// NOMBRE DEL VIDEO A BUSCAR
	private JTextField txtNombre;

	// FILTROS
	private JComboBox<?> filtros;

	// ETIQUETAS
	private String[] etiquetas;

	// BOTONES
	private JButton bBuscar;
	private JButton bNuevaBusqueda;
	private JButton bReproducir;

	public Explorar(AppVideo v) {
		// COLOR DE FONDO
		setBackground(Color.GRAY);
		setLayout(null);

		// ASIGNACIÓN VALORES PANEL BUSCAR
		inicializarPanelBuscar();

		// ASIGNACIÓN VALORES PANEL ETIQUETAS
		inicializarPanelEtiquetas();

		// ASIGNACIÓN VALORES SCROLLPANEL DE VIDEOS
		inicializarScrollPanelVideos();

		// INICIALIZAR PANEL DE REPRODUCCIÓN

		Box verticalBox_1 = Box.createVerticalBox();
		panelReproductor.add(verticalBox_1);

		Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_1.add(rigidArea_3);

		Box horizontalBox_6 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_6);

		JLabel txtTitulo = new JLabel("Titulo");
		txtTitulo.setVisible(false);
		txtTitulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		horizontalBox_6.add(txtTitulo);

		Component rigidArea_4 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_1.add(rigidArea_4);

		JPanel pVideo = new JPanel();
		pVideo.setVisible(false);
		verticalBox_1.add(pVideo);

		Component rigidArea_10 = Box.createRigidArea(new Dimension(450, 20));
		verticalBox_1.add(rigidArea_10);

		// **********************************************************
		// *************************************************ACCIONES
		// BOTONES**************************************************
		listaEtiquetas.addMouseListener(new MouseAdapter() {
			String aux;

			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1 && !modeloEtiquetas.contains("\r")) {
					aux = modeloEtiquetas.remove(listaEtiquetas.getSelectedIndex());
					if (modeloEtiqSeleccionadas.contains("\r"))
						modeloEtiqSeleccionadas.remove(0);
					if (modeloEtiquetas.isEmpty())
						modeloEtiquetas.add(0, "\r");
					listaEtiquetas.revalidate();
					modeloEtiqSeleccionadas.addElement(aux);
					listaSeleccionados.revalidate();
				}
			}
		});

		listaSeleccionados.addMouseListener(new MouseAdapter() {
			String aux;

			public void mouseClicked(MouseEvent e) {
				if (listaSeleccionados.getSelectedIndex() == -1)
					return;
				if (e.getClickCount() == 1 && !modeloEtiqSeleccionadas.contains("\r")) {
					aux = modeloEtiqSeleccionadas.remove(listaSeleccionados.getSelectedIndex());
					if (modeloEtiquetas.contains("\r"))
						modeloEtiquetas.remove(0);
					if (modeloEtiqSeleccionadas.isEmpty())
						modeloEtiqSeleccionadas.add(0, "\r");
					listaSeleccionados.revalidate();
					;
					modeloEtiquetas.addElement(aux);
					listaEtiquetas.revalidate();
				}
			}
		});

		bBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<String> ll = new LinkedList<String>();
				for (Object o : modeloEtiqSeleccionadas.toArray()) {
					if (!o.equals("\r"))
						ll.add((String) o);
				}
				mostrarVideos();
			}
		});

		bNuevaBusqueda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modeloVideos.removeAllElements();
				listaVideos.revalidate();
				if (!control) {
					for (Component c : pVideo.getComponents())
						pVideo.remove(c);
					App.getInstancia().pararVideo();
					pVideo.revalidate();
					pVideo.repaint();
					CardLayout c = (CardLayout) (panel.getLayout());
					c.removeLayoutComponent(panelReproductor);
					control = true;

				}
			}
		});

		bReproducir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (control) {
					int index = listaVideos.getSelectedIndex();
					if (index != -1) {
						Video v = App.getInstancia().findVideoURL((modeloVideos.get(index).getUrl()));
						v = App.getInstancia().incrementarVisualizaciones(v);
						CardLayout c = (CardLayout) (panel.getLayout());
						panel.add(panelReproductor, REPRODUCTOR);
						c.show(panel, REPRODUCTOR);
						App.getInstancia().pararVideo();
						pVideo.remove(main.Lanzador.videoWeb);
						pVideo.add(main.Lanzador.videoWeb);
						txtTitulo.setText(v.getTitulo());
						v = App.getInstancia().incrementarVisualizaciones(v);
						txtTitulo.setVisible(true);
						pVideo.setVisible(true);
						App.getInstancia().reproducirVideo(v);
						validate();
						control = false;
					}
				}
			}
		});
		// *******************************************************************************************************************
	}

	// ******************************************************MÉTODOS******************************************************
	public void cargarEtiquetas() {
		int i = 0;
		List<Etiqueta> listaEtiquetas = App.getInstancia().recuperarEtiquetas();
		etiquetas = new String[listaEtiquetas.size()];
		for (Etiqueta e : listaEtiquetas) {
			etiquetas[i] = e.getNombre();
			i++;
		}
	}

	public void actualizarEtiquetas() {
		modeloEtiqSeleccionadas.clear();
		modeloEtiquetas.clear();
		for (String valor : etiquetas) {
			modeloEtiquetas.addElement(valor);
		}
		System.out.println(modeloEtiquetas);
		listaEtiquetas.revalidate();
		listaSeleccionados.revalidate();
	}

	public void habilitarFiltros(boolean ispremium) {
		filtros.setEnabled(ispremium);
	}
	// *******************************************************************************************************************

	// **************************************************INICIALIZADORES**************************************************

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void inicializarPanelBuscar() {
		panelBusqueda = new JPanel();
		panelBusqueda.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelBusqueda.setBackground(Color.GRAY);
		panelBusqueda.setBounds(0, 0, 528, 107);
		add(panelBusqueda);
		panelBusqueda.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		Box verticalBox = Box.createVerticalBox();
		panelBusqueda.add(verticalBox);

		Component rigidArea_1 = Box.createRigidArea(new Dimension(420, 20));
		verticalBox.add(rigidArea_1);

		Box horizontalBox = Box.createHorizontalBox();
		verticalBox.add(horizontalBox);

		JLabel lblNewLabel = new JLabel("Buscar titulo: ");
		lblNewLabel.setForeground(Color.WHITE);
		horizontalBox.add(lblNewLabel);

		txtNombre = new JTextField();
		horizontalBox.add(txtNombre);
		txtNombre.setColumns(10);

		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox.add(rigidArea);

		bBuscar = new JButton("Buscar");
		horizontalBox.add(bBuscar);

		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox.add(rigidArea_2);

		Box horizontalBox_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1);

		filtros = new JComboBox<>();
		filtros.setEnabled(false);
		filtros.setModel(new DefaultComboBoxModel(new String[] { "NoFiltro", "Menores", "MisListas" }));
		horizontalBox_1.add(filtros);

		Component rigidArea_3 = Box.createRigidArea(new Dimension(170, 20));
		horizontalBox_1.add(rigidArea_3);

		bReproducir = new JButton("Reproducir");
		horizontalBox_1.add(bReproducir);

		Component rigidArea_4 = Box.createRigidArea(new Dimension(39, 20));
		horizontalBox_1.add(rigidArea_4);

		bNuevaBusqueda = new JButton("Nueva búsqueda");
		horizontalBox_1.add(bNuevaBusqueda);
	}

	private void inicializarPanelEtiquetas() {
		cargarEtiquetas(); 
		panelEtiquetas = new JPanel();
		panelEtiquetas.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelEtiquetas.setBackground(Color.GRAY);
		panelEtiquetas.setBounds(526, 0, 164, 510);
		add(panelEtiquetas);

		Box verticalBox_1 = Box.createVerticalBox();
		panelEtiquetas.add(verticalBox_1);

		Component rigidArea_4 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_1.add(rigidArea_4);

		Box horizontalBox_2 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_2);

		JLabel lblNewLabel_1 = new JLabel("Etiquetas disponibles");
		lblNewLabel_1.setForeground(Color.WHITE);
		horizontalBox_2.add(lblNewLabel_1);

		Component rigidArea_4_1 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_1.add(rigidArea_4_1);

		listaEtiquetas = new JList<String>();
		modeloEtiquetas = new DefaultListModel<String>();
		for (String valor : etiquetas) {
			modeloEtiquetas.addElement(valor);
		}
		listaEtiquetas.setModel(modeloEtiquetas);
		listaEtiquetas.setSelectedIndex(0);

		JScrollPane scrollLista = new JScrollPane(listaEtiquetas);
		scrollLista.setPreferredSize(new DimensionUIResource(150, 150));
		verticalBox_1.add(scrollLista);

		Component rigidArea_5 = Box.createRigidArea(new Dimension(20, 75));
		verticalBox_1.add(rigidArea_5);

		Box horizontalBox_3 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_3);

		JLabel lblNewLabel_2 = new JLabel("Buscar etiquetas");
		lblNewLabel_2.setForeground(Color.WHITE);
		horizontalBox_3.add(lblNewLabel_2);

		Component rigidArea_4_1_1 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_1.add(rigidArea_4_1_1);
		listaSeleccionados = new JList<String>();

		modeloEtiqSeleccionadas = new DefaultListModel<String>();
		modeloEtiqSeleccionadas.addElement("\r");

		listaSeleccionados.setModel(modeloEtiqSeleccionadas);
		listaSeleccionados.setSelectedIndex(0);

		JScrollPane scrollLista1 = new JScrollPane(listaSeleccionados);
		scrollLista1.setPreferredSize(new DimensionUIResource(150, 150));
		verticalBox_1.add(scrollLista1);

	}

	private void inicializarScrollPanelVideos() {
		listaVideos = new JList<Miniatura>();
		listaVideos.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		listaVideos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaVideos.setVisibleRowCount(-1);
		modeloVideos = new DefaultListModel<Miniatura>();
		control = true;
		panel = new JPanel();
		panelReproductor = new JPanel();
		panel.setLayout(new CardLayout(0, 0));
		panelVideosBuscados = new JPanel();
		panelVideosBuscados.setLayout(new BorderLayout(0, 0));
		scrollListaVideos = new JScrollPane(listaVideos);
		listaVideos.setModel(modeloVideos);
		panelVideosBuscados.add(scrollListaVideos);
		panel.add(panelVideosBuscados, PANTALLA_VIDEOS);

		panel.setBackground(Color.GRAY);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(0, 107, 528, 403);
		add(panel);
		Videos = new LinkedList<Video>();

	}
	//******************************************************MÉTODOS******************************************************
	public void mostrarVideos() {
		modeloVideos.clear();
		List<String> ll = new LinkedList<String>();
		for (Object o : modeloEtiqSeleccionadas.toArray()) {
			if (!o.equals("\r"))
				ll.add((String) o);
		}

		Videos = App.getInstancia().busquedaDeVideos(txtNombre.getText(), (String) filtros.getSelectedItem(), ll);
		for (Video v : Videos) {
			Miniatura m = new Miniatura(v, 150, 150);
			modeloVideos.addElement(m);
		}
		listaVideos.setCellRenderer(new VideoListRenderer());
		listaVideos.revalidate();
		listaVideos.setSelectedIndex(0);

	}
}
