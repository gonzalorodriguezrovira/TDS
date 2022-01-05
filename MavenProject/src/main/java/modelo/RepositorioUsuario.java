package modelo;

import java.util.ArrayList;
import java.util.List;

import persistencia.DAOException;
import persistencia.FactoriaDAO;
import persistencia.IAdaptadorUsuarioDAO;

public class RepositorioUsuario {
	// ATRIBUTOS
	private static RepositorioUsuario unicaInstancia = new RepositorioUsuario();
	private List<Usuario> bdUser; 		// Donde almacenamos localmente a los usuario

	private FactoriaDAO dao;
	private IAdaptadorUsuarioDAO adaptadorUsuario;

	//CONSTRUCTOR
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

	//CARGADOR
	//Para que el constructor pueda añadir a la base local los usuario de la base de datos
	public void cargarUsuarios() {
		List<Usuario> userBD = adaptadorUsuario.recuperarUsuarios();
		for (Usuario user : userBD)
			bdUser.add(user);
	}
	
	//MÉTODOS
	//Para que otras clases puedan acceder a este positorio y sus métodos
	public static RepositorioUsuario getUnicaInstancia() {
		return unicaInstancia;
	}
	
	public Usuario findUsuario(String user) {
		//Buscamos localmente y devolvemos el usuario o nulo en caso de no estar registrado
		return bdUser.stream().filter(u -> user.equals(u.getUsuario())).findAny().orElse(null);
	}

	public boolean addUsuario(Usuario user) {
		Usuario bdu = findUsuario(user.getUsuario());
		if (bdu == null) {
			adaptadorUsuario.addUsuario(user);	//Guardamos en la base de datos
			bdUser.add(user);					//Guardamos localmente
		}
		return bdu == null;						//Devolvemos si se ha podido o no añadir
	}

	public boolean removeUsuario(Usuario usr) {
		//Borramos de la base de datos y localmente
		adaptadorUsuario.borrarUsuario(usr);
		return bdUser.remove(usr);
	}

	public void addListaVideo(Usuario user, ListaVideos lista) {
		user.addListaVideo(lista);
	}
	
	public ListaVideos findListaVideo(Usuario user, String name) {
		return user.findLista(name);
	}
	
	public void addVideoALista(Usuario user, ListaVideos lista, Video video) {
		user.addVideoALista(lista, video);
	}

	public boolean checkContraseña(Usuario usuario, String password) {
		return usuario.checkContraseña(password);
	}

}
