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

public class Explorar extends JPanel {

	/**
	 * Create the panel.
	 */
	public Explorar() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 463, 367);
		add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.add(panel_2);
		
		JPanel pEtiquetas = new JPanel();
		pEtiquetas.setBounds(483, 17, 34, 314);
		pEtiquetas.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		add(pEtiquetas);
	}
}
