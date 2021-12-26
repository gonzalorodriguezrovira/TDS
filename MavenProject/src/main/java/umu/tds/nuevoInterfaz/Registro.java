package umu.tds.nuevoInterfaz;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Registro extends JPanel {

	/**
	 * Create the panel.
	 */
	public Registro() {
		JButton bCancelarRegistro = new JButton("Cancelar");
		add(bCancelarRegistro);
		
		bCancelarRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout)(AppVideo.vDisplay.getLayout());
				c.show(AppVideo.vDisplay, AppVideo.BRUH);
			}
		});
		
	}

}
