package umu.tds.clases;

import java.util.HashSet;
import java.util.Set;

public class Video {

	private String url;
	private String titulo;
	private int numRepro;
	private Set<Etiqueta> etiquetas;

	public Video(String url, String titulo, Etiqueta... etiquetas) {
		this.url = url;
		this.titulo = titulo;
		this.numRepro = 0;
		this.etiquetas = new HashSet<Etiqueta>();
		for (Etiqueta etiq : etiquetas) {
			this.etiquetas.add(etiq);
		}
	}

	public int getNumRepro() {
		return numRepro;
	}

}
