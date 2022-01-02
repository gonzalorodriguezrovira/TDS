package modelo;

import java.util.LinkedList;
import java.util.List;

public class ListaVideos {
	
	private int codigo;
	private String name;
	private List<Video> videos;
	
	//TODO mirar si está bien
	public ListaVideos(String name, List<Video> videos) {
		this.name = name;
		this.videos = new LinkedList<Video>(videos);
	}
	
	public ListaVideos(String name) {
		this(name, new LinkedList<Video>());
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getClass().getSimpleName() + " - name=["+name+"], videos="+videos.toString()+"";
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public List<Video> getVideos() {
		return videos;
	}
	
	private void addVideo(Video v) {
		videos.add(0,v);
	}
	
}
