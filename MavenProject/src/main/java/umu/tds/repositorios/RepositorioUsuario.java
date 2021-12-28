package umu.tds.repositorios;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import umu.tds.clases.ListaVideos;
import umu.tds.clases.Usuario;


public class RepositorioUsuario {
	private static final int tamDefault = 5;

	private static RepositorioUsuario unicaInstancia = new RepositorioUsuario();
	
	// ATRIBUTOS DE PRUEBA LOCALES
	private Set<Usuario> bdUser = new HashSet<Usuario>();


	public static RepositorioUsuario getUnicaInstancia() {
		return unicaInstancia;
	}

	public boolean addUsuario(String nombre, String email, int tamHistorial, String user, String password) {
		Usuario bdu = bdUser.stream()
							.filter(u -> user.equals(u.getUsuario()))
							.findAny()
							.orElse(null);
		if (bdu == null) {
			Usuario usr = new Usuario(nombre, email, tamHistorial, user, password);
			bdUser.add(usr);
		}
		return bdu == null;
	}

	public boolean addUsuario(String nombre, String email, String user, String password) {
		return this.addUsuario(nombre, email, tamDefault, user, password);
	}

	public boolean removeUsuario(Usuario usr) {
		return bdUser.remove(usr);
	}

	public Usuario findUsuario(String user) {
		return bdUser.stream()
				.filter(u -> user.equals(u.getUsuario()))
				.findAny()
				.orElse(null);
	}
	
	//TODO mirar si es correcto
	public void addListaVideo(Usuario user, ListaVideos lista) {
		user.addListaVideo(lista);
	}
	
	public List<ListaVideos> findListaVideo(Usuario user, String name){
		return user.findLista(name);
	}


}
