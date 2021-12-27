package umu.tds.clases;

import java.util.LinkedList;
import java.util.List;

public class Usuario {
	
	private static final int tamDefault = 5;
	
	private String nombre;
	private String email;
	private String usuario;
	private String password;
	private boolean premium;
	private List<ListaVideos> listaVideos;
	private List<Video> recientes;
	private int tamHistorial;
	
	public Usuario(String nombre, String email, int tamHistorial, String usuario, String password) {
		this.nombre = nombre;
		this.email = email;
		this.premium = false;
		this.listaVideos = new LinkedList<ListaVideos>();
		this.recientes = new LinkedList<Video>();
		this.tamHistorial = tamHistorial;
		this.usuario = usuario;
		this.password = password;
	}
	
	public Usuario(String nombre, String email, String usuario, String password) {
		this(nombre, email, tamDefault, usuario, password);
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public String getEmail() {
		return email;
	}
	
	@Override
	public String toString() {
		return "Clase: "+this.getClass().getName()+" - [nombre: "+nombre+"], " + "[email: "+email+"], " + "[usuario: "+usuario+"]";
	}
	
}
