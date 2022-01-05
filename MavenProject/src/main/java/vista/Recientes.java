package vista;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.util.List;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;

import controlador.App;
import modelo.Video;
import javax.swing.ListSelectionModel;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.AbstractListModel;

public class Recientes extends JPanel {
	// LISTAS
	JList<Video> listaRecientes;
	JList<Video> listaRecientes1;

	// MODELOS
	DefaultListModel<Video> modeloRecientes;
	DefaultListModel<Video> modeloRecientes1;
	
	//PANELES
	private JPanel panel;
	private JPanel panel_2;

	public Recientes() {
		setLayout(new BorderLayout(0, 0));

		//ASIGNACIÓN LISTA VIDEOS IZQUIERDA
		inicializarListaIzquierda();
		
		//ASIGNACIÓN LISTA VIDEOS DERECHA
		inicializarListaDerecha();
		

	}

	public void inicializarRecientes() {
		modeloRecientes = new DefaultListModel<Video>();
		List<Video> l = App.getInstancia().obtenerRecientes();
		for (Video video : App.getInstancia().obtenerRecientes()) {
			modeloRecientes.addElement(video);
		}
		listaRecientes.setModel(modeloRecientes);
	}
	
	public void inicializarListaIzquierda(){
		panel = new JPanel();
		add(panel, BorderLayout.WEST);
		
		listaRecientes = new JList<Video>();
		listaRecientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		modeloRecientes = new DefaultListModel<Video>();

//		listaRecientes.setModel();

		JScrollPane scrollLista = new JScrollPane(listaRecientes);
		scrollLista.setPreferredSize(new DimensionUIResource(200, 400));
		scrollLista.revalidate();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(scrollLista);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 5));
		scrollLista.setColumnHeaderView(rigidArea_1);
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(5, 20));
		scrollLista.setRowHeaderView(rigidArea_2);
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 10));
		panel.add(rigidArea);
		
		Box horizontalBox = Box.createHorizontalBox();
		panel.add(horizontalBox);
		
		JButton btnNewButton = new JButton("New button");
		horizontalBox.add(btnNewButton);
		
		Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 10));
		panel.add(rigidArea_3);
	}

	public void inicializarListaDerecha() {
		panel_2 = new JPanel();
		add(panel_2, BorderLayout.CENTER);
		
		
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 5));
		panel_2.add(rigidArea);
		
		listaRecientes1 = new JList<Video>();
		listaRecientes1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		modeloRecientes1 = new DefaultListModel<Video>();

		listaRecientes1.setModel(modeloRecientes);

		JScrollPane scrollLista1 = new JScrollPane(listaRecientes1);
		scrollLista1.setPreferredSize(new DimensionUIResource(200, 400));
		scrollLista1.revalidate();
		
		Box horizontalBox = Box.createHorizontalBox();

		panel_2.add(horizontalBox);
		horizontalBox.add(scrollLista1);
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(5, 20));
		horizontalBox.add(rigidArea_2);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 5));
		panel_2.add(rigidArea_1);
		
		
	}
	
}
