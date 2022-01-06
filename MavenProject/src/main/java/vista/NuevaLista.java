package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.FlowLayout;
import java.util.ArrayList;
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
	private DefaultListModel<Video> modeloVideosB;

	private ListaVideos listaVideos = new ListaVideos("");

	public NuevaLista() {
		setLayout(null);
		// **************************PANEL PARA BUSCAR LISTAS***************************
		JPanel pNombreLista = new JPanel();
		pNombreLista.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pNombreLista.setBackground(Color.GRAY);
		pNombreLista.setBounds(0, 0, 200, 106);
		add(pNombreLista);
		pNombreLista.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JLabel lblNombreLista = new JLabel("Introduce nombre lista:");
		lblNombreLista.setForeground(Color.WHITE);
		pNombreLista.add(lblNombreLista);

		Box verticalBox = Box.createVerticalBox();
		pNombreLista.add(verticalBox);

		Box horizontalBox = Box.createHorizontalBox();
		verticalBox.add(horizontalBox);

		txtBuscarLista = new JTextField();
		txtBuscarLista.setColumns(10);
		horizontalBox.add(txtBuscarLista);
		JButton bBuscarLista = new JButton("Buscar");
		// ACCIÓN PASAR DE UNA LISTA A OTRA
		/*
		 * bBuscarLista.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { // ANOTACIÓN DE ROBERTO: Aquí quizas en los
		 * siguientes ifs, los más externos, se // deba quitar la comprobación de que la
		 * lista sea vacía y ponerla // como un if que engloble todo. Te ahorras esa
		 * comprobación varias veces: // if(!txtBuscarLista.getText().isEmpty()){ (todo
		 * LO QUE HAY DEBAJO) } listaVideos =
		 * App.getInstancia().findListaVideo(txtBuscarLista.getText()); if (listaVideos
		 * == null && !txtBuscarLista.getText().isEmpty()) { // SI NO ENCONTRAMOS
		 * NINGÚNA LISTA listaVideos = new ListaVideos(txtBuscarLista.getText()); // LA
		 * CREAMOS JFrame jFrame = new JFrame(); // (POP UP) int result =
		 * JOptionPane.showConfirmDialog(jFrame, "Desea crear la lista " +
		 * txtBuscarLista.getText()); if (result == 0) { // SE ELIGE CREAR LA LISTA //
		 * HE AÑADIDO DESDE AQUI { listaVideos = new
		 * ListaVideos(txtBuscarLista.getText()); // CON ESTO SE GUARDA EN LA BD
		 * App.getInstancia().addListaVideo(listaVideos); // PARA QUE NO SE CREE OTRA
		 * VEZ // } HASTA AQUI modeloVideosN = new DefaultListModel<Video>();
		 * listaVideosN = new JList<Video>(); } } else if
		 * (!txtBuscarLista.getText().isEmpty()) { // SI ENCONTRAMOS UNA LISTA for
		 * (Video v : listaVideos.getVideos()) { modeloVideosN.addElement(v); }
		 * listaVideosN = new JList<Video>(); listaVideosN.setModel(modeloVideosN); //TE
		 * FALTA PONER ESTO DE AQUI ABAJO PARA EVITAR POSIBLES ERRORES
		 * //listaVideosN.setSelectedIndex(0); } } });
		 */
		// QUEDARÍA TAL QUE ASÍ

		bBuscarLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!txtBuscarLista.getText().isEmpty()) {
					listaVideos = App.getInstancia().findListaVideo(txtBuscarLista.getText());
					if (listaVideos == null) {
						listaVideos = new ListaVideos(txtBuscarLista.getText()); // LA CREAMOS
						JFrame jFrame = new JFrame(); // (POP UP)
						int result = JOptionPane.showConfirmDialog(jFrame,
								"Desea crear la lista " + txtBuscarLista.getText());
						if (result == 0) { // SE ELIGE CREAR LA LISTA
							modeloVideosN.clear();
							listaVideosN.revalidate();
							listaVideosN.setSelectedIndex(0);
						}
					} else {
						modeloVideosN.clear();
						for (Video v : listaVideos.getVideos()) {
							modeloVideosN.addElement(v);
						}
						listaVideosN.revalidate();
						listaVideosN.setSelectedIndex(0);
					}
				}
			}
		});

		horizontalBox.add(bBuscarLista);

		Component a = Box.createRigidArea(new Dimension(70, 15));
		verticalBox.add(a);

		JButton bEliminar = new JButton("Eliminar");
		verticalBox.add(bEliminar);

		// **************************PANEL PARA BUSCAR VIDEOS***************************
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

		// TITULO DEL VIDEO QUE ESTAMOS BUSCANDO
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

		// ********************PANEL PARA VIDEOS DE LA LISTA*************************
		JPanel pLista = new JPanel();
		pLista.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pLista.setBackground(Color.GRAY);
		pLista.setBounds(0, 105, 200, 409);
		add(pLista);

		Box verticalBox_2 = Box.createVerticalBox();
		pLista.add(verticalBox_2);

		// INICIALIZAMOS LA LISTA DE LA IZQUIERDA
		listaVideosN = new JList<Video>();
		// TODO ESTE VALOR HAY QUE CAMBIARLO CUANDO PODAMOS ENSEÑAR MINIATURAS
		listaVideosN.setVisibleRowCount(17);
		modeloVideosN = new DefaultListModel<Video>();
		listaVideosN.setModel(modeloVideosN);
		listaVideosN.setSelectedIndex(0);

		JScrollPane scrollLista = new JScrollPane(listaVideosN);
		verticalBox_2.add(scrollLista);
		// HE CAMBIADO EL TAMAÑO DE LA LISTA DE LA IZQUIERDA
		// CON LOS VALORES DE ABAJO
		scrollLista.setPreferredSize(new DimensionUIResource(180, 300));

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

		// *************************PANEL DE VIDEOS BUSCADOS**************************
		JPanel pVideos = new JPanel();
		// SI INICIALIZAS AQUÍ LA LISTA NO HACE FALTA QUE LA INICIALICES ARRIBA, CUANDO
		// LA DECLARAS
		listaVideosB = new JList<Video>();
		listaVideosB.setVisibleRowCount(24);
		modeloVideosB = new DefaultListModel<Video>();

		listaVideosB.setModel(modeloVideosB);
		listaVideosB.setSelectedIndex(0);

		JScrollPane scrollLista1 = new JScrollPane(listaVideosB);
		scrollLista1.setPreferredSize(new DimensionUIResource(441, 383));
		pVideos.add(scrollLista1);
		pVideos.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pVideos.setBackground(Color.GRAY);
		pVideos.setBounds(200, 106, 491, 408);
		add(pVideos);

		// QUE? ESTO ES UN CUADRO DE TEXTO, NO UN BOTÓN.
		// CREO QUE QUERÍAS PONER EL BOTON DE NUEVA BUSQUEDA
		// QUE ESTÁ MÁS ABAJO, O SEA QUE CREO QUE SE PUEDE QUITAR
		/*
		 * txtBuscarLista.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { if (txtBuscarLista.getText().isEmpty()) {
		 * listaVideos = null; } } });
		 */

		bAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listaVideos != null) {
					Video aux = modeloVideosB.get(listaVideosB.getSelectedIndex());
					if (aux != null) {
						for (int i = 0; i < modeloVideosN.getSize(); i++) {
							if (modeloVideosN.get(i).equals(aux))
								return;
						}
						listaVideos.addVideo(aux);
						modeloVideosN.addElement(aux);
						listaVideosN.revalidate();
					}
				}
			}
		});

		bQuitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = listaVideosN.getSelectedIndex();
				if (index != -1) {
					Video aux = modeloVideosN.get(index);
					listaVideos.removeVideo(aux);
					modeloVideosN.remove(index);
					listaVideosN.revalidate();
				}
			}
		});

		bAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * MEJOR EN EL bAdd y bQuitar para evitar meter videos repetidos en la lista for
				 * (Object v : modeloVideosN.toArray()) { listaVideos.addVideo((Video) v); }
				 */
				// HE AÑADIDO ESTO
				if (App.getInstancia().findListaVideo(listaVideos.getName()) != null) {
					App.getInstancia().setVideosALista(listaVideos);
				}
				App.getInstancia().addListaVideo(listaVideos);
			}
		});

		bBuscarVideos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Video> aux = App.getInstancia().videosPorNombre(txtBuscarVideos.getText(),
						App.getInstancia().recuperarVideos());
				for (Video v : aux) {
					modeloVideosB.addElement(v);
				}
				listaVideosB.revalidate();
			}
		});

		bReiniciarBusqueda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modeloVideosB.clear();
				listaVideosB.revalidate();
			}
		});

		bEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modeloVideosN.clear();
				listaVideosN.revalidate();
				txtBuscarLista.setText("");
				listaVideos = null;
			}
		});
	}
	
	public void vaciar() {
		txtBuscarLista.setText("");
		txtBuscarVideos.setText("");
		modeloVideosB.clear();
		modeloVideosN.clear();
		listaVideosN.revalidate();
		listaVideosB.revalidate();
	}
	
}
