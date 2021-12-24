package umu.tds.clases;

import java.util.LinkedList;
import java.util.List;

public class ListaVideos {

	private String name;
	private List<Video> videos;

	public ListaVideos(String name) {
		this.name = name;
		this.videos = new LinkedList<Video>();
	}

	public String getName() {
		return name;
	}

}
