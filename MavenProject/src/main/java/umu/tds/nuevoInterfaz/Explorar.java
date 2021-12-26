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

public class Explorar extends JPanel {

	/**
	 * Create the panel.
	 */
	public Explorar() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(65, 0, 10, 81);
		add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(109, 200, 27, 46);
		add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(260, 143, 33, 56);
		add(panel_2);
	}
}
