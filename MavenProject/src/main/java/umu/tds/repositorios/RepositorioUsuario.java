package umu.tds.repositorios;

import java.util.HashSet;
import java.util.Set;

import umu.tds.clases.Usuario;

public class RepositorioUsuario {
	private static final int tamDefault = 5;

	// ATRIBUTOS DE PRUEBA LOCALES
	private Set<Usuario> bdUser = new HashSet<Usuario>();

	// CONSTRUCTOR POR DEFECTO

	public boolean addUsuario(String nombre, String email, int tamHistorial, String usuario, String password) {
		Usuario bdu = bdUser.stream()
							.filter(u -> usuario.equals(u.getUsuario()))
							.findAny()
							.orElse(null);
		if (bdu == null) {
			Usuario usr = new Usuario(nombre, email, tamHistorial, usuario, password);
			bdUser.add(usr);
		}
		return bdu == null;
	}

	public boolean addUsuario(String nombre, String email, String usuario, String password) {
		return this.addUsuario(nombre, email, tamDefault, usuario, password);
	}

	public boolean removeUsuario(Usuario usr) {
		return bdUser.remove(usr);
	}

	public Usuario findUsuario(String usuario) {
		return bdUser.stream()
				.filter(u -> usuario.equals(u.getUsuario()))
				.findAny()
				.orElse(null);
	}

}
