package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
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
import modelo.Video;

public class MisListas extends JPanel {

	private JList<Video> listaVideos = new JList<Video>();
	private DefaultListModel<Video> modeloVideos = new DefaultListModel<Video>();
	private List<String> aux = new LinkedList<String>();
	private JComboBox<String> boxListaVideos = new JComboBox<String>();
	private DefaultComboBoxModel<String> modeloBoxListaVideos = new DefaultComboBoxModel<String>();

	public MisListas() {
		setBackground(Color.GRAY);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(0, 11, 184, 394);
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

		boxListaVideos.setModel(new DefaultComboBoxModel());

		verticalBox.add(boxListaVideos);

		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		verticalBox.add(rigidArea);

		Box horizontalBox_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1);

		JButton bReproducir = new JButton("Reproducir\r\n");
		horizontalBox_1.add(bReproducir);

		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox.add(rigidArea_1);

		listaVideos.setModel(modeloVideos);
		JScrollPane scroll = new JScrollPane();
		scroll.add(listaVideos);
		scroll.setPreferredSize(new Dimension(172, 280));
		verticalBox.add(scroll);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(0, 403, 184, 90);
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
		panel_2.setBounds(184, 11, 497, 482);
		add(panel_2);

		JLabel lblNewLabel_1 = new JLabel(
				"seguramente haya que hacer otro cardlayout y cuando se haga click en uno de los videos ponerlo en pantalla. Posible reutilización de los videos en explorar");
		panel_2.add(lblNewLabel_1);

		// CardLayout c = (CardLayout) (AppVideo.vDisplay.getLayout());
		// bCancelarML.addActionListener(ev -> c.show(AppVideo.vDisplay,
		// AppVideo.INICIO_SESION));
		/*
		 * bCancelarML.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { CardLayout c =
		 * (CardLayout)(AppVideo.vDisplay.getLayout()); c.show(AppVideo.vDisplay,
		 * AppVideo.BRUH); } });
		 */
	}

	public void inicializarLista() {
		aux = App.getInstancia().recuperarNombesListaVideos();
		modeloBoxListaVideos.removeAllElements();
		for (String a : aux) {
			modeloBoxListaVideos.addElement(a);
		}
		boxListaVideos.setModel(modeloBoxListaVideos);
		mostrarListaVideos();
	}

	public void mostrarListaVideos() {
		modeloVideos.clear();
		List<Video> aux2 = App.getInstancia()
				.findListaVideo(modeloBoxListaVideos.getElementAt(boxListaVideos.getSelectedIndex())).getVideos();
		for (Video v : aux2) {
			modeloVideos.addElement(v);
		}
		System.out.println(modeloVideos);
		listaVideos.revalidate();
	}
}
