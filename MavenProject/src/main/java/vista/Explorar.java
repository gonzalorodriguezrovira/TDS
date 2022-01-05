package vista;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Flow.Subscription;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import controlador.App;
import modelo.Etiqueta;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

public class Explorar extends JPanel {
	//PANELES
	private JPanel panelBusqueda;
	private JPanel panelEtiquetas;
	
	//LISTAS
	JList<String> listaSeleccionados;
	JList<String> listaEtiquetas;
	
	//MODELOS
	DefaultListModel<String> modeloEtiquetas;
	DefaultListModel<String> modeloEtiqSeleccionadas;
	
	//NOMBRE DEL VIDEO A BUSCAR
	private JTextField txtNombre;
	
	//FILTROS
	private JComboBox filtros;
	
	//ETIQUETAS
	private String[] etiquetas;
	
	//BOTONES
	private JButton bBuscar;
	private JButton bNuevaBusqueda;
	
	public Explorar(AppVideo v) {
		//COLOR DE FONDO
		setBackground(Color.GRAY);
		setLayout(null);
		
		//ASIGNACIÓN VALORES PANEL BUSCAR
		inicializarPanelBuscar();
		
		//ASIGNACIÓN VALORES PANEL ETIQUETAS
		inicializarPanelEtiquetas();
		
		//ASIGNACIÓN VALORES SCROLLPANEL DE VIDEOS
		inicializarScrollPanelVideos();
		
		//*************************************************ACCIONES BOTONES**************************************************
		listaEtiquetas.addMouseListener(new MouseAdapter() {
			String aux;
			public void mouseClicked(MouseEvent e) {

				if (e.getClickCount() == 1 && !modeloEtiquetas.contains("\r")) {
					aux = modeloEtiquetas.remove(listaEtiquetas.getSelectedIndex());
					if (modeloEtiqSeleccionadas.contains("\r"))
						modeloEtiqSeleccionadas.remove(0);
					if (modeloEtiquetas.isEmpty())
						modeloEtiquetas.add(0, "\r");
					listaEtiquetas.setModel(modeloEtiquetas);
					modeloEtiqSeleccionadas.addElement(aux);
					listaSeleccionados.setModel(modeloEtiqSeleccionadas);
				}
			}
		});

		listaSeleccionados.addMouseListener(new MouseAdapter() {
			String aux;
			public void mouseClicked(MouseEvent e) {

				if (e.getClickCount() == 1 && !modeloEtiqSeleccionadas.contains("\r")) {
					aux = modeloEtiqSeleccionadas.remove(listaSeleccionados.getSelectedIndex());
					if (modeloEtiquetas.contains("\r"))
						modeloEtiquetas.remove(0);
					if (modeloEtiqSeleccionadas.isEmpty())
						modeloEtiqSeleccionadas.add(0, "\r");
					listaSeleccionados.setModel(modeloEtiqSeleccionadas);
					modeloEtiquetas.addElement(aux);
					listaEtiquetas.setModel(modeloEtiquetas);
				}
			}
		});

		bBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<String> ll = new LinkedList<String>();
				for(Object o : modeloEtiqSeleccionadas.toArray()) {
					if(!o.equals("\r"))
						ll.add((String)o);
				}
				System.out.println(App.getInstancia().busquedaDeVideos(txtNombre.getText(), (String) filtros.getSelectedItem(), ll));
			}
		});
		//*******************************************************************************************************************
	}
	
	//******************************************************MÉTODOS******************************************************
	public void cargarEtiquetas() {
		int i = 0;
		List<Etiqueta> listaEtiquetas = App.getInstancia().recuperarEtiquetas();
		etiquetas = new String[listaEtiquetas.size()];
		for (Etiqueta e : listaEtiquetas) {
			etiquetas[i] = e.getNombre();
			i++;
		}
	}

	public void habilitarFiltros(boolean ispremium) {
		filtros.setEnabled(ispremium);
	}
	//*******************************************************************************************************************
	
	//**************************************************INICIALIZADORES**************************************************
	private void inicializarPanelBuscar() {
		panelBusqueda = new JPanel();
		panelBusqueda.setBackground(Color.GRAY);
		panelBusqueda.setBounds(0, 0, 480, 107);
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

		filtros = new JComboBox();
		filtros.setEnabled(false);
		filtros.setModel(new DefaultComboBoxModel(new String[] { "NoFiltro", "Menores", "MisListas" }));
		horizontalBox_1.add(filtros);

		Component rigidArea_3 = Box.createRigidArea(new Dimension(200, 20));
		horizontalBox_1.add(rigidArea_3);

		bNuevaBusqueda = new JButton("Nueva búsqueda");
		horizontalBox_1.add(bNuevaBusqueda);
	}
	
	private void inicializarPanelEtiquetas() {
		cargarEtiquetas();						//Inicializamos el array de etiquetas
		panelEtiquetas = new JPanel();
		panelEtiquetas.setBackground(Color.GRAY);
		panelEtiquetas.setBounds(499, 0, 170, 504);
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

		verticalBox_1.add(scrollLista1);
	}
	
	private void inicializarScrollPanelVideos() {
		ScrollPane scrollPaneVideos = new ScrollPane();
		scrollPaneVideos.setBackground(Color.GRAY);
		scrollPaneVideos.setBounds(0, 107, 480, 397);
		add(scrollPaneVideos);
	}
	//*******************************************************************************************************************
}
