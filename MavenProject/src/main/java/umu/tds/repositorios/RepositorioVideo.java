package umu.tds.repositorios;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import umu.tds.clases.Etiqueta;
import umu.tds.clases.Video;

public class RepositorioVideo {
	
	private static RepositorioVideo unicaInstancia = new RepositorioVideo();
	
	//Base de datos local
	private Set<Video> bdVideos = new HashSet<Video>();

	// CONSTRUCTOR POR DEFECTO
	
	public static RepositorioVideo getUnicaInstancia() {
		return unicaInstancia;
	}

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
	}

	public boolean removeVideo(Video video) {
		return bdVideos.remove(video);
	}
	
	public List<Video> findVideo(String palabra) {
		return bdVideos.stream()
				.filter(v -> v.getTitulo().contains(palabra))
				.collect(Collectors.toList());
			
	}
}
