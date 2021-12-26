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
	
	public PantallaLogin(){
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setBackground(Color.GRAY);
		setForeground(Color.BLACK);
		setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(164, 140, 122, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(164, 97, 122, 20);
		textField_1.setColumns(10);
		add(textField_1);
		
		JLabel lblNewLabel = new JLabel("Login:");
		lblNewLabel.setBounds(122, 100, 29, 14);
		lblNewLabel.setForeground(Color.WHITE);
		add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(104, 143, 50, 14);
		lblPassword.setForeground(Color.WHITE);
		add(lblPassword);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(89, 181, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(273, 181, 89, 23);
		add(btnNewButton_1);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalStrut_1.setBounds(361, 192, 89, 1);
		add(horizontalStrut_1);
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		rigidArea.setBounds(0, 192, 89, 1);
		add(rigidArea);
		
	}
}
