package umu.tds;

public class Video {

	private String url;
	private String titulo;
	private int numRepro;
	
	
	
	
	public Video(String url, String titulo) {
		this.url = url;
		this.titulo = titulo;
		this.numRepro = 0;
	}




	public int getNumRepro() {
		return numRepro;
	}

}
