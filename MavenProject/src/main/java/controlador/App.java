package controlador;

import java.util.Date;
import java.util.List;
import java.util.Set;

import modelo.Etiqueta;
import modelo.ListaVideos;
import modelo.RepositorioUsuario;
import modelo.RepositorioVideo;
import modelo.Usuario;
import modelo.Video;
import persistencia.DAOException;
import persistencia.FactoriaDAO;
import persistencia.IAdaptadorEtiquetaDAO;
import persistencia.IAdaptadorUsuarioDAO;
import persistencia.IAdaptadorVideoDAO;

public class App 
{
	private static App aplicacion;
	
	private Usuario usuarioActual;	//usuario que estamos tratando en el momento
	
	private IAdaptadorUsuarioDAO adaptadorUsuario;
	private IAdaptadorVideoDAO adaptadorVideo;
	private IAdaptadorEtiquetaDAO adapatadorEtiqueta;
//	private IAdaptadorListaVideosDAO adaptadorListaVideos;
	
	private RepositorioUsuario repositorioUsuario;
	private RepositorioVideo repositorioVideo;
	
	public static App getInstancia() {
		if(aplicacion == null)
			aplicacion = new App();
		return aplicacion;
	}
	
	private App() {
		inicializarAdaptadores();
		inicializarRepositorios();
	}
	
	private void inicializarRepositorios() {
		repositorioUsuario = RepositorioUsuario.getUnicaInstancia();
		repositorioVideo = RepositorioVideo.getUnicaInstancia();
	}
	
	private void inicializarAdaptadores() {
		FactoriaDAO factoria = null;
		try {
			factoria = FactoriaDAO.getInstancia(FactoriaDAO.DAO_TDS);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		adaptadorUsuario = factoria.getUsuarioDAO();
		adaptadorVideo = factoria.getVideoDAO();
	}
	
	public boolean registrarUsuario(String nombre, String apellidos, String email, String usuario, String password,Date nacimiento) {
		// No se controla que existan dnis duplicados
		Usuario usr= new Usuario(nombre,apellidos,email,usuario,password,nacimiento);
		//adaptadorCliente.registrarCliente(usr);
		return repositorioUsuario.addUsuario(usr);
	}
	
	public boolean registrarVideo(String url, String titulo, Set<Etiqueta> etiquetas) {
		// No se controla que existan dnis duplicados
		Video video= new Video(url,titulo,etiquetas);
		//adaptadorVideo.registrarVideo(video);
		return repositorioVideo.addVideo(video);
	}
	
	public boolean removeUsuario(Usuario usr) {
		//adaptadorUsuario.removeUsuario(usr);
		return repositorioUsuario.removeUsuario(usr);
	}
	
	public boolean removeVideo(Video video) {
		//adaptadorVideo.removeVideo(Video);
		return repositorioVideo.removeVideo(video);
	}
	// TODO Buscamos por el objeto usuario o por el nombre de este(usr)
	public Usuario findUsuario(String user) {
		//adaptadorUsuario.findUsuario(user);
		return repositorioUsuario.findUsuario(user);
	}

	public List<Video> findVideo(String palabra) {
		//adaptadorVideo.findVideo(video);
		return repositorioVideo.findVideo(palabra);
	}

	public void addListaVideo(Usuario user, ListaVideos lista) {
		repositorioUsuario.addListaVideo(user, lista);
	}
	
	public List<ListaVideos> findListaVideo(Usuario user, String name){
		return repositorioUsuario.findListaVideo(user, name);
	}

	public boolean comprobarPassword(Usuario usuario, String password) {
		return repositorioUsuario.checkContraseña(usuario, password);
	}
	
}