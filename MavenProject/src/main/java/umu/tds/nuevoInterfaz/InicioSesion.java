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

public class InicioSesion extends JPanel {
	private JTextField txtUsername;
	private JTextField txtPassword;

	public InicioSesion() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBackground(Color.LIGHT_GRAY);
		verticalBox.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		this.add(verticalBox);

		Component rigidArea_2_IS = Box.createRigidArea(new Dimension(20, 15));
		verticalBox.add(rigidArea_2_IS);

		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBackground(Color.WHITE);
		verticalBox.add(horizontalBox);

		JLabel lblNewLabel = new JLabel("Login");
		horizontalBox.add(lblNewLabel);

		Component rigidArea_3_IS = Box.createRigidArea(new Dimension(41, 20));
		horizontalBox.add(rigidArea_3_IS);

		txtUsername = new JTextField();
		horizontalBox.add(txtUsername);
		txtUsername.setColumns(10);

		Box horizontalBox_1 = Box.createHorizontalBox();
		horizontalBox_1.setBackground(Color.WHITE);
		verticalBox.add(horizontalBox_1);

		JLabel lblNewLabel_1 = new JLabel("Password");
		horizontalBox_1.add(lblNewLabel_1);

		Component rigidArea_4_IS = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_4_IS);

		txtPassword = new JTextField();
		txtPassword.setToolTipText("");
		horizontalBox_1.add(txtPassword);
		txtPassword.setColumns(10);

		Component rigidArea_5_IS = Box.createRigidArea(new Dimension(20, 80));
		verticalBox.add(rigidArea_5_IS);

		Box horizontalBox_2 = Box.createHorizontalBox();
		horizontalBox_2.setBackground(Color.WHITE);
		verticalBox.add(horizontalBox_2);

		JButton bAceptarLogin = new JButton("Aceptar");
		horizontalBox_2.add(bAceptarLogin);

		Component rigidArea_6_IS = Box.createRigidArea(new Dimension(80, 20));
		horizontalBox_2.add(rigidArea_6_IS);

		JButton bCancelarLogin = new JButton("Cancelar");
		horizontalBox_2.add(bCancelarLogin);

		Component rigidArea_7_IS = Box.createRigidArea(new Dimension(20, 15));
		verticalBox.add(rigidArea_7_IS);
		
		bCancelarLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout)(AppVideo.vDisplay.getLayout());
				c.show(AppVideo.vDisplay, AppVideo.BRUH);
			}
		});
		
	}
}
