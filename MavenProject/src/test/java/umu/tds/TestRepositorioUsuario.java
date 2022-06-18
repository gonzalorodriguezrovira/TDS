package umu.tds;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
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


		for (Usuario u : repositorio.getUsuarios()) {
			repositorio.removeUsuario(u);
		}

		usuarios = new LinkedList<Usuario>();

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date date = formatter.parse("26-09-1989");

		Usuario u1 = new Usuario("Paco", "Mermelada", "paco@como.es", "paquito", "1234", date);
		u1.setCodigo(1);
		usuarios.add(u1);

		Usuario u2 = new Usuario("Pepe", "Fernandez", "pepe@como.es", "pepito", "1234", date);
		u2.setCodigo(2);
		usuarios.add(u2);

		Usuario u3 = new Usuario("Jony", "Melabo", "jony@como.es", "joni", "1234", date);
		u3.setCodigo(3);
		usuarios.add(u3);
	}

	@Before
	public void iniciarRepositorio() {

		for (Usuario u : usuarios) {

			repositorio.addUsuario(u);
		}

		Collection<Usuario> repositorio2 = repositorio.getUsuarios();

		for (Usuario u : usuarios) {

			assertTrue(repositorio2.contains(u));

		}

	}

	@Test
	public void borrarUsuarios() {

		for (Usuario u : usuarios) {

			repositorio.removeUsuario(u);

		}

		Collection<Usuario> repositorio2 = repositorio.getUsuarios();

		for (Usuario u : usuarios) {

			assertFalse(repositorio2.contains(u));
		}

	}

	@Test
	public void tesListaVideos() {

		Video v1 = new Video("https://www.youtube.com/watch?v=efoTZzqOrI8&ab_channel=LaHiperactina",
				"Bebidas energeticas", new HashSet<Etiqueta>());
		
		ListaVideos l = new ListaVideos("hola");
		
		l.addVideo(v1);
		
		Usuario u1 = repositorio.findUsuario("pepito");
		
		repositorio.addListaVideo(u1, l);
		
		assertEquals(repositorio.findListaVideo(u1, "hola"), l);
		
		
	}
	
	@Test
	public void tesRecientes() {
		Video v1 = new Video("https://www.youtube.com/watch?v=efoTZzqOrI8&ab_channel=LaHiperactina",
				"Bebidas energeticas", new HashSet<Etiqueta>());
		Video v2 = new Video("https://www.youtube.com/watch?v=dUgd_dWocDY&ab_channel=DemarcoFlamenco",
				"Cancion", new HashSet<Etiqueta>());
		
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
	

}
