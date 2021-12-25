package umu.tds.interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.Box;
import java.awt.Component;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JTabbedPane;
import javax.swing.border.BevelBorder;
import javax.swing.JInternalFrame;
import javax.swing.JToolBar;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import java.awt.Font;

public class AppVideo {

	private JFrame frmAppvideo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppVideo window = new AppVideo();
					window.frmAppvideo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppVideo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAppvideo = new JFrame();
		frmAppvideo.setTitle("AppVideo");
		frmAppvideo.setBounds(100, 100, 652, 534);
		frmAppvideo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAppvideo.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frmAppvideo.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel = new JLabel("AppVideo");
		lblNewLabel.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 14));
		lblNewLabel.setIcon(new ImageIcon(AppVideo.class.getResource("/junit/runner/smalllogo.gif")));
		panel.add(lblNewLabel);
		
		Component rigidArea = Box.createRigidArea(new Dimension(50, 20));
		panel.add(rigidArea);
		
		JButton btnNewButton = new JButton("New button");
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		panel.add(btnNewButton_1);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		panel.add(rigidArea_1);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		frmAppvideo.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel explorar = new JPanel();
		tabbedPane.addTab("Explorar", null, explorar, null);
		
		JPanel misListas = new JPanel();
		tabbedPane.addTab("Mis Listas", null, misListas, null);
		
		JPanel recientes = new JPanel();
		tabbedPane.addTab("Recientes", null, recientes, null);
		
		JPanel nuevasListas = new JPanel();
		tabbedPane.addTab("Nuevas Listas", null, nuevasListas, null);
	}
}
