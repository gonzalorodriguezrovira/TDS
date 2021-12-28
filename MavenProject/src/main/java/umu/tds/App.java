package umu.tds;

import umu.tds.repositorios.RepositorioUsuario;
import umu.tds.repositorios.RepositorioVideo;

public class App 
{
	private static App aplicacion = null;
	
	private RepositorioUsuario repositorioUsuario;
	private RepositorioVideo repositorioVideo;
	
	public static App getInstancia() {
		if(aplicacion == null)
			aplicacion = new App();
		return aplicacion;
	}
	
	private App() {
		inicializarRepositorios();
	}
	
	private void inicializarRepositorios() {
		repositorioUsuario = RepositorioUsuario.getUnicaInstancia();
		repositorioVideo= RepositorioVideo.getUnicaInstancia();
	}
	
}