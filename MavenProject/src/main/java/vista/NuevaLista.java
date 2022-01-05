package vista;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;

import java.awt.FlowLayout;
import java.awt.List;

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

import controlador.App;
import modelo.ListaVideos;
import modelo.Video;
import javax.swing.SwingConstants;
import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NuevaLista extends JPanel {
	private JTextField txtBuscarLista;
	private JTextField textField_1;

	private JList<Video> listaVideosN;
	private JList<Video> listaVideosB;
	
	private DefaultListModel<Video> modeloVideosN;
	private DefaultListModel<Video> modeloVideosB;
	
	
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
				ListaVideos listaVideos = App.getInstancia().findListaVideo(txtBuscarLista.getText());
				if(listaVideos==null&&!txtBuscarLista.getText().isEmpty()) {
					JFrame jFrame = new JFrame();
			        int result = JOptionPane.showConfirmDialog(jFrame, "Desea crear la lista "+txtBuscarLista.getText());

			        if (result == 0) {
			           ListaVideos listaNueva = new ListaVideos(txtBuscarLista.getName());
			           App.getInstancia().addListaVideo(listaNueva);
			           listaVideosN = (JList<Video>) listaNueva.getVideos();
			        }
			        else {}
			             

				}else if(!txtBuscarLista.getText().isEmpty()){
					listaVideosN = (JList<Video>) listaVideos.getVideos();
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
		
		textField_1 = new JTextField();
		horizontalBox_1.add(textField_1);
		textField_1.setColumns(26);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_1);
		
		JButton btnNewButton = new JButton("Buscar");
		horizontalBox_1.add(btnNewButton);
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_1.add(rigidArea_2);
		
		JButton btnNewButton_1 = new JButton("Nueva búsqueda");
		verticalBox_1.add(btnNewButton_1);
		
		JPanel pLista = new JPanel();
		pLista.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pLista.setBackground(Color.GRAY);
		pLista.setBounds(0, 105, 200, 409);
		add(pLista);
		
		Box verticalBox_2 = Box.createVerticalBox();
		pLista.add(verticalBox_2);
		listaVideosN = new JList<Video>();
		listaVideosN.setVisibleRowCount(18);
		modeloVideosN  = new DefaultListModel<Video>();
		
		listaVideosN.setModel(modeloVideosN);
		listaVideosN.setSelectedIndex(0);

		JScrollPane scrollLista = new JScrollPane(listaVideosN);
		verticalBox_2.add(scrollLista);
		
		Component rigidArea_5 = Box.createRigidArea(new Dimension(20, 15));
		verticalBox_2.add(rigidArea_5);
		
		Box horizontalBox_2 = Box.createHorizontalBox();
		verticalBox_2.add(horizontalBox_2);
		
		JButton btnNewButton_2 = new JButton("Añadir");
		horizontalBox_2.add(btnNewButton_2);
		
		Component rigidArea_3 = Box.createRigidArea(new Dimension(40, 20));
		horizontalBox_2.add(rigidArea_3);
		
		JButton btnNewButton_3 = new JButton("Quitar");
		horizontalBox_2.add(btnNewButton_3);
		
		Component rigidArea_4 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_2.add(rigidArea_4);
		
		Box horizontalBox_3 = Box.createHorizontalBox();
		verticalBox_2.add(horizontalBox_3);
		
		JButton btnNewButton_4 = new JButton("Aceptar");
		horizontalBox_3.add(btnNewButton_4);
		
		JPanel pVideos = new JPanel();
		listaVideosB = new JList<Video>();
		listaVideosB.setVisibleRowCount(24);
		modeloVideosB = new DefaultListModel<Video>();
		
		Component glue = Box.createGlue();
		pVideos.add(glue);
		
		listaVideosB.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listaVideosB.setSelectedIndex(0);

		JScrollPane scrollLista1 = new JScrollPane(listaVideosB);
		pVideos.add(scrollLista1);
		pVideos.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pVideos.setBackground(Color.GRAY);
		pVideos.setBounds(200, 106, 491, 408);
		add(pVideos);

	}
}
