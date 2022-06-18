package umu.tds;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



import modelo.Etiqueta;
import modelo.ListaVideos;
import modelo.RepositorioUsuario;
import modelo.Usuario;
import modelo.Video;

public class TestRepositorioUsuario {

	private static RepositorioUsuario repositorio;
	private static LinkedList<Usuario> usuarios;

	@BeforeClass
	public static void setUpBefore() throws ParseException {

		repositorio = RepositorioUsuario.getUnicaInstancia();

		ArrayList<Usuario> aux = (ArrayList<Usuario>) repositorio.getUsuarios();
		
		for(int i = 0; i < aux.size(); i++) {
			repositorio.removeUsuario(aux.get(i));
		}
				
		usuarios = new LinkedList<Usuario>();
			
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

		Usuario u1 = new Usuario("Paco", "Mermelada", "paco@como.es", "paquito", "1234", formatter.parse("26-09-1989"));
		usuarios.add(u1);

		Usuario u2 = new Usuario("Pepe", "Fernandez", "pepe@como.es", "pepito", "1234", formatter.parse("26-09-1989"));
		usuarios.add(u2);

		Usuario u3 = new Usuario("Jony", "Melabo", "jony@como.es", "joni", "1234", formatter.parse("26-09-1989"));
		usuarios.add(u3);
		
	}

	@Before
	public void iniciarRepositorio() {
		for (Usuario u : usuarios) {

			repositorio.addUsuario(u);
			
		}

		for (Usuario u : usuarios) {
			
			assertTrue(repositorio.findUsuario(u.getUsuario()) != null);

		}

	}

	@Test
	public void tesListaVideos() {

		HashSet<Etiqueta> etiquetas = new HashSet<Etiqueta>();
		etiquetas.add(new Etiqueta("Video"));
		
		Video v1 = new Video("https://youtu.be/P3hSmSNMFEg",
				"Bebidas energeticas", etiquetas);
		
		ListaVideos l = new ListaVideos("hola");
		
		l.addVideo(v1);
		
		Usuario u1 = repositorio.findUsuario("pepito");
		
		repositorio.addListaVideo(u1, l);
		
		assertTrue(repositorio.findListaVideo(u1, "hola") != null);
		
		for (Video v : repositorio.findListaVideo(u1, "hola").getVideos())
			assertTrue(l.getVideos().contains(v));
	}

	@Test
	public void tesRecientes() {
		HashSet<Etiqueta> etiquetas = new HashSet<Etiqueta>();
		etiquetas.add(new Etiqueta("Video"));
		Video v1 = new Video("https://youtu.be/LuNnGxeqLKQ",
				"Bebidas energeticas", etiquetas);
		Video v2 = new Video("https://youtu.be/R0krUthYxF4",
				"Cancion", etiquetas);
		
		Usuario u1 = repositorio.findUsuario("pepito");
		
		LinkedList<Video> videos= new LinkedList<Video>();
		videos.add(v1);
		videos.add(v2);
		
		for(Video v: videos) {
			repositorio.addHistorial(u1, v);
		}
		
		for(Video v: videos) {
			assertTrue(u1.getRecientes().contains(v));
		}
		
	}
	
	@Test
	public void borrarUsuarios() {

		for (Usuario u : usuarios) {

			repositorio.removeUsuario(repositorio.findUsuario(u.getUsuario()));

		}

		Collection<Usuario> repositorio2 = repositorio.getUsuarios();

		for (Usuario u : usuarios) {

			assertFalse(repositorio2.contains(u));
		}

	}
	

}
