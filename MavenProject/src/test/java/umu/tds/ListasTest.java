package umu.tds;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import umu.tds.clases.Etiqueta;
import umu.tds.clases.ListaVideos;
import umu.tds.clases.Usuario;
import umu.tds.clases.Video;
import umu.tds.repositorios.RepositorioUsuario;
import umu.tds.repositorios.RepositorioVideo;

public class ListasTest {
	public static void main(String[] args) {
		RepositorioVideo repoV = new RepositorioVideo();
		RepositorioUsuario repoU = new RepositorioUsuario();		
		
		repoV.addVideo("vid1", "vid1", new Etiqueta("et1"));
		repoV.addVideo("vid2", "vid2", new Etiqueta("et1"));
//		repoV.addVideo("vid3", "vid3", new Etiqueta("et1"), new Etiqueta("et3"));
//		repoV.addVideo("vid4", "vid4", new Etiqueta("et1"), new Etiqueta("et2"));
		
		repoU.addUsuario("juan", "juanemail", "juanito", "hola");
		
		
		Usuario user = repoU.findUsuario("juanito");
		
		//ESTA LISTA LA CREARIAMOS EN REPOSITORIO VIDEOS? O DIRECTAMENTE EN APP VIDEO?
		List<Video> pfing = repoV.findVideo("vid");
		List<Video> ppfing= repoV.findVideo("1");
		
		ListaVideos miLista = new ListaVideos("miLista",pfing);
		ListaVideos otra = new ListaVideos("otra",ppfing);
		repoU.addListaVideo(user, miLista);
		repoU.addListaVideo(user, otra);
		
		System.out.println(user.findLista("miLista"));
		
		
	}	
}
