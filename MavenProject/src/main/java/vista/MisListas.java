package vista;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;

public class MisListas extends JPanel {

	/**
	 * Create the panel.
	 */
	public MisListas() {
		setBackground(Color.GRAY);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(0, 11, 184, 394);
		add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JLabel lblNewLabel = new JLabel("  Seleccione la lista: ");
		lblNewLabel.setForeground(Color.WHITE);
		panel.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setMaximumRowCount(19);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"}));
		panel.add(comboBox);
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 350));
		panel.add(rigidArea);
		
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
		
		JLabel lblNewLabel_1 = new JLabel("seguramente haya que hacer otro cardlayout y cuando se haga click en uno de los videos ponerlo en pantalla. Posible reutilización de los videos en explorar");
		panel_2.add(lblNewLabel_1);
		
		CardLayout c = (CardLayout)(AppVideo.vDisplay.getLayout());
		//bCancelarML.addActionListener(ev -> c.show(AppVideo.vDisplay, AppVideo.INICIO_SESION));
		/*
		bCancelarML.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout)(AppVideo.vDisplay.getLayout());
				c.show(AppVideo.vDisplay, AppVideo.BRUH);
			}
		});
		*/
	}
}
