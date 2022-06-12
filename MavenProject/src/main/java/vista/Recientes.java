package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;

import controlador.App;
import modelo.Etiqueta;
import modelo.Video;
import java.awt.Font;
import javax.swing.JTextField;

public class Recientes extends JPanel {

	private JList<Miniatura> listaVideos = new JList<Miniatura>();
	private DefaultListModel<Miniatura> modeloVideos = new DefaultListModel<Miniatura>();
	private List<String> aux = new LinkedList<String>();
	private JComboBox<String> boxListaVideos = new JComboBox<String>();
	private DefaultComboBoxModel<String> modeloBoxListaVideos = new DefaultComboBoxModel<String>();
	private JTextField txtFEtiquetas;

	public Recientes(AppVideo v) {
		setBackground(Color.GRAY);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(0, 11, 184, 420);
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		Box verticalBox = Box.createVerticalBox();
		panel.add(verticalBox);

		Box horizontalBox = Box.createHorizontalBox();
		verticalBox.add(horizontalBox);

		JLabel lblSeleccionarLaLi = new JLabel("Seleccionar la lista: ");
		lblSeleccionarLaLi.setForeground(Color.WHITE);
		horizontalBox.add(lblSeleccionarLaLi);

		Component rigidArea_2 = Box.createRigidArea(new Dimension(50, 20));
		horizontalBox.add(rigidArea_2);

		boxListaVideos.setMaximumRowCount(19);

		boxListaVideos.setModel(modeloBoxListaVideos);

		boxListaVideos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarListaVideos();
			}
		});

		verticalBox.add(boxListaVideos);

		Component rigidArea = Box.createRigidArea(new Dimension(20, 10));
		verticalBox.add(rigidArea);

		Box horizontalBox_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1);

		JButton bReproducir = new JButton("Reproducir\r\n");

		horizontalBox_1.add(bReproducir);

		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 10));
		verticalBox.add(rigidArea_1);

		listaVideos.setModel(modeloVideos);
		listaVideos.setCellRenderer(new VideoListRenderer());
		JScrollPane scroll = new JScrollPane(listaVideos);
		scroll.setPreferredSize(new Dimension(172, 320));
		verticalBox.add(scroll);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(0, 430, 184, 65);
		add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));

		Component horizontalStrut = Box.createHorizontalStrut(52);
		panel_1.add(horizontalStrut);

		JButton bCancelarML = new JButton("Cancelar");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 1;
		panel_1.add(bCancelarML);

		Component horizontalStrut_1 = Box.createHorizontalStrut(52);
		panel_1.add(horizontalStrut_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(189, 11, 492, 482);
		add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		Box verticalBox_1 = Box.createVerticalBox();
		panel_2.add(verticalBox_1);

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

		Box horizontalBox_7 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_7);

		JLabel txtVisualizaciones = new JLabel("Reproducciones");
		txtVisualizaciones.setVisible(false);
		txtVisualizaciones.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_7.add(txtVisualizaciones);

		JPanel pVideo = new JPanel();
		pVideo.setVisible(false);
		verticalBox_1.add(pVideo);

		Box horizontalBox_8 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_8);

		JLabel txtEtiquetas = new JLabel("cambiar por etiquetas");
		txtEtiquetas.setVisible(false);
		horizontalBox_8.add(txtEtiquetas);

		Component rigidArea_10 = Box.createRigidArea(new Dimension(450, 20));
		verticalBox_1.add(rigidArea_10);

		Box horizontalBox_9 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_9);

		Component rigidArea_9 = Box.createRigidArea(new Dimension(50, 20));
		horizontalBox_9.add(rigidArea_9);

		JLabel txtnuevaetiquetainfo = new JLabel("Nueva etiqueta:");
		txtnuevaetiquetainfo.setVisible(false);
		horizontalBox_9.add(txtnuevaetiquetainfo);

		Component rigidArea_6 = Box.createRigidArea(new Dimension(10, 20));
		horizontalBox_9.add(rigidArea_6);

		txtFEtiquetas = new JTextField();
		txtFEtiquetas.setEnabled(false);
		txtFEtiquetas.setVisible(false);
		txtFEtiquetas.setColumns(10);
		horizontalBox_9.add(txtFEtiquetas);

		Component rigidArea_7 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_9.add(rigidArea_7);

		JButton bEtiquetasNuevas = new JButton("Añadir");
		bEtiquetasNuevas.setVisible(false);
		bEtiquetasNuevas.setEnabled(false);
		horizontalBox_9.add(bEtiquetasNuevas);

		Component rigidArea_8 = Box.createRigidArea(new Dimension(50, 20));
		horizontalBox_9.add(rigidArea_8);

		// CardLayout c = (CardLayout) (AppVideo.vDisplay.getLayout());
		// bCancelarML.addActionListener(ev -> c.show(AppVideo.vDisplay,
		// AppVideo.INICIO_SESION));
		/*
		 * bCancelarML.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { CardLayout c =
		 * (CardLayout)(AppVideo.vDisplay.getLayout()); c.show(AppVideo.vDisplay,
		 * AppVideo.BRUH); } });
		 */

		bReproducir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = listaVideos.getSelectedIndex();
				if (index != -1) {
					App.getInstancia().stopVideo();
					pVideo.remove(main.Lanzador.videoWeb);
					pVideo.add(main.Lanzador.videoWeb);
					Video v = App.getInstancia().findVideoURL((modeloVideos.get(index).getUrl()));
					txtTitulo.setText(v.getTitulo());
					v = App.getInstancia().incrementarVisualizaciones(v);
					mostrarListaVideos();
					txtVisualizaciones.setText(String.valueOf(v.getNumRepro()));
					txtEtiquetas.setText("");
					for (Etiqueta e : v.getEtiquetas())
						txtEtiquetas.setText(txtEtiquetas.getText() + " - " + e.getNombre());
					txtTitulo.setVisible(true);
					txtVisualizaciones.setVisible(true);
					txtEtiquetas.setVisible(true);
					txtnuevaetiquetainfo.setVisible(true);
					txtFEtiquetas.setVisible(true);
					txtFEtiquetas.setEnabled(true);
					bEtiquetasNuevas.setVisible(true);
					bEtiquetasNuevas.setEnabled(true);
					pVideo.setVisible(true);
					App.getInstancia().playVideo(v);
					validate();
				}
			}
		});

		bCancelarML.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(Component c : pVideo.getComponents())
					pVideo.remove(c);
				App.getInstancia().stopVideo();
				pVideo.revalidate();
		        pVideo.repaint();
				txtTitulo.setVisible(false);
				txtVisualizaciones.setVisible(false);
				txtEtiquetas.setVisible(false);
				txtnuevaetiquetainfo.setVisible(false);
				txtFEtiquetas.setVisible(false);
				txtFEtiquetas.setEnabled(false);
				bEtiquetasNuevas.setVisible(false);
				bEtiquetasNuevas.setEnabled(false);
				pVideo.setVisible(false);
			}
		});

		bEtiquetasNuevas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombreE = txtFEtiquetas.getText();
				Etiqueta etiqueta = new Etiqueta(nombreE);
				if (App.getInstancia().addEtiquetaAVideo(App.getInstancia().findVideoURL((modeloVideos.get(listaVideos.getSelectedIndex()).getUrl())), etiqueta)) {
					txtEtiquetas.setText(txtEtiquetas.getText() + " - " + nombreE);
					v.actualizarEtiquetasExplorar();
				}
			}
		});

	}

	public void inicializarLista() {
		habilitar();
		boxListaVideos.setModel(new DefaultComboBoxModel(new String[] { "Recientes", "MasPopulares" }));
		mostrarListaVideos();
	}

	public void mostrarListaVideos() {
		modeloVideos.clear();
		int index = boxListaVideos.getSelectedIndex();
		if (index != -1) {
			if (index == 0) {
				List<Video> aux2 = App.getInstancia().obtenerRecientes();
				for (Video v : aux2) {
					modeloVideos.addElement(new Miniatura(v, 100, 100));
				}
				listaVideos.setSelectedIndex(0);
				listaVideos.revalidate();
			} else {
				List<Video> aux2 = App.getInstancia().recuperarMasVistos();
				for (Video v : aux2) {
					modeloVideos.addElement(new Miniatura(v, 100, 100));
				}
				listaVideos.setSelectedIndex(0);
				listaVideos.revalidate();
			}

		}
	}

	public void habilitar() {
		boxListaVideos.setEnabled(App.getInstancia().getUsuarioActual().isPremium());
	}
}
