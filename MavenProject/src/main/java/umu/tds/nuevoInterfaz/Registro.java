package umu.tds.nuevoInterfaz;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import com.toedter.calendar.JDateChooser;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Registro extends JPanel {

	/**
	 * Create the panel.
	 */
	JPanel pRegistro = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	
	public Registro() {
		setBackground(Color.GRAY);
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		Box verticalBox = Box.createVerticalBox();
		add(verticalBox);
		
		Component rigidArea = Box.createRigidArea(new Dimension(350, 50));
		verticalBox.add(rigidArea);
		
		Box horizontalBox = Box.createHorizontalBox();
		verticalBox.add(horizontalBox);
		
		Component rigidArea_2_4 = Box.createRigidArea(new Dimension(55, 20));
		horizontalBox.add(rigidArea_2_4);
		
		JLabel lblNewLabel = new JLabel("*Nombre");
		lblNewLabel.setForeground(Color.WHITE);
		horizontalBox.add(lblNewLabel);
		
		textField = new JTextField();
		horizontalBox.add(textField);
		textField.setColumns(10);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 5));
		verticalBox.add(rigidArea_1);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1);
		
		Component rigidArea_2_4_2 = Box.createRigidArea(new Dimension(55, 20));
		horizontalBox_1.add(rigidArea_2_4_2);
		
		JLabel lblNewLabel_1 = new JLabel("Apellidos");
		lblNewLabel_1.setForeground(Color.WHITE);
		horizontalBox_1.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		horizontalBox_1.add(textField_1);
		
		Component rigidArea_1_1 = Box.createRigidArea(new Dimension(200, 5));
		verticalBox.add(rigidArea_1_1);
		
		Box horizontalBox_1_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Fecha de nacimiento");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		horizontalBox_1_1.add(lblNewLabel_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		horizontalBox_1_1.add(textField_2);
		
		Component rigidArea_2_4_1 = Box.createRigidArea(new Dimension(50, 20));
		horizontalBox_1_1.add(rigidArea_2_4_1);
		
		Component rigidArea_1_1_1 = Box.createRigidArea(new Dimension(200, 5));
		verticalBox.add(rigidArea_1_1_1);
		
		Box horizontalBox_1_2 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1_2);
		
		Component rigidArea_2_4_2_1 = Box.createRigidArea(new Dimension(74, 20));
		horizontalBox_1_2.add(rigidArea_2_4_2_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("email");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		horizontalBox_1_2.add(lblNewLabel_1_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		horizontalBox_1_2.add(textField_3);
		
		Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 25));
		verticalBox.add(rigidArea_3);
		
		Box horizontalBox_1_1_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1_1_1);
		
		Component rigidArea_2_1 = Box.createRigidArea(new Dimension(58, 20));
		horizontalBox_1_1_1.add(rigidArea_2_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("*Usuario");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		horizontalBox_1_1_1.add(lblNewLabel_1_1_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		horizontalBox_1_1_1.add(textField_4);
		
		Component rigidArea_2_4_2_1_3 = Box.createRigidArea(new Dimension(55, 20));
		horizontalBox_1_1_1.add(rigidArea_2_4_2_1_3);
		
		Component rigidArea_1_2 = Box.createRigidArea(new Dimension(20, 5));
		verticalBox.add(rigidArea_1_2);
		
		Box horizontalBox_1_1_2 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1_1_2);
		
		Component rigidArea_2_2 = Box.createRigidArea(new Dimension(38, 20));
		horizontalBox_1_1_2.add(rigidArea_2_2);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("*Contraseña");
		lblNewLabel_1_1_2.setForeground(Color.WHITE);
		horizontalBox_1_1_2.add(lblNewLabel_1_1_2);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		horizontalBox_1_1_2.add(textField_5);
		
		Component rigidArea_2_4_2_1_2 = Box.createRigidArea(new Dimension(55, 20));
		horizontalBox_1_1_2.add(rigidArea_2_4_2_1_2);
		
		Component rigidArea_1_3 = Box.createRigidArea(new Dimension(20, 5));
		verticalBox.add(rigidArea_1_3);
		
		Box horizontalBox_1_1_3 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1_1_3);
		
		Component rigidArea_2_3 = Box.createRigidArea(new Dimension(2, 20));
		horizontalBox_1_1_3.add(rigidArea_2_3);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("*Repetir contraseña\r\n");
		lblNewLabel_1_1_3.setForeground(Color.WHITE);
		horizontalBox_1_1_3.add(lblNewLabel_1_1_3);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		horizontalBox_1_1_3.add(textField_6);
		
		Component rigidArea_2_4_2_1_1 = Box.createRigidArea(new Dimension(55, 20));
		horizontalBox_1_1_3.add(rigidArea_2_4_2_1_1);
		
		Component rigidArea_3_1 = Box.createRigidArea(new Dimension(20, 22));
		verticalBox.add(rigidArea_3_1);
		
		Box horizontalBox_2 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2);
		
		Component rigidArea_4 = Box.createRigidArea(new Dimension(50, 20));
		horizontalBox_2.add(rigidArea_4);
		
		JButton btnNewButton = new JButton("Registrar");
		horizontalBox_2.add(btnNewButton);
		
		Component rigidArea_4_1 = Box.createRigidArea(new Dimension(50, 20));
		horizontalBox_2.add(rigidArea_4_1);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		horizontalBox_2.add(btnNewButton_1);
		
		Component rigidArea_3_2 = Box.createRigidArea(new Dimension(20, 25));
		verticalBox.add(rigidArea_3_2);
		
		Box horizontalBox_3 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_3);
		
		Component rigidArea_5_1 = Box.createRigidArea(new Dimension(50, 20));
		horizontalBox_3.add(rigidArea_5_1);
		
		JLabel lblNewLabel_2 = new JLabel("*Campos obligatorios");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		horizontalBox_3.add(lblNewLabel_2);
		
		Component rigidArea_5 = Box.createRigidArea(new Dimension(100, 20));
		horizontalBox_3.add(rigidArea_5);
		pRegistro.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	}
}
