package umu.tds;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import controlador.App;
import modelo.Etiqueta;
import modelo.Usuario;
import modelo.Video;

public class Pruebalistas {

	public static void main(String[] args) {
		HashSet<Etiqueta> hola = new HashSet<Etiqueta>() ;
		hola.add(new Etiqueta("musica"));
		Video v1 = new Video("url1","video1", hola);
//		App.getInstancia().addReciente(App.getInstancia().findUsuario("a"),App.getInstancia().findVideo(v1));
//		System.out.println(App.getInstancia().findUsuario("a").getRecientes());
//		App.getInstancia().addEtiqueta(new Etiqueta("Ayuda"));
//		Video v1 = new Video("aaaa","nn1", hola);
//		Video v2 = new Video("aa","n2", new HashSet<Etiqueta>());
//		System.out.println(App.getInstancia().registrarVideo("url4","video4", hola));
//  App.getInstancia().registrarVideo("url5","vid5", hola);
//		List<Video> l1 = new LinkedList<Video>();
//		l1.add(v1);
//		l1.add(v2);
//		List<Video> l2 = new LinkedList<Video>();
//		l2.addAll(l1);
//		l2.addAll(l2);
//		System.out.println(l2.size());
//		System.out.println(l2.get(1));
		
		
		
	}

}
