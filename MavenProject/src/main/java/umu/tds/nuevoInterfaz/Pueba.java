package umu.tds.nuevoInterfaz;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.JTextField;

public class Pueba extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public Pueba() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		Box horizontalBox = Box.createHorizontalBox();
		panel.add(horizontalBox);
		
		textField = new JTextField();
		horizontalBox.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		add(textField_2);
		textField_2.setColumns(10);

	}

}
