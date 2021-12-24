package umu.tds;

public class Usuario {
	private String nombre;
	private String email;
	private boolean premium;
	
	public Usuario(String nombre, String email) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.premium = false;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public String getEmail() {
		return email;
	}
	
}
