package umu.tds;

import java.util.HashSet;

import umu.tds.clases.Etiqueta;
import umu.tds.clases.Video;
import umu.tds.repositorios.RepositorioVideos;

public class RepVidTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RepositorioVideos repo = new RepositorioVideos();
		Etiqueta pepe = new Etiqueta();
		System.out.println(repo.addVideo("aaa", "Paco mermela", pepe));
		System.out.println(repo.addVideo("aaa", "Paco mermela", pepe));

		System.out.println(repo.addVideo("aaaa", "mermela", pepe));
		
		HashSet<Video> v = (HashSet<Video>) repo.findUsuario("merme");
		System.out.println(v.toString());

	}

}
