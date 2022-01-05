package modelo;


import java.util.Set;

public class Video {
	//ATRIBUTOS
	private int codigo;
	private String url;
	private String titulo;
	private int numRepro;
	private Set<Etiqueta> etiquetas;

	//CONSTRUCTOR
	public Video(String url, String titulo, Set<Etiqueta> etiquetas) {
		this.url = url;
		this.titulo = titulo;
		this.numRepro = 0;
		this.etiquetas = etiquetas;

	}
	
	//GETTERS Y SETTERS
	public int getNumRepro() {
		return numRepro;
	}

	public String getUrl() {
		return url;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	//TODO CLONE
	public Set<Etiqueta> getEtiquetas() {
		return etiquetas;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public void setNumRepro(int numRepro) {
		this.numRepro = numRepro;
	}
	
	//MÉTODOS
	public void addEtiqueta(Etiqueta e) {
		etiquetas.add(e);
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + " - url= [" + url +"], titulo= ["+titulo+"], numRepro= ["+numRepro+"], etiquetas= "+etiquetas;
	}
}
