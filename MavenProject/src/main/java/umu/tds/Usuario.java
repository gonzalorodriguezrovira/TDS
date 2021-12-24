package umu.tds;

import java.util.LinkedList;
import java.util.List;

public class Usuario {
	private String nombre;
	private String email;
	private boolean premium;
	private List<ListaVideos> listaVideos; 
	
	public Usuario(String nombre, String email) {
		this.nombre = nombre;
		this.email = email;
		this.premium = false;
		this.listaVideos = new LinkedList<ListaVideos>();
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public String getEmail() {
		return email;
	}
	
}
