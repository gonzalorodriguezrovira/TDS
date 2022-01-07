package modelo;

import java.util.ArrayList;
import java.util.List;

import persistencia.DAOException;
import persistencia.FactoriaDAO;
import persistencia.IAdaptadorVideoDAO;

public class RepositorioVideo {
	//ATRIBUTOS
	private static RepositorioVideo unicaInstancia = new RepositorioVideo();
	private List<Video> bdVideos;	// Donde almacenamos localmente a los usuario

	private FactoriaDAO dao;
	private IAdaptadorVideoDAO adaptadorVideo;
	
	//CONSTRUCTOR
	public RepositorioVideo() {
		bdVideos = new ArrayList<Video>();
		try {
			dao = FactoriaDAO.getInstancia(FactoriaDAO.DAO_TDS);
			adaptadorVideo = dao.getVideoDAO();
			this.cargarVideos();
		} catch (DAOException eDAO) {
			eDAO.printStackTrace();
		}
	}
	
	//CARGADOR
	//Para que el constructor pueda añadir a la base local los videos de la base de datos
	public void cargarVideos() {
		List<Video> videos = adaptadorVideo.recuperarVideos();
		for (Video video : videos)
			bdVideos.add(video);
	}
	
	//MÉTODOS
	//Para que otras clases puedan acceder a este positorio y sus métodos
	public static RepositorioVideo getUnicaInstancia() {
		return unicaInstancia;
	}

	//TODO comprobar uso. Borrar si no se usa.
	public Video findVideo(Video video) {
		//Hacemos una busqueda local 
		return bdVideos.stream()
				.filter(v -> v.getUrl().contains(video.getUrl()))
				.findAny()
				.orElse(null);
	}
	
	public Video findVideoURL(String url) {
		//Hacemos una busqueda local 
		return bdVideos.stream()
				.filter(v -> v.getUrl().contains(url))
				.findAny()
				.orElse(null);
	}
	
	public boolean addVideo(Video video) {
		Video bdu = findVideo(video);			//Comprobamos que el video no está ya añadido
		if (bdu == null) {
			bdVideos.add(video);				//Guardamos localmente
			adaptadorVideo.addVideo(video);		//Guardamos en la base de datos
		}
		return bdu == null;						//Devolvemos si se ha podido o no añadir
	}
	
	public boolean removeVideo(Video video) {
		//Borramos de la base de datos y localmente
		adaptadorVideo.borrarVideo(video);
		return bdVideos.remove(video);
	}
	
	public List<Video> recuperarVideos(){
		//Devolvemos la base de datos entera
		return bdVideos;
	}

	public void incrementarVisualizaciones(Video v) {
		v.setNumRepro(v.getNumRepro()+1);
	}
}
