package modelo;

import java.util.LinkedList;
import java.util.List;

public class ListaVideos {
	//ATRIBUTOS
	private int codigo;
	private String name;
	private List<Video> videos;
	
	//CONSTRUCTOR
	public ListaVideos(String name, List<Video> videos) {
		this.name = name;
		this.videos = videos;
	}
	
	//CONSTRUCTOR
	public ListaVideos(String name) {
		this(name, new LinkedList<Video>());
	}
	
	//GETTERS Y SETTERS
	public String getName() {
		return name;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public List<Video> getVideos() {
		return videos;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setVideos(List<Video> lista) {
		videos = lista;
		
	}	

	//MÉTODOS
	public void addVideo(Video v) {
		if (!videos.contains(v))
			videos.add(0,v);
	}
	
	public void removeVideo(Video v) {
		videos.remove(v);
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + " - name=["+name+"], videos="+videos.toString()+"";
	}

}
