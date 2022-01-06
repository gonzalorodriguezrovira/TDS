package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.FlowLayout;
import java.util.List;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.plaf.DimensionUIResource;

import controlador.App;
import modelo.ListaVideos;
import modelo.Video;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NuevaLista extends JPanel {
	private JTextField txtBuscarLista;
	private JTextField txtBuscarVideos;

	private JList<Video> listaVideosN;
	private JList<Video> listaVideosB;

	private DefaultListModel<Video> modeloVideosN;
	private DefaultListModel<Video> modeloVideosB = new DefaultListModel<Video>();

	private ListaVideos listaVideos;

	public NuevaLista() {
		setLayout(null);

		JPanel pNombreLista = new JPanel();
		pNombreLista.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pNombreLista.setBackground(Color.GRAY);
		pNombreLista.setBounds(0, 0, 200, 106);
		add(pNombreLista);
		pNombreLista.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JLabel lblNewLabel = new JLabel("Introduce nombre lista:");
		lblNewLabel.setForeground(Color.WHITE);
		pNombreLista.add(lblNewLabel);

		Box verticalBox = Box.createVerticalBox();
		pNombreLista.add(verticalBox);

		Box horizontalBox = Box.createHorizontalBox();
		verticalBox.add(horizontalBox);

		txtBuscarLista = new JTextField();
		txtBuscarLista.setColumns(10);
		horizontalBox.add(txtBuscarLista);

		JButton bBuscarLista = new JButton("Buscar");
		bBuscarLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaVideos = App.getInstancia().findListaVideo(txtBuscarLista.getText());
				if (listaVideos == null && !txtBuscarLista.getText().isEmpty()) {
					listaVideos = new ListaVideos(txtBuscarLista.getText());
					JFrame jFrame = new JFrame();
					int result = JOptionPane.showConfirmDialog(jFrame,
							"Desea crear la lista " + txtBuscarLista.getText());

					if (result == 0) {
						// App.getInstancia().addListaVideo(listaNueva);
						modeloVideosN = new DefaultListModel<Video>();
						listaVideosN = new JList<Video>();
					
					}
				} else if (!txtBuscarLista.getText().isEmpty()) {
					for (Video v : listaVideos.getVideos()) {
						modeloVideosN.addElement(v);
					}
					listaVideosN = new JList<Video>();
					listaVideosN.setModel(modeloVideosN);
				}
			}
		});

		horizontalBox.add(bBuscarLista);

		Component a = Box.createRigidArea(new Dimension(70, 15));
		verticalBox.add(a);

		JButton bEliminar = new JButton("Eliminar");
		verticalBox.add(bEliminar);

		JPanel pBuscado = new JPanel();
		pBuscado.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pBuscado.setBackground(Color.GRAY);
		pBuscado.setBounds(198, 0, 493, 106);
		add(pBuscado);

		Box verticalBox_1 = Box.createVerticalBox();
		pBuscado.add(verticalBox_1);

		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_1.add(rigidArea);

		Box horizontalBox_1 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_1);

		JLabel lblNewLabel_1 = new JLabel("Buscar titulo: ");
		lblNewLabel_1.setForeground(Color.WHITE);
		horizontalBox_1.add(lblNewLabel_1);

		txtBuscarVideos = new JTextField();
		horizontalBox_1.add(txtBuscarVideos);
		txtBuscarVideos.setColumns(26);

		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_1);

		JButton bBuscarVideos = new JButton("Buscar");
		horizontalBox_1.add(bBuscarVideos);

		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_1.add(rigidArea_2);

		JButton bReiniciarBusqueda = new JButton("Nueva búsqueda");
		verticalBox_1.add(bReiniciarBusqueda);

		JPanel pLista = new JPanel();
		pLista.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pLista.setBackground(Color.GRAY);
		pLista.setBounds(0, 105, 200, 409);
		add(pLista);

		Box verticalBox_2 = Box.createVerticalBox();
		pLista.add(verticalBox_2);
		listaVideosN = new JList<Video>();
		listaVideosN.setVisibleRowCount(18);
		modeloVideosN = new DefaultListModel<Video>();

		listaVideosN.setModel(modeloVideosN);
		listaVideosN.setSelectedIndex(0);

		JScrollPane scrollLista = new JScrollPane(listaVideosN);
		verticalBox_2.add(scrollLista);
		// TODO
		scrollLista.setPreferredSize(new DimensionUIResource(100, 100));

		Component rigidArea_5 = Box.createRigidArea(new Dimension(20, 15));
		verticalBox_2.add(rigidArea_5);

		Box horizontalBox_2 = Box.createHorizontalBox();
		verticalBox_2.add(horizontalBox_2);

		JButton bAdd = new JButton("Añadir");
		horizontalBox_2.add(bAdd);

		Component rigidArea_3 = Box.createRigidArea(new Dimension(40, 20));
		horizontalBox_2.add(rigidArea_3);

		JButton bQuitar = new JButton("Quitar");
		horizontalBox_2.add(bQuitar);

		Component rigidArea_4 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_2.add(rigidArea_4);

		Box horizontalBox_3 = Box.createHorizontalBox();
		verticalBox_2.add(horizontalBox_3);

		JButton bAceptar = new JButton("Aceptar");
		horizontalBox_3.add(bAceptar);

		JPanel pVideos = new JPanel();
		listaVideosB = new JList<Video>();
		listaVideosB.setVisibleRowCount(24);
		modeloVideosB = new DefaultListModel<Video>();

		Component glue = Box.createGlue();
		pVideos.add(glue);

		listaVideosB.setModel(modeloVideosB);
		listaVideosB.setSelectedIndex(0);

		txtBuscarLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtBuscarLista.getText().isEmpty()) {
					listaVideos= null;
				}
			}
		});

		bAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listaVideos != null) {
					Video aux = modeloVideosB.get(listaVideosB.getSelectedIndex());
					if (aux != null) {
						modeloVideosN.addElement(aux);
						listaVideosN.setModel(modeloVideosN);//TODO xq no se actualiza
					}
				}
			}
		});

		bQuitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Video aux = modeloVideosN.get(listaVideosN.getSelectedIndex());
				if (aux != null) {
					modeloVideosN.remove(listaVideosN.getSelectedIndex());
					listaVideosN.setModel(modeloVideosN);
				}
			}
		});

		bAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaVideos aux = new ListaVideos(txtBuscarLista.getText());
				for (Object v : modeloVideosN.toArray()) {
					aux.addVideo((Video) v);
				}
				App.getInstancia().addListaVideo(aux);
			}
		});

		bBuscarVideos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Video> aux = App.getInstancia().videosPorNombre(txtBuscarVideos.getText(),
						App.getInstancia().recuperarVideos());
				for (Video v : aux) {
					modeloVideosB.addElement(v);
				}
				listaVideosB.setModel(modeloVideosB);
			}
		});

		bReiniciarBusqueda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modeloVideosB = new DefaultListModel<Video>();
				listaVideosB.setModel(modeloVideosB);
			}
		});

		JScrollPane scrollLista1 = new JScrollPane(listaVideosB);
		pVideos.add(scrollLista1);
		pVideos.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pVideos.setBackground(Color.GRAY);
		pVideos.setBounds(200, 106, 491, 408);
		add(pVideos);

	}
}
