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
	private JTextField txtNombre;

	private JComboBox filtros;

	private String[] etiquetas;

	public Explorar(AppVideo v) {
		cargarEtiquetas();

		setBackground(Color.GRAY);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 480, 107);
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		Box verticalBox = Box.createVerticalBox();
		panel.add(verticalBox);

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

		JButton bBuscar = new JButton("Buscar");
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

		JButton bNuevaBusqueda = new JButton("Nueva búsqueda");
		horizontalBox_1.add(bNuevaBusqueda);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(499, 0, 170, 504);
		add(panel_2);

		Box verticalBox_1 = Box.createVerticalBox();
		panel_2.add(verticalBox_1);

		Component rigidArea_4 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_1.add(rigidArea_4);

		Box horizontalBox_2 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_2);

		JLabel lblNewLabel_1 = new JLabel("Etiquetas disponibles");
		lblNewLabel_1.setForeground(Color.WHITE);
		horizontalBox_2.add(lblNewLabel_1);

		Component rigidArea_4_1 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_1.add(rigidArea_4_1);

		JList<String> listaEtiquetas = new JList<String>();
		DefaultListModel<String> model = new DefaultListModel<String>();
		for (String valor : etiquetas) {
			model.addElement(valor);
		}
		listaEtiquetas.setModel(model);
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
		JList<String> listaSeleccionados = new JList<String>();

		DefaultListModel<String> model1 = new DefaultListModel<String>();
		model1.addElement("\r");

		listaSeleccionados.setModel(model1);
		listaSeleccionados.setSelectedIndex(0);
		listaEtiquetas.addMouseListener(new MouseAdapter() {
			String aux;
			public void mouseClicked(MouseEvent e) {

				if (e.getClickCount() == 1 && !model.contains("\r")) {
					aux = model.remove(listaEtiquetas.getSelectedIndex());
					if (model1.contains("\r"))
						model1.remove(0);
					if (model.isEmpty())
						model.add(0, "\r");
					listaEtiquetas.setModel(model);
					model1.addElement(aux);
					listaSeleccionados.setModel(model1);
				}
			}
		});

		listaSeleccionados.addMouseListener(new MouseAdapter() {
			String aux;
			public void mouseClicked(MouseEvent e) {

				if (e.getClickCount() == 1 && !model1.contains("\r")) {
					aux = model1.remove(listaSeleccionados.getSelectedIndex());
					if (model.contains("\r"))
						model.remove(0);
					if (model1.isEmpty())
						model1.add(0, "\r");
					listaSeleccionados.setModel(model1);
					model.addElement(aux);
					listaEtiquetas.setModel(model);
				}
			}
		});

		JScrollPane scrollLista1 = new JScrollPane(listaSeleccionados);

		verticalBox_1.add(scrollLista1);

		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBackground(Color.GRAY);
		scrollPane.setBounds(0, 107, 480, 397);
		add(scrollPane);
		
		bBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<String> ll = new LinkedList<String>();
				for(Object o : model.toArray()) {
					ll.add((String)o);
				}
				System.out.println(App.getInstancia().busquedaDeVideos(txtNombre.getText(), (String) filtros.getSelectedItem(), ll));
			}
		});	
	}

	public void cargarEtiquetas() {
		int i = 0;
		List<Etiqueta> listaEtiquetas = App.getInstancia().recuperarEtiquetas();
		etiquetas = new String[listaEtiquetas.size()];
		for (Etiqueta e : listaEtiquetas) {
			System.out.println(e);
			etiquetas[i] = e.getNombre();
			i++;
		}
	}

	public void habilitarFiltros(boolean ispremium) {
		filtros.setEnabled(ispremium);
	}

}
