package controlador;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.EventObject;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import componente.ComponenteBuscadorVideos;
import componente.EventVideos;
import componente.VideosListener;
import main.Lanzador;
import modelo.Etiqueta;
import modelo.FiltroVideo;
import modelo.ListaVideos;
import modelo.RepositorioUsuario;
import modelo.RepositorioVideo;
import modelo.Usuario;
import modelo.Video;
import persistencia.DAOException;
import persistencia.FactoriaDAO;
import persistencia.IAdaptadorEtiquetaDAO;
import persistencia.IAdaptadorListaVideosDAO;
import persistencia.IAdaptadorUsuarioDAO;
import persistencia.IAdaptadorVideoDAO;
import tds.video.VideoWeb;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;


public class App implements VideosListener {
	// ATRIBUTOS
	private static App aplicacion; // Única instancia de App
	private Usuario usuarioActual; // Último usuario que ha iniciado sesión
	private FiltroVideo f; // Último filtro que ha aplicado el usuario

	private IAdaptadorUsuarioDAO adaptadorUsuario;
	private IAdaptadorVideoDAO adaptadorVideo;
	private IAdaptadorEtiquetaDAO adapatadorEtiqueta;
	private IAdaptadorListaVideosDAO adaptadorListaVideos;

	private RepositorioUsuario repositorioUsuario;
	private RepositorioVideo repositorioVideo;
	
	
	private ComponenteBuscadorVideos componenteVideo;
	

	// Para que otras clases puedan acceder a App y sus métodos
	public static App getInstancia() {
		if (aplicacion == null)
			aplicacion = new App();
		return aplicacion;
	}
	
	public static VideoWeb getVideoWeb() {
		if (Lanzador.videoWeb == null)
			Lanzador.videoWeb = new VideoWeb();
		return Lanzador.videoWeb;
	}

	// CONSTRUCTOR
	private App() {
		inicializarAdaptadores();
		inicializarRepositorios();
		
		componenteVideo = ComponenteBuscadorVideos.getUnicaInstancia();
		componenteVideo.addVideosListener(this);
		componenteVideo.setArchivoVideos("xml/video.xml");
		
	}

	// MÉTODOS PARA EL CONSTRUCTOR
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
		adapatadorEtiqueta = factoria.getEtiquetaDAO();
		adaptadorListaVideos = factoria.getListaVideosDAO();
	}
	
	// REPRODUCTOR VIDEO *   ROBERTO

	public void playVideo(Video v) { 
		
		Lanzador.videoWeb.playVideo(v.getUrl());
		adaptadorVideo.modificarVideo(v);

		usuarioActual.addRecientes(v);
		adaptadorUsuario.modificarUsuario(usuarioActual);

	}

	public void playVideo(String s) {

		Video v = findVideoURL(s);

		Lanzador.videoWeb.playVideo(v.getUrl());
		adaptadorVideo.modificarVideo(v);

		usuarioActual.addRecientes(v);
		adaptadorUsuario.modificarUsuario(usuarioActual);

	}

	public void stopVideo() {

		Lanzador.videoWeb.cancel();
	}
	

	// MÉTODOS PARA EL USUARIO ACTUAL
	
	@Override
	public void nuevosVideos(EventObject e) {
		LinkedList<Video> lista = getVideosXML(((EventVideos) e).getVideos());
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i)!=null) {
			if (repositorioVideo.addVideo(lista.get(i))) { // Intentamos registrarlo en la base local
				adaptadorVideo.addVideo(lista.get(i)); // Si hemos podido, entonces también lo introducimos en la bd.
			}
			}
		}
	}
	
	public LinkedList<Video> getVideosXML(componente.Videos videos) {
		LinkedList<Video> lista = new LinkedList<Video>();
		for (componente.Video v : videos.getVideo()) {
			Set<Etiqueta> etiquetas = new HashSet<Etiqueta>();
			for(String s : v.getEtiqueta()) {
				Etiqueta nEtiqueta = new Etiqueta(s);
				etiquetas.add(nEtiqueta);
			}
			lista.add(new Video(v.getURL(), v.getTitulo(), etiquetas));
		}
		return lista;
	}
	
	public Usuario getUsuarioActual() {
		return usuarioActual;
	}

	public void setUsuarioActual(Usuario usuarioActual) {
		this.usuarioActual = usuarioActual;
	}

	public boolean usuarioSetPremium() {
		usuarioActual.setPremium(!usuarioActual.isPremium());
		adaptadorUsuario.modificarUsuario(usuarioActual);
		return usuarioActual.isPremium();
	}

	public List<Video> obtenerRecientes() {
		return usuarioActual.getRecientes();
	}


	// MÉTODOS USUARIO
	public boolean registrarUsuario(String nombre, String apellidos, String email, String usuario, String password,
			Date nacimiento) {
		Usuario usr = new Usuario(nombre, apellidos, email, usuario, password, nacimiento);
		if (repositorioUsuario.addUsuario(usr)) {// Intentamos registrarlo en la base local
			adaptadorUsuario.addUsuario(usr);// Si hemos podido, entonces también lo introducimos en la bd.
			return true;
		}
		return false; // Si no se ha podido añadir en la local tampoco se debería poder añadir en la
						// bd.
	}

	// TODO comprobar utilidad en el proyecto fnal. si no, borrar o dejar comentado
	public boolean removeUsuario(Usuario usr) {
		adaptadorUsuario.borrarUsuario(usr);
		return repositorioUsuario.removeUsuario(usr);
	}

	public Usuario findUsuario(String user) {
		// Basta con mirar en la en el repositorio ya que se han cargado los usuarios de
		// la bd.
		return repositorioUsuario.findUsuario(user);
	}

	public boolean comprobarPassword(Usuario usuario, String password) {
		return repositorioUsuario.checkContraseña(usuario, password);
	}

	public List<ListaVideos> recuperarListasVideos() {
		return repositorioUsuario.recuperarListaVideos(usuarioActual);
	}

	public List<String> recuperarNombesListaVideos() {
		return recuperarListasVideos().stream().map((l) -> l.getName()).collect(Collectors.toList());
	}

	// MÉTODOS VIDEO
	// TODO comprobar utilidad en el proyecto fnal. si no, borrar o dejar comentado
	public List<Video> recuperarMasVistos(){
        List<Video> l = recuperarVideos();
        List<Video> lista = new LinkedList<Video>();
        l.sort((v1,v2) -> ((Integer)v2.getNumRepro()).compareTo((Integer)v1.getNumRepro()));
        if(l.size()>5) {
        for(int i = 0 ; i < 5 ; i++) lista.add(l.get(i));
        }else {
        	return l;
        }
       
        return lista;
    }
	
	
	public List<Video> recuperarVideos() {
		return repositorioVideo.recuperarVideos();
	}

	public boolean registrarVideo(String url, String titulo, Set<Etiqueta> etiquetas) {
		Video video = new Video(url, titulo, etiquetas);
		if (repositorioVideo.addVideo(video)) { // Intentamos registrarlo en la base local
			adaptadorVideo.addVideo(video); // Si hemos podido, entonces también lo introducimos en la bd.
			return true;
		}
		return false; // Si no se ha podido añadir en la local tampoco se debería poder añadir en la
						// bd.
	}

	public boolean removeVideo(Video video) {
		adaptadorVideo.borrarVideo(video);
		return repositorioVideo.removeVideo(video);
	}

	// TODO. comprobar si se usa. si no, borrar
	public Video findVideo(Video video) {
		// Basta con mirar en la en el repositorio ya que se han cargado los videos de
		// la bd.
		return repositorioVideo.findVideo(video);
	}
	
	public Video findVideoURL(String url) {
		// Basta con mirar en la en el repositorio ya que se han cargado los videos de
		// la bd.
		return repositorioVideo.findVideoURL(url);
	}

	// MÉTODOS LISTA VIDEO
	public void addListaVideo(ListaVideos lista) {
		repositorioUsuario.addListaVideo(usuarioActual, lista);
		adaptadorListaVideos.addListaVideos(lista);
		// Tras añadirle la lista modificamos las bases de datos
		// La local ya se modifica debido al aliasing
		adaptadorUsuario.modificarUsuario(usuarioActual); // Modificamos la base de datos
	}

	public ListaVideos findListaVideo(String name) {
		// Basta con buscarlo en la base de datos
		return repositorioUsuario.findListaVideo(usuarioActual, name);
	}

	// TODO COMPROBAR USO
	public void addVideoALista(ListaVideos lista, Video video) {
		// Añadimos el video a la lista del usuario actual
		repositorioUsuario.addVideoALista(usuarioActual, lista, video);
		// Actualizamos el usuario en la base de datos
		adaptadorUsuario.modificarUsuario(usuarioActual);
	}

	public void setVideosALista(ListaVideos lista) {
		ListaVideos l = findListaVideo(lista.getName());
		l.setVideos(l.getVideos());
		adaptadorListaVideos.modificarListaVideos(l);
		adaptadorUsuario.modificarUsuario(usuarioActual);
	}
	
	public void generarPDF() throws FileNotFoundException, DocumentException {
		Document doc = new Document();
		PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("AppVideo.pdf"));
	    doc.open();
	    
		List<ListaVideos> listaVideos= getUsuarioActual().getListaVideos();
		for(ListaVideos lv: listaVideos) {
			lv.generarPDF(doc);
		}
		doc.close();
	}

	// MÉTODOS ETIQUETA
	// TODO. comprobar uso. borrar si no se usa.
	public void addEtiqueta(Etiqueta e) {
		adapatadorEtiqueta.addEtiqueta(e);
	}

	public List<Etiqueta> recuperarEtiquetas() {
		return adapatadorEtiqueta.recuperarEtiquetas();
	}

	public boolean addEtiquetaAVideo(Video video, Etiqueta etiqueta) {
		if (!etiqueta.getNombre().isEmpty()) {
			video = findVideo(video);
			for(Etiqueta e : recuperarEtiquetas()) {
				if(etiqueta.getNombre().equals(e.getNombre())) {
					if(video.addEtiqueta(e)) {						
						adaptadorVideo.modificarVideo(video);
						return true;
					}
					return false;
				}
			}
			adapatadorEtiqueta.addEtiqueta(etiqueta);
			video.addEtiqueta(etiqueta);
			adaptadorVideo.modificarVideo(video);
			return true;
		}
		return false;
	}

	// MÉTODOS PARA VENTANA EXPLORAR
	public List<Video> busquedaDeVideos(String nombre, String filtro, List<String> etiquetas) {
		List<Video> l = repositorioVideo.recuperarVideos();
		l = videosPorNombre(nombre, l);
		l = videosPorEtiquetas(l, etiquetas);
		return videosFiltrados(filtro, l);
	}

	public List<Video> videosPorNombre(String nombre, List<Video> videos) {
		if (nombre.isEmpty())
			return videos;
		return videos.stream().filter(v -> v.getTitulo().contains(nombre)).collect(Collectors.toList());
	}

	public List<Video> videosFiltrados(String filtro, List<Video> videos) {
		try {
			f = (FiltroVideo) Class.forName("modelo.Filtro" + filtro).getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return videos.stream().filter(v -> f.esVideoOK(v)).collect(Collectors.toList());
	}

	public List<Video> videosPorEtiquetas(List<Video> videos, List<String> etiquetas) {
		if (etiquetas.isEmpty())
			return videos;
		List<Video> l = new LinkedList<Video>();
		for (Video v : videos) {
			Set<Etiqueta> conjuntoE = v.getEtiquetas();
			for (Etiqueta e : conjuntoE) {
				if (etiquetas.contains(e.getNombre())) {
					l.add(v);
				}
			}
		}
		return l;
	}

	public Video incrementarVisualizaciones(Video v) {
		v = findVideo(v);
		addHistorial(v);
		repositorioVideo.incrementarVisualizaciones(v);
		adaptadorVideo.modificarVideo(v);
		return v;
	}

	public void addHistorial(Video v) {
		repositorioUsuario.addHistorial(usuarioActual, findVideo(v));
		adaptadorUsuario.modificarUsuario(usuarioActual);
	}
}