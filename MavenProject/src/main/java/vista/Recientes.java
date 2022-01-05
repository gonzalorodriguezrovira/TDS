package vista;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;

import controlador.App;
import modelo.Video;

public class Recientes extends JPanel {
	//LISTAS
	JList<Video> listaRecientes;
	
	//MODELOS
	DefaultListModel<Video> modeloRecientes;
	
	public Recientes() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.WEST);
		
		listaRecientes = new JList<Video>();
		modeloRecientes = new DefaultListModel<Video>();
		
		for (Video video : App.getInstancia().obtenerRecientes()) {
			modeloRecientes.addElement(video);
		}
		listaRecientes.setModel(modeloRecientes);

		JScrollPane scrollLista = new JScrollPane(listaRecientes);
		panel.add(scrollLista);
		
		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.CENTER);

	}

}
