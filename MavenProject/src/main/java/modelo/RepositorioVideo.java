package modelo;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import controlador.App;

public class RepositorioVideo {
	
	private static RepositorioVideo unicaInstancia = new RepositorioVideo();
	
	//Base de datos local
	private List<Video> bdVideos = new LinkedList<Video>();

	public RepositorioVideo() {
		bdVideos = App.getInstancia().cargarVideos();
	}
	
	public static RepositorioVideo getUnicaInstancia() {
		return unicaInstancia;
	}
/*
	public boolean addVideo(String url, String titulo,Etiqueta... etiquetas) {
		Video bdu = bdVideos.stream()
							.filter(u -> url.equals(u.getUrl()))
							.findAny()
							.orElse(null);
		if (bdu == null) {
			Video video = new Video(url, titulo, etiquetas);
			bdVideos.add(video);
		}
		return bdu == null;
	}*/
	
	public boolean addVideo(Video video) {
		Video bdu = bdVideos.stream()
							.filter(u -> video.getUrl().equals(u.getUrl()))
							.findAny()
							.orElse(null);
		if (bdu == null) {
			bdVideos.add(video);
		}
		return bdu == null;
	}

	public boolean removeVideo(Video video) {
		return bdVideos.remove(video);
	}
	
	public List<Video> findVideo(String palabra) {
		return bdVideos.stream()
				.filter(v -> v.getTitulo().contains(palabra))
				.collect(Collectors.toList());
			
	}
	
	public List<Video> recuperarVideos(){
		return bdVideos;
	}
}
