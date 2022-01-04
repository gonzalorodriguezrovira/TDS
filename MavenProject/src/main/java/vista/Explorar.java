package vista;

import java.util.List;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

public class Explorar extends JPanel {
	private JTextField textField;

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

		textField = new JTextField();
		horizontalBox.add(textField);
		textField.setColumns(10);

		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox.add(rigidArea);

		JButton btnNewButton = new JButton("Buscar");
		horizontalBox.add(btnNewButton);

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

		JButton btnNewButton_1 = new JButton("Nueva búsqueda");
		horizontalBox_1.add(btnNewButton_1);

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

		JList<String> lista = new JList<String>();
		DefaultListModel<String> model = new DefaultListModel<String>();
		for (String valor : etiquetas) {
			model.addElement(valor);
		}
		lista.setModel(model);
		lista.setSelectedIndex(0);

		JScrollPane scrollLista = new JScrollPane(lista);
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
		JList<String> lista1 = new JList<String>();

		DefaultListModel<String> model1 = new DefaultListModel<String>();
			model1.addElement("\r");
		

		lista1.setModel(model1);
		lista1.setSelectedIndex(0);
		lista.addMouseListener(new MouseAdapter() {
			String aux;
			public void mouseClicked(MouseEvent e) {
				
				if(e.getClickCount() == 1&&!model.contains("\r")) {
					aux = model.remove(lista.getSelectedIndex());
					if(model1.contains("\r"))
						model1.remove(0);
					if(model.isEmpty())
						model.add(0, "\r");
					lista.setModel(model);
					model1.addElement(aux);
					lista1.setModel(model1);
				}
			}	
		});
		
		lista1.addMouseListener(new MouseAdapter() {
			String aux;
			public void mouseClicked(MouseEvent e) {
				
				if(e.getClickCount() == 1&&!model1.contains("\r")) {
					aux = model1.remove(lista1.getSelectedIndex());
					if(model.contains("\r"))
						model.remove(0);
					if(model1.isEmpty())
						model1.add(0, "\r");
					lista1.setModel(model1);
					model.addElement(aux);
					lista.setModel(model);
				}
			}	
		});

		JScrollPane scrollLista1 = new JScrollPane(lista1);

		verticalBox_1.add(scrollLista1);

		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBackground(Color.GRAY);
		scrollPane.setBounds(0, 107, 480, 397);
		add(scrollPane);
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

	public void buscar() {
		App.getInstancia().videosFiltrados((String) filtros.getSelectedItem());
	}

	public void habilitarFiltros(boolean ispremium) {
		filtros.setEnabled(ispremium);
	}

}
