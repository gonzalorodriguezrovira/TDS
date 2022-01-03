package modelo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import persistencia.DAOException;
import persistencia.FactoriaDAO;
import persistencia.IAdaptadorUsuarioDAO;

public class RepositorioUsuario {
	// private static final int tamDefault = 5;

	private static RepositorioUsuario unicaInstancia = new RepositorioUsuario();

	// ATRIBUTOS DE PRUEBA LOCALES
	private Set<Usuario> bdUser;

	public static RepositorioUsuario getUnicaInstancia() {
		return unicaInstancia;
	}

	private FactoriaDAO dao;
	private IAdaptadorUsuarioDAO adaptadorUsuario;

	public RepositorioUsuario() {
		try {
			dao = FactoriaDAO.getInstancia(FactoriaDAO.DAO_TDS);
			adaptadorUsuario = dao.getUsuarioDAO();
			bdUser = new HashSet<>();
			this.cargarUsuarios();
		} catch (DAOException eDAO) {
			eDAO.printStackTrace();
		}
	}

	public Usuario findUsuario(String user) {
		return bdUser.stream().filter(u -> user.equals(u.getUsuario())).findAny().orElse(null);
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

	public void cargarUsuarios() {
		List<Usuario> userBD = adaptadorUsuario.recuperarUsuarios();
		for (Usuario user : userBD)
			bdUser.add(user);
	}

	// TODO mirar si es correcto
	public void addListaVideo(Usuario user, ListaVideos lista) {
		user.addListaVideo(lista);
	}

	public List<ListaVideos> findListaVideo(Usuario user, String name) {
		return user.findLista(name);
	}

	public boolean checkContraseña(Usuario usuario, String password) {
		return usuario.checkContraseña(password);
	}

}
