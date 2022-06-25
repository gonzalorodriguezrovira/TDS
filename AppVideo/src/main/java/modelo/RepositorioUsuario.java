package modelo;

import java.util.ArrayList;
import java.util.List;

import persistencia.DAOException;
import persistencia.FactoriaDAO;
import persistencia.IAdaptadorUsuarioDAO;

public class RepositorioUsuario {
	// ATRIBUTOS
	private static RepositorioUsuario unicaInstancia = new RepositorioUsuario();
	private List<Usuario> bdUser; // Donde almacenamos localmente a los usuario

	private FactoriaDAO dao;
	private IAdaptadorUsuarioDAO adaptadorUsuario;

	// CONSTRUCTOR
	public RepositorioUsuario() {
		bdUser = new ArrayList<Usuario>();
		try {
			dao = FactoriaDAO.getInstancia(FactoriaDAO.DAO_TDS);
			adaptadorUsuario = dao.getUsuarioDAO();
			this.cargarUsuarios();
		} catch (DAOException eDAO) {
			eDAO.printStackTrace();
		}
	}

	// CARGADOR
	
	public void cargarUsuarios() {
		List<Usuario> userBD = adaptadorUsuario.recuperarUsuarios();
		for (Usuario user : userBD)
			bdUser.add(user);
	}

	// MÉTODOS
	
	public static RepositorioUsuario getUnicaInstancia() {
		return unicaInstancia;
	}

	public Usuario findUsuario(String user) {
		
		return bdUser.stream().filter(u -> user.equals(u.getUsuario())).findAny().orElse(null);
	}

	public boolean addUsuario(Usuario user) {
		Usuario bdu = findUsuario(user.getUsuario());
		if (bdu == null) {
			adaptadorUsuario.addUsuario(user); 
			bdUser.add(user); 
		}
		return bdu == null; 
	}
	
	public boolean removeUsuario(Usuario usr) {
		adaptadorUsuario.borrarUsuario(usr);
		return bdUser.remove(usr);
	}

	public void addListaVideo(Usuario user, ListaVideos lista) {
		user.addListaVideo(lista);
	}

	public ListaVideos findListaVideo(Usuario user, String name) {
		return user.findLista(name);
	}

	public boolean checkContraseña(Usuario usuario, String password) {
		return usuario.checkContraseña(password);
	}

	public List<ListaVideos> recuperarListaVideos(Usuario user) {
		return user.getListaVideos();
	}

	public void addHistorial(Usuario u, Video v) {
		u.addRecientes(v);
	}

	public List<Usuario> getUsuarios() {
		return bdUser;
	}

}
