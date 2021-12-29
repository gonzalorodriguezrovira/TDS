package modelo;

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

	public String getUrl() {
		return url;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getClass().getSimpleName() + " - url= [" + url +"], titulo= ["+titulo+"], numRepro= ["+numRepro+"], etiquetas= "+etiquetas;
	}

}
