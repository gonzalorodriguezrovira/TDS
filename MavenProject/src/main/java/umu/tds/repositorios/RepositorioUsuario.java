package umu.tds.repositorios;

import umu.tds.clases.Usuario;

public class RepositorioUsuario {
	//CONSTRUCTOR POR DEFECTO
	
	//TODO REVISAR TIPO DE RETORNO
	public void addUsuario(String nombre, String email) { 		//TODO checkear si hay que añadir la contraseña
		Usuario usuario = new Usuario(nombre, email);
	}

	public void removeUsuario(String nombre) {					//TODO contraseña para eliminar?
		
	}
	
	/*public Usuario findUsuario(String nombre) {
		
	}*/
	
}
