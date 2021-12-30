package modelo;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Usuario {

	private static final int tamDefault = 5;

	private String nombre;
	private String email;
	private String usuario;
	private String password;
	private Date nacimiento;
	private boolean premium;
	private List<ListaVideos> listaVideos;
	private List<Video> recientes;
	private int tamHistorial;

	public Usuario(String nombre, String email, int tamHistorial, String usuario, String password,Date nacimiento) {
		this.nombre = nombre;
		this.email = email;
		this.premium = false;
		this.listaVideos = new LinkedList<ListaVideos>();
		this.recientes = new LinkedList<Video>();
		this.tamHistorial = tamHistorial;
		this.usuario = usuario;
		this.password = password;
		this.nacimiento = nacimiento;
	}

	public Usuario(String nombre, String email, String usuario, String password,Date nacimiento) {
		this(nombre, email, tamDefault, usuario, password,nacimiento);
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

	// TODO mirar si es correcto
	public void addListaVideo(ListaVideos lista) {
		listaVideos.add(lista);
	}

	public List<ListaVideos> findLista(String name) {
		return listaVideos.stream().filter(l -> l.getName().contains(name)).collect(Collectors.toList());
	}

	public void addRecientes(Video video) {
		Video aux = recientes.stream()
				.filter(v -> v.getUrl().equals(video.getUrl()))
				.findAny()
				.orElse(null);
		if(aux == null) {
			recientes.add(0, video);
			if(recientes.size() > tamHistorial)
				recientes.remove(tamHistorial);
		}
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + " - nombre= [" + nombre + "], " + "email= [" + email + "], "
				+ "premium= [" + premium + "], " + "listaVideos= " + listaVideos + ", " + "recientes= " + recientes
				+ ", " + "tamHistorial= [" + tamHistorial + "], " + "usuario= [" + usuario + "]";
	}

	public boolean checkContraseña(String password) {
		return this.password.equals(password);
	}

}
