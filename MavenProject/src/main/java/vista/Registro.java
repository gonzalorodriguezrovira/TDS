package vista;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import com.toedter.calendar.JDateChooser;

import controlador.App;

import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;
import java.awt.Color;
import com.jgoodies.looks.plastic.PlasticComboBoxUI;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.Date;

public class Registro extends JPanel {

	/**
	 * Create the panel.
	 */
	JPanel pRegistro = new JPanel();
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtEmail;
	private JTextField txtUsuario;
	private JTextField txtContraseña;
	private JTextField txtRepContraseña;
	private JDateChooser dateFechaNa = null;

	public Registro(AppVideo v) {
		setBackground(Color.GRAY);
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		Box verticalBox = Box.createVerticalBox();
		add(verticalBox);

		Component rigidArea = Box.createRigidArea(new Dimension(350, 60));
		verticalBox.add(rigidArea);

		Box horizontalBox = Box.createHorizontalBox();
		verticalBox.add(horizontalBox);

		Component rigidArea_2_4 = Box.createRigidArea(new Dimension(67, 20));
		horizontalBox.add(rigidArea_2_4);

		JLabel lblNewLabel = new JLabel("*Nombre: ");
		lblNewLabel.setForeground(Color.WHITE);
		horizontalBox.add(lblNewLabel);

		txtNombre = new JTextField();
		horizontalBox.add(txtNombre);
		txtNombre.setColumns(10);

		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 5));
		verticalBox.add(rigidArea_1);

		Box horizontalBox_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1);

		Component rigidArea_2_4_2 = Box.createRigidArea(new Dimension(65, 20));
		horizontalBox_1.add(rigidArea_2_4_2);

		JLabel lblNewLabel_1 = new JLabel("Apellidos: ");
		lblNewLabel_1.setForeground(Color.WHITE);
		horizontalBox_1.add(lblNewLabel_1);

		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		horizontalBox_1.add(txtApellidos);

		Component rigidArea_1_1 = Box.createRigidArea(new Dimension(200, 5));
		verticalBox.add(rigidArea_1_1);

		Box horizontalBox_1_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1_1);

		JLabel lblNewLabel_1_1 = new JLabel("*Fecha de nacimiento: ");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		horizontalBox_1_1.add(lblNewLabel_1_1);

		 dateFechaNa = new JDateChooser();
		horizontalBox_1_1.add(dateFechaNa);

		Component rigidArea_2_4_1 = Box.createRigidArea(new Dimension(50, 20));
		horizontalBox_1_1.add(rigidArea_2_4_1);

		Component rigidArea_1_1_1 = Box.createRigidArea(new Dimension(200, 5));
		verticalBox.add(rigidArea_1_1_1);

		Box horizontalBox_1_2 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1_2);

		Component rigidArea_2_4_2_1 = Box.createRigidArea(new Dimension(86, 20));
		horizontalBox_1_2.add(rigidArea_2_4_2_1);

		JLabel lblNewLabel_1_2 = new JLabel("email: ");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		horizontalBox_1_2.add(lblNewLabel_1_2);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		horizontalBox_1_2.add(txtEmail);

		Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 25));
		verticalBox.add(rigidArea_3);

		Box horizontalBox_1_1_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1_1_1);

		Component rigidArea_2_1 = Box.createRigidArea(new Dimension(68, 20));
		horizontalBox_1_1_1.add(rigidArea_2_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("*Usuario: ");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		horizontalBox_1_1_1.add(lblNewLabel_1_1_1);

		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		horizontalBox_1_1_1.add(txtUsuario);

		Component rigidArea_2_4_2_1_3 = Box.createRigidArea(new Dimension(55, 20));
		horizontalBox_1_1_1.add(rigidArea_2_4_2_1_3);

		Component rigidArea_1_2 = Box.createRigidArea(new Dimension(20, 5));
		verticalBox.add(rigidArea_1_2);

		Box horizontalBox_1_1_2 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1_1_2);

		Component rigidArea_2_2 = Box.createRigidArea(new Dimension(45, 20));
		horizontalBox_1_1_2.add(rigidArea_2_2);

		JLabel lblNewLabel_1_1_2 = new JLabel("*Contraseña: ");
		lblNewLabel_1_1_2.setForeground(Color.WHITE);
		horizontalBox_1_1_2.add(lblNewLabel_1_1_2);

		txtContraseña = new JTextField();
		txtContraseña.setColumns(10);
		horizontalBox_1_1_2.add(txtContraseña);

		Component rigidArea_2_4_2_1_2 = Box.createRigidArea(new Dimension(55, 20));
		horizontalBox_1_1_2.add(rigidArea_2_4_2_1_2);

		Component rigidArea_1_3 = Box.createRigidArea(new Dimension(20, 5));
		verticalBox.add(rigidArea_1_3);

		Box horizontalBox_1_1_3 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1_1_3);

		Component rigidArea_2_3 = Box.createRigidArea(new Dimension(2, 20));
		horizontalBox_1_1_3.add(rigidArea_2_3);

		JLabel lblNewLabel_1_1_3 = new JLabel("*Repetir contraseña\r\n: ");
		lblNewLabel_1_1_3.setForeground(Color.WHITE);
		horizontalBox_1_1_3.add(lblNewLabel_1_1_3);

		txtRepContraseña = new JTextField();
		txtRepContraseña.setColumns(10);
		horizontalBox_1_1_3.add(txtRepContraseña);

		Component rigidArea_2_4_2_1_1 = Box.createRigidArea(new Dimension(55, 20));
		horizontalBox_1_1_3.add(rigidArea_2_4_2_1_1);

		Component rigidArea_3_1 = Box.createRigidArea(new Dimension(20, 22));
		verticalBox.add(rigidArea_3_1);

		Box horizontalBox_2 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2);

		Component rigidArea_4 = Box.createRigidArea(new Dimension(50, 20));
		horizontalBox_2.add(rigidArea_4);

		JButton bRegistrar = new JButton("Registrar");
		horizontalBox_2.add(bRegistrar);

		Component rigidArea_4_1 = Box.createRigidArea(new Dimension(50, 20));
		horizontalBox_2.add(rigidArea_4_1);

		JButton bCancelar = new JButton("Cancelar");
		horizontalBox_2.add(bCancelar);

		Component rigidArea_3_2 = Box.createRigidArea(new Dimension(20, 25));
		verticalBox.add(rigidArea_3_2);

		Box horizontalBox_3 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_3);

		Component rigidArea_5_1 = Box.createRigidArea(new Dimension(50, 20));
		horizontalBox_3.add(rigidArea_5_1);

		JLabel lblNewLabel_2 = new JLabel("*Campos obligatorios");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		horizontalBox_3.add(lblNewLabel_2);

		Component rigidArea_5 = Box.createRigidArea(new Dimension(100, 20));
		horizontalBox_3.add(rigidArea_5);
		pRegistro.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		CardLayout c = (CardLayout) (AppVideo.vDisplay.getLayout());
		bCancelar.addActionListener(ev -> c.show(AppVideo.vDisplay, AppVideo.BRUH));

		bRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre = txtNombre.getText();
				String password = txtContraseña.getText().trim();
				String passwordRep = txtRepContraseña.getText().trim();
				String email = txtEmail.getText().trim();
				String apellidos = txtApellidos.getText();
				String usuario= txtUsuario.getText().trim();
				Date nacimiento= dateFechaNa.getDate();

				if(!nombre.isEmpty()) {
					if(nacimiento != null) {
						if(!usuario.isEmpty()&& App.getInstancia().findUsuario(usuario)==null) {
							if(!password.isEmpty()) {
								if(passwordRep.equals(password)) {
									txtApellidos.setText("");
									txtContraseña.setText("");
									txtEmail.setText("");
									txtNombre.setText("");
									txtRepContraseña.setText("");
									txtUsuario.setText("");
									dateFechaNa.setCalendar(null);
									v.registrarUsuario(nombre, email, usuario, passwordRep,nacimiento);
								}else {
									//TODO popup consataseñas no cinciden
								}
							}else {
								//popup contraseña vacio
							}
						}else {
							//popup usuario no valido
						}
					}else {
						//popup fecha vacia
					}
				}else {
					//popup nombre vacio
				}


			}
		});
	}
	/*
	 * private static void addPopup(Component component, final JPopupMenu popup) {
	 * component.addMouseListener(new MouseAdapter() { public void
	 * mousePressed(MouseEvent e) { if (e.isPopupTrigger()) { showMenu(e); } }
	 * 
	 * public void mouseReleased(MouseEvent e) { if (e.isPopupTrigger()) {
	 * showMenu(e); } }
	 * 
	 * private void showMenu(MouseEvent e) { popup.show(e.getComponent(), e.getX(),
	 * e.getY()); } }); }
	 */
}
