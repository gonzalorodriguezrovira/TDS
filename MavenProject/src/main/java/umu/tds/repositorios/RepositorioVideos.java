package umu.tds.repositorios;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import umu.tds.clases.Etiqueta;
import umu.tds.clases.Video;

public class RepositorioVideos {
	private Set<Video> bdVideos = new HashSet<Video>();

	// CONSTRUCTOR POR DEFECTO

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

	public boolean removeUsuario(Video video) {
		return bdVideos.remove(video);
	}

	public Set<Video> findUsuario(String palabra) {
		return bdVideos.stream()
				.filter(v -> v.getTitulo().contains(palabra))
				.collect(Collectors.toSet());
			
	}
}
