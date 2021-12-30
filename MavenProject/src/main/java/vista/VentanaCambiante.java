package vista;

import java.awt.CardLayout;
import java.awt.GridBagConstraints;

import javax.swing.JPanel;

public class VentanaCambiante extends JPanel {

	final static String INICIO_SESION = "Inicio de sesion";
	final static String BRUH = "borrame cuando tengas ventana de inicio";
	final static String REGISTRO = "Registro de usuario";
	final static String EXPLORAR = "Explorar videos";
	final static String MIS_LISTAS = "Buscar en las listas de usuario";
	
	static GridBagConstraints gbc_vDisplay = new GridBagConstraints();
	
	InicioSesion pIS;
	PantallaBase pPB;
	Registro pR;
	Explorar pE;
	MisListas pML;
	
	public VentanaCambiante() {
	
		setLayout(new CardLayout(0, 0));

		gbc_vDisplay.fill = GridBagConstraints.BOTH;
		gbc_vDisplay.gridx = 0;
		gbc_vDisplay.gridy = 2;		
		
		
		add(pR, "REGISTRO");
		add(pE, "EXPLORAR");
		add(pML, "MIS_LISTAS");
		add(pPB, "BRUH");
		add(pIS, "INICIO_SESION");
		
	}


	public void changeV(String inicioSesion) {
		((CardLayout) this.getLayout()).show(this,INICIO_SESION);
	}

}
