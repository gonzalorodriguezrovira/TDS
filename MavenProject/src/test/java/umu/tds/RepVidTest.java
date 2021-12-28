package umu.tds;

import java.util.HashSet;

import umu.tds.clases.Etiqueta;
import umu.tds.clases.Video;
import umu.tds.repositorios.RepositorioVideo;

public class RepVidTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RepositorioVideo repo = new RepositorioVideo();
		Etiqueta pepe = new Etiqueta("a");
		System.out.println(repo.addVideo("aaa", "Paco mermela", pepe));
		System.out.println(repo.addVideo("aaa", "Paco mermela", pepe));

		System.out.println(repo.addVideo("aaaa", "mermela", pepe));
		
		HashSet<Video> v = (HashSet<Video>) repo.findVideo("merme");
		System.out.println(v.toString());

	}

}
