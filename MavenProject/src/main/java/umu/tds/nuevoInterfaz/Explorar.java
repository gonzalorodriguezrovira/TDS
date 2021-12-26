package umu.tds.nuevoInterfaz;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import com.toedter.calendar.JDateChooser;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Scrollbar;
import java.awt.ScrollPane;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.TextArea;
import java.awt.Label;

public class Explorar extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public Explorar() {
		setBackground(Color.GRAY);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 500, 107);
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
		
		Component rigidArea_3 = Box.createRigidArea(new Dimension(300, 20));
		horizontalBox_1.add(rigidArea_3);
		
		JButton btnNewButton_1 = new JButton("Nueva búsqueda");
		horizontalBox_1.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(519, 0, 136, 504);
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
		
	
		
		JTextArea area = new JTextArea();
		area.setEditable(false);
		area.setWrapStyleWord(true);
		area.setLineWrap(true);
		area.setText("a\r\na\r\na\r\na\r\na\r\na\r\na\r\n");
		area.setRows(8);
		area.setColumns(15);
		verticalBox_1.add(area);
		
		JScrollPane scroll = new JScrollPane(area);
		verticalBox_1.add(scroll);
		
		Component rigidArea_5 = Box.createRigidArea(new Dimension(20, 70));
		verticalBox_1.add(rigidArea_5);
		
		Box horizontalBox_3 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_3);
		
		JLabel lblNewLabel_2 = new JLabel("Buscar etiquetas");
		lblNewLabel_2.setForeground(Color.WHITE);
		horizontalBox_3.add(lblNewLabel_2);
		
		Component rigidArea_4_1_1 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_1.add(rigidArea_4_1_1);
		JTextArea area1 = new JTextArea();
		area1.setEditable(false);
		area1.setText("a\r\na\r\na\r\na\r\na\r\na\r\na\r\n");
		area1.setWrapStyleWord(true);
		area1.setRows(8);
		area1.setLineWrap(true);
		area1.setColumns(15);
		verticalBox_1.add(area1);
		
		JScrollPane scroll1 = new JScrollPane(area1);
		verticalBox_1.add(scroll1);
		
		Component rigidArea_6 = Box.createRigidArea(new Dimension(20, 20));
		panel_2.add(rigidArea_6);
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBackground(Color.GRAY);
		scrollPane.setBounds(0, 107, 500, 397);
		add(scrollPane);
		
		
	}
}
