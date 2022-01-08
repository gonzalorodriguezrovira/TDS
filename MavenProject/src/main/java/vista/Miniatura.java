package vista;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import controlador.App;
import modelo.Video;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.Box;

public class Miniatura extends JPanel {
	
	private String url;
	private String nombre;
	
	public Miniatura(Video video, int x, int y) {
		url = video.getUrl();
		nombre = video.getTitulo();
		this.setMaximumSize(new Dimension(x,y));
        this.setPreferredSize(new Dimension(x,y));
        this.setMinimumSize(new Dimension(x,y));
        this.setBackground(Color.WHITE);
		
        JLabel lMiniatura = new JLabel();
        lMiniatura.setIcon(App.getVideoWeb().getThumb(url));
        ImageIcon i = new ImageIcon();
        i = App.getVideoWeb().getThumb(url);
        lMiniatura.setMaximumSize(new Dimension(x-10,y-10));
        lMiniatura.setPreferredSize(new Dimension(x-10,y-10));
        lMiniatura.setMinimumSize(new Dimension(x-10,y-10)); 
        lMiniatura.setBorder(new LineBorder(Color.BLACK,2));
        
        JLabel Titulo = new JLabel();
        Titulo.setText(nombre);
        Titulo.setMaximumSize(new Dimension(x,10));
        Titulo.setPreferredSize(new Dimension(x,10));
        Titulo.setMinimumSize(new Dimension(x,10)); 
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        this.add(lMiniatura);
        this.add(Titulo);
        
        Box horizontalBox = Box.createHorizontalBox();
        horizontalBox.add(lMiniatura);
        add(horizontalBox);
        Box horizontalBox1 = Box.createHorizontalBox();
        horizontalBox1.add(Titulo);
        add(horizontalBox1);
        
	}
	
	public String getUrl() {
		return url;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Miniatura otro = (Miniatura) obj;
		
		return otro.getUrl().equals(url);
		
	}
	
}
