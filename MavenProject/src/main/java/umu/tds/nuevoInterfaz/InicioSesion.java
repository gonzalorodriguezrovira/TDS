package umu.tds.nuevoInterfaz;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.border.LineBorder;

public class InicioSesion extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	public InicioSesion() {
		setBackground(Color.GRAY);
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		Box verticalBox_1 = Box.createVerticalBox();
		add(verticalBox_1);
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 60));
		verticalBox_1.add(rigidArea);
		
		Box verticalBox_2 = Box.createVerticalBox();
		verticalBox_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		verticalBox_2.setBackground(Color.GRAY);
		verticalBox_1.add(verticalBox_2);
		
		Component rigidArea_2_IS = Box.createRigidArea(new Dimension(20, 30));
		verticalBox_2.add(rigidArea_2_IS);
		
		Box horizontalBox_3 = Box.createHorizontalBox();
		horizontalBox_3.setBackground(Color.WHITE);
		verticalBox_2.add(horizontalBox_3);
		
		Component rigidArea_1_1 = Box.createRigidArea(new Dimension(41, 20));
		horizontalBox_3.add(rigidArea_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Login: ");
		lblNewLabel_2.setForeground(Color.WHITE);
		horizontalBox_3.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		horizontalBox_3.add(textField);
		
		Component rigidArea_1_1_4 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3.add(rigidArea_1_1_4);
		
		Component rigidArea_1_2 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_2.add(rigidArea_1_2);
		
		Box horizontalBox_1_1 = Box.createHorizontalBox();
		horizontalBox_1_1.setBackground(Color.WHITE);
		verticalBox_2.add(horizontalBox_1_1);
		
		Component rigidArea_1_1_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1_1.add(rigidArea_1_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password: ");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		horizontalBox_1_1.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("");
		textField_1.setColumns(10);
		horizontalBox_1_1.add(textField_1);
		
		Component rigidArea_1_1_5 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1_1.add(rigidArea_1_1_5);
		
		Component rigidArea_5_IS_1 = Box.createRigidArea(new Dimension(20, 80));
		verticalBox_2.add(rigidArea_5_IS_1);
		
		Box horizontalBox_2_1 = Box.createHorizontalBox();
		horizontalBox_2_1.setBackground(Color.WHITE);
		verticalBox_2.add(horizontalBox_2_1);
		
		Component rigidArea_1_1_3 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_1.add(rigidArea_1_1_3);
		
		JButton bAceptarLogin_1 = new JButton("Aceptar");
		horizontalBox_2_1.add(bAceptarLogin_1);
		
		Component rigidArea_6_IS_1 = Box.createRigidArea(new Dimension(80, 20));
		horizontalBox_2_1.add(rigidArea_6_IS_1);
		
		JButton bCancelarLogin_1 = new JButton("Cancelar");
		horizontalBox_2_1.add(bCancelarLogin_1);
		
		Component rigidArea_1_1_2 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_1.add(rigidArea_1_1_2);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_2.add(rigidArea_1);
		
		bCancelarLogin_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout)(AppVideo.vDisplay.getLayout());
				c.show(AppVideo.vDisplay, AppVideo.BRUH);
			}
		});
		
	}
}
