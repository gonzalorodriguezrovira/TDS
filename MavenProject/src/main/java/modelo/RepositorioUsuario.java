package modelo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class RepositorioUsuario {
	private static final int tamDefault = 5;

	private static RepositorioUsuario unicaInstancia = new RepositorioUsuario();
	
	// ATRIBUTOS DE PRUEBA LOCALES
	private Set<Usuario> bdUser = new HashSet<Usuario>();


	public static RepositorioUsuario getUnicaInstancia() {
		return unicaInstancia;
	}
	/*
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
	}*/
	
	public Usuario findUsuario(String user) {
		return bdUser.stream()
				.filter(u -> user.equals(u.getUsuario()))
				.findAny()
				.orElse(null);
	}
	
	public boolean addUsuario(Usuario user) {
		Usuario bdu = findUsuario(user.getUsuario());
		if (bdu == null) {
			bdUser.add(user);
		}
		return bdu == null;
	}

	public boolean removeUsuario(Usuario usr) {
		return bdUser.remove(usr);
	}

	
	
	//TODO mirar si es correcto
	public void addListaVideo(Usuario user, ListaVideos lista) {
		user.addListaVideo(lista);
	}
	
	public List<ListaVideos> findListaVideo(Usuario user, String name){
		return user.findLista(name);
	}


}
