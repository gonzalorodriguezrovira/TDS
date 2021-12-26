package umu.tds.interfaz;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.Box;
import java.awt.FlowLayout;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class PantallaLogin extends JPanel{
	
	private JLabel labelImegen;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtUsername;
	private JTextField txtPassword;
	
	public PantallaLogin(){
		JPanel inicioSesion = new JPanel();
		inicioSesion.setBackground(Color.LIGHT_GRAY);
		inicioSesion.setVisible(false);
		inicioSesion.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		Component rigidArea_7 = Box.createRigidArea(new Dimension(500, 100));
		inicioSesion.add(rigidArea_7);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBackground(Color.LIGHT_GRAY);
		verticalBox.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		inicioSesion.add(verticalBox);
		
		Component rigidArea_9 = Box.createRigidArea(new Dimension(20, 15));
		verticalBox.add(rigidArea_9);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBackground(Color.WHITE);
		verticalBox.add(horizontalBox);
		
		JLabel lblNewLabel = new JLabel("Login");
		horizontalBox.add(lblNewLabel);
		
		Component rigidArea_5 = Box.createRigidArea(new Dimension(47, 20));
		horizontalBox.add(rigidArea_5);
		
		txtUsername = new JTextField();
		horizontalBox.add(txtUsername);
		txtUsername.setColumns(10);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		horizontalBox_1.setBackground(Color.WHITE);
		verticalBox.add(horizontalBox_1);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		horizontalBox_1.add(lblNewLabel_1);
		
		Component rigidArea_6 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_6);
		
		txtPassword = new JTextField();
		txtPassword.setToolTipText("");
		horizontalBox_1.add(txtPassword);
		txtPassword.setColumns(10);
		
		Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 80));
		verticalBox.add(rigidArea_3);
		
		Box horizontalBox_2 = Box.createHorizontalBox();
		horizontalBox_2.setBackground(Color.WHITE);
		verticalBox.add(horizontalBox_2);
		
		JButton bAceptarLogin = new JButton("Aceptar");
		horizontalBox_2.add(bAceptarLogin);
		
		Component rigidArea_4 = Box.createRigidArea(new Dimension(80, 20));
		horizontalBox_2.add(rigidArea_4);
		
		JButton bCancelarLogin = new JButton("Cancelar");
		horizontalBox_2.add(bCancelarLogin);
		
		Component rigidArea_8 = Box.createRigidArea(new Dimension(100, 15));
		verticalBox.add(rigidArea_8);
		
	}
}
