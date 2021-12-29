package umu.tds;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import controlador.App;
import modelo.Etiqueta;
import modelo.ListaVideos;
import modelo.Usuario;
import modelo.Video;

public class Test {
	public static void main(String[] args) {
		App app = App.getInstancia();
		app.registrarUsuario("Juan", "juanemail", "Juanito", "123", LocalDate.now());
		app.registrarUsuario("Lara", "laraemail", "larita", "123", LocalDate.now());
		app.registrarVideo("1", "vid1", new Etiqueta("nombre"));
		app.registrarVideo("2", "vid2", new Etiqueta("nombre"));
		app.registrarVideo("3", "vid3", new Etiqueta("nombre"));
		app.registrarVideo("4", "vid1", new Etiqueta("nombre"));
		
		Usuario usr = app.findUsuario("Juanito");
		
		System.out.println(usr);
		
		List<Video> ll = app.findVideo("vid");
		
		
		ListaVideos l = new ListaVideos("gonzalomarica", ll);
		
		app.addListaVideo(usr, l);

		System.out.println(l);
		
		System.out.println(app.findListaVideo(usr, "gonzalomarica"));
		
	}
}
