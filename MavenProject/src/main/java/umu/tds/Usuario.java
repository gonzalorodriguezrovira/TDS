package umu.tds;

import java.util.LinkedList;
import java.util.List;

public class Usuario {
	
	private static final int tamDefault = 5;
	
	private String nombre;
	private String email;
	private boolean premium;
	private List<ListaVideos> listaVideos;
	private List<Video> recientes;
	private int tamHistorial;
	
	public Usuario(String nombre, String email, int tamHistorial) {
		this.nombre = nombre;
		this.email = email;
		this.premium = false;
		this.listaVideos = new LinkedList<ListaVideos>();
		this.recientes = new LinkedList<Video>();
		this.tamHistorial = tamHistorial;
	}
	
	public Usuario(String nombre, String email) {
		this.nombre = nombre;
		this.email = email;
		this.premium = false;
		this.listaVideos = new LinkedList<ListaVideos>();
		this.recientes = new LinkedList<Video>();
		this.tamHistorial = tamDefault;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getEmail() {
		return email;
	}
	
}
